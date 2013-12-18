package br.gov.inmetro.estudoandroid01;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}
	
	
	/*@Override
	public void onStart(){
		Toast.makeText(MainActivity.this, "Implementou onStart", Toast.LENGTH_SHORT).show();
	}
    
	@Override
	public void onRestart(){
		Toast.makeText(MainActivity.this, "Implementou onRestart", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onResume(){
		Toast.makeText(MainActivity.this, "Implementou onResume", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onPause(){
		Toast.makeText(MainActivity.this, "Implementou onPause", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStop(){
		Toast.makeText(MainActivity.this, "Implementou onStop", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDestroy(){
    	
    }*/
	
}
