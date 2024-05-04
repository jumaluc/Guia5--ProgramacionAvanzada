package vistas;

public class ServicioBarVista {
	
	private Validaciones val = new Validaciones();

	
	public int pedirPlato() {
		System.out.println("Ingrese el ID del plato: ");
		return val.validarInt();
	}
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	public int pedirHuesped() {
		System.out.println("Ingrese el DNI del huesped solicitante de la limpieza: ");
		return val.validarInt();
	}
	public int pedirCantidad() {
		System.out.println("Ingrese la cantidad: ");
		return val.validarInt();
	}
	public void mostrarArgInt(int i, String mensaje) {
		System.out.println(mensaje+i);
	}
	public void mostrarArgDouble(double i, String m) {
		System.out.println(m+i);
	}
	public void mostrarArgString(String i,String m) {
		System.out.println(m+i);
	}
}
