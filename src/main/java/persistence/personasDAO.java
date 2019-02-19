/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.Personas;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class personasDAO {
    private PreparedStatement psSelectAll;
    private PreparedStatement psSelect;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    
    private DataBase db;
    
    public personasDAO() {
    	if (App.DB != null) {
    		this.db = App.DB;
    	} else {
		throw new RuntimeException("Error: No se ha inicializado la conexión.");
		}
    }
    
    public ArrayList<Personas> getAll() {
		ArrayList<Personas> listaPersonas = new ArrayList<Personas>();
		try {
			if (psSelectAll == null) {
				psSelectAll = db.PreparedQuery(
					"SELECT id, nombre, apellido FROM Personas"
				);
			}	
			ResultSet result = db.ExecuteQuery(psSelectAll);
			while(result.next()) {
				Personas personas = new Personas();
				personas.setId(result.getInt("id"));
				personas.setNombre(result.getString("nombre"));
				personas.setApellido(result.getString("apellido"));
                                
				listaPersonas.add(personas);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al ejecutar consulta.", e);
		}    	
		return listaPersonas;	
	}
    public static void main(String[] args) throws IOException {
		
		try {
			App.OpenConnection();	
			
			
			System.out.println("GET ALL");	
			ArrayList<Personas> listaPersonas = App.personasDAO.getAll();
			for (Personas personas : listaPersonas) {
			System.out.println(personas.getId() +" "+ personas.getNombre() +" "+personas.getApellido());
                        }
                        } catch (Exception e) {
			throw new RuntimeException("Se ha generado un error inesperado", e);
		} finally {
			App.CloseConnection();
		}
	}
    
}
