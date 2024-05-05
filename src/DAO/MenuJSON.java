package DAO;
import javax.json.*;

import modelo.Menu;

import java.io.*;
public class MenuJSON {

	public Menu[] leerArchivo() {

		try {
			File aJson = new File("menu.JSON");
			FileInputStream fsInJson = new FileInputStream(aJson);
			JsonReader rdrJson = Json.createReader(fsInJson);
			JsonArray menuArray = rdrJson.getJsonArray();
			int cantidadObj = menuArray.size();
			Menu [] menu = new Menu[cantidadObj];
			
			for(int i = 0 ; i<cantidadObj ; i++) {
				
				JsonObject menuJson = menuArray.getJsonObject(i);
				
				String tipo = menuJson.getString("tipo");
				String nombre = menuJson.getString("nombre");
				double precio = menuJson.getJsonNumber("precio").doubleValue();
				int idMenu = menuJson.getInt("idMenu");
				JsonArray jsonArray = menuJson.getJsonArray("ingredientes");
				String [] ingredientes = new String[jsonArray.size()];
				int l = 0;
				for(JsonValue v : jsonArray) {
					ingredientes[l] = v.toString();
					l++;
				}
				boolean compartir = menuJson.getBoolean("compartir");
				menu[i]= new Menu(tipo, nombre, precio, ingredientes, compartir, idMenu);

			}
			return menu;

			
			}
		catch(IOException e) {
			e.printStackTrace();		}
		finally {
			
		}
		
		return null;

	}
}
