package br.com.barros.anuncio.carros.dao;

import br.com.barros.anuncio.carros.model.User;
 
public interface UserDao {
     public boolean existsValidation(String validation);
     public void save(User user);
}