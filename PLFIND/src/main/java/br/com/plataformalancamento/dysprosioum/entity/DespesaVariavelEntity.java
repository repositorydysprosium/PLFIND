package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DespesaVariavelEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private Long favorecido;
	
	private Long itemDespesa;
	
	private Long formaPagamento;
	
	private Long produtoServico;
	
	private Long fontePagamento;
	
	private Long canalPagamento;
	
	private Long responsavelPagamento;
	
	private BigDecimal valorDespesa;
	
	private Date dataDespesa;
	
	private Integer quantidadeItem;
	
	private Boolean isFontePagamentoUnico;
	
	private Boolean isItemUnico;
	
	private String observacaoDespesaVariavel;
	
	public DespesaVariavelEntity() { }

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

	public Long getFavorecido() {
		return favorecido;
	}

	public void setFavorecido(Long favorecido) {
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

	public Long getFontePagamento() {
		return fontePagamento;
	}

	public void setFontePagamento(Long fontePagamento) {
		this.fontePagamento = fontePagamento;
	}

	public Long getCanalPagamento() {
		return canalPagamento;
	}

	public void setCanalPagamento(Long canalPagamento) {
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
