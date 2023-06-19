**2023-1-OPPS1-ProjectMate-2**

2023년 1학기 동국대학교 컴퓨터공학과 공개SW프로젝트 2조의 프로젝트입니다 🙂

[👩🏻‍💻 기존 프로젝트 구경하기](https://github.com/junoade/2021-1-OSSP2-ttogttagis-3)

# Akobot *v2.0* 🐘


### 🐘🧡아코봇, 동국대학교 입시정보를 알려줘!
![아코봇](https://github.com/CSID-DGU/2023-1-OSSP1-ProjectMate-2/assets/114139700/b859ef76-6dc8-4618-a4cf-b103325032db)

> 동국대학교 공식 홈페이지에 접속하면 오른쪽 하단에 위와 같은 귀여운 아코 아이콘이 존재합니다.


## 프로젝트 소개  💬

> 동국대학교 입학을 원하는 예비 입학생들에게 입시 정보를 보다 빠르고 정확하게 전달하기 위해, 홈페이지 오른쪽 하단에 상시 대기하고 있는 아코봇 !
> 
> 
> “수시전형 알려줘”와 같이 궁금한 점을 친근하게 물어본다면 당신의 예상보다 빠르게 고민을 해결해 줄 거예요 💬
> 
> > **v1.0와의 차별점 ⚠️**
> > 
> 1. 챗봇 이용 시 새로운 정보를 요청해야 할 경우, 기존 프로젝트는 다시 아코봇을 호출해야 한다는 문제점이 존재하였습니다. 이를 보완하여 아코봇을 다시 호출하지 않아도 계속해서 원하는 정보를 제공받을 수 있도록 챗봇 호출 구조를 변경하였습니다. 
> 2. Dialogflow 서비스를 활용한 기존 프로젝트는 사용자가 입력한 멘트에서 추출한 핵심 키워드 중 임의로 결과를 반환한다는 점을 보완하여 파이썬을 이용해 전처리 모듈을 구현하고, 모듈을 통해 추출한 키워드에 적합한 결과를 도출하여 GCR(Goal Completion Rate) 지수를 높이는 것을 목표로 진행하였습니다.  
> 3. 기존 프로젝트는 DBMS로 구조가 정해져 있지 않은 firebase를 활용했습니다. 프로젝트 챗봇이 사용하는 입시 정보의 특성 상 매해 세부 사항이 개정되어도 구조 자체는 유지되기 때문에, 답변을 줄 항목의 개수를 기준으로 테이블을 구분하여 데이터의 일관성을 유지하고 수정이 용이한 MySQL로 변경하였습니다.
> 4. 기존 프로젝트에서 관리자 페이지의 경우 인증키가 있는 관리자 만이 접근 가능한데, 이 인증키는 관리자 페이지의 페이지 소스 내에 공개되어 있어 보안이 취약하다는 단점을 가지고 있습니다. 이를 관리자 페이지에서 사용자가 학교 코드를 입력하면, db에서 해당 학교 코드를 찾아 일치할 경우 관리자 페이지에 접속할 수 있게 변경하고자 하였습니다. 
> 
> > **기대 효과 📈**
> > 
> 1. 경제성 및 편의성: 동국대학교 홈페이지에 상시 대기하고 있는 아코봇을 통해 입시 정보를 쉽고 빠르게 얻을 수 있으므로, 입시 준비에 필요한 정보를 찾는 시간과 노력을 크게 줄일 수 있다. 학생들은 학교 공식 홈페이지를 탐색하거나 힘들게 다른 정보 제공 사이트를 찾아다니지 않고도, 챗봇을 통해 입시 관련 질문에 즉시 답변을 받을 수 있다. 또한 챗봇을 활용하여 입시 정보를 제공하면, 학교나 입시 대행 기관이 정보 제공을 위해 할애해야 하는 비용과 인력을 절감할 수 있다. 동시에 많은 학생들에게 동일한 정보를 효율적으로 전달할 수 있다. 
> 2.  신뢰성: 아코봇은 학교 홈페이지에서 매번 업데이트되는 정보를 기반으로 하므로, 가장 정확하며 가장 최신의 정보를 통해 답변을 제공한다. 이는 학생들이 신뢰할 수 있는 출처로부터 정보를 얻는 것과 동등한 효과이다. 입시 관련 담당자와의 통신에 비해 신속하고 일관된 정보를 제공할 수 있으므로, 정확하고 빠르게 제공받은 정보로 입시 준비에 임할 수 있다.
> 3. 접근성: 아코봇은 PC로 접속하여 사용할 수 있다. 이는 누구나 언제 어디서든 챗봇을 이용하여 입시 정보를 얻을 수 있다는 것을 의미한다. 학교 홈페이지의 오른쪽 하단에 챗봇이 위치해 있어 필요할 때 바로 바로 이용할 수 있게 된다. 
> 4. 사회성 : 아코봇을 통해 입시 정보와 관련된 질문에 관해 대답을 받고 학생들은 더 큰 자신감과 효능감을 가질 수 있다. 또한 이 챗봇이 본교 컴퓨터공학과의 프로젝트로 제작되었다는 것을 오픈소스로 제공한다면 본교 입학을 목표로 하는 입시생들에게 동기 부여가 될 수 있을 것이며, 이는 학업적 성취에 긍정적인 영향을 미칠 수 있다. 

## 💌 Introduction in English 
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

## **목차**

[📍Database](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#Database)

[⌛ 아코봇 실행 예시](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#-아코봇-실행-예시) 

[🖥️ 아코봇 관리자 페이지 화면 구성](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#%EF%B8%8F-아코봇-관리자-페이지-화면-구성) 

[©️ 라이센스](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#%EF%B8%8F-라이센스) 

[🔧 Stacks ](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/blob/main/README.md#-stacks)

## 📍 Database

- 챗봇의 질문 흐름도

![DB_level_diagram](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/assets/101847471/9528a3dd-a832-487f-876d-61c873629b2e)

- ER Diagram

![ERD](https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/assets/101847471/c0578255-cf04-4349-91bf-77c63257dd3f)

## ⌛ 아코봇 실행 예시

<img width="400" alt="image" src="https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/assets/114139700/d40fe822-d9ec-482f-8b0f-c0b4697a25d7">

> 챗봇을 클릭한 후 질문을 입력하면 다음과 같이 답변을 제공합니다.
> "수시 논술전형 알려줘"와 같이 입력했을 때, '수시'라는 상위 키워드 밑에 하위 키워드로 '논술'이라는 키워드가 존재하므로 하위 키워드인 '논술'에 대한 답변만 제공하는 것을 확인할 수 있습니다.

<img width="400" alt="Screenshot 2023-06-19 at 16 11 00" src="https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/assets/114139700/a17e9cc0-9b44-4bca-93aa-521a74c39a5a">

> 사용자가 요청한 데이터의 특성에 따라 텍스트 및 이미지 등으로 정보를 제공합니다.

## 🖥️ 아코봇 관리자 페이지 화면 구성

<img width="400" alt="Screenshot 2023-06-19 at 16 11 52" src="https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/assets/114139700/5fafc5b6-9856-4cfb-b603-9cf9c70dd45e">

> 챗봇 만으로 답변이 해결되지 않을 시, 사용자가 직접 질문을 등록할 수 있는 웹페이지 연동 링크를 제공합니다.

<img width="400" alt="Screenshot 2023-06-19 at 16 13 11" src="https://github.com/CSID-DGU/2023-1-OPPS1-ProjectMate-2/assets/114139700/33bb0116-f5bd-4e3d-b4c6-49c4def128e1">

> 위와 같이 사용자는 미해결 질문을 작성할 수 있고, 이에 대해 관리자가 보낸 답변을 메일로 확인할 수 있습니다. 

## ©️ 라이센스

MIT License

Copyright (c) 2023 CSID DGU ProjectMate

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## 🔧 Stacks


### Environment
<img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/><img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white"/><img src="https://img.shields.io/badge/Intelli%20j-orange?style=flat-square&logo=intellijidea&logoColor=black"/>

### Development
<img src="https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=Python&logoColor=white"/><img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/><img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black"/><img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>

### Library
<img src="https://img.shields.io/badge/soynlp-0.0.493-brightgreen?style=flat-square&logo=soynlp&logoColor=white"/><img src="https://img.shields.io/badge/pip-23.1.2-blue?style=flat-square&logo=pip&logoColor=white"/>

### Communication
<img src="https://img.shields.io/badge/Notion-white?style=flat-square&logo=Notion&logoColor=black"/><img src="https://img.shields.io/badge/Webex-black?style=flat-square&logo=Webex&logoColor=white"/>
