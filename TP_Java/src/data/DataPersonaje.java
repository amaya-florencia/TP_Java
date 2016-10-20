package data;
import java.sql.*;
import java.util.ArrayList;

import entidades.*;
import util.ApplicationException;

public class DataPersonaje {
	public DataPersonaje(){		
	}
	public ResultSet getResultSet() throws ApplicationException{

		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT idPersonaje, nombre, evasion, defensa, vida, energia, puntosTotales " +
					"FROM personajes"
				   );			
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			throw e;
		}
		finally
		{
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				throw e;
			}
		}		
		return rs;
		
	}
	@SuppressWarnings("null")
	public ArrayList<Personaje> getAll() throws ApplicationException{
		ArrayList<Personaje> personajes = null;		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("SELECT idPersonaje,nombrePersonaje,vida,"
					+ "energia,defensa,evasion,puntos_totales FROM personajes");
					
			rs = stmt.executeQuery();
			if(rs != null && rs.next())
			{
				Personaje p = new Personaje();
				p.setIdPersonaje(rs.getInt("idPersonaje"));
				p.setNombrePersonaje(rs.getString("nombrePersonaje"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setEvasion(rs.getInt("evasion"));			
				p.setPuntosTotales(rs.getInt("puntos_totales"));
				
				personajes.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			throw e;
		}
		finally
		{
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				throw e;
			}
		}		
		return personajes;
	
	}
	public Personaje getPersonajeNombre(String nombreIngresado){
			
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Personaje perEncontrado = null;
		
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("SELECT idPersonaje,nombrePersonaje,vida,"
					+ "energia,defensa,evasion,puntos_totales FROM personajes WHERE nombrePersonaje = ?");
			stmt.setString(1, nombreIngresado);			
			rs = stmt.executeQuery();
			if(rs != null && rs.next())
			{
				perEncontrado = new Personaje();
				perEncontrado.setIdPersonaje(rs.getInt("idPersonaje"));
				perEncontrado.setNombrePersonaje(rs.getString("nombrePersonaje"));
				perEncontrado.setVida(rs.getInt("vida"));
				perEncontrado.setEnergia(rs.getInt("energia"));
				perEncontrado.setDefensa(rs.getInt("defensa"));
				perEncontrado.setEvasion(rs.getInt("evasion"));			
				perEncontrado.setPuntosTotales(rs.getInt("puntos_totales"));				
			}
		}catch (SQLException e) {			
			e.printStackTrace();
		} catch (ApplicationException e) {			
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {				
				e.printStackTrace();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}	
		
		return perEncontrado;
		
		
	}
	
	
	public void add(Personaje p){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into personajes(nombrePersonaje,vida,energia,defensa,evasion,puntos_totales)"+
					" values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			// PreparedStatement.RETURN_GENERATED_KEYS to be able to retrieve id generated on the db
			// by the autoincrement column. Otherwise don't use it
						
			stmt.setString(1, p.getNombrePersonaje());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntosTotales());			
			
			stmt.execute();			
			//after executing the insert use the following lines to retrieve the id
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setIdPersonaje(rs.getInt(1));		
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (ApplicationException e) {			
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {				
				e.printStackTrace();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
	public void update(Personaje p){
		ResultSet rs=null;
		PreparedStatement stmt=null;	
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE personajes SET nombrePersonaje=?,vida=?,energia=?,defensa=?,evasion=?,puntos_totales=?"+
					" WHERE idPersonaje=?");	
			
			stmt.setInt(1, p.getIdPersonaje());
			stmt.setString(2, p.getNombrePersonaje());
			stmt.setInt(3, p.getVida());
			stmt.setInt(4, p.getEnergia());
			stmt.setInt(5, p.getDefensa());
			stmt.setInt(6, p.getEvasion());
			stmt.setInt(7, p.getPuntosTotales());
			
			
			stmt.execute();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (ApplicationException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {				
				e.printStackTrace();
			} catch (ApplicationException e) {				
				e.printStackTrace();
			}
		}
	}
	public void delete(Personaje p){
		PreparedStatement stmt=null;		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from personajes where idPersonaje=?");
			stmt.setInt(1, p.getIdPersonaje());
			stmt.execute();
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (ApplicationException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {				
				e.printStackTrace();
			} catch (ApplicationException e) {				
				e.printStackTrace();
			}
		}		
	}
	
	
}
