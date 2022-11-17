package serviciorest.cliente.servicio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import serviciorest.cliente.entidad.Videojuego;

@Service
public class ServicioProxyVideojuego {
	public static final String URL = "http://localhost:8080/videojuegos/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	//AÑADIR
	public Videojuego añadirVideojuego(Videojuego v) {
		try {
			ResponseEntity <Videojuego> re = restTemplate.postForEntity(URL, v, Videojuego.class);
			System.out.println("Alta Videojuego => Código de respuesta " + re.getStatusCode());
			return re.getBody();
		}catch (HttpClientErrorException e) {
			System.out.println("Alta Videojuego => El videojuego no se puede dar de alta");
			System.out.println(e.getStatusCode());
			return null;
		}
		
	}
	
	//BORRAR
	public boolean borrarVideojuego(int id) {
		try {
			restTemplate.delete(URL + id);
			return true;
		}catch (HttpClientErrorException e) {
			System.out.println("Borrar Videojuego => El videojuego no se ha podido borrar: " +id);
			System.out.println(e.getStatusCode());
			return false;
		}
	}
	
	//ACTUALIZAR
	public boolean actualizarVideojuego(Videojuego v) {
		try {
			restTemplate.put(URL + v.getId(),v,Videojuego.class);
			return true;
		}catch (HttpClientErrorException e) {
			System.out.println("Actualizar Videojuego => El videojuego no se ha podido actualizar: " +v.getId());
			System.out.println(e.getStatusCode());
			return false;
		}
	}
	
	//BUSCAR
	public Videojuego buscarVideojuego(int id) {
		try {
			ResponseEntity <Videojuego> re = restTemplate.getForEntity(URL + id, Videojuego.class);
			System.out.println("Buscar Videojuego => Código de respuesta " + re.getStatusCode());
			return re.getBody();
		}catch (HttpClientErrorException e) {
			System.out.println("Buscar Videojuego => El videojuego no se ha encontrado: " + id) ;
			System.out.println(e.getStatusCode());
			return null;
			
		}
	}
	
	//LISTAR
	public List<Videojuego> listarVideojuego(){
		try {
			ResponseEntity <Videojuego[]> re = restTemplate.getForEntity(URL + "lista", Videojuego[].class);
			Videojuego[] listAux = re.getBody();
			return Arrays.asList(listAux);
		}catch (HttpClientErrorException e) {
			System.out.println("Listar Videojuegos => Error al listar los videojuegos");
			System.out.println(e.getStatusCode());
			return null;
		}
		
	}
	
	
}
