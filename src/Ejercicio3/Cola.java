package Ejercicio3;

import java.util.LinkedList;

public class Cola {

	private int MAX_ELEMENTOS;
	LinkedList<Integer> cola;
	public Cola (int max) {
		cola = new LinkedList<Integer>();
		this.MAX_ELEMENTOS=max;
	}
	
	public synchronized boolean estaVacia() {
		int numElementos=cola.size();
		if (numElementos==0) {
			return true;
		}
		return false;
		
	}
	
	public synchronized boolean estaLlena(){
		int numElementos=cola.size();
		if (numElementos==this.MAX_ELEMENTOS) {
			return true;
		}
		return false;
	}
	
	public synchronized boolean encolar(int numero) {
		if (estaLlena()) {
			return false;
		}
		cola.addLast(numero);
		return true;
	}
	
	public synchronized int desencolar() {
		if (estaVacia()) {
			return -1;
		}
		int numero=cola.removeFirst();
		return numero;
		
	}
}
