$(document).ready(function(){
    //해당 textarea 태그의 id값
    $('#limit_text').on('keyup', function(){
        //입력 글자수 보여주는 부분
        $('#text_cnt').html("("+$(this).val().length+" / 2000)");
        //최대 LMS 2000바이트
        if($(this).val().length>2000){
            $(this).val($(this).val().substring(0,2000));
            $('#text_cnt').html("(2000 / 2000)");
        }
    });
    //해당 input label 태그의 id값
    $('#limit_reply_title').on('keyup', function(){
        //입력 글자수 보여주는 부분
        $('#reply_title_cnt').html("("+$(this).val().length+" / 30)");
        //최대 LMS 2000바이트
        if($(this).val().length>30){
            $(this).val($(this).val().substring(0,30));
            $('#text_cnt').html("(30 / 30)");
        }
    });
});