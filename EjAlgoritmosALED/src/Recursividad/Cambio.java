package Recursividad;

public class Cambio {
	
	
	public static int contarFormasCambio (int objetivo, int[] monedas) {
			return contarAux(objetivo,monedas,0,0);
	}
	
	private static int contarAux(int objetivo, int[] monedas, int acumulado, int numerocombinaciones) {
		
		if(acumulado > objetivo) {
			return numerocombinaciones;
		}
		
		if(acumulado == objetivo) {
			numerocombinaciones++;
			return numerocombinaciones;
			
		}
		
		for(int moneda : monedas) {
			numerocombinaciones = contarAux(objetivo,monedas,acumulado+moneda,numerocombinaciones);
			
			
		}
		return numerocombinaciones;
	}
	
	public static void main(String[] args) {
		
		int[] monedas = {1,2,5};
		
		System.out.println(contarFormasCambio(5,monedas));
		
	}

}
