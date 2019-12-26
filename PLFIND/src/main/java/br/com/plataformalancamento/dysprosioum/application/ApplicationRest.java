package br.com.plataformalancamento.dysprosioum.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@ApplicationPath(ConstanteUtility.APPLICATION_PATH)
public class ApplicationRest extends ResourceConfig {

	public ApplicationRest() {
		packages(ConstanteUtility.APPLICATION_PATH_PACKAGE);
	}
	
}
