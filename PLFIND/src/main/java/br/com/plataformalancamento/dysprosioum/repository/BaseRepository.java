package br.com.plataformalancamento.dysprosioum.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.connection.DatabaseConnection;

public class BaseRepository<C> implements BaseInterfaceRepository<C>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(BaseRepository.class);
	
	private EntityManager entityManager;
	
	private EntityTransaction entityTransaction;
	
	private DatabaseConnection databaseConnection;
	
	public BaseRepository() { 
		this.entityManager = DatabaseConnection.openConnection();
		this.entityTransaction = entityManager.getTransaction();
	}
	
	@Override
	public C persist(C object) {
		beginTransaction();
			this.entityManager.persist(object);
		commitTransaction();
		closeEntityManager();
		return object;
	}

	@Override
	public C remove(C object) {
		beginTransaction();
			this.entityManager.remove(object);
		commitTransaction();
		return object;
	}

	@Override
	public C update(C object) {
		beginTransaction();
			this.entityManager.merge(object);
		commitTransaction();
		return object;
	}

	@Override
	public List<C> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C findOne(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C findOne(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void beginTransaction() {
		if(this.entityManager.getTransaction().isActive() == false) {
			this.entityManager.getTransaction().begin();
		}
	}
	
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
	public void commitTransactionAndClose() {
		entityManager.getTransaction().commit();
		closeEntityManager();
	}
	
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
	}
	
	public void closeEntityManager() {
		entityManager.close();
	}
	
	public void cleanEntityManager() {
		entityManager.clear();
	}
	
	public void flushEntityManager() {
		entityManager.flush();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityTransaction getEntityTransaction() {
		return entityTransaction;
	}

	public void setEntityTransaction(EntityTransaction entityTransaction) {
		this.entityTransaction = entityTransaction;
	}

	public DatabaseConnection getDatabaseConnection() {
		return databaseConnection;
	}

	public void setDatabaseConnection(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
