/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Rol;
import entity.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class UsuariosDAO {
    private PreparedStatement psSelectAll;
    private PreparedStatement psSelect;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    
    private DataBase db;

    public UsuariosDAO() {
    	if (App.DB != null) {
    		this.db = App.DB;
    	} else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
		}
    }
    
    public ArrayList<Usuarios> getAll() throws SQLException {
		ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
		try {
			if (psSelectAll == null) {
				psSelectAll = db.PreparedQuery(
					"SELECT ID_USUARIO,CONTRASEÑA,ID_ROL" +
                                        "FROM USUARIOS"
				);
            }
            ResultSet result = db.ExecuteQuery(psSelectAll);
			while(result.next()) {
				Usuarios usuarios = new Usuarios();
				usuarios.setIdUsuario(result.getInt("ID_USUARIO"));
				usuarios.setContraseña(result.getString("CONTRASEÑA"));
                                
                        
		}
		} catch (SQLException e) {
			throw new RuntimeException("Error al ejecutar consulta.", e);
		}
		return listaUsuarios;
	}

     public Usuarios get(int idUsuario) {
    	Usuarios usuarios = new Usuarios();		
		ResultSet result = null;
		try {
			if (psSelect == null) {
				psSelect = db.PreparedQuery(
				"SELECT ID_USUARIO, CONTRASEÑA, ID_ROL FROM USUARIOS WHERE ID_USUARIO=?"					
				);
			}	
			ArrayList<Object> inputs = new ArrayList<Object>();
			inputs.add(idUsuario);
            result = db.ExecuteQuery(psSelect,inputs);
			while(result.next()){
				usuarios.setIdUsuario(result.getInt("ID_USUARIO"));
				usuarios.setContraseña(result.getString("CONTRASEÑA"));
                                Rol rol = App.RolDAO.get(result.getInt("ID_ROL"));
                                usuarios.setIdRol(rol);
                                                               										
			}			
		}catch (SQLException e) {
			throw new RuntimeException("Error al ejecutar consulta.", e);
		}  	
		return usuarios;
	}
}
