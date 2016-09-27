package negocio;

import java.util.ArrayList;
import entidades.*;
import java.io.InvalidClassException;
import util.ApplicationException;
import data.DataPersonaje;

public class CtrlABMCPersonaje {

	private ArrayList<Personaje> personajes;
	private data.DataPersonaje dataPer;
	private int puntosIniciales = 200;
	
	public CtrlABMCPersonaje(){
		personajes = new ArrayList<Personaje>();
		dataPer=new DataPersonaje();
	}
	
	public ArrayList<Personaje> getAll()throws ApplicationException{
		
		ArrayList<Personaje> personajes = null;
		
			personajes = dataPer.getAll();
		return personajes;
	}
	
	
	public void agregar(Personaje p) throws ApplicationException {
		
		if(validar(p)){
			p.setPuntosTotales(puntosIniciales);
			personajes.add(p);
		} else {
			throw new ApplicationException("El personaje ya existe");
		}
		dataPer.add(p);
		
		
	}
	
	private boolean validar(Personaje p) {
		boolean valida = true;
		Personaje encontrado = dataPer.getPersonajeNombre(p.getNombrePersonaje());
		if (encontrado==null){
			valida=true;
		}else{
			valida=false;
		}
		return valida;
	}

	public void modificar(Personaje p) throws ApplicationException{
		/*if(personajes.contains(p)){
			Personaje perEnc = this.getPersonaje(p);
			perEnc.setNombrePersonaje(p.getNombrePersonaje());
			perEnc.setVida(p.getVida());
			perEnc.setEnergia(p.getEnergia());
			perEnc.setDefensa(p.getDefensa());
			perEnc.setEvasion(p.getEvasion());
			
		}else{
			throw new ApplicationException("El personaje no existe");
		}		*/
		dataPer.update(p);
		
	}	
	
	public void eliminar(Personaje p){
		//personajes.remove(p);
		dataPer.delete(p);
		
	}
	public Personaje getPersonaje(Personaje p){
		Personaje perEnc=null;
		int i=personajes.indexOf(p);
		if(i>=0){
			perEnc=personajes.get(i);
		}
		return perEnc;
	}
}
