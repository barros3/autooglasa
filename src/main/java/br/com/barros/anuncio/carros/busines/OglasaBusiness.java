package br.com.barros.anuncio.carros.busines;

import java.util.List;

import br.com.barros.anuncio.carros.dao.OglasaDao;
import br.com.barros.anuncio.carros.dao.utils.DAOFactory;
import br.com.barros.anuncio.carros.model.Oglasa;

public class OglasaBusiness {
 
    private OglasaDao oglasaDao;
     
    public OglasaBusiness() {
        super();
        setOglasaDao(DAOFactory.createOglasa());
    }
 
    public void setOglasaDao(OglasaDao oglasaDao) {
        this.oglasaDao = oglasaDao;
    }     
 
    public Oglasa saveBusiness(Oglasa oglasa){
        return oglasaDao.save(oglasa);
    }
    
    public List<Oglasa> listBusiness(){
    	return oglasaDao.list();
    }
}