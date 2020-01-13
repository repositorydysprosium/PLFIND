package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelDomain;
import br.com.plataformalancamento.dysprosioum.entity.ProdutoServicoDomain;
import br.com.plataformalancamento.dysprosioum.repository.DespesaVariavelRepository;

@RequestScoped
public class DespesaVariavelService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DespesaVariavelRepository despesaVariavelRepository;
	
	@Inject
	private ProdutoServicoService produtoServicoService;
	
	public DespesaVariavelService() {
		this.despesaVariavelRepository = new DespesaVariavelRepository();
		this.produtoServicoService = new ProdutoServicoService();
	}
	
	public DespesaVariavelDomain persist(DespesaVariavelDomain despesaVariavelDomain) {
		despesaVariavelDomain.setProdutoServico(cadastrarProdutoServico(despesaVariavelDomain.getProdutoServico()));
		despesaVariavelDomain.setValorTotalDespesa(recuperarValorTotalDespesaVariavel(despesaVariavelDomain));
		return this.despesaVariavelRepository.persist(despesaVariavelDomain);
	}
	
	private ProdutoServicoDomain cadastrarProdutoServico(ProdutoServicoDomain produtoServicoDomain) {
		produtoServicoService.persist(produtoServicoDomain);
		return produtoServicoDomain;
	}
	
	private BigDecimal recuperarValorTotalDespesaVariavel(DespesaVariavelDomain despesaVariavelDomainParameter) {
		return despesaVariavelDomainParameter.getProdutoServico().getValorProdutoServico();
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
