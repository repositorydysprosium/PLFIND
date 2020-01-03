package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;

public class FontePagamentoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String nome;
	
	private Boolean isAtivo;

	public FontePagamentoEntity() { }
	
	public FontePagamentoEntity(Long codigo) { 
		super();
		this.codigo = codigo;
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
