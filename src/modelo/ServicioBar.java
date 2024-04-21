package modelo;
import java.util.*;
public class ServicioBar {
	
	private Calendar fechaDia;
	private int dniSolicitante;
	private int cantidad;
	private int numeroAlojamiento; 
	private String nombrePlato;
	public Calendar getFechaDia() {
		return fechaDia;
	}
	public void setFechaDia(Calendar fechaDia) {
		this.fechaDia = fechaDia;
	}
	public int getDniSolicitante() {
		return dniSolicitante;
	}
	public void setDniSolicitante(int dniSolicitante) {
		this.dniSolicitante = dniSolicitante;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getNumeroAlojamiento() {
		return numeroAlojamiento;
	}
	public void setNumeroAlojamiento(int numeroAlojamiento) {
		this.numeroAlojamiento = numeroAlojamiento;
	}
	public String getNombrePlato() {
		return nombrePlato;
	}
	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}
	public ServicioBar() {}
	public ServicioBar(Calendar fechaDia, int dniSolicitante, int cantidad, int numeroAlojamiento, String nombrePlato) {
		super();
		this.fechaDia = fechaDia;
		this.dniSolicitante = dniSolicitante;
		this.cantidad = cantidad;
		this.numeroAlojamiento = numeroAlojamiento;
		this.nombrePlato = nombrePlato;
	}
	
	
}
