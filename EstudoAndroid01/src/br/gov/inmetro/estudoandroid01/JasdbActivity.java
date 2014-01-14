package br.gov.inmetro.estudoandroid01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import br.gov.inmetro.estudoandroid01.jasdb.PessoaJasdb;
import br.gov.inmetro.estudoandroid01.jasdb.Pessoa;
import br.gov.inmetro.estudoandroid01.jasdb.SessaoJasdb;
import br.gov.inmetro.estudoandroid01.util.Arquivo;

public class JasdbActivity extends Activity {

	PessoaJasdb pessoaJasdb;
	SessaoJasdb sessaoJasdb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jasdb);

		ArrayList<Pessoa> listPessoa = new ArrayList<Pessoa>();
		listPessoa.add(new Pessoa("Filipe Costa", "flp.costas@gmail.com", 29));
		listPessoa.add(new Pessoa("Caroline Souza", "carols@gmail.com", 28));
		listPessoa.add(new Pessoa("David Belmont", "dcbelmont@gmail.com", 31));
		listPessoa.add(new Pessoa("Wellington Lima", "wslima@gmail.com", 26));
		
		Arquivo arquivoJasdb = new Arquivo(this);
		String strArquivo = arquivoJasdb.ler("Pessoa.pjs");
		Log.i("arquivo", strArquivo);
		
		//inicia sessao
		sessaoJasdb = new SessaoJasdb(this);
		sessaoJasdb.criar();
		
		//trabalhando
		pessoaJasdb = new PessoaJasdb(sessaoJasdb);
		pessoaJasdb.criar(listPessoa);
		pessoaJasdb.listarTodos();
		
		sessaoJasdb.listarBags();
		//fecha sessao
		sessaoJasdb.fechar();
		
	}

	@Override
	protected void onStart() {
		super.onStart();

	}
}
