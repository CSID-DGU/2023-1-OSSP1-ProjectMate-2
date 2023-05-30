#intent matching 하기
import pandas as pd
import extracting

#user keyword-intent keyword matching with dictionary {key:value}
intents={
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
                #level 3
                '두드림소프트웨어':'susi_dodreamsoft',
                '불교추천':'susi_buddhism',
                '학교장추천':'susi_principal',
                '논술':'susi_essay',
                '두드림':'susi_dodream',
                '고른기회':'susi_regular',
                '특수교육대상자':'susi_special',
                '재직자':'susi_incumbent',
                '실기':'susi_performance',
                #level 4
                '일반전형':'jungsi_normal',
                '농어촌전형':'jungsi_farming',
                '특성화고교':'jungsi_specialized',
                '재직자':'jungsi_incumbent',
                '기초생활수급자및차상위계층':'jungsi_basic',
                #level 6
                '수시경쟁률':'competition_susi',
                '정시경쟁률':'competition_jungsi',
                #level 7
                '농어촌학생재학거주인정기준':'note_farming',
                '특성화고교졸업자동일계열기준학과':'note_special',
                '재직기간산정기준':'note_incumbent',
                #level 9
                '서류종합평가':'test_documnet',
                '면접평가':'test_interview',
                '학교생활기록부':'test_records',
                '대학수학능력시험':'test_SAT',
                #level 10
                '재외국민/외국인':'schedule_foreigner',
                '정시':'schedule_jungsi',
                '수시':'schedule_susi',
                #fallback intent
                '잘못된 입력':'fallback'
             }

# preprocess data
intent_keywords=intents.keys() # korean 인텐트 한국어
intent_names=intents.values() # english 인텐트 영어
#intent_levels=

# raw matching
matchings=[]
for user_keyword in extracting.keywords: # extracted keywords from user input
    for intent_keyword in intent_keywords: # intent list from DB
        if intent_keyword in user_keyword: # if extracted keyword contains intent name
            matchings.append(intents[intent_keyword]) 
            print("'"+user_keyword+"' 입력을 '"+intent_keyword + "'에 해당하는 "
                  +intents[intent_keyword]+" 인텐트로 매칭을 성공했습니다.")
            break
            

# matchings 리스트 내 중복 값 제거
matchings=list(dict.fromkeys(matchings))

# matchings 리스트 내 개수가 0이면 fallback 발생
if len(matchings)==0:
    matchings.append(intents['잘못된 입력'])

# show matching results (intents in english)
print(matchings)

# matching된 결과들 레벨에 따라 처리할 것 (intents의 intent_levels 사용)


# cmd 창에서의 출력
