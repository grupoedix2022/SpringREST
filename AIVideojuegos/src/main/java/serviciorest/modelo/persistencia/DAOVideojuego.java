package serviciorest.modelo.persistencia;

import serviciorest.modelo.entidad.Videojuego;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

//Objeto DAO. Usamos la anotacion @Component, para posterior inyección con @Autowired
@Component
public class DAOVideojuego {
	
	//Creamos biblioteca de videojuegos e inicializamos con juegos y con id para autoasignación
	public List<Videojuego> biblioteca;
	int id=0;
	
	public DAOVideojuego (){
			
		System.out.println("DaoVideojuego");
		biblioteca = new ArrayList<Videojuego>();
		Videojuego v1 = new Videojuego(id++, "God of War", "Santa Monica Studios", 99);
		Videojuego v2 = new Videojuego(id++, "Monkey Island", "Lucas Arts", 100);
		Videojuego v3 = new Videojuego(id++, "Superman 64", "Titus Interactive", 0.1);
		Videojuego v4 = new Videojuego(id++, "Bloodborne", "Fromsoftware", 95);
		Videojuego v5 = new Videojuego(id++, "Frostpunk", "11 bits Stusios", 89);
		
		biblioteca.add(v1);
		biblioteca.add(v2);
		biblioteca.add(v3);
		biblioteca.add(v4);
		biblioteca.add(v5);
		
				
		}
	
	//Método que devuelve videojuego por ID
	public Videojuego get(int gameID){
		Videojuego videojuego = null;
		try {
			for (Videojuego v : biblioteca) {
				if (v.getGameID() == gameID) {
					videojuego =v;
				}
			}
			return videojuego;
		} catch (NullPointerException iobe) {
			System.out.println("No existe");
			return null;
		}
	}
	
	//Método para chequar el nombre por si hubiera repetidos
	public boolean checkNombre(String nombre) {
		boolean check = true;
		for (Videojuego v : biblioteca) {
			if (v.getNombre().equalsIgnoreCase(nombre)){
				check = false;
				return check;
				}
		}
		return check;			
	}
	
	//Método para chequar el ID por si hubiera repetidos
	public boolean checkID(int id) {
		boolean check = true;
		for (Videojuego v : biblioteca) {
			if (v.getGameID()==id){
				check = false;
				return check;
				}
		}
		return check;			
	}

	//Método Get
	public List<Videojuego> getBiblioteca() {
		return biblioteca;
	}

	//Set
	public void setBiblioteca(List<Videojuego> biblioteca) {
		this.biblioteca = biblioteca;
	}

	//add incluye asignación de nuevo ID
	public void add(Videojuego videojuego) {
		videojuego.setGameID(id++);
		this.biblioteca.add(videojuego);		
	}
		
	
	//Método que elimina videojuego por ID
	public Videojuego remove(int gameID) {			
			try{
				return biblioteca.remove(biblioteca.indexOf(this.get(gameID)));
			}catch (Exception e) {
				System.out.println("Error");
				return null;
			}
	}
	
	//Actualización de videojuego
	public Videojuego update(Videojuego v) {
		try {		
			Videojuego vSet = this.get(v.getGameID());
			vSet.setGameID(v.getGameID());
			vSet.setNombre(v.getNombre());
			vSet.setCompania(v.getCompania());
			vSet.setNota(v.getNota());
			return vSet;
		}catch (Exception e) {
				System.out.println("Update -> Error");
				return null;
		}
			
	}
	
}
	

	
				
	

		


