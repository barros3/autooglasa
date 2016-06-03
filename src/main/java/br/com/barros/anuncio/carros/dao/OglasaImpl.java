package br.com.barros.anuncio.carros.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import br.com.barros.anuncio.carros.dao.utils.HibernateUtil;
import br.com.barros.anuncio.carros.model.Oglasa;

@SessionScoped
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

	// @Override
	// public void remove(Oglasa oglasa) {
	// session.delete(oglasa);
	// }

	// metodo atualizado, testar
	@Override
	public void remove(Long id) {
		session.delete(session.get(Oglasa.class, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Oglasa> list() {

		List<Oglasa> oglasaList = new ArrayList<Oglasa>();
		
		try {

			String hqlOglasaList = "from Oglasa u";
			oglasaList = (List<Oglasa>) session.createQuery(hqlOglasaList).list();
			
		} catch (Exception e) {
//			e.getCause();
			session = HibernateUtil.getSessionFactory().getCurrentSession();
		}finally{
			String hqlOglasaList = "from Oglasa u";
			oglasaList = (List<Oglasa>) session.createQuery(hqlOglasaList).list();
		}
		return oglasaList;
	}

	@Override
	public void merge(Oglasa oglasa) {
		session.merge(oglasa);
	}

	@Override
	public Oglasa save(Oglasa oglasa) {
		session.save(oglasa);
		return oglasa;
	}

}