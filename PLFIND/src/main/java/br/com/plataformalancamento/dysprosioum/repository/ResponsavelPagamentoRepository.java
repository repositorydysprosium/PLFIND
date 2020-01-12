package br.com.plataformalancamento.dysprosioum.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.plataformalancamento.dysprosioum.entity.ResponsavelPagamentoDomain;

public class ResponsavelPagamentoRepository extends BaseRepository<ResponsavelPagamentoDomain> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ResponsavelPagamentoRepository() { }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ResponsavelPagamentoDomain> findAll() {
		StringBuilder stringBuilder = new StringBuilder("SELECT responsavel_pagamento_domain_ ")
			.append("FROM ResponsavelPagamentoDomain responsavel_pagamento_domain_ ");
		TypedQuery<ResponsavelPagamentoDomain> typedQuery = (TypedQuery<ResponsavelPagamentoDomain>) getEntityManager().createQuery(stringBuilder.toString());
		return typedQuery.getResultList();
	}

}
