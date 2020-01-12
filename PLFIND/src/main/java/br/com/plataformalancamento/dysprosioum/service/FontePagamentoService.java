package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.FontePagamentoEntity;
import br.com.plataformalancamento.dysprosioum.repository.FontePagamentoRepository;

public class FontePagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private FontePagamentoRepository fontePagamentoRepository;
	
	public FontePagamentoService() {
		this.fontePagamentoRepository = new FontePagamentoRepository();
	}
	
	public List<FontePagamentoEntity> findAll() {
		return fontePagamentoRepository.findAll(); 
	}
}