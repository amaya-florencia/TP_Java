package negocio;


import java.util.ArrayList;
import java.util.Random;
import entidades.*;
import java.io.InvalidClassException;
import util.ApplicationException;
import data.DataPersonaje;

public class CtrlPartida {
	
	
	private Personaje personaje1,personaje2;
	private DataPersonaje dataPer;
	private int turno;
	private int vidaOriginal1;
	private int vidaOriginal2;
	private int energiaOriginal1;
	private int energiaOriginal2;

	public int getVidaOriginal1() {
		return vidaOriginal1;
	}
	public void setVidaOriginal1(int vidaOriginal1) {
		this.vidaOriginal1 = vidaOriginal1;
	}
	public int getVidaOriginal2() {
		return vidaOriginal2;
	}
	public void setVidaOriginal2(int vidaOriginal2) {
		this.vidaOriginal2 = vidaOriginal2;
	}
	public int getEnergiaOriginal1() {
		return energiaOriginal1;
	}
	public void setEnergiaOriginal1(int energiaOriginal1) {
		this.energiaOriginal1 = energiaOriginal1;
	}
	public int getEnergiaOriginal2() {
		return energiaOriginal2;
	}
	public void setEnergiaOriginal2(int energiaOriginal2) {
		this.energiaOriginal2 = energiaOriginal2;
	}
	public Personaje getPersonaje1() {
		return personaje1;
	}
	public void setPersonaje1(Personaje personaje1) {
		this.personaje1 = personaje1;
	}
	public Personaje getPersonaje2() {
		return personaje2;
	}
	public void setPersonaje2(Personaje personaje2) {
		this.personaje2 = personaje2;
	}
	public CtrlPartida(){
		
		dataPer = new DataPersonaje();
		turno = 0;
		personaje1 = null;
		personaje2 = null;
		
	}
	public CtrlPartida(Personaje per1,Personaje per2){
		personaje1 = per1;
		personaje2=per2;
		this.setVidaOriginal1(personaje1.getVida());
		this.setVidaOriginal2(personaje2.getVida());
		this.setEnergiaOriginal1(personaje1.getVida());
		this.setEnergiaOriginal2(personaje2.getVida());		
	}
	public void defensa(Personaje personajeActual) throws ApplicationException{
		
			if(personajeActual.getIdPersonaje()==personaje1.getIdPersonaje()){
				personajeActual.setEnergia(this.getEnergiaOriginal1()*personajeActual.getDefensa()/100);
				personajeActual.setVida(this.getVidaOriginal1()*personajeActual.getDefensa()/250);
				this.setPersonaje1(personajeActual);
			}else{
				int i = this.getEnergiaOriginal2();
				int j = personajeActual.getDefensa();
				personajeActual.setEnergia(i *j /100);
				personajeActual.setVida(this.getVidaOriginal2()*personajeActual.getDefensa()/250);
				this.setPersonaje2(personajeActual);
			}
				
			throw new ApplicationException(personajeActual.getNombrePersonaje()+" recupera " + personajeActual.getEnergia() + " de energia y " 
							+ personajeActual.getVida() + " de vida.");
	
		
	}
	public void ataque(int energiaAtaque,Personaje atacante, Personaje defensor) throws ApplicationException{
		
		
			atacante.setEnergia(atacante.getEnergia() - energiaAtaque);	
			boolean evade =this.defensorEvade(energiaAtaque,defensor);
			if(!evade){
				
				int vidaRestante = defensor.getVida() - energiaAtaque;
				if (vidaRestante>0){					
					defensor.setVida(vidaRestante);						
					throw new ApplicationException("El ataque es efectivo!!"+ 
								defensor.getNombrePersonaje()+"pierde "+energiaAtaque + "puntos de vida");
	
				}else{						
						throw new ApplicationException("Felicitaciones! Has derrotado a "+defensor.getNombrePersonaje());						
				}
				}else{
				throw new ApplicationException("Tu ataque ha sido evadido!"+ defensor.getNombrePersonaje()+"conserva sus puntos de vida ");
			}
		}	
	
	public boolean defensorEvade(int energiaAtaque,Personaje defensor){
		boolean evade = false;
		Random rnd = new Random();
		Double i = rnd.nextDouble();
		if (i*100 > defensor.getEvasion()){//evade ataque
			defensor.setVida(defensor.getVida()-energiaAtaque);
			evade = true;
		}
		return evade;
	}
}
