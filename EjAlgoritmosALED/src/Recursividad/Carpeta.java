package Recursividad;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

	private String nombre;
	private List<Archivo> archivos;
	private List<Carpeta > subcarpetas;
	
	public Carpeta(String nombre, List<Archivo> archivos, List<Carpeta > subcarpetas) {
		this.nombre=nombre;
		this.archivos=archivos;
		this.subcarpetas=subcarpetas;
	}
	public List<Archivo> getArchivos(){
		return this.archivos;
	}
	
	public List<Carpeta> getSubcarpetas(){
		return this.subcarpetas;
	}
	
	public static double calcularPesoTotal(Carpeta inicio, double acumulado) {
		Carpeta preinicio = inicio;
		double pesoTotal = acumulado;
		boolean visited = false;
		
		if(inicio.getArchivos() != null) { //Caso base: no más subcarpetas o archivos dentro->cálculo del pesoTotal de esa carpeta
			for(int i=0; i<inicio.getArchivos().size();i++) {
				pesoTotal += inicio.getArchivos().get(i).getPesoMB();
				
			}
			visited = true;
		}
		
		if (inicio.getSubcarpetas() != null && visited == true){	//Caso recursivo: exploramos las subcarpetas de inicio
			for(int j=0; j<inicio.getSubcarpetas().size();j++) {
				calcularPesoTotal(inicio.getSubcarpetas().get(j), pesoTotal);
			} 
		}
		if(inicio.getSubcarpetas() == null) {
			//TODO Controlar condición
		}
		
		return pesoTotal;
	}

	public static void main(String[] args) {
		
		
		
		
		Archivo vid = new Archivo("Vídeo David p1", 56);
		Archivo pr = new Archivo("Práctica 1 ALED",2);
		Carpeta c2 = new Carpeta("Carpeta c.2",null,null);
		List<Carpeta> subcarpetasC = new ArrayList<Carpeta>();
		List<Archivo> archivosC1 = new ArrayList<Archivo>();
		archivosC1.add(pr);
		archivosC1.add(vid);
		Carpeta c1 = new Carpeta("Carpeta c.2",archivosC1,null);
		subcarpetasC.add(c1);
		subcarpetasC.add(c2);
		List<Archivo> archivosC = new ArrayList<Archivo>();
		archivosC.add(vid);
		archivosC.add(pr);
		Carpeta c = new Carpeta("Carpeta c",archivosC,subcarpetasC);
		System.out.println(calcularPesoTotal(c,0));
		
		
	}



}

