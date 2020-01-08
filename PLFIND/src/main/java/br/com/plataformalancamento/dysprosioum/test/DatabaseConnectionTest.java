package br.com.plataformalancamento.dysprosioum.test;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.connection.DatabaseConnection;

public class DatabaseConnectionTest {
	
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionTest.class);
	
	public static void main(String[] args) {
		databaseConnection();
	}
	
	@SuppressWarnings("static-access")
	private static void databaseConnection() {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		LOGGER.info("CONEXAO REALIZADA COM SUCESSO: " + databaseConnection.openConnection());
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
