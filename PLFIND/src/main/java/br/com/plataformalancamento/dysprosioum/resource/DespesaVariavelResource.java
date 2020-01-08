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
import br.com.plataformalancamento.dysprosioum.factory.DespesaVariavelFactory;
import br.com.plataformalancamento.dysprosioum.service.DespesaVariavelService;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.DESPESA_VARIAVEL_RESOURCE)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON})
public class DespesaVariavelResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(DespesaVariavelResource.class);
	
	private List<DespesaVariavelDomain> despesaVariavelEntityList = new ArrayList<DespesaVariavelDomain>();
	
	private DespesaVariavelService despesaVariavelService;
	
	public DespesaVariavelResource() {
		this.despesaVariavelService = new DespesaVariavelService();
	}
	
	@GET
	@Path("/findAll")
	public List<DespesaVariavelDomain> findAll() {
		List<DespesaVariavelDomain> despesaVariavelDomainList = DespesaVariavelFactory.findAll();
		return despesaVariavelDomainList;
	}
	
	@POST
	@Path("/persist")
	public DespesaVariavelDomain persist(DespesaVariavelDomain despesaVariavelDomain) {
		despesaVariavelService.persist(despesaVariavelDomain);
		return despesaVariavelDomain;
	}
	
	public static Logger getLogger() {
		return LOGGER;
	}

	public List<DespesaVariavelDomain> getDespesaVariavelEntityList() {
		return despesaVariavelEntityList;
	}

	public void setDespesaVariavelEntityList(List<DespesaVariavelDomain> despesaVariavelEntityList) {
		this.despesaVariavelEntityList = despesaVariavelEntityList;
	}

	public DespesaVariavelService getDespesaVariavelService() {
		return despesaVariavelService;
	}

	public void setDespesaVariavelService(DespesaVariavelService despesaVariavelService) {
		this.despesaVariavelService = despesaVariavelService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
