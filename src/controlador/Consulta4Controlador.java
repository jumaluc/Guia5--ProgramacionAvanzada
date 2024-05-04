package controlador;

import vistas.Consulta4Vista;

public class Consulta4Controlador {
	
	private Consulta4Vista consulta4Vista = new Consulta4Vista();
	public void mostrarConsulta4() {
	}
	public void mostrarAlojamiento(int i, String a, String c, double p) {
		consulta4Vista.mostrarMensaje("ALOJAMIENTO");
		consulta4Vista.mostrarArgInt(i, "numero del alojamiento: ");
		consulta4Vista.mostrarArgString(a, "area: ");
		consulta4Vista.mostrarArgString(c, "categoria: ");
		consulta4Vista.mostrarArgDouble(p, "tarifa: ");
	}
	public void mostrarFechaIngreso(String fechaIngreso) {
		consulta4Vista.mostrarArgString(fechaIngreso, "Fecha Ingreso: ");
	}
	public void mostrarHuespedes(String n, String a) {
		consulta4Vista.mostrarMensaje("HUESPED");
		consulta4Vista.mostrarArgString(n, "Nombre: ");
		consulta4Vista.mostrarArgString(a, "Apellido: ");
	}
	public void mostrarServicioBar(String fecha,String  plato,int  cantidad,double precioP) {
		consulta4Vista.mostrarMensaje("SERVICIO BAR");
		consulta4Vista.mostrarArgString(fecha, "Fecha: ");
		consulta4Vista.mostrarArgString(plato, "Plato: ");
		consulta4Vista.mostrarArgInt(cantidad, "Cantidad: ");
		consulta4Vista.mostrarArgDouble(precioP, "Precio: ");
	}
	public void mostrarServicioLimpieza(String fecha,int dni) {
		consulta4Vista.mostrarMensaje("SERVICIO LIMPIEZA");
		consulta4Vista.mostrarArgString(fecha, "Fecha: ");
		consulta4Vista.mostrarArgInt(dni, "Dni del Solicitante: ");
	}
	
}
