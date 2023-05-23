#intent matching 하기
import pandas as pd
import extracting

# load intent data.*will be modified with DB
data=pd.read_csv("simple.CSV", encoding="utf-8")
intents=data.iloc[:,0:2]

# preprocess data
intent_names=intents[intents.columns[1]].to_list()
intent_levels=intents[intents.coulumns[0]].to_list()

# raw matching
matchings=[]
for keyword in extracting.keywords: #extracted keywords from user input
    for intent_name in intent_names: #intent list from DB
        if intent_name in keyword: #if extracted keyword contains intent name
            matchings.append(intent_names) 
            print(intent_names+ "인텐트로 매칭이 성공했습니다.")
            break

print(matchings) #show matching results
'''
matching되지 않은 키워드들은 fall back intent 하나만 matching list에 append
matchings.append(["fallback"])
'''

'''
matching된 결과들 레벨에 따라 처리할 것
#intents의 intent_levels 사용
'''
