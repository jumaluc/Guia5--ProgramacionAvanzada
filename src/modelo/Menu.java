package modelo;

public class Menu {
	
	private int idMenu;
	private String  tipo;
	private String nombre;
	private double precio;
	private String[] ingredientes = new String [3];
	private boolean compartir;
	
	
	
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String[] getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String[] ingredientes) {
		this.ingredientes = ingredientes;
	}
	public boolean isCompartir() {
		return compartir;
	}
	public void setCompartir(boolean compartir) {
		this.compartir = compartir;
	}
	public Menu() {}
	public Menu(String tipo, String nombre, double precio, String[] ingredientes, boolean compartir, int idMenu) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.precio = precio;
		this.ingredientes = ingredientes;
		this.compartir = compartir;
		this.idMenu=idMenu;
	}
	
}
