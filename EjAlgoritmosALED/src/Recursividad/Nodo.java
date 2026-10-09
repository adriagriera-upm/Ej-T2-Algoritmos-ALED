package Recursividad;

public class Nodo { 
	

	int valor; 
	Nodo izq, der; 
	
	public Nodo(int valor) {
		this.valor=valor;
	}
	
	public static boolean esBST (Nodo nodo) {
		return esBSTAux(nodo);
	}

	private static boolean esBSTAux (Nodo nodo) {
		
		boolean compizq = false;
		boolean compder = true;
		
		//Caso base
		if(nodo.izq == null && nodo.der == null) {
			return true;
		}
		
		if(nodo.izq.valor >= nodo.valor || nodo.der.valor <= nodo.valor) {
			return false;
		}
		
		if(nodo.izq != null && nodo.der != null) {
		compizq = esBSTAux(nodo.izq);
		compder = esBSTAux(nodo.der);
		}
		
		return (compizq && compder);
	}

	public static void main(String[] args) {
		
		Nodo n = new Nodo(4);
		Nodo n1 = new Nodo(2);
		Nodo n2 = new Nodo(7);
		n.izq = n1;
		n.der = n2;
		
		Nodo m1 = new Nodo(1);
		Nodo m2 = new Nodo(3);
		n1.izq = m1;
		n1.der = m2;
		
		Nodo l1 = new Nodo(5);
		Nodo l2 = new Nodo(10);
		n2.izq = l1;
		n2.der = l2;
		
		System.out.println(esBST(n));
		
		
		
		
		
	}
	
	
	
	
	
}