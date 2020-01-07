package br.com.plataformalancamento.dysprosioum.factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.FavorecidoDomain;

public class FavorecidoFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private FavorecidoFactory() { }
	
	public static FavorecidoDomain recuperarFavorecidoBancoSantander() {
		FavorecidoDomain favorecidoDomain = new FavorecidoDomain();
			favorecidoDomain.setCodigo(1L);
			favorecidoDomain.setNome("Banco Santander (Nacional)");
		return favorecidoDomain;
	}
	
	public static FavorecidoDomain recuperarFavorecidoSoDigital() {
		FavorecidoDomain favorecidoDomain = new FavorecidoDomain();
			favorecidoDomain.setCodigo(2L);
			favorecidoDomain.setNome("Só Digital Comércio e Serviço de Informática (Plano Piloto)");
		return favorecidoDomain;
	}
	
	public static FavorecidoDomain recuperarFavorecidoBancoCaixaEconômicaFederal() {
		FavorecidoDomain favorecidoDomain = new FavorecidoDomain();
			favorecidoDomain.setCodigo(3L);
			favorecidoDomain.setNome("Banco Caixa Econômica Federal (Nacional)");
		return favorecidoDomain;
	}
	
	public static FavorecidoDomain recuperarFavorecidoBancoBrasil() {
		FavorecidoDomain favorecidoDomain = new FavorecidoDomain();
			favorecidoDomain.setCodigo(4L);
			favorecidoDomain.setNome("Banco do Brasil (Nacional)");
		return favorecidoDomain;
	}
	
	public static FavorecidoDomain recuperarFavorecidoLoterica() {
		FavorecidoDomain favorecidoDomain = new FavorecidoDomain();
			favorecidoDomain.setCodigo(5L);
			favorecidoDomain.setNome("Lotérica (Setor Bancário Norte)");
		return favorecidoDomain;
	}
	
	public static FavorecidoDomain recuperarFavorecidoSupermercadoPraVoce() {
		FavorecidoDomain favorecidoDomain = new FavorecidoDomain();
			favorecidoDomain.setCodigo(6L);
			favorecidoDomain.setNome("Supermercado PraVocê (Taguatinga Centro)");
		return favorecidoDomain;
	}
	
	public static FavorecidoDomain recuperarFavorecidoPanificadoraReiPao() {
		FavorecidoDomain favorecidoDomain = new FavorecidoDomain();
			favorecidoDomain.setCodigo(7L);
			favorecidoDomain.setNome("Panificadora Rei do Pão (Taguatinga Centro)");
		return favorecidoDomain;
	}
	
	public static List<FavorecidoDomain> findAll() {
		List<FavorecidoDomain> favorecidoDomainList = new ArrayList<FavorecidoDomain>();
			favorecidoDomainList.add(recuperarFavorecidoSoDigital());
			favorecidoDomainList.add(recuperarFavorecidoBancoBrasil());
			favorecidoDomainList.add(recuperarFavorecidoBancoCaixaEconômicaFederal());
			favorecidoDomainList.add(recuperarFavorecidoBancoSantander());
			favorecidoDomainList.add(recuperarFavorecidoLoterica());
			favorecidoDomainList.add(recuperarFavorecidoPanificadoraReiPao());
			favorecidoDomainList.add(recuperarFavorecidoSupermercadoPraVoce());
			favorecidoDomainList.add(recuperarFavorecidoBancoBrasil());
		return favorecidoDomainList;
	}

}
