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
	
	//AÑADIR (REVISAR HTTPSTATUS)
	@PostMapping(path = "videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> agregarVideojuego(@RequestBody Videojuego v){
		System.out.println("Agregar => Intentando dar de alta el videojuego: " + v);
		//List<Videojuego> listAux = daoVideojuego.listarVideojuegos();
		daoVideojuego.añadirVideojuego(v);		
		//if (listAux.contains(v))
		if (v == null)
			return new ResponseEntity<Videojuego>(HttpStatus.I_AM_A_TEAPOT); //418 soy una tetera			
		else
			return new ResponseEntity<Videojuego>(v, HttpStatus.CREATED); //201 videojuego creado
	}
	
	//BORRAR
	@DeleteMapping(path = "videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable("id") int id){
		System.out.println("Borrar => Borrando videojuego con id : " + id);
		Videojuego v = daoVideojuego.borrarVideojuego(id);
		if(v != null)
			return new ResponseEntity<Videojuego>(HttpStatus.OK); //200 videojuego borrado
		else
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND); //404 videojuego no encontrado		
	}
	
	
	//MODIFICAR
	@PutMapping(path = "videojuegos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(@PathVariable("id") int id, @RequestBody Videojuego v){
		System.out.println("Modificar => Modificando videojuego por ID : " + id);
		System.out.println("Modificar => Modificando videojuego : " + v);
		//v.setId(id);
		Videojuego vid = daoVideojuego.actualizar(v);
		if(vid != null)
			return new ResponseEntity<Videojuego>(HttpStatus.OK); //200 videojuego modificado
		else
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND); //404 videojuego no encontrado		
	}
	
	
	//BUSCAR
	@GetMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Videojuego>> obtenerVideojuego(@PathVariable("id")int id){
		System.out.println("Obtener => Buscando videojuego con el id:" +id);
		List <Videojuego> v = daoVideojuego.buscarVideojuego(id);
		if(v != null) {
			return new ResponseEntity <List<Videojuego>> (v,HttpStatus.OK);//200 OK
		}
		else {
			
			return new ResponseEntity <List<Videojuego>> (HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	//LISTAR
	@GetMapping(path="videojuegos/lista",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarVideojuegos(){
		System.out.println("Listar => Listando todos los videojuegos");
		List <Videojuego> v = daoVideojuego.listarVideojuegos();
		return new ResponseEntity <List<Videojuego>> (v,HttpStatus.OK);
	}

}
