package Recursividad;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

	private String nombre;
	private List<Archivo> archivos;
	private List<Carpeta > subcarpetas;
	
	public Carpeta(String nombre) {
		this.nombre=nombre;
		this.archivos= new ArrayList<>();
		this.subcarpetas = new ArrayList<>();
	}
	public List<Archivo> getArchivos(){
		return this.archivos;
	}
	
	public List<Carpeta> getSubcarpetas(){
		return this.subcarpetas;
	}
	
	public static double calcularPesoTotal(Carpeta inicio, double acumulado) {
		
		double peso = 0;
		
		if(inicio.getSubcarpetas().isEmpty() && !inicio.getArchivos().isEmpty()) { //Caso base: no más subcarpetas->cálculo del pesoTotal de esa carpeta
			for(int i=0; i<inicio.getArchivos().size();i++) {
					peso += inicio.getArchivos().get(i).getPesoMB();	
				}
		}
		
		 else if(!inicio.getSubcarpetas().isEmpty()) {	//Caso recursivo: exploramos las subcarpetas de inicio
			for(int i=0; i<inicio.getArchivos().size();i++) {
				peso += inicio.getArchivos().get(i).getPesoMB();
			}
			for(int j=0; j<inicio.getSubcarpetas().size();j++) {
				peso += calcularPesoTotal(inicio.getSubcarpetas().get(j), peso);
			} 
		}
		return peso;
	}

	public static void main(String[] args) {
		Archivo vid = new Archivo("Vídeo David p1", 65);
		Archivo pr = new Archivo("Práctica 1 ALED",2);
		Carpeta c = new Carpeta("Carpeta c");
		Carpeta c1 = new Carpeta("Carpeta c1");
		c.getArchivos().add(pr);
		c.getArchivos().add(vid);
		c.getSubcarpetas().add(c1);
		c1.getArchivos().add(pr);
		c1.getArchivos().add(vid);
		c.getSubcarpetas().add(new Carpeta("Carpeta c2"));
		
		System.out.println(calcularPesoTotal(c,0));
		
	}



}

