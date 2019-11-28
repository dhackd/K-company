
declare -x INSTALL_TYPE='local'
declare -x SILENT=0
declare -x TEND_TO_PROCESS=0

################################################################################
# Ensure to use apt-get
function ensure-aptitude() {
  which apt-get &>/dev/null && sudo apt-get update -y >/dev/null
  return $?
}
################################################################################
# Ensure to use yum
function ensure-yum() {
  which yum &>/dev/null && sudo yum update -y >/dev/null
  return $?
}

################################################################################
# Check an existence of unzip, or exit
function ensure-unzip() {
  message-on "Checking unzip..."
  which unzip &>/dev/null
  if [ "$?" -ne 0 ]; then
    warning "FAIL"
    if [ -t 1 ]; then
      if [ "$SILENT" == 0 ]; then
        message "Installer needs unzip but you don't have it. Could you permit to install unzip before progress? (Y/n)"
        read ANSWER
        shopt -s nocasematch
        case "${ANSWER,,}" in
          ""|"y"|"yes")
            INSTALL_UNZIP=1
            ;;
          "n"|"no")
            INSTALL_UNZIP=0
            error "The installation is stopped by user"
            ;;
          *)
            error "Your answer is not understood. Stop the installation"
            ;;
        esac
      else # [ "$SILENT" == 0 ]
        INSTALL_UNZIP=$TEND_TO_PROCESS
      fi # [ "$SILENT" == 0 ]
    else
      INSTALL_UNZIP=$TEND_TO_PROCESS
    fi
    if [ $INSTALL_UNZIP == 0 ]; then
      error "Installation is failed because unzip doesn't exist. Install unzip and retry."
    else
      message-on 'Installing unzip...'
      (ensure-aptitude && sudo apt-get install -y unzip $APT_OPTS) || (ensure-yum && sudo yum install -y unzip $YUM_OPTS)
      if [ "$?" -ne 0 ]; then
        debug "COMMAND: (ensure-aptitude && sudo apt-get install -y unzip $APT_OPTS) || (ensure-yum && sudo yum install -y unzip $YUM_OPTS)"
        error "Fail to install unzip!! Check your package manager."
      fi
      success 'OK'
    fi
  else
    success "OK"
  fi # [ "$?" -ne 0 ]
}
function ensure-install-type() {
  case "$1" in
    "local" | "system" | "service")
      success "Installation type: $1"
      ;;
    *)
      error "Unknown installation type: $1"
      ;;
  esac
}

################################################################################
# Install locally
function install-local() {
  ensure-unzip

  message-on "Unarchiving to $TARGET..."
  echo $TARGET
  echo $0
  unzip -o -d $TARGET $0 &>/dev/null
  success "OK"
}

################################################################################
# Install locally
function install-system() {
  install-local
  # Make link
  pushd $TARGET >/dev/null
  TARGET_PATH=`pwd`
  popd >/dev/null
  ln -s $KRX_HOME /usr/share/coinstack
  ln -s $KRX_HOME/bin/coinstack-cli /usr/bin/coinstack-cli

  echo 'export USER_KRX_HOME=$HOME/.coinstack.d' > /etc/profile.d/coinstack.sh
}

################################################################################
# Install as service
function install-service() {
  install-system || error "Fail to install to system!"
  echo 'export USER_KRX_HOME=$HOME/.coinstack.d' > /etc/profile.d/coinstack.sh
  ln -s $KRX_HOME/conf /etc/coinstack
  cp $KRX_HOME/doc/template/coinstack.service /etc/init.d/coinstack
  chmod 755 /etc/init.d/coinstack
  which chkconfig && chkconfig --add coinstack
  which update-rc.d && update-rc.d coinstack defaults && update-rc.d coinstack enable
  service coinstack start
}

################################################################################
function print-banner() {
  if [ `tput cols` -le 162 ]; then
    print-small-banner
  else
    print-big-banner
  fi

  # horizontal separator
  echo ""
}

################################################################################
# Main process

if [ -z "$TARGET" ]; then
  case "$INSTALL_TYPE" in
    "local")
      TARGET=`pwd`
      ;;
    "system" | "service")
      TARGET=/usr/share
      ;;
    *)
      error "Unknown installation type: $1"
      ;;
  esac
fi
export TARGET
export KRX_HOME="$TARGET/krxpoc-home-dlt-$VERSION"

if [ "$SILENT" == 1 ]; then
  APT_OPTS="-q"
  YUM_OPTS="-q"
fi

print-banner

ensure-install-type $INSTALL_TYPE

install-$INSTALL_TYPE

if [ `tput cols` -le 162 ]; then
  cat $KRX_HOME/doc/welcome-install-small.txt
else
  cat $KRX_HOME/doc/welcome-install-big.txt
fi

success "Success to install the Krx Poc!!"
echo ""

# Don't remove next statement
# It makes the separation with zip part
exit 0
