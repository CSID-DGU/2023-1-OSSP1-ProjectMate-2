<h3> 2021-1-OSSP2-ttogttagis-3</h3>
<h1> Project for building Chatbot of Dongguk Univ. Admissions  &  Akobot Management system for its Admin</h1> 
<br> 
<ul style="list-style:none;">
    <li><a href="#sec_target1" style="text-decoration:none;"><b>I. Jump to Akobot's Introduction</b></a></li>
    <li><a href="#sec_target2" style="text-decoration:none;"><b>II. Jump to Admins' Web Page Introduction</b></a></li>
     <br>
    <li><a href="https://github.com/CSID-DGU/2021-1-OSSP2-ttogttagis-3/blob/main/README.md">Redirect for Korean Speakers</a> </li> 
</ul>
<br> 
<h3> Team Member</h3> 

* 2019112059 이가영 (Team Leader) 

* 2017112071 김응관

* 2018110504 박지원

* 2013111989 이학진

* 2017112095 최준호

<br>
<div class="sec1">
    <a name="sec_target1"></a>
    <h2>I. Akobot - Chabot for Dongguk Univ. Admissions</h2>
</div>

### Goal

> This Chabot, Akobot offers information for applying Dongguk University by communicating with an user. If there's any case that akobot couldn't understand, it gives an URL and it allows user to get info from admins later. 

---

