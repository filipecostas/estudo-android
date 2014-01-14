package br.gov.inmetro.estudoandroid01.jasdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pessoa {

	private String nome;
	private String email;
	private int idade;

	public Pessoa(String nome, String email, int idade) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	
	public static Map<String, Object> convertMap(Pessoa pessoa) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Nome", pessoa.getNome());
		map.put("Email", pessoa.getEmail());
		map.put("Idade", pessoa.getIdade());

		return map;
	}

	public static List<Map<String, Object>> convertListMap(List<Pessoa> listPessoa) {
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for (Pessoa pessoa : listPessoa) {
			listMap.add(convertMap(pessoa));
		}
		
		return listMap;
	}
}
