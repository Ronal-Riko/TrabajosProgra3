package com.Ronaal.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import web.ronal.model.Inventario;



public class ProductoDAO {

	
public List<Inventario> productoLista(){
		
		List<Inventario>listacl = new ArrayList<>();
		
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("iniciando-HIBERNATE-JPA");
		em=emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			listacl= em.createQuery("from Inventario").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return listacl;
	}
	
	
	public void agregarDatos(Inventario in) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("iniciando-HIBERNATE-JPA");
		em=emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(in);
		em.flush();
		em.getTransaction().commit();
		
	}
	
	public void actualizarDatos(Inventario in) {
		
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("iniciando-HIBERNATE-JPA");
		em=emf.createEntityManager();
		in.getId();
		in.getNombreProducto();
		in.getPrecioProducto();
		in.getCantidadProducto();
		in.getTotalProducto();
		em.getTransaction().begin();
		em.merge(in);
		em.flush();
		em.getTransaction().commit();
	}
	
	
	public void eliminarDatos(Inventario in) {
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("iniciando-HIBERNATE-JPA");
		em=emf.createEntityManager();
		in=em.getReference(Inventario.class, in.getId());
		em.getTransaction().begin();
		em.remove(in);
		em.flush();
		em.getTransaction().commit();
		
	}
}
