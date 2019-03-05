/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.InfoIdiomas;
import entity.InfoPreguntas;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class InfoIdiomasDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public InfoIdiomasDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<InfoIdiomas> getAll() throws SQLException {
        ArrayList<InfoIdiomas> listaIdiomas = new ArrayList<InfoIdiomas>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_IDIOMAS,IDIOMA,COMPRENDE,HABLA,ESCRIBE,ID_PREGUNTAS "
                        + "FROM info_idiomas"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                InfoIdiomas idiomas = new InfoIdiomas();
                idiomas.setIdIdiomas(result.getInt("ID_IDIOMAS"));
                idiomas.setIdioma(result.getString("IDIOMA"));
                idiomas.setComprende(result.getString("COMPRENDE"));
                idiomas.setHabla(result.getString("HABLA"));
                idiomas.setEscribe(result.getString("ESCRIBE"));
                idiomas.setIdPreguntas(new InfoPreguntas(result.getInt("ID_PREGUNTAS")));
                listaIdiomas.add(idiomas);
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
        return listaIdiomas;
    }

    public InfoIdiomas get(int idIdiomas) {
        InfoIdiomas idiomas = new InfoIdiomas();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_IDIOMAS,IDIOMA,COMPRENDE,HABLA,ESCRIBE,ID_PREGUNTAS "
                                + "FROM info_idiomas WHERE ID_IDIOMAS=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idIdiomas);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                idiomas.setIdIdiomas(result.getInt("ID_IDIOMAS"));
                idiomas.setIdioma(result.getString("IDIOMA"));
                idiomas.setComprende(result.getString("COMPRENDE"));
                idiomas.setHabla(result.getString("HABLA"));
                idiomas.setEscribe(result.getString("ESCRIBE"));
                idiomas.setIdPreguntas((new InfoPreguntasDAO()).get(result.getInt("ID_PREGUNTAS")));

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
        return idiomas;
    }

    public long insert(InfoIdiomas idiomas) {
        long result;
        try {
            String columns = "IDIOMA,COMPRENDE,HABLA,ESCRIBE,ID_PREGUNTAS";
            String values = "?,?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO info_idiomas(" + columns + ") VALUES(" + values + ")", "ID_IDIOMAS"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idiomas.getIdioma());
            inputs.add(idiomas.getComprende());
            inputs.add(idiomas.getHabla());
            inputs.add(idiomas.getEscribe());
            inputs.add(idiomas.getIdPreguntas().getIdPreguntas());

            result = db.ExecuteUpdate(psInsert, inputs);

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        }
        return result;
    }

    public long update(InfoIdiomas idiomas) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (idiomas.getIdioma() != null) {
                columns += ",IDIOMA=?";
                inputs.add(idiomas.getIdioma());
            }
            if (idiomas.getComprende() != null) {
                columns += ",COMPRENDE=?";
                inputs.add(idiomas.getComprende());
            }
            if (idiomas.getHabla() != null) {
                columns += ",HABLA=?";
                inputs.add(idiomas.getHabla());
            }
            
            if (idiomas.getEscribe() != null) {
                columns += ",ESCRIBE=?";
                inputs.add(idiomas.getEscribe());
            }
            if (idiomas.getIdPreguntas() != null) {
                columns += ",ID_PREGUNTAS=?";
                inputs.add(idiomas.getIdPreguntas().getIdPreguntas());
            }
            inputs.add(idiomas.getIdIdiomas());
            columns = columns.substring(1);

            //if (psUpdate == null) {
            psUpdate = db.PreparedUpdate(
                    "UPDATE info_idiomas SET " + columns + " WHERE ID_IDIOMAS=?"
            );
            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        }
        return result;
    }

    public long delete(int idIdiomas) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM info_idiomas "
                        + "WHERE ID_IDIOMAS=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idIdiomas);
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
//            ArrayList<InfoIdiomas> listaRoles = App.IdiomasDAO.getAll();
//            for (InfoIdiomas rol : listaRoles) {
//                System.out.println(
//                        rol.getIdIdiomas()+ " "
//                        + rol.getIdioma()+ " "
//                        + rol.getComprende()+ " "
//                        + rol.getHabla()+ " "
//                        + rol.getEscribe()+ " "
//                        + rol.getIdPreguntas().getIdPreguntas());
//            }
//            System.out.println("GET ONE");
//            int idTUsuario = 1;
//            InfoIdiomas rol = App.IdiomasDAO.get(idTUsuario);
//            if (rol.getIdIdiomas() != 0) {
//                System.out.println(
//                        rol.getIdIdiomas()+ " "
//                        + rol.getIdioma()+ " "
//                        + rol.getComprende()+ " "
//                        + rol.getHabla()+ " "
//                        + rol.getEscribe()+ " "
//                        + rol.getIdPreguntas().getIdPreguntas());
//            }
//            System.out.println("INSERT");
//            InfoIdiomas rol = new InfoIdiomas();
//            rol.setIdioma("asd");
//            rol.setComprende("asd");
//            rol.setHabla("asdasd");
//            rol.setEscribe("asd");
//            rol.setIdPreguntas(new InfoPreguntas(3));
//            App.IdiomasDAO.insert(rol);
//            System.out.println("UPDATE");
//            InfoIdiomas rol = new InfoIdiomas();
//            rol.setIdIdiomas(1);
//            rol.setIdioma("adasdasdasdasd");
//            rol.setComprende("asd");
//            rol.setHabla("asdasd");
//            rol.setEscribe("2018");
//            rol.setIdPreguntas(new InfoPreguntas(3));
//            System.out.println(App.IdiomasDAO.update(rol));
//            System.out.println("DELETE");
//            App.IdiomasDAO.delete(1);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
