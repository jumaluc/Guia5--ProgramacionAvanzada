package DAO;
import java.util.Scanner;
import java.io.*;
import controlador.*;
import modelo.*;
import vistas.ErrorValidacionHuesped;
public class HuespedesTXT {
	
	  	private File archivoLeer = null;
	  	private Scanner archivoEntrada = null;
		private FileWriter archivo = null;
		private PrintWriter archivoSalida = null;
		private ControladorExcepcion controladorExcepcion = new ControladorExcepcion();;
		
	public void cargarHuespedes(int dni, String nombre, String apellido, String pais) {
		try {
			archivo = new FileWriter("huespedes.txt",true);
			archivoSalida = new PrintWriter(archivo);
			archivoSalida.print(dni+"|");
			archivoSalida.print(nombre+"|");
			archivoSalida.print(apellido+"|");
			archivoSalida.print(pais);
			
		}
		catch(IOException e) {
			System.out.println("Error con el archivo");
		}
		finally {
			archivoSalida.close();
		}
	}
	public boolean leerHuespedes(int dni, String nombre, String apellido, String pais){
		
		try {
			archivoLeer = new File("huespedes.txt");
			archivoEntrada = new Scanner(archivoLeer);
			while(archivoEntrada.hasNext()) {
				String lineaActual = archivoEntrada.nextLine();
				String [] lineaActualString = lineaActual.split("|");
				int dniLinea = Integer.parseInt(lineaActualString[0]);
				if(dni == dniLinea) {
					if(!lineaActualString[1].equals(nombre) || !lineaActualString[2].equals(apellido) || !lineaActualString[3].equals(pais)) {
						controladorExcepcion.llamarExcepcion();
					}
					return true;
					 //VALIDAR DATOS
					
				}
				return false;
			}
		}
		catch(IOException e) {
			System.out.println("Error al intentar leer el archivo");
		}
		finally {
			archivoEntrada.close();
		}
		return false;
	}
	

}
