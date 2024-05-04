package vistas;
import controlador.*;

import java.util.*;
public class MenuVista {
	
	public void mostrarMenu(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		Validaciones validaciones = new Validaciones();
		//Calendar fechaDia = Calendar.getInstance();
		AlojamientosVista alojamientosVista = new AlojamientosVista();
		HuespedesVista huespedesVista = new HuespedesVista();
		EstadiaControlador estadiaControlador = new EstadiaControlador();
		ServicioLimpiezaControlador servicioLimpiezaControlador = new ServicioLimpiezaControlador();
		ServicioBarControlador servicioBarControlador = new ServicioBarControlador();
		AlojamientoControlador alojamientoControlador = new AlojamientoControlador();
		
		do {	
			System.out.println("Ingrese 1 para ver las unidades disponibles");
			System.out.println("Ingrese 2 para ingresar huespedes");
			int menu = validaciones.validarInt();
			switch(menu) {
			case 1 : alojamientosVista.unidadesDisponibles();
			case 2 : estadiaControlador.crearEstadia();			
			case 3 : estadiaControlador.llamadaServicioLimpieza();
			//solicitud de limpieza extra //tengo que verificar que el huesped este en alguna estadia y que sea cabania, luego crear el objeto y el archivo
			case 4 : estadiaControlador.llamadaServicioBar();
			case 5 : estadiaControlador.totalApagar();
			//CONSULTAS
			case 6 : estadiaControlador.consulta1(args); 
			case 7 : estadiaControlador.consulta2();
			case 8 : estadiaControlador.consulta3();
			case 9 : estadiaControlador.carcarConsulta4JSON(); 
			}
		}
		
		while(true);
		
	}

}
