package br.com.barros.anuncio.carros.busines;

import javax.faces.bean.SessionScoped;

import br.com.barros.anuncio.carros.dao.UserDao;
import br.com.barros.anuncio.carros.dao.utils.DAOFactory;
import br.com.barros.anuncio.carros.model.User;

@SessionScoped
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
    
    // MUDANCA
    
    private User user;
    
    public User mergeBusiness(User user){
    	return userDao.merge(user);
    }
    
    public User persistBusiness(User user){
    	return userDao.merge(user);
    }
    
    public User getUserLogado() {
    	this.user = userDao.getUserSession();
        return user;
        
    }
}