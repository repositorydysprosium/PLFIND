package br.com.plataformalancamento.dysprosioum.resource;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.FontePagamentoEntity;
import br.com.plataformalancamento.dysprosioum.service.FontePagamentoService;
import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Path(ConstanteUtility.FONTE_PAGAMENTO_RESOURCE)
@Produces({MediaType.APPLICATION_JSON})
public class FontePagamentoResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(FontePagamentoResource.class);
	
	private FontePagamentoService fontePagamentoService;
	
	public FontePagamentoResource() { 
		this.fontePagamentoService = new FontePagamentoService();
	}
	
	@GET
	public List<FontePagamentoEntity> fontePagamentoEntityList() {
		return fontePagamentoService.findAll();
	}
	
	@POST
	@Path("persist")
	public FontePagamentoEntity persist(FontePagamentoEntity fontePagamentoEntity) {
		this.fontePagamentoService.persist(fontePagamentoEntity);
		return fontePagamentoEntity;
	}
	
	public static Logger getLogger() {
		return LOGGER;
	}
	
}
