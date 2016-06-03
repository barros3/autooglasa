package br.com.barros.anuncio.carros.busines;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.barros.anuncio.carros.model.Oglasa;

@ApplicationScoped
@ManagedBean(name = "oglasaService")
public class OglasaBusinessService {
	
	@Autowired
	private OglasaBusiness oglasaBusiness;
	
	@PostConstruct
	public void init(){
		oglasaBusiness = new OglasaBusiness();
	}
	
	public List<Oglasa> createOglasas() {
		List<Oglasa> list = oglasaBusiness.listBusiness();
		List<Oglasa> listExibe = new ArrayList<Oglasa>();
		for(int i = 0; i < list.size(); i++){
			listExibe.add(new Oglasa(list.get(i).getId(), list.get(i).getPreco(), list.get(i).getFabricante(), list.get(i).getModelo(),
					list.get(i).getAno(), list.get(i).getPotencia(), list.get(i).getUser()));
		}
		return listExibe;
	}

}
