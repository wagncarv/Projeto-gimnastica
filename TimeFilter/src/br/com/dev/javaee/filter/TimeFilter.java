package br.com.dev.javaee.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class TimeFilter implements Filter {

	public TimeFilter() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		long start = System.currentTimeMillis();

		chain.doFilter(request, response);

		long end = System.currentTimeMillis();

		long time = end - start;

		try (PrintWriter out = new PrintWriter(new FileWriter("C:/Java/Testes/time.txt", true))) {
			out.print(req.getRequestURI() + ": time = " + time + "ms\n");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {

	}

}
