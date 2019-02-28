/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Ciudad;
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
public class InfoPreguntasDAO {

    private PreparedStatement psSelectAll;
    private PreparedStatement psSelect;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public InfoPreguntasDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<InfoPreguntas> getAll() {
        ArrayList<InfoPreguntas> listaInfoPreguntas = new ArrayList<InfoPreguntas>();
        try {

            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT ID_PREGUNTAS, EMPRESA, TIPO_EMPRESA, CARGO, EMP_DIRECCION, EMP_TELEFONO, "
                        + "EMP_CIUDAD, EXISTENCIA_PROGRAMA, EXPE_LABOR_FUNCIONES, RAZONES, "
                        + "FIN_PRESTAMO, FIN_AUX_EMPRESARIAL, FIN_REC_PROPIOS, FIN_BECA, EGRESADO_UNILLANOS, "
                        + "FECHA_FORMULARIO, FECHA_LECTURA, COMENTARIOS, "
                        + "VALIDACION_PREGUNTAS FROM info_preguntas"
                );
            }
            ResultSet result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                InfoPreguntas infoPreguntas = new InfoPreguntas();
                infoPreguntas.setIdPreguntas(result.getInt("ID_PREGUNTAS"));
                infoPreguntas.setEmpresa(result.getString("EMPRESA"));
                infoPreguntas.setTipoEmpresa(result.getString("TIPO_EMPRESA"));
                infoPreguntas.setCargo(result.getString("CARGO"));
                infoPreguntas.setEmpDireccion(result.getString("EMP_DIRECCION"));
                infoPreguntas.setEmpTelefono(result.getString("EMP_TELEFONO"));
                infoPreguntas.setEmpCiudad(new Ciudad(result.getInt("EMP_CIUDAD")));
                infoPreguntas.setExistenciaPrograma(result.getString("EXISTENCIA_PROGRAMA"));
                infoPreguntas.setExpeLaborFunciones(result.getString("EXPE_LABOR_FUNCIONES"));
                infoPreguntas.setRazones(result.getString("RAZONES"));
                infoPreguntas.setFinPrestamo(result.getString("FIN_PRESTAMO"));
                infoPreguntas.setFinAuxEmpresarial(result.getString("FIN_AUX_EMPRESARIAL"));
                infoPreguntas.setFinRecPropios(result.getString("FIN_REC_PROPIOS"));
                infoPreguntas.setFinBeca(result.getString("FIN_BECA"));
                infoPreguntas.setEgresadoUnillanos(result.getString("EGRESADO_UNILLANOS"));
                infoPreguntas.setFechaFormulario(result.getDate("FECHA_FORMULARIO"));
                infoPreguntas.setFechaLectura(result.getDate("FECHA_LECTURA"));
                infoPreguntas.setComentarios(result.getString("COMENTARIOS"));
                infoPreguntas.setValidacionPreguntas(result.getBytes("VALIDACION_PREGUNTAS"));

