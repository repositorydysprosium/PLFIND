package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;

public class ResponsavelPagamentoDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String nome;
	
	private Boolean isValido;
	
	private Boolean isFontePagamento;
	
	private Boolean isPessoaFinanceira;
	
	public ResponsavelPagamentoDomain() { }

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

	public Boolean getIsFontePagamento() {
		return isFontePagamento;
	}

	public void setIsFontePagamento(Boolean isFontePagamento) {
		this.isFontePagamento = isFontePagamento;
	}

	public Boolean getIsPessoaFinanceira() {
		return isPessoaFinanceira;
	}

	public void setIsPessoaFinanceira(Boolean isPessoaFinanceira) {
		this.isPessoaFinanceira = isPessoaFinanceira;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
