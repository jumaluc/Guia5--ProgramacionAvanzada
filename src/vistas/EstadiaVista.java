package vistas;

public class EstadiaVista {
	
	private Validaciones val= new Validaciones();
	

	public void mostrarTotal(double pagar) {
		System.out.println("El total a pagar es de: "+pagar);
	}
	public int pedirInt(String mensaje) {
		System.out.println(mensaje);
		return val.validarInt();
	}
}
