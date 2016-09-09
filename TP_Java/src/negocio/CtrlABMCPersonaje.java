package negocio;

import java.util.ArrayList;
import entidades.*;
import java.io.InvalidClassException;
import util.ApplicationException;

public class CtrlABMCPersonaje {

	private ArrayList<Personaje> personajes;
		
	public CtrlABMCPersonaje(){
		personajes = new ArrayList<Personaje>();
	}
	public void agregar(Personaje p) throws ApplicationException {
		if(!personajes.contains(p)){
			personajes.add(p);
		} else {
			throw new ApplicationException("El personaje ya existe");
		}
	}
	
	public void modificar(Personaje p) throws ApplicationException{
		if(personajes.contains(p)){
			Personaje perEnc = this.getPersonaje(p);
			perEnc.setNombrePersonaje(p.getNombrePersonaje());
			perEnc.setVida(p.getVida());
			perEnc.setEnergia(p.getEnergia());
			perEnc.setDefensa(p.getDefensa());
			perEnc.setEvasion(p.getEvasion());
			
		}else{
			throw new ApplicationException("El personaje no existe");
		}		
	}	
	
	public void eliminar(Personaje p){
		personajes.remove(p);
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
