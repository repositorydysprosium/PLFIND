package br.com.plataformalancamento.dysprosioum.repository;

import java.util.List;

public interface BaseInterfaceRepository<C> {
	public C persist(C object);
//	public List<C> persistAll();
	public C remove(C object);
	public C update(C object);
	public List<C> findAll();
	public C findOne(Long codigo);
	public C findOne(String descricao);
}
