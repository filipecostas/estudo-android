package br.gov.inmetro.estudoandroid01;

import nl.renarj.jasdb.api.DBSession;
import nl.renarj.jasdb.api.SimpleEntity;
import nl.renarj.jasdb.api.model.EntityBag;
import nl.renarj.jasdb.core.exceptions.*;

import com.obera.jasdb.android.AndroidDBSession;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class JasdbActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jasdb);

		try {
			DBSession session = new AndroidDBSession(getApplicationContext());
			EntityBag bag = session.createOrGetBag("bag1");
			String documentedId = bag.addEntity(new SimpleEntity().addProperty("testProperty", "SimpleValue")).getInternalId();

			Log.i("JasDb", "Found entity: " + SimpleEntity.toJson(bag.getEntity(documentedId)));
			
		} catch (JasDBStorageException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void onStart() {
		super.onStart();

	}
}
