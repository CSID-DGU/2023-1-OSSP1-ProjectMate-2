# 2021-1-OSSP2-ttogttagis-3
동국대 입학도우미 챗봇 '아코봇' 
<ul style="list-style:none;">
    <li><a href="#sec_target1" style="text-decoration:none;"><b>I. 아코봇 설명부로 이동</b></a></li>
    <li><a href="#sec_target2" style="text-decoration:none;">1.1  </a></li>
    <li><a href="#sec_target3" style="text-decoration:none;">1.2.</a></li>
    <li><a href="#sec_target4" style="text-decoration:none;">1.3 그레이들 프로젝트를 스프링 부트 프로젝트로 변경하기</a></li>
    <li><a href="#sec_target5" style="text-decoration:none;">II. <b>관리자 페이지 설명부로 이동 <b>인텔리제이에서 GIT 과 GITHUB 사용법 </b></a></li>
    <li><a href="#sec_target6" style="text-decoration:none;">2.1. </a></li>
</ul>

## 팀 구성 
* 2019112059 이가영 (팀장)

* 2017112071 김응관

* 2018110504 박지원

* 2013111989 이학진

* 2017112095 최준호


## 동국대 입학처 챗봇- 아코봇 & 관리자 페이지 프로젝트 

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


![흐름도](https://user-images.githubusercontent.com/11707490/122390118-98cf9e80-cfac-11eb-82a4-9097dc190872.png)



### 2. 챗봇 완성 

- 텍스트 정보 제공
<img width="524" alt="텍스트 정보제공" src="https://user-images.githubusercontent.com/11707490/122399761-0f24ce80-cfb6-11eb-9d28-78157b0d5b24.png">

- 이미지 링크 제공
<img width="820" alt="이미지 링크 제공" src="https://user-images.githubusercontent.com/11707490/122399790-151aaf80-cfb6-11eb-8d18-386f03aed27f.png">

- 미해결 질문 게시판 링크 제공
<img width="587" alt="미해결 질문 게시판 링크" src="https://user-images.githubusercontent.com/11707490/122399808-1815a000-cfb6-11eb-98f8-e94aab0f2b26.png">





<br>



<div class="sec1">
    <a name="sec_target5"></a>
    <h2>II. 관리자 페이지</h2>
</div>



### 목표

> IT 산업에 종사하거나 코딩을 배우지 않은 대학교 입학처 관계자도 챗봇을 운영하면서 생기는 미해결 질문, 질문 답변 및 알림, 데이터베이스 수정 등의 업무를 할 수 있게 하는 웹 어플리케이션 개발



---
  &nbsp;`개발 언어` : ![JAVA](http://img.shields.io/badge/-Java11-006cb7?style=flat&logo=Java)

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

### 2. 관리자 페이지 완성 모습

- 관리자 암호키가 있는 관리자만이 구글 연동 로그인을 할 수 있음

![접근](https://user-images.githubusercontent.com/54317409/122359472-8ba4b680-cf90-11eb-8825-611964835110.png)


- 로그인 이후 관리자 페이지 메인 화면<br>

![관리자 전면](https://user-images.githubusercontent.com/54317409/122359491-8f383d80-cf90-11eb-835f-76ab30d6ca2a.JPG)



- 미해결 질문 게시글 목록 전체  조회<br>
![질문 게시글 목록](https://user-images.githubusercontent.com/54317409/122363506-f3a8cc00-cf93-11eb-886a-ce7c1ecec8a4.png)



- 미해결 질문 게시글 상세 조회<br>
![미해결 질문 조회](https://user-images.githubusercontent.com/54317409/122363493-f0154500-cf93-11eb-9232-cb72cd51f9cc.png)



- 미해결 질문 답변 및 알람(메일) 전송 <br>
![답변 및 알람 전송](https://user-images.githubusercontent.com/54317409/122363516-f73c5300-cf93-11eb-9ea1-e34e3b788881.png)


- 아코봇 정보 갱신 <br>
![정보 업데이트](https://user-images.githubusercontent.com/54317409/122363528-fb687080-cf93-11eb-995a-aa083ccb6f6e.png)



### N. 배포 방법

- 로컬 PC에서 배포하는 경우
- 가상 머신에서 배포하는 경우




