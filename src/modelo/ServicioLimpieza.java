package modelo;
import java.util.*;

public class ServicioLimpieza {
	
	private Calendar fechaDia;
	private double valor;
	private int dniSolicitante;
	private int numeroAlojamiento;
	public Calendar getFechaDia() {
		return fechaDia;
	}
	public void setFechaDia(Calendar fechaDia) {
		this.fechaDia = fechaDia;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getDniSolicitante() {
		return dniSolicitante;
	}
	public void setDniSolicitante(int dniSolicitante) {
		this.dniSolicitante = dniSolicitante;
	}
	public int getNumeroAlojamiento() {
		return numeroAlojamiento;
	}
	public void setNumeroAlojamiento(int numeroAlojamiento) {
		this.numeroAlojamiento = numeroAlojamiento;
	}
	public ServicioLimpieza() {}
	public ServicioLimpieza(Calendar fechaDia, double valor, int dniSolicitante, int numeroAlojamiento) {
		super();
		this.fechaDia = fechaDia;
		this.valor = valor;
		this.dniSolicitante = dniSolicitante;
		this.numeroAlojamiento = numeroAlojamiento;
	}
	
	
}
