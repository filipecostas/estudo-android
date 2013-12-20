package br.gov.inmetro.estudoandroid01.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;

/**
 * Classe para auxiliar na navegacao entre activitys
 * 
 * @author fcsilva
 *
 */
public class Navegacao {

	private Activity activity;
	private Intent itent;

	public Intent getItent() {
		return itent;
	}

	public void setItent(Intent itent) {
		this.itent = itent;
	}
		
	public Navegacao(Activity activity) {
		this.activity = activity;
	}
	
	public void irPara(Class<?> alvo) {
		itent = new Intent(activity, alvo);
		activity.startActivity(itent);
	}
	
	public void post(ArrayList<String> params, ArrayList<String> itens) {
		for(int i = 0; i < params.size(); i++) {
			itent.putExtra(params.get(i), itens.get(i));
		}
	}

	
}
