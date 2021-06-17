<h3> 2021-1-OSSP2-ttogttagis-3</h3>
<h1> 동국대 입학처 챗봇- 아코봇 & 관리자 페이지 프로젝트</h1> 
<br> 
<ul style="list-style:none;">
    <li><a href="#sec_target1" style="text-decoration:none;"><b>I. 아코봇 설명부로 이동</b></a></li>
    <li><a href="#sec_target2" style="text-decoration:none;">II. <b>관리자 페이지 설명부로 이동</b></a></li>
    <br>
    <li><a href="https://github.com/CSID-DGU/2021-1-OSSP2-ttogttagis-3/blob/main/README_ENG.md">Redirect for English Speakers</a> </li> 
</ul>
<br> 
<h3> 팀 구성</h3> 

* 2019112059 이가영 (팀장)

* 2017112071 김응관

* 2018110504 박지원

* 2013111989 이학진

* 2017112095 최준호

<br> 
<div class="sec1">
    <a name="sec_target1"></a>
    <h2>I. 아코봇</h2>
</div>


### 목표

> 챗봇은 사용자와의 대화를 통해 입시정보 데이터를 제공한다. 챗봇이 이해하지 못하는 질문은 미해결 질문 게시판 링크를 제공하여 관리자가 직접 사용자에게 답변을 할 수 있도록 한다.

