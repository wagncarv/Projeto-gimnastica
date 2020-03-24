package br.com.dev.javaee.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MeuListener implements ServletRequestListener {

  
	
    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("Request destruída");
    }

	
    public void requestInitialized(ServletRequestEvent event)  { 
         System.out.println("Request inicializada");
         
         HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
         request.setAttribute("name", "Wagner");
    }
	
}
