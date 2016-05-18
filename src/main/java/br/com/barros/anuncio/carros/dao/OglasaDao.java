package br.com.barros.anuncio.carros.dao;

import java.util.List;

import br.com.barros.anuncio.carros.model.Oglasa;
 
public interface OglasaDao {
     public boolean existsValidation(String validation);
     public void save(Oglasa oglasa);
     public void update(Oglasa oglasa);
     public List<Oglasa> list();
     public void remove(Oglasa oglasa);
}