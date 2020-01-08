package br.com.plataformalancamento.dysprosioum.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.jboss.logging.Logger;

import br.com.plataformalancamento.dysprosioum.entity.CanalPagamentoDomain;
import br.com.plataformalancamento.dysprosioum.factory.CanalPagamentoFactory;
import br.com.plataformalancamento.dysprosioum.resource.CanalPagamentoResource;

public class CanalPagamentoResourceTest {
	
	private static final Logger LOGGER = Logger.getLogger(CanalPagamentoResourceTest.class);
	
	public static void main(String[] args) {
		persist();
	}
	
	public static void persist() { 
		CanalPagamentoResource canalPagamentoResource = new CanalPagamentoResource();
		CanalPagamentoDomain canalPagamentoDomain = CanalPagamentoFactory.getCanalPagamentoPagamentoCaixa();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<CanalPagamentoDomain>> constraintViolationSetList = validator.validate(canalPagamentoDomain);
		if(constraintViolationSetList.size() > 0) {
			for(ConstraintViolation<CanalPagamentoDomain> constraintViolation : constraintViolationSetList) {
				getLogger().error(constraintViolation.getMessage());
			}
		} else {
			canalPagamentoResource.persist(CanalPagamentoFactory.getCanalPagamentoPagamentoCaixa());
		}
		
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
