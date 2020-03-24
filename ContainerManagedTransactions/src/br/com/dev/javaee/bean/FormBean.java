package br.com.dev.javaee.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.dev.javaee.ejb.MyBean;

@Named
@RequestScoped
public class FormBean implements Serializable {

	@EJB
	private MyBean myBean;
	
	public String executar() {
		myBean.mA();
		return null;
	}
}
