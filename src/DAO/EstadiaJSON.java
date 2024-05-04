package DAO;
import java.io.*;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import java.util.*;

import modelo.*;
import controlador.*;

public class EstadiaJSON {
	
	private EstadiaControlador estadiaControlador = new EstadiaControlador();
  	private File archivoLeer = null;
  	private Scanner archivoEntrada = null;
	private FileWriter archivo = null;
	private PrintWriter archivoSalida = null;
	


    public void cargarEstadiaJSON(Alojamientos a, Huespedes[] h, int id, Calendar fechaIngreso, int cantDias) {


        
        try {
        	File aJson = new File("estadias.json");
        	FileOutputStream fsOutJson = new FileOutputStream(aJson, true);
        	JsonWriter wrtJson = Json.createWriter(fsOutJson);
        	
            JsonObjectBuilder objJsonEstadia = Json.createObjectBuilder();
            
            objJsonEstadia.add("id", id);
            
            String fecha = fechaIngreso.get(Calendar.DATE)+ "/"+(fechaIngreso.get(Calendar.MONTH)+1) + fechaIngreso.get(Calendar.YEAR);
            objJsonEstadia.add("fechaIngreso", fecha);
            objJsonEstadia.add("cantidadDias", cantDias);
            
            JsonArrayBuilder jsonArrayHuespedes = Json.createArrayBuilder();
            
            for (Huespedes huesped : h) {
                JsonObjectBuilder objJsonHuesped = Json.createObjectBuilder();
                objJsonHuesped.add("nombre", huesped.getNombre());
                objJsonHuesped.add("apellido", huesped.getApellido());
                objJsonHuesped.add("dni", huesped.getNumeroDocumento());
                objJsonHuesped.add("pais", huesped.getPais());
                
                jsonArrayHuespedes.add(objJsonHuesped);
            }
            JsonArray jsonArray = jsonArrayHuespedes.build();
            objJsonEstadia.add("Huespedes", jsonArray);

            JsonObjectBuilder objJsonAlojamientos = Json.createObjectBuilder();
            objJsonAlojamientos.add("id", a.getId());
            objJsonAlojamientos.add("area", a.getArea());
            objJsonAlojamientos.add("tarifaID", a.getTarifa().getIdTarifa());
            objJsonAlojamientos.add("capacidadMaxima", a.getCapacidadMax());
            objJsonAlojamientos.add("categoria", a.getCategoria());
            objJsonAlojamientos.add("libre", a.getLibre());
            
            JsonObject objJsonAlojamientosFile = objJsonAlojamientos.build();
            objJsonEstadia.add("alojamiento", objJsonAlojamientosFile);                
       
            JsonObject objJsonEstadiaFinal = objJsonEstadia.build();
            
            wrtJson.writeObject(objJsonEstadiaFinal);
            
            wrtJson.close();
                             
            
            
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo JSON: " + e.getMessage());
   
    }
    }
}

