package br.com.barros.anuncio.carros.busines;

import br.com.barros.anuncio.carros.dao.OglasaDao;
import br.com.barros.anuncio.carros.dao.ProfileDao;
import br.com.barros.anuncio.carros.dao.utils.DAOFactory;
import br.com.barros.anuncio.carros.model.Oglasa;
import br.com.barros.anuncio.carros.model.Profile;

public class OglasaBusiness {
 
    private OglasaDao oglasaDao;      
     
    public OglasaBusiness() {
        super();
        setOglasaDao(DAOFactory.createOglasa());
    }
 
    public void setOglasaDao(OglasaDao oglasaDao) {
        this.oglasaDao = oglasaDao;
    }     
 
    public void save(Oglasa oglasa){
        oglasaDao.save(oglasa);
    }    
}