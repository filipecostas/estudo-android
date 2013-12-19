package br.gov.inmetro.estudoandroid01.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Classe para cria alertas
 * 
 * @author fcsilva
 * 
 */
public class Alerta {

	Activity activity;
	AlertDialog.Builder builder;

	public Alerta(Activity activity) {
		this.activity = activity;
	}

	public void exibir(String titulo, String mensagem) {
		builder = new AlertDialog.Builder(activity);
		builder.create();

		if (titulo != "") {
			builder.setTitle(titulo);
		}

		if (mensagem != "") {
			builder.setMessage(mensagem);
		}

		builder.setCancelable(false);
	}

	public void exibir(String titulo, String mensagem, String textBtnOpcao) {
		exibir(titulo, mensagem);
		if (!textBtnOpcao.isEmpty()) {
			builder.setNegativeButton(textBtnOpcao,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
		}
		builder.show();
	}
	
	public void exibir(String titulo, String mensagem, String[] textBtnOpcao, DialogInterface.OnClickListener positiveDialogOnClickListener, DialogInterface.OnClickListener negativeDialogOnClickListener ) {
		exibir(titulo, mensagem);
		if (textBtnOpcao.length > 0) {
			builder.setPositiveButton(textBtnOpcao[0], positiveDialogOnClickListener);
			builder.setNegativeButton(textBtnOpcao[1], negativeDialogOnClickListener);
		}
		builder.show();
	}

}
