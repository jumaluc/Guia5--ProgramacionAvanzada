package controlador;
import modelo.*;

import vistas.*;
import java.util.*;
import DAO.*;
public class EstadiaControlador {
	
	private HuespedesControlador huespedesControlador = new HuespedesControlador();
	private HuespedesVista huespedesVista = new HuespedesVista();
	private AlojamientosVista alojamientosVista = new AlojamientosVista();
	private Estadia [] estadia = new Estadia[100];
	private AlojamientoControlador alojamientoControlador = new AlojamientoControlador();
	private EstadiaVista estadiaVista = new EstadiaVista();
	private EstadiaJSON estadiasJSON = new EstadiaJSON();
	private ServicioLimpiezaVista servicioLimpiezaVista = new ServicioLimpiezaVista();
	private ServicioBarVista servicioBarVista = new ServicioBarVista();
	private MenuControlador menuControlador = new MenuControlador();
	private ServicioLimpiezaTXT servicioLimpiezaTXT = new ServicioLimpiezaTXT();
	private ServicioBarTXT servicioBarTXT = new ServicioBarTXT();
	private Consulta4JSON consulta4JSON = new Consulta4JSON();

	private int estadiaPosicion=0;
	
	
	
	
	public void crearEstadia() {
		int cantHuespedes = huespedesVista.pedirInt("Cuantos huespedes son?: ");
		//ACA YA CARGUE TODOS LOS HUESPEDES
		estadia[estadiaPosicion] = new Estadia();
		estadia[estadiaPosicion].setHuesped(huespedesControlador.cargarHuespedesTXT(cantHuespedes));
		//AHORA TENGO QUE PEDIRLE Y OFRECERLE ALOJAMIENTOS
		int idAlojamiento = alojamientosVista.preferenciasHuesped(cantHuespedes);
		//AHORA DEBERIA A TRAVES DE ESTE ID DEVOLVER EL ALOJAMIENTO CORRESPONDIENTE.
		estadia[estadiaPosicion].setAlojamiento(alojamientoControlador.devolverAlojamientoPorId(idAlojamiento));	
		if(estadia[estadiaPosicion].getAlojamiento() instanceof Cabañas) {
			estadia[estadiaPosicion].crearServicioLimpieza();
		}
		//AHORA PIDO LA CANTIDAD DE DIAS QUE SE ALOJAN
		estadia[estadiaPosicion].setCantidadDias(estadiaVista.pedirInt("Ingrese la cantidad de dias que durara su alojamiento: "));
		Calendar fechaIngreso = Calendar.getInstance();
		estadia[estadiaPosicion].setFechaIngreso(fechaIngreso);
		estadia[estadiaPosicion].setIdEstadia(estadiaPosicion);
		estadiaPosicion++;
		//AHORA DEBERIA CARGAR TODA ESTA INFO EN EL ARCHIVO ESTADIAS
		estadiasJSON.cargarEstadiaJSON(estadia[estadiaPosicion].getAlojamiento(), estadia[estadiaPosicion].getHuespedes(), estadia[estadiaPosicion].getIdEstadia(), estadia[estadiaPosicion].getFechaIngreso(), estadia[estadiaPosicion].getCantidadDias());
	}
	
	public Huespedes devolverHuesped(int dni) {
		for(Estadia e : estadia) {
		if(e!=null) {
			for(Huespedes h : e.getHuespedes() ) {
				if(h!=null) {
				if(h.getNumeroDocumento()==dni && e.getAlojamiento() instanceof Cabañas) {
					return h;
				}
			}
			}
		}
		}
		return null;
	}
	public int devolverEstadia(int dni) { //DEVUELVE LA ESTADIA DEL CLIENTE Y EL ID
		for(Estadia e : estadia) {
		if(e!=null) {
			for(Huespedes h : e.getHuespedes() ) {
				if(h!=null) {
				if(h.getNumeroDocumento()==dni && e.getAlojamiento() instanceof Cabañas) {
					e.crearServicioLimpieza();
					return e.getIdEstadia();
				}
			}
			}
		}
		}
		return 0;
	}
	public void llamadaServicioLimpieza() {
		
		boolean a = true;
		Huespedes huespedSolicitante = new Huespedes();
		int dni=0;
		while(a) {
			dni = servicioLimpiezaVista.pedirHuesped();
			huespedSolicitante = devolverHuesped(dni);
			if(huespedSolicitante==null) {
				servicioLimpiezaVista.mostrarMensaje("Error ese DNI no esta en ninguna estadia");
			}
			else {
				break;
			}
		}
			int idEstadia  = devolverEstadia(dni);

			Calendar fechaDia = Calendar.getInstance();
			for(int i = 0 ; i < estadia.length ; i++) {
				if(estadia[i]!=null) {
					
					if(estadia[i].getIdEstadia() == idEstadia) {

							for(int l = 0 ; l < estadia[i].getServicioLimpieza().length ; l++) {
								if(estadia[i].getServicioLimpieza()[l].getDniSolicitante()==null) {
									estadia[i].setServicioLimpieza(huespedSolicitante, fechaDia,  l);
									String fechaDiaFormato = fechaDia.get(Calendar.DATE)+"/"+(fechaDia.get(Calendar.MONTH)+1)+"/"+fechaDia.get(Calendar.YEAR);
									servicioLimpiezaTXT.crearArchivoLimp(huespedSolicitante.getNumeroDocumento(), fechaDiaFormato, estadia[i].getAlojamiento().getId());
									return;
								}
							}
						
					}

				}
			}
		
	}
	public void llamadaServicioBar() {
		
	
		Huespedes huespedSolicitante = new Huespedes();
		int dni=0;
		while(true) {
			dni = servicioBarVista.pedirHuesped();
			huespedSolicitante = devolverHuesped(dni);
			if(huespedSolicitante==null) {
				servicioBarVista.mostrarMensaje("Error ese DNI no esta en ninguna estadia");
			}
			else {
				break;
			}
		}
		Menu plato = new Menu();
		while(true) {
			int platoID = servicioBarVista.pedirPlato();
			
			plato = menuControlador.existenciaMenu(platoID);
			if(plato==null) {
				servicioBarVista.mostrarMensaje("Ese id de plato no se encuentra en el sistema: ");
			}
			else {
				break;
			}
		}
			int cantidad = servicioBarVista.pedirCantidad();
			int idEstadia  = devolverEstadia(dni);
			Calendar fechaDia = Calendar.getInstance();
			for(int i = 0 ; i < estadia.length ; i++) {
				if(estadia[i]!=null) {
					if(estadia[i].getIdEstadia()==idEstadia) {
						for(int l = 0 ; l < estadia[i].getServicioBar().length; l++) {
							if(estadia[i].getServicioBar()[l].getDniSolicitante()==null) {
								estadia[i].setServicioBar(huespedSolicitante, fechaDia, l, cantidad, plato);
								String fechaDiaFormato = fechaDia.get(Calendar.DATE)+"/"+(fechaDia.get(Calendar.MONTH)+1)+"/"+fechaDia.get(Calendar.YEAR);
								servicioBarTXT.crearArchivoBar(huespedSolicitante.getNumeroDocumento(), fechaDiaFormato, cantidad, plato.getNombre(), estadia[i].getAlojamiento().getId());
								return;
							}
						}
					}
				}
			}
			
		
	}
	//CREAR FUNCION QUE AL RECIBIR UN ID DE ESTADIA LA FINALICE, LIBERANDO EL ALOJAMIENTO Y MOSTRANDO EL TOTAL A ABONAR 
	public void totalApagar() {
		int idEstadia=0;
		int pos=0;
		boolean a = true;
		while(a) {
		 idEstadia = estadiaVista.pedirInt("Ingresa el id de la estadia que finaliza: ");
		 for(int i = 0 ; i < estadia.length; i++) {
			 if(estadia[i].getIdEstadia()==idEstadia) {
				 estadia[i].getAlojamiento().setLibre(true);
				 estadia[i].setFinalizada(true);
				 pos=i;
				 a=false;
				 break;
			 }
		 }
		}
		double total=estadia[pos].totalApagar();
		estadiaVista.mostrarTotal(total);
	
	}
	
