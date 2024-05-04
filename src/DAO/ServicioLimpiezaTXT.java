package DAO;
import java.io.*;

import modelo.*;
import controlador.*;

public class ServicioLimpiezaTXT {
	
	
	public void crearArchivoLimp(int dni, String fecha, int alojamiento) {
		
		FileWriter archivo = null;
		PrintWriter archivoSalida = null;
		
		try {
			String lString = String.valueOf(alojamiento);
			if(alojamiento<10) {
				lString = "0"+lString;
			}
			
			String archivoNombre = "Limp"+lString+".txt";
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
			
			//5 ESPACIOS AL VALOR DE LA LIMPIEZA
			String valor = String.valueOf(ServicioLimpieza.getValor());
	        espaciosFaltantes = 5 - valor.length();
	        for (int i = 0; i < espaciosFaltantes; i++) {
	            archivoSalida.print(" ");
	        }
			archivoSalida.print(valor);
			
			archivoSalida.close();
		}
		catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}

	}
}
