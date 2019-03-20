package Ejercicio4;

public class Camino {
	private static int num =0;
	private Monumento origen;
	private Monumento destino;
	private Double m;
	private int id;
	

	public static Camino create() {
		return new Camino();
	}

	public static Camino create(Monumento c1, Monumento c2) {
		return new Camino(c1,c2);
	}

	public static Camino create(Monumento c1, Monumento c2, String[] formato) {
		return new Camino(c1,c2,formato);
	}

	public static Camino create(Monumento c1, Monumento c2, Double km) {
		return new Camino(c1, c2, km);
	}
	
	private Camino(Monumento c1, Monumento c2) {
		this.origen = c1;
		this.destino = c2;
		this.m = 0.;
		this.id = num;
		num++;
	}
	
	private Camino() {
		this.origen = null;
		this.destino = null;
		this.id = num;
		num++;
	} 
	private Camino(Monumento c1, Monumento c2, String[] nombre) {
		this.origen = c1;
		this.destino = c2;
		this.m = Double.parseDouble(nombre[2]);
		this.id = num;
		num++;
	}
	
	private Camino(Monumento c1, Monumento c2, Double m) {
		this.origen = c1;
		this.destino = c2;
		this.m = m;
		this.id = num;
		num++;
	}

	public Monumento getOrigen() {
		return origen;
	}

	public void setOrigen(Monumento origen) {
		this.origen = origen;
	}

	public Monumento getDestino() {
		return destino;
	}

	public void setDestino(Monumento destino) {
		this.destino = destino;
	}

	public Double getM() {
		return m;
	}

	public void setM(Double m) {
		this.m = m;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "("+getOrigen()+","+getDestino()+","+this.m+")";
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
