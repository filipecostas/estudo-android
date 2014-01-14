package br.gov.inmetro.estudoandroid01.jasdb;

import java.util.List;

import nl.renarj.jasdb.api.model.EntityBag;

public abstract class EntidadeJasdb<T> {
	
	protected SessaoJasdb sessao;
	protected EntityBag bag;
	
	public SessaoJasdb getSessao() {
		return sessao;
	}
	public void setSessao(SessaoJasdb sessao) {
		this.sessao = sessao;
	}
	
	public EntityBag getBag() {
		return bag;
	}
	public void setBag(EntityBag bag) {
		this.bag = bag;
	}
	
	public void novoBag(SessaoJasdb sessao, String nomeBag){
		this.setSessao(sessao);
		bag = getSessao().novoBag(nomeBag);
	}
	
	protected abstract void criar(List<T> listPessoa);
	protected abstract List<T> listarTodos();
	protected abstract void porID(String strIDEntity);
	protected abstract void remover(EntityBag bag);
	protected abstract void alterar(EntityBag bag);
	
	
}
