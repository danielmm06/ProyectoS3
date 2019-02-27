/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Ciudad;
import entity.Departamento;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class CiudadDAO {
    
    private PreparedStatement psSelectAll;
    private PreparedStatement psSelect;
    private PreparedStatement psSelectByNombre;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    
    private DataBase db;
    
    public CiudadDAO() {
    	if (App.DB != null) {
            this.db = App.DB;
    	} else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
            }
        }
    
    public ArrayList<Ciudad> getAll() {
		ArrayList<Ciudad> listaCiudad = new ArrayList<Ciudad>();
		try {
                    if (psSelectAll == null) {
                            psSelectAll = db.PreparedQuery(
                            "SELECT ID_CIUDAD,NOMBRE_CIUDAD,ID_DPTO " +
                            "FROM CIUDAD"
                            );
            }
            ResultSet result = db.ExecuteQuery(psSelectAll);
            while(result.next()) {
                    Ciudad ciudad = new Ciudad();
                    ciudad.setIdCiudad(result.getInt("ID_CIUDAD"));
                    ciudad.setNombreCiudad(result.getString("NOMBRE_CIUDAD"));
                    Departamento departamento = new Departamento();
                    departamento.setIdDpto(result.getInt("ID_DPTO"));
                    ciudad.setIdDpto(departamento);
                    
                    listaCiudad.add(ciudad);
            }
            } catch (SQLException e) {
                    throw new RuntimeException("Error al ejecutar consulta.", e);
            } 
            return listaCiudad;
	}
    
    public Ciudad get(int idCiudad) {
        Ciudad ciudad = new Ciudad();
        ResultSet result = null;
        try {
            if (psSelect == null) {
                    psSelect = db.PreparedQuery(
                    "SELECT ID_CIUDAD,NOMBRE_CIUDAD,ID_DPTO " +
                    "FROM CIUDAD " +
                    "WHERE ID_CIUDAD=?"
                    );
        }
        ArrayList<Object> inputs = new ArrayList<Object>();
        inputs.add(idCiudad);
        result = db.ExecuteQuery(psSelect,inputs);
        while(result.next()) {
            ciudad.setIdCiudad(result.getInt("ID_CIUDAD"));
            ciudad.setNombreCiudad(result.getString("NOMBRE_CIUDAD"));
            Departamento departamento = new Departamento();
            departamento.setIdDpto(result.getInt("ID_DPTO"));
            ciudad.setIdDpto(departamento);
            
            }
        } catch (SQLException e) {
                throw new RuntimeException("Error al ejecutar consulta.", e);
        } 
        return ciudad;
    }
    
    public long insert(Ciudad ciudad) {
        long result;
        try {
            String columns = "NOMBRE_CIUDAD,ID_DPTO";
            String values = "?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                    "INSERT INTO CIUDAD("+columns+") VALUES("+values+")",
                    "ID_CIUDAD"
                    );
                }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(ciudad.getNombreCiudad());
            inputs.add(ciudad.getIdDpto().getIdDpto());	
            result = db.ExecuteUpdate(psInsert,inputs);
            } catch (SQLException e) {
                    throw new RuntimeException("Error al ejecutar inserción.", e);
            } 
            return result;
	}
	 
	public long update(Ciudad ciudad) {
            long result;
            try {
                String columns = "";
                ArrayList<Object> inputs = new ArrayList<Object>();
                
                if (ciudad.getNombreCiudad() != null) {
                        columns += ",NOMBRE_CIUDAD=?";
                        inputs.add(ciudad.getNombreCiudad());
                }
                if (ciudad.getIdDpto() != null) {
                        columns += ",ID_DPTO=?";
                        inputs.add(ciudad.getIdDpto().getIdDpto());
                }

                inputs.add(ciudad.getIdCiudad());
                columns = columns.substring(1);
                        psUpdate = db.PreparedUpdate(
                            "UPDATE CIUDAD SET "+columns+" WHERE ID_CIUDAD=? "
                        );
                        
            result = db.ExecuteUpdate(psUpdate,inputs);
            } catch (SQLException e) {
                    throw new RuntimeException("Error al ejecutar actualización.", e);
            } 
            return result;
	}
	
	
	public long delete(int idCiudad) {
            long result;
                try {
                    if (psDelete == null) {
                            psDelete = db.PreparedUpdate(
                            "DELETE FROM CIUDAD " +
                            "WHERE ID_CIUDAD=?"
                            );
                }
                ArrayList<Object> inputs = new ArrayList<Object>();
                inputs.add(idCiudad);
                result = db.ExecuteUpdate(psDelete,inputs);
                } catch (SQLException e) {
                        throw new RuntimeException("Error al ejecutar borrado.", e);
                } 
            return result;
	}	
    
    public static void main(String[] args) throws IOException {
        try {
            App.OpenConnection();

//            System.out.println("GET ALL");
//            ArrayList<Ciudad> listaCiudad = App.CiudadDAO.getAll();
//            for (Ciudad ciudad : listaCiudad) {
//                System.out.println(ciudad.getIdCiudad() + " " + ciudad.getNombreCiudad() + " " + ciudad.getIdDpto().getIdDpto());
//            }
            
//            System.out.println("GET ONE");
//            int idCiudad = 34;			
//            Ciudad ciudad = App.CiudadDAO.get(idCiudad);
//            if(ciudad.getIdCiudad() != 0) {						
//                System.out.println(ciudad.getIdCiudad()+" "+ciudad.getNombreCiudad()+" "+ciudad.getIdDpto().getIdDpto());
//            }
             
//            System.out.println("INSERT");				
//            Ciudad ciudad = new Ciudad();
//            ciudad.setNombreCiudad("Andrea");
//            Departamento departamento = new DepartamentoDAO().get(1);
//            ciudad.setIdDpto(departamento);
//            App.CiudadDAO.insert(ciudad);
         
//            System.out.println("UPDATE");
//            Ciudad ciudad = new Ciudad();
//            ciudad.setIdCiudad(1365);
//            ciudad.setNombreCiudad("Daniel");
//            System.out.println(App.CiudadDAO.update(ciudad));

//            System.out.println("DELETE");
//            App.CiudadDAO.delete(1365);
//            System.out.println(App.CiudadDAO.delete(1365));
         
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
