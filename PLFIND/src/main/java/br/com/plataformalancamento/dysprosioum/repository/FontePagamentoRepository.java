package br.com.plataformalancamento.dysprosioum.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.plataformalancamento.dysprosioum.entity.FontePagamentoEntity;

public class FontePagamentoRepository extends BaseRepository<FontePagamentoEntity> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public FontePagamentoRepository() { }
	
	@SuppressWarnings("unchecked")
	public List<FontePagamentoEntity> findAll() {
		StringBuilder stringBuilder = new StringBuilder("SELECT fonte_pagamento_entity_ ")
			.append("FROM FontePagamentoEntity fonte_pagamento_entity_ ");
		TypedQuery<FontePagamentoEntity> typedQuery = (TypedQuery<FontePagamentoEntity>) getEntityManager().createQuery(stringBuilder.toString());
		return typedQuery.getResultList();
	}

}
