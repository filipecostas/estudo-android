package br.gov.inmetro.estudoandroid01.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

/**
 * Classe para manipular arquivos
 * @author fcsilva
 *
 */
public class Arquivo {
	
	Activity activity;
	
	public Arquivo(Activity activity) {
		this.activity = activity;
	}
	
	/**
	 * Criar arquivo interno
	 * 
	 * @param conteudo : String
	 * @param nomeArquivo : String
	 */
	public void criar(String conteudo, String nomeArquivo) {
		String strJson = conteudo;
		try {
			FileOutputStream outputStream = activity.openFileOutput(nomeArquivo, Context.MODE_PRIVATE);
			outputStream.write(strJson.getBytes());
			outputStream.close();
			Log.i("mensagem", "arquivo criado com sucesso");
			Log.i("data", activity.getFilesDir().toString());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ler arquivo interno
	 * 
	 * @param nomeArquivo : String
	 * @return
	 */
	public String ler(String nomeArquivo) {
		String strArquivo = String.valueOf("");
		try {
			FileInputStream inputStream = activity.openFileInput(nomeArquivo);
        	InputStreamReader inputreader = new InputStreamReader(inputStream);
	        BufferedReader buffreader = new BufferedReader(inputreader);
	        while(buffreader.ready()) {
	        	strArquivo += buffreader.readLine();
	        }
	        inputreader.close();
			Log.i("mensagem", "arquivo lido com sucesso");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return strArquivo;
	}
	
	/**
	 * Lista arquivos internos
	 * 
	 * @return arrayArquivos
	 */
	public File[] listarArquivos(){
		File[] arrayArquivos = null;
		try {
			arrayArquivos = activity.getFilesDir().listFiles();
			for(int i = 0; i < arrayArquivos.length; i++) {
				Log.i("arquivos", arrayArquivos[i].getName().toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return arrayArquivos;
	}

}