	public void  consulta1(String args[]) {
		
		int [] menusID = new int[menuControlador.devolverMenu().length];
		
		for(int i = 0 ; i < menusID.length ; i++) {
			menusID[i] =  menuControlador.devolverMenu()[i].getIdMenu();
		}

			for(Estadia e : estadia) {
				if(e!=null) {
				for(ServicioBar s : e.getServicioBar()) {
					for(int i = 0 ; i < menusID.length ; i++) {
						if(s.getNombrePlato().getIdMenu() == menusID[i]) {
							menusID[i]=0; //SUPONIENDO QUE NO PUEDE HABER IDs IGUAL A 0
						}
					}
				}
			}
			}
					
			
			for(Menu m : menuControlador.devolverMenu()) {
				if(m.getTipo().equals("plato principal") && m.getPrecio()>Double.parseDouble(args[0])) {}
					for(int id : menusID) {
						if(m.getIdMenu()==id) {
							menuControlador.mostrarPlatoConsulta1(m.getNombre());
								
							
						}
					}
				}
	}
	
	public void consulta2() {
		
		for(Estadia e : estadia) {
			if(e!=null) {
				if(e.getAlojamiento() instanceof Cabañas) {
					Calendar fechaMesAnt = Calendar.getInstance();
					fechaMesAnt.add(Calendar.MONTH, -1);
					int cantidadUsoAlojamiento = alojamientosRepetidos(e.getAlojamiento().getId());
					if(cantidadUsoAlojamiento==1) {					
						if(((Cabañas)e.getAlojamiento()).isHidromasaje() && e.getFechaIngreso().after(fechaMesAnt)) {
							alojamientoControlador.mostrarConsulta2(e.getAlojamiento().getId());
						}					
						}
					else {
						int a = 0 ; 
						for(int i = 0 ; i < cantidadUsoAlojamiento ; i++) {
							for(Estadia e1 : estadia) {
								if(e!=null) {
									if(e1.getAlojamiento().getId()==e.getAlojamiento().getId()) {
										if(((Cabañas)e.getAlojamiento()).isHidromasaje() && e.getFechaIngreso().after(fechaMesAnt)) {
											a++;
										}	
									}
									
								}
							}
						}
						if(a==cantidadUsoAlojamiento) {
							alojamientoControlador.mostrarConsulta2(e.getAlojamiento().getId());

						}
							
					}
				}
			}
		}
	}
	public int alojamientosRepetidos(int id) {
		int cant=0;
		for(Estadia e : estadia) {
			if(e!=null) {
				if(e.getAlojamiento().getId()==id) {
					cant++;
				}
			}
		}
		return cant;
	}
	public void consulta3() {
		int cantidadHuespedes=0;
		for(Huespedes h : huespedesControlador.devolverHuespedes()) {
			int cantH=0;
			for(Estadia e : estadia) {
				for(Huespedes he : e.getHuespedes()) {
					if(h.getNumeroDocumento()==he.getNumeroDocumento()) {
						cantH ++;
					}
				}
			}
			if(cantH > 3) {
				cantidadHuespedes++;
			}
		}
		huespedesControlador.mostrarConsulta3(cantidadHuespedes);
	}
	public String pedirFechaIngreso(int id) {
		for(Estadia e : estadia ) {
			if(e!=null) {
				if(e.getAlojamiento().getId()==id && !e.isFinalizada()) {
					Calendar fecha = e.getFechaIngreso();
					String fechaFormato = fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR);
					return fechaFormato;
				}
			}
		}
		return null;
	}
	public void pedirHuespedes(int id) {
		for(Estadia e : estadia) {
			if(e!=null) {
				if(e.getAlojamiento().getId()==id && !e.isFinalizada()) {
					for(Huespedes h : e.getHuespedes()) {
						huespedesControlador.mostrarHuesped(h.getNumeroDocumento());
					}
				}
			}
			}
	}

	public void carcarConsulta4JSON() {
		
		for(Estadia e : estadia) {
			if(e!=null) {
				if(e.getAlojamiento().getLibre() && !e.isFinalizada()) {
					Calendar fecha = e.getFechaIngreso();
					String fechaFormato = fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR);
					if(e.getAlojamiento() instanceof Cabañas) {
						consulta4JSON.cargarConsulta4JSON(e.getAlojamiento(),fechaFormato, e.getHuespedes(), e.getServicioBar(), e.getServicioLimpieza());

					}
					else {
						consulta4JSON.cargarConsulta4JSON(e.getAlojamiento(),fechaFormato, e.getHuespedes(), e.getServicioBar(), null);

					}
					
							
				}
				}
		}
	}
	
	
}
