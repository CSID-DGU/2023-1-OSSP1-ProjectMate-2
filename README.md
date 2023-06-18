**2023-1-OPPS1-ProjectMate-2**

2023년 1학기 동국대학교 컴퓨터공학과 공개SW프로젝트 2조의 프로젝트입니다 🙂

# Akobot *v2.0* 🐘


### 🐘🧡아코봇, 동국대학교 입시정보를 알려줘!

너비를 300정도로 프로젝트 이미지를 넣어준다

너비를 300정도로 프로젝트 이미지를 넣어준다

너비를 300정도로 프로젝트 이미지를 넣어준다  (가운데 정렬 필수)

너비를 300정도로 프로젝트 이미지를 넣어준다

너비를 300정도로 프로젝트 이미지를 넣어준다

너비를 300정도로 프로젝트 이미지를 넣어준다 



## 프로젝트 소개  💬

> 동국대학교 입학을 원하는 예비 입학생들에게 입시 정보를 보다 빠르고 정확하게 전달하기 위해, 홈페이지 오른쪽 하단에 상시 대기하고 있는 아코봇 !
> 
> 
> “수시전형 알려줘”와 같이 궁금한 점을 친근하게 물어본다면 당신의 예상보다 빠르게 고민을 해결해 줄 거예요 💬
> 
> > **v1.0와의 차별점 ⚠️**
> > 
> 1. 챗봇 이용 시 새로운 정보를 요청해야 할 경우, 기존 프로젝트는 다시 아코봇을 호출해야 한다는 문제점이 존재하였습니다. 이를 보완하여 아코봇을 다시 호출하지 않아도 계속해서 원하는 정보를 제공받을 수 있도록 챗봇 호출 구조를 변경하였습니다. 
> 2. Dialogflow 서비스를 활용한 기존 프로젝트는 사용자가 입력한 멘트에서 추출한 핵심 키워드 중 임의로 결과를 반환한다는 점을 보완하여 파이썬을 이용해 전처리 모듈을 구현하고, 모듈을 통해 추출한 키워드에 적합한 결과를 도출하여 GCR(Goal Completion Rate) 지수를 높일 수 있습니다. 
> 3. 기존 프로젝트는 DBMS로 구조가 정해져 있지 않은 firebase를 활용했습니다. 프로젝트 챗봇이 사용하는 입시 정보의 특성 상 매해 세부 사항이 개정되어도 구조 자체는 유지되기 때문에, 답변을 줄 항목의 개수를 기준으로 테이블을 구분하여 데이터의 일관성을 유지하고 수정이 용이한 MySQL로 변경하였습니다.
> 4. 기존 프로젝트에서 관리자 페이지의 경우 인증키가 있는 관리자 만이 접근 가능한데, 이 인증키는 관리자 페이지의 페이지 소스 내에 공개되어 있어 보안이 취약하다는 단점을 가지고 있습니다. 이를 관리자 페이지에서 사용자가 학교 코드를 입력하면, db에서 해당 학교 코드를 찾아 일치할 경우 관리자 페이지에 접속할 수 있게 변경하였습니다. (보안 상 취약점을 보완했다는 점 + 공개 키 배포 관련 내용 추가 필요)
> 
> > **기대 효과 📈**
> > 
> 1. 편의성 : 아코봇을 통해 입시 정보를 쉽고 빠르게 얻을 수 있으므로, 입시 준비에 필요한 정보를 찾는 시간과 노력을 크게 줄일 수 있습니다. 학생들은 복잡한 학교 공식 홈페이지나 다른 정보 출처를 찾아다니지 않고도 챗봇을 통해 입시 관련 질문에 즉시 답변을 받을 수 있습니다.
> 2. 신뢰성: 아코봇은 정확하고 최신의 정보를 기반으로 답변을 제공합니다. 이는 학생들이 신뢰할 수 있는 출처로부터 정보를 얻는 것과 동등한 효과를 가져옵니다. 학교 공식 홈페이지나 입시 관련 담당자와의 통신에 비해 신속하고 일관된 정보를 제공할 수 있으므로, 학생들은 더 큰 신뢰를 가지고 입시 준비에 임할 수 있습니다.
> 3. 접근성: 아코봇은 PC로 접속하여 사용할 수 있습니다. 이는 누구나 언제 어디서든 챗봇을 이용하여 입시 정보를 얻을 수 있다는 것을 의미합니다. 따라서 지방이나 외국에 거주하거나, 바쁜 일정을 갖고 있는 학생들에게도 입시 정보에 손쉽게 접근할 수 있는 기회를 제공합니다.

## Introduction in English 💌
Our chatbot supports the following component.
1. The people who want to find the information about our university admission can obtain that information much faster and more accurately by using our chatbot.
2. You can use our chatbot by connecting university official website and click the chatbot item where positioned lower right of website.
3. If you can not obtain the result you don’t expect, you can send a e-mail to manager. So you can get an answer that contain the information you need directly.

## 👥  웹개발팀 소개

| 이름 | 학번 | Major Part |  ID  |
| --- | --- | --- | --- |
| 박성준 👑 | 2019112066 | Front-end | [@SJ-PARKs](https://github.com/SJ-PARKs) |
| 박민제 | 2019112608 | Back-end | [@Park-MinJe](https://github.com/Park-MinJe) |
| 유재윤 | 2020113391 | User NLP & Rule-based Matching | [@jaeyoonwodbs](https://github.com/jaeyoonwodbs) |
| 정지수 | 2020113394 | User NLP & Rule-based Matching | [@StopSoo](https://github.com/StopSoo) |
| 김규리 | 2021111998 | Back-end | [@mandar2n](https://github.com/mandar2n) |
| 김세민 | 2021112017 | User NLP & Rule-based Matching | [@semnisem](https://github.com/semnisem) |

## 배포 주소

> 개발 버전 :
> 
> 
> **프론트 서버** : 
> 
> **백엔드 서버** : 
> 

## **목차**

[⌛ 아코봇 실행 예시](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#-아코봇-실행-예시) 

[🖥️ 아코봇 관리자 페이지 화면 구성](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#%EF%B8%8F-아코봇-관리자-페이지-화면-구성) 

[©️ 라이센스](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#%EF%B8%8F-라이센스) 

[🔧 Stacks ](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#-stacks)

[🗓️ 프로젝트를 마치며](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#%EF%B8%8F-프로젝트를-마치며) 


## ⌛ 아코봇 실행 예시


실행예시를 넣어준다

## 🖥️ 아코봇 관리자 페이지 화면 구성

표로 된 화면 구성 이미지를 넣으면 좋을 듯 함

## ©️ 라이센스

라이센스를 넣어준다

## 🔧 Stacks


### Environment
<img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/><img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white"/><img src="https://img.shields.io/badge/Intelli%20j-orange?style=flat-square&logo=intellijidea&logoColor=black"/>

### Development
<img src="https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=Python&logoColor=white"/><img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/><img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black"/><img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>

### Library
<img src="https://img.shields.io/badge/soynlp-0.0.493-brightgreen?style=flat-square&logo=soynlp&logoColor=white"/><img src="https://img.shields.io/badge/pip-23.1.2-blue?style=flat-square&logo=pip&logoColor=white"/>

### Communication
<img src="https://img.shields.io/badge/Notion-white?style=flat-square&logo=Notion&logoColor=black"/><img src="https://img.shields.io/badge/Webex-black?style=flat-square&logo=Webex&logoColor=white"/>


## 🗓️ 프로젝트를 마치며

- 고집했던 포인트
- 이후의 계획
- 프로젝트의 확장 가능성

