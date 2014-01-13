package br.gov.inmetro.estudoandroid01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import br.gov.inmetro.estudoandroid01.util.Alerta;
import br.gov.inmetro.estudoandroid01.util.AlertaMenu;
import br.gov.inmetro.estudoandroid01.util.Arquivo;
import br.gov.inmetro.estudoandroid01.util.Navegacao;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StorageActivity extends Activity {

	private Arquivo arquivo;
	private Navegacao navegacao;
	private Alerta alerta;
	private EditText editNomeArquivo;
	private EditText editConteudoArquivo;
	private Button botaoSalvarArquivo;
	private Button btnListarArquivos;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.storage_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
			case R.id.principal:
				navegacao.irPara(MainActivity.class).start();
				return true;
			case R.id.listar:
				//implementar...
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_storage);
		
		editNomeArquivo = (EditText)findViewById(R.id.editNomeArquivo);
		editConteudoArquivo = (EditText)findViewById(R.id.editConteudoArquivo);
		botaoSalvarArquivo = (Button)findViewById(R.id.btnSalvarArquivo);
		btnListarArquivos = (Button)findViewById(R.id.btnListarArquivos);
		arquivo = new Arquivo(StorageActivity.this);
		alerta = new Alerta(StorageActivity.this);
		navegacao = new Navegacao(StorageActivity.this);
		
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		botaoSalvarArquivo.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(!editNomeArquivo.getText().toString().isEmpty() && !editConteudoArquivo.getText().toString().isEmpty()) {
					String nomeArquivo = editNomeArquivo.getText().toString();
					String conteudoArquivo = editConteudoArquivo.getText().toString();
					arquivo.criar(conteudoArquivo, nomeArquivo);
					String strArquivo = arquivo.ler(nomeArquivo);
					
					alerta.exibir(getString(R.string.msgSucesso), strArquivo, getString(R.string.msgOk));
				}
			}
		});
		
		
		btnListarArquivos.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				StringBuilder strbuilder = new StringBuilder();
				File[] arrayFile = arquivo.listarArquivos();
				for(File arquivo : arrayFile) {
					strbuilder.append(String.format("nome: %s tam: %sb\n", arquivo.getName(), (arquivo.length())));
				}
				alerta.exibir(getString(R.string.listarArquivos), strbuilder.toString(), getString(R.string.msgOk));
			}
			
		});
		
		
	}

}
