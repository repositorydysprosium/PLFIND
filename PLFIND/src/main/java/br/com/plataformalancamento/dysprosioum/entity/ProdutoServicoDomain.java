package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = ConstanteUtility.TABLE_NAME_TB_PRODUTO_SERVICO)
@XmlRootElement
public class ProdutoServicoDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = ConstanteUtility.SEQUENCE_PRODUTO_SERVICO, sequenceName = ConstanteUtility.SEQUENCE_PRODUTO_SERVICO, allocationSize = 1)
	@GeneratedValue(generator = ConstanteUtility.SEQUENCE_PRODUTO_SERVICO, strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	private String descricao;
	
	private Integer quantidadeProdutoServico;
	
	private BigDecimal valorProdutoServico;
	
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

	public BigDecimal getValorProdutoServico() {
		return valorProdutoServico;
	}

	public void setValorProdutoServico(BigDecimal valorProdutoServico) {
		this.valorProdutoServico = valorProdutoServico;
	}

	public Integer getQuantidadeProdutoServico() {
		return quantidadeProdutoServico;
	}

	public void setQuantidadeProdutoServico(Integer quantidadeProdutoServico) {
		this.quantidadeProdutoServico = quantidadeProdutoServico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
