package ejercicio1.BT;

import java.util.List;

public class ProblemaUno {
	
	public static List<Integer> elementos;
	
	public ProblemaUno(List<Integer> elementos) {
		super();
		ProblemaUno.elementos = elementos;
	}

	public List<Integer> getElementos() {
		return elementos;
	}

	public static void setElementos(List<Integer> elementos) {
		ProblemaUno.elementos = elementos;
	}
	
}
