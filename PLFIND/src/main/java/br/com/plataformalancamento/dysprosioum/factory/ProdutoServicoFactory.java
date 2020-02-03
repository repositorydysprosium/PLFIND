package br.com.plataformalancamento.dysprosioum.factory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.ProdutoServicoDomain;

public class ProdutoServicoFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static ProdutoServicoDomain produtoServicoDomainMegaSena() {
		ProdutoServicoDomain produtoServicoDomain = new ProdutoServicoDomain();
			produtoServicoDomain.setDescricao("Mega Sena");
			produtoServicoDomain.setQuantidadeProdutoServico(2);
			produtoServicoDomain.setValorProdutoServico(new BigDecimal(4.5));
		return produtoServicoDomain;
	}
	
	public static ProdutoServicoDomain produtoServicoDomainLotofacil() {
		ProdutoServicoDomain produtoServicoDomain = new ProdutoServicoDomain();
			produtoServicoDomain.setDescricao("Lotofacil");
			produtoServicoDomain.setQuantidadeProdutoServico(8);
			produtoServicoDomain.setValorProdutoServico(new BigDecimal(3.5));
		return produtoServicoDomain;
	}
	
	public static List<ProdutoServicoDomain> findAll() {
		List<ProdutoServicoDomain> produtoServicoDomainList = new ArrayList<ProdutoServicoDomain>();
			produtoServicoDomainList.add(produtoServicoDomainLotofacil());
			produtoServicoDomainList.add(produtoServicoDomainMegaSena());
		return produtoServicoDomainList;
	}
	
}
