package br.com.dev.javaee.websocket;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/server")
public class EchoEndpoint {

	@OnOpen
	public void onOpen(Session arg0, EndpointConfig config) {
		System.out.println("Conex�o aberta!");
		
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println("Conex�o fechada!");
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.out.println("Erro!");
		throwable.printStackTrace();
	}
	
	@OnMessage
	public void onMessage(Session session, String message) throws IOException{
		System.out.println("Mensagem recebida: " +  message);
		
		session.getBasicRemote().sendText(message);
	}
	
	

}
