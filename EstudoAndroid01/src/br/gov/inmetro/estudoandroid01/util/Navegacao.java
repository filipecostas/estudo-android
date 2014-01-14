package br.gov.inmetro.estudoandroid01.util;

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
	private Intent intent;

	public Intent getIntent() {
		return intent;
	}

	public void setintent(Intent intent) {
		this.intent = intent;
	}
		
	public Navegacao(Activity activity) {
		this.activity = activity;
	}
	
	public Navegacao irPara(Class<?> alvo) {
		intent = new Intent(activity, alvo);
		return this;
	}
	
	public Navegacao start() {
		activity.startActivity(intent);
		return this;
	}
}
