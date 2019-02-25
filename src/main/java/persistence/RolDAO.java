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

    private PreparedStatement psSelect;
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
        }
        return rol;
    }

    public long insert(Rol rol) {
        long result;
        try {
            String columns = "ID_T_USUARIO,NOMBRE_T_USUARIO";
            String values = "?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO ROL(" + columns + ") VALUES(" + values + ")"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (rol.getNombreTUsuario() != null) {
                inputs.add(rol.getIdTUsuario());
                inputs.add(rol.getNombreTUsuario());
            } else {
                inputs.add(null);
                inputs.add(null);
            }

            result = db.ExecuteUpdate(psInsert, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
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
//			int codPregDescuentos = 1;			
//			PregDescuentos pregDescuentos = App.PregDescuentosDAO.get(codPregDescuentos);
//			if(pregDescuentos.getCodPregDescuentos() != 0) {						
//				System.out.println(pregDescuentos.getCodPregDescuentos()+" "+pregDescuentos.getPregunta()+" "+pregDescuentos.getTipoFormulario()+" "+pregDescuentos.getActivo());
//			}
                   System.out.println("INSERT");
                   Rol rol = new Rol();
                   rol.setIdTUsuario(1213);
                   rol.setNombreTUsuario("ANDREA OCHOA");
                  App.RolDAO.insert(rol);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
