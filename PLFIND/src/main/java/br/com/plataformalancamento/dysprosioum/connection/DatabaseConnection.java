package br.com.plataformalancamento.dysprosioum.connection;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.plataformalancamento.dysprosioum.repository.BaseRepository;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@SuppressWarnings("rawtypes")
public class DatabaseConnection extends BaseRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static EntityManagerFactory entityManagerFactory;
	
	public DatabaseConnection() { }
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory(ConstanteUtility.PERSISTENCE_UNIT_NAME);
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static EntityManager openConnection() {
		return DatabaseConnection.getEntityManagerFactory().createEntityManager();
	}

	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		DatabaseConnection.entityManagerFactory = entityManagerFactory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
