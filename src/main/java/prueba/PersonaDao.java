package prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonaDao {
	private static EntityManagerFactory entityManagerFactory;
	
	private void setUp(){
		entityManagerFactory = Persistence.createEntityManagerFactory( "aplicacion.jpa" );
	}

	private void tearDown(){
		entityManagerFactory.close();
	}
	public void persistir() {
		setUp();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Persona p = new Persona("Jorge","Lopez");
		entityManager.persist(p);
		entityManager.getTransaction().commit();
		entityManager.close();
		tearDown();
		
	}
	public static void main(String[] args) {
		PersonaDao pd = new PersonaDao();
		pd.persistir();
	}

}
