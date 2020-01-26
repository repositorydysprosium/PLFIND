package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.plataformalancamento.dysprosioum.entity.ResponsavelPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.factory.ResponsavelPagamentoFactory;
import br.com.plataformalancamento.dysprosioum.repository.ResponsavelPagamentoRepository;

@RequestScoped
public class ResponsavelPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResponsavelPagamentoRepository responsavelPagamentoRepository;
	
	public ResponsavelPagamentoService() { }
	
	public List<ResponsavelPagamentoDomain> findAll() {
		return this.responsavelPagamentoRepository.findAll();
	}
	
	public ResponsavelPagamentoDomain persist(ResponsavelPagamentoDomain responsavelPagamentoDomain) {
		this.responsavelPagamentoRepository.persist(ResponsavelPagamentoFactory.recuperarResponsavelPagamentoFactory(responsavelPagamentoDomain));
		return responsavelPagamentoDomain;
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
