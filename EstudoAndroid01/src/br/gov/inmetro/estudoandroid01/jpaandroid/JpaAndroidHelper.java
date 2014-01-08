package br.gov.inmetro.estudoandroid01.jpaandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * A biblioteca OrmLite trabalha com o JPA e facilita a construcao da
 * persistencia
 * 
 * @author fcsilva
 * 
 * @param <E>
 */
public class JpaAndroidHelper<E> extends OrmLiteSqliteOpenHelper {

	public JpaAndroidHelper(Context context) {
		super(context, "ExemploJPA.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource src) {
		try {
			TableUtils.createTable(src, Cliente.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource src,
			int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(src, Cliente.class, true);
			onCreate(db, src);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	 public void close() {
	  super.close();
	 }
}
