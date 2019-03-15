/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Rol;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class RolDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public RolDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<Rol> getAll() throws SQLException {
        ArrayList<Rol> listaRol = new ArrayList<Rol>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_T_USUARIO, NOMBRE_T_USUARIO "
                        + "FROM ROL"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                Rol rol = new Rol();
                rol.setIdTUsuario(result.getInt("ID_T_USUARIO"));
                rol.setNombreTUsuario(result.getString("NOMBRE_T_USUARIO"));
                listaRol.add(rol);
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
        return listaRol;
    }

    public Rol get(int idTUsuario) {
        Rol rol = new Rol();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_T_USUARIO,NOMBRE_T_USUARIO FROM ROL WHERE ID_T_USUARIO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idTUsuario);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                rol.setIdTUsuario(result.getInt("ID_T_USUARIO"));
                rol.setNombreTUsuario(result.getString("NOMBRE_T_USUARIO"));

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
        return rol;
    }

    public long insert(Rol rol) {
        long result;
        try {
            String columns = "NOMBRE_T_USUARIO";
            String values = "?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO ROL(" + columns + ") VALUES(" + values + ")", "ID_T_USUARIO"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(rol.getNombreTUsuario());

            result = db.ExecuteUpdate(psInsert, inputs);

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        } finally {
            if (psInsert != null) {
                try {
                    psInsert.close();
                    psInsert = null;
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return result;
    }

    public long update(Rol rol) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (rol.getNombreTUsuario() != null) {
                columns += ",NOMBRE_T_USUARIO=?";
                inputs.add(rol.getNombreTUsuario());
            }
            inputs.add(rol.getIdTUsuario());
            columns = columns.substring(1);

            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE ROL SET " + columns + " WHERE ID_T_USUARIO=?"
                );
            }
            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        } finally {
            if (psUpdate != null) {
                try {
                    psUpdate.close();
                    psUpdate = null;
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return result;
    }

    public long delete(Integer idTUsuario) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM ROL "
                        + "WHERE ID_T_USUARIO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idTUsuario);
            result = db.ExecuteUpdate(psDelete, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar borrado.", e);
        } finally {
            if (psDelete != null) {
                try {
                    psDelete.close();
                    psDelete = null;
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
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
