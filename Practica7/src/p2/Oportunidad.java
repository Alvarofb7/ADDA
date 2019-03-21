package p2;

public class Oportunidad {
	private Integer beneficio, capital;
	
	public static Oportunidad create(String s) {
		return new Oportunidad(s);
	}
	private Oportunidad(String s) {
		String[] t = s.split(",");
		capital = Integer.parseInt(t[0]);
		beneficio = Integer.parseInt(t[1]);
	}
	
	public Integer getBeneficio() {
		return beneficio;
	}
	
	public Integer getCapital() {
		return capital;
	}
	
}
