package br.gov.inmetro.estudoandroid01.jasdb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nl.renarj.jasdb.api.DBSession;
import nl.renarj.jasdb.api.SimpleEntity;
import nl.renarj.jasdb.api.model.EntityBag;
import nl.renarj.jasdb.api.query.QueryResult;
import nl.renarj.jasdb.core.exceptions.JasDBStorageException;
import android.app.Activity;
import android.util.Log;

import com.obera.jasdb.android.AndroidDBSession;

public class PessoaJasdb extends EntidadeJasdb<Pessoa> {

	public static final String NOME_BAG = "Pessoa";

	public PessoaJasdb(SessaoJasdb sessao) {
		super.novoBag(sessao, NOME_BAG);
	}

	@Override
	public void criar(List<Pessoa> listPessoa) {
		try {
			for (Pessoa pessoa : listPessoa) {
				SimpleEntity entity = new SimpleEntity();
				entity.addProperty("Nome", pessoa.getNome());
				entity.addProperty("Email", pessoa.getEmail());
				entity.addProperty("Idade", pessoa.getIdade());
				bag.addEntity(entity);
				Log.i("PessoaJasdb", "Criando bag: " + SimpleEntity.toJson(entity));
			}

		} catch (JasDBStorageException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Pessoa> listarTodos() {
		
		List<Pessoa> listPessoa = new ArrayList<Pessoa>();
		
		try {
			QueryResult result = bag.getEntities();
			for (SimpleEntity entity : result) {
				/*Pessoa pessoa = new Pessoa(
						entity.getProperty("Nome").toString(),
						entity.getProperty("Email").toString(),
						Integer.parseInt(entity.getProperty("Idade").toString()));
				listPessoa.add(pessoa);*/
				Log.i("PessoaJasdb", "Listando bag: " + SimpleEntity.toJson(entity));
			}
		} catch (JasDBStorageException e) {
			e.printStackTrace();
		}
		
		return listPessoa;
	}

	@Override
	protected void porID(String strIDEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void remover(EntityBag bag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void alterar(EntityBag bag) {
		// TODO Auto-generated method stub
		
	}

	

}
