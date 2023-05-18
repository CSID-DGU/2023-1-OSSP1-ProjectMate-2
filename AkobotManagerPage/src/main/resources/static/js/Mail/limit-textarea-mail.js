$(document).ready(function () {
    //메일 제목 길이 제한 255 bytes
    $('#title').on('keyup', function () {
        //입력 글자수 보여주는 부분
        $('#reply_title_cnt').html("(" + $(this).val().length + " / 255 bytes)");
        //최대 255 bytes
        if ($(this).val().length > 255) {
            $(this).val($(this).val().substring(0, 255));
            alert("메일의 제목은 255 bytes가 최대입니다.");
            $('#text_cnt').html("(255 / 255)");
        }
    });
});