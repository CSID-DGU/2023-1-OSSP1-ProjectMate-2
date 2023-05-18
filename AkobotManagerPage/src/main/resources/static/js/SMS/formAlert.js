$(document).ready(function(){
    //submit 버튼이 눌렸을 때
    $("#submit").click(function(){
        if(!$(':radio[name="smsType"]:checked')){
            alert("발송 타입을 선택하세요");
            $("#smsType").focus();
            return false;
        }
        if($("#limit_reply_title").val().length == 0){
            alert("답변의 제목을 입력해주세요");
            $("#limit_reply_title").focus();
            return false;
        }
        if($("#limit_text").val().length == 0){
            alert("메시지 내용을 입력해주세요");
            $("#limit_text").focus();
            return false;
        }
        if($("#Rphone").val().length == 0){
            alert("받으시는 분의 번호를 확인해주세요");
            $("#Rphone").focus();
            return false;
        }

    });

});