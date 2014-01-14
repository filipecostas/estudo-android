package br.gov.inmetro.estudoandroid01.jasdb;

import java.util.List;

import nl.renarj.jasdb.api.DBSession;
import nl.renarj.jasdb.api.model.EntityBag;
import nl.renarj.jasdb.core.exceptions.JasDBStorageException;

import com.obera.jasdb.android.AndroidDBSession;

import android.app.Activity;
import android.util.Log;

public class SessaoJasdb {

	private Activity activity;
	private DBSession session;
	
	public SessaoJasdb(Activity activity) {
		this.activity = activity;
	}
	
	public void criar() {
		try {
			session = new AndroidDBSession(activity);
			Log.i("SessaoJasdb", "Criando sessao: " + session.getInstanceId());

		} catch (JasDBStorageException e) {
			e.printStackTrace();
		}
	}
	
	
	public EntityBag novoBag(String nome) {
		EntityBag bag = null;
		try {
			bag = session.createOrGetBag(nome);
			Log.i("SessaoJasdb", "Criando bag: " + bag.getName());
		} catch (JasDBStorageException e) {
			e.printStackTrace();
		}
		return bag;
	}
	
	
	public void removerBag(String nomeBag) {
		try {
			session.removeBag(nomeBag);
		} catch (JasDBStorageException e) {
			e.printStackTrace();
		}
	}
	
	public void listarBags() {
		try {
			List<EntityBag> listBag = session.getBags();
			
			for(int i = 0; i < listBag.size(); i++) {
				Log.i("SessaoJasdb", "Listando bag: name: " + listBag.get(i).getName() + ", size: " + listBag.get(i).getSize());
			}
			
		} catch (JasDBStorageException e) {
			e.printStackTrace();
		}
	}
	
	public void fechar() {
		try {
			session.closeSession();
		} catch (JasDBStorageException e) {
			e.printStackTrace();
		}
	}
}
