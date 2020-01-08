package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;

public class CanalPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CanalPagamentoRepository canalPagamentoRepository;
	
	public CanalPagamentoService() { 
		this.canalPagamentoRepository = new CanalPagamentoRepository();
	}
	
	public CanalPagamentoDomain persist(CanalPagamentoDomain canalPagamentoDomain) {
		return canalPagamentoRepository.persist(canalPagamentoDomain);
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
