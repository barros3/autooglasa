package br.com.barros.anuncio.carros.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.barros.anuncio.carros.busines.OglasaBusinessService;
import br.com.barros.anuncio.carros.model.Oglasa;

@ManagedBean(name="dtPaginatorView")
@ViewScoped // view
public class PaginatorView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Oglasa> oglasa;
    
    @ManagedProperty("#{oglasaService}")
    private OglasaBusinessService oglasaService;
 
    @PostConstruct
    public void init() {
    	oglasa = oglasaService.createOglasas();
    }
     
    public List<Oglasa> getOglasa() {
        return oglasa;
    }
 
    public void setOglasaService(OglasaBusinessService oglasaservice) {
        this.oglasaService = oglasaservice;
    }
}
