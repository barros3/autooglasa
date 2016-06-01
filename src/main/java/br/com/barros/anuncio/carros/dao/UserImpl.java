package br.com.barros.anuncio.carros.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.barros.anuncio.carros.model.User;
 
public class UserImpl implements UserDao {
 
    private Session session;
 
    public void setSession(Session session) {
        this.session = session;
    }
  
    @Override
    public boolean existsValidation(String validation) {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("validation", validation));        
        User user = (User) criteria.uniqueResult();
         
        if(user != null){
            user.setActive(true);
            user.setValidation("");
            save(user);
            return true;
        }        
        return false;
    }
    public void save(User user){
        session.saveOrUpdate(user);
    }
    
	@Override
	public User persist(User user) {
		session.persist(user);
		return user;
	}

	@Override
	public User merge(User user) {
		session.merge(user);
		return user;
	}
	
	@Override
	public User find(User user) {
		session.get(User.class, user.getId());
		return user;
	}

	@Override
	public User getUserSession() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String login = ((UserDetails)principal).getUsername();
		String password = ((UserDetails)principal).getPassword();
		
		String hqlLoginAndSenhaUserSession = "from User u where u.login like :login and u.password like :password";
		User user = new User();
		user = (User) session.createQuery(hqlLoginAndSenhaUserSession).setParameter("login", login).setParameter("password", password).uniqueResult();
		
		return user;

	}
}