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

	protected Activity activity;
	protected AlertDialog.Builder alertBuilder;
	private boolean canceble;

	public boolean isCanceble() {
		return canceble;
	}
	public void setCanceble(boolean canceble) {
		this.canceble = canceble;
	}

	public Alerta(Activity activity) {
		this.activity = activity;
		this.canceble = false;
	}

	
	/**
	 * Criar AlertDialog
	 * 
	 * @param titulo : String
	 * @param mensagem : String
	 */
	public void exibir(String titulo, String mensagem) {
		alertBuilder = new AlertDialog.Builder(activity);
		alertBuilder.create();

		if (!titulo.isEmpty()) {
			alertBuilder.setTitle(titulo);
		}

		if (!mensagem.isEmpty()) {
			alertBuilder.setMessage(mensagem);
		}

		alertBuilder.setCancelable(isCanceble());
	}

	
	/**
	 * Sobrecarga Exibe Alerta com opcao de implementacao do botao para cancelar
	 * 
	 * @param titulo : String
	 * @param mensagem : String
	 * @param textBtnOpcao : String
	 */
	public void exibir(String titulo, String mensagem, String textBtnOpcao) {
		exibir(titulo, mensagem);
		if (!textBtnOpcao.isEmpty()) {
			alertBuilder.setNegativeButton(textBtnOpcao,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
		}
		alertBuilder.show();
	}

	
	/**
	 * Sobrecarga Exibe Alerta com opcao de implementacao do botao positivo e
	 * negativo
	 * 
	 * @param titulo: String
	 * @param mensagem: String
	 * @param textBtnOpcao: String[]
	 * @param positiveDialogOnClickListener
	 *            Implementar a Inteface DialogInterface para eventos positivos
	 *            - new DialogInterface.OnClickListener() { public void
	 *            onClick(DialogInterface dialog, int id) { //aqui faz o envio
	 *            da avaliacao enviarAvaliacao(); } }
	 * @param negativeDialogOnClickListener
	 *            Implementar a Inteface DialogInterface para eventos negativos
	 *            - new DialogInterface.OnClickListener() { public void
	 *            onClick(DialogInterface dialog, int id) { //aqui faz o envio
	 *            da avaliacao enviarAvaliacao();
	 */
	public void exibir(String titulo, String mensagem, String[] textBtnOpcao,
			DialogInterface.OnClickListener positiveDialogOnClickListener,
			DialogInterface.OnClickListener negativeDialogOnClickListener) {
		exibir(titulo, mensagem);
		if (textBtnOpcao.length > 0) {
			alertBuilder.setPositiveButton(textBtnOpcao[0],
					positiveDialogOnClickListener);
			alertBuilder.setNegativeButton(textBtnOpcao[1],
					negativeDialogOnClickListener);
		}
		alertBuilder.show();
	}
	
	
	
}
