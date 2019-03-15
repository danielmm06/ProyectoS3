/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.InfoLaboral;
import entity.InfoPreguntas;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class InfoLaboralDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public InfoLaboralDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<InfoLaboral> getAll() throws SQLException {
        ArrayList<InfoLaboral> listaLaboral = new ArrayList<InfoLaboral>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_LABORAL,EMPRESA,CARGO,FECHA_INICIO,FECHA_FIN,ID_PREGUNTAS "
                        + "FROM info_laboral"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                InfoLaboral laboral = new InfoLaboral();
                laboral.setIdLaboral(result.getInt("ID_LABORAL"));
                laboral.setEmpresa(result.getString("EMPRESA"));
                laboral.setCargo(result.getString("CARGO"));
                laboral.setFechaInicio(Date.valueOf(result.getString("FECHA_INICIO")));
                laboral.setFechaFin(Date.valueOf(result.getString("FECHA_FIN")));
                laboral.setIdPreguntas(new InfoPreguntas(result.getInt("ID_PREGUNTAS")));
                listaLaboral.add(laboral);
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
        return listaLaboral;
    }

    public ArrayList<InfoLaboral> getAllByPreguntas(InfoPreguntas preguntas) {
        ArrayList<InfoLaboral> listaLaboral = new ArrayList<InfoLaboral>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_LABORAL,EMPRESA,CARGO,FECHA_INICIO,FECHA_FIN,ID_PREGUNTAS "
                        + "FROM info_laboral where ID_PREGUNTAS=" + preguntas.getIdPreguntas()
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                InfoLaboral laboral = new InfoLaboral();
                laboral.setIdLaboral(result.getInt("ID_LABORAL"));
                laboral.setEmpresa(result.getString("EMPRESA"));
                laboral.setCargo(result.getString("CARGO"));
                laboral.setFechaInicio(Date.valueOf(result.getString("FECHA_INICIO")));
                laboral.setFechaFin(Date.valueOf(result.getString("FECHA_FIN")));
                laboral.setIdPreguntas(new InfoPreguntas(result.getInt("ID_PREGUNTAS")));
                listaLaboral.add(laboral);
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
        return listaLaboral;
    }

    public InfoLaboral get(int idLaboral) {
        InfoLaboral laboral = new InfoLaboral();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_LABORAL,EMPRESA,CARGO,FECHA_INICIO,FECHA_FIN,ID_PREGUNTAS "
                        + "FROM info_laboral WHERE ID_LABORAL=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idLaboral);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                laboral.setIdLaboral(result.getInt("ID_LABORAL"));
                laboral.setEmpresa(result.getString("EMPRESA"));
                laboral.setCargo(result.getString("CARGO"));
                laboral.setFechaInicio(Date.valueOf(result.getString("FECHA_INICIO")));
                laboral.setFechaFin(Date.valueOf(result.getString("FECHA_FIN")));
                laboral.setIdPreguntas((new InfoPreguntasDAO()).get(result.getInt("ID_PREGUNTAS")));

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
        return laboral;
    }

    public long insert(InfoLaboral laboral) {
        long result;
        try {
            String columns = "EMPRESA,CARGO,FECHA_INICIO,FECHA_FIN,ID_PREGUNTAS";
            String values = "?,?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO info_laboral(" + columns + ") VALUES(" + values + ")", "ID_LABORAL"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(laboral.getEmpresa());
            inputs.add(laboral.getCargo());
            inputs.add(laboral.getFechaInicio());
            inputs.add(laboral.getFechaFin());
            inputs.add(laboral.getIdPreguntas().getIdPreguntas());

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

    public long update(InfoLaboral laboral) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (laboral.getEmpresa() != null) {
                columns += ",EMPRESA=?";
                inputs.add(laboral.getEmpresa());
            }
            if (laboral.getCargo() != null) {
                columns += ",CARGO=?";
                inputs.add(laboral.getCargo());
            }
            if (laboral.getFechaInicio() != null) {
                columns += ",FECHA_INICIO=?";
                inputs.add(laboral.getFechaInicio());
            }

            if (laboral.getFechaFin() != null) {
                columns += ",FECHA_FIN=?";
                inputs.add(laboral.getFechaFin());
            }
            if (laboral.getIdPreguntas() != null) {
                columns += ",ID_PREGUNTAS=?";
                inputs.add(laboral.getIdPreguntas().getIdPreguntas());
            }
            inputs.add(laboral.getIdLaboral());
            columns = columns.substring(1);

            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE info_laboral SET " + columns + " WHERE ID_LABORAL=?"
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

    public long delete(int idLaboral) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM info_laboral "
                        + "WHERE ID_LABORAL=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idLaboral);
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
    
    public long deleteByPreguntas(InfoPreguntas preguntas) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM info_laboral "
                        + "WHERE ID_PREGUNTAS=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(preguntas.getIdPreguntas());
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
//            ArrayList<InfoLaboral> listaRoles = App.LaboralDAO.getAll();
//            for (InfoLaboral rol : listaRoles) {
//                System.out.println(
//                        rol.getIdLaboral()+ " "
//                        + rol.getEmpresa()+ " "
//                        + rol.getCargo()+ " "
//                        + rol.getFechaInicio()+ " "
//                        + rol.getFechaFin()+ " "
//                        + rol.getIdPreguntas().getIdPreguntas());
//            }
//            System.out.println("GET ONE");
//            int idTUsuario = 1;
//            InfoLaboral rol = App.LaboralDAO.get(idTUsuario);
//            if (rol.getIdLaboral() != 0) {
//                System.out.println(
//                        rol.getIdLaboral()+ " "
//                        + rol.getEmpresa()+ " "
//                        + rol.getCargo()+ " "
//                        + rol.getFechaInicio()+ " "
//                        + rol.getFechaFin()+ " "
//                        + rol.getIdPreguntas().getIdPreguntas());
//            }
//            System.out.println("INSERT");
//            InfoLaboral rol = new InfoLaboral();
//            rol.setEmpresa("asd");
//            rol.setCargo("asd");
//            rol.setFechaInicio(Date.valueOf("2018-01-01"));
//            rol.setFechaFin(Date.valueOf("2018-01-01"));
//            rol.setIdPreguntas(new InfoPreguntas(3));
//            App.LaboralDAO.insert(rol);
//            System.out.println("UPDATE");
//            InfoLaboral rol = new InfoLaboral();
//            rol.setIdLaboral(1);
//            rol.setEmpresa("asdasdasdasdasd");
//            rol.setCargo("asd");
//            rol.setFechaInicio(Date.valueOf("2018-01-01"));
//            rol.setFechaFin(Date.valueOf("2018-01-01"));
//            rol.setIdPreguntas(new InfoPreguntas(3));
//            System.out.println(App.LaboralDAO.update(rol));
//            System.out.println("DELETE");
//            App.LaboralDAO.delete(1);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
