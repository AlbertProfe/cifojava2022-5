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
    $("#response").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        setConnected(true);
        console.log('Connected: ' + frame);
        showConnections(frame);
        stompClient.subscribe('/message/response', function (textmessage) {
			console.log('Response from server: ' + textmessage);
            showTextMessage(JSON.parse(textmessage.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    showConnections("Disconnected");
    console.log("Disconnected");
}

function sendText() {
	console.log('About to send: ' + $("#contenttosend").val()  );
    stompClient.send("/app/sendmessage", {}, JSON.stringify({'content': $("#contenttosend").val()}));
}

function showTextMessage(message) {
	console.log('Response from server: ' + message);
    $("#response").append("<tr><td>" + message + "</td></tr>");
}

function showConnections(message) {
    $("#connectionstatusline").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendText(); });
});