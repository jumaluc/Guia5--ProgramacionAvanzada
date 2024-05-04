package controlador;
import DAO.AlojamientosTXT;
import modelo.*;
import vistas.*;
public class AlojamientoControlador {
	
	private AlojamientosTXT alojamientosTXT = new AlojamientosTXT();
	private Alojamientos [] alojamientos = new Alojamientos[alojamientosTXT.contadorLinea()]; //DEVERIA SER 19 
	private AlojamientosVista alojamientosVista =new AlojamientosVista();
	private EstadiaControlador estadiaControlador = new EstadiaControlador();
	
	
	public void cargarAlomaniento(){		
		alojamientos = alojamientosTXT.leerArchivo();
		}
	
	public int cantidadUnidadesDisponibles() {
		return unidadesDisponibles().length;
	}
	
	public Alojamientos[] unidadesDisponibles() {
		Alojamientos [] alojamientosLibres = new Alojamientos[alojamientos.length];
		for(int i = 0 ; i<alojamientos.length ; i++) {
			if(alojamientos[i].getLibre()) {
				alojamientosLibres[i] = alojamientos[i];
			}									
			}
		return alojamientosLibres;
	}
	
	//EN BASE A LAS PREFERENCIAS QUE EL USUARIO INGRESO, CREA UN ARRAY CON LOS ALOJAMIENTOS QUE CUMPLEN SUS REQUERIMIENTOS Y LO DEVUELVE
	public Alojamientos[] alojamientosPreferenciales(int cantHuespedes, boolean hidro, String tipo) {
		Alojamientos[] alojamientosPreferenciales = new Alojamientos[alojamientos.length];
		for(int i = 0; i < alojamientos.length ;i++) {
			if(alojamientos[i].getCapacidadMax()>=cantHuespedes && alojamientos[i].getLibre()) {
				if(tipo.equals("cabaña") && alojamientos[i] instanceof Cabañas) {
					if(hidro && ((Cabañas)alojamientos[i]).isHidromasaje()) {
						alojamientosPreferenciales[i] = alojamientos[i];
					}
					else if(!hidro && !((Cabañas)alojamientos[i]).isHidromasaje()) {
						alojamientosPreferenciales[i] = alojamientos[i];
					}
				}
				else if(tipo.equals("suite") && alojamientos[i] instanceof Suites) {
					for(int j = 0 ; j < ((Suites)alojamientos[i]).getDispositivosElectronicos().length ; j++){
						String dispositivosElectronicosRequeridos = alojamientosVista.suitesPreferencias();
						for(int l = 0 ; l < ((Suites)alojamientos[i]).getDispositivosElectronicos().length; l++) {
							if(((Suites) alojamientos[i]).getDispositivosElectronicos()[l].equals(dispositivosElectronicosRequeridos)) {
								alojamientosPreferenciales[i] = alojamientos[i];
								//DA IGUAL LO QUE INGRESE (PORQUE PODEMOS TENERLO O NO), SI LLEGASE A COINSIDIR CON UNO QUE TENEMOS REGISTRADO 
								//SE LA VA A MOSTRAR ESE
							}
						}
						
						}
					
					}
					
				}
			
			}
		return alojamientosPreferenciales;
		}
	//A TRAVES DEL ARRAY CREADO ANTERIORMENTE CON LOS ALOJAMIENTOS PREFERENCIALES, LOS MUESTRA AL USUARIO Y LE PIDE QUE ELIJA UNO DE ELLOS
	//Y LO DEVUELVE
	public int  mostrarAlojamientosPreferenciales(Alojamientos[] alPref) { 
		int id= 0;
		alojamientosVista.mostrarMensaje("ALOJAMIENTOS QUE CUMPLEN LAS PREFERENCIAS DEL HUESPED");
		for(Alojamientos al : alPref) {
			alojamientosVista.mostrarArgInt(al.getId(),"ALOJAMIENTO CON ID = ");
			alojamientosVista.mostrarArgString(al.getTarifa().getCategoria(),"Categoria = " );
			alojamientosVista.mostrarArgDouble(al.getTarifa().getPrecio(), "Precio = ");
		}
		boolean salir = true;
		while(salir) {
		int elegido = alojamientosVista.pedirElegido();
		for(Alojamientos al : alPref) {
			if(al.getId()==elegido) {
				id=al.getId();
				salir = false;
				break;
			}
		}
		
		}
		return id;
	}
	public Alojamientos devolverAlojamientoPorId(int id) {
		for(Alojamientos al : alojamientos) {
			if(al.getId() == id) {
				//YA NO ESTA MAS LIBRE
				al.setLibre(false);
				return al;
			}
		}
		return null;
	}
	

	
	

	public int unidadesDisponiblesID(int i) {
		return unidadesDisponibles()[i].getId();
	}
	public int unidadesDisponiblesCapacidad(int i) {
		return unidadesDisponibles()[i].getCapacidadMax();
	}
	public String unidadesDisponiblesArea(int i) {
		return unidadesDisponibles()[i].getArea();
	}
	public String unidadesDisponiblesCategoria(int i) {
		return unidadesDisponibles()[i].getCategoria();
	}
	public double unidadesDisponiblesTarifa(int i) {
		return unidadesDisponibles()[i].getTarifa().getPrecio();
	}
	public boolean tipo(int i) {
		if(unidadesDisponibles()[i] instanceof Cabañas) {
			
			return true;
		}
		else if(unidadesDisponibles()[i] instanceof Suites) {
			return false;
		}
		return false;
	}
	public boolean unidadesDisponiblesHidromasaje(int i) {
		
		return ((Cabañas)unidadesDisponibles()[i]).isHidromasaje();
		
	}
	public String [] unidadesDisponiblesDispositivos(int i) {
		return ((Suites)unidadesDisponibles()[i]).getDispositivosElectronicos();
	}
	
	public void mostrarConsulta2(int id) {
		alojamientosVista.mostrarConsulta2Vista(id);					
	}
	





	
	}
