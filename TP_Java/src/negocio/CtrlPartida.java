package negocio;

import java.util.ArrayList;
import java.util.Random;
import entidades.*;
import java.io.InvalidClassException;
import util.ApplicationException;
import data.DataPersonaje;

public class CtrlPartida {
	
	
	Personaje pAtaque = new Personaje();
	Personaje pDefensa = new Personaje();
	Personaje personaje1 = new Personaje();
	Personaje personaje2 = new Personaje();
	
	public CtrlPartida(){
		
		
	}
	public CtrlPartida(Personaje per1,Personaje per2){
		personaje1 = per1;
		personaje2=per2;
		int vida1=personaje1.getVida();
		int vida2=personaje2.getVida();
		int energia1=personaje1.getEnergia();
		int energia2=personaje2.getEnergia();
		
	}
	public Personaje turno(Personaje personaje1,Personaje personaje2){
		Random rnd = new Random();
		int i= rnd.nextInt();
		int j=rnd.nextInt();
		if(i>j){
			pAtaque = personaje1;			
			pDefensa = personaje2;
		}else{
			  pAtaque = personaje2;
			  pDefensa = personaje1;
		}	
		return pAtaque;
	}
	public Boolean ataque(int energiaAtaque) throws ApplicationException{
		Boolean evade;
		if (pAtaque.getEnergia()>energiaAtaque){
			pAtaque.setEnergia(pAtaque.getEnergia()-energiaAtaque);						
			evade = this.calcularEvasion(energiaAtaque);
			
			validaGanador();
		}else{			
			throw new ApplicationException("La energia de ataque debe ser menor que "+ pAtaque.getEnergia());
		}	
		
		return evade;
	}
	public Boolean validaGanador() throws ApplicationException {
		Boolean gana;
		if (pDefensa.getVida()>0){
			Personaje aux = pAtaque;
			pAtaque= pDefensa;
			pDefensa=aux;
			gana = false;
			//this.ataque(energiaAtaque);
		}else{			
			
			if(pAtaque.getNombrePersonaje()==personaje1.getNombrePersonaje()){
				personaje1.setPuntosTotales(pAtaque.getPuntosTotales()+10);
			}else if (pAtaque.getNombrePersonaje()==personaje2.getNombrePersonaje()){
				personaje2.setPuntosTotales(pAtaque.getPuntosTotales()+10);
			}
			throw new ApplicationException("El ganador es: " + pAtaque.getNombrePersonaje());
			
		}
		return gana;
		
	}
	public Boolean calcularEvasion(int energiaAtaque){
		Boolean evade = false;
		Random rnd = new Random();
		Double i= rnd.nextDouble()*2+0;
		if (i*100< pDefensa.getEvasion()){//evade ataque
			pDefensa.setVida(pDefensa.getVida()-energiaAtaque);
			evade = true;
		}
		return evade;
	}

}
