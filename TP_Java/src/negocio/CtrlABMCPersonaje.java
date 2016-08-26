package negocio;

import java.util.ArrayList;
import entidades.*;
import java.io.InvalidClassException;

public class CtrlABMCPersonaje {

	private ArrayList<Personaje> personajes;
	
	
	
	public CtrlABMCPersonaje(){
		personajes = new ArrayList<Personaje>();
	}
	public void agregar(Personaje p) {
		for(int i = 0;i<=personajes.size();i++){
			if(p.getNombrePersonaje()==personajes.get(i).getNombrePersonaje()){
				System.out.println("Ya existe ese nombre, ingrese otro");
			}else{
				personajes.add(p);
			}
		}
	}
	public void modificar(Personaje p){
		if(personajes.contains(p)){
			Personaje perEnc = this.getPersonaje(p);
			perEnc.setNombrePersonaje(p.getNombrePersonaje());
			perEnc.setVida(p.getVida());
			perEnc.setEnergia(p.getEnergia());
			perEnc.setDefensa(p.getDefensa());
			perEnc.setEvasion(p.getEvasion());	
		}else{
			System.out.println("El personaje no existe");
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
