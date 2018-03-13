package it.altran.jsf.myApp.jpa;

import it.altran.jsf.myApp.jpa.entity.Pubblicazione;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import it.altran.jsf.myApp.domain.Employee;
//import it.altran.jsf.myApp.domain.Department;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listBooks();

		System.out.println(".. done");
	}




	private void createEmployees() {
//		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
//		if (numOfEmployees == 0) {
//			Department department = new Department("java");
//			manager.persist(department);
//
//			manager.persist(new Employee("Jakab Gipsz",department));
//			manager.persist(new Employee("Captain Nemo",department));
//
//		}
	}


	private void listBooks() {
		List<Pubblicazione> resultList = manager.createQuery("Select a From Pubblicazione a", Pubblicazione.class).getResultList();
		System.out.println("num of bokks:" + resultList.size());
		for (Pubblicazione next : resultList) {
			System.out.println("next employee: " + next.getTitolo());
		}
	}


}
