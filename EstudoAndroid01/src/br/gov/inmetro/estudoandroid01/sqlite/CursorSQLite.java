package br.gov.inmetro.estudoandroid01.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.database.Cursor;

/**
 * Classe responsavel para construir cursores do database SQLite
 * 
 * @author fcsilva
 *
 * @param <A>
 */
public class CursorSQLite<A> {

	private Cursor cursor;
	private List<String> listCampos;
	private List<Integer> listIntIndex;
	private List<Object> listObjectValue;
	private static Object instancia;
	
	public static Object getInstancia() {
		return instancia;
	}
	public static void setInstancia(Object instancia) {
		CursorSQLite.instancia = instancia;
	}

	/**
	 * Construtor
	 * 
	 * @param cursor
	 */
	public CursorSQLite(Cursor cursor){
		this.cursor = cursor;
	}

	public CursorSQLite<A> addCampo(String campo) {
		listCampos.add(campo);
		return this;
	}
	
	public void addCursorIndex() {
		for(int i = 0; i < listCampos.size(); i++) {
			listIntIndex.add(cursor.getColumnIndex(listCampos.get(i)));
		}
	}
	
	@SuppressLint("NewApi")
	public void addCursorValue() {
		for(int i = 0; i < listIntIndex.size(); i++) {
			listObjectValue.add(cursor.getType(i));
		}
	}
	
	public Integer getIndex(int index) {
		return listIntIndex.get(index);
	}
	
	public Object getValue(int index) {
		return listObjectValue.get(index);
	}
	
	@SuppressLint("NewApi")
	public <T> List<A> constroiCursor(){
		List<A> listItems = new ArrayList<A>();
		
		if(cursor == null)
            return listItems;
        try {
 
            if (cursor.moveToFirst()) {
                do {
                	addCursorIndex();
                	addCursorValue();
                    @SuppressWarnings("unchecked")
					A item = (A) CursorSQLite.getInstancia();
                    listItems.add(item);
 
                } while (cursor.moveToNext());
            }
             
        } finally {
            cursor.close();
        }
		
        return listItems;
	}

	
}
