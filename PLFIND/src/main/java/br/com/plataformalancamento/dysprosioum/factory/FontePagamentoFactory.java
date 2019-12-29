package br.com.plataformalancamento.dysprosioum.factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.FontePagamentoEntity;

public class FontePagamentoFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public FontePagamentoFactory() { }
	
	public static FontePagamentoEntity getFontePagamentoDinheiro() {
		FontePagamentoEntity fontePagamentoEntity = new FontePagamentoEntity();
			fontePagamentoEntity.setCodigo(1L);
			fontePagamentoEntity.setIsAtivo(Boolean.TRUE);
			fontePagamentoEntity.setNome("Dinheiro");
		return fontePagamentoEntity;
	}
	
	public static FontePagamentoEntity getFontePagamentoBancoSantanderDebito() {
		FontePagamentoEntity fontePagamentoEntity = new FontePagamentoEntity();
			fontePagamentoEntity.setCodigo(2L);
			fontePagamentoEntity.setIsAtivo(Boolean.TRUE);
			fontePagamentoEntity.setNome("Banco Santander (Cartão de Débito)");
		return fontePagamentoEntity;
	}
	
	public static FontePagamentoEntity getFontePagamentoBancoSantanderCredito() {
		FontePagamentoEntity fontePagamentoEntity = new FontePagamentoEntity();
			fontePagamentoEntity.setCodigo(3L);
			fontePagamentoEntity.setIsAtivo(Boolean.TRUE);
			fontePagamentoEntity.setNome("Banco Santander (Cartão de Crédito)");
		return fontePagamentoEntity;
	}
	
	public static List<FontePagamentoEntity> getFontePagamentoList() {
		List<FontePagamentoEntity> fontePagamentoEntityList = new ArrayList<>();
			fontePagamentoEntityList.add(getFontePagamentoDinheiro());
			fontePagamentoEntityList.add(getFontePagamentoBancoSantanderDebito());
			fontePagamentoEntityList.add(getFontePagamentoBancoSantanderCredito());
		return fontePagamentoEntityList;
	}
	
}
