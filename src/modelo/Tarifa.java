package modelo;

public class Tarifa {
	
	private int idTarifa;
	private String categoria;
	private int capacidad;
	private double precio;
	
	
	
	public int getIdTarifa() {
		return idTarifa;
	}
	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public Tarifa() {}
	
	public Tarifa(int idTarifa,String categoria, int capacidad, double precio) {
		this.idTarifa = idTarifa;
		this.categoria = categoria;
		this.capacidad = capacidad;
		this.precio = precio;
	}
	
	
}
