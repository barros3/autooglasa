package br.com.barros.anuncio.carros.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barros.anuncio.carros.busines.OglasaBusiness;
import br.com.barros.anuncio.carros.busines.UserBusiness;
import br.com.barros.anuncio.carros.model.Oglasa;
import br.com.barros.anuncio.carros.model.Profile;
import br.com.barros.anuncio.carros.model.User;
import br.com.barros.anuncio.carros.utils.ManipulateDate;


@ManagedBean(name = "oglasaBean")
@RequestScoped
public class OglasaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private User user;
	private Profile profile = null;
	private Oglasa oglasa = null;
	private List<Oglasa> oglasaList = null;
	private List<Oglasa> oglasaListPublic = null;
	
	@PostConstruct
	public void init() {
		profile = new Profile();
		oglasa = new Oglasa();
		oglasaList = new ArrayList<Oglasa>();
		oglasaListPublic = new ArrayList<Oglasa>();
	}
	
	public String save() {
	
		try {
			OglasaBusiness oglasaBusiness =  new OglasaBusiness();
			UserBusiness  userBusiness = new UserBusiness();
			
			// PEGO O USUARIO DA SESSAO
			user = userBusiness.getUserLogado();		
			
			//	POPULA O OGLASA
			oglasa.setModelo(oglasa.getModelo());
			oglasa.setFabricante(oglasa.getFabricante());
			oglasa.setAno(oglasa.getAno());
			oglasa.setPreco(oglasa.getPreco());
			oglasa.setPotencia(oglasa.getPotencia());
			oglasa.setUser(user);
			
			//	PERSISTE O OGLASA
			oglasaBusiness.saveBusiness(oglasa);
			
			//	ADICIONA O OGLASA PERSISTIDO NA LISTA DE OGLASA DO USUARIO
			oglasaList.add(oglasa);
			user.setOglasa(oglasaList);
			
			// PERSISTE O USUARIO
			userBusiness.mergeBusiness(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("TAG ERRO OGLASA");
		}

		return "/user_common/principal";
	}
	
//	OglasaBusiness oglasaBusiness = new OglasaBusiness();
//	public List<Oglasa> listOglasaPublic(){
//		return oglasaListPublic = oglasaBusiness.listBusiness();
//	}
	
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

	public List<Oglasa> getOglasaListPublic() {
		return oglasaListPublic;
	}

	public void setOglasaListPublic(List<Oglasa> oglasaListPublic) {
		this.oglasaListPublic = oglasaListPublic;
	}
	
}