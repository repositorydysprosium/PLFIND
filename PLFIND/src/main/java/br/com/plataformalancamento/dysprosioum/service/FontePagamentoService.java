package br.com.plataformalancamento.dysprosioum.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.plataformalancamento.dysprosioum.entity.FontePagamentoEntity;
import br.com.plataformalancamento.dysprosioum.repository.FontePagamentoRepository;

@RequestScoped
public class FontePagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private FontePagamentoRepository fontePagamentoRepository;
	
	public FontePagamentoService() {
		this.fontePagamentoRepository = new FontePagamentoRepository();
	}
	
	public List<FontePagamentoEntity> findAll() {
		return fontePagamentoRepository.findAll(); 
	}
	
	public FontePagamentoEntity persist(FontePagamentoEntity fontePagamentoEntity) {
		return this.fontePagamentoRepository.persist(fontePagamentoEntity);
	}
	
}
