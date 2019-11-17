package com.codetrimix.apptest.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codetrimix.apptest.model.dao.PersonaDAO;
import com.codetrimix.apptest.model.dominio.Persona;


@Repository
public class PersonaDAOImpl implements PersonaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Persona persona) {		
		sessionFactory.getCurrentSession().save(persona);
	}

	@Override
	public void edit(Persona persona) {
		sessionFactory.getCurrentSession().update(persona);
	}

	@Override
	public void delete(Long idPersona) {
		sessionFactory.getCurrentSession().delete(getPersona(idPersona));
	}

	@Override
	public Persona getPersona(Long idPersona) {		
		return (Persona)sessionFactory.getCurrentSession().get(Persona.class, idPersona);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getAll() {
		Session session = sessionFactory.openSession();
		return (List<Persona>)session.createQuery("FROM Persona p ORDER BY p.perId").getResultList();
	}
	
	public List<Persona> getPersonasByFiltro(String nombre, String tipoDocumento) {
		CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
		Root<Persona> personaRoot = criteriaQuery.from(Persona.class);
		Predicate nombreCondition = criteriaBuilder.like(personaRoot.get("perNombre"), "%"+nombre+"%");
		Predicate tipoCondition = criteriaBuilder.like(personaRoot.get("perTipoDocumento"), tipoDocumento);
		criteriaQuery.where(criteriaBuilder.and(nombreCondition, tipoCondition));
		TypedQuery<Persona> tipedQuery = sessionFactory.getCurrentSession().createQuery(criteriaQuery);
		return tipedQuery.getResultList();
	}

}
