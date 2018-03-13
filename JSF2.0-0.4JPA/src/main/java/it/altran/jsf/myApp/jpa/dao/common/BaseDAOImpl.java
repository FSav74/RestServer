package it.altran.jsf.myApp.jpa.dao.common;

import java.io.Serializable;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;


@SuppressWarnings("unchecked")
public class BaseDAOImpl implements DAO {
	protected EntityManager em;
	protected Class clazz;

	public BaseDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public Serializable findByPrimaryKey(Serializable key) throws DataException {
		Serializable result;
		try {
			result = (Serializable) em.find(clazz, key);
			em.flush();
		} catch (IllegalArgumentException e1) {
			throw new DataException(DataException.IllegalArgument, e1.getMessage());
		} catch (Exception e2) {
			e2.printStackTrace();
			throw new DataException(DataException.Generic, e2.getMessage());
		}
		return result;
	}

	public Serializable aggiorna(Serializable entity) throws DataException {
		try {
			em.merge(entity);
			em.flush();
		} catch (IllegalArgumentException e1) {
			throw new DataException(DataException.IllegalArgument, e1.getMessage());
		} catch (Exception e2) {
			e2.printStackTrace();
			throw new DataException(DataException.Generic, e2.getMessage());
		}
		return entity;
	}

	public Serializable cancella(Serializable entity) throws DataException {
		try {
			em.remove(entity);
			em.flush();
		} catch (IllegalArgumentException e1) {
			throw new DataException(DataException.IllegalArgument, e1.getMessage());
		} catch (Exception e2) {
			throw new DataException(DataException.Generic, e2.getMessage());
		}
		return entity;
	}

	public Serializable inserisci(Serializable entity) throws DataException {
		try {
			em.persist(entity);
			em.flush();
		} catch (EntityExistsException e1) {
			throw new DataException(DataException.EntityExists, e1.getMessage());
		} catch (Exception e2) {
			throw new DataException(DataException.Generic, e2.getMessage());
		}
		return entity;
	}
}