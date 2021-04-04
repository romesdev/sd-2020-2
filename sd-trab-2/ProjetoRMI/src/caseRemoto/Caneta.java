package caseRemoto;

import java.io.Serializable;

public class Caneta implements Serializable{
	String cor;

	
	
	
	
	public Caneta(String cor) {
		super();
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	public String imprimir() {
		return "escrevendo com uma caneta da cor " + this.cor;
	}
	
}
