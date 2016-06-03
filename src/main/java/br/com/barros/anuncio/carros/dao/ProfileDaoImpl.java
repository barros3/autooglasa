package br.com.barros.anuncio.carros.dao;

import org.hibernate.Session;

import br.com.barros.anuncio.carros.model.Profile;
 
public class ProfileDaoImpl implements ProfileDao {
 
    private Session session;
 
    public void setSession(Session session) {
        this.session = session;
    }
     
    // @Override
    public void save(Profile profile) {
        this.session.saveOrUpdate(profile);
    }
}