package vistas;
import java.util.*;
import controlador.*;
public class HuespedesVista {
	
	 Validaciones val = new Validaciones();
	 HuespedesControlador huespedesControlador = new HuespedesControlador();
	 AlojamientosVista alojamientosVista = new AlojamientosVista();
	 AlojamientoControlador alojamientosControlador = new AlojamientoControlador();
	

	public int pedirInt(String mensaje) {
		System.out.println(mensaje);
		return val.validarInt();
	}

	public String setValoresStringHuesped(String pedido) {
		System.out.println(pedido);
		return val.validarString();
	}

	public void controlarExcepcionVista()  {
		try {	
			throw new ErrorValidacionHuesped("Hubo un error al validar el huesped ingresado anteriormente");
		}
		catch(ErrorValidacionHuesped e) {
			e.getMessage();
		}
	}
	public void mostrarArgInt(int i, String mensaje) {
		System.out.println(mensaje+i);
	}
	public void mostrarArgString(String i, String mensaje) {
		System.out.println(mensaje+i);
	}


}



