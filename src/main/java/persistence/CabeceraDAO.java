/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Cabecera;
import entity.Categoria;
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
public class CabeceraDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public CabeceraDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<Cabecera> getAll() throws SQLException {
        ArrayList<Cabecera> listaCabecera = new ArrayList<Cabecera>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_CABECERA, CATEGORIA, PROGRAMA, FACULTAD, ID_PREGUNTAS "
                        + "FROM cabecera"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                Cabecera cabecera = new Cabecera();
                cabecera.setIdCabecera(result.getInt("ID_CABECERA"));
                cabecera.setCategoria(new Categoria(result.getInt("CATEGORIA")));
                cabecera.setPrograma(result.getString("PROGRAMA"));
                cabecera.setFacultad(result.getString("FACULTAD"));
                cabecera.setIdPreguntas(new InfoPreguntas(result.getInt("ID_PREGUNTAS")));
                listaCabecera.add(cabecera);
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
        return listaCabecera;
    }

    public Cabecera get(int idCategoria) {
        Cabecera cabecera = new Cabecera();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_CABECERA, CATEGORIA, PROGRAMA, FACULTAD, ID_PREGUNTAS FROM cabecera WHERE ID_CABECERA=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idCategoria);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                cabecera.setIdCabecera(result.getInt("ID_CABECERA"));
                cabecera.setCategoria((new CategoriaDAO()).get(result.getInt("CATEGORIA")));
                cabecera.setPrograma(result.getString("PROGRAMA"));
                cabecera.setFacultad(result.getString("FACULTAD"));
                cabecera.setIdPreguntas((new InfoPreguntasDAO()).get(result.getInt("ID_PREGUNTAS")));

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
        return cabecera;
    }

    public Cabecera getByPreguntas(InfoPreguntas preguntas) {
        Cabecera cabecera = new Cabecera();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_CABECERA, CATEGORIA, PROGRAMA, FACULTAD, ID_PREGUNTAS FROM cabecera WHERE ID_PREGUNTAS=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(preguntas.getIdPreguntas());
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                cabecera.setIdCabecera(result.getInt("ID_CABECERA"));
                cabecera.setCategoria((new CategoriaDAO()).get(result.getInt("CATEGORIA")));
                cabecera.setPrograma(result.getString("PROGRAMA"));
                cabecera.setFacultad(result.getString("FACULTAD"));
                cabecera.setIdPreguntas(new InfoPreguntas(result.getInt("ID_PREGUNTAS")));

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
        return cabecera;
    }

    public long insert(Cabecera cabecera) {
        long result;
        try {
            String columns = "CATEGORIA, PROGRAMA, FACULTAD, ID_PREGUNTAS";
            String values = "?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO cabecera(" + columns + ") VALUES(" + values + ")", "ID_CABECERA"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(cabecera.getCategoria().getIdCategoria());
            inputs.add(cabecera.getPrograma());
            inputs.add(cabecera.getFacultad());
            inputs.add(cabecera.getIdPreguntas().getIdPreguntas());

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

    public long update(Cabecera cabecera) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (cabecera.getCategoria() != null) {
                columns += ",CATEGORIA=?";
                inputs.add(cabecera.getCategoria().getIdCategoria());
            }
            if (cabecera.getPrograma() != null) {
                columns += ",PROGRAMA=?";
                inputs.add(cabecera.getPrograma());
            }
            if (cabecera.getFacultad() != null) {
                columns += ",FACULTAD=?";
                inputs.add(cabecera.getFacultad());
            }
            if (cabecera.getIdPreguntas() != null) {
                columns += ",ID_PREGUNTAS=?";
                inputs.add(cabecera.getIdPreguntas().getIdPreguntas());
            }
            inputs.add(cabecera.getIdCabecera());
            columns = columns.substring(1);

            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE cabecera SET " + columns + " WHERE ID_CABECERA=?"
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

    public long delete(int idCabecera) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM cabecera "
                        + "WHERE ID_CABECERA=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idCabecera);
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
//            ArrayList<Cabecera> listaRoles = App.CabeceraDAO.getAll();
//            for (Cabecera rol : listaRoles) {
//                System.out.println(
//                        rol.getIdCabecera() + " "
//                        + rol.getCategoria().getIdCategoria() + " "
//                        + rol.getPrograma() + " "
//                        + rol.getFacultad());
//            }
//            System.out.println("GET ONE");
//            int idTUsuario = 1;
//            Cabecera rol = App.CabeceraDAO.get(idTUsuario);
//            if (rol.getIdCabecera() != 0) {
//                System.out.println(rol.getIdCabecera() + " "
//                        + rol.getCategoria().getIdCategoria() + " "
//                        + rol.getPrograma() + " "
//                        + rol.getFacultad());
//            }
//            System.out.println("INSERT");
//            Cabecera rol = new Cabecera();
//            rol.setCategoria(new Categoria(1));
//            rol.setPrograma("asd");
//            rol.setFacultad("asd");
//            App.CabeceraDAO.insert(rol);
//            System.out.println("UPDATE");
//            Cabecera rol = new Cabecera();
//            rol.setIdCabecera(1);
//            rol.setPrograma("dsa");
//            rol.setFacultad("dsa");
//            System.out.println(App.CabeceraDAO.update(rol));
////            System.out.println("DELETE");
//            App.CabeceraDAO.delete(2);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
