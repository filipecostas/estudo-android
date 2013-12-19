package br.gov.inmetro.estudoandroid01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.gov.inmetro.estudoandroid01.sqlite.Veiculo;
import br.gov.inmetro.estudoandroid01.sqlite.VeiculoDAO;
import br.gov.inmetro.estudoandroid01.util.Navegacao;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author fcsilva
 * 
 *         Consultar:
 *         http://arthurlehdermann.wordpress.com/2013/03/11/android-criando-um-listview-personalizado/
 *         http://www.javacodegeeks.com/2013/06/android-listview-tutorial-and-basic-example.html
 * 
 */

public class SqliteActivity extends ListActivity {

	ListView listview;
	List<String> arrayItens;
	List<Veiculo> listVeiculo;
	VeiculoDAO daoVeiculo;
	Navegacao nav;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.sqlite_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
			case R.id.principal:
				nav.irPara(MainActivity.class);
				return true;
			case R.id.cadastrar:
				nav.irPara(SqliteFormularioActivity.class);
				return true;
			case R.id.listar:
				nav.irPara(SqliteActivity.class);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar barra = getActionBar();
		barra.setDisplayOptions(ActionBar.NAVIGATION_MODE_TABS);
		
		nav = new Navegacao(this);
		daoVeiculo = new VeiculoDAO(this);
		arrayItens = new ArrayList<String>();
		listVeiculo = new ArrayList<Veiculo>();
		listVeiculo = daoVeiculo.listarTodos();
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		if (listVeiculo.size() > 0) {
			for (Veiculo v : listVeiculo)
				arrayItens.add(String.format("id: [%s] nome: %s - marca: %s", v.getId(), v.getNome(), v.getMarca()));
		}

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, arrayItens));
		listview = getListView();

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView textView = (TextView) view;
				String mensgagem = String.format("[%s] id: %s - valor: %s", position, id, textView.getText());
				Toast.makeText(SqliteActivity.this, mensgagem, Toast.LENGTH_SHORT).show();
			}

		});

	}

}
