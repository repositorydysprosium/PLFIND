package br.com.plataformalancamento.dysprosioum.resource;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.FavorecidoDomain;
import br.com.plataformalancamento.dysprosioum.service.FavorecidoService;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.FAVORECIDO_RESOURCE)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@RequestScoped
public class FavorecidoResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(FavorecidoResource.class);
	
	@Inject
	private FavorecidoService favorecidoService;
	
	public FavorecidoResource() { }
	
	@GET
	@Path("/findAll")
	public List<FavorecidoDomain> findAll() {
//		LOGGER.info(ConstanteUtility.MENSAGEM_CONSULTA_SUCESSO);
		return favorecidoService.findAll();
	}

	public FavorecidoService getFavorecidoService() {
		return favorecidoService;
	}

	public void setFavorecidoService(FavorecidoService favorecidoService) {
		this.favorecidoService = favorecidoService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
