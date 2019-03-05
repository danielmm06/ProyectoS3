/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.InfoAcademica;
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
public class InfoAcademicaDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public InfoAcademicaDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<InfoAcademica> getAll() throws SQLException {
        ArrayList<InfoAcademica> listaAcademica = new ArrayList<InfoAcademica>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_INFO_ACADEMICA,UNIVERSIDAD,PROGRAMA,TITULO_OBTENIDO,ANO,ID_PREGUNTAS "
                        + "FROM info_academica"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                InfoAcademica academica = new InfoAcademica();
                academica.setIdInfoAcademica(result.getInt("ID_INFO_ACADEMICA"));
                academica.setUniversidad(result.getString("UNIVERSIDAD"));
                academica.setPrograma(result.getString("PROGRAMA"));
                academica.setTituloObtenido(result.getString("TITULO_OBTENIDO"));
                academica.setAno(result.getString("ANO"));
                academica.setIdPreguntas(new InfoPreguntas(result.getInt("ID_PREGUNTAS")));
                listaAcademica.add(academica);
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
        return listaAcademica;
    }

    public InfoAcademica get(int idAcademica) {
        InfoAcademica academica = new InfoAcademica();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_INFO_ACADEMICA,UNIVERSIDAD,PROGRAMA,TITULO_OBTENIDO,ANO,ID_PREGUNTAS "
                                + "FROM info_academica WHERE ID_INFO_ACADEMICA=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idAcademica);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                academica.setIdInfoAcademica(result.getInt("ID_INFO_ACADEMICA"));
                academica.setUniversidad(result.getString("UNIVERSIDAD"));
                academica.setPrograma(result.getString("PROGRAMA"));
                academica.setTituloObtenido(result.getString("TITULO_OBTENIDO"));
                academica.setAno(result.getString("ANO"));
                academica.setIdPreguntas((new InfoPreguntasDAO()).get(result.getInt("ID_PREGUNTAS")));

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
        return academica;
    }

    public long insert(InfoAcademica academica) {
        long result;
        try {
            String columns = "UNIVERSIDAD,PROGRAMA,TITULO_OBTENIDO,ANO,ID_PREGUNTAS";
            String values = "?,?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO info_academica(" + columns + ") VALUES(" + values + ")", "ID_INFO_ACADEMICA"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(academica.getUniversidad());
            inputs.add(academica.getPrograma());
            inputs.add(academica.getTituloObtenido());
            inputs.add(academica.getAno());
            inputs.add(academica.getIdPreguntas().getIdPreguntas());

            result = db.ExecuteUpdate(psInsert, inputs);

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        }
        return result;
    }

    public long update(InfoAcademica academica) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (academica.getUniversidad() != null) {
                columns += ",UNIVERSIDAD=?";
                inputs.add(academica.getUniversidad());
            }
            if (academica.getPrograma() != null) {
                columns += ",PROGRAMA=?";
                inputs.add(academica.getPrograma());
            }
            if (academica.getTituloObtenido() != null) {
                columns += ",TITULO_OBTENIDO=?";
                inputs.add(academica.getTituloObtenido());
            }
            
            if (academica.getAno() != null) {
                columns += ",ANO=?";
                inputs.add(academica.getAno());
            }
            if (academica.getIdPreguntas() != null) {
                columns += ",ID_PREGUNTAS=?";
                inputs.add(academica.getIdPreguntas().getIdPreguntas());
            }
            inputs.add(academica.getIdInfoAcademica());
            columns = columns.substring(1);

            //if (psUpdate == null) {
            psUpdate = db.PreparedUpdate(
                    "UPDATE info_academica SET " + columns + " WHERE ID_INFO_ACADEMICA=?"
            );
            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        }
        return result;
    }

    public long delete(int idAcademica) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM info_academica "
                        + "WHERE ID_INFO_ACADEMICA=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idAcademica);
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
//            ArrayList<InfoAcademica> listaRoles = App.AcademicaDAO.getAll();
//            for (InfoAcademica rol : listaRoles) {
//                System.out.println(
//                        rol.getIdInfoAcademica()+ " "
//                        + rol.getUniversidad()+ " "
//                        + rol.getPrograma()+ " "
//                        + rol.getTituloObtenido()+ " "
//                        + rol.getAno()+ " "
//                        + rol.getIdPreguntas().getIdPreguntas());
//            }
//            System.out.println("GET ONE");
//            int idTUsuario = 1;
//            InfoAcademica rol = App.AcademicaDAO.get(idTUsuario);
//            if (rol.getIdInfoAcademica() != 0) {
//                System.out.println(
//                        rol.getIdInfoAcademica()+ " "
//                        + rol.getUniversidad()+ " "
//                        + rol.getPrograma()+ " "
//                        + rol.getTituloObtenido()+ " "
//                        + rol.getAno()+ " "
//                        + rol.getIdPreguntas().getIdPreguntas());
//            }
//            System.out.println("INSERT");
//            InfoAcademica rol = new InfoAcademica();
//            rol.setUniversidad("asd");
//            rol.setPrograma("asd");
//            rol.setTituloObtenido("asdasd");
//            rol.setAno("2018");
//            rol.setIdPreguntas(new InfoPreguntas(3));
//            App.AcademicaDAO.insert(rol);
//            System.out.println("UPDATE");
//            InfoAcademica rol = new InfoAcademica();
//            rol.setIdInfoAcademica(1);
//            rol.setUniversidad("adsasdasdasdsa");
//            rol.setPrograma("asd");
//            rol.setTituloObtenido("asdasd");
//            rol.setAno("2018");
//            rol.setIdPreguntas(new InfoPreguntas(3));
//            System.out.println(App.AcademicaDAO.update(rol));
//            System.out.println("DELETE");
//            App.AcademicaDAO.delete(1);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
