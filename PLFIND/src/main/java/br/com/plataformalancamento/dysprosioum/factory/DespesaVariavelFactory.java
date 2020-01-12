package br.com.plataformalancamento.dysprosioum.factory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelDomain;
import br.com.plataformalancamento.dysprosioum.entity.FavorecidoDomain;
import br.com.plataformalancamento.dysprosioum.entity.FontePagamentoEntity;
import br.com.plataformalancamento.dysprosioum.entity.FormaPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.entity.ProdutoServicoDomain;
import br.com.plataformalancamento.dysprosioum.entity.ResponsavelPagamentoDomain;

public class DespesaVariavelFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public DespesaVariavelFactory() { }
	
	public static DespesaVariavelDomain recuperarDepesaVariavelSoDigitalInformatica() {
		DespesaVariavelDomain despesaVariavelEntitySoDigitalInformatica = new DespesaVariavelDomain();
			despesaVariavelEntitySoDigitalInformatica.setCodigo(1L);
			despesaVariavelEntitySoDigitalInformatica.setFavorecido(new FavorecidoDomain(1L));
//			despesaVariavelEntitySoDigitalInformatica.setItemDespesa(1L);
//			despesaVariavelEntitySoDigitalInformatica.setFormaPagamento(1L);
			despesaVariavelEntitySoDigitalInformatica.setProdutoServico(new ProdutoServicoDomain(1L));
			despesaVariavelEntitySoDigitalInformatica.setFontePagamento(new FontePagamentoEntity(1L));
			despesaVariavelEntitySoDigitalInformatica.setCanalPagamento(new CanalPagamentoDomain(1L));
//			despesaVariavelEntitySoDigitalInformatica.setResponsavelPagamento(1L);
			despesaVariavelEntitySoDigitalInformatica.setValorDespesa(new BigDecimal(45));
			despesaVariavelEntitySoDigitalInformatica.setDataDespesa(new Date());
//			despesaVariavelEntitySoDigitalInformatica.setQuantidadeItem(1);
//			despesaVariavelEntitySoDigitalInformatica.setIsFontePagamentoUnico(true);
			despesaVariavelEntitySoDigitalInformatica.setIsItemUnico(true);
//			despesaVariavelEntitySoDigitalInformatica.setObservacaoDespesaVariavel("");
		return despesaVariavelEntitySoDigitalInformatica;
	}
	
	public static DespesaVariavelDomain recuperarDepesaVariavelSupermercadoPraVoce() {
		DespesaVariavelDomain despesaVariavelEntitySupermercadoPraVoce = new DespesaVariavelDomain();
			despesaVariavelEntitySupermercadoPraVoce.setCodigo(1L);
			despesaVariavelEntitySupermercadoPraVoce.setFavorecido(new FavorecidoDomain(1L));
//			despesaVariavelEntitySupermercadoPraVoce.setItemDespesa(1L);
//			despesaVariavelEntitySupermercadoPraVoce.setFormaPagamento(1L);
			despesaVariavelEntitySupermercadoPraVoce.setProdutoServico(new ProdutoServicoDomain(1L));
			despesaVariavelEntitySupermercadoPraVoce.setFontePagamento(new FontePagamentoEntity(1L));
			despesaVariavelEntitySupermercadoPraVoce.setCanalPagamento(new CanalPagamentoDomain(1L));
//			despesaVariavelEntitySupermercadoPraVoce.setResponsavelPagamento(1L);
			despesaVariavelEntitySupermercadoPraVoce.setValorDespesa(new BigDecimal(45));
			despesaVariavelEntitySupermercadoPraVoce.setDataDespesa(new Date());
//			despesaVariavelEntitySupermercadoPraVoce.setQuantidadeItem(1);
//			despesaVariavelEntitySupermercadoPraVoce.setIsFontePagamentoUnico(true);
			despesaVariavelEntitySupermercadoPraVoce.setIsItemUnico(true);
//			despesaVariavelEntitySupermercadoPraVoce.setObservacaoDespesaVariavel("");
		return despesaVariavelEntitySupermercadoPraVoce;
	}
	
	public static DespesaVariavelDomain recuperarDepesaVariavelPanificadoraReiPao() {
		DespesaVariavelDomain depesaVariavelPanificadoraReiPao = new DespesaVariavelDomain();
			depesaVariavelPanificadoraReiPao.setCanalPagamento(new CanalPagamentoDomain(1L));
			depesaVariavelPanificadoraReiPao.setDataDespesa(new Date());
			depesaVariavelPanificadoraReiPao.setFavorecido(new FavorecidoDomain(1L));
			depesaVariavelPanificadoraReiPao.setFontePagamento(new FontePagamentoEntity(1L));
			depesaVariavelPanificadoraReiPao.setFormaPagamento(new FormaPagamentoDomain(1L));
			depesaVariavelPanificadoraReiPao.setIsFormaPagamentoUnico(true);
			depesaVariavelPanificadoraReiPao.setIsItemUnico(true);
			depesaVariavelPanificadoraReiPao.setObservacao("");
			depesaVariavelPanificadoraReiPao.setProdutoServico(new ProdutoServicoDomain(1L));
			depesaVariavelPanificadoraReiPao.setResponsavelPagamento(new ResponsavelPagamentoDomain(1L));
			depesaVariavelPanificadoraReiPao.setValorDespesa(new BigDecimal(10));
		return depesaVariavelPanificadoraReiPao;
	}
	
	public static List<DespesaVariavelDomain> findAll() {
		List<DespesaVariavelDomain> despesaVariavelDomainList = new ArrayList<DespesaVariavelDomain>();
			despesaVariavelDomainList.add(recuperarDepesaVariavelSoDigitalInformatica());
			despesaVariavelDomainList.add(recuperarDepesaVariavelSupermercadoPraVoce());
			despesaVariavelDomainList.add(recuperarDepesaVariavelPanificadoraReiPao());
		return despesaVariavelDomainList;
	}

}
