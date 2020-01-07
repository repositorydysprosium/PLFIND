package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;

public class ProdutoServicoDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String descricao;
	
	public ProdutoServicoDomain() { }

	public ProdutoServicoDomain(Long codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public ProdutoServicoDomain(Long codigo) {
		super();
		this.codigo = codigo;
	}
	
	public ProdutoServicoDomain(String descricao) {
		super();
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
