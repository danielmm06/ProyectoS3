/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.TipoDocumento;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class TipoDocumentoDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public TipoDocumentoDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<TipoDocumento> getAll() throws SQLException {
        ArrayList<TipoDocumento> listaTipoDocumento = new ArrayList<TipoDocumento>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_DOCUMENTO, NOMB_DOCUMENTO "
                        + "FROM tipo_documento"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                TipoDocumento tdocumento = new TipoDocumento();
                tdocumento.setIdDocumento(result.getInt("ID_DOCUMENTO"));
                tdocumento.setNombDocumento(result.getString("NOMB_DOCUMENTO"));
                listaTipoDocumento.add(tdocumento);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar consulta.", e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el resultset", e);
                }
            }
            if (psSelectAll != null) {
                try {
                    psSelectAll.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return listaTipoDocumento;
    }

    public TipoDocumento get(int idDocumento) {
        TipoDocumento tdocumento = new TipoDocumento();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_DOCUMENTO, NOMB_DOCUMENTO FROM tipo_documento WHERE ID_DOCUMENTO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idDocumento);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                tdocumento.setIdDocumento(result.getInt("ID_DOCUMENTO"));
                tdocumento.setNombDocumento(result.getString("NOMB_DOCUMENTO"));

            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar consulta.", e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el resultset", e);
                }
            }
            if (psSelect != null) {
                try {
                    psSelect.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return tdocumento;
    }

    public long insert(TipoDocumento tdocumento) {
        long result;
        try {
            String columns = "NOMB_DOCUMENTO";
            String values = "?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO tipo_documento(" + columns + ") VALUES(" + values + ")", "ID_DOCUMENTO"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(tdocumento.getNombDocumento());

            result = db.ExecuteUpdate(psInsert, inputs);

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        }
        return result;
    }

    public long update(TipoDocumento tdocumento) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();
            if (tdocumento.getNombDocumento() != null) {
                columns += ",NOMB_DOCUMENTO=?";
                inputs.add(tdocumento.getNombDocumento());
            }
            inputs.add(tdocumento.getIdDocumento());
            columns = columns.substring(1);

            //if (psUpdate == null) {
            psUpdate = db.PreparedUpdate(
                    "UPDATE tipo_documento SET " + columns + " WHERE ID_DOCUMENTO=?"
            );
            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        }
        return result;
    }

    public long delete(int idTDocumento) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM tipo_documento "
                        + "WHERE ID_DOCUMENTO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idTDocumento);
            result = db.ExecuteUpdate(psDelete, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar borrado.", e);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try {
            App.OpenConnection();

//            System.out.println("GET ALL");
//            ArrayList<Rol> listaRoles = App.RolDAO.getAll();
//            for (Rol rol : listaRoles) {
//                System.out.println(rol.getIdTUsuario() + " " + rol.getNombreTUsuario());
//            }
//			System.out.println("GET ONE");
//			int idTUsuario = 1121200;			
//			Rol rol = App.RolDAO.get(idTUsuario);
//			if(rol.getIdTUsuario() != 0) {						
//				System.out.println(rol.getIdTUsuario()+" "+rol.getNombreTUsuario());
//			}
//                        System.out.println("INSERT");				
//                        Rol rol = new Rol();
//                        rol.setNombreTUsuario("ADMIN");
//                        App.RolDAO.insert(rol);	
//                    System.out.println("UPDATE");				
//                    Rol rol = new Rol();
//                    rol.setIdTUsuario(1213);		
//                    rol.setNombreTUsuario("Estudiante");
//                    App.RolDAO.update(rol);		
//                    System.out.println(App.RolDAO.update(rol));
//                      System.out.println("DELETE");
//                      App.RolDAO.delete(1121200);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
