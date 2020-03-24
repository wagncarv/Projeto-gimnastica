package br.com.dev.javaee;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/sec/*")
public class SecurityFilter implements Filter {
	
	@Inject
    private UserBean user;
    
    public SecurityFilter() {
        System.out.println("Filtro criado");
    }

	
	public void destroy() {
		System.out.println("Filter destruído");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (user == null || !user.isAuthenticated()) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filtro inicializado");
	}

}
