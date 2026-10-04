package Recursividad;

import java.util.List;
import java.util.ArrayList;

public class Habilidad {
	
	private String id;
	private int costePuntos;
	private List<Habilidad> desbloqueables;
	
	public Habilidad(String id, int costePuntos) {
		
		this.id=id;
		this.costePuntos=costePuntos;
		this.desbloqueables= new ArrayList<>();
	}

	public int getCoste() {
		return this.costePuntos;
	}
	
	public List<Habilidad> getDesbloqueables(){
		return this.desbloqueables;
	}
	
	public static int costeRamaCompleta(Habilidad raiz, int costeAcumulado) {
		
		int costes = raiz.getCoste();
		
		//Caso base: la habilidad no tiene más habilidades desbloqueables en la rama
		if(raiz.getDesbloqueables().isEmpty()) {
			return costes;
		}
		//Caso recursivo
		else {
			for(Habilidad desb : raiz.getDesbloqueables()) {
				costes += costeRamaCompleta(desb,costes);
			}
		}
		return costes;
	}

	
	public static void main(String[] args) {
		
		//Código escrito por Claude (me ahorra tiempo)
		
	    // Árbol de ejemplo:
	    //
	    //                 Ataque (10)
	    //                /           \
	    //          Fuego (20)       Hielo (15)
	    //          /       \             \
	    // BolaFuego (30) MuroFuego (40)  RayoHielo (25)

	    Habilidad ataque = new Habilidad("Ataque", 10);
	    Habilidad fuego = new Habilidad("Fuego", 20);
	    Habilidad hielo = new Habilidad("Hielo", 15);
	    Habilidad bolaFuego = new Habilidad("BolaFuego", 30);
	    Habilidad muroFuego = new Habilidad("MuroFuego", 40);
	    Habilidad rayoHielo = new Habilidad("RayoHielo", 25);

	    ataque.getDesbloqueables().add(fuego);
	    ataque.getDesbloqueables().add(hielo);
	    fuego.getDesbloqueables().add(bolaFuego);
	    fuego.getDesbloqueables().add(muroFuego);
	    hielo.getDesbloqueables().add(rayoHielo);

	    // Esperado: 10 + 20 + 30 + 40 + 15 + 25 = 140
	    System.out.println("Coste rama completa (esperado 140): "
	            + costeRamaCompleta(ataque, 0));
	}
	
	
}
