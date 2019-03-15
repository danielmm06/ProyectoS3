/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.TipoSoporte;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class TipoSoporteDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public TipoSoporteDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<TipoSoporte> getAll() throws SQLException {
        ArrayList<TipoSoporte> listaTSoporte = new ArrayList<TipoSoporte>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_TIPOSOPORTE, NOMBRE "
                        + "FROM tipo_soporte"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                TipoSoporte tSoporte = new TipoSoporte();
                tSoporte.setIdTiposoporte(result.getInt("ID_TIPOSOPORTE"));
                tSoporte.setNombre(result.getString("NOMBRE"));
                listaTSoporte.add(tSoporte);
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
        return listaTSoporte;
    }

    public TipoSoporte get(int idTUsuario) {
        TipoSoporte tSoporte = new TipoSoporte();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_TIPOSOPORTE,NOMBRE FROM tipo_soporte WHERE ID_TIPOSOPORTE=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idTUsuario);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                tSoporte.setIdTiposoporte(result.getInt("ID_TIPOSOPORTE"));
                tSoporte.setNombre(result.getString("NOMBRE"));

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
        return tSoporte;
    }

    public long insert(TipoSoporte tSoporte) {
        long result;
        try {
            String columns = "NOMBRE";
            String values = "?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO tipo_soporte(" + columns + ") VALUES(" + values + ")", "ID_TIPOSOPORTE"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(tSoporte.getNombre());

            result = db.ExecuteUpdate(psInsert, inputs);

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        } finally {
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return result;
    }

    public long update(TipoSoporte tSoporte) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (tSoporte.getNombre() != null) {
                columns += ",NOMBRE=?";
                inputs.add(tSoporte.getNombre());
            }
            inputs.add(tSoporte.getIdTiposoporte());
            columns = columns.substring(1);

            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE tipo_soporte SET " + columns + " WHERE ID_TIPOSOPORTE=?"
                );
            }
            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        } finally {
            if (psUpdate != null) {
                try {
                    psUpdate.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return result;
    }

    public long delete(int idTSoporte) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM tipo_soporte "
                        + "WHERE ID_TIPOSOPORTE=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idTSoporte);
            result = db.ExecuteUpdate(psDelete, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar borrado.", e);
        } finally {
            if (psDelete != null) {
                try {
                    psDelete.close();
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
//            ArrayList<TipoSoporte> listaRoles = App.TSoporteDAO.getAll();
//            for (TipoSoporte rol : listaRoles) {
//                System.out.println(rol.getIdTiposoporte() + " " + rol.getNombre());
//            }
//            System.out.println("GET ONE");
//            int idTUsuario = 1;
//            TipoSoporte rol = App.TSoporteDAO.get(idTUsuario);
//            if (rol.getIdTiposoporte() != 0) {
//                System.out.println(rol.getIdTiposoporte() + " " + rol.getNombre());
//            }
//            System.out.println("INSERT");
//            TipoSoporte rol = new TipoSoporte();
//            rol.setNombre("ADMIN");
//            App.TSoporteDAO.insert(rol);
//            System.out.println("UPDATE");
//            TipoSoporte rol = new TipoSoporte();
//            rol.setIdTiposoporte(1);
//            rol.setNombre("Estudiante");
//            System.out.println(App.TSoporteDAO.update(rol));
//            System.out.println("DELETE");
//            App.TSoporteDAO.delete(2);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
