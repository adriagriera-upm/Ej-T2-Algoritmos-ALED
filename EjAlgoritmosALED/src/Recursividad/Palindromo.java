package Recursividad;

import java.util.*;

public class Palindromo {

	public static boolean esPalindromo(String texto) {
		
		boolean loes = true;
		
		if(texto.charAt(0) != texto.charAt(texto.length()-1)) {
			loes = false;
		}
		
		String newtexto = texto.substring(1, texto.length()-1);
		
		
		
		//Caso base: cuando texto es de tamaño <= 1
		if(texto.length() <= 1) {
			return loes;
		}
		//Caso recursivo
		else if (newtexto.length() > 1) {
			loes = esPalindromo(newtexto);
		}
		return loes;
	}
		
	public static void main(String[] args) {
		
		String p = "13abba31";
		String s = "hloh";
		String s1 = "hloslh";
		
		
		System.out.println(esPalindromo(p));
		System.out.println(esPalindromo(s1));
		
	}
		
}
	

