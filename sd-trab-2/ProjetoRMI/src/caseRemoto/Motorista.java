package caseRemoto;

import java.io.Serializable;
import java.util.ArrayList;

public class Motorista extends Pessoa implements Serializable{
	String cnh;
	ArrayList<Pessoa> motoristas;



	public Motorista(String nome, String cpf, int idade, Carro carro, String cnh) {
		super(nome, cpf, idade, carro);
		this.cnh = cnh;
		this.motoristas = new ArrayList<Pessoa>();
	}
	
	public void adicionar(Pessoa p) {
		this.motoristas.add(p);
	}
	
	public void remover(Pessoa p) {
		this.motoristas.remove(p);
	}


	public ArrayList<Pessoa> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(ArrayList<Pessoa> motoristas) {
		this.motoristas = motoristas;
	}

	public String getCnh() {
		return cnh;
	}


	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public String cnhOkay() {
		if(this.cnh != null) 
			return "Eu posso dirigir com a CNH: " + this.cnh;
		
		else return "Não tenho permissão para dirigir";

	}
	
	public String imprimir() {
		return this.motoristas.toString();
		
	}

	@Override
	public String toString() {
		return "Motorista [cnh=" + cnh + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", carro=" + carro
				+ "]";
	}
	
	
}

