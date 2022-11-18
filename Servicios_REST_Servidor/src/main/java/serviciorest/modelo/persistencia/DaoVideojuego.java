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
	
	//AÑADIR
	public Videojuego añadirVideojuego(Videojuego v){
		
	    int cont = 0;
	    
	    if(listaVideojuegos.contains(v)) {
	    	System.out.println("Añadir => Videojuego en lista");
	        return null;
	    
	    }else {
	    	
	        listaVideojuegos.add(v);
	        cont = listaVideojuegos.size() -1;
	        System.out.println("Añadido el videojuego => " + listaVideojuegos.get(cont) + " a la lista");
	        return listaVideojuegos.get(cont);
	    }
	}
	
	//BORRAR
	public Videojuego borrarVideojuego(int id) {
        										
		try {
			for(Videojuego v : listaVideojuegos) {	
				if(v.getId() == id){
					int vAux = listaVideojuegos.indexOf(v);
					System.out.println(vAux);
					System.out.println("Borrar => Videojuego " + v + "");
					return listaVideojuegos.remove(vAux);
				}		
			}
		
		}catch (UnsupportedOperationException e) {
			System.out.println("Borrar => El videojuego no se encuentra en la lista ");
			return null ;
		}		
		return null;	
	}	
	
	//ACTUALIZAR
	public Videojuego actualizar(Videojuego v) {
		
		try {
			for(Videojuego vid : listaVideojuegos) {
				if(vid.getId() == v.getId()) {
					int vAux = listaVideojuegos.indexOf(vid);
					Videojuego vix = listaVideojuegos.get(vAux);
					vix.setNombre(v.getNombre());
					vix.setCompañia(v.getCompañia());
					vix.setNota(v.getNota());
					return vix;
				}
				
			}
			
		}catch(IndexOutOfBoundsException e) {
			System.out.println(" Actualizar => El videojuego no está en la lista");		
			return null;
		}
		return null;
	}
	
	//BUSCAR
	public Videojuego buscarVideojuego(int id) {
			for(Videojuego v : listaVideojuegos) {
				if(v.getId() == id){
					return v;
				}
			}
			return null;		
	}		
	
	//LISTAR
	public List<Videojuego> listarVideojuegos(){
	    return listaVideojuegos;
	}

}
