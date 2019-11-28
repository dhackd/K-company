#!/bin/bash
# resolve links - $0 may be a softlink
if [ -z "$PROJECT_HOME" ];then
  PRG="$0"
  while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
      PRG="$link"
    else
      PRG=`dirname "$PRG"`/"$link"
    fi
  done

  cd $(dirname $PRG)
  export PROJECT_HOME=`pwd`
  cd -&>/dev/null
fi

###############################################################################
#Build Type

function help () {
  echo "  -t : build type (default dlt)"
}

while getopts "t:h" FLAG; do
  case $FLAG in
    t) BUILD_OPT=$OPTARG ;;
    h|*) help ; exit 1 ;;
  esac
done

################################################################################
# Print color
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

################################################################################
# Definition
VERSION=$(grep ' version ' $PROJECT_HOME/build.gradle | cut -d"'" -f2)
BUILD_WORKSPACE=$PROJECT_HOME/build

APP_NAME=krxpoc-home
BUILD_TYPE=${BUILD_OPT:-"dlt"}
APP_FULLNAME="krxpoc-home-$BUILD_TYPE-$VERSION"
INSTALLER_NAME="$APP_FULLNAME-installer.bin"

if [ -z "$VERSION" ]; then
  echo "The version not detected. Check build script or environment."
  exit 1
fi

###############################################################################
# Banner
BIG_BANNER_FUNC=$(cat <<EOF
function print-big-banner() {
  cat <<EOF1
    `cat $PROJECT_HOME/$APP_NAME-assembly/src/big-logo.txt`
EOF1
}
EOF
)

SMALL_BANNER_FUNC=$(cat <<EOF
function print-small-banner() {
  cat <<EOF1
    `cat $PROJECT_HOME/$APP_NAME-assembly/src/small-logo.txt`
EOF1
}
EOF
)

################################################################################
#Setup by type
function setup-by-type() {
  if [ "$BUILD_TYPE" == "legacy" ]; then
    printf "${GREEN}build by legacy${NC}\n"
    setup-legacy
    setup-common
  elif [ "$BUILD_TYPE" == "dlt" ]; then
    printf "${GREEN}build by dlt${NC}\n"
    setup-dlt
    setup-common
  else
    printf "${RED}unknown type\n"
    exit 1;
  fi
}

################################################################################
#setup legacy
function setup-legacy() {
  #setup build
  sed 's/_buildType_/legacy/; s/_buildName_/legacy/' $PROJECT_HOME/template/gradleTemplate >> $PROJECT_HOME/template/build.gradle
  mv $PROJECT_HOME/template/build.gradle $PROJECT_HOME/$APP_NAME-assembly

  #setup common
  sed 's/_launcher_/krx.exec.HomeLegacyLauncher/; s/_profiles_/legacy/' $PROJECT_HOME/template/krx-common-template >> $PROJECT_HOME/template/krx-common
  mv $PROJECT_HOME/template/krx-common $PROJECT_HOME/$APP_NAME-assembly/src/assembly/bin
}

################################################################################
#setup dlt
function setup-dlt() {
  #setup build
  sed 's/_buildType_/server/; s/_buildName_/dlt/' $PROJECT_HOME/template/gradleTemplate >> $PROJECT_HOME/template/build.gradle
  mv $PROJECT_HOME/template/build.gradle $PROJECT_HOME/$APP_NAME-assembly

  #setup common
  sed 's/_launcher_/krx.exec.HomeKafkaLauncher/; s/_profiles_/dlt/' $PROJECT_HOME/template/krx-common-template >> $PROJECT_HOME/template/krx-common
  mv $PROJECT_HOME/template/krx-common $PROJECT_HOME/$APP_NAME-assembly/src/assembly/bin
}

