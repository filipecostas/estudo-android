package br.gov.inmetro.estudoandroid01;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.gov.inmetro.estudoandroid01.sqlite.Veiculo;
import br.gov.inmetro.estudoandroid01.sqlite.VeiculoDAO;
import br.gov.inmetro.estudoandroid01.util.AlertaMenu;
import br.gov.inmetro.estudoandroid01.util.Navegacao;

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
	List<Long> arrayItensId;
	List<Veiculo> listVeiculo;
	VeiculoDAO daoVeiculo;
	Navegacao navegacao;
	AlertaMenu alerta;

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
				navegacao.irPara(MainActivity.class).start();
				return true;
			case R.id.cadastrar:
				navegacao.irPara(SqliteFormularioActivity.class).start();
				return true;
			case R.id.listar:
				navegacao.irPara(SqliteActivity.class).start();
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
		
		navegacao = new Navegacao(this);
		daoVeiculo = new VeiculoDAO(this);
		alerta = new AlertaMenu(this);
		arrayItens = new ArrayList<String>();
		arrayItensId = new ArrayList<Long>();
		listVeiculo = new ArrayList<Veiculo>();
		listVeiculo = daoVeiculo.listarTodos();
		
		if (listVeiculo.size() > 0) {
			for (Veiculo v : listVeiculo) {
				arrayItens.add(String.format("id: [%s] nome: %s - marca: %s", v.getId(), v.getNome(), v.getMarca()));
				arrayItensId.add(v.getId());
			}
		}
		
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, arrayItens));
		listview = getListView();
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
				TextView textView = (TextView) view;
				String mensagem = String.format("[%s] id: %s - valor: %s", position, id, textView.getText());
				Toast.makeText(SqliteActivity.this, mensagem, Toast.LENGTH_SHORT).show();
				final Long idVeiculo = arrayItensId.get(position);
				
				alerta.addMenu(getString(R.string.editar))
					.addMenu(getString(R.string.excluir))
					.addMenu(getString(R.string.verDetalhes));
				alerta.setCanceble(true);
				alerta.exibir(getString(R.string.msgOpcoes), getString(R.string.nulo), new OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int item) {
						switch(item){
							case 0:
								//Toast.makeText(SqliteActivity.this, arrayItensId.get(position).toString(), Toast.LENGTH_SHORT).show();
								//nav.getItent().putExtra("id", arrayItensId.get(position));
								navegacao.irPara(SqliteFormularioActivity.class);
								
								navegacao.getIntent().putExtra("id", idVeiculo);
								navegacao.start();
								break;
								
							case 1:
								Veiculo veiculoDeletar = new Veiculo(null, null, 0);
								veiculoDeletar.setId(arrayItensId.get(position));
								daoVeiculo.deletar(veiculoDeletar);
								onResume();
								break;
								
							case 2:
								Veiculo veiculoDetalhe = daoVeiculo.retornarPorId(idVeiculo);
								String strMensagem = String.format("nome: %s \nmarca: %s\nano: %s", veiculoDetalhe.getNome(), veiculoDetalhe.getMarca(), Integer.toString(veiculoDetalhe.getAno()));
								alerta.exibir(getString(R.string.msgAtencao), strMensagem, getString(R.string.msgOk));
								break;
						}
					}
					
				});
			}

		});
		
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		
	}
	
	
	@Override
	protected void onResume(){
		super.onResume();
		
		
	}

}
