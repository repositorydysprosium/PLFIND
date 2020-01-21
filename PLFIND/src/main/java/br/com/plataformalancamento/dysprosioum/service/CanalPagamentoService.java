package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.factory.CanalPagamentoFactory;
import br.com.plataformalancamento.dysprosioum.repository.CanalPagamentoRepository;

@RequestScoped
public class CanalPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CanalPagamentoRepository canalPagamentoRepository;
	
	public CanalPagamentoService() { 
		this.canalPagamentoRepository = new CanalPagamentoRepository();
	}
	
	public List<CanalPagamentoDomain> finAll() {
		return canalPagamentoRepository.findAll();
	}
	
	public CanalPagamentoDomain persist(CanalPagamentoDomain canalPagamentoDomain) {
		return canalPagamentoRepository.persist(CanalPagamentoFactory.getCanalPagamento(canalPagamentoDomain));
	}
	
	public CanalPagamentoDomain findOne(Long codigo) {
		return this.canalPagamentoRepository.findOne(codigo);
	}

	public CanalPagamentoRepository getCanalPagamentoRepository() {
		return canalPagamentoRepository;
	}

	public void setCanalPagamentoRepository(CanalPagamentoRepository canalPagamentoRepository) {
		this.canalPagamentoRepository = canalPagamentoRepository;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
