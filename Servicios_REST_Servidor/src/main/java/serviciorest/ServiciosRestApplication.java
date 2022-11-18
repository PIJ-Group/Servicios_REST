package serviciorest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Mediante la anotación SpringBootApplication le decimos a Spring que pueda
 * dar de alta objetos e inyectar dependecias.*/
@SpringBootApplication
public class ServiciosRestApplication {
	

	public static void main(String[] args) {
		System.out.println("Servicio Rest -> Cargando el contexto de Spring");
		
		SpringApplication.run(ServiciosRestApplication.class, args);
		
		System.out.println("Servicio Rest -> Contexto de Spring cargado");	
	}
	
}