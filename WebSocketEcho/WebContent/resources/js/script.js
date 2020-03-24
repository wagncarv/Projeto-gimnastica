var websocket;

function connect() {
	console.log("connect()");
	websocket = new WebSocket("ws://localhost:8080/WebSocketEcho/server");

	websocket.onopen = function(event) {
		console.log("onopen");
	};

	websocket.onerror = function(event) {
		console.log("onerror");
	};

	websocket.onmessage = function(event) {
		console.log("onmessage: " + event.data);
		document.querySelector("#textResponse").innerHTML = event.data;
	};

}

function sendMessage() {
	var text = document.querySelector("#text").value;
	websocket.send(text);
}

function closeWebsocket() {
	document.querySelector("#textResponse").innerHTML = "Fim da conexão!";
	websocket.close();
}

window.onload = connect;