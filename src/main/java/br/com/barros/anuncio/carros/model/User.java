package br.com.barros.anuncio.carros.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NaturalId;
 
@Entity
@Table(name="user_ofoka")
@SequenceGenerator(name = "seq", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class User implements Serializable {
     
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator="seq")
    private Long id;
    @NaturalId
    private String login;
    private String password;    
    private Boolean active;
    private String validation;
     
    @ElementCollection(targetClass = String.class)
    @JoinTable(name = "user_permission",
               uniqueConstraints = { @UniqueConstraint (columnNames = {"id", "permission" })},
               joinColumns = @JoinColumn(name = "id"))
    @Column(name = "permission", length = 40)
    @Cascade(CascadeType.DELETE)
    private Set<String> permissions = new HashSet<String>();   
    
//    @OneToMany(targetEntity = Oglasa.class, mappedBy="id", cascade=javax.persistence.CascadeType.ALL)
//    private Set<Oglasa> oglasaList;
    
    @OneToMany(cascade=javax.persistence.CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="user_has_oglasa", 
		    joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
		    inverseJoinColumns={@JoinColumn(name="oglasa_id", referencedColumnName="id")})
    private List<Oglasa> oglasa;
    
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public Boolean isActive() {
        return active;
    }
 
    public void setActive(Boolean active) {
        this.active = active;
    }    
 
    public Set<String> getPermissions() {
        return permissions;
    }
 
    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
 
    public Boolean getActive() {
        return active;
    }
 
    public String getValidation() {
        return validation;
    }
 
    public void setValidation(String validation) {
        this.validation = validation;
    }    
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

	public List<Oglasa> getOglasa() {
		return oglasa;
	}

	public void setOglasa(List<Oglasa> oglasa) {
		this.oglasa = oglasa;
	}

//	public Set<Oglasa> getOglasaList() {
//		return oglasaList;
//	}
//
//	public void setOglasaList(Set<Oglasa> oglasaList) {
//		this.oglasaList = oglasaList;
//	}
//	
//	public void addOglasa(Oglasa oglasa){
//		oglasaList.add(oglasa);
//		oglasa.setUser(this);
//	}
  }