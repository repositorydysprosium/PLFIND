package br.com.plataformalancamento.dysprosioum.resource;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.plataformalancamento.dysprosioum.entity.ResponsavelPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.service.ResponsavelPagamentoService;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.RESPONSAVEL_PAGAMENTO_RESOURCE)
@Produces({MediaType.APPLICATION_JSON})
@RequestScoped
public class ResponsavelPagamentoResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResponsavelPagamentoService responsavelPagamentoService;
	
	public ResponsavelPagamentoResource() { }
	
	@GET
	public List<ResponsavelPagamentoDomain> findAll() {
		return this.responsavelPagamentoService.findAll();
	}
	
	@POST
	@Path("/persist")
	public ResponsavelPagamentoDomain persist(ResponsavelPagamentoDomain responsavelPagamentoDomain) {
		return this.responsavelPagamentoService.persist(responsavelPagamentoDomain);
	}

	public ResponsavelPagamentoService getResponsavelPagamentoService() {
		return responsavelPagamentoService;
	}

	public void setResponsavelPagamentoService(ResponsavelPagamentoService responsavelPagamentoService) {
		this.responsavelPagamentoService = responsavelPagamentoService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
