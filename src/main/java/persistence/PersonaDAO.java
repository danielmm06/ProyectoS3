/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PersonaDAO {
    private PreparedStatement psSelectAll;
    private PreparedStatement psSelect;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    
    private DataBase db;

    public PersonaDAO() {
    	if (App.DB != null) {
    		this.db = App.DB;
    	} else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
		}
    }
    
    public ArrayList<Persona> getAll() {
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();		
		try {
			
			if (psSelectAll == null) {
				psSelectAll = db.PreparedQuery(
		        		"SELECT ID_PERSONA, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, DOCUMENTO, TIPODOCUMENTO, "
                                                + "EXP_PAIS, EXP_DPTO, EXP_CIUDAD, DIRECCION, BARRIO, RES_PAIS, RES_DPTO, RES_CIUDAD, "
                                                + "TELEFONO, EMAIL, DIRECCION_OFIC, OFIC_PAIS, OFIC_DPTO, OFIC_CIUDAD, TELEFONO_OFIC, "
                                                + "FECHA_NACIMIENTO, PAIS_NACIMIENTO, DPTO_NACIMIENTO, CIUDAD_NACIMIENTO, ESTADO_CIVIL, "
                                                + "ESTRATO, INFO_PREGUNTAS FROM persona"
				);
            }                        
            ResultSet result = db.ExecuteQuery(psSelectAll);
			while(result.next()) {
				Persona persona = new Persona();
				persona.setNombre1(result.getString("NOMBRE1"));
                                persona.setNombre2(result.getString("NOMBRE2"));
                                persona.setApellido1(result.getString("APELLIDO1"));
                                persona.setApellido2(result.getString("APELLIDO2"));
                               
                                
                                
				listaPersonas.add(persona);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al ejecutar consulta.", e);
		}
		return listaPersonas;
	}
    
}
