package serviciorest.cliente;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import serviciorest.cliente.entidad.Videojuego;
import serviciorest.cliente.servicio.ServicioProxyVideojuego;

@SpringBootApplication
public class ServiciosRestClienteApplication implements CommandLineRunner {
	
	Scanner sc = new Scanner(System.in);
	
	@Autowired
	private ServicioProxyVideojuego spv;
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Cliente => Cargando el contexto de Spring");
		SpringApplication.run(ServiciosRestClienteApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Cliente => Contexto de Spring cargado");
		
		//Inicialización de variables
		int opcion;
		Videojuego vAux;
		List <Videojuego>listaVideojuegos = null;
		int idAux;
		
		do {
			opcion = menu();
			
			switch(opcion) {
			
			case 1:
				vAux = new Videojuego();
				
				System.out.println("Añade el ID: ");
				vAux.setId(sc.nextInt());
				sc.nextLine();
				
				System.out.println("Añade el nombre");
				vAux.setNombre(sc.nextLine());				
				
				System.out.println("Añade la compañia");
				vAux.setCompañia(sc.nextLine());
				
				System.out.println("Añade la nota");
				vAux.setNota(sc.nextDouble());
				
				spv.añadirVideojuego(vAux);
				break;
				
			case 2:
				System.out.println("Escribe el ID del videojuego a borrar: ");
				idAux = sc.nextInt();
				
				spv.borrarVideojuego(idAux);
				break;
				
			case 3:
				vAux = new Videojuego();
				
				System.out.println("Escribe el ID del videojuego a modificar: ");
				vAux.setId(sc.nextInt());
				sc.nextLine();
				
				System.out.println("Escribe el nombre a modificar: ");
				vAux.setNombre(sc.nextLine());				
				
				System.out.println("Escribe la compañia a modificar: ");
				vAux.setCompañia(sc.nextLine());
				
				System.out.println("Escribe la nota a modificar: ");
				vAux.setNota(sc.nextDouble());
				
				spv.actualizarVideojuego(vAux);
				break;
				
			case 4:
				System.out.println("Escribe el ID del videojuego a buscar: ");
				idAux = sc.nextInt();
				vAux = spv.buscarVideojuego(idAux);
				System.out.println(vAux);
				break;
				
			case 5:
				listaVideojuegos = spv.listarVideojuego();
				
				for(Videojuego v : listaVideojuegos)
				System.out.println(v);
				break;
			
			case 6:
				salir();
				break;
				
			default:
				System.out.println("Elige una opción correcta por favor");
				break;
			}
		}while(opcion != 6);
		
	}
	
	public int menu() {
		
		System.out.println("\n --------- VIDEOCLUB PIJ ---------- \n");
		System.out.println("1. Dar de alta un videojuego");
		System.out.println("2. Dar de baja un videojuego por ID");
		System.out.println("3. Modificar un videojuego por ID");
		System.out.println("4. Obtener un videojuego por ID");
		System.out.println("5. Listar todos los videojuegos");
		System.out.println("6. Salir de la aplicación");
		int option = sc.nextInt();
		System.out.println("Has elegido la opción: " + option);
		return option;
	}
	
	public void salir() {
		 SpringApplication.exit(context, () ->0);
		 System.out.println("El Cliente ha cerrado la conexión");
	}
	

}
