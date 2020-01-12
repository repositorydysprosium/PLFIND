package br.com.plataformalancamento.dysprosioum.resource;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.plataformalancamento.dysprosioum.entity.ResponsavelPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.service.ResponsavelPagamentoService;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.RESPONSAVEL_PAGAMENTO_RESOURCE)
@Produces({MediaType.APPLICATION_JSON})
public class ResposavelPagamentoResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ResponsavelPagamentoService responsavelPagamentoService;
	
	public ResposavelPagamentoResource() { 
		this.responsavelPagamentoService = new ResponsavelPagamentoService();
	}
	
	@GET
	public List<ResponsavelPagamentoDomain> findAll() {
		return this.responsavelPagamentoService.findAll();
	}
	
}
