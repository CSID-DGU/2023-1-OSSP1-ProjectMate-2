$(document).ready(function(){
    //submit 버튼이 눌렸을 때
    $("#submit").click(function(){
        if($("#userEmail").val().length == 0){
            alert("이메일을 확인해 주세요!");
            $("#userEmail").focus();
            return false;
        }
        if($("#title").val().length == 0){
            alert("답변 메일의 제목을 입력해주세요");
            $("#title").focus();
            return false;
        }
        if($("#limit_text").val().length == 0){
            alert("답변 메일의 내용을 입력해주세요");
            $("#limit_text").focus();
            return false;
        }
        // valid check
        var form = document.getElementById('mailForm');
        if (form.checkValidity()) {
            alert("메일 전송이 완료되었습니다!");
        }else{
            alert("메일을 다시 확인해주세요.")
        }
    });

});