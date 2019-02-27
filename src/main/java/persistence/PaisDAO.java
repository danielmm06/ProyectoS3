/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Pais;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PaisDAO {
    private PreparedStatement psSelect;
    private PreparedStatement psSelectByNombre;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    
    private DataBase db;
    
    public PaisDAO() {
    	if (App.DB != null) {
            this.db = App.DB;
    	} else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
		}
    }
    
    public ArrayList<Pais> getAll() {
        ArrayList<Pais> listaPais = new ArrayList<Pais>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;

        try {
            if (psSelectAll == null) {
                    psSelectAll = db.PreparedQuery(
                    "SELECT ID_PAIS,NOMBRE_PAIS " +
                    "FROM PAIS"
                    );
        }
        result = db.ExecuteQuery(psSelectAll);
        while(result.next()) {
                Pais pais = new Pais();
                pais.setIdPais(result.getInt("ID_PAIS"));
                pais.setNombrePais(result.getString("NOMBRE_PAIS"));
                						
                listaPais.add(pais);
                    }
            } catch (SQLException e) {
                    throw new RuntimeException("Error al ejecutar consulta.", e);
            }finally {
            if (result != null) {
                try {
                        result.close();
                } catch (SQLException e) { throw new RuntimeException("Error al cerrar el resultset", e);}
            }
            if (psSelectAll != null) {
                try {
                        psSelectAll.close();
                } catch (SQLException e) { throw new RuntimeException("Error al cerrar el preparedstatement", e);}
            }
            } 
            return listaPais;

    }
    
    public Pais get(int idPais) {
        Pais pais = new Pais();
        ResultSet result = null;
        try {
            if (psSelect == null) {
                    psSelect = db.PreparedQuery(
                    "SELECT ID_PAIS,NOMBRE_PAIS " +
                    "FROM PAIS " +
                    "WHERE ID_PAIS=?"
                    );
        }
        ArrayList<Object> inputs = new ArrayList<Object>();
        inputs.add(idPais);     
        result = db.ExecuteQuery(psSelect,inputs);
        while(result.next()) {
                pais.setIdPais(result.getInt("ID_PAIS"));
                pais.setNombrePais(result.getString("NOMBRE_PAIS"));
                				
                    }
            } catch (SQLException e) {
                    throw new RuntimeException("Error al ejecutar consulta.", e);
            } 
            return pais;
    }
    
    public long insert(Pais pais) {
        long result;
        try {
            String columns = "NOMBRE_PAIS";
            String values = "?";
            if (psInsert == null) {
                    psInsert = db.PreparedUpdate(
                            "INSERT INTO PAIS("+columns+") VALUES("+values+")",
                            "ID_PAIS"
                    );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
                       
            if(pais.getNombrePais() != null){				
                    inputs.add(pais.getNombrePais());	
            }else {
                    inputs.add(null);
            }				
            result = db.ExecuteUpdate(psInsert,inputs);
            } catch (SQLException e) {
                    throw new RuntimeException("Error al ejecutar inserción.", e);
            } 
            return result;
	}
    
    public long update(Pais pais) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();
            
            if (pais.getNombrePais() != null) {
                    columns += ",NOMBRE_PAIS=?";
                    inputs.add(pais.getNombrePais());
            }
            			
            inputs.add(pais.getIdPais());
            columns = columns.substring(1);
                
            psUpdate = db.PreparedUpdate(
                    "UPDATE PAIS SET "+columns+" WHERE ID_PAIS=? "
            );
            result = db.ExecuteUpdate(psUpdate,inputs);
        } catch (SQLException e) {
                throw new RuntimeException("Error al ejecutar actualización.", e);
        } 
        return result;
    }
    
    public long delete(Integer idPais) {
        long result;
        try {
            if (psDelete == null) {
                    psDelete = db.PreparedUpdate(
                    "DELETE FROM PAIS " +
                    "WHERE ID_PAIS=?"
                    );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idPais);
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
//            ArrayList<Pais> listaPais = App.PaisDAO.getAll();
//            for (Pais pais : listaPais) {
//                System.out.println(pais.getIdPais() +" "+ pais.getNombrePais());
//            }

//            System.out.println("GET ONE");
//            Integer codPais = 43;
//            Pais pais = App.PaisDAO.get(codPais);
//            if(pais.getIdPais() != null) {
//                System.out.println(pais.getIdPais() +" "+ pais.getNombrePais());
//            }

//                System.out.println("INSERT");				
//                Pais pais = new Pais();
//                pais.setNombrePais("DANIEL");
//                App.PaisDAO.insert(pais);

//            System.out.println("UPDATE");
//            Pais pais = new Pais();
//            pais.setIdPais(245);
//            pais.setNombrePais("ANDREA");			
//            System.out.println(App.PaisDAO.update(pais));
              
//              System.out.println("DELETE");
//              App.PaisDAO.delete(245);

        } catch (Exception e) {
                throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
                App.CloseConnection();
        }
    }
}
