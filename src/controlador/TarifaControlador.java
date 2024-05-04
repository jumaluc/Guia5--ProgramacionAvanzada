package controlador;
import java.util.NoSuchElementException;

import DAO.TarifaCSV;
import modelo.*;

public class TarifaControlador {
	
	private TarifaCSV tarifasArchivo = new TarifaCSV();
	private Tarifa[] tarifas = new Tarifa[19];
	
	public Tarifa[] objetoTarifa() {
         tarifas = tarifasArchivo.leerArchivo();
        return tarifas;

	}
	
    public Tarifa encontrarTarifa(int capMax, String categoria){
    	
    try {	
        for(Tarifa t : objetoTarifa()) {
        	 if(capMax == t.getCapacidad() && categoria.equals(t.getCategoria())) {
        		 return t;
        	 }
        }
        throw new NoSuchElementException("No se encontró ninguna tarifa con esas cualidades");
    }
    catch(NoSuchElementException e) {
    	System.out.println(e.getMessage());
    	return null;
    }
    }
}
