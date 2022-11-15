package serviciorest.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.modelo.entidad.Videojuego;
import serviciorest.modelo.persistencia.DaoVideojuego;


@RestController
public class ControladorVideojuegos {

	@Autowired
	private DaoVideojuego daoVideojuego;
	
	/*La URL para acceder a este metodo sería: 
	"http://localhost:8080/Videojuegos" y el metodo a usar seria POST
	Pasandole el videojuego sin el ID dentro del body del HTTP request
	
	Dar de alta un videojuego.
	*/
	
	@PostMapping(path = "videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> agregarVideojuego(@RequestBody Videojuego v){
		System.out.println("Dando de alta videojuego: " + v);
		daoVideojuego.añadirVideojuego(v);
		return new ResponseEntity<Videojuego>(v, HttpStatus.CREATED); //201 videojuego creado
	}
	
	@DeleteMapping(path = "videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable("id") int id){
		System.out.println("Borrando videojuego con id : " + id);
		Videojuego v = daoVideojuego.borrarVideojuego(id);
		if(v != null)
			return new ResponseEntity<Videojuego>(HttpStatus.OK); //200 videojuego borrado
		else
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND); //404 videojuego no encontrado		
	}
	
	
	//MODIFICAR VIDEOJUEGO POR ID
	@PutMapping(path = "videojuegos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(@PathVariable("id") int id, @RequestBody Videojuego v){
		System.out.println("Modificando videojuego por ID : " + id);
		System.out.println("Modificando videojuego : " + v);
		//v.setId(id);
		Videojuego vid = daoVideojuego.actualizar(v);
		if(vid != null)
			return new ResponseEntity<Videojuego>(HttpStatus.OK); //200 videojuego modificado
		else
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND); //404 videojuego no encontrado		
	}
	
	
	//Buscar videojuego por ID
	@GetMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Videojuego>> obtenerVideojuego(@PathVariable("id")int id){
		System.out.println("Buscando videojuego con el id:" +id);
		List <Videojuego> v = daoVideojuego.buscarVideojuego(id);
		if(v != null) {
			return new ResponseEntity <List<Videojuego>> (v,HttpStatus.OK);//200 OK
		}
		else {
			
			return new ResponseEntity <List<Videojuego>> (HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	// Listar Videojuego
	@GetMapping(path="videojuegos/lista",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarVideojuegos(){
		System.out.println("Listando todos los videojuegos");
		List <Videojuego> v = daoVideojuego.listarVideojuegos();
		return new ResponseEntity <List<Videojuego>> (v,HttpStatus.OK);
	}

}
