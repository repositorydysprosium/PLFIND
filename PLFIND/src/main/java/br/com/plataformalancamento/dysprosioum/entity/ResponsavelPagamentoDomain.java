package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Entity
@Table(name = ConstanteUtility.TABLE_NAME_TB_RESPONSAVEL_PAGAMENTO)
@XmlRootElement
public class ResponsavelPagamentoDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = ConstanteUtility.SEQUENCE_RESPONSAVEL_PAGAMENTO, sequenceName = ConstanteUtility.SEQUENCE_RESPONSAVEL_PAGAMENTO, allocationSize = 1)
	@GeneratedValue(generator = ConstanteUtility.SEQUENCE_RESPONSAVEL_PAGAMENTO, strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	private String nome;
	
	private Boolean isValido;
	
	private Boolean isFontePagamento;
	
	private Boolean isPessoaFinanceira;
	
	public ResponsavelPagamentoDomain() { }

	public ResponsavelPagamentoDomain(Long codigo) {
		super();
		this.codigo = codigo;
	}

	public ResponsavelPagamentoDomain(String nome) {
		super();
		this.nome = nome;
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
