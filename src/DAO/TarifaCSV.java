package DAO;
import java.io.*;
import java.util.*;

import modelo.Tarifa;

public class TarifaCSV{
	
	  private File archivo = null;
	  private Scanner archivoEntrada = null;

	    public Tarifa[] leerArchivo() {
	        try {
	            archivo = new File("tarifas.csv");
	            archivoEntrada = new Scanner(archivo);
	            int i = 0;
	            Tarifa tarifas[] = new Tarifa[contadorLinea()];
	   
	            while (archivoEntrada.hasNext()) {
	            	
	                String lineaActual = archivoEntrada.nextLine();
	                String linea [] = lineaActual.split(";");	          
	                int idTarifa = Integer.parseInt(linea[0]);
	                double precio = Double.parseDouble(linea[1]);
	                String categoria = linea[2];
	                int capacidad = Integer.parseInt(linea[3]);	          
	                tarifas[i] = new Tarifa(idTarifa, categoria, capacidad, precio);    
	            }
	            
	            return tarifas ;
	        } catch (IOException e) {
	            System.out.println("El archivo no existe");
	            return null;
	        } finally {
	            try {
	                if (archivoEntrada != null) {
	                    archivoEntrada.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
			
	    }
		   public  int contadorLinea() {
		        try (FileReader archivo = new FileReader("tarifas.csv");
		             Scanner scanner = new Scanner(archivo)) {
		            int contadorLineas = 0;
		            while (scanner.hasNextLine()) {
		                scanner.nextLine();
		                contadorLineas++;
		            }
		            return contadorLineas;
		        } catch (IOException e) {
		            System.out.println("Error al contar líneas: " + e.getMessage());
		            return 0;
		        }
	}
}
