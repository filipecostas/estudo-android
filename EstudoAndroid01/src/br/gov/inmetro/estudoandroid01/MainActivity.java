package br.gov.inmetro.estudoandroid01;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.gov.inmetro.estudoandroid01.util.Navegacao;

public class MainActivity extends Activity {

	private Button btnSqlite;
	private Navegacao navegacao;
	private Button btnStorage;
	private Button btnJpaAndroid;
	private Button btnJasDb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSqlite = (Button)findViewById(R.id.btnSqlite);
		btnStorage = (Button)findViewById(R.id.btnStorage);
		btnJpaAndroid = (Button)findViewById(R.id.btnJpaAndroid);
		btnJasDb = (Button)findViewById(R.id.btnJasDb);
		navegacao = new Navegacao(MainActivity.this);
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		btnStorage.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				navegacao.irPara(StorageActivity.class).start();
			}
			
		});
		
		btnSqlite.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				navegacao.irPara(SqliteActivity.class).start();
			}
			
		});
		
		btnJpaAndroid.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				navegacao.irPara(JpaActivity.class).start();
			}
			
		});
		
		btnJasDb.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				navegacao.irPara(JasdbActivity.class).start();
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






