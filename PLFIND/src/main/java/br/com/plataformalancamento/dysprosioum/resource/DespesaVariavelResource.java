package br.com.plataformalancamento.dysprosioum.resource;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelEntity;
import br.com.plataformalancamento.dysprosioum.factory.DespesaVariavelFactory;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.DESPESA_VARIAVEL_RESOURCE)
public class DespesaVariavelResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(DespesaVariavelResource.class);
	
	public DespesaVariavelResource() { }
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<DespesaVariavelEntity> findAll() {
		List<DespesaVariavelEntity> despesaVariavelEntityList = DespesaVariavelFactory.findAll();
		LOGGER.info(ConstanteUtility.MENSAGEM_CONSULTA_SUCESSO);
		return despesaVariavelEntityList;
	}
}
