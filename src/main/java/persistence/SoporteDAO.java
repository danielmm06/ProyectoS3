/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Persona;
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
                        "SELECT id_SOPORTE,NOMBRE_SOPORTE,URL_ARCHIVO,id_persona,id_TIPOSOPORTE,NOMBRE_TMP,VALidACION "
                        + "FROM soporte"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                Soporte soporte = new Soporte();
                soporte.setIdSoporte(result.getInt("id_SOPORTE"));
                soporte.setNombreSoporte(result.getString("NOMBRE_SOPORTE"));
                soporte.setUrlArchivo(result.getString("URL_ARCHIVO"));
                soporte.setIdPersona(new Persona(result.getInt("id_persona")));
                soporte.setIdTiposoporte(new TipoSoporte(result.getInt("id_TIPOSOPORTE")));
                soporte.setNombreTmp(result.getNString("NOMBRE_TMP"));
                soporte.setValidacion(result.getString("VALidACION"));

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

    public Soporte get(int idSoporte) {
        Soporte soporte = new Soporte();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT id_SOPORTE,NOMBRE_SOPORTE,URL_ARCHIVO,id_persona,id_TIPOSOPORTE,NOMBRE_TMP,VALidACION "
                        + "FROM soporte WHERE id_SOPORTE=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idSoporte);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                soporte.setIdSoporte(result.getInt("id_SOPORTE"));
                soporte.setNombreSoporte(result.getString("NOMBRE_SOPORTE"));
                soporte.setUrlArchivo(result.getString("URL_ARCHIVO"));
                soporte.setIdPersona((new PersonaDAO()).get(result.getInt("id_persona")));
                soporte.setIdTiposoporte((new TipoSoporteDAO()).get(result.getInt("id_TIPOSOPORTE")));
                soporte.setNombreTmp(result.getNString("NOMBRE_TMP"));
                soporte.setValidacion(result.getString("VALidACION"));

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
        PreparedStatement psInsert = null;
        long result;
        try {
            String columns = "NOMBRE_SOPORTE,URL_ARCHIVO,id_persona,id_TIPOSOPORTE,NOMBRE_TMP,VALidACION";
            String values = "?,?,?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO soporte(" + columns + ") VALUES(" + values + ")", "id_SOPORTE"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(soporte.getNombreSoporte());
            inputs.add(soporte.getUrlArchivo());
            inputs.add(soporte.getIdPersona().getDocumento());
            inputs.add(soporte.getIdTiposoporte().getIdTiposoporte());

            if (soporte.getNombreTmp() != null) {
                inputs.add(soporte.getNombreTmp());
            } else {
                inputs.add(null);
            }
            if (soporte.getValidacion() != null) {
                inputs.add(soporte.getValidacion());
            } else {
                inputs.add(0);
            }
            System.out.println();
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

    public long update(Soporte soporte) {
        PreparedStatement psUpdate = null;
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
            if (soporte.getIdPersona() != null) {
                columns += ",id_persona=?";
                inputs.add(soporte.getIdPersona().getDocumento());
            }
            if (soporte.getIdTiposoporte() != null) {
                columns += ",id_TIPOSOPORTE=?";
                inputs.add(soporte.getIdTiposoporte().getIdTiposoporte());
            }

            if (soporte.getNombreTmp() != null) {
                columns += ",NOMBRE_TMP=?";
                inputs.add(soporte.getIdPersona().getDocumento());
            }

            if (soporte.getValidacion() != null) {
                columns += ",VALidACION=?";
                inputs.add(soporte.getValidacion());
            }

            inputs.add(soporte.getIdSoporte());
            columns = columns.substring(1);

            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE soporte SET " + columns + " WHERE id_SOPORTE=?"
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

    public long delete(int idSoporte) {
        PreparedStatement psDelete = null;
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM soporte "
                        + "WHERE id_SOPORTE=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idSoporte);
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

    public ArrayList<Soporte> getAllByAllPerson(int codPersona) {
        ArrayList<Soporte> listaSoporte = new ArrayList<Soporte>();
        PreparedStatement psSelectByAllPerson = null;
        ResultSet result = null;
        try {
            if (psSelectByAllPerson == null) {
                psSelectByAllPerson = db.PreparedQuery(
                        "SELECT S.id_SOPORTE,S.NOMBRE_SOPORTE,S.URL_ARCHIVO,S.id_persona,S.id_TIPOSOPORTE, S.NOMBRE_TMP, S.VALidACION, TI.NOMBRE AS NOMBRE_SOPORTE "
                        + "FROM soporte S, tipo_soporte TI, persona P "
                        + "WHERE S.id_persona=? AND TI.id_TIPOSOPORTE=S.id_TIPOSOPORTE AND P.DOCUMENTO=S.id_persona AND URL_ARCHIVO LIKE '%soportes/" + codPersona + "/Inscripcion%' ORDER BY S.NOMBRE_SOPORTE"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(codPersona);
            result = db.ExecuteQuery(psSelectByAllPerson, inputs);
            while (result.next()) {
                Soporte soporte = new Soporte();
                soporte.setIdSoporte(result.getInt("id_SOPORTE"));
                soporte.setNombreSoporte(result.getString("NOMBRE_SOPORTE"));
                soporte.setUrlArchivo(result.getString("URL_ARCHIVO"));

                Persona persona = new Persona();
                persona.setDocumento(result.getInt("id_persona"));
                soporte.setIdPersona(persona);

                TipoSoporte tipoSoporte = new TipoSoporte();
                tipoSoporte.setNombre(result.getString("NOMBRE_SOPORTE"));
                tipoSoporte.setIdTiposoporte(result.getInt("id_TIPOSOPORTE"));
                soporte.setIdTiposoporte(tipoSoporte);

                soporte.setNombreTmp(result.getString("NOMBRE_TMP"));

                soporte.setValidacion(result.getString("VALidACION"));
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
            if (psSelectByAllPerson != null) {
                try {
                    psSelectByAllPerson.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return listaSoporte;
    }

    public Soporte getByPersona(long codPersona) {
        Soporte soporte = new Soporte();
        ResultSet result = null;
        PreparedStatement psSelectByPerson = null;
        try {
            if (psSelectByPerson == null) {
                psSelectByPerson = db.PreparedQuery(
                        "SELECT id_SOPORTE,NOMBRE_SOPORTE,URL_ARCHIVO,id_persona,id_TIPOSOPORTE,NOMBRE_TMP FROM soporte WHERE id_persona=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(codPersona);
            result = db.ExecuteQuery(psSelectByPerson, inputs);
            while (result.next()) {
                soporte.setIdSoporte(result.getInt("id_SOPORTE"));
                soporte.setNombreSoporte(result.getString("NOMBRE_SOPORTE"));
                soporte.setUrlArchivo(result.getString("URL_ARCHIVO"));
                //Persona persona = App.PersonaDAO.get(result.getInt("COD_persona"));
                Persona persona = new Persona();
                persona.setDocumento(result.getInt("id_persona"));
                soporte.setIdPersona(persona);
                //TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(result.getInt("COD_TIPOSOPORTE"));
                TipoSoporte tipoSoporte = new TipoSoporte();
                tipoSoporte.setIdTiposoporte(result.getInt("id_TIPOSOPORTE"));
                soporte.setIdTiposoporte(tipoSoporte);

                soporte.setNombreTmp(result.getString("NOMBRE_TMP"));
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
            if (psSelectByPerson != null) {
                try {
                    psSelectByPerson.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return soporte;
    }

    public Soporte getByPath(String path) {
        Soporte soporte = new Soporte();
        PreparedStatement psSelectByPath = null;
        ResultSet result = null;
        try {
            if (psSelectByPath == null) {
                psSelectByPath = db.PreparedQuery(
                        "SELECT id_SOPORTE,NOMBRE_SOPORTE,URL_ARCHIVO,id_persona,id_TIPOSOPORTE,NOMBRE_TMP FROM soporte WHERE URL_ARCHIVO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(path);
            result = db.ExecuteQuery(psSelectByPath, inputs);
            while (result.next()) {
                soporte.setIdSoporte(result.getInt("id_SOPORTE"));
                soporte.setNombreSoporte(result.getString("NOMBRE_SOPORTE"));
                soporte.setUrlArchivo(result.getString("URL_ARCHIVO"));
                //Persona persona = App.PersonaDAO.get(result.getInt("COD_persona"));
                Persona persona = new Persona();
                persona.setDocumento(result.getInt("id_persona"));
                soporte.setIdPersona(persona);
                //TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(result.getInt("COD_TIPOSOPORTE"));
                TipoSoporte tipoSoporte = new TipoSoporte();
                tipoSoporte.setIdTiposoporte(result.getInt("id_TIPOSOPORTE"));
                soporte.setIdTiposoporte(tipoSoporte);

                soporte.setNombreTmp(result.getString("NOMBRE_TMP"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar consulta.", e);
        }
        return soporte;
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
