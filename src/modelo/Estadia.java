package modelo;

import java.util.*;
public class Estadia {
	
	private Calendar fechaIngreso;
	private int cantidadDias;
	private boolean limpieza;
	private Huespedes [] huesped;
	private Alojamientos alojamiento;
	private boolean bar;
	private ServicioBar servicioBar;
	private ServicioLimpieza servicioLimpieza;
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
	public Huespedes [] getHuesped() {
		return huesped;
	}
	public void setHuesped(Huespedes[] huesped) {
		this.huesped = huesped;
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
	public ServicioBar getServicioBar() {
		return servicioBar;
	}
	public void setServicioBar(ServicioBar servicioBar) {
		this.servicioBar = servicioBar;
	}
	public ServicioLimpieza getServicioLimpieza() {
		return servicioLimpieza;
	}
	public void setServicioLimpieza(ServicioLimpieza servicioLimpieza) {
		this.servicioLimpieza = servicioLimpieza;
	}
	
	public Estadia() {}
	public Estadia(Calendar fechaIngreso, int cantidadDias, boolean limpieza, Huespedes [] huesped,
			Alojamientos alojamiento, boolean bar, ServicioBar servicioBar, ServicioLimpieza servicioLimpieza) {
		this.fechaIngreso = fechaIngreso;
		this.cantidadDias = cantidadDias;
		this.limpieza = limpieza;
		this.huesped = huesped;
		this.alojamiento = alojamiento;
		this.bar = bar;
		this.servicioBar = servicioBar;
		this.servicioLimpieza = servicioLimpieza;
	}
	
	
}
