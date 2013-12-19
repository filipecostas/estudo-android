package br.gov.inmetro.estudoandroid01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.gov.inmetro.estudoandroid01.util.Navegacao;

public class MainActivity extends Activity {

	private Button btnSqlite;
	private Navegacao navegacao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSqlite = (Button)findViewById(R.id.btnSqlite);
		navegacao = new Navegacao(MainActivity.this);
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		btnSqlite.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				navegacao.irPara(SqliteActivity.class);
			}
			
		});
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

}
