package br.gov.inmetro.estudoandroid01.jpaandroid;

import android.content.Context;

/**
 * Dao espeficia da entidade
 * 
 * @author fcsilva
 *
 */
public class ClienteDAO extends DAOJpaAndroid<Cliente>{
	
	public ClienteDAO(Context context) {
		super(context, Cliente.class);
	}
}
