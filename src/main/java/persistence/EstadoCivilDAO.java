/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.EstadoCivil;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class EstadoCivilDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public EstadoCivilDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<EstadoCivil> getAll() throws SQLException {
        ArrayList<EstadoCivil> listaEstadoCivil = new ArrayList<EstadoCivil>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID, ESTADO_CIVIL "
                        + "FROM estado_civil"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                EstadoCivil estado = new EstadoCivil();
                estado.setId(result.getInt("ID"));
                estado.setEstadoCivil(result.getString("ESTADO_CIVIL"));
                listaEstadoCivil.add(estado);
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
        return listaEstadoCivil;
    }

    public EstadoCivil get(int idEstado) {
        EstadoCivil estado = new EstadoCivil();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID, ESTADO_CIVIL FROM estado_civil WHERE ID=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idEstado);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                estado.setId(result.getInt("ID"));
                estado.setEstadoCivil(result.getString("ESTADO_CIVIL"));

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
        return estado;
    }

    public long insert(EstadoCivil estado) {
        long result;
        try {
            String columns = "ESTADO_CIVIL";
            String values = "?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO estado_civil(" + columns + ") VALUES(" + values + ")", "ID"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(estado.getEstadoCivil());

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

    public long update(EstadoCivil estado) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();
            if (estado.getEstadoCivil() != null) {
                columns += ",ESTADO_CIVIL=?";
                inputs.add(estado.getEstadoCivil());
            }
            inputs.add(estado.getId());
            columns = columns.substring(1);

            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE estado_civil SET " + columns + " WHERE ID=?"
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

    public long delete(int idEstado) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM estado_civil "
                        + "WHERE ID=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idEstado);
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
//            ArrayList<EstadoCivil> listaRoles = App.EstadoDAO.getAll();
//            for (EstadoCivil rol : listaRoles) {
//                System.out.println(rol.getId()+ " " + rol.getEstadoCivil());
//            }
//            System.out.println("GET ONE");
//            int idTUsuario = 1;
//            EstadoCivil rol = App.EstadoDAO.get(idTUsuario);
//            if (rol.getId() != 0) {
//                System.out.println(rol.getId() + " " + rol.getEstadoCivil());
//            }
//            System.out.println("INSERT");
//            EstadoCivil rol = new EstadoCivil();
//            rol.setEstadoCivil("ADMIN");
//            App.EstadoDAO.insert(rol);
//            System.out.println("UPDATE");
//            EstadoCivil rol = new EstadoCivil();
//            rol.setId(8);
//            rol.setEstadoCivil("Estudiante");
//            System.out.println(App.EstadoDAO.update(rol));
//            System.out.println("DELETE");
//            App.EstadoDAO.delete(8);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