&nbsp;`Developement Environment ` : ![Springboot](http://img.shields.io/badge/-Dialogflow-FF9800?style=flat&logo=Dialogflow)

&nbsp;`Database` : ![Springboot](http://img.shields.io/badge/-CloudFirestore-FFCA28?style=flat&logo=Firebase)


---
### 1. Install Akobot on `your Dialogflow Project`

 &nbsp;a. Download `Akobot2.zip` located in Chatbot/Akobot2.zip from this repository .<br>

 &nbsp;b. To import our project,  go to https://dialogflow.cloud.google.com/ then, login with your account to service Akobot.

 &nbsp;c. Follow 3 steps below to import the Akobot2.zip file.

 &nbsp; &nbsp; (1) On Dialogflow Console, click `the setting buttons`.

 &nbsp; &nbsp; (2) Go to `Export and Import` 

 &nbsp; &nbsp; (3) Select `IMPORT FROM ZIP` and choose `Akobot2.zip` file
 

<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122643658-0108b680-d14c-11eb-87fe-4cb4c3e9479c.png"></p>

<br>
<h3> 2. Establish `Akobot Database` with Cloud firestore </h3>

&nbsp;a. Download `dataBackup.json` located `/Database/dataBackup.json` from this repository .<br>

&nbsp;b. To install `firestore-import-export`, enter next instruction on your cmd or terminal  

```
npm -install -g node-firestore-import-export
```

&nbsp;c. To import our original database, 

Go https://firebase.google.com/ then Get login with your google account for this project

Follow next step to get `serviceAccountKey.json` file on your local PC

  (1)  Get into Project Setting 

  (2)  Click Service Account

  (3)  Get a new private key setting, then copy serviceAccountKey.json 
  

<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437291-8a957880-cfd4-11eb-8af1-1319affa6506.png" height="60%" width="60%"></p>


Hit next command on your cmd or termina

```
firestore-import --accountCredentials path/to/credentials/file.json --backupFile /backups/myDatabase.json
```

> --accountCredentials : credential key to access your cloud firestore database.
>
> path/to/credentials/file.json : directory for the credential key.
>
> --backupFile : to import your new database with the backup one.
>
> /backups/myDatabase.json : directory for the backup database.


&nbsp;d. Reference, 
> Visit https://www.npmjs.com/package/node-firestore-import-export 

### 3. Designing Question Flow

<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/11707490/122390118-98cf9e80-cfac-11eb-82a4-9097dc190872.png"></p>



### 4. Akobot Demonstrations

- Delivering Text Info
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/11707490/122399761-0f24ce80-cfb6-11eb-9d28-78157b0d5b24.png"></p>

- Passing an link for an image info
<p align="center"><img height="60%" width="60%" alt="이미지 링크 제공" src="https://user-images.githubusercontent.com/11707490/122399790-151aaf80-cfb6-11eb-8d18-386f03aed27f.png"></p>

- Also offering an link for submitting an unsolved question
<p align="center"><img height="60%" width="60%" alt="미해결 질문 게시판 링크" src="https://user-images.githubusercontent.com/11707490/122399808-1815a000-cfb6-11eb-98f8-e94aab0f2b26.png"></p>





<br>



<div class="sec1">
    <a name="sec_target2"></a>
    <h2>II. Web Application - Akobot Management system </h2>
</div>



### Goal

> Helping Admins handle Akobot well under some problems, which are some un-solved questions, answering these questions, and doing CRUD operation
> , even if they are not involved in IT industry or never learned how to code program. 
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122449417-c9c9c680-cfe0-11eb-8681-014f52b0feff.png" height="60%" width="60%"><br> Design for AMS - Akobot Management System</p>

---
&nbsp;`Developing Programming Langauges` : ![JAVA](http://img.shields.io/badge/-Java11-006cb7?style=flat&logo=Java) & ![JAVA](http://img.shields.io/badge/-Javascript-006cb7?style=flat&logo=Javascript)

&nbsp;`Developing Environment` :  ![Springboot](http://img.shields.io/badge/-Springboot2.4.5-000000?style=flat&logo=springboot) & ![Springboot](http://img.shields.io/badge/-Gradle6.8.3-006cb7?style=flat&logo=gradle)

&nbsp;`View Side Template Engine` : ![Springboot](http://img.shields.io/badge/-Thymeleaf-005F0F?style=flat&logo=Thymeleaf)

&nbsp;`Database` : ![Springboot](http://img.shields.io/badge/-CloudFirestore-FFCA28?style=flat&logo=Firebase) & ![Springboot](http://img.shields.io/badge/-H2-0000FF?style=flat&logo=RDBMS)

&nbsp;`IDE` :  ![Springboot](http://img.shields.io/badge/-IntelliJ-000000?style=flat&logo=IntelliJIDEA)

&nbsp;`Some OS which are able to deploy this project` : ![Springboot](http://img.shields.io/badge/-Windows10-006cb7?style=flat&logo=windows) &  ![Springboot](http://img.shields.io/badge/-MacOS-006cb7?style=flat&logo=macOS) & ![Springboot](http://img.shields.io/badge/-LINUX-006cb7?style=flat&logo=Linux)

---

### 1. Implementing Open Source Software

#####   Purpose of being FAST, EASY AND STABLE Project

&nbsp;&nbsp;![Springboot](http://img.shields.io/badge/-BootStrap-006cb7?style=flat&logo=BootStrap) & ![Springboot](http://img.shields.io/badge/-JUnit5-006cb7?style=flat&logo=JUnit5) & ![Springboot](http://img.shields.io/badge/-DevTools-FFCA28?style=flat)  & ![Springboot](http://img.shields.io/badge/-SpringMVC-005F0F?&nbsp;&nbsp;style=flat&logo=Spring)

#####   Purpose of being secure and convenient for logging user account with GOOGLE 

&nbsp;&nbsp;![Springboot](http://img.shields.io/badge/-JPA-FFCA28?style=flat&logo=Firebase&link=본인주소) & ![Springboot](http://img.shields.io/badge/-SpringSecurity-FFCA28?style=flat&logo=Firebase&link=본인주소)


<br>
<h3> 2. HOW to install? </h3>
<h4> A. for IDEs, such as IntelliJ</h4>

1. Please install IntelliJ

> https://www.jetbrains.com/idea/download

2. Next step, please set following options. 

    - (1) Check upper view and click `Setting`> `Build,Execution,Deployment` > `Gradle`

    - (2) Set `Build and run using` , `Run tests using` as `IntelliJ IDEA` 


<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122431795-bcf0a700-cfcf-11eb-8a29-0898eed6ea1d.png" height="60%" width="60%"></p>



3. Look upto your upper view in IntelliJ, 
- (1) Get `File`> `Project Structure`>`Project`
- (2) Set `Project SDK` with ` Java 11` 
   if you haven't installed Java 11, please consider using ` Amazon Correto 11.0.10` or install onto your computer

<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122431904-cf6ae080-cfcf-11eb-92cc-6eeae906fed8.png" height="60%" width="60%"></p>

4. To clone this project into your local repository,

   (1) Go to `File`

   (2) Click `Project from Version Contrl...`
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122432254-21ac0180-cfd0-11eb-86d1-54ec1b2d724f.png" height="60%" width="60%"></p>


​	(3)  Please copying our web URL into the URL blank.  

<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122432277-2670b580-cfd0-11eb-805d-e890e8524eac.png" height="60%" width="60%"></p>

<br>
<h4> B. for Installing using Git Bash   </h4>

1. Open GIT BASH and hit `git clone` commands to clone our project.

```
git clone https://github.com/CSID-DGU/2021-1-OSSP2-ttogttagis-3.git
```


<br>

<h4> C. for Installing Linux based Virtual Machine </h4>  

1. To start installing Java and Git, please write below commands on terminal. 

```
sudo yum install java-11-openjdk-devel
sudo yum install git
```

2. Change Timezone for your service area 
for us, we've changed it as GMT+9 
```
sudo rm /etc/localtime
sudo ln –s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

3. Make directories to clone our project.

```
mkdir ~/app && mkdir ~/app/akobot
```

4. Change directory and clone our github reposiory.

```
cd ~/app/akobot 
git clone https://github.com/CSID-DGU/2021-1-OSSP2-ttogttagis-3.git
```



### ⚠️ (REQUIRED) Note that some properties files which is very important to run this project written in `.gitignore`
<br>
🌟 Insert 3 properites files into `src` > `main` > `resources`
- Consider using Vim Editor, if you are accessing our project in linux based VM such as Ubuntu, CentOs

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

- Please go to https://www.google.com/settings/security/lesssecureapps and down-grade security level of your account which is going to send E-Mail to users
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437319-8ff2c300-cfd4-11eb-91f1-2c25384d2d6f.JPG" height="60%" width="60%"></p>

-  Replace `WRITE_YOUR_EMAIL_HERE` 와 `WRITE_YOUR_PASSWORD_HERE` with admins's google account email and password. 


2. `application-oauth.properties`
```properties
spring.security.oauth2.client.registration.google.client-id= WRITE_YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret= WRITE_YOUR_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=profile,email
```

Properties file for Spring Security and Google Logging API

- Go to  cloud.google.com/gcp
- Create new Project, then click  API Summary. If you've already registed, choose that project.
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437419-a7ca4700-cfd4-11eb-809f-1cf23a62e453.png" height="60%" width="60%"></p>

- Make User account info, and create OAuth Client ID
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437441-ae58be80-cfd4-11eb-9ecb-b6d671625a89.png" height="60%" width="60%"></p>

- Fill out some URI onto blanks for allowing Redirection, and check your Client ID, password 

 - Replace `WRITE_YOUR_CLIENT_ID` and `WRITE_YOUR_CLIENT_SECRET` with them.
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
It contains very crucial inforamation to access Chabot's and Web Page's Database
- Goto https://console.firebase.google.com/ make new Firebase project or choose one.

  (1)  Get into Project Setting 

  (2)  Click Service Account

  (3)  Get a new private key setting, then copy serviceAccountKey.json 
  (⚠️ If you alreday have a latest private key, you don't need to make a new one.)
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122437291-8a957880-cfd4-11eb-8af1-1319affa6506.png" height="60%" width="60%"></p>


### 3. DEPLOY Environment Settings

<h5>- Direct Deploying under your PC<h5>

(1) Launch `bootJar` to make `Akobot-0.0.1-SNAPSHOT.jar` file and check
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122448707-034e0200-cfe0-11eb-8977-ceae84ca6831.png" height="60%" width="60%"></p>

(2) open cmd, terminal or whatever, change directory on to its directory,

put `java –jar Akobot-0.0.1-SNAPSHOT.jar` or `nohup java -jar Akobot-0.0.1-SNAPSHOT.jar 2>&1 &` commands to  deploy.
note that it has its own TOMCAT configuration 
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122448824-21b3fd80-cfe0-11eb-88b1-8e362b83ff50.png" height="60%" width="60%"></p>


<h5> - Deploying under LINUX based VM </h5>

We conduct this example under AWS Cloud Server, 

Environment is,

CentOS7 based AMI2 Instances

General Purpose and Free Tier -  t2.micro
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122448882-31cbdd00-cfe0-11eb-8c26-bc20cbcd1a76.png" height="60%" width="60%"></p>


> Reconsider the case for installing Project under Linux based OS

1. To start installing Java and Git, please write below commands on terminal.

```
sudo yum install java-11-openjdk-devel
sudo yum install git
```
 
2. Change Timezone for your service area

```
sudo rm /etc/localtime
sudo ln –s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

3. Make directories to clone our project.

```
mkdir ~/app && mkdir ~/app/akobot
```

4. Change directory and clone our github reposiory.

```
cd ~/app/akobot 
git clone https://github.com/CSID-DGU/2021-1-OSSP2-ttogttagis-3.git
```

5. Use Vim editor for three propeties files that are ingored because of `.gitignore` file for security.
```
vim ~/src/main/resources/application.properties
vim ~/src/main/resources/application-oauth.properties
vim ~/src/main/resources/serviceAccountKey.json
```

6-1. write down auto-deploy file, `deploy.sh` 

then hit ./deploy.sh to start deploy

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



6-2. OR  just hit ./gradlew build to build `AkobotWeb-0.0.1-SNAPSHOT.jar` and use `java ...` or `nohup ...` commands to deploy
<p align="center"><img src="https://user-images.githubusercontent.com/54317409/122448953-460fda00-cfe0-11eb-8888-1f1fcc5a1134.png" height="60%" width="60%"></p>

<br>
### 4. AMS Demonstrations

- Only admins who have a private key can proceed further logging process
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122359472-8ba4b680-cf90-11eb-8825-611964835110.png"></p>

- Main Page After Logging<br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122359491-8f383d80-cf90-11eb-835f-76ab30d6ca2a.JPG"></p>


- Read all unsovled  questions<br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122363506-f3a8cc00-cf93-11eb-886a-ce7c1ecec8a4.png"></p>



- Read a detailed unsolved question<br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122363493-f0154500-cf93-11eb-9232-cb72cd51f9cc.png"></p>


- Write down an answer and send a E-Mail to notify <br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122363516-f73c5300-cf93-11eb-9ea1-e34e3b788881.png"></p>


- Update AKobot DB <br>
<p align="center"><img height="60%" width="60%" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/54317409/122363528-fb687080-cf93-11eb-995a-aa083ccb6f6e.png"></p>






