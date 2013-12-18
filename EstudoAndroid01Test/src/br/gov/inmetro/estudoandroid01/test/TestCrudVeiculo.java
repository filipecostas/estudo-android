package br.gov.inmetro.estudoandroid01.test;

import java.util.List;

import android.test.AndroidTestCase;
import br.gov.inmetro.estudoandroid01.sqlite.Veiculo;
import br.gov.inmetro.estudoandroid01.sqlite.VeiculoDAO;

public class TestCrudVeiculo extends AndroidTestCase {

	VeiculoDAO dao;

	@Override
	public void setUp() {
		dao = VeiculoDAO.getInstance(getContext());
	}

	@Override
	public void tearDown() {
		//dao.fecharConexao();
	}

	public void test01Salvar() {
		Veiculo v = new Veiculo("carro1", "mercedes", 1993);
		dao.salvar(v);
		List<Veiculo> listVeiculo = dao.listarTodos();
		assertEquals(listVeiculo.get(0).getNome(), "carro1");
	}

	public void test02ListarTodos() {
		List<Veiculo> listVeiculo = dao.listarTodos();
		assertFalse(listVeiculo.isEmpty());

	}
}
