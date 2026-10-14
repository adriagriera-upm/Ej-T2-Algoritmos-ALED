package Recursividad;

public class NodoLista {
	
	int dato; 
	NodoLista siguiente;
	
	public NodoLista(int dato) {
		this.dato=dato;
	}
	
	public static NodoLista invertirRecursivo (NodoLista actual) {
		
		// Caso base: lista vacía o único elemento
		if (actual == null || actual.siguiente == null) {
			return actual;
		}
		
		else {
		// Paso recursivo:
		NodoLista newinv = invertirRecursivo(actual.siguiente);
		
		actual.siguiente.siguiente = actual;
		
		actual.siguiente = null;
		
		return newinv;
		}
	}
	
	public static void main(String[] args) {
		
		NodoLista n1 = new NodoLista(3);
		NodoLista n2 = new NodoLista(6);
		NodoLista n3 = new NodoLista(7);
		NodoLista n4 = new NodoLista(31);
		NodoLista n5 = new NodoLista(1);
		;
		n1.siguiente = n2;
		n2.siguiente = n3;
		n3.siguiente = n4;
		n4.siguiente = n5;
		
		
		NodoLista ninv = invertirRecursivo(n1);
		System.out.println(ninv);
	}
	
}
