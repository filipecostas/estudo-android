package br.gov.inmetro.estudoandroid01.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;

public class AlertaMenu extends Alerta {
	
	List<String> listMenu;
	
	public AlertaMenu(Activity activity) {
		super(activity);
		listMenu = new ArrayList<String>();
	}

	/**
	 * Criar Dialog de contexto para menu
	 * 
	 * @see Important! Implementar o metodo addMenu(item) para ser adicionado o menu.
	 * 
	 * @param titulo : String
	 * @param mensagem : String
	 * @param implementacaoOnClickListener : Interface OnClickListener new OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int item) {
						switch(item){
							case 0:
								// implementacao menu 0...
								break;
								
							case 1:
								// implementacao menu 1...
								break;
								
							case 2:
								// implementacao menu 2...
								break;
						}
					}
					
				}
	 */
	public void exibir(String titulo, String mensagem, DialogInterface.OnClickListener implementacaoOnClickListener){
		
		if(listMenu.size() > 0) {
			exibir(titulo, mensagem);
			CharSequence[] items = listMenu.toArray(new CharSequence[listMenu.size()]);
			alertBuilder.setItems(items, implementacaoOnClickListener);
		} else {
			exibir(titulo, "Nenhum menu adicionado.");
		}
		alertBuilder.show();
		listMenu.clear();
	}
	
	public AlertaMenu addMenu(String item) {
		listMenu.add(item);
		return this;
	}
	
	
}
