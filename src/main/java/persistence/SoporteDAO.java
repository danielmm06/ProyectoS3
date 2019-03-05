/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.InfoPreguntas;
import entity.Soporte;
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
public class SoporteDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public SoporteDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<Soporte> getAll() throws SQLException {
        ArrayList<Soporte> listaSoporte = new ArrayList<Soporte>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_SOPORTE,NOMBRE_SOPORTE,URL_ARCHIVO,ID_TIPOSOPORTE,VALIDACION,ID_PREGUNTAS "
                        + "FROM soporte"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                Soporte soporte = new Soporte();
                soporte.setIdSoporte(result.getInt("ID_SOPORTE"));
                soporte.setNombreSoporte(result.getString("NOMBRE_SOPORTE"));
                soporte.setUrlArchivo(result.getString("URL_ARCHIVO"));
                soporte.setIdTiposoporte(new TipoSoporte(result.getInt("ID_TIPOSOPORTE")));
                soporte.setValidacion(result.getInt("VALIDACION"));
                soporte.setIdPreguntas(new InfoPreguntas(result.getInt("ID_PREGUNTAS")));
                listaSoporte.add(soporte);
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
        return listaSoporte;
    }

    public Soporte get(int idCategoria) {
        Soporte soporte = new Soporte();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_SOPORTE,NOMBRE_SOPORTE,URL_ARCHIVO,ID_TIPOSOPORTE,VALIDACION,ID_PREGUNTAS "
                                + "FROM soporte WHERE ID_SOPORTE=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idCategoria);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                soporte.setIdSoporte(result.getInt("ID_SOPORTE"));
                soporte.setNombreSoporte(result.getString("NOMBRE_SOPORTE"));
                soporte.setUrlArchivo(result.getString("URL_ARCHIVO"));
                soporte.setIdTiposoporte((new TipoSoporteDAO()).get(result.getInt("ID_TIPOSOPORTE")));
                soporte.setValidacion(result.getInt("VALIDACION"));
                soporte.setIdPreguntas((new InfoPreguntasDAO()).get(result.getInt("ID_PREGUNTAS")));

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
        return soporte;
    }

    public long insert(Soporte soporte) {
        long result;
        try {
            String columns = "NOMBRE_SOPORTE,URL_ARCHIVO,ID_TIPOSOPORTE,VALIDACION,ID_PREGUNTAS";
            String values = "?,?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO soporte(" + columns + ") VALUES(" + values + ")", "ID_SOPORTE"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(soporte.getNombreSoporte());
            inputs.add(soporte.getUrlArchivo());
            inputs.add(soporte.getIdTiposoporte().getIdTiposoporte());
            inputs.add(soporte.getValidacion());
            inputs.add(soporte.getIdPreguntas().getIdPreguntas());

            result = db.ExecuteUpdate(psInsert, inputs);

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        }
        return result;
    }

    public long update(Soporte soporte) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (soporte.getNombreSoporte() != null) {
                columns += ",NOMBRE_SOPORTE=?";
                inputs.add(soporte.getNombreSoporte());
            }
            if (soporte.getUrlArchivo() != null) {
                columns += ",URL_ARCHIVO=?";
                inputs.add(soporte.getUrlArchivo());
            }
            if (soporte.getIdTiposoporte() != null) {
                columns += ",ID_TIPOSOPORTE=?";
                inputs.add(soporte.getIdTiposoporte().getIdTiposoporte());
            }
            
            if (soporte.getValidacion() != 0) {
                columns += ",VALIDACION=?";
                inputs.add(soporte.getValidacion());
            }
            if (soporte.getIdPreguntas() != null) {
                columns += ",ID_PREGUNTAS=?";
                inputs.add(soporte.getIdPreguntas().getIdPreguntas());
            }
            inputs.add(soporte.getIdSoporte());
            columns = columns.substring(1);

            //if (psUpdate == null) {
            psUpdate = db.PreparedUpdate(
                    "UPDATE soporte SET " + columns + " WHERE ID_SOPORTE=?"
            );
            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        }
        return result;
    }

    public long delete(int idSoporte) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM soporte "
                        + "WHERE ID_SOPORTE=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idSoporte);
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
//            ArrayList<Soporte> listaRoles = App.SoporteDAO.getAll();
//            for (Soporte rol : listaRoles) {
//                System.out.println(
//                        rol.getIdSoporte()+ " "
//                        + rol.getNombreSoporte() + " "
//                        + rol.getUrlArchivo()+ " "
//                        + rol.getIdTiposoporte().getIdTiposoporte()+ " "
//                        + rol.getValidacion()+ " "
//                        + rol.getIdPreguntas().getIdPreguntas());
//            }
//            System.out.println("GET ONE");
//            int idTUsuario = 1;
//            Soporte rol = App.SoporteDAO.get(idTUsuario);
//            if (rol.getIdSoporte() != 0) {
//                System.out.println(rol.getIdSoporte()+ " "
//                        + rol.getNombreSoporte() + " "
//                        + rol.getUrlArchivo()+ " "
//                        + rol.getIdTiposoporte().getIdTiposoporte()+ " "
//                        + rol.getValidacion()+ " "
//                        + rol.getIdPreguntas().getIdPreguntas());
//            }
//            System.out.println("INSERT");
//            Soporte rol = new Soporte();
//            rol.setNombreSoporte("asd");
//            rol.setUrlArchivo("asd");
//            rol.setIdTiposoporte(new TipoSoporte(3));
//            rol.setValidacion(0);
//            rol.setIdPreguntas(new InfoPreguntas(3));
//            App.SoporteDAO.insert(rol);
//            System.out.println("UPDATE");
//            Soporte rol = new Soporte();
//            rol.setIdSoporte(1);
//            rol.setNombreSoporte("ASDASDADS");
//            rol.setUrlArchivo("dsa");
//            rol.setIdTiposoporte(new TipoSoporte(3));
//            rol.setValidacion(0);
//            rol.setIdPreguntas(new InfoPreguntas(3));
//            System.out.println(App.SoporteDAO.update(rol));
//            System.out.println("DELETE");
//            App.SoporteDAO.delete(1);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
