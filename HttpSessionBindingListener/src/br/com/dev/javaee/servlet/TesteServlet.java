package br.com.dev.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dev.javaee.model.Produto;


@WebServlet("/Teste")
public class TesteServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Produto x = new Produto();
		Produto y = new Produto();
		
		session.setAttribute("p1", x);
		session.setAttribute("p2", y);
		
		response.setContentType("text/plain");
		
		try(PrintWriter out = response.getWriter()) {
			out.print(String.format("Primeiro produto: %s \n", x.getName()));
			out.print(String.format("Segundo produto: %s", y.getName()));
		}
	}

}
