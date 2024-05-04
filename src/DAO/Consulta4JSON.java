package DAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import controlador.*;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;

import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import modelo.*;
public class Consulta4JSON {
	
	private EstadiaControlador estadiaControlador = new EstadiaControlador();
	private File archivo = null;
	private FileOutputStream archivoSalida = null;
	private JsonWriter wrtJson = null;
	private JsonArrayBuilder arrayFinal = null;
	private JsonReader reader = null;
	private Consulta4Controlador consulta4Controlador = new Consulta4Controlador();
	
	public void cargarConsulta4JSON(Alojamientos a, String fecha, Huespedes[] h, ServicioBar[] s, ServicioLimpieza[] l) {
		
		try {
			archivo = new File("consulta4.json");
			archivoSalida = new FileOutputStream(archivo, true);
			wrtJson = Json.createWriter(archivoSalida);
			arrayFinal = Json.createArrayBuilder();
			
			JsonObjectBuilder objFinal = Json.createObjectBuilder();
			JsonObjectBuilder objAlojamiento = Json.createObjectBuilder();
			objAlojamiento.add("numero", a.getId());
			objAlojamiento.add("area", a.getArea());
			objAlojamiento.add("categoria", a.getCategoria());
			objAlojamiento.add("tarifa", a.getTarifa().getPrecio());
			
			JsonObject objAlojamientoFinalizado = objAlojamiento.build();
			
			objFinal.add("Alojamiento", objAlojamientoFinalizado);
			objFinal.add("Fecha Ingreso", fecha);
			JsonArrayBuilder arrayHuespedes = Json.createArrayBuilder();
			for(Huespedes huespedes : h) {
				JsonObjectBuilder huesped = Json.createObjectBuilder();
				
				huesped.add("nombre", huespedes.getNombre());
				huesped.add("apellido", huespedes.getApellido());
				JsonObject huespedFinalizado = huesped.build();
				
				arrayHuespedes.add(huespedFinalizado);
			}
			JsonArray arrayHuespedesFinalizado = arrayHuespedes.build();
			
			objFinal.add("Huespedes", arrayHuespedesFinalizado);
			
			JsonArrayBuilder arrayServicioBar = Json.createArrayBuilder();
			for(ServicioBar ser : s) {
				Calendar fecha1 = ser.getFechaDia();
				if(fecha1!=null) { //YA QUE SI ES NULL LA FECHA SIGNIFICA QUE NUNCA SE CARGO EL SERVICIO BAR EN ESA POSICION
				JsonObjectBuilder servicioBar = Json.createObjectBuilder();
				
				String fechaFormato = fecha1.get(Calendar.DATE)+"/"+(fecha1.get(Calendar.MONTH)+1)+"/"+fecha1.get(Calendar.YEAR);
				servicioBar.add("Fecha", fechaFormato);
				servicioBar.add("Plato", ser.getNombrePlato().getNombre());
				servicioBar.add("Cantidad", ser.getCantidad());
				servicioBar.add("Precio", ser.getNombrePlato().getPrecio());
				
				JsonObject servicioBarFinalizado = servicioBar.build();
				arrayServicioBar.add(servicioBarFinalizado);
				}
				
			}
			JsonArray arrayServicioBarFinalizado = arrayServicioBar.build();
			objFinal.add("Servicios de Bar", arrayServicioBarFinalizado);
			JsonArrayBuilder arrayServicioLimpieza = Json.createArrayBuilder();
			if(l!=null) {
				for(ServicioLimpieza limp : l) {
					Calendar fecha1=limp.getFechaDia();
					if(fecha1!=null) {
						JsonObjectBuilder servicioLimpieza = Json.createObjectBuilder();
						String fechaFormato = fecha1.get(Calendar.DATE)+"/"+(fecha1.get(Calendar.MONTH)+1)+"/"+fecha1.get(Calendar.YEAR);
						servicioLimpieza.add("Fecha", fechaFormato);
						servicioLimpieza.add("Dni solicitante", limp.getDniSolicitante().getNumeroDocumento());
						//NO LE PONGO EL PRECIO PORQUE ES PARA TODOS EL MISMO
						JsonObject servicioLimpiezaFinalizado = servicioLimpieza.build();
						
						arrayServicioLimpieza.add(servicioLimpiezaFinalizado);
					}
				}
				JsonArray arrayServicioLimpiezaFinalizado = arrayServicioLimpieza.build();
				objFinal.add("Servicios de Limpieza", arrayServicioLimpiezaFinalizado);
			}
			JsonObject objFinalFinalizado = objFinal.build();
			
			arrayFinal.add(objFinalFinalizado);
			JsonArray jsonArrayFinalizado = arrayFinal.build();
			
			wrtJson.writeArray(jsonArrayFinalizado);
			
			wrtJson.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(wrtJson !=null) {
					wrtJson.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void leerConsulta4() {
		
		try {
			archivo= new File("consulta4.json");
			FileInputStream archivoSalida = new FileInputStream(archivo);
			reader = Json.createReader(archivoSalida);
			JsonArray arrayGlobal = reader.readArray();
			
			for(JsonObject objetoFinal : arrayGlobal.getValuesAs(JsonObject.class)) {
				
				JsonObject objetoAlojamiento = objetoFinal.getJsonObject("Alojamiento");
				
				int numeroAlojamiento=0;
				
				try {
					numeroAlojamiento=objetoAlojamiento.getInt("numero");
					if(numeroAlojamiento<0) {
						throw new ExcepcionDato("Error el numero del alojamiento no deberia ser menor a 0");
					}
				}	
				catch(ExcepcionDato e) {
					e.getMessage();
				}
				String area ="";
				try {
					area=objetoAlojamiento.getString("area");
					if(area.equals("")) {
						throw new ExcepcionDato("Error el area no deberia estar vacia: ");
					}
				}
				catch(ExcepcionDato e) {
					e.getMessage();
				}
				
				String categoria=objetoAlojamiento.getString("categoria");
				JsonNumber precioJ=objetoAlojamiento.getJsonNumber("precio");
				double precio = precioJ.doubleValue();
				 
				consulta4Controlador.mostrarAlojamiento(numeroAlojamiento, area, categoria, precio);
				
				String fechaIngreso=objetoFinal.getString("Fecha Ingreso");
				
				consulta4Controlador.mostrarFechaIngreso(fechaIngreso);
				
				JsonArray  arrayHuespedes = objetoFinal.getJsonArray("Huespedes");
				for(JsonObject huesped : arrayHuespedes.getValuesAs(JsonObject.class)) {
					
					String nombre = huesped.getString("Nombre");
					String apellido = huesped.getString("Apellido");
					
					consulta4Controlador.mostrarHuespedes(nombre, apellido);
				}
				JsonArray servicioBar = objetoFinal.getJsonArray("Servicios de Bar");
				for(JsonObject s : servicioBar.getValuesAs(JsonObject.class)) {
					
					String fecha = s.getString("Fecha");
					String plato = s.getString("Plato");
					int cantidad = s.getInt("Cantidad");
					JsonNumber precioJP= s.getJsonNumber("Precio");
					double precioP = precioJP.doubleValue();
					
					consulta4Controlador.mostrarServicioBar(fecha, plato, cantidad, precioP);
				}
				if(objetoFinal.containsKey("Servicios de Limpieza")) {
					JsonArray servicioLimpiezaArray = objetoFinal.getJsonArray("Servicios de Limpieza");
					for(JsonObject s : servicioLimpiezaArray.getValuesAs(JsonObject.class)) {
						
						String fecha = s.getString("Fecha");
						int dni = s.getInt("Dni solicitante");
						
						consulta4Controlador.mostrarServicioLimpieza(fecha, dni);
					}
				}
				
				
			}
				
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
