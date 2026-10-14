package Recursividad;

public class Cambio {
	
	
	public static int contarPermutaciones (int objetivo, int[] monedas) {
			return contarPAux(objetivo,monedas,0,0);
	}
	
	private static int contarPAux(int objetivo, int[] monedas, int acumulado, int numerocombinaciones) {
		
		if(acumulado > objetivo) {
			return numerocombinaciones;
		}
		
		if(acumulado == objetivo) {
			numerocombinaciones++;
			return numerocombinaciones;
			
		}
		
		for(int moneda : monedas) {
			numerocombinaciones = contarPAux(objetivo,monedas,acumulado+moneda,numerocombinaciones);
			
		}
		return numerocombinaciones;
	}
	
	public static int contarCombinaciones(int objetivo, int[] monedas) {
		return contarCAux(objetivo,monedas,0);
	}
	
	private static int contarCAux(int objetivo, int[] monedas, int indicemoneda) {
		int comb = 0;
		
		if(objetivo == 0) {
			return 1;
		}
		
		if(objetivo<0 || indicemoneda >= monedas.length-1) {
			 return 0;
		}
		//Probar
		comb += contarCAux(objetivo-monedas[indicemoneda],monedas,indicemoneda) + contarCAux(objetivo, monedas,indicemoneda + 1);
		
		return comb;
	}
	
	public static void main(String[] args) {
		
		int[] monedas = {1,2,5};
		
		System.out.println(contarPermutaciones(5,monedas));
		
		System.out.println(contarCombinaciones(3,monedas));
		
	}
	
	

}
