package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.plataformalancamento.dysprosioum.entity.ProdutoServicoDomain;
import br.com.plataformalancamento.dysprosioum.repository.ProdutoServicoRepository;

@RequestScoped
public class ProdutoServicoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoServicoRepository produtoServicoRepository;
	
	public ProdutoServicoService() { 
		this.produtoServicoRepository = new ProdutoServicoRepository();
	}

	public ProdutoServicoDomain persist(ProdutoServicoDomain produtoServicoDomain) {
		produtoServicoRepository.persist(produtoServicoDomain);
		return produtoServicoDomain;
	}
	
}
