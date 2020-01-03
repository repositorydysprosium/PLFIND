package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Entity
@Table(name =  ConstanteUtility.TABLE_NAME_TB_DESPESA_VARIAVEL)
@XmlRootElement
public class DespesaVariavelEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "ID_FAVORECIDO", nullable = false)
	private FavorecidoDomain favorecido;
	
	@Column(name = "ID_ITEM_DESPESA", nullable = false)
	private Long itemDespesa;
	
	@Column(name = "ID_FORMA_PAGAMENTO", nullable = false)
	private Long formaPagamento;
	
	@Column(name = "ID_PRODUTO_SERVICO", nullable = false)
	private Long produtoServico;
	
	@Column(name = "ID_FONTE_PAGAMENTO", nullable = false)
	private FontePagamentoEntity fontePagamento;
	
	@Column(name = "ID_CANAL_PAGAMENTO", nullable = false)
	private CanalPagamentoDomain canalPagamento;
	
	@Column(name = "ID_RESPONSAVEL_PAGAMENTO", nullable = false)
	private Long responsavelPagamento;
	
	@Column(name = "VALOR_TOTAL_DESPESA", nullable = false)
	private BigDecimal valorDespesa;
	
	@Column(name = "DATA_DESPESA", nullable = false)
	private Date dataDespesa;
	
	@Column(name = "QUANTIDADE_ITEM_DESPESA", nullable = false)
	private Integer quantidadeItem;
	
	@Column(name = "IS_FONTE_PAGAMENTO", nullable = false)
	private Boolean isFontePagamentoUnico;
	
	@Column(name = "ID_ITEM_UNICO", nullable = false)
	private Boolean isItemUnico;
	
	@Column(name = "OBSERVACAO", nullable = true)
	private String observacaoDespesaVariavel;
	
	public DespesaVariavelEntity() { }

	public DespesaVariavelEntity(Long codigo, FavorecidoDomain favorecido, Long itemDespesa, Long formaPagamento,
			Long produtoServico, FontePagamentoEntity fontePagamento, CanalPagamentoDomain canalPagamento, Long responsavelPagamento,
			BigDecimal valorDespesa, Date dataDespesa, Integer quantidadeItem, Boolean isFontePagamentoUnico,
			Boolean isItemUnico, String observacaoDespesaVariavel) {
		super();
		this.codigo = codigo;
		this.favorecido = favorecido;
		this.itemDespesa = itemDespesa;
		this.formaPagamento = formaPagamento;
		this.produtoServico = produtoServico;
		this.fontePagamento = fontePagamento;
		this.canalPagamento = canalPagamento;
		this.responsavelPagamento = responsavelPagamento;
		this.valorDespesa = valorDespesa;
		this.dataDespesa = dataDespesa;
		this.quantidadeItem = quantidadeItem;
		this.isFontePagamentoUnico = isFontePagamentoUnico;
		this.isItemUnico = isItemUnico;
		this.observacaoDespesaVariavel = observacaoDespesaVariavel;
	}

	public DespesaVariavelEntity(Long codigo) {
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

	public Long getItemDespesa() {
		return itemDespesa;
	}

	public void setItemDespesa(Long itemDespesa) {
		this.itemDespesa = itemDespesa;
	}

	public Long getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Long formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Long getProdutoServico() {
		return produtoServico;
	}

	public void setProdutoServico(Long produtoServico) {
		this.produtoServico = produtoServico;
	}

	public FontePagamentoEntity getFontePagamento() {
		return fontePagamento;
	}

	public void setFontePagamento(FontePagamentoEntity fontePagamento) {
		this.fontePagamento = fontePagamento;
	}

	public CanalPagamentoDomain getCanalPagamento() {
		return canalPagamento;
	}

	public void setCanalPagamento(CanalPagamentoDomain canalPagamento) {
		this.canalPagamento = canalPagamento;
	}

	public Long getResponsavelPagamento() {
		return responsavelPagamento;
	}

	public void setResponsavelPagamento(Long responsavelPagamento) {
		this.responsavelPagamento = responsavelPagamento;
	}

	public BigDecimal getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(BigDecimal valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(Integer quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public Boolean getIsFontePagamentoUnico() {
		return isFontePagamentoUnico;
	}

	public void setIsFontePagamentoUnico(Boolean isFontePagamentoUnico) {
		this.isFontePagamentoUnico = isFontePagamentoUnico;
	}

	public Boolean getIsItemUnico() {
		return isItemUnico;
	}

	public void setIsItemUnico(Boolean isItemUnico) {
		this.isItemUnico = isItemUnico;
	}

	public String getObservacaoDespesaVariavel() {
		return observacaoDespesaVariavel;
	}

	public void setObservacaoDespesaVariavel(String observacaoDespesaVariavel) {
		this.observacaoDespesaVariavel = observacaoDespesaVariavel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DespesaVariavelEntity other = (DespesaVariavelEntity) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DespesaVariavelEntity [codigo=" + codigo + ", favorecido=" + favorecido + "]";
	}
	
}
