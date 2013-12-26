package br.gov.inmetro.estudoandroid01;

import br.gov.inmetro.estudoandroid01.sqlite.Veiculo;
import br.gov.inmetro.estudoandroid01.sqlite.VeiculoDAO;
import br.gov.inmetro.estudoandroid01.util.Alerta;
import br.gov.inmetro.estudoandroid01.util.Navegacao;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 
 * @author fcsilva
 * 
 */
public class SqliteFormularioActivity extends Activity {

	private Navegacao nav;
	private VeiculoDAO daoVeiculo;
	private EditText editNome, editMarca, editAno;
	private Button btnSalvar;
	private Veiculo veiculo;
	private Alerta alerta;
	private Integer ID = 0;
	

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
			nav.irPara(MainActivity.class).start();
			return true;
		case R.id.cadastrar:
			nav.irPara(SqliteFormularioActivity.class).start();
			return true;
		case R.id.listar:
			nav.irPara(SqliteActivity.class).start();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_formulario);

		nav = new Navegacao(this);
		alerta = new Alerta(this);
		daoVeiculo = new VeiculoDAO(this);
		editNome = (EditText) findViewById(R.id.editNome);
		editMarca = (EditText) findViewById(R.id.editMarca);
		editAno = (EditText) findViewById(R.id.editAno);
		btnSalvar = (Button) findViewById(R.id.btnSalvar);
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		if(getIntent().hasExtra("id")){
			Bundle extra = getIntent().getExtras();
			ID = (int)extra.getLong("id");
			if(ID > 0) {
				veiculo = daoVeiculo.retornarPorId(ID);
				editNome.setText(veiculo.getNome());
				editMarca.setText(veiculo.getMarca());
				editAno.setText(Integer.toString(veiculo.getAno()));
			}
		}
		
		btnSalvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				if(!editNome.getText().toString().isEmpty() && !editMarca.getText().toString().isEmpty() && !editAno.getText().toString().isEmpty()) {
					veiculo = new Veiculo(editNome.getText().toString(), editMarca.getText().toString(),
							Integer.parseInt(editAno.getText().toString()));
					
					if(ID > 0) {
						veiculo.setId(ID);
						daoVeiculo.editar(veiculo);
						alerta.exibir(getString(R.string.msgSucesso), getString(R.string.msgRegistroAlterado), getString(R.string.msgOk));
					} else {
						daoVeiculo.salvar(veiculo);
						alerta.exibir(getString(R.string.msgSucesso), getString(R.string.msgRegistroSalvo), getString(R.string.msgOk));
					}
					
					editNome.setText(String.valueOf(""));
					editMarca.setText(String.valueOf(""));
					editAno.setText(String.valueOf(""));
					
				} else {
					alerta.exibir(getString(R.string.msgAtencao), getString(R.string.msgCamposObrigatorios), getString(R.string.msgOk)); 
				}
			}

		});
	}

}
