/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Rol;
import entity.Usuarios;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Daniel
 */
public class UsuariosDAO {

    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public UsuariosDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<Usuarios> getAll() throws SQLException {
        ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
        PreparedStatement psSelectAll = null;
        ResultSet result = null;
        try {
            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_USUARIO, CONTRASENA, ID_ROL "
                        + "FROM USUARIOS"
                );
            }
            result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdUsuario(result.getInt("ID_USUARIO"));
                usuarios.setContrasena(result.getString("CONTRASENA"));
                Rol rol = new Rol();
                rol.setIdTUsuario(result.getInt("ID_ROL"));
                usuarios.setIdRol(rol);

                listaUsuarios.add(usuarios);
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
        return listaUsuarios;
    }

    public Usuarios get(int idUsuario) {
        Usuarios usuarios = new Usuarios();
        PreparedStatement psSelect = null;
        ResultSet result = null;
        try {
            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_USUARIO, CONTRASENA, ID_ROL FROM USUARIOS WHERE ID_USUARIO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idUsuario);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                usuarios.setIdUsuario(result.getInt("ID_USUARIO"));
                usuarios.setContrasena(result.getString("CONTRASENA"));
                usuarios.setIdRol((new RolDAO()).get(result.getInt("ID_ROL"))); /////////////////////////////////////////////////////
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
        return usuarios;
    }
    

    public long insert(Usuarios usuarios) {
        long result;
        try {
            String columns = "ID_USUARIO,CONTRASENA,ID_ROL ";
            String values = "?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO USUARIOS(" + columns + ") VALUES(" + values + ")", "ID_USUARIO"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            if (usuarios.getIdUsuario() != null) {
                inputs.add(usuarios.getIdUsuario());
            } else {
                inputs.add(null);
            }
            if (usuarios.getContrasena() != null) {
                inputs.add(App.MD5(usuarios.getContrasena()+App.SECRET_PASS)); 
//                inputs.add(DigestUtils.md5Hex(usuarios.getContrasena())); //agrega contraseña encriptada
            } else {
                inputs.add(null);
            }
            if (usuarios.getIdRol() != null) {
                inputs.add(usuarios.getIdRol().getIdTUsuario());
            } else {
                inputs.add(null);
            }

            result = db.ExecuteUpdate(psInsert, inputs);

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        }
        return result;
    }

    public long update(Usuarios usuarios) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (usuarios.getContrasena() != null) {
                columns += ",CONTRASENA=?";
                inputs.add(App.MD5(usuarios.getContrasena()+App.SECRET_PASS)); 
//                inputs.add(DigestUtils.md5Hex(usuarios.getContrasena()));
            }
            if (usuarios.getIdRol() != null) {
                columns += ",ID_ROL=?";
                inputs.add(usuarios.getIdRol().getIdTUsuario());
            }

            inputs.add(usuarios.getIdUsuario());
            columns = columns.substring(1);

            if (psUpdate == null) {
                psUpdate = db.PreparedUpdate(
                        "UPDATE USUARIOS SET " + columns + " WHERE ID_USUARIO=?"
                );
            }
            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        }
        return result;
    }

    public long delete(Integer IdUsuario) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM USUARIOS "
                        + "WHERE ID_USUARIO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(IdUsuario);
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
//            ArrayList<Usuarios> listaUsuarios = App.UsuariosDAO.getAll();
//            for (Usuarios listaUsuario : listaUsuarios) {
//                System.out.println(listaUsuario.getIdUsuario() + " " + listaUsuario.getContrasena()+" "+listaUsuario.getIdRol().getIdTUsuario());
//            }
//			System.out.println("GET ONE");
//			int idUsuario = 1120654554;			
//			Usuarios usuarios = App.UsuariosDAO.get(idUsuario);
//			if(usuarios.getIdUsuario() != 0) {						
//				System.out.println(usuarios.getIdUsuario()+" "+usuarios.getContrasena()+" "+usuarios.getIdRol().getIdTUsuario());
//			}


//                        System.out.println("GET ONE");
//			String idUsuario = "1121";
////                        String contrasena = "daniel";
//			Usuarios usuarios = App.UsuariosDAO.getnombre(idUsuario);
//			if(usuarios.getIdUsuario() != 0) {						
//                            System.out.println(usuarios.getIdUsuario()+" "+usuarios.getContrasena());
//			}
//                        System.out.println("INSERT");				
//                        Usuarios usuarios = new Usuarios();
//                        usuarios.setIdUsuario(1121);
//                        usuarios.setContrasena("daniel");
//                        Rol rol = new RolDAO().get(1);
//                        usuarios.setIdRol(rol);
//                        App.UsuariosDAO.insert(usuarios);	
//                    
//                    System.out.println("UPDATE");				
//                    Usuarios usuarios = new Usuarios();
//                    usuarios.setIdUsuario(112166);
//                    usuarios.setContrasena("daniel3");
//                    Rol rol = new RolDAO().get(1);
//                    usuarios.setIdRol(rol);
//                    App.UsuariosDAO.update(usuarios);
//                    System.out.println(App.UsuariosDAO.update(usuarios));
//                      System.out.println("DELETE");
//                      App.UsuariosDAO.delete(1120654554);
//                      System.out.println(App.RolDAO.delete(1120654554));
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }

}
