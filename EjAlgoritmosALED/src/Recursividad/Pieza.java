package Recursividad;

import java.util.ArrayList;
import java.util.List;

public class Pieza {
	
	private String nombre;
	private boolean esDefectuosa;
	private List<Pieza> componentes; // Piezas necesarias para montar esta
	
	public Pieza(String nombre, boolean esDefectuosa) {
		
		this.nombre=nombre;
		this.esDefectuosa=esDefectuosa;
		this.componentes=new ArrayList<>();
		
	}
	
	public boolean isDefectuosa () { return this.esDefectuosa; }
	public List<Pieza> getComponentes () { return this.componentes; }
	
	public static boolean contieneDefectos(Pieza piezaPrincipal) {
		
		boolean defectuosa = false;
		
		if(piezaPrincipal.esDefectuosa) {
			defectuosa = true;
		}
		
		if(piezaPrincipal.getComponentes().isEmpty()) {
			
		}
		
		for(Pieza componente : piezaPrincipal.getComponentes()) {
			defectuosa = contieneDefectos(componente);
		}
	return defectuosa;
	}

	
	public static void main(String[] args) {

	    // Árbol de ejemplo (entre paréntesis, si es defectuosa):
	    //
	    //                 Coche (no)
	    //                /          \
	    //         Motor (no)       Chasis (no)
	    //         /       \             |
	    //   Piston (no)  Bujia (SÍ)   Rueda (no)

	    Pieza coche = new Pieza("Coche", false);
	    Pieza motor = new Pieza("Motor", false);
	    Pieza chasis = new Pieza("Chasis", false);
	    Pieza piston = new Pieza("Piston", false);
	    Pieza bujia = new Pieza("Bujia", true);
	    Pieza rueda = new Pieza("Rueda", false);

	    coche.getComponentes().add(motor);
	    coche.getComponentes().add(chasis);
	    motor.getComponentes().add(piston);
	    motor.getComponentes().add(bujia);
	    chasis.getComponentes().add(rueda);

	    System.out.println("Coche (esperado true): " + contieneDefectos(coche));
	    System.out.println("Motor (esperado true): " + contieneDefectos(motor));
	    System.out.println("Chasis (esperado false): " + contieneDefectos(chasis));
	    System.out.println("Piston, hoja sana (esperado false): " + contieneDefectos(piston));
	    System.out.println("Bujia, hoja defectuosa (esperado true): " + contieneDefectos(bujia));
	}
}
