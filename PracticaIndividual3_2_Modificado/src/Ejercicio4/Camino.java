package Ejercicio4;

public class Camino {

	public static Camino create() {
		return new Camino();
	}

	public static Camino create(Monumento c1, Monumento c2) {
		return new Camino(c1,c2);
	}

	public static Camino create(Monumento c1, Monumento c2, String[] formato) {
		return new Camino(c1,c2,formato);
	}

	public static Camino create(Monumento c1, Monumento c2, Double tiempo) {
		return new Camino(c1, c2, tiempo);
	}

	private static int num =0;
	private Monumento origen;
	private Monumento destino;
	private Double tiempo;
	private int id;

	private Camino(Monumento c1, Monumento c2) {
		this.origen = c1;
		this.destino = c2;
		this.tiempo = 0.;
		this.id = num;
		num++;
	}
	
	private Camino() {
		this.origen = null;
		this.destino = null;
		this.tiempo = 0.;
		this.id = num;
		num++;
	} 
	private Camino(Monumento c1, Monumento c2, String[] nombre) {
		this.origen = c1;
		this.destino = c2;
		this.tiempo = Double.parseDouble(nombre[2]);
		this.id = num;
		num++;
	}
	
	private Camino(Monumento c1, Monumento c2, Double tiempo) {
		this.origen = c1;
		this.destino = c2;
		this.tiempo = tiempo;
		this.id = num;
		num++;
	}


	public double getTiempo() {
		return this.tiempo;
	}

	
	public Monumento getorigen(){
		return origen;
	}
	
	public Monumento getdestino(){
		return destino;
	}

	@Override
	public String toString() {
		return getorigen()+","+getdestino();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Camino))
			return false;
		Camino other = (Camino) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
