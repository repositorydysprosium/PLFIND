package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.enterprise.context.RequestScoped;

import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelDomain;
import br.com.plataformalancamento.dysprosioum.entity.ProdutoServicoDomain;
import br.com.plataformalancamento.dysprosioum.repository.DespesaVariavelRepository;
import br.com.plataformalancamento.dysprosioum.utility.DateUtility;

@RequestScoped
public class DespesaVariavelService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DespesaVariavelRepository despesaVariavelRepository;
	
	public DespesaVariavelService() {
		this.despesaVariavelRepository = new DespesaVariavelRepository();
	}
	
	public DespesaVariavelDomain persist(DespesaVariavelDomain despesaVariavelDomain) {
		despesaVariavelDomain.setDataDespesa(acrescentarDiasDate(despesaVariavelDomain.getDataDespesa(), 1));
		despesaVariavelDomain.setValorTotalDespesa(recuperarValorTotalDespesaVariavel(despesaVariavelDomain));
		for(ProdutoServicoDomain produtoServicoDomainResult : despesaVariavelDomain.getProdutoServicoDomainList()) {
			produtoServicoDomainResult.setDespesaVariavelDomain(despesaVariavelDomain);
		}
		despesaVariavelDomain = this.despesaVariavelRepository.persist(despesaVariavelDomain);
		return despesaVariavelDomain;
	}
	
	private BigDecimal recuperarValorTotalDespesaVariavel(DespesaVariavelDomain despesaVariavelDomainParameter) {
		BigDecimal valorTotalDespesa = new BigDecimal(0);
		for(ProdutoServicoDomain produtoServicoDomainResult : despesaVariavelDomainParameter.getProdutoServicoDomainList()) {
			valorTotalDespesa = valorTotalDespesa.add(produtoServicoDomainResult.getValorProdutoServico()).multiply(new BigDecimal(produtoServicoDomainResult.getQuantidadeProdutoServico()));
		}
		return valorTotalDespesa;
	}
	
	private Date acrescentarDiasDate(Date dataParameter, Integer numeroDias) {
		return DateUtility.acrescentarDiasDate(dataParameter, 1);
	}

	public DespesaVariavelRepository getDespesaVariavelRepository() {
		return despesaVariavelRepository;
	}

	public void setDespesaVariavelRepository(DespesaVariavelRepository despesaVariavelRepository) {
		this.despesaVariavelRepository = despesaVariavelRepository;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
