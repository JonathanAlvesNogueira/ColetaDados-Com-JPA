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
@Table(name = "nome da sua tabela")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	@Column(length = 50, nullable = false)
	String nome;
	@Column(length = 11, nullable = false)
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
		// Cria uma instância do EntityManagerFactory utilizando o nome da unidade de
		// persistência "obtem-usuario"
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("obtem-usuario");
		// incia o entity Manager
		EntityManager em = emf.createEntityManager();

		// Busca um objeto Usuario no banco de dados a partir do ID informado
		Usuario usu = em.find(Usuario.class, id);

		// Verifica se o objeto foi encontrado
		if (usu != null) {
			System.out.println("Id" + usu.getId() + " CPF:" + usu.getCpf() + " Nome: " + usu.getNome());
		} else {
			System.out.println("Usuario não existe");
		}

		// fecha a conexão
		em.close();
		emf.close();

	}

	public void obtemDadoPorNome(String nome) {

		// Cria uma instância do EntityManagerFactory utilizando o nome da unidade de
		// persistência "obtem-usuario"
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("obtem-usuario");
		EntityManager em = emf.createEntityManager();
		// Cria uma consulta para buscar o objeto Usuario a partir do nome informado
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where u.nome = :nome", Usuario.class);

		// verifica se a consulta achou o resultado 
		if (query != null) {
			query.setParameter("nome", nome);
			Usuario nomeCompleto = query.getSingleResult();
			System.out.println("Esse é o ID do Usuario" + nomeCompleto.getId() + "Esse é o nome do usuario "
					+ nomeCompleto.getNome() + "Esse é o cpf do Usuario" + nomeCompleto.getCpf());
		} else {
			System.out.println("Não existe esse usuario");
		}

	}

}
