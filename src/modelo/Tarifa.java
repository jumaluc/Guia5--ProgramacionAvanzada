package modelo;

public class Tarifa {
	
	private char categoria;
	private int capacidad;
	
	public char getCategoria() {
		return categoria;
	}
	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public Tarifa() {}
	
	public Tarifa(char categoria, int capacidad) {
		super();
		this.categoria = categoria;
		this.capacidad = capacidad;
	}
	
	
}
