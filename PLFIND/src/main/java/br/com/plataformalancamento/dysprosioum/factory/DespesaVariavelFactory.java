package br.com.plataformalancamento.dysprosioum.factory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.entity.DespesaVariavelEntity;
import br.com.plataformalancamento.dysprosioum.entity.FavorecidoDomain;
import br.com.plataformalancamento.dysprosioum.entity.FontePagamentoEntity;
import br.com.plataformalancamento.dysprosioum.entity.ProdutoServicoDomain;

public class DespesaVariavelFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public DespesaVariavelFactory() { }
	
	public static DespesaVariavelEntity recuperarDepesaVariavelSoDigitalInformatica() {
		DespesaVariavelEntity despesaVariavelEntitySoDigitalInformatica = new DespesaVariavelEntity();
			despesaVariavelEntitySoDigitalInformatica.setCodigo(1L);
			despesaVariavelEntitySoDigitalInformatica.setFavorecido(new FavorecidoDomain(1L));
			despesaVariavelEntitySoDigitalInformatica.setItemDespesa(1L);
			despesaVariavelEntitySoDigitalInformatica.setFormaPagamento(1L);
			despesaVariavelEntitySoDigitalInformatica.setProdutoServico(new ProdutoServicoDomain(1L));
			despesaVariavelEntitySoDigitalInformatica.setFontePagamento(new FontePagamentoEntity(1L));
			despesaVariavelEntitySoDigitalInformatica.setCanalPagamento(new CanalPagamentoDomain(1L));
			despesaVariavelEntitySoDigitalInformatica.setResponsavelPagamento(1L);
			despesaVariavelEntitySoDigitalInformatica.setValorDespesa(new BigDecimal(45));
			despesaVariavelEntitySoDigitalInformatica.setDataDespesa(new Date());
			despesaVariavelEntitySoDigitalInformatica.setQuantidadeItem(1);
			despesaVariavelEntitySoDigitalInformatica.setIsFontePagamentoUnico(true);
			despesaVariavelEntitySoDigitalInformatica.setIsItemUnico(true);
			despesaVariavelEntitySoDigitalInformatica.setObservacaoDespesaVariavel("");
		return despesaVariavelEntitySoDigitalInformatica;
	}
	
	public static DespesaVariavelEntity recuperarDepesaVariavelSupermercadoPraVoce() {
		DespesaVariavelEntity despesaVariavelEntitySupermercadoPraVoce = new DespesaVariavelEntity();
			despesaVariavelEntitySupermercadoPraVoce.setCodigo(1L);
			despesaVariavelEntitySupermercadoPraVoce.setFavorecido(new FavorecidoDomain(1L));
			despesaVariavelEntitySupermercadoPraVoce.setItemDespesa(1L);
			despesaVariavelEntitySupermercadoPraVoce.setFormaPagamento(1L);
			despesaVariavelEntitySupermercadoPraVoce.setProdutoServico(new ProdutoServicoDomain(1L));
			despesaVariavelEntitySupermercadoPraVoce.setFontePagamento(new FontePagamentoEntity(1L));
			despesaVariavelEntitySupermercadoPraVoce.setCanalPagamento(new CanalPagamentoDomain(1L));
			despesaVariavelEntitySupermercadoPraVoce.setResponsavelPagamento(1L);
			despesaVariavelEntitySupermercadoPraVoce.setValorDespesa(new BigDecimal(45));
			despesaVariavelEntitySupermercadoPraVoce.setDataDespesa(new Date());
			despesaVariavelEntitySupermercadoPraVoce.setQuantidadeItem(1);
			despesaVariavelEntitySupermercadoPraVoce.setIsFontePagamentoUnico(true);
			despesaVariavelEntitySupermercadoPraVoce.setIsItemUnico(true);
			despesaVariavelEntitySupermercadoPraVoce.setObservacaoDespesaVariavel("");
		return despesaVariavelEntitySupermercadoPraVoce;
	}
	
	public static List<DespesaVariavelEntity> findAll() {
		List<DespesaVariavelEntity> despesaVariavelEntityList = new ArrayList<DespesaVariavelEntity>();
			despesaVariavelEntityList.add(recuperarDepesaVariavelSoDigitalInformatica());
			despesaVariavelEntityList.add(recuperarDepesaVariavelSupermercadoPraVoce());
		return despesaVariavelEntityList;
	}

}
