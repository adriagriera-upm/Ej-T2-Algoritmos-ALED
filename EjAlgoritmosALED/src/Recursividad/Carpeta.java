package Recursividad;

import java.util.List;

public class Carpeta {

	private String nombre;
	private List<Archivo> archivos;
	private List<Carpeta > subcarpetas;
	
	public Carpeta(String nombre) {
		this.nombre=nombre;
	}
	public List<Archivo> getArchivos(){
		return this.archivos;
	}
	
	public List<Carpeta> getSubcarpetas(){
		return this.subcarpetas;
	}
	
	public static double calcularPesoTotal(Carpeta inicio) {
		
		//TODO completar
		
		return -1;
	}
}
