package serviciorest.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import serviciorest.modelo.entidad.Videojuego;

@Component
public class DaoVideojuego {
private List<Videojuego> listaVideojuegos;
	
	
	
	public DaoVideojuego () {
		super();
		System.out.println("DaoVideojuejo -> Cargando lista de videojuegos...");
		
		listaVideojuegos = new ArrayList<Videojuego>();
		
		Videojuego v1 = new Videojuego(657, "Tetris", "Spectrum Holobyte", 9.0);
		Videojuego v2 = new Videojuego(852, "DOOM 64", "Bethesda", 9.8);
		Videojuego v3 = new Videojuego(951, "The Legend Of Zelda: The Ocarina of Time", "Nintendo", 9.3);
		Videojuego v4 = new Videojuego(753, "The Last Of Us", "Naughty Dog", 8.9);
		Videojuego v5 = new Videojuego(654, "Arkanoid", "Taito Corporation", 6.4);
		
		listaVideojuegos.add(v1);
		listaVideojuegos.add(v2);
		listaVideojuegos.add(v3);
		listaVideojuegos.add(v4);
		listaVideojuegos.add(v5);
	}
	
	
	
public void añadirVideojuego(Videojuego v){
	
	try {
	for(Videojuego vid : listaVideojuegos) {
		if(v.getId() != vid.getId() || v.getNombre() != vid.getNombre()) {
			listaVideojuegos.add(v);
			System.out.println("Añadido el videojuego => " + v + " a la lista");
		}else {
			System.out.println("DaoVideojuego Añadir => El videojuego ya está en la lista");
		}
	}
	}catch(Exception eo) { //REVISAR ESTE CATCH para poner la excepción que corresponda
		
	}	
}

public Videojuego borrarVideojuego(int id) { //REVISAR PARA QUE DEVUELVA ALGO CUANDO BORRE
											//REVISAR CON BOOLEANO
	
	for(Videojuego v : listaVideojuegos) {
		if(v.getId() == id){
			listaVideojuegos.remove(id);
			System.out.println("Borrar => Videojuego " + v + "");
		}
	}
	return null;			
}		
		
public Videojuego actualizar(Videojuego v) {
	
	try {
		Videojuego vid = listaVideojuegos.get(v.getId());
		vid.setNombre(v.getNombre());
		vid.setCompañia(v.getCompañia());
		vid.setNota(v.getNota());
		return vid;
			
	}catch(IndexOutOfBoundsException e) {
		System.out.println(" Actualizar => El videojuego no está en la lista");		
		return null;
	}
	
}
	
public List<Videojuego> buscarVideojuego(int id) {
	List<Videojuego> vid = new ArrayList<Videojuego>();
		for(Videojuego v : listaVideojuegos) {
			if(v.getId() == id){
				vid.add(v);
			}
		}
		
		return vid;			
}		

public List<Videojuego> listarVideojuegos(){
    return listaVideojuegos;
}

}
