#KRX POC
빌드 방법
./build.sh -t ${BUILD_TYPE}

이 클 립 스 구 동 방 법

spring boot -> run configuration
Arguments 탭, VM arguments 항목에 아래의 내용 추가. 
-Dspring.profiles.active=development

h2 접 속 방 법

localhost:8081/h2-console
접속 후 
Saved Settings : Generic MySQL로 변경 후
JDBC URL : jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MODE=MYSQL
User Name : blocko
Password: blocko

#TEST방법
#현재 테스트 해보시면 전문의 orderType에 따라 매수,매도요청을하도록
#확인해보실 수 있습니다.

포스트맨을 통해서 테스트 해볼 수 있도록 추가해놓았습니다.
krx.controller.rest
 - HomeController.java

TEST:
 - postman을 통해서 get방식으로 아래와 같이 호출하시면 됩니다.

 ex) /send/{id}
    {id} : orderBook 테이블에 들어가 있는 데이터를 기준으로 orderNum값을 넣으시면 됩니다.
    => localhost:8081/send/99e67076-1b47-4da4-a49e-af0127dc4e46

krx.kafka
 - KafkaConsumer.java
 => 현재 krxhome에서 자체 테스트 할 수 있도록 각 기관별
 리스너를 샘플로 달아놓았습니다.
