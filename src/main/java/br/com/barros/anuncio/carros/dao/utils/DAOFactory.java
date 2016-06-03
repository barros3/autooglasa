package br.com.barros.anuncio.carros.dao.utils;

import br.com.barros.anuncio.carros.dao.OglasaDao;
import br.com.barros.anuncio.carros.dao.OglasaImpl;
import br.com.barros.anuncio.carros.dao.ProfileDao;
import br.com.barros.anuncio.carros.dao.ProfileDaoImpl;
import br.com.barros.anuncio.carros.dao.UserDao;
import br.com.barros.anuncio.carros.dao.UserImpl;

public class DAOFactory {
 
    public static ProfileDao createProfile(){
        ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();
        profileDaoImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return profileDaoImpl;
    }
    
    public static UserDao createUser(){
        UserImpl userImpl = new UserImpl();
        userImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return userImpl;
    }
    
    public static OglasaDao createOglasa(){
    	OglasaImpl OglasaImpl = new OglasaImpl();
    	OglasaImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return OglasaImpl;
    }
    
}