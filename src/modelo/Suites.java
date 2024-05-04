package modelo;

public class Suites extends Alojamientos {
	
	private String [] dispositivosElectronicos = new String[3];

	public String[] getDispositivosElectronicos() {
		return dispositivosElectronicos;
	}

	public void setDispositivosElectronicos(String[] dispositivosElectronicos) {
		this.dispositivosElectronicos = dispositivosElectronicos;
	}

	public Suites() {}

	
	public Suites(int id, String area, String categoria, int capacidadMax, Tarifa tarifa, boolean libre, String [] s ) {
		super(id, area, categoria, capacidadMax, tarifa, libre);
		dispositivosElectronicos = s; 
	}


	
	
	
}
