package vistas;
import java.util.*;
public class ServicioLimpiezaVista {
	
	private Validaciones val = new Validaciones();
	
	public int pedirHuesped() {
		System.out.println("Ingrese el DNI del huesped solicitante de la limpieza");
		return val.validarInt();
	}
	public void mostrarMensaje(String mensaje) {
		System.out.println("Error ese DNI no esta en ninguna estadia");
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
