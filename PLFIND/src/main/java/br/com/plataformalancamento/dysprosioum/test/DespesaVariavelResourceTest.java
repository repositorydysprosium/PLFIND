package br.com.plataformalancamento.dysprosioum.test;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelDomain;
import br.com.plataformalancamento.dysprosioum.factory.DespesaVariavelFactory;
import br.com.plataformalancamento.dysprosioum.resource.CanalPagamentoResource;
import br.com.plataformalancamento.dysprosioum.resource.DespesaVariavelResource;

public class DespesaVariavelResourceTest {
	
	private static final Logger LOGGER = Logger.getLogger(DespesaVariavelResourceTest.class);
	
	public static void main(String[] args) {
		persist();
	}
	
	public static void persist() {
		CanalPagamentoResource canalPagamentoResource = new CanalPagamentoResource();
		DespesaVariavelResource despesaVariavelResource = new DespesaVariavelResource();
		DespesaVariavelDomain despesaVariavelDomain = DespesaVariavelFactory.recuperarDepesaVariavelPanificadoraReiPao();
			despesaVariavelDomain.setCanalPagamento(canalPagamentoResource.findOne(1L));
			despesaVariavelResource.persist(despesaVariavelDomain);
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
