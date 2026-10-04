package Recursividad;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	
	private String nombre;
	private double salario;
	private List<Empleado> subordinados;
	
	public Empleado(String nombre, double salario) {
		
		this.nombre=nombre;
		this.salario=salario;
		this.subordinados=new ArrayList<>();
	}
	
	public double getSalario() {
		return salario;
	}
	
	public List<Empleado> getSubordinados(){
		return subordinados;
	}

	public static double presupuestoEquipo(Empleado jefe, double acumulado) {
		
		double salarios = jefe.getSalario();
		//Caso base: cuando llegamos a un empleado que no tiene subordinados
		if(jefe.getSubordinados().isEmpty()) {
			return salarios;
		}
		//Caso recursivo
		else {
			for(Empleado sub : jefe.getSubordinados()) {
				salarios += presupuestoEquipo(sub,salarios);
			}
		}
		return salarios;	
	}
	
	public static void main(String[] args) {
		
		Empleado ceo = new Empleado("Juan",100000);
		Empleado mkt = new Empleado("Sofía",40000);
		Empleado jefeIT = new Empleado("Ahmed",50000);
		Empleado b1 = new Empleado("Becario 1",20000);
		Empleado b2 = new Empleado("Becario 1",20000);
		
		jefeIT.getSubordinados().add(b1);
		jefeIT.getSubordinados().add(b2);
		ceo.getSubordinados().add(mkt);
		ceo.getSubordinados().add(jefeIT);
		System.out.println("Presupuesto del equipo: " + presupuestoEquipo(ceo,0));
		
	}
	
	
	
	
}
