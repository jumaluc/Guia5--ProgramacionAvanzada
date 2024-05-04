package modelo;

import java.util.*;
public class Estadia implements IPagar{
	
	private int idEstadia;
	private Calendar fechaIngreso;
	private int cantidadDias;
	private boolean limpieza;
	private Huespedes [] huespedes;
	private Alojamientos alojamiento;
	private boolean bar;
	private ServicioBar[] servicioBar = new ServicioBar[10];
	private ServicioLimpieza[] servicioLimpieza = new ServicioLimpieza[10];
	private boolean finalizada = false;
	
	
	
	
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public int getIdEstadia() {
		return idEstadia;
	}
	public void setIdEstadia(int idEstadia) {
		this.idEstadia = idEstadia;
	}
	public Huespedes[] getHuespedes() {
		return huespedes;
	}
	public void setHuespedes(Huespedes[] huespedes) {
		this.huespedes = huespedes;
	}
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getCantidadDias() {
		return cantidadDias;
	}
	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}
	public boolean isLimpieza() {
		return limpieza;
	}
	public void setLimpieza(boolean limpieza) {
		this.limpieza = limpieza;
	}

	public void setHuesped(Huespedes[] huesped) {
		this.huespedes = huesped;
	}
	public Alojamientos getAlojamiento() {
		return alojamiento;
	}
	public void setAlojamiento(Alojamientos alojamiento) {
		this.alojamiento = alojamiento;
	}
	public boolean isBar() {
		return bar;
	}
	public void setBar(boolean bar) {
		this.bar = bar;
	}
	public ServicioBar[] getServicioBar() {
		return servicioBar;
	}
	public void setServicioBar(Huespedes h, Calendar f,  int p, int cantidad, Menu plato) {
		servicioBar[p].setCantidad(cantidad);
		servicioBar[p].setHuespedSolicitante(h);
		servicioBar[p].setNombrePlato(plato);
		servicioBar[p].setFechaDia(f);
	}
	public ServicioLimpieza[] getServicioLimpieza() {
		return servicioLimpieza;
	}
	public void setServicioLimpieza(Huespedes h, Calendar f, int p) {
		servicioLimpieza[p].setHuespedSolicitante(h);
		servicioLimpieza[p].setFechaDia(f);
	}
	
	public void crearServicioLimpieza() {
		for(int i = 0 ; i < servicioLimpieza.length ; i++) {
			servicioLimpieza[i] = new ServicioLimpieza();
		}
	}
	
	
	public Estadia() {
		
		for(int i = 0 ; i < servicioBar.length ; i++) {
			servicioBar[i] = new ServicioBar();
		}
	}
	
	
	public Estadia(Calendar fechaIngreso, int cantidadDias, boolean limpieza, Huespedes [] huesped,
			Alojamientos alojamiento, boolean bar, ServicioBar[] servicioBar, ServicioLimpieza[] servicioLimpieza) {
		this();
		this.fechaIngreso = fechaIngreso;
		this.cantidadDias = cantidadDias;
		this.limpieza = limpieza;
		this.huespedes = huesped;
		this.alojamiento = alojamiento;
		this.bar = bar;
		this.servicioBar = servicioBar;
		this.servicioLimpieza = servicioLimpieza;
	}
	
	public double totalApagar() {
		double alojamientoPrecioxDias = alojamiento.getTarifa().getPrecio()*cantidadDias;
		double valorLimpieza=0;
		double valorBar=0;
		if(alojamiento instanceof Cabañas) {
			
			for(ServicioLimpieza s : servicioLimpieza) {
				if(s!=null) {
					valorLimpieza+=s.totalApagar();
				}
			}
		}
		for(ServicioBar b : servicioBar) {
			valorBar=b.totalApagar();
		}
		//VER SI SUPERA 3 DIAS LA PERMANENCIA
		Calendar fechaHoy = Calendar.getInstance();
		Calendar fechaHoymenos3 = Calendar.getInstance();
		fechaHoymenos3.add(Calendar.DATE, -3);
		if(fechaIngreso.before(fechaHoy) && fechaIngreso.after(fechaHoymenos3)){
			alojamientoPrecioxDias=alojamientoPrecioxDias-alojamientoPrecioxDias*0.07;
		}
		return alojamientoPrecioxDias+valorLimpieza+valorBar;
	
	}
	
	
}
