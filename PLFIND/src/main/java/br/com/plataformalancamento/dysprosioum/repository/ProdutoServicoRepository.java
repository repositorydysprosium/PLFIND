package br.com.plataformalancamento.dysprosioum.repository;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.plataformalancamento.dysprosioum.entity.ProdutoServicoDomain;

@RequestScoped
public class ProdutoServicoRepository extends BaseRepository<ProdutoServicoDomain> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ProdutoServicoRepository() { }
	
	@Override
	public ProdutoServicoDomain persist(ProdutoServicoDomain produtoServicoDomain) {
		return super.persist(produtoServicoDomain);
	}

}
