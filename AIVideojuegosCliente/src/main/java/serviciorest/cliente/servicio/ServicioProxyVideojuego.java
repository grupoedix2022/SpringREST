package serviciorest.cliente.servicio;

import java.util.Arrays;
import java.util.List;

import serviciorest.cliente.entidad.Videojuego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

//Servicio con etiqueta @Service para indicar que reúne la lógica de la aplicación
@Service
public class ServicioProxyVideojuego {
	
	//Indicamos la dirección como constante
	public static final String URL = "http://localhost:8080/videojuegos/";
	
	//Inyección del RestTemplate para facilitar el uso de protocolo HTTP del servicio REST.
	@Autowired
	private RestTemplate restTemplate;
	
	//Get ID, uso de ResponseEntity para devolver getBody() del JSON con control de errores.
	public Videojuego get(int gameID){
		try {		
			ResponseEntity<Videojuego> re = restTemplate.getForEntity(URL + gameID, Videojuego.class);
			HttpStatus hs= re.getStatusCode();
			if(hs == HttpStatus.OK) {	
				return re.getBody();
			}else {
				System.out.println("Respuesta no contemplada");
				return null;
			}
		}catch (HttpClientErrorException e) {
			System.out.println("obtener -> NO se ha encontrado ID: " + gameID);
		    System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	
	//Modifica Videojuego, comprobando el ID para completar el path.
	public void set(Videojuego videojuego) {
		try {			
			restTemplate.put(URL + videojuego.getGameID(), videojuego, Videojuego.class);			
		}catch(HttpClientErrorException e){
			System.out.println("obtener -> NO se ha encontrado ID: " + videojuego);
		    System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
		}
	}
	
	//Devuelve el listado de videojuegos. El Array devuelto en JSON se convierte en ArrayList.
	public List<Videojuego> list(){		
		try {
			ResponseEntity<Videojuego[]> re = restTemplate.getForEntity(URL, Videojuego[].class);
			Videojuego[] v = re.getBody();
			return Arrays.asList(v);
		} catch (HttpClientErrorException e) {
			System.out.println("listar -> Error en listado");
		    System.out.println("listar -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	
	//Elimina videojuego por ID
	public void deleteVideojuego(int gameID){
		try {		
			restTemplate.delete(URL + gameID);
			System.out.println("Se borró el juego con ID: " + gameID);
		}catch (HttpClientErrorException e) {
			System.out.println(URL + gameID);
			System.out.println("obtener -> NO se ha encontrado ID: " + gameID);
		    System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());		    
		}
	}
	
	//Añade videojuego nuevo, el chequeo del Nombre se realiza en 
	public Videojuego sign(Videojuego videojuego){
		try {		
			ResponseEntity<Videojuego> re = restTemplate.postForEntity(URL, videojuego, Videojuego.class);
			System.out.println("Se añadió videojuego");
			return re.getBody();
		}catch (HttpClientErrorException e) {
			System.out.println("alta -> El Videojuego NO se ha dado de alta: " + videojuego.getNombre());
		    System.out.println("alta -> Codigo de respuesta: " + e.getStatusCode());
		    return null;	    
		}
	}

}