---

  &nbsp;`개발 환경` : ![Springboot](http://img.shields.io/badge/-Dialogflow-FF9800?style=flat&logo=Dialogflow)

  &nbsp;`데이터베이스` : ![Springboot](http://img.shields.io/badge/-CloudFirestore-FFCA28?style=flat&logo=Firebase)


---

### 1. 질문 흐름도 구상

<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/11707490/122390118-98cf9e80-cfac-11eb-82a4-9097dc190872.png"></p>



### 2. 챗봇 완성 모습

- 텍스트 정보 제공
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/11707490/122399761-0f24ce80-cfb6-11eb-9d28-78157b0d5b24.png"></p>

- 이미지 링크 제공
<p align="center"><img height="60%" width="60%" alt="이미지 링크 제공" src="https://user-images.githubusercontent.com/11707490/122399790-151aaf80-cfb6-11eb-8d18-386f03aed27f.png"></p>

- 미해결 질문 게시판 링크 제공
<p align="center"><img height="60%" width="60%" alt="미해결 질문 게시판 링크" src="https://user-images.githubusercontent.com/11707490/122399808-1815a000-cfb6-11eb-98f8-e94aab0f2b26.png"></p>





<br>



<div class="sec1">
    <a name="sec_target2"></a>
    <h2>II. 관리자 페이지</h2>
</div>



### 목표

> IT 산업에 종사하거나 코딩을 배우지 않은 대학교 입학처 관계자도 챗봇을 운영하면서 생기는 미해결 질문, 질문 답변 및 알림, 데이터베이스 수정 등의 업무를 할 수 있게 하는 웹 어플리케이션 개발
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122449417-c9c9c680-cfe0-11eb-8681-014f52b0feff.png" height="60%" width="60%"><br> 관리자 페이지 전체 구성도</p>

---
  &nbsp;`개발 언어` : ![JAVA](http://img.shields.io/badge/-Java11-006cb7?style=flat&logo=Java) & ![JAVA](http://img.shields.io/badge/-Javascript-006cb7?style=flat&logo=Javascript)

  &nbsp;`개발 환경` :  ![Springboot](http://img.shields.io/badge/-Springboot2.4.5-000000?style=flat&logo=springboot) & ![Springboot](http://img.shields.io/badge/-Gradle6.8.3-006cb7?style=flat&logo=gradle)

  &nbsp;`화면 처리 탬플릿` : ![Springboot](http://img.shields.io/badge/-Thymeleaf-005F0F?style=flat&logo=Thymeleaf)

  &nbsp;`데이터베이스` : ![Springboot](http://img.shields.io/badge/-CloudFirestore-FFCA28?style=flat&logo=Firebase) & ![Springboot](http://img.shields.io/badge/-H2-0000FF?style=flat&logo=RDBMS)

  &nbsp;`통합 개발 환경` :  ![Springboot](http://img.shields.io/badge/-IntelliJ-000000?style=flat&logo=IntelliJIDEA)

  &nbsp;`배포 가능한 운영체제` : ![Springboot](http://img.shields.io/badge/-Windows10-006cb7?style=flat&logo=windows) &  ![Springboot](http://img.shields.io/badge/-MacOS-006cb7?style=flat&logo=macOS) & ![Springboot](http://img.shields.io/badge/-LINUX-006cb7?style=flat&logo=Linux)

---

### 1. 오픈 소스 활용

#####   빠르고 손쉬우며 안정성 있는 개발 오픈소스 사용

&nbsp;&nbsp;![Springboot](http://img.shields.io/badge/-BootStrap-006cb7?style=flat&logo=BootStrap) & ![Springboot](http://img.shields.io/badge/-JUnit5-006cb7?style=flat&logo=JUnit5) & ![Springboot](http://img.shields.io/badge/-DevTools-FFCA28?style=flat)  & ![Springboot](http://img.shields.io/badge/-SpringMVC-005F0F?&nbsp;&nbsp;style=flat&logo=Spring)

#####   보안성과 편리함을 챙기는 로그인 기능 구현을 위한 오픈소스 사용

&nbsp;&nbsp;![Springboot](http://img.shields.io/badge/-JPA-FFCA28?style=flat&logo=Firebase&link=본인주소) & ![Springboot](http://img.shields.io/badge/-SpringSecurity-FFCA28?style=flat&logo=Firebase&link=본인주소)


<br>
<h3> 2. 해당 프로젝트 설치 방법 </h3>
<h4> A. 통합개발환경, IntelliJ 에서 해당 프로젝트 설치하기 </h4>

1. 인텔리제이 IDE를 설치한다.

> https://www.jetbrains.com/idea/download

2. IntelliJ 설치후 IntelliJ 의 설정을 다음과 같이 설정한다.

   - (1) IntelliJ 상단 `Setting`> `Build,Execution,Deployment` > `Gradle` 에 접근하여, 

   - (2) `Build and run using` , `Run tests using` 의 드롭박스의 값을 `IntelliJ IDEA` 로 바꿔주십시오. (기본 설정이 `Gradle`인데 느리다고 합니다.)


<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122431795-bcf0a700-cfcf-11eb-8a29-0898eed6ea1d.png" height="60%" width="60%"></p>



3. IntelliJ 상단 메뉴에서
- (1) `File`> `Project Structure`>`Project`에서
- (2) `Project SDK`의 선택지 중 ` Java 11`을 설정해주셔야 합니다. 별도의 다운이 필요 없는 ` Amazon Correto 11.0.10`를 설정하거나 또는 자바11를 설치합니다.

<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122431904-cf6ae080-cfcf-11eb-92cc-6eeae906fed8.png" height="60%" width="60%"></p>

4. 깃허브에 있는 프로젝트를 로컬 레파지토리로 복사하기 위해,

   (1) 인텔리제이 상단  `File` 탭을 누른다. 

   (2) `Project from Version Contrl...`를 누른다
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122432254-21ac0180-cfd0-11eb-86d1-54ec1b2d724f.png" height="60%" width="60%"></p>


​	(3)  저희 오픈소스 프로젝트 URL을 입력하고, CLONE 버튼을 누릅니다.

<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122432277-2670b580-cfd0-11eb-805d-e890e8524eac.png" height="60%" width="60%"></p>

<br>
<h4> B. 로컬 PC에 해당 프로젝트 설치하기 </h4>

1. GIT BASH를 이용하여, `git clone` 명령어를 이용하여 로컬 PC에 해당 프로젝트를 복사합니다.

```
git clone https://github.com/CSID-DGU/2021-1-OSSP2-ttogttagis-3.git
```


<br>

<h4> C. 리눅스 기반 가상 머신에 해당 프로젝트 설치하기</h4>  

1. 자바와 GIT 을 설치합니다

```
sudo yum install java-11-openjdk-devel
sudo yum install git
```

2. 해당 서버의 시간대를 한국으로 설정합니다.

```
sudo rm /etc/localtime
sudo ln –s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

3. 프로젝트를 다운 받고, 배포 파일을 만들기 위한 디렉토리를 생성합니다.

```
mkdir ~/app && mkdir ~/app/akobot
```

4. 해당 디렉토리로 이동하고, 깃허브의 프로젝트 레파지토리를 복사합니다.

```
cd ~/app/akobot 
git clone https://github.com/CSID-DGU/2021-1-OSSP2-ttogttagis-3.git
```



### ⚠️ (필수) 공통 프로젝트에 필수 적이지만, 보안상의 이유로 `.gitignore`에 등록된 부분이 있습니다.
<br>
🌟 프로젝트 경로의 `src` > `main` > `resources` 디렉토리에 추가할 파일 3가지 
- LINUX기반 가상 머신에선, VIM 에디터등을 이용해 해당 경로에서 작성할 것

1. `application.properties`


```properties
# 자동재시작 사용여부
spring.devtools.restart.enabled=true

#application-oauth.properties 로딩
spring.profiles.include=oauth

#로컬 작업에서 db 작업을 위해 h2
spring.h2.console.enabled=true

#카페 24 SMS 호스팅 키 였으나 더이상 사용하지 않음
#sms.key = 

# mail 발신 관련
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username= WRITE_YOUR_EMAIL_HERE
spring.mail.password= WRITE_YOUR_PASSWORD_HERE
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.auth=true
```

- 해당 GMAIL 계정으로 로그인한 상태에서 https://www.google.com/settings/security/lesssecureapps에서 보안 수준이 낮은 앱 허용 사용을 해주십시오
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437319-8ff2c300-cfd4-11eb-91f1-2c25384d2d6f.JPG" height="60%" width="60%"></p>

- mail 발신을 담당할 관리자의 gmail 이메일과 패스워드를 WRITE_`YOUR_EMAIL_HERE` 와 `WRITE_YOUR_PASSWORD_HERE`입력하십시오


2. `application-oauth.properties`
```properties
spring.security.oauth2.client.registration.google.client-id= WRITE_YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret= WRITE_YOUR_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=profile,email
```

Spring Security와 구글 로그인 API를 활용하여 로그인 처리를 담당하는 properties파일입니다.

- 구글 클라우드 플랫폼 cloud.google.com/gcp 에 접속합니다.
- 새 프로젝트를 생성 후, API 개요를 클릭합니다. 또는 기존의 프로젝트를 선택합니다.
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437419-a7ca4700-cfd4-11eb-809f-1cf23a62e453.png" height="60%" width="60%"></p>

- 상단 사용자 인증 정보 만들기 선택 후 OAuth 클라이언트 ID 생성합니다.
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437441-ae58be80-cfd4-11eb-9ecb-b6d671625a89.png" height="60%" width="60%"></p>

- 리디렉션을 승인할 URI을 작성 후, 클라이언트 ID, 비밀번호를 확인하고

  해당 properties 파일의 WRITE_YOUR_CLIENT_ID 와 WRITE_YOUR_CLIENT_SECRET에 대치합니다.
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437513-c03a6180-cfd4-11eb-88cc-36fe68149c8a.png" height="60%" width="60%"></p>


3.  `serviceAccountKey.json`
```json
{
  "type": "service_account",
  "project_id": "akobotweb",
  "private_key_id": "COPY YOUR KEY"
  "private_key": "-----BEGIN PRIVATE KEY-----
  
  
  
  \n-----END PRIVATE KEY-----\n",
  "client_email": "COPY YOUR KEY",
  "client_id": "COPY YOUR KEY",
  "auth_uri": "COPY YOUR KEY",
  "token_uri": "COPY YOUR KEY",
  "auth_provider_x509_cert_url": "COPY YOUR KEY",
  "client_x509_cert_url": "COPY YOUR KEY"
}
```

챗봇과 챗봇 데이터베이스인 firebase 앱에 접근하는 키의 정보를 담고 있습니다.

- https://console.firebase.google.com/ 로 이동하여 Firebase 프로젝트를 새로 생성하거나 만듭니다.

  (1)  톱니바퀴 모양을 클릭 하여 프로젝트 설정으로 이동합니다

  (2)  서비스 계정을 클릭합니다

  (3)  `새 비공개 키 설정`을 클릭하여 serviceAccountKey.json 파일을 생성하고 프로젝트의 해당 파일로 복사합니다.

<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437291-8a957880-cfd4-11eb-8af1-1319affa6506.png" height="60%" width="60%"></p>


### 3. 배포 환경 구축

<h5>- 직접 개인 PC에서 배포하는 경우<h5>

(1) 인텔리제이에서 bootJar을 실행시켜 배포 파일을 생성하고, Akobot-0.0.1-SNAPSHOT.jar이 생성됨을 확인한다. 
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122448707-034e0200-cfe0-11eb-8977-ceae84ca6831.png" height="60%" width="60%"></p>

(2) 그 다음 cmd를 열고 해당 배포 파일의 디렉토리로 이동한 후,

 java –jar Akobot-0.0.1-SNAPSHOT.jar 명령어 또는 nohup java -jar Akobot-0.0.1-SNAPSHOT.jar 2>&1 & 명령어를 통해 해당 프로젝트를 내장 톰켓 서버를 통해 배포하게 된다.
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122448824-21b3fd80-cfe0-11eb-88b1-8e362b83ff50.png" height="60%" width="60%"></p>


<h5> - LINUX 기반의 가상 머신에서 배포하는 경우</h5>

해당 프로젝트는 아마존 웹 서비스 AWS의 클라우드 서버에 가상 머신이 구동될 수 있도록 하였습니다.

해당 서버 환경은 다음과 같습니다.

CentOS7 기반 리눅스 2 AMI2 인스턴스 

범용 목적 및 프리 티어인 t2.micro  
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122448882-31cbdd00-cfe0-11eb-8c26-bc20cbcd1a76.png" height="60%" width="60%"></p>


> 앞서 리눅스 기반 환경에서 프로젝트 설치하기 를 참고합니다.  

1. 자바와 GIT 을 설치합니다

```
sudo yum install java-11-openjdk-devel
sudo yum install git
```

2. 해당 서버의 시간대를 한국으로 설정합니다.

```
sudo rm /etc/localtime
sudo ln –s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

3. 프로젝트를 다운 받고, 배포 파일을 만들기 위한 디렉토리를 생성합니다.

```
mkdir ~/app && mkdir ~/app/akobot
```

4. 해당 디렉토리로 이동하고, 깃허브의 프로젝트 레파지토리를 복사합니다.

```
cd ~/app/akobot 
git clone https://github.com/CSID-DGU/2021-1-OSSP2-ttogttagis-3.git
```

5. `.gitignore` 때문에 제외된 properties 파일을 vim 에디터를 이용하여 해당 경로에 맞게 작성한다.

```
vim ~/src/main/resources/application.properties
vim ~/src/main/resources/application-oauth.properties
vim ~/src/main/resources/serviceAccountKey.json
```

6-1. `deploy.sh` 파일 작성하여 자동화 배포 설정을 한다.

   그 이후 ./deploy.sh를 터미널에 입력하여 실행시킨다.

```shell
#!/bin/bash
REPOSITORY=/home/ec2-user/app/akobot
PROJECT_NAME=2021-1-OSSP2-ttogttagis-3

cd $REPOSITORY/$PROJECT_NAME/

echo "> Git Pull"

git pull

echo "> STARTING BUILD PROJECT"

./gradlew build

echo "> step1 move dir"

cd $REPOSITORY

echo "> COPYING BUILD FILES"

cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

echo "> Indentifying current PID, which is working on"

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.jar)
echo "CURRENT PID : $CURRENT_PID"
if [ -z "$CURRENT_PID" ]; then
  echo "> there's no working pid in current status, so don't terminate"
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi
echo "> DEPLOY NEW APPLICATION "
JAR_NAME=$(ls -tr $REPOSITORY/ | grep *.jar | tail -n 1)
echo "> JAR NAME : $JAR_NAME"
nohup java -jar $REPOSITROY/$JAR_NAME 2>&1 &

```



6-2. 또는  ./gradlew build 명령어로 AkobotWeb-0.0.1-SNAPSHOT.jar를 빌드하고 직접  java 명령어 nohup명령어로 실행시켜 호스팅한다.
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122448953-460fda00-cfe0-11eb-8888-1f1fcc5a1134.png" height="60%" width="60%"></p>

<br>
### 4. 관리자 페이지 완성 모습

- 관리자 암호키가 있는 관리자만이 구글 연동 로그인을 할 수 있음
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122359472-8ba4b680-cf90-11eb-8825-611964835110.png"></p>

- 로그인 이후 관리자 페이지 메인 화면<br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122359491-8f383d80-cf90-11eb-835f-76ab30d6ca2a.JPG"></p>


- 미해결 질문 게시글 목록 전체  조회<br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122363506-f3a8cc00-cf93-11eb-886a-ce7c1ecec8a4.png"></p>



- 미해결 질문 게시글 상세 조회<br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122363493-f0154500-cf93-11eb-9232-cb72cd51f9cc.png"></p>


- 미해결 질문 답변 및 알람(메일) 전송 <br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122363516-f73c5300-cf93-11eb-9ea1-e34e3b788881.png"></p>


- 아코봇 정보 갱신 <br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122363528-fb687080-cf93-11eb-995a-aa083ccb6f6e.png"></p>






