package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;

import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelEntity;

public class DespesaVariavelService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public DespesaVariavelService() { }
	
	public DespesaVariavelEntity persist(DespesaVariavelEntity despesaVariavelEntity) {
		return despesaVariavelEntity;
	}

}
