package Recursividad;

public class NodoLista {
	
	int dato; 
	NodoLista siguiente;
	
	public NodoLista(int dato) {
		this.dato=dato;
	}
	
	
	/*
	 * Ejercicio 2.10
	 */
	public static NodoLista fusionarListas(NodoLista l1, NodoLista l2) {
		
		//Caso recursivo:
		if(l1.dato < l2.dato) {
			NodoLista lfus = new NodoLista(l1.dato);
			return fusionarAux(l1.siguiente,l2,lfus); 
		} else if(l2.dato < l1.dato) {
			NodoLista lfus = new NodoLista(l2.dato);
			return fusionarAux(l1,l2.siguiente,lfus); 
		} else {
			NodoLista lfus = new NodoLista(l2.dato);
			lfus.siguiente = l1;
			return fusionarAux(l1.siguiente,l2.siguiente,lfus);
		}
	}
	
	private static NodoLista fusionarAux(NodoLista l1, NodoLista l2, NodoLista lfus) {
		//Caso base
		if(l1 == null) {
			lfus.siguiente = new NodoLista(l2.dato);
		} else if(l2 == null) {
			lfus.siguiente = new NodoLista(l1.dato);
		} else {
		//Caso recursivo
			if(l1.dato<l2.dato) {
				lfus.siguiente = new NodoLista(l1.dato);
				fusionarAux(l1.siguiente,l2,lfus.siguiente);
			} else if(l2.dato<l1.dato) {
				lfus.siguiente = new NodoLista(l2.dato);
				fusionarAux(l1,l2.siguiente,lfus.siguiente);
			} else {
				lfus.siguiente= new NodoLista(l1.dato);
				lfus.siguiente.siguiente= new NodoLista(l2.dato);
				fusionarAux(l1.siguiente,l2.siguiente,lfus.siguiente.siguiente);
			}
		}
		return lfus;
	}
	/*
	 * Ejercicio 2.8
	 */
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
		
		NodoLista l1 = new NodoLista(1);
		l1.siguiente = new NodoLista(4);
		l1.siguiente.siguiente = new NodoLista(6);
		l1.siguiente.siguiente.siguiente = new NodoLista(12);
		NodoLista l2 = new NodoLista(3);
		l2.siguiente = new NodoLista(5);
		l2.siguiente.siguiente = new NodoLista(7);
		l2.siguiente.siguiente.siguiente = new NodoLista(10);
		l2.siguiente.siguiente.siguiente.siguiente = new NodoLista(14);
		
		NodoLista l1and2 = fusionarListas(l1,l2);
	}
	
}
