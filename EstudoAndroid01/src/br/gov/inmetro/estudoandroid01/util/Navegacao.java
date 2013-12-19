package br.gov.inmetro.estudoandroid01.util;

import android.app.Activity;
import android.content.Intent;

public class Navegacao {

	private Activity activity;
	
	public Navegacao(Activity activity) {
		this.activity = activity;
	}
	
	public void irPara(Class<?> alvo) {
		Intent i = new Intent(activity, alvo);
		activity.startActivity(i);
	}
	
}
