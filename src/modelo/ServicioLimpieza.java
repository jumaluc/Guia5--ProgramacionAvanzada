package modelo;
import java.util.*;

public class ServicioLimpieza implements IPagar{
	
	private Calendar fechaDia;
	private static double valor=500;
	private Huespedes huespedSolicitante;
	
	
	public Calendar getFechaDia() {
		return fechaDia;
	}
	public void setFechaDia(Calendar fechaDia) {
		this.fechaDia = fechaDia;
	}
	public static double getValor() {
		return valor;
	}
	public Huespedes getDniSolicitante() {
		return huespedSolicitante;
	}
	public void setHuespedSolicitante(Huespedes dniSolicitante) {
		this.huespedSolicitante = dniSolicitante;
	}
	


	public Huespedes getHuespedSolicitante() {
		return huespedSolicitante;
	}
	public static void setValor(double valor) {
		ServicioLimpieza.valor = valor;
	}
	public ServicioLimpieza() {}
	public ServicioLimpieza(Calendar fechaDia, Huespedes huespedSolicitante) {
		super();
		this.fechaDia = fechaDia;
		this.huespedSolicitante = huespedSolicitante;
	}
	public double totalApagar() {
		return valor;
	}
	
	
}
