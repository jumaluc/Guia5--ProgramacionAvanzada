package modelo;
import java.util.*;
public class ServicioBar implements IPagar{
	
	private Calendar fechaDia;
	private Huespedes huespedSolicitante;
	private int cantidad;
	private Menu plato;
	public Calendar getFechaDia() {
		return fechaDia;
	}
	public void setFechaDia(Calendar fechaDia) {
		this.fechaDia = fechaDia;
	}
	public Huespedes getDniSolicitante() {
		return huespedSolicitante;
	}
	public void setHuespedSolicitante(Huespedes huespedSolicitante) {
		this.huespedSolicitante = huespedSolicitante;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Menu getNombrePlato() {
		return plato;
	}
	public void setNombrePlato(Menu plato) {
		this.plato = plato;
	}
	public ServicioBar() {}
	public ServicioBar(Calendar fechaDia, Huespedes huespedSolicitante, int cantidad, Menu plato) {
		super();
		this.fechaDia = fechaDia;
		this.huespedSolicitante = huespedSolicitante;
		this.cantidad = cantidad;
		this.plato = plato;
	}
	public double totalApagar() {
		return plato.getPrecio()*(double)cantidad;
		
	}
	
	
}
