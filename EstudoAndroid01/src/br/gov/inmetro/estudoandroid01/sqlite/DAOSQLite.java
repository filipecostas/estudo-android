package br.gov.inmetro.estudoandroid01.sqlite;

import java.util.List;

public interface DAOSQLite<T> {
	
	public void salvar(T veiculo);
    public List<T> listarTodos();
    public void deletar(T veiculo);
    public void editar(T veiculo);

}
