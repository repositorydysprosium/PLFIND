package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.FavorecidoDomain;
import br.com.plataformalancamento.dysprosioum.factory.FavorecidoFactory;

@RequestScoped
public class FavorecidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(FavorecidoService.class);
	
	public FavorecidoService() { }
	
	public List<FavorecidoDomain> findAll() {
		return FavorecidoFactory.findAll();
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
