package br.com.barros.anuncio.carros.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barros.anuncio.carros.busines.OglasaBusiness;
import br.com.barros.anuncio.carros.model.Oglasa;
import br.com.barros.anuncio.carros.model.Profile;
import br.com.barros.anuncio.carros.model.User;
import br.com.barros.anuncio.carros.utils.ManipulateDate;


@ManagedBean(name = "oglasaBean")
@RequestScoped
public class OglasaBean {

	private User user = null;
	private Profile profile = null;
	private Oglasa oglasa = null;
	private List<Oglasa> oglasaList = new ArrayList<Oglasa>();
	
	@PostConstruct
	public void init() {
		user = new User();
		profile = new Profile();
		oglasa = new Oglasa();
	}

	public String save() {
	
		OglasaBusiness oglasaBusiness =  new OglasaBusiness();
		
		oglasa.setModelo(oglasa.getModelo());
		oglasa.setFabricante(oglasa.getFabricante());
		oglasa.setModelo(oglasa.getModelo());
		oglasa.setAno(oglasa.getAno());
		oglasa.setPreco(oglasa.getPreco());
		oglasa.setPotencia(oglasa.getPotencia());
		
		oglasa.setUser(user);
		
		oglasaList.add(oglasa);
		
		user.setOglasaList(oglasaList);

		oglasaBusiness.save(oglasa);
		
		return "/public/feedback_login";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Map<String, Object> getDays() {
		return ManipulateDate.getDays();
	}

	public Map<String, Object> getMonths() {
		return ManipulateDate.getMonths();
	}

	public Map<String, Object> getYears() {
		return ManipulateDate.getYears();
	}
	
	public Oglasa getOglasa() {
		return oglasa;
	}

	public void setOglasa(Oglasa oglasa) {
		this.oglasa = oglasa;
	}

	public List<Oglasa> getOglasaList() {
		return oglasaList;
	}

	public void setOglasaList(List<Oglasa> oglasaList) {
		this.oglasaList = oglasaList;
	}
}