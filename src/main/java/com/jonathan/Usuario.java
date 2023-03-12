package com.jonathan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "numero")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	@Column(length = 50, nullable=false)
	String nome;
	@Column(length = 11, nullable=false)
	String cpf;
	
	
	
	public Usuario() {
		super();
	}
	
	
	public Usuario(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public void obtemDadoPorId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("obtem-usuario");
		EntityManager em = emf.createEntityManager();
		
		
		Usuario usu = em.find(Usuario.class, id);
		if(usu != null) {
			System.out.println("Id" + usu.getId() + " CPF:" + usu.getCpf() + " Nome: " + usu.getNome());
		}else {
			System.out.println("Usuario não existe");
		}
		
		em.close();
		emf.close();
		
	}
	public void obtemDadoPorNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("obtem-usuario");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where u.nome = :nome",Usuario.class);
		if(query != null ) {
		
		query.setParameter("nome", nome);
		Usuario nomeCompleto = query.getSingleResult();
		System.out.println("Esse é o ID do Usuario" + nomeCompleto.getId() + "Esse é o nome do usuario " + nomeCompleto.getNome() + "Esse é o cpf do Usuario" + nomeCompleto.getCpf());
	}else {
		System.out.println("Não existe esse usuario");
	}
		
		
	}
	
	
	
	
	
	
}


