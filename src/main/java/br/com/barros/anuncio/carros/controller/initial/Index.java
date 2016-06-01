package br.com.barros.anuncio.carros.controller.initial;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.barros.anuncio.carros.busines.OglasaBusiness;
import br.com.barros.anuncio.carros.dao.OglasaDao;

@RequestScoped
@ManagedBean
public class Index {

	@PostConstruct
	public void init() {
		System.out.println("Bean executado!");
	}

	public String login(){
		return "/public/login.xhtml";
	}
	
	public String index(){
		return "/public/index.xhtml";
	}
	
	public String getMessage() {
		return "Hello World JSF!";
	}

	public String register() {
		return "/public/register.xhtml";
	}
	
	public String oglasa() {
		return "/user_common/oglasa.xhtml";
	}
	
	public String logout(){
		return "/public/index.xhtml";
	}
	
	public String principal(){
		return "/user_common/principal.xhtml";
	}
}