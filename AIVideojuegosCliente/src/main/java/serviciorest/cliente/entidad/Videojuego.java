package serviciorest.cliente.entidad;

import org.springframework.stereotype.Component;

@Component
public class Videojuego {
	
	private int gameID;
	private String nombre;
	private String compania;
	private double nota;
	
	public Videojuego () {
		super();
	}
	
	public Videojuego  (int gameID, String nombre, String compania, double nota) {		
		this.gameID = gameID;
		this.nombre = nombre;
		this.compania = compania;
		this.nota = nota;
	}
	
	public Videojuego  (String nombre, String compania, double nota) {		
		this.nombre = nombre;
		this.compania = compania;
		this.nota = nota;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Videojuego [gameID=" + gameID + ", nombre=" + nombre + ", compania=" + compania + ", nota=" + nota + "]";
	}
	

}
