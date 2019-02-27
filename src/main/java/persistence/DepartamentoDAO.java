/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Departamento;
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
public class DepartamentoDAO {
    private PreparedStatement psSelectAll;
    private PreparedStatement psSelect;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;
    
    private DataBase db;
    
    public DepartamentoDAO() {
    	if (App.DB != null) {
            this.db = App.DB;
    	} else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
            }
    }
    
    public ArrayList<Departamento> getAll() {
        ArrayList<Departamento> listaDepartamento = new ArrayList<Departamento>();
        try {
            if (psSelectAll == null) {
                    psSelectAll = db.PreparedQuery(
                    "SELECT ID_DPTO,NOMBRE_DPTO,ID_PAIS " +
                    "FROM DEPARTAMENTO"
                    );
        }
        ResultSet result = db.ExecuteQuery(psSelectAll);
        while(result.next()) {
                Departamento departamento = new Departamento();
                departamento.setIdDpto(result.getInt("ID_DPTO"));
                departamento.setNombreDpto(result.getString("NOMBRE_DPTO"));
                Pais pais = new Pais();
                pais.setIdPais(result.getInt("ID_PAIS"));
                departamento.setIdPais(pais);
                
                listaDepartamento.add(departamento);
        }
        } catch (SQLException e) {
                throw new RuntimeException("Error al ejecutar consulta.", e);
        } 
        return listaDepartamento;

    }
    
    public Departamento get(int idDpto) {
        Departamento departamento = new Departamento();
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                "SELECT ID_DPTO,NOMBRE_DPTO,ID_PAIS " +
                "FROM DEPARTAMENTO " +
                "WHERE ID_DPTO=?"
                );
            }
        ArrayList<Object> inputs = new ArrayList<Object>();
        inputs.add(idDpto);
        result = db.ExecuteQuery(psSelect,inputs);
        while(result.next()) {
            departamento.setIdDpto(result.getInt("ID_DPTO"));
            departamento.setNombreDpto(result.getString("NOMBRE_DPTO"));
            Pais pais = new Pais();
            pais.setIdPais(result.getInt("ID_PAIS"));
            departamento.setIdPais(pais);

        }
        } catch (SQLException e) {
                throw new RuntimeException("Error al ejecutar consulta.", e);
        } 
        return departamento;
	}
    
    public long insert(Departamento departamento) {
        long result;
        try {
            String columns = "NOMBRE_DPTO,ID_PAIS";
            String values = "?,?";
            if (psInsert == null) {
                    psInsert = db.PreparedUpdate(
                            "INSERT INTO DEPARTAMENTO("+columns+") VALUES("+values+")",
                            "ID_DPTO"
                    );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(departamento.getNombreDpto());
            inputs.add(departamento.getIdPais().getIdPais()); 
            result = db.ExecuteUpdate(psInsert,inputs);
            } catch (SQLException e) {
                    throw new RuntimeException("Error al ejecutar inserción.", e);
            } 
            return result;
	}
		
    public long update(Departamento departamento) {
            long result;
            try {
                String columns = "";
                ArrayList<Object> inputs = new ArrayList<Object>();
                if (departamento.getNombreDpto() != null) {
                        columns += ",NOMBRE_DPTO=?";
                        inputs.add(departamento.getNombreDpto());
                }
                if (departamento.getIdPais() != null) {
                        columns += ",ID_PAIS=?";
                        inputs.add(departamento.getIdPais().getIdPais());
                }

                inputs.add(departamento.getIdDpto());
                columns = columns.substring(1);

                psUpdate = db.PreparedUpdate(
                "UPDATE DEPARTAMENTO SET "+columns+" WHERE ID_DPTO=? "
                ); 
            result = db.ExecuteUpdate(psUpdate,inputs);
            } catch (SQLException e) {
                    throw new RuntimeException("Error al ejecutar actualización.", e);
            } 
            return result;
        }
		
	public long delete(int idDpto) {
            long result;
                try {
                    if (psDelete == null) {
                            psDelete = db.PreparedUpdate(
                            "DELETE FROM DEPARTAMENTO " +
                            "WHERE ID_DPTO=?"
                            );
                    }
                    ArrayList<Object> inputs = new ArrayList<Object>();
                    inputs.add(idDpto);
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
//            ArrayList<Departamento> listaDepartamento = App.DepartamentoDAO.getAll();
//            for (Departamento departamento : listaDepartamento) {
//                    System.out.println(departamento.getIdDpto() +" "+ departamento.getNombreDpto() +" "+ departamento.getIdPais().getIdPais());
//            }
               
//            System.out.println("GET ONE");
//            int codDepartamento = 22;		
//            Departamento departamento = App.DepartamentoDAO.get(codDepartamento);
//            System.out.println(departamento.getIdDpto() +" "+ departamento.getNombreDpto() +" "+ departamento.getIdPais().getIdPais());
//            
//            System.out.println("INSERT");				
//            Departamento departamento = new Departamento();
//            departamento.setNombreDpto("Andrea");
//            Pais pais = new PaisDAO().get(1);
//            departamento.setIdPais(pais);
//            App.DepartamentoDAO.insert(departamento);

//            System.out.println("UPDATE");				
//            Departamento departamento = new Departamento();
//            departamento.setIdDpto(278);		
//            departamento.setNombreDpto("Daniel");
//            App.DepartamentoDAO.update(departamento);
////            Pais pais = new PaisDAO().get(1);
////            departamento.setIdPais(pais);
//            System.out.println(App.DepartamentoDAO.update(departamento));
            
//            System.out.println("DELETE");
//            App.DepartamentoDAO.delete(278);

        } catch (Exception e) {
			throw new RuntimeException("Se ha generado un error inesperado", e);
		} finally {
			App.CloseConnection();
		}
	}    
}