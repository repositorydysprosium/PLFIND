package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;

public class FavorecidoDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String nome;
	
	public FavorecidoDomain() { }
	
	public FavorecidoDomain(Long codigo) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
