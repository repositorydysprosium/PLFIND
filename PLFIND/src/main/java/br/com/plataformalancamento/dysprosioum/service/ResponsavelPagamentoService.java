package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.ResponsavelPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.repository.ResponsavelPagamentoRepository;

public class ResponsavelPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ResponsavelPagamentoRepository responsavelPagamentoRepository;
	
	public ResponsavelPagamentoService() {
		this.responsavelPagamentoRepository = new ResponsavelPagamentoRepository();
	}
	
	public List<ResponsavelPagamentoDomain> findAll() {
		return this.responsavelPagamentoRepository.findAll();
	}

	public ResponsavelPagamentoRepository getResponsavelPagamentoRepository() {
		return responsavelPagamentoRepository;
	}

	public void setResponsavelPagamentoRepository(ResponsavelPagamentoRepository responsavelPagamentoRepository) {
		this.responsavelPagamentoRepository = responsavelPagamentoRepository;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
