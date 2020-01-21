package br.com.plataformalancamento.dysprosioum.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;

@RequestScoped
public class CanalPagamentoRepository extends BaseRepository<CanalPagamentoDomain> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<CanalPagamentoDomain> findAll() {
		StringBuilder stringBuilder = new StringBuilder("SELECT canal_pagamento_domain_ ")
			.append("FROM CanalPagamentoDomain canal_pagamento_domain_ ");
		TypedQuery<CanalPagamentoDomain> typedQuery = (TypedQuery<CanalPagamentoDomain>) getEntityManager().createQuery(stringBuilder.toString());
		return typedQuery.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public CanalPagamentoDomain findOne(Long codigo) {
		StringBuilder stringBuilder = new StringBuilder("SELECT canal_pagamento_domain_ ")
			.append("FROM CanalPagamentoDomain canal_pagamento_domain_ ")
			.append("WHERE canal_pagamento_domain_.codigo = : codigoParameter ");
		TypedQuery<CanalPagamentoDomain> typedQuery = (TypedQuery<CanalPagamentoDomain>) getEntityManager().createQuery(stringBuilder.toString());
			typedQuery.setParameter("codigoParameter", codigo);
		return (CanalPagamentoDomain) typedQuery.getSingleResult();
	}

}
