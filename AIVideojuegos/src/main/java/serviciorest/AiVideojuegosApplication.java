package serviciorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Arranque de aplicacion SpringBoot
@SpringBootApplication
public class AiVideojuegosApplication {

	public static void main(String[] args) {
		//Ejecución de contexto Spring
		System.out.println("Servicio Rest -> Cargando el contexto de Spring...");
		SpringApplication.run(AiVideojuegosApplication.class, args);
		System.out.println("Servicio Rest -> Cargado con éxito...");
	}

}
