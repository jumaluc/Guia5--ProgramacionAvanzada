package controlador;
import vistas.*;
import modelo.*;
import DAO.*;
public class HuespedesControlador {
	
	private HuespedesVista huespedesVista = new  HuespedesVista();
	private Huespedes [] huespedes = new Huespedes[100];
	private HuespedesTXT huespedesTXT;
	private EstadiaControlador estadiaControlador;
	
	
	
	public Huespedes[] cargarHuespedesTXT(int cantHuespedes) { //INTERACTUA  CON EL ARCHIVO HUESPEDESTXT Y CARGA LOS DATOS EN LOS OBJETOS HUESPEDES
											//TAMBIEN SE FIJA DE QUE SI YA ESTA INGRESADO EN EL SISTEMA LO VALIDA
										//UTILIZO EXCEPCION PROPIA ="ErrorValidacionHuesped"
	
		Huespedes [] huespedesPorEstadia = new Huespedes[cantHuespedes];
		
		for(int i = 0 ; i < huespedes.length ; i++) {
			if(huespedes[i]!=null) {
				continue;
			}
			else {
				int dni = huespedesVista.pedirInt("Dni : "); 
				while(true) {
					if(repeticionHuespedes(huespedes, dni)) {
						dni = huespedesVista.pedirInt("Dni : ");
					}
					else {break;}
				}
				String nombre=huespedesVista.setValoresStringHuesped("Nombre : ");
				String apellido=huespedesVista.setValoresStringHuesped("Apellido : ");
				String pais=huespedesVista.setValoresStringHuesped("Pais : ");
				if(!huespedesTXT.leerHuespedes(dni, nombre, apellido, pais)) {
					huespedesTXT.cargarHuespedes(dni, nombre, apellido, pais);
				}
				huespedes[i] = new Huespedes(dni, nombre, apellido, pais);
				if(i<cantHuespedes) {
					huespedesPorEstadia[i] = huespedes[i];		
				}
			}
		}

		return huespedesPorEstadia;		
	}
	
	private boolean repeticionHuespedes(Huespedes [] h, int dni ) {
		for(int i = 0; i<huespedes.length ; i++) {
			if(huespedes[i]!=null && huespedes[i].getNumeroDocumento()==0) {
				if(huespedes[i].getNumeroDocumento()==dni) {
					return false;
				}
			}
		}
		return true;
	}
	public Huespedes[] devolverHuespedes() {
		return huespedes;
	}
	public void mostrarConsulta3(int i) {
		huespedesVista.mostrarArgInt(i, "La cantidad de huespedes que usaron el complejo mas de 3 veces es de:  ");
	}
	public void mostrarHuesped(int i) {
		for(Huespedes h : huespedes) {
			if(h.getNumeroDocumento()==i) {
				huespedesVista.mostrarArgString(h.getNombre(), "Nombre del huesped: ");
				huespedesVista.mostrarArgString(h.getApellido(), "Apellido del huesped: ");
			}
		}
	}

}
