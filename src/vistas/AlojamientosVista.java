package vistas;
import controlador.*;
public class AlojamientosVista {
	
	private AlojamientoControlador alojamientosControlador = new AlojamientoControlador();
	private Validaciones val = new Validaciones();
	private HuespedesVista huespedesVista = new HuespedesVista();
	
	
	public void unidadesDisponibles() {
		System.out.println("UNIDADES DISPONIBLES");
		for(int i =0 ; i< alojamientosControlador.cantidadUnidadesDisponibles(); i++) {
			
			System.out.println("ID ="+alojamientosControlador.unidadesDisponiblesID(i));
			System.out.println("AREA ="+alojamientosControlador.unidadesDisponiblesArea(i));
			System.out.println("CATEGORIA = "+alojamientosControlador.unidadesDisponiblesCategoria(i));
			System.out.println("CAPACIDAD MAXIMA = "+alojamientosControlador.unidadesDisponiblesCapacidad(i));
			System.out.println("TARIFA DIARIA = "+alojamientosControlador.unidadesDisponiblesTarifa(i));
			if(alojamientosControlador.tipo(i)) {
				if(alojamientosControlador.unidadesDisponiblesHidromasaje(i)) {
					System.out.println("Cuenta con hidromasaje");
				}
				System.out.println("No cuenta con hidromaseje");
			}
			else {
				String[] array =alojamientosControlador.unidadesDisponiblesDispositivos(i);
				for(String a : array) {
					System.out.println("Los dispositivos son :"+a);
				}
			}
		}
						
	}
	
	public int preferenciasHuesped(int cantHuespedes) {
		System.out.println("Desean Hidromasaje? (si/no): ");
		String hidro=val.validarString().toLowerCase();
		while(!hidro.equals("si") || !hidro.equals("no")) {
			System.out.println("Desean Hidromasaje? (si/no): ");
			hidro=val.validarString().toLowerCase();
		}
		boolean h = false;
		if(hidro.equals("si")) {
			h=true;
		}
		 String tipo="";
		if(!hidro.equals("si")) {
			System.out.println("Desean cabaña o suite? (cabaña/suite): ");
			tipo = val.validarString().toLowerCase();
			while(!tipo.equals("cabaña") || !tipo.equals("suite")) {
				System.out.println("Desean cabaña o suite? (cabaña/suite): ");
				tipo = val.validarString().toLowerCase();
			}
		}
		else {
			tipo = "cabaña";
		}
		//TREAR TODAS LOS ALOJAMIENTOS QUE CUMPLAN CON LOS REQUERIMIENTOS DEL HUESPED
		return alojamientosControlador.mostrarAlojamientosPreferenciales(alojamientosControlador.alojamientosPreferenciales(cantHuespedes, h, tipo));

		
	}
	public String suitesPreferencias() {
		System.out.println("Ingrese un dispositivo electronico de su preferencia: ");
		return val.validarString();
		
	
	}
	
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}


	
	public int pedirElegido() {
		System.out.println("AHORA INGRESE EL ID DEL ALOJAMIENTO ELEGIDO: ");
		return val.validarInt();
	}
	
	
	
	public void mostrarConsulta2Vista(int i) {
		System.out.println("El numero de la cabaña con hidromasaje que solo se haya usado en el transcurso del ultimo mes: "+i);
	}
	
	
	
	public void mostrarArgInt(int i, String mensaje) {
		System.out.println(mensaje + i);
	}
	public void mostrarArgDouble(double i, String mensaje) {
		System.out.println(mensaje + i);
	}
	public void mostrarArgString(String i, String mensaje) {
		System.out.println(mensaje + i);
	}
}
