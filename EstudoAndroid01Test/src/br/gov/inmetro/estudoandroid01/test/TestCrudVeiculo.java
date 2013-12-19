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
		
	}

	public void test01Salvar() {
		Veiculo v = new Veiculo("Fiesta Preto", "Ford", 2009);
		dao.salvar(v);
		List<Veiculo> listVeiculo = dao.listarTodos();
		
		assertEquals(listVeiculo.get(0).getNome(), "Fiesta Preto");
	}

	public void test02ListarTodos() {
		List<Veiculo> listVeiculo = dao.listarTodos();
		
		assertFalse(listVeiculo.isEmpty());

	}
	
	public void test03Editar() {
		Veiculo veiculo = dao.listarTodos().get(0);
		veiculo.setAno(2013);
		dao.editar(veiculo);
		Veiculo veiculoEditado = dao.listarTodos().get(0);
		
		assertSame(veiculo.getId(), veiculoEditado.getId());
		
	}
}
