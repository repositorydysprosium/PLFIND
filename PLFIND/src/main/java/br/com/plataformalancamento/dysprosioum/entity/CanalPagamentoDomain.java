package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;

public class CanalPagamentoDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String nome;
	
	private Boolean isValido;
	
	public CanalPagamentoDomain() { }

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

	public Boolean getIsValido() {
		return isValido;
	}

	public void setIsValido(Boolean isValido) {
		this.isValido = isValido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
