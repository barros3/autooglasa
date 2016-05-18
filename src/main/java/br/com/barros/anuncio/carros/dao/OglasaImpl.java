package br.com.barros.anuncio.carros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barros.anuncio.carros.model.Oglasa;
 
public class OglasaImpl implements OglasaDao {
 
    private Session session;
 
    public void setSession(Session session) {
        this.session = session;
    }

	@Override
	public boolean existsValidation(String validation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Oglasa oglasa) {
		session.save(oglasa);
	}

	@Override
	public void update(Oglasa oglasa) {
		session.update(oglasa);
	}


	@Override
	public void remove(Oglasa oglasa) {
		session.delete(oglasa);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Oglasa> list() {
		Query createQuery = session.createQuery("SELECT * FROM oglasa");
		List<Oglasa> oglasaList = (List<Oglasa>) createQuery;
		return oglasaList;
	}
  
}