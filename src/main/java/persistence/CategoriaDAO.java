/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Categoria;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class CategoriaDAO {
//    private PreparedStatement psSelectAll;

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public CategoriaDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<Categoria> getAll() throws SQLException {
        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_CATEGORIA, NOMB_CATEGORIA "
                        + "FROM categoria"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(result.getInt("ID_CATEGORIA"));
                categoria.setNombCategoria(result.getString("NOMB_CATEGORIA"));
                listaCategoria.add(categoria);
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
        return listaCategoria;
    }

    public Categoria get(int idCategoria) {
        Categoria categoria = new Categoria();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_CATEGORIA,NOMB_CATEGORIA FROM categoria WHERE ID_CATEGORIA=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idCategoria);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                categoria.setIdCategoria(result.getInt("ID_CATEGORIA"));
                categoria.setNombCategoria(result.getString("NOMB_CATEGORIA"));

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
        return categoria;
    }

    public long insert(Categoria categoria) {
        long result;
        try {
            String columns = "NOMB_CATEGORIA";
            String values = "?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO categoria(" + columns + ") VALUES(" + values + ")", "ID_CATEGORIA"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(categoria.getNombCategoria());

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

    public long update(Categoria categoria) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (categoria.getNombCategoria() != null) {
                columns += ",NOMB_CATEGORIA=?";
                inputs.add(categoria.getNombCategoria());
            }
            inputs.add(categoria.getIdCategoria());
            columns = columns.substring(1);

            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE categoria SET " + columns + " WHERE ID_CATEGORIA=?"
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

    public long delete(int idCategoria) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM categoria "
                        + "WHERE ID_CATEGORIA=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idCategoria);
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
//            ArrayList<Categoria> listaRoles = App.CategoriaDAO.getAll();
//            for (Categoria rol : listaRoles) {
//                System.out.println(rol.getIdCategoria()+ " " + rol.getNombCategoria());
//            }
//			         System.out.println("GET ONE");
//            int idTUsuario = 1;
//            Categoria rol = App.CategoriaDAO.get(idTUsuario);
//            if (rol.getIdCategoria()!= 0) {
//                System.out.println(rol.getIdCategoria()+ " " + rol.getNombCategoria());
//            }
//            System.out.println("INSERT");
//            Categoria rol = new Categoria();
//            rol.setNombCategoria("ADMIN");
//            App.CategoriaDAO.insert(rol);
//                    System.out.println("UPDATE");
//            Categoria rol = new Categoria();
//            rol.setIdCategoria(4);
//            rol.setNombCategoria("Estudiante");
//            System.out.println(App.CategoriaDAO.update(rol));
//                      System.out.println("DELETE");
//                      App.CategoriaDAO.delete(4);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
