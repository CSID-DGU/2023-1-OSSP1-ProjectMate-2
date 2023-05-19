#extracting keywords from the input sentence of user
import pandas as pd
from soynlp.utils import DoublespaceLineCorpus
from soynlp.word import WordExtractor
from soynlp.tokenizer import MaxScoreTokenizer
import json

#load data for training..*will be modified with DB
training=pd.read_csv("simple.CSV", encoding="euc-kr")
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
for i in  range(0, 29):
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
words=maxscore_tokenizer.tokenize("두드림소프트웨어알려줄래??")
print(words)


#look at DB and extracting the only keywords what you need
keywords=[]
for word in words:
    if word=='두드림소프트웨어': #will be modified w/ DB
        keywords.append(word)

#extracted keywords
print(keywords)