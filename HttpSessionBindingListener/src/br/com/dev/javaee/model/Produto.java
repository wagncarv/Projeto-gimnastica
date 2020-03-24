package br.com.dev.javaee.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Produto implements HttpSessionBindingListener {
	
	private String name;
	
	public String getName() {
		return name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		this.name = event.getName();
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		this.name = null;
	}
	
	

}
