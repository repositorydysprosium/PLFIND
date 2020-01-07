package br.com.plataformalancamento.dysprosioum.resource;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.factory.CanalPagamentoFactory;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.CANAL_PAGAMENTO_RESOURCE)
@Produces({MediaType.APPLICATION_JSON})
public class CanalPagamentoResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(CanalPagamentoResource.class);
	
	public CanalPagamentoResource() { }
	
	@GET
	public List<CanalPagamentoDomain> finAll() {
//		LOGGER.info(ConstanteUtility.MENSAGEM_CONSULTA_SUCESSO);
		return CanalPagamentoFactory.finAll();
	}
	
	public static Logger getLogger() {
		return LOGGER;
	}

}
