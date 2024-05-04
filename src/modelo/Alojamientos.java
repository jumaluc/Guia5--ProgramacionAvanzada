package modelo;

public class Alojamientos {

	protected int id;
	protected String area;
	protected String categoria;
	protected int capacidadMax;
	protected Tarifa tarifa;
	protected boolean libre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	public boolean getLibre() {
		return libre;
	}
	public void setLibre(boolean libre) {
		this.libre = libre;
	}
	public Alojamientos() {}
	
	public Alojamientos(int id, String area, String categoria, int capacidadMax, Tarifa tarifa, boolean libre) {
		this.id = id;
		this.area = area;
		this.categoria = categoria;
		this.capacidadMax = capacidadMax;
		this.tarifa = tarifa;
		this.libre = libre;
	}
	
	
}