################################################################################
#setup common
function setup-common() {
  #setup profiles
  rm $PROJECT_HOME/$APP_NAME-assembly/src/assembly/conf/*.yaml
  cp $PROJECT_HOME/template/application-$BUILD_TYPE.yaml $PROJECT_HOME/$APP_NAME-assembly/src/assembly/conf

  #setup build name
  sed s/_name_/$BUILD_TYPE/ $PROJECT_HOME/template/installer-template >> $PROJECT_HOME/template/installer.sh
  mv $PROJECT_HOME/template/installer.sh $PROJECT_HOME/$APP_NAME-assembly/src/installer
}

################################################################################

# Inject a file contaianing version information
function inject-version() {
  TARGET_DIR=$1
  cat <<EOF >$TARGET_DIR/VERSION
$VERSION
EOF
}

################################################################################
# Copy test script files to a target directory
function inject-testscripts() {
  TARGET_DIR=$1
  mkdir "$TARGET_DIR/lib/test"
  cp -R "$PROJECT_HOME/$APP_NAME-test/function-test/" "$TARGET_DIR/lib/test/function-test"
}

################################################################################
# Download open source licenses
function rake-licenses() {
  LICENSE_XML=$1
  TARGET_DIR=$2
  LICENSE_URLS=`cat $LICENSE_XML |grep '<license' |grep 'url=' | sed -E "s/(.*url=')|('>)//g" | sed -E "s/\/$//g" | sort | uniq`
  mkdir -p $TARGET_DIR
  cd $TARGET_DIR
  for LICENSE_URL in $LICENSE_URLS
  do
    echo "Downloading $LICENSE_URL..."
    curl -sJLO $LICENSE_URL
  done
  cd - >/dev/null
}

################################################################################
# Build
setup-by-type

echo "Version: $VERSION"

echo "Building java modules..."
cd $PROJECT_HOME
$PROJECT_HOME/gradlew clean build distZip || exit 1 #downloadLicenses

echo "Unarchiving assembly..."
cd $PROJECT_HOME/$APP_NAME-assembly/build/distributions
unzip -q "$PROJECT_HOME/$APP_NAME-assembly/build/distributions/$APP_FULLNAME.zip"
inject-version "$PROJECT_HOME/$APP_NAME-assembly/build/distributions/$APP_FULLNAME"

# echo "Build docker image..."
# cd $PROJECT_HOME/$APP_NAME-assembly
# which docker
# DOCKER_EXIST="$?"
# if [ 0 -eq $DOCKER_EXIST ]; then
#   docker build -t $APP_NAME:$VERSION .
#   DOCKER_RUN="$?"
#   if [ 0 -ne $DOCKER_RUN ]; then
#     sudo service docker start
#     docker build -t $APP_NAME:$VERSION .
#   fi
# else
#   sudo yum install -y docker-ce
#   docker build -t $APP_NAME:$VERSION .
#   DOCKER_RUN="$?"
#   if [ 0 -ne $DOCKER_RUN ]; then
#     sudo service docker start
#     docker build -t $APP_NAME:$VERSION .
#   fi
# fi

echo "Reassembling..."
rm -rf $BUILD_WORKSPACE
mkdir $BUILD_WORKSPACE
cd $PROJECT_HOME/$APP_NAME-assembly/build/distributions
unzip -q $APP_FULLNAME.zip -d $BUILD_WORKSPACE
inject-version $BUILD_WORKSPACE/$APP_FULLNAME
# inject-testscripts $BUILD_WORKSPACE/$APP_FULLNAME
#rake-licenses $PROJECT_HOME/$APP_NAME-assembly/build/reports/license/license-dependency.xml $BUILD_WORKSPACE/$APP_FULLNAME/doc/license
#cp $PROJECT_HOME/$APP_NAME-assembly/build/reports/license/* $BUILD_WORKSPACE/$APP_FULLNAME/doc/license

cd $BUILD_WORKSPACE
tar -czf ${APP_FULLNAME}.tar.gz $APP_FULLNAME
( which zip || sudo yum install -y zip ) &&  zip -r ${APP_FULLNAME}.zip $APP_FULLNAME
rm -rf $APP_FULLNAME

cat <<EOF | cat - $PROJECT_HOME/$APP_NAME-assembly/src/assembly/bin/krx-common $PROJECT_HOME/$APP_NAME-assembly/src/installer/installer.sh $BUILD_WORKSPACE/${APP_FULLNAME}.zip > $BUILD_WORKSPACE/$INSTALLER_NAME
#!/bin/bash
$BIG_BANNER_FUNC
$SMALL_BANNER_FUNC
declare -x VERSION=$VERSION
EOF
chmod 755 $BUILD_WORKSPACE/$INSTALLER_NAME
