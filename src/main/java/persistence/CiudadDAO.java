/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Ciudad;
import entity.Departamento;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class CiudadDAO {

    private PreparedStatement psSelectAll;
    private PreparedStatement psSelect;
    private PreparedStatement psSelectByNombre;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public CiudadDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<Ciudad> getAll() {
        ArrayList<Ciudad> listaCiudad = new ArrayList<Ciudad>();
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_ciudad,NOMBRE_ciudad,ID_DPTO "
                        + "FROM ciudad"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(result.getInt("ID_ciudad"));
                ciudad.setNombreCiudad(result.getString("NOMBRE_ciudad"));
                Departamento departamento = new Departamento();
                departamento.setIdDpto(result.getInt("ID_DPTO"));
                ciudad.setIdDpto(departamento);

                listaCiudad.add(ciudad);
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
                    psSelectAll = null;
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return listaCiudad;
    }

    public Ciudad get(int idCiudad) {
        Ciudad ciudad = new Ciudad();
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_ciudad,NOMBRE_ciudad,ID_DPTO "
                        + "FROM ciudad "
                        + "WHERE ID_ciudad=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idCiudad);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                ciudad.setIdCiudad(result.getInt("ID_ciudad"));
                ciudad.setNombreCiudad(result.getString("NOMBRE_ciudad"));
                ciudad.setIdDpto((new DepartamentoDAO()).get(result.getInt("ID_DPTO")));

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
                    psSelect = null;
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return ciudad;
    }

    public ArrayList<Ciudad> getByDepart(int idDpto) {
        ArrayList<Ciudad> listaCiudadDerpt = new ArrayList<Ciudad>();
        PreparedStatement psSelectGetByDepart = null;
        ResultSet result = null;
        try {
            if (psSelectGetByDepart == null) {
                psSelectGetByDepart = db.PreparedQuery("SELECT ID_ciudad,NOMBRE_ciudad,ID_DPTO "
                        + "FROM ciudad "
                        + "WHERE ID_DPTO=?");
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idDpto);
            result = db.ExecuteQuery(psSelectGetByDepart, inputs);
            while (result.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(result.getInt("ID_ciudad"));
                ciudad.setNombreCiudad(result.getString("NOMBRE_ciudad"));
                Departamento departamento = new Departamento();
                departamento.setIdDpto(result.getInt("ID_DPTO"));
                ciudad.setIdDpto(departamento);

                listaCiudadDerpt.add(ciudad);
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
            if (psSelectGetByDepart != null) {
                try {
                    psSelectGetByDepart.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }

        return listaCiudadDerpt;
    }

    public long insert(Ciudad ciudad) {
        long result;
        try {
            String columns = "NOMBRE_ciudad,ID_DPTO";
            String values = "?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO ciudad(" + columns + ") VALUES(" + values + ")",
                        "ID_ciudad"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(ciudad.getNombreCiudad());
            inputs.add(ciudad.getIdDpto().getIdDpto());
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

    public long update(Ciudad ciudad) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (ciudad.getNombreCiudad() != null) {
                columns += ",NOMBRE_ciudad=?";
                inputs.add(ciudad.getNombreCiudad());
            }
            if (ciudad.getIdDpto() != null) {
                columns += ",ID_DPTO=?";
                inputs.add(ciudad.getIdDpto().getIdDpto());
            }

            inputs.add(ciudad.getIdCiudad());
            columns = columns.substring(1);
            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE ciudad SET " + columns + " WHERE ID_ciudad=? "
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

    public long delete(int idCiudad) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM ciudad "
                        + "WHERE ID_ciudad=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idCiudad);
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
//            ArrayList<Ciudad> listaCiudad = App.CiudadDAO.getByDepart(22);
//            for (Ciudad ciudad : listaCiudad) {
//                System.out.println(ciudad.getIdCiudad() + " " + ciudad.getNombreCiudad() + " " + ciudad.getIdDpto().getIdDpto());
//            }
//            System.out.println("GET ONE");
//            int idCiudad = 34;			
//            Ciudad ciudad = App.CiudadDAO.get(idCiudad);
//            if(ciudad.getIdCiudad() != 0) {						
//                System.out.println(ciudad.getIdCiudad()+" "+ciudad.getNombreCiudad()+" "+ciudad.getIdDpto().getIdDpto());
//            }
//            System.out.println("INSERT");				
//            Ciudad ciudad = new Ciudad();
//            ciudad.setNombreCiudad("Andrea");
//            Departamento departamento = new DepartamentoDAO().get(1);
//            ciudad.setIdDpto(departamento);
//            App.CiudadDAO.insert(ciudad);
//            System.out.println("UPDATE");
//            Ciudad ciudad = new Ciudad();
//            ciudad.setIdCiudad(1365);
//            ciudad.setNombreCiudad("Daniel");
//            System.out.println(App.CiudadDAO.update(ciudad));
//            System.out.println("DELETE");
//            App.CiudadDAO.delete(1365);
//            System.out.println(App.CiudadDAO.delete(1365));
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
