package br.com.barros.anuncio.carros.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
@Entity
@Table(name="oglasa")
@SequenceGenerator(name = "seq", sequenceName = "seq_oglasa", allocationSize = 1, initialValue = 1)
public class Oglasa implements Serializable {
     
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator="seq")
    private Long id;
   
    private double preco;
    
    private String fabricante;
    
    private String modelo;
    
    private int ano;
    
    private String potencia;
    
//    @ManyToOne
//    @JoinColumn(name="user_fk", nullable=true)
    @ManyToOne(cascade=CascadeType.ALL)
    private User user;

    public Oglasa(){
    }
    
	public Oglasa(Long id, double preco, String fabricante, String modelo, int ano, String potencia, User user) {
		super();
		this.id = id;
		this.preco = preco;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.ano = ano;
		this.potencia = potencia;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}