package it.altran.jsf.myApp.jpa.dao;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import it.altran.jsf.myApp.jpa.dao.common.BaseDAOImpl;
import it.altran.jsf.myApp.jpa.dao.common.DataException;
import it.altran.jsf.myApp.jpa.entity.Pubblicazione;



import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

public class PubblicazioneDAO extends BaseDAOImpl{

	
	
		public PubblicazioneDAO(EntityManager em) {
			super(em);
			this.clazz = Pubblicazione.class;
		}
		
		public ArrayList<Pubblicazione> getAll(String userName) throws DataException {
			ArrayList<Pubblicazione> lista = new ArrayList<>();
			Query query;
			try {
				query = em.createNamedQuery("Pubblicazione.findAll");
//				query.setParameter("usUser", userName);
				lista = (ArrayList<Pubblicazione>) query.getResultList();
			} catch (NoResultException e1) {
				throw new DataException(DataException.NoResult, e1.getMessage());
			} catch (NonUniqueResultException e2) {
				throw new DataException(DataException.NonUniqueResult, e2.getMessage());
			} catch (Exception e3) {
				throw new DataException(DataException.Generic, e3.getMessage());
			}
			return lista;
		}
		
		public ArrayList<Pubblicazione> getPubblicazionefromTitolo(String titolo) throws DataException {
			ArrayList<Pubblicazione> lista = new ArrayList<>();
			Query query;
			try {
				query = em.createNamedQuery("Pubblicazione.findFromTitolo");
				query.setParameter("titolo", "%"+titolo+"%");
				lista = (ArrayList<Pubblicazione>) query.getResultList();
			} catch (NoResultException e1) {
				throw new DataException(DataException.NoResult, e1.getMessage());
			} catch (NonUniqueResultException e2) {
				throw new DataException(DataException.NonUniqueResult, e2.getMessage());
			} catch (Exception e3) {
				throw new DataException(DataException.Generic, e3.getMessage());
			}
			return lista;
		}
		
		/* JPA impagination
		 return em.createNamedQuery("yourqueryname", YourEntity.class)
	      .setMaxResults(noOfRecords)
	      .setFirstResult(pageIndex * noOfRecords));
	      .getResultList(); 
		 */
		public ArrayList<Pubblicazione> getPubblicazionefromTitolo(String titolo,int pageIndex,int noOfRecords) throws DataException {
			ArrayList<Pubblicazione> lista = new ArrayList<>();
			Query query;
			try {
				query = em.createNamedQuery("Pubblicazione.findFromTitolo");
				query.setParameter("titolo", "%"+titolo+"%");
				
				//JPA pagination
				query.setMaxResults(noOfRecords)
			      .setFirstResult(pageIndex * noOfRecords);
				
			
				
				System.out.println(">>>>titolo:"+titolo);
				System.out.println(">>>>pageIndex:"+pageIndex);
				System.out.println(">>>>noOfRecords:"+noOfRecords);
				
				lista = (ArrayList<Pubblicazione>) query.getResultList();
				if(lista != null)
					System.out.println(">>>>DIMENSIONE:"+lista.size());
			} catch (NoResultException e1) {
				throw new DataException(DataException.NoResult, e1.getMessage());
			} catch (NonUniqueResultException e2) {
				throw new DataException(DataException.NonUniqueResult, e2.getMessage());
			} catch (Exception e3) {
				throw new DataException(DataException.Generic, e3.getMessage());
			}
			return lista;
		}
		
		public long getCountPubblicazionefromTitolo(String titolo)throws DataException {

			Query query;
			long countResult = 0;
			try {
				query = em.createNamedQuery("Pubblicazione.countFromTitolo");
				query.setParameter("titolo", "%"+titolo+"%");
				countResult = (long)query.getSingleResult();
			}catch (Exception e3) {
				throw new DataException(DataException.Generic, e3.getMessage());
			}
			return countResult;
		}
		
}
