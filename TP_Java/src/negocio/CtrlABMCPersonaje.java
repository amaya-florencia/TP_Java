package negocio;

import java.util.ArrayList;
import entidades.*;
import java.sql.ResultSet;

import util.ApplicationException;
import data.DataPersonaje;

public class CtrlABMCPersonaje {

	private ArrayList<Personaje> personajes;
	private DataPersonaje dataPer;
	private Personaje per;
	private int puntosIniciales = 200;
	String [] nombres = null;
	
	public CtrlABMCPersonaje(){
		personajes = new ArrayList<Personaje>();
		dataPer=new DataPersonaje();
	}

	public ResultSet getResultSet() throws ApplicationException{
		return dataPer.getResultSet();
	}
	
	public void agregar(Personaje p) throws ApplicationException {	
		if(validarNombre(p)){
			p.setPuntosTotales(puntosIniciales);
			int puntosAsignados = p.getDefensa()+p.getEnergia()+p.getEvasion()+p.getVida();
			if(p.getPuntosTotales()>=puntosAsignados){
				personajes.add(p);
			}else {
				throw new ApplicationException("La suma de los puntos asignados no debe ser mayor a "+ p.getPuntosTotales());
			}
		} else {
			throw new ApplicationException("El personaje ya existe");
		}
		dataPer.add(p);
	}
	
	private boolean validarNombre(Personaje p) {
		boolean valida = true;
		Personaje encontrado = dataPer.getPersonajeNombre(p.getNombrePersonaje());	
		if (!(encontrado==null)){
			valida=true;
		}else{
			valida=false;
		}
		return valida;
	}
	
	private boolean validarNombre(String nombre) {
		boolean valida = true;
		Personaje encontrado = dataPer.getPersonajeNombre(nombre);	
		if (!(encontrado==null)){
			valida=true;
		}else{
			valida=false;
		}
		return valida;
	}

	public void update(Personaje p) throws ApplicationException{
			dataPer.update(p);	
	}	
	
	public void eliminar(Personaje p){
		dataPer.delete(p);		
	}
	
	public Personaje buscarPersonajePorNombre(String nombreIngresado)throws ApplicationException{
		if (this.validarNombre(nombreIngresado))	{
			Personaje per = dataPer.getPersonajeNombre(nombreIngresado);
		}else{
			throw new ApplicationException("El personaje no existe");
		}
		return per;
	}

	public ArrayList<Personaje> getAll() throws ApplicationException {		
		return dataPer.getAll();
	}

	
}