                listaInfoPreguntas.add(infoPreguntas);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar consulta.", e);
        }
        return listaInfoPreguntas;
    }

    public InfoPreguntas get(int idPreguntas) {
        InfoPreguntas infoPreguntas = new InfoPreguntas();
        ResultSet result = null;
        try {

            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT ID_PREGUNTAS, EMPRESA, TIPO_EMPRESA, CARGO, EMP_DIRECCION, EMP_TELEFONO, "
                        + "EMP_CIUDAD, EXISTENCIA_PROGRAMA, EXPE_LABOR_FUNCIONES, RAZONES, "
                        + "FIN_PRESTAMO, FIN_AUX_EMPRESARIAL, FIN_REC_PROPIOS, FIN_BECA, EGRESADO_UNILLANOS, "
                        + "FECHA_FORMULARIO, FECHA_LECTURA, COMENTARIOS, "
                        + "VALIDACION_PREGUNTAS FROM info_preguntas WHERE ID_PREGUNTAS=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idPreguntas);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                infoPreguntas.setIdPreguntas(result.getInt("ID_PREGUNTAS"));
                infoPreguntas.setEmpresa(result.getString("EMPRESA"));
                infoPreguntas.setTipoEmpresa(result.getString("TIPO_EMPRESA"));
                infoPreguntas.setCargo(result.getString("CARGO"));
                infoPreguntas.setEmpDireccion(result.getString("EMP_DIRECCION"));
                infoPreguntas.setEmpTelefono(result.getString("EMP_TELEFONO"));
                infoPreguntas.setEmpCiudad((new CiudadDAO()).get(result.getInt("EMP_CIUDAD")));
                infoPreguntas.setExistenciaPrograma(result.getString("EXISTENCIA_PROGRAMA"));
                infoPreguntas.setExpeLaborFunciones(result.getString("EXPE_LABOR_FUNCIONES"));
                infoPreguntas.setRazones(result.getString("RAZONES"));
                infoPreguntas.setFinPrestamo(result.getString("FIN_PRESTAMO"));
                infoPreguntas.setFinAuxEmpresarial(result.getString("FIN_AUX_EMPRESARIAL"));
                infoPreguntas.setFinRecPropios(result.getString("FIN_REC_PROPIOS"));
                infoPreguntas.setFinBeca(result.getString("FIN_BECA"));
                infoPreguntas.setEgresadoUnillanos(result.getString("EGRESADO_UNILLANOS"));
                infoPreguntas.setFechaFormulario(result.getDate("FECHA_FORMULARIO"));
                infoPreguntas.setFechaLectura(result.getDate("FECHA_LECTURA"));
                infoPreguntas.setComentarios(result.getString("COMENTARIOS"));
                infoPreguntas.setValidacionPreguntas(result.getBytes("VALIDACION_PREGUNTAS"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar consulta.", e);
        }
        return infoPreguntas;
    }

    public long insert(InfoPreguntas infoPreguntas) {
        long result;
        try {
            String columns = "EMPRESA, TIPO_EMPRESA, CARGO, EMP_DIRECCION, EMP_TELEFONO, "
                    + "EMP_CIUDAD, EXISTENCIA_PROGRAMA, EXPE_LABOR_FUNCIONES, RAZONES, "
                    + "FIN_PRESTAMO, FIN_AUX_EMPRESARIAL, FIN_REC_PROPIOS, FIN_BECA, EGRESADO_UNILLANOS, "
                    + "FECHA_FORMULARIO, FECHA_LECTURA, COMENTARIOS, "
                    + "VALIDACION_PREGUNTAS";
            String values = "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO info_preguntas(" + columns + ") VALUES(" + values + ")",
                        "ID_PREGUNTAS"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(infoPreguntas.getEmpresa());
            inputs.add(infoPreguntas.getTipoEmpresa());
            inputs.add(infoPreguntas.getCargo());
            inputs.add(infoPreguntas.getEmpDireccion());
            inputs.add(infoPreguntas.getEmpTelefono());
            inputs.add(infoPreguntas.getEmpCiudad());
            inputs.add(infoPreguntas.getExistenciaPrograma());
            inputs.add(infoPreguntas.getExpeLaborFunciones());
            inputs.add(infoPreguntas.getRazones());
            inputs.add(infoPreguntas.getFinPrestamo());
            inputs.add(infoPreguntas.getFinAuxEmpresarial());
            inputs.add(infoPreguntas.getFinRecPropios());
            inputs.add(infoPreguntas.getFinBeca());
            inputs.add(infoPreguntas.getEgresadoUnillanos());
            inputs.add(infoPreguntas.getFechaFormulario());
            inputs.add(infoPreguntas.getFechaLectura());
            inputs.add(infoPreguntas.getComentarios());
            inputs.add(infoPreguntas.getValidacionPreguntas());
            result = db.ExecuteUpdate(psInsert, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        }
        return result;
    }

    public long update(InfoPreguntas infoPreguntas) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (infoPreguntas.getEmpresa() != null) {
                columns += ",EMPRESA=?";
                inputs.add(infoPreguntas.getEmpresa());
            }
            if (infoPreguntas.getTipoEmpresa() != null) {
                columns += ",TIPO_EMPRESA=?";
                inputs.add(infoPreguntas.getTipoEmpresa());
            }
            if (infoPreguntas.getCargo() != null) {
                columns += ",CARGO=?";
                inputs.add(infoPreguntas.getCargo());
            }
            if (infoPreguntas.getEmpDireccion() != null) {
                columns += ",EMP_DIRECCION=?";
                inputs.add(infoPreguntas.getEmpDireccion());
            }
            if (infoPreguntas.getEmpTelefono() != null) {
                columns += ",EMP_TELEFONO=?";
                inputs.add(infoPreguntas.getEmpTelefono());
            }
            if (infoPreguntas.getEmpCiudad() != null) {
                columns += ",EMP_CIUDAD=?";
                inputs.add(infoPreguntas.getEmpCiudad().getIdCiudad());
            }
            if (infoPreguntas.getExistenciaPrograma() != null) {
                columns += ",EXISTENCIA_PROGRAMA=?";
                inputs.add(infoPreguntas.getExistenciaPrograma());
            }
            if (infoPreguntas.getExpeLaborFunciones() != null) {
                columns += ",EXPE_LABOR_FUNCIONES=?";
                inputs.add(infoPreguntas.getExpeLaborFunciones());
            }
            if (infoPreguntas.getRazones() != null) {
                columns += ",RAZONES=?";
                inputs.add(infoPreguntas.getRazones());
            }
            if (infoPreguntas.getFinPrestamo() != null) {
                columns += ",FIN_PRESTAMO=?";
                inputs.add(infoPreguntas.getFinPrestamo());
            }
            if (infoPreguntas.getFinAuxEmpresarial() != null) {
                columns += ",FIN_AUX_EMPRESARIAL=?";
                inputs.add(infoPreguntas.getFinAuxEmpresarial());
            }
            if (infoPreguntas.getFinRecPropios() != null) {
                columns += ",FIN_REC_PROPIOS=?";
                inputs.add(infoPreguntas.getFinRecPropios());
            }
            if (infoPreguntas.getFinBeca() != null) {
                columns += ",FIN_BECA=?";
                inputs.add(infoPreguntas.getFinBeca());
            }
            if (infoPreguntas.getEgresadoUnillanos() != null) {
                columns += ",EGRESADO_UNILLANOS=?";
                inputs.add(infoPreguntas.getEgresadoUnillanos());
            }
            if (infoPreguntas.getFechaFormulario() != null) {
                columns += ",FECHA_FORMULARIO=?";
                inputs.add(infoPreguntas.getFechaFormulario());
            }
            if (infoPreguntas.getFechaLectura() != null) {
                columns += ",FECHA_LECTURA=?";
                inputs.add(infoPreguntas.getFechaLectura());
            }
            if (infoPreguntas.getComentarios() != null) {
                columns += ",COMENTARIOS=?";
                inputs.add(infoPreguntas.getComentarios());
            }
            if (infoPreguntas.getValidacionPreguntas() != null) {
                columns += ",VALIDACION_PREGUNTAS=?";
                inputs.add(infoPreguntas.getValidacionPreguntas());
            }

            inputs.add(infoPreguntas.getIdPreguntas());
            columns = columns.substring(1);
            psUpdate = db.PreparedUpdate(
                    "UPDATE info_preguntas SET " + columns + " WHERE ID_PREGUNTAS=? "
            );

            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        }
        return result;
    }

    public long delete(int idPreguntas) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM info_preguntas "
                        + "WHERE ID_PREGUNTAS=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(idPreguntas);
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
//            ArrayList<Rol> listaRoles = App.RolDAO.getAll();
//            for (Rol rol : listaRoles) {
//                System.out.println(rol.getIdTUsuario() + " " + rol.getNombreTUsuario());
//            }
//			System.out.println("GET ONE");
//			int idTUsuario = 1121200;			
//			Rol rol = App.RolDAO.get(idTUsuario);
//			if(rol.getIdTUsuario() != 0) {						
//				System.out.println(rol.getIdTUsuario()+" "+rol.getNombreTUsuario());
//			}
//                        System.out.println("INSERT");				
//                        Rol rol = new Rol();
//                        rol.setNombreTUsuario("ADMIN");
//                        App.RolDAO.insert(rol);	
//                    System.out.println("UPDATE");				
//                    Rol rol = new Rol();
//                    rol.setIdTUsuario(1213);		
//                    rol.setNombreTUsuario("Estudiante");
//                    App.RolDAO.update(rol);		
//                    System.out.println(App.RolDAO.update(rol));
//                      System.out.println("DELETE");
//                      App.RolDAO.delete(1121200);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
