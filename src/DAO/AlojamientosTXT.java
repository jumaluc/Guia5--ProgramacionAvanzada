package DAO;
import java.io.*;
import java.util.*;
import controlador.*
;
import modelo.Alojamientos;
import modelo.Cabañas;
import modelo.Suites;

public class AlojamientosTXT   {
    
    private File archivo = null;
    private Scanner archivoEntrada = null;

    
    
    public Alojamientos[] leerArchivo() {
        try {
            archivo = new File("alojamientos.txt");
            archivoEntrada = new Scanner(archivo);
            int i = 0;
            Alojamientos alojamientos[] = new Alojamientos[contadorLinea()];
            while (archivoEntrada.hasNext()) {
                String lineaActual = archivoEntrada.nextLine();
                int id  = Integer.parseInt(lineaActual.substring(0, 2).trim());
                String area = lineaActual.substring(2, 13);
                String categoria = lineaActual.substring(13, 23);
                int capMax  = Integer.parseInt(lineaActual.substring(23, 25).trim());
                int iDtarifa  = Integer.parseInt(lineaActual.substring(25, 27).trim());
                
                
                
                String l = lineaActual.substring(27, 32).trim();
                boolean libre = false;
                if(l.equals("true")) {
                	libre=true;
                }
                else if(l.equals("false")) {
                	
                }
                else {
                	System.out.println("error");
                }
                String tipo = lineaActual.substring(32,38).trim();
                TarifaControlador  tarifaControlador = new TarifaControlador();
                if(tipo.equals("cabaña")) {
                    String h = lineaActual.substring(38, 43); 
                    boolean hidromasaje = false;
                    if(h.equals("true")) {
                    	hidromasaje=true;
                    }
                    else if(h.equals("false")) {
                    	
                    }
                    else {
                    	System.out.println("error");
                    }
                    	
                    double adicional =  Double.parseDouble((lineaActual.substring(43, 47))); //ver bien que hacer con esto
                	alojamientos[i] = new Cabañas(id, area, categoria, capMax, tarifaControlador.encontrarTarifa(capMax, categoria), libre, hidromasaje);

                	
                }
                else if (tipo.equals("suites")) {
                	String[] dispositivos = lineaActual.substring(38, 70).split(";");
                	for (int j = 0; j < dispositivos.length; j++) {
                	    dispositivos[j] = dispositivos[j].trim();
                	}
                	alojamientos[i] = new Suites(id,area,categoria,capMax, tarifaControlador.encontrarTarifa(capMax, categoria), libre, dispositivos);

                }
                else {
                	System.out.println("Error");
                }
                
                

            }
            return alojamientos;
        } 
    
        catch (IOException e) {
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
	        try (FileReader archivo = new FileReader("alojamientos.txt");
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
