package br.gov.inmetro.estudoandroid01;

import br.gov.inmetro.estudoandroid01.sqlite.Veiculo;
import br.gov.inmetro.estudoandroid01.sqlite.VeiculoDAO;
import br.gov.inmetro.estudoandroid01.util.Navegacao;
import android.app.Activity;
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
	EditText editNome, editMarca, editAno;
	Button btnSalvar;
	Veiculo veiculo;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_formulario);

		nav = new Navegacao(this);
		daoVeiculo = new VeiculoDAO(this);

		editNome = (EditText) findViewById(R.id.editNome);
		editMarca = (EditText) findViewById(R.id.editMarca);
		editAno = (EditText) findViewById(R.id.editAno);
		btnSalvar = (Button) findViewById(R.id.btnSalvar);

	}

	@Override
	protected void onStart() {
		super.onStart();

		btnSalvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				veiculo = new Veiculo(editNome.getText().toString(), editMarca.getText().toString(),
							Integer.parseInt(editAno.getText().toString()));
				
				if(!veiculo.getNome().isEmpty() && !veiculo.getMarca().isEmpty() && !(veiculo.getAno() > 0)) {
					daoVeiculo.salvar(veiculo);
				} else {
					
				}
					

			}

		});
	}

}
