package br.gov.inmetro.estudoandroid01.jpaandroid;

import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import android.content.Context;

/**
 * Dao Generica para classes
 * 
 * @author fcsilva
 *
 * @param <E>
 */
public abstract class DAOJpaAndroid<E> extends JpaAndroidHelper<E> {

	protected Dao<E, Integer> dao;
	private Class<E> type;

	public DAOJpaAndroid(Context context, Class<E> type) {
		super(context);
		this.type = type;
		setDao();
	}

	protected void setDao() {
		try {
			dao = DaoManager.createDao(getConnectionSource(), type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<E> getAll() {
		try {
			List<E> result = dao.queryForAll();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public E getById(int id) {
		try {
			E obj = dao.queryForId(id);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insert(E obj) {
		try {
			dao.create(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(E obj) {
		try {
			dao.delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(E obj) {
		try {
			dao.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
