package br.com.plataformalancamento.dysprosioum.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelDomain;
import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelEntity;
import br.com.plataformalancamento.dysprosioum.factory.DespesaVariavelFactory;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.DESPESA_VARIAVEL_RESOURCE)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
public class DespesaVariavelResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(DespesaVariavelResource.class);
	
	List<DespesaVariavelDomain> despesaVariavelEntityList = new ArrayList<DespesaVariavelDomain>();
	
	public DespesaVariavelResource() { }
	
	@GET
	@Path("/findAll")
	public List<DespesaVariavelEntity> findAll() {
		List<DespesaVariavelEntity> despesaVariavelEntityList = DespesaVariavelFactory.findAll();
		return despesaVariavelEntityList;
	}
	
	@POST
	@Path("/persist")
	public DespesaVariavelDomain persist(DespesaVariavelDomain despesaVariavelEntity) {
		despesaVariavelEntityList.add(despesaVariavelEntity);
		return despesaVariavelEntity;
	}
	
	public static Logger getLogger() {
		return LOGGER;
	}
	
}
