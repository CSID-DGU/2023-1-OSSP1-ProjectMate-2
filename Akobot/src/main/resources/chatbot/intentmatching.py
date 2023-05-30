#intent matching 하기
import pandas as pd
import extracting

# load intent data.*will be modified with DB
data=pd.read_csv("simple.CSV", encoding="utf-8")
intents=data.iloc[:,0:2]

# preprocess data
intent_names=intents[intents.columns[1]].to_list()
intent_levels=intents[intents.columns[0]].to_list() #오타수정

#user keyword-intent keyword matching
user_keyword={
                #level 1
                '전체모집요강':'total',
                '수시':'susi',
                '정시':'jungsi',
                '모집인원':'recruit',
                '작년도경쟁률':'competition',
                '지원자격유의사항':'note',
                '외국인특별전형':'foreign',
                '전형요소별평가방법':'test',
                '전형일정':'schedule',  
                #level 2
                '두드림소프트웨어':'susi_dodreamsw',
                '불교추천':'susi_buddhism',
                '학교장추천':'susi_principal',
                '논술':'susi_essay',
                '두드림':'susi_dodream',
                '고른기회':'susi_regular',
                #level 3
                '일반전형':'jungsi_regular',
                '농어촌전형':'jungsi_farming',
                '특성화고교':'jungsi_specializedschool',
                '재직자':'jungsi_incumbent',
                '기초생활수급자및차상위계층':'jungsi_basicliving',
                #level 4 
                '농어촌학생재학거주인정기준':'note_farm_standard',
                '특성화고교졸업자동일계열기준학과':'note_specialmajor',
                '재직기간산정기준':'note_incumbent_calculating',
                #level 5
                '서류종합평가':'test_documnet',
                '면접평가':'test_interview',
                '학교생활기록부':'test_records',
                '대학수학능력시험':'test_SAT'
             }

# raw matching
matchings=[]
for keyword in extracting.keywords: #extracted keywords from user input
    for intent_name in intent_names: #intent list from DB
        if intent_name in user_keyword[keyword]: #if extracted keyword contains intent name
            matchings.append(intent_names) 
            print(intent_names+ "인텐트로 매칭이 성공했습니다.")
            break
        else:
            matchings.append(["fallback"])
        

print(matchings) #show matching results


'''
matching되지 않은 키워드들은 fall back intent 하나만 matching list에 append
matchings.append(["fallback"])
'''

'''
matching된 결과들 레벨에 따라 처리할 것
#intents의 intent_levels 사용
'''
