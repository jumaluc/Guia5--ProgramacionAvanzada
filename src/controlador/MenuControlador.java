package controlador;
import DAO.MenuJSON;
import vistas.*;
import modelo.*;

public class MenuControlador {
	
	private MenuJSON menuJSON = new MenuJSON();
	private Menu[] menu = cargarMenuJson();
	private MenuComidaVista menuComidaVista = new MenuComidaVista();
	public Menu[] cargarMenuJson() {
		
		
		return menuJSON.leerArchivo();
	}
	
	
	public Menu existenciaMenu(int id) {
		
		for(Menu m : menu) {
			if(m!=null) {
				if(m.getIdMenu()==id) {
					return m;
				}
			}
		}return null;
		
	}
	public Menu[] devolverMenu() {
		
		return menu;
	}
	public void mostrarPlatoConsulta1(String s) {
		menuComidaVista.mostrar(s);
	}

}

