package it.altran.jsf.myApp.jpa.dao.common;

import java.io.Serializable;


public interface DAO {
	public Serializable inserisci(Serializable entity) throws DataException;

	public Serializable aggiorna(Serializable entity) throws DataException;

	public Serializable cancella(Serializable entity) throws DataException;

	public Serializable findByPrimaryKey(Serializable key) throws DataException;
}
