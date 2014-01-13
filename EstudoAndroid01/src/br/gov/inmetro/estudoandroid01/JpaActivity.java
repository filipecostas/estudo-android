package br.gov.inmetro.estudoandroid01;

import android.app.Activity;
import android.os.Bundle;
import br.gov.inmetro.estudoandroid01.util.Navegacao;

public class JpaActivity extends Activity {

	private Navegacao navegacao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jpa);
		
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}
}
