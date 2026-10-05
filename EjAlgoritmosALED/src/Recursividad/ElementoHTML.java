package Recursividad;

import java.util.ArrayList;
import java.util.List;

public class ElementoHTML {
	
	private String tag;
	private List<ElementoHTML> hijos;
	
	public ElementoHTML(String tag) {
		
		this.tag=tag;
		this.hijos= new ArrayList<>();
	}
	
	public String getTag() {
		return tag;
	}
	
	public List<ElementoHTML> getHijos(){
		return hijos;
	}
	
	
	public static int contarEtiquetas(ElementoHTML elemento, String tagBuscado, int acumulado) {
		
		int numTag = acumulado;
		
		if(elemento.getTag() == tagBuscado) {
			numTag++;
		}
		
		//Caso base: llega al hijo final
		if(elemento.getHijos().isEmpty()) {
			return numTag;
		}
		
		//Caso recursivo
		else {
			for(ElementoHTML elementohijo : elemento.getHijos()) {
				numTag = contarEtiquetas(elementohijo,tagBuscado,numTag);
			}
		}
		return numTag;
	}
	
	public static void main(String[] args) {

	    // Árbol de ejemplo:
	    //
	    //                    html
	    //                /          \
	    //            head            body
	    //             |            /   |    \
	    //           title       div    p     div
	    //                      /   \         |
	    //                     p     p        a
	    //                                    |
	    //                                    p

	    ElementoHTML html = new ElementoHTML("html");
	    ElementoHTML head = new ElementoHTML("head");
	    ElementoHTML title = new ElementoHTML("title");
	    ElementoHTML body = new ElementoHTML("body");
	    ElementoHTML div1 = new ElementoHTML("div");
	    ElementoHTML p1 = new ElementoHTML("p");
	    ElementoHTML p2 = new ElementoHTML("p");
	    ElementoHTML p3 = new ElementoHTML("p");
	    ElementoHTML div2 = new ElementoHTML("div");
	    ElementoHTML a = new ElementoHTML("a");
	    ElementoHTML p4 = new ElementoHTML("p");

	    html.getHijos().add(head);
	    html.getHijos().add(body);
	    head.getHijos().add(title);
	    body.getHijos().add(div1);
	    body.getHijos().add(p3);
	    body.getHijos().add(div2);
	    div1.getHijos().add(p1);
	    div1.getHijos().add(p2);
	    div2.getHijos().add(a);
	    a.getHijos().add(p4);

	    System.out.println("Etiquetas <p> (esperado 4): "
	            + contarEtiquetas(html, "p", 0));
	}
}
