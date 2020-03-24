package br.com.dev.javaee;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(loadOnStartup = 3, name = "Init2")
public class Init2Servlet extends HttpServlet {
	       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		System.out.println("Servlet 2 inicializado");
		
		String email = config.getInitParameter("adminEmail");
		System.out.println(String.format("%s %s", "adminEmail: ", email));
	}

}
