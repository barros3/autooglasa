package br.com.barros.anuncio.carros.busines;

import br.com.barros.anuncio.carros.dao.UserDao;
import br.com.barros.anuncio.carros.dao.utils.DAOFactory;

public class UserBusiness {
 
    private UserDao userDao;      
     
    public UserBusiness() {
        super();
        setUserDao(DAOFactory.createUser());
    }
     
    public boolean existsValidation(String validation) {
        return userDao.existsValidation(validation);
    }
 
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }     
}