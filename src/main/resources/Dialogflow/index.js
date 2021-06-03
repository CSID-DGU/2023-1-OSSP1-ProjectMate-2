 
const functions = require('firebase-functions');
const {WebhookClient} = require('dialogflow-fulfillment');
const {Card, Suggestion} = require('dialogflow-fulfillment');
 
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);
admin.firestore().settings({timestapsInSnapshots:true});

const db = admin.firestore();


process.env.DEBUG = 'dialogflow:debug'; // enables lib debugging statements
 
exports.dialogflowFirebaseFulfillment = functions.https.onRequest((request, response) => {
  const agent = new WebhookClient({ request, response });
  //const queryText = conv.request.body.queryResult;     //사용자 질문 받아서 저장
  const queryText = request.body.queryResult.queryText;     //사용자 질문 받아서 저장
  console.log('Dialogflow Request headers: ' + JSON.stringify(request.headers));
  console.log('Dialogflow Request body: ' + JSON.stringify(request.body));


  function susi_dodream(agent) {
   
    return db.collection('susi').doc('dodream').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  function susi_dodream_soft(agent) {
   
    return db.collection('susi').doc('dodreamsoft').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  function susi_special(agent) {
   
    return db.collection('susi').doc('special').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  function susi_regular(agent) {
   
    return db.collection('susi').doc('regular').get().then (docu=>{   
      const condition1 = docu.data().condition1;
      const condition2 = docu.data().condition2;
      const condition3 = docu.data().condition3;
      const condition4 = docu.data().condition4;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition1);
      agent.add(condition2);
      agent.add(condition3);
      agent.add(condition4);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
  function susi_incumbent(agent) {
   
    return db.collection('susi').doc('incumbent').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  function susi_essay(agent) {
   
    return db.collection('susi').doc('essay').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
  function susi_principal(agent) {
   
    return db.collection('susi').doc('principal').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
  
  
  function susi_buddhism(agent) {
     return db.collection('susi').doc('buddhism').get().then (docu=>{   
      const condition1 = docu.data().condition1;
      const condition2 = docu.data().condition2;
      const condition3 = docu.data().condition3;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition1);
      agent.add(condition2);
      agent.add(condition3);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
  function jeongsi_normal(agent) {
   
    return db.collection('jungsi').doc('normal').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
  function jeongsi_farming(agent) {
   
    return db.collection('jungsi').doc('farming').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
  function jeongsi_specialized(agent) {
   
    return db.collection('jungsi').doc('specialized').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);   
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
  
  
  function jeongsi_basicliving(agent) {
   
    return db.collection('jungsi').doc('basic').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);   
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
  
  
  function jeongsi_incumbent(agent) {
   
    return db.collection('jungsi').doc('incumbent').get().then (docu=>{   
      const condition = docu.data().condition;
      const point = docu.data().point;
      const test =  docu.data().test;
      
      agent.add(`1.지원자격`);
      agent.add(condition);
      agent.add(`2.전형방법`);
      agent.add(point);
      agent.add(test);    
      agent.add(`또 궁금한 점이 있다면 '아코봇'을 불러줘!`);
    });
  }
  
  
 
  
  
  
  
  
  
  
  
  function elseIntent(agent){
    agent.add(`그외 질문에 관련된 궁금한 점을 "나는 ㅇㅇㅇ가 궁금해" 와 같이 이야기해줘!`);
  }
  
  function user_elseQuestion(agent){ 
    agent.add(`답변 테스트`);
    //agent.add(queryText);
    return db.collection("else").where("question", "==", queryText).get()
      .then(function(querySnapshot) {
        querySnapshot.forEach(function(doc) {
          var answer = doc.data().answer;
          agent.add(answer);      
        });
    })
    .catch(function(error) {
        //error handling 
    });
    
  }
  
  
  let intentMap = new Map();
  
  intentMap.set('susi_dodream', susi_dodream);
  intentMap.set('susi_buddhism', susi_buddhism);
  intentMap.set('susi_dodream_soft', susi_dodream_soft);
  intentMap.set('susi_special', susi_special);
  intentMap.set('susi_regular', susi_regular);
  intentMap.set('susi_incumbent', susi_incumbent);
  intentMap.set('susi_essay', susi_essay);
  intentMap.set('susi_principal', susi_principal);
  
  intentMap.set('jeongsi_normal', jeongsi_normal);
  intentMap.set('jeongsi_farming', jeongsi_farming);
  intentMap.set('jeongsi_specialized', jeongsi_specialized);
  intentMap.set('jeongsi_basicliving', jeongsi_basicliving);
  intentMap.set('jeongsi_incumbent', jeongsi_incumbent);
  
  
  intentMap.set('elseIntent', elseIntent);
  intentMap.set('user_elseQuestion', user_elseQuestion);
  agent.handleRequest(intentMap);
});
