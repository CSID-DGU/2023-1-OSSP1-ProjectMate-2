var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (answering) {
            //showGreeting(JSON.parse(answering.body));
            showGreeting(JSON.parse(answering.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    $("#greetings").append("<tr style=\"text-align:right\"><td>USER</td></tr>");
    $("#greetings").append("<tr style=\"text-align:right\"><td>" + $("#ask").val() + "</td></tr>");
    stompClient.send("/app/hello", {}, JSON.stringify({'ask': $("#ask").val()}));
}

function showGreeting(messages) {
    $("#greetings").append("<tr><td>SERVER</td></tr>");
    for(i = 0; i < messages.length; i++){
        $("#greetings").append("<tr><td>" + messages[i].says + "</td></tr>");
    }
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});