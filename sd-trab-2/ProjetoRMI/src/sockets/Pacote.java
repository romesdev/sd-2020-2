package sockets;


//classe que manda um pacote na transmissão
public class Pacote implements Interface {// implementa a minha interface
	
	
	public Pacote() {
		super();
	}

	@Override
	public void metodo1(String str) {// concatena uma mensagem no final da String

		System.out.println(("String com concatenação qualquer:" +str + "-parteFinalDaMensagem!"));
	}

	@Override
	public void metodo2(String str) {//reverte a String
		String reverso = new StringBuilder(str).reverse().toString();
		System.out.println("String invertida: "+ reverso);
	}

}
