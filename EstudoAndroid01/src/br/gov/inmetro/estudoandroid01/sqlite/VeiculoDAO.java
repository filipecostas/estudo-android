package br.gov.inmetro.estudoandroid01.sqlite;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class VeiculoDAO implements DAOSQLite<Veiculo> {

	public static final String TABELA = "TB_VEICULO";
	public static final String ID = "id";
	public static final String NOME = "nome";
	public static final String MARCA = "marca";
	public static final String ANO = "ano";
	public static final String SCRIPT_CRIACAO_TABELA = "CREATE TABLE " + TABELA
			+ "(" + ID + " INTEGER PRIMARY KEY," + NOME + " TEXT," + MARCA
			+ " TEXT," + ANO + " TEXT" + ")";
	public static final String SCRIPT_EXCLUSAO_TABELA = "DROP TABLE IF EXISTS "
			+ TABELA;
	private SQLiteDatabase dataBase = null;
	private static VeiculoDAO instance;

	private VeiculoDAO(Context context) {
		PersistenceHelper persistenceHelper = PersistenceHelper
				.getInstance(context);
		dataBase = persistenceHelper.getWritableDatabase();

	}

	public static VeiculoDAO getInstance(Context context) {
		if (instance == null)
			instance = new VeiculoDAO(context);
		return instance;
	}

	@Override
	public void salvar(Veiculo veiculo) {
		ContentValues values = gerarContentValeuesVeiculo(veiculo);
		dataBase.insert(TABELA, null, values);
	}

	@Override
	public List<Veiculo> listarTodos() {
		String queryReturnAll = "SELECT * FROM " + TABELA;
		Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
		List<Veiculo> veiculos = construirVeiculoPorCursor(cursor);

		return veiculos;
	}

	@Override
	public void deletar(Veiculo veiculo) {
		String[] valoresParaSubstituir = { String.valueOf(veiculo.getId()) };

		dataBase.delete(TABELA, ID + " = ?", valoresParaSubstituir);
	}

	@Override
	public void editar(Veiculo veiculo) {
		ContentValues valores = gerarContentValeuesVeiculo(veiculo);

		String[] valoresParaSubstituir = { String.valueOf(veiculo.getId()) };

		dataBase.update(TABELA, valores, ID + " = ?", valoresParaSubstituir);
	}

	private List<Veiculo> construirVeiculoPorCursor(Cursor cursor) {

		// isolando
		CursorSQLite<Veiculo> cursorSqlite = new CursorSQLite<Veiculo>(cursor);
		cursorSqlite.addCampo(ID).addCampo(NOME).addCampo(MARCA).addCampo(ANO);
		Veiculo v = new Veiculo(cursorSqlite.getValue(1).toString(),
				cursorSqlite.getValue(2).toString(),
				(Integer) cursorSqlite.getValue(3));
		v.setId((Integer) cursorSqlite.getValue(0));
		CursorSQLite.setInstancia(v);
		return cursorSqlite.constroiCursor();

		/*
		 * List<Veiculo> veiculos = new ArrayList<Veiculo>();
		 * 
		 * if(cursor == null) return veiculos; try {
		 * 
		 * if (cursor.moveToFirst()) { do {
		 * 
		 * int indexID = cursor.getColumnIndex(ID); int indexNome =
		 * cursor.getColumnIndex(NOME); int indexMarca =
		 * cursor.getColumnIndex(MARCA); int indexAno =
		 * cursor.getColumnIndex(ANO);
		 * 
		 * long id = cursor.getInt(indexID); String nome =
		 * cursor.getString(indexNome); String marca =
		 * cursor.getString(indexMarca); int ano = cursor.getInt(indexAno);
		 * 
		 * Veiculo veiculo = new Veiculo(nome, marca, ano); veiculo.setId(id);
		 * veiculos.add(veiculo);
		 * 
		 * } while (cursor.moveToNext()); }
		 * 
		 * } finally { cursor.close(); }
		 * 
		 * return veiculos;
		 */
	}

	private ContentValues gerarContentValeuesVeiculo(Veiculo veiculo) {
		ContentValues values = new ContentValues();
		values.put(NOME, veiculo.getNome());
		values.put(MARCA, veiculo.getMarca());
		values.put(ANO, veiculo.getAno());

		return values;
	}

	public void fecharConexao() {
		if (dataBase != null && dataBase.isOpen())
			dataBase.close();
	}

}
