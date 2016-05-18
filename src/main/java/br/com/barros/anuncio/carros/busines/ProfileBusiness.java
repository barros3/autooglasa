package br.com.barros.anuncio.carros.busines;

import br.com.barros.anuncio.carros.dao.ProfileDao;
import br.com.barros.anuncio.carros.dao.utils.DAOFactory;
import br.com.barros.anuncio.carros.model.Profile;

public class ProfileBusiness {
	
	private ProfileDao profileDao;
    
    public ProfileBusiness() {
        super();
        setProfileDao(DAOFactory.createProfile());
    }    
     
    private void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }
 
    public void save(Profile profile){
        profileDao.save(profile);
    }    
}
