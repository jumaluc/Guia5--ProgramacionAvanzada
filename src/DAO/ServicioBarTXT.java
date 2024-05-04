package DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import modelo.ServicioLimpieza;

public class ServicioBarTXT {

	
	public void crearArchivoBar(int dni, String fecha, int cantidad, String plato, int alojamiento) {
		
		
		FileWriter archivo = null;
		PrintWriter archivoSalida = null;
		try {
			String lString = String.valueOf(alojamiento);
			if(alojamiento<10) {
				lString = "0"+lString;
			}
			
			String archivoNombre = "Cons"+lString+".txt";
			archivo = new FileWriter(archivoNombre, true);
			archivoSalida = new PrintWriter(archivo);
			
			//LE RESERVO 10 ESPACIOS AL DNI
			
			String dniString = String.valueOf(dni);
	        int espaciosFaltantes = 10 - dniString.length();
	        for (int i = 0; i < espaciosFaltantes; i++) {
	            archivoSalida.print(" ");
	        }
			archivoSalida.print(dniString);
			
			//11 ESPACIOS A LA FECHA
	        espaciosFaltantes = 11 - fecha.length();
	        for (int i = 0; i < espaciosFaltantes; i++) {
	            archivoSalida.print(" ");
	        }
			archivoSalida.print(fecha);
			
			String cantidadString = String.valueOf(cantidad);
			espaciosFaltantes = 3 - cantidadString.length();
	        for (int i = 0; i < espaciosFaltantes; i++) {
	            archivoSalida.print(" ");
	        }
	        archivoSalida.print(cantidadString);
	        
	        espaciosFaltantes = 20 - plato.length();
	        for (int i = 0; i < espaciosFaltantes; i++) {
	            archivoSalida.print(" ");
	        }
	        archivoSalida.print(plato);
	        
	        
			
		}
		catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		finally {
			archivoSalida.close();

		}
	}
	
}
