package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;

import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelDomain;
import br.com.plataformalancamento.dysprosioum.repository.DespesaVariavelRepository;

public class DespesaVariavelService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DespesaVariavelRepository despesaVariavelRepository;
	
	public DespesaVariavelService() { 
		this.despesaVariavelRepository = new DespesaVariavelRepository();
	}
	
	public DespesaVariavelDomain persist(DespesaVariavelDomain despesaVariavelDomain) {
		return this.despesaVariavelRepository.persist(despesaVariavelDomain);
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
