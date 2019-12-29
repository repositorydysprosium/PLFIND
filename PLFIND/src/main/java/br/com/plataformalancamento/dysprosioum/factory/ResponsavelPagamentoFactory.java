package br.com.plataformalancamento.dysprosioum.factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.ResponsavelPagamentoDomain;

public class ResponsavelPagamentoFactory implements Serializable {

	private static final long serialVersionUID = 1L;

	public ResponsavelPagamentoFactory() { }
	
	public static ResponsavelPagamentoDomain getResposanvelPagamentoJamille() {
		ResponsavelPagamentoDomain responsavelPagamentoDomain = new ResponsavelPagamentoDomain();
			responsavelPagamentoDomain.setNome("Jamille Alves");
			responsavelPagamentoDomain.setCodigo(1L);
			responsavelPagamentoDomain.setIsFontePagamento(Boolean.TRUE);
			responsavelPagamentoDomain.setIsPessoaFinanceira(Boolean.TRUE);
			responsavelPagamentoDomain.setIsValido(Boolean.TRUE);
		return responsavelPagamentoDomain;
	}
	
	public static ResponsavelPagamentoDomain getResposanvelPagamentoJose() {
		ResponsavelPagamentoDomain responsavelPagamentoDomain = new ResponsavelPagamentoDomain();
			responsavelPagamentoDomain.setNome("José Quintin");
			responsavelPagamentoDomain.setCodigo(2L);
			responsavelPagamentoDomain.setIsFontePagamento(Boolean.TRUE);
			responsavelPagamentoDomain.setIsPessoaFinanceira(Boolean.TRUE);
			responsavelPagamentoDomain.setIsValido(Boolean.TRUE);
		return responsavelPagamentoDomain;
	}
	
	public static List<ResponsavelPagamentoDomain> finAll() {
		List<ResponsavelPagamentoDomain> responsavelPagamentoDomainList = new ArrayList<ResponsavelPagamentoDomain>();
			responsavelPagamentoDomainList.add(getResposanvelPagamentoJamille());
			responsavelPagamentoDomainList.add(getResposanvelPagamentoJose());
		return responsavelPagamentoDomainList;
	}
	
}
