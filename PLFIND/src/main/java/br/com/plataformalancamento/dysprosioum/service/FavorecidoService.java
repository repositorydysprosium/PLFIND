package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.FavorecidoDomain;
import br.com.plataformalancamento.dysprosioum.repository.FavorecidoRepository;

@RequestScoped
public class FavorecidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(FavorecidoService.class);
	
	@Inject
	private FavorecidoRepository favorecidoRepository;
	
	public FavorecidoService() { }
	
	public List<FavorecidoDomain> findAll() {
		return favorecidoRepository.findAll();
	}
	
	public FavorecidoDomain persist(FavorecidoDomain favorecidoDomain) {
		return favorecidoRepository.persist(favorecidoDomain);
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
