package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Entity
@Table(name =  ConstanteUtility.TABLE_NAME_TB_DESPESA_VARIAVEL)
@XmlRootElement
public class DespesaVariavelDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SEQUENCE_DESPESA_VARIAVEL", sequenceName = "SEQUENCE_DESPESA_VARIAVEL", allocationSize = 1)
	@GeneratedValue(generator = "SEQUENCE_DESPESA_VARIAVEL", strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name = "ID_FAVORECIDO", referencedColumnName = "codigo", nullable = false)
	private FavorecidoDomain favorecido;
	
	@OneToOne
	@JoinColumn(name = "ID_FONTE_PAGAMENTO", referencedColumnName = "codigo", nullable = false)
	private FontePagamentoEntity fontePagamento;
	
	@OneToOne
	@JoinColumn(name = "ID_FORMA_PAGAMENTO", referencedColumnName = "codigo", nullable = true)
	private FormaPagamentoDomain formaPagamento;
	
	@OneToOne
	@JoinColumn(name = "ID_CANAL_PAGAMENTO", referencedColumnName = "codigo", nullable = false)
	private CanalPagamentoDomain canalPagamento;
	
	@OneToOne
	@JoinColumn(name = "ID_RESPONSAVEL_PAGAMENTO", referencedColumnName = "codigo", nullable = false)
	private ResponsavelPagamentoDomain responsavelPagamento;
	
	@OneToOne
	@JoinColumn(name = "ID_PRODUTO_SERVICO", referencedColumnName = "codigo", nullable = false)
	private ProdutoServicoDomain produtoServico;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "DATA_DESPESA", nullable = false)
	private Date dataDespesa;
	
	@Column(name = "VALOR_TOTAL_DESPESA", nullable = false)
	private BigDecimal valorDespesa;
	
	@Column(name = "QUANTIDADE_PRODUTO_SERVICO", nullable = false)
	private Integer quantidadeProdutoServico;
	
	@Column(name = "IS_ITEM_UNICO", nullable = false)
	private Boolean isItemUnico;
	
	@Column(name = "IS_FORMA_PAGAMENTO_UNICO", nullable = false)
	private Boolean isFormaPagamentoUnico;
	
	@Column(name = "OBSERVACAO", nullable = true)
	private String observacao;
	
	public DespesaVariavelDomain() { }

	public DespesaVariavelDomain(Long codigo, FavorecidoDomain favorecido) {
		super();
		this.codigo = codigo;
		this.favorecido = favorecido;
	}

	public DespesaVariavelDomain(Long codigo) {
		super();
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public FavorecidoDomain getFavorecido() {
		return favorecido;
	}

	public void setFavorecido(FavorecidoDomain favorecido) {
		this.favorecido = favorecido;
	}

	public Boolean getIsItemUnico() {
		return isItemUnico;
	}

	public void setIsItemUnico(Boolean isItemUnico) {
		this.isItemUnico = isItemUnico;
	}

	public Integer getQuantidadeProdutoServico() {
		return quantidadeProdutoServico;
	}

	public void setQuantidadeProdutoServico(Integer quantidadeProdutoServico) {
		this.quantidadeProdutoServico = quantidadeProdutoServico;
	}
	
	public Boolean getIsFormaPagamentoUnico() {
		return isFormaPagamentoUnico;
	}

	public void setIsFormaPagamentoUnico(Boolean isFormaPagamentoUnico) {
		this.isFormaPagamentoUnico = isFormaPagamentoUnico;
	}

	public FontePagamentoEntity getFontePagamento() {
		return fontePagamento;
	}

	public void setFontePagamento(FontePagamentoEntity fontePagamento) {
		this.fontePagamento = fontePagamento;
	}

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public CanalPagamentoDomain getCanalPagamento() {
		return canalPagamento;
	}

	public void setCanalPagamento(CanalPagamentoDomain canalPagamento) {
		this.canalPagamento = canalPagamento;
	}

	public ResponsavelPagamentoDomain getResponsavelPagamento() {
		return responsavelPagamento;
	}

	public void setResponsavelPagamento(ResponsavelPagamentoDomain responsavelPagamento) {
		this.responsavelPagamento = responsavelPagamento;
	}

	public void setProdutoServico(ProdutoServicoDomain produtoServico) {
		this.produtoServico = produtoServico;
	}

	public ProdutoServicoDomain getProdutoServico() {
		return produtoServico;
	}

	public BigDecimal getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(BigDecimal valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public FormaPagamentoDomain getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoDomain formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
