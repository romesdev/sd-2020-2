package caseRemoto;

import java.io.Serializable;
import java.util.ArrayList;

public class Pessoa implements Serializable{
	String nome;
	String cpf;
	int idade;
	Carro carro;
	ArrayList<Pessoa> pessoas;
	
	public Pessoa(String nome, String cpf, int idade, Carro carro) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.carro = carro;
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public void adicionar(Pessoa p) {
		this.pessoas.add(p);
	}
	
	public void remover(Pessoa p) {
		this.pessoas.remove(p);
	}
	
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}



	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public String temCarro() {
		if(this.carro != null) 
			return "Tenho carro e a placa é " + this.carro.placa;
		
		else return "Não tenho carro";
	}
	
	public String imprimir() {
		return this.pessoas.toString();
		
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + "]";
	}
	
	
	
}
