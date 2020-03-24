var websocket;

function connect() {
	websocket = new WebSocket("ws://localhost:8080/WebSocketChat/chat");

	websocket.onopen = function(event) {
		console.log("onopen()");
		
		var msg = "!C!" + document.querySelector("#name").value;
		websocket.send(msg);
		
		document.querySelector("#chat").style.display = "block" ;
		document.querySelector("#name").disabled = true;
		document.querySelector("#btnConnect").disabled = true;
		document.querySelector("#message").focus();
	};

	websocket.onerror = function(event) {
		console.log("onerror()");
	};

	websocket.onmessage = function(event) {
		console.log("onmessage()");
		
		var elem = document.querySelector("#messages");
		
		elem.value += event.data + "\n";
	};

}

function closeWebsocket() {
	websocket.close();
	
	document.querySelector("#chat").style.display = "none" ;
	document.querySelector("#messages").value = "";
	document.querySelector("#name").disabled = false;
	document.querySelector("#name").value = "";
	document.querySelector("#name").focus();
	document.querySelector("#btnConnect").disabled = false;
}

function sendMessage() {
	var msg = document.querySelector("#message");
	websocket.send(msg.value);
	
	msg.value = "";
	msg.focus();
}