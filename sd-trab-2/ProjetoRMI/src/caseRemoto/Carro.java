package caseRemoto;

import java.io.Serializable;
import java.util.ArrayList;

public class Carro implements Serializable {
	String placa;
	String marca;
	Motorista dono;
	ArrayList<Carro> carros;

	
	
	public Carro(String placa, String marca) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.carros = new ArrayList<Carro>();
	}
	
	public void adicionar(Carro c) {
		this.carros.add(c);
	}
	
	public void remover(Carro c) {
		this.carros.remove(c);
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String meuDono() {
		if(this.dono != null) 
			return "Meu dono é:" + this.dono.nome;
		
		else return "Não tenho dono";
	}
	
	public String imprimir() {
		return this.carros.toString();
		
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", marca=" + marca + ", dono=" + dono + "]";
	}
	
	
	
}
