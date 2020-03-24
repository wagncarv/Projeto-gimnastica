package br.com.dev.javaee.websocket;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
public class ChatEndpoint {
	
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<>();
	
	@OnOpen
	public void connected(Session session, EndpointConfig config)throws IOException {
		System.out.println("connected()");
		sessions.add(session);

	}

	@OnClose
	public void disconnected(Session session, CloseReason closeReason)throws IOException {
		System.out.println("disconnected()");
		sessions.remove(session);
		String name = (String) session.getUserProperties().get("name");
		broadcast(name + " saiu do chat!");
	}
	

	@OnError
	public void error(Session session, Throwable throwable)throws IOException {
		System.out.println("error(): " + throwable);
	}

	@OnMessage
	public void messageReceived(Session session, String message)throws IOException, EncodeException {
		if (message.trim().length() == 0) {
			return;
		}
		
		System.out.println("messageReceived(): " + message);
		
		if (message.startsWith("!C!")) {
			String name = message.substring(3);
			session.getUserProperties().put("name", name);
			broadcast(" "+ name + " entrou no chat!");
		}else {
			LocalTime now = LocalTime.now();
			String name = (String) session.getUserProperties().get("name");
			String formattedMessage = String.format(" %tH:%tM:%tS - %s disse: %s ", now, now, now, name, message);
			broadcast(formattedMessage);
		}
	}
	
	private void broadcast(String message)throws IOException {
		for (Session session : sessions) {
			session.getBasicRemote().sendText(message);
		}
	}

}
