#extracting keywords from the input sentence of user
import pandas as pd
from soynlp.utils import DoublespaceLineCorpus
from soynlp.word import WordExtractor
from soynlp.tokenizer import MaxScoreTokenizer
import json

#load data for training..*will be modified with DB
training=pd.read_csv("example.CSV", encoding="euc-kr")
training=pd.DataFrame(training['content'])

'''
#단락 구분하기
contents=[]
for i in training:
    i=' '.join(i.split())
    contents.append(i)
    training=pd.DataFrame(contents)
'''
#write .txt file
f = open("training.txt", 'wt', encoding='utf-8')
for i in  range(0, 100):
    data = training.loc[i].to_string()
    f.write(data+'\n')
f.close()

#counting txt file's line number
corpus = DoublespaceLineCorpus("training.txt")
print("text file's line number is ", len(corpus))

'''
#load json (DB)
with open('C:\\test.json', 'r') as f:
    json_data = json.load(f)
print(json.dumps(json_data, indent="\t") )
'''

#corpus training
word_extractor = WordExtractor()
word_extractor.train(corpus)
word_score_table = word_extractor.extract()

scores = {word:score.cohesion_forward for word, score in word_score_table.items()}
maxscore_tokenizer = MaxScoreTokenizer(scores=scores)
words=[]
words=maxscore_tokenizer.tokenize("두드림소프트웨어가 궁금해")
print(words)


#look at DB and extracting the only keywords what you need
keywords=[]
for word in words:
    if ('두드림' in word) or ('소프트웨어' in word)==True : #will be modified w/ DB
        #keywords에는 조사를 뺀 word가 들어가야하는데 문제점 발생! -> 소프트웨어 뒤에 붙은 조사 '가'가 분리가 안됩니다...
        keywords.append(word)
        
#extracted keywords
print(keywords)