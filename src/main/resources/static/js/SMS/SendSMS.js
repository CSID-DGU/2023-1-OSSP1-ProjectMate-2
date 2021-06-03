function setPhoneNumber(val) {
    var numList = val.split("-");
    document.smsForm.sphone1.value = numList[0];
    document.smsForm.sphone2.value = numList[1];
    if (numList[2] != undefined) {
        document.smsForm.sphone3.value = numList[2];
    }
}
function loadJSON() {
    var data_file = "/calljson.jsp";
    var http_request = new XMLHttpRequest();
    try {
        // Opera 8.0+, Firefox, Chrome, Safari
        http_request = new XMLHttpRequest();
    } catch (e) {
        // Internet Explorer Browsers
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");

        } catch (e) {

            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                // Eror
                alert("지원하지 않는브라우저!");
                return false;
            }

        }
    }
    http_request.onreadystatechange = function () {
        if (http_request.readyState == 4) {
            // Javascript function JSON.parse to parse JSON data
            var jsonObj = JSON.parse(http_request.responseText);
            if (jsonObj['result'] == "Success") {
                var aList = jsonObj['list'];
                var selectHtml = "<select name=\"sendPhone\" onchange=\"setPhoneNumber(this.value)\">";
                selectHtml += "<option value='' selected>발신번호를 선택해주세요</option>";
                for (var i = 0; i < aList.length; i++) {
                    selectHtml += "<option value=\"" + aList[i] + "\">";
                    selectHtml += aList[i];
                    selectHtml += "</option>";
                }
                selectHtml += "</select>";
                document.getElementById("sendPhoneList").innerHTML = selectHtml;
            }
        }
    }
    http_request.open("GET", data_file, true);
    http_request.send();
}
