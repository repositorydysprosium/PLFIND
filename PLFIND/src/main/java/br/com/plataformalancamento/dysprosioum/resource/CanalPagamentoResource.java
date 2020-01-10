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

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.service.CanalPagamentoService;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.CANAL_PAGAMENTO_RESOURCE)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@RequestScoped
public class CanalPagamentoResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(CanalPagamentoResource.class);
	
	@Inject
	private CanalPagamentoService canalPagamentoService;
	
	public CanalPagamentoResource() { 
		this.canalPagamentoService = new CanalPagamentoService();
	}
	
	public CanalPagamentoDomain persist(CanalPagamentoDomain canalPagamentoDomain) {
		return this.canalPagamentoService.persist(canalPagamentoDomain);
	}
	
	public CanalPagamentoDomain findOne(Long codigo) {
		return this.canalPagamentoService.findOne(codigo);
	}
	
	@GET
	@Path("/findAll")
	public List<CanalPagamentoDomain> finAll() {
		return canalPagamentoService.finAll();
	}
	
	public static Logger getLogger() {
		return LOGGER;
	}

	public CanalPagamentoService getCanalPagamentoService() {
		return canalPagamentoService;
	}

	public void setCanalPagamentoService(CanalPagamentoService canalPagamentoService) {
		this.canalPagamentoService = canalPagamentoService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
