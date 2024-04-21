package modelo;

public class Cabañas extends Alojamientos {
		
	private boolean hidromasaje;
	private static double adicional;
	public boolean isHidromasaje() {
		return hidromasaje;
	}
	public void setHidromasaje(boolean hidromasaje) {
		this.hidromasaje = hidromasaje;
	}
	public static double getAdicional() {
		return adicional;
	}
	public static void setAdicional(double adicional) {
		Cabañas.adicional = adicional;
	}
	
	public Cabañas() {}
	
	public Cabañas(int id, String area, String categoria, int capacidadMax, Tarifa tarifa, boolean libre, boolean h) {
		super(id, area, categoria, capacidadMax, tarifa, libre);
		hidromasaje = h;
	}
	
	
}
