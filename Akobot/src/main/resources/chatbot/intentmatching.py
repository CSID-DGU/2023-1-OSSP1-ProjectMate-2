#intent matching 하기
import pandas as pd
import extracting

#user keyword-intent keyword matching with dictionary {key:valuelist}
intents={
                #level 1
                '전체모집요강':['total',1],
                '수시':['susi',1],
                '정시':['jungsi',1],
                '모집인원':['recruit',1],
                '작년도경쟁률':['competition',1],
                '지원자격유의사항':['note',1],
                '외국인특별전형':['foreign',1],
                '전형요소별평가방법':['test',1],
                '전형일정':['schedule',1],  
                #level 3
                '두드림소프트웨어':['susi_dodreamsoft',3],
                '불교추천':['susi_buddhism',3],
                '학교장추천':['susi_principal',3],
                '논술':['susi_essay',3],
                '두드림':['susi_dodream',3],
                '고른기회':['susi_regular',3],
                '특수교육대상자':['susi_special',3],
                '재직자':['susi_incumbent',3],
                '실기':['susi_performance',3],
                #level 4
                '일반전형':['jungsi_normal',4],
                '농어촌전형':['jungsi_farming',4],
                '특성화고교':['jungsi_specialized',4],
                '재직자':['jungsi_incumbent',4],
                '기초생활수급자및차상위계층':['jungsi_basic',4],
                #level 6
                '수시경쟁률':['competition_susi',6],
                '정시경쟁률':['competition_jungsi',6],
                #level 7
                '농어촌학생재학거주인정기준':['note_farming',7],
                '특성화고교졸업자동일계열기준학과':['note_special',7],
                '재직기간산정기준':['note_incumbent',7],
                #level 9
                '서류종합평가':['test_documnet',9],
                '면접평가':['test_interview',9],
                '학교생활기록부':['test_records',9],
                '대학수학능력시험':['test_SAT',9],
                #level 10
                '재외국민/외국인일정':['schedule_foreigner',10],
                '정시일정':['schedule_jungsi',10],
                '수시일정':['schedule_susi',10],
                #fallback intent
                '잘못된 입력':['fallback',0]
             }

# preprocess data
intent_keywords=intents.keys() # korean 인텐트이름 한국어
intent_list=list(intents.values()) # english 인텐트 이름영어, 인텐트 레벨 (2D)

# 영어이름 인텐트 리스트 (아직 사용안함)
intent_names= pd.DataFrame(intent_list)[0].to_list()
#print(intent_names)

# 인텐트 레벨 리스트
intent_levels= pd.DataFrame(intent_list)[1].to_list()
#print(intent_levels)

# raw matching
matchings=[]
for user_keyword in extracting.keywords: # extracted keywords from user input
    for intent_keyword in intent_keywords: # intent list from DB
        if intent_keyword in user_keyword: # if extracted keyword contains intent name
            matchings.append(intents[intent_keyword]) 
            print("'"+user_keyword+"'입력을 '"+intent_keyword+"'에 해당하는 "
             +intents[intent_keyword][0]+" 인텐트로 매칭을 성공했습니다.")
            break

# matchings 리스트 내 개수가 0이면 fallback 발생
if len(matchings)==0:
    matchings.append(intents['잘못된 입력'])
    
                
# matchings 리스트 내 중복 값 제거
matchings=list((matchings))

# show matching results (intents in english)
print("matching 결과 >>",matchings)


######################## 다른 레벨 다중 키워드 ###########################
# matching된 결과들 레벨에 따라 처리할 것 (intents의 intent_levels 사용)
# 1과 그 이상이 존재할 경우, 이름포함 여부로 드롭
for element in matchings:
    if element[1]==1: #레벨이 1
        for another in matchings:
            if another[1]>1:
                if element[0] in another[0]:
                    matchings.remove(element)




# python 서버 연결되게끔 cmd 창에서의 출력
