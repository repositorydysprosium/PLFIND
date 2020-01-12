package br.com.plataformalancamento.dysprosioum.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.com.plataformalancamento.dysprosioum.entity.FavorecidoDomain;

@RequestScoped
public class FavorecidoRepository extends BaseRepository<FavorecidoDomain> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FavorecidoDomain> findAll() {
		StringBuilder stringBuilder = new StringBuilder("SELECT favorecido_domain_ ")
			.append("FROM FavorecidoDomain favorecido_domain_ ");
		TypedQuery<FavorecidoDomain> typedQuery = (TypedQuery<FavorecidoDomain>) getEntityManager().createQuery(stringBuilder.toString());
		return typedQuery.getResultList();
	}

}
