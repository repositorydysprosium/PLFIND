package br.com.plataformalancamento.dysprosioum.factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;

public class CanalPagamentoFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public CanalPagamentoFactory() { }
	
	public static CanalPagamentoDomain getCanalPagamentoPagamentoCaixa() {
		CanalPagamentoDomain canalPagamentoDomain = new CanalPagamentoDomain();
			canalPagamentoDomain.setNome("Pagamento em Caixa");
			canalPagamentoDomain.setIsValido(Boolean.TRUE);
		return canalPagamentoDomain;
	}
	
	public static CanalPagamentoDomain getCanalPagamentoPagamentoInternetBanking() {
		CanalPagamentoDomain canalPagamentoDomain = new CanalPagamentoDomain();
			canalPagamentoDomain.setCodigo(2L);
			canalPagamentoDomain.setNome("Pagamento via Internet Banking");
			canalPagamentoDomain.setIsValido(Boolean.TRUE);
		return canalPagamentoDomain;
	}
	
	public static CanalPagamentoDomain getCanalPagamentoPagamentoCartaoCredito() {
		CanalPagamentoDomain canalPagamentoDomain = new CanalPagamentoDomain();
			canalPagamentoDomain.setCodigo(3L);
			canalPagamentoDomain.setNome("Pagamento via Cartão de Crédito");
			canalPagamentoDomain.setIsValido(Boolean.TRUE);
		return canalPagamentoDomain;
	}
	
	public static CanalPagamentoDomain getCanalPagamentoPagamentoBoletoBancario() {
		CanalPagamentoDomain canalPagamentoDomain = new CanalPagamentoDomain();
			canalPagamentoDomain.setCodigo(4L);
			canalPagamentoDomain.setNome("Pagamento via Boleto Bancário");
			canalPagamentoDomain.setIsValido(Boolean.TRUE);
		return canalPagamentoDomain;
	}
	
	public static CanalPagamentoDomain getCanalPagamentoPagamentoChequePredatado() {
		CanalPagamentoDomain canalPagamentoDomain = new CanalPagamentoDomain();
			canalPagamentoDomain.setCodigo(5L);
			canalPagamentoDomain.setNome("Pagamento via Cheque Predatado");
			canalPagamentoDomain.setIsValido(Boolean.TRUE);
		return canalPagamentoDomain;
	}
	
	public static List<CanalPagamentoDomain> finAll() {
		List<CanalPagamentoDomain> canalPagamentoDomainList = new ArrayList<CanalPagamentoDomain>();
			canalPagamentoDomainList.add(getCanalPagamentoPagamentoCaixa());
			canalPagamentoDomainList.add(getCanalPagamentoPagamentoInternetBanking());
			canalPagamentoDomainList.add(getCanalPagamentoPagamentoCartaoCredito());
			canalPagamentoDomainList.add(getCanalPagamentoPagamentoBoletoBancario());
			canalPagamentoDomainList.add(getCanalPagamentoPagamentoChequePredatado());
		return canalPagamentoDomainList;
	}

}
