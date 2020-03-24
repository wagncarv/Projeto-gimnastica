window.onload = connect;

var websocket;
var path = "ws://localhost:8080/WebSocketEncodersDecoders";
function connect() {
	websocket = new WebSocket(path + "/notification");

	websocket.onopen = function(event) {
		console.log("onopen()");
	};

	websocket.onmessage = function(event) {
		console.log("onmessage()");

		var json = JSON.parse(event.data);
		document.getElementById("time").innerHTML = json.time;
		document.getElementById("id").innerHTML = json.assignedId;
	};

	websocket.onerror = function(event) {
		console.log("onerror()");
	};
}

function closeWebsocket() {
	websocket.close();
}

function send() {
	var titleElem = document.getElementById("title");
	var contentElem = document.getElementById("content");

	var json = {
		"title" : titleElem.value,
		"content" : contentElem.value
	};

	websocket.send(JSON.stringify(json));

	titleElem.value = "";
	contentElem.value = "";
}