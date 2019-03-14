/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Ciudad;
import entity.EstadoCivil;
import entity.InfoPreguntas;
import entity.Persona;
import entity.TipoDocumento;
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
public class PersonaDAO {

    private PreparedStatement psSelectAll;
    private PreparedStatement psSelect;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psDelete;

    private DataBase db;

    public PersonaDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public ArrayList<Persona> getAll() {
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        try {

            if (psSelectAll == null) {
                psSelectAll = db.PreparedQuery(
                        "SELECT NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, DOCUMENTO, TIPODOCUMENTO, "
                        + "EXP_CIUDAD, DIRECCION, BARRIO, RES_CIUDAD, "
                        + "TELEFONO, EMAIL, DIRECCION_OFIC, OFIC_CIUDAD, TELEFONO_OFIC, FAX_OFIC, CELULAR_OFIC,"
                        + "FECHA_NACIMIENTO, CIUDAD_NACIMIENTO, ESTADO_CIVIL, "
                        + "ESTRATO, ID_PREGUNTAS FROM persona"
                );
            }
            ResultSet result = db.ExecuteQuery(psSelectAll);
            while (result.next()) {
                Persona persona = new Persona();
                persona.setNombre1(result.getString("NOMBRE1"));
                persona.setNombre2(result.getString("NOMBRE2"));
                persona.setApellido1(result.getString("APELLIDO1"));
                persona.setApellido2(result.getString("APELLIDO2"));
                persona.setDocumento(result.getInt("DOCUMENTO"));
                persona.setTipodocumento(new TipoDocumento(result.getInt("TIPODOCUMENTO")));
                persona.setExpCiudad(new Ciudad(result.getInt("EXP_CIUDAD")));
                persona.setDireccion(result.getString("DIRECCION"));
                persona.setBarrio(result.getString("BARRIO"));
                persona.setResCiudad(new Ciudad(result.getInt("RES_CIUDAD")));
                persona.setTelefono(result.getString("TELEFONO"));
                persona.setEmail(result.getString("EMAIL"));
                persona.setDireccionOfic(result.getString("DIRECCION_OFIC"));
                persona.setOficCiudad(new Ciudad(result.getInt("OFIC_CIUDAD")));
                persona.setTelefonoOfic(result.getString("TELEFONO_OFIC"));
                persona.setFaxOfic(result.getString("FAX_OFIC"));
                persona.setCelularOfic(result.getString("CELULAR_OFIC"));
                persona.setFechaNacimiento(result.getDate("FECHA_NACIMIENTO"));
                persona.setCiudadNacimiento(new Ciudad(result.getInt("CIUDAD_NACIMIENTO")));
                persona.setEstadoCivil(new EstadoCivil(result.getInt("ESTADO_CIVIL")));
                persona.setEstrato(result.getString("ESTRATO"));
                persona.setIdPreguntas(new InfoPreguntas(result.getInt("INFO_PREGUNTAS")));

                listaPersonas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar consulta.", e);
        }
        return listaPersonas;
    }

    public Persona get(int documento) {
        Persona persona = new Persona();
        ResultSet result = null;
        try {

            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "SELECT NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, DOCUMENTO, TIPODOCUMENTO, "
                        + "EXP_CIUDAD, DIRECCION, BARRIO, RES_CIUDAD, "
                        + "TELEFONO, EMAIL, DIRECCION_OFIC, OFIC_CIUDAD, TELEFONO_OFIC, FAX_OFIC, CELULAR_OFIC, "
                        + "FECHA_NACIMIENTO, CIUDAD_NACIMIENTO, SEXO, ESTADO_CIVIL, "
                        + "ESTRATO, ID_PREGUNTAS FROM persona WHERE DOCUMENTO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(documento);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                persona.setNombre1(result.getString("NOMBRE1"));
                persona.setNombre2(result.getString("NOMBRE2"));
                persona.setApellido1(result.getString("APELLIDO1"));
                persona.setApellido2(result.getString("APELLIDO2"));
                persona.setDocumento(result.getInt("DOCUMENTO"));
                persona.setTipodocumento((new TipoDocumentoDAO()).get(result.getInt("TIPODOCUMENTO")));
                persona.setExpCiudad((new CiudadDAO()).get(result.getInt("EXP_CIUDAD")));
                persona.setDireccion(result.getString("DIRECCION"));
                persona.setBarrio(result.getString("BARRIO"));
                persona.setResCiudad((new CiudadDAO()).get(result.getInt("RES_CIUDAD")));
                persona.setTelefono(result.getString("TELEFONO"));
                persona.setEmail(result.getString("EMAIL"));
                persona.setDireccionOfic(result.getString("DIRECCION_OFIC"));
                persona.setOficCiudad((new CiudadDAO()).get(result.getInt("OFIC_CIUDAD")));
                persona.setTelefonoOfic(result.getString("TELEFONO_OFIC"));
                persona.setFaxOfic(result.getString("FAX_OFIC"));
                persona.setCelularOfic(result.getString("CELULAR_OFIC"));
                persona.setFechaNacimiento(result.getDate("FECHA_NACIMIENTO"));
                persona.setCiudadNacimiento((new CiudadDAO()).get(result.getInt("CIUDAD_NACIMIENTO")));
                persona.setSexo(result.getString("SEXO"));
                persona.setEstadoCivil((new EstadoCivilDAO()).get(result.getInt("ESTADO_CIVIL")));
                persona.setEstrato(result.getString("ESTRATO"));
                persona.setIdPreguntas((new InfoPreguntasDAO()).get(result.getInt("INFO_PREGUNTAS")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar consulta.", e);
        }
        return persona;
    }

    public long insert(Persona persona) {
        long result;
        try {
            String columns = "NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, DOCUMENTO, TIPODOCUMENTO, "
                    + "EXP_CIUDAD, DIRECCION, BARRIO, RES_CIUDAD, "
                    + "TELEFONO, EMAIL, DIRECCION_OFIC, OFIC_CIUDAD, TELEFONO_OFIC, FAX_OFIC, CELULAR_OFIC, "
                    + "FECHA_NACIMIENTO, CIUDAD_NACIMIENTO, SEXO,ESTADO_CIVIL, "
                    + "ESTRATO, ID_PREGUNTAS";
            String values = "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO PERSONA(" + columns + ") VALUES(" + values + ")",
                        "DOCUMENTO"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(persona.getNombre1());
            inputs.add(persona.getNombre2());
            inputs.add(persona.getApellido1());
            inputs.add(persona.getApellido2());
            inputs.add(persona.getDocumento());
            inputs.add(persona.getTipodocumento().getIdDocumento());
            inputs.add(persona.getExpCiudad().getIdCiudad());
            inputs.add(persona.getDireccion());
            inputs.add(persona.getBarrio());
            inputs.add(persona.getResCiudad().getIdCiudad());
            inputs.add(persona.getTelefono());
            inputs.add(persona.getEmail());
            inputs.add(persona.getDireccionOfic());
            inputs.add(persona.getOficCiudad().getIdCiudad());
            inputs.add(persona.getTelefonoOfic());
            inputs.add(persona.getFaxOfic());
            inputs.add(persona.getCelularOfic());
            inputs.add(persona.getFechaNacimiento());
            inputs.add(persona.getCiudadNacimiento().getIdCiudad());
            inputs.add(persona.getSexo());
            inputs.add(persona.getEstadoCivil().getId());
            inputs.add(persona.getEstrato());
            inputs.add(persona.getIdPreguntas().getIdPreguntas());
            result = db.ExecuteUpdate(psInsert, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        }
        return result;
    }

    public long update(Persona persona) {
        long result;
        try {
            String columns = "";
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (persona.getNombre1() != null) {
                columns += ",NOMBRE1=?";
                inputs.add(persona.getNombre1());
            }
            if (persona.getNombre2() != null) {
                columns += ",NOMBRE2=?";
                inputs.add(persona.getNombre2());
            }
            if (persona.getApellido1() != null) {
                columns += ",APELLIDO1=?";
                inputs.add(persona.getApellido1());
            }
            if (persona.getApellido2() != null) {
                columns += ",APELLIDO2=?";
                inputs.add(persona.getApellido2());
            }
            if (persona.getTipodocumento() != null) {
                columns += ",TIPODOCUMENTO=?";
                inputs.add(persona.getTipodocumento().getIdDocumento());
            }
            if (persona.getExpCiudad() != null) {
                columns += ",EXP_CIUDAD=?";
                inputs.add(persona.getExpCiudad().getIdCiudad());
            }
            if (persona.getDireccion() != null) {
                columns += ",DIRECCION=?";
                inputs.add(persona.getDireccion());
            }
            if (persona.getBarrio() != null) {
                columns += ",BARRIO=?";
                inputs.add(persona.getBarrio());
            }
            if (persona.getResCiudad() != null) {
                columns += ",RES_CIUDAD=?";
                inputs.add(persona.getResCiudad().getIdCiudad());
            }
            if (persona.getTelefono() != null) {
                columns += ",TELEFONO=?";
                inputs.add(persona.getTelefono());
            }
            if (persona.getEmail() != null) {
                columns += ",EMAIL=?";
                inputs.add(persona.getEmail());
            }
            if (persona.getDireccionOfic() != null) {
                columns += ",DIRECCION_OFIC=?";
                inputs.add(persona.getDireccionOfic());
            }
            if (persona.getOficCiudad() != null) {
                columns += ",OFIC_CIUDAD=?";
                inputs.add(persona.getOficCiudad().getIdCiudad());
            }
            if (persona.getTelefonoOfic() != null) {
                columns += ",TELEFONO_OFIC=?";
                inputs.add(persona.getTelefonoOfic());
            }
            if (persona.getFaxOfic()!= null) {
                columns += ",FAX_OFIC=?";
                inputs.add(persona.getFaxOfic());
            }
            if (persona.getCelularOfic()!= null) {
                columns += ",CELULAR_OFIC=?";
                inputs.add(persona.getCelularOfic());
            }
            if (persona.getFechaNacimiento() != null) {
                columns += ",FECHA_NACIMIENTO=?";
                inputs.add(persona.getFechaNacimiento());
            }
            if (persona.getCiudadNacimiento() != null) {
                columns += ",CIUDAD_NACIMIENTO=?";
                inputs.add(persona.getCiudadNacimiento().getIdCiudad());
            }
            if (persona.getSexo() != null) {
                columns += ",SEXO=?";
                inputs.add(persona.getSexo());
            }
            if (persona.getEstadoCivil() != null) {
                columns += ",ESTADO_CIVIL=?";
                inputs.add(persona.getEstadoCivil().getId());
            }
            if (persona.getEstrato() != null) {
                columns += ",ESTRATO=?";
                inputs.add(persona.getEstrato());
            }
            if (persona.getIdPreguntas() != null) {
                columns += ",ID_PREGUNTAS=?";
                inputs.add(persona.getIdPreguntas().getIdPreguntas());
            }

            inputs.add(persona.getDocumento());
            columns = columns.substring(1);
            psUpdate = db.PreparedUpdate(
                    "UPDATE persona SET " + columns + " WHERE DOCUMENTO=? "
            );

            result = db.ExecuteUpdate(psUpdate, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar actualización.", e);
        }
        return result;
    }

    public long delete(int documento) {
        long result;
        try {
            if (psDelete == null) {
                psDelete = db.PreparedUpdate(
                        "DELETE FROM persona "
                        + "WHERE DOCUMENTO=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(documento);
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
//            ArrayList<Persona> lista = App.PersonaDAO.getAll();
//            for (Persona persona : lista) {
//                System.out.println(
//                        persona.getNombre1() + ", "
//                        + persona.getNombre2() + ", "
//                        + persona.getApellido1() + ", "
//                        + persona.getApellido2() + ", "
//                        + persona.getDocumento() + ", "
//                        + persona.getTipodocumento().getIdDocumento() + ", "
//                        + persona.getExpCiudad().getIdCiudad() + ", "
//                        + persona.getDireccion() + ", "
//                        + persona.getBarrio() + ", "
//                        + persona.getResCiudad().getIdCiudad() + ", "
//                        + persona.getTelefono() + ", "
//                        + persona.getEmail() + ", "
//                        + persona.getDireccionOfic() + ", "
//                        + persona.getOficCiudad().getIdCiudad() + ", "
//                        + persona.getTelefonoOfic() + ", "
//                        + persona.getFechaNacimiento() + ", "
//                        + persona.getCiudadNacimiento().getIdCiudad() + ", "
//                        + persona.getSexo() + ", "
//                        + persona.getEstadoCivil().getId() + ", "
//                        + persona.getEstrato() + ", "
//                        + persona.getInfoPreguntas().getIdPreguntas()
//                );
//            }
//            System.out.println("GET ONE");
//            int documento = 123;
//            Persona persona = App.PersonaDAO.get(documento);
//            if (persona.getDocumento() != 0) {
//                System.out.println(
//                        persona.getNombre1() + ", "
//                        + persona.getNombre2() + ", "
//                        + persona.getApellido1() + ", "
//                        + persona.getApellido2() + ", "
//                        + persona.getDocumento() + ", "
//                        + persona.getTipodocumento().getIdDocumento() + ", "
//                        + persona.getExpCiudad().getIdCiudad() + ", "
//                        + persona.getDireccion() + ", "
//                        + persona.getBarrio() + ", "
//                        + persona.getResCiudad().getIdCiudad() + ", "
//                        + persona.getTelefono() + ", "
//                        + persona.getEmail() + ", "
//                        + persona.getDireccionOfic() + ", "
//                        + persona.getOficCiudad().getIdCiudad() + ", "
//                        + persona.getTelefonoOfic() + ", "
//                        + persona.getFechaNacimiento() + ", "
//                        + persona.getCiudadNacimiento().getIdCiudad() + ", "
//                        + persona.getSexo() + ", "
//                        + persona.getEstadoCivil().getId() + ", "
//                        + persona.getEstrato() + ", "
//                        + persona.getInfoPreguntas().getIdPreguntas()
//                );
//            }
//            System.out.println("INSERT");
//            Persona persona = new Persona();
//            persona.setNombre1("sdf");
//            persona.setNombre2("asd");
//            persona.setApellido1("asd");
//            persona.setApellido2("asd");
//            persona.setDocumento(1);
//            persona.setTipodocumento(new TipoDocumento(1));
//            persona.setExpCiudad(new Ciudad(1));
//            persona.setDireccion("asd");
//            persona.setBarrio("asd");
//            persona.setResCiudad(new Ciudad(1));
//            persona.setTelefono("654");
//            persona.setEmail("asd");
//            persona.setDireccionOfic("asd");
//            persona.setOficCiudad(new Ciudad(1));
//            persona.setTelefonoOfic("654");
//            persona.setFechaNacimiento(Date.valueOf("2018-01-01"));
//            persona.setCiudadNacimiento(new Ciudad(1));
//            persona.setSexo("m");
//            persona.setEstadoCivil(new EstadoCivil(1));
//            persona.setEstrato("1");
//            persona.setInfoPreguntas(new InfoPreguntas(1));
//            App.PersonaDAO.insert(persona);
//            System.out.println("UPDATE");
//            Persona persona = new Persona();
//            persona.setDocumento(1);
//            persona.setNombre2("Alex");
//            System.out.println(App.PersonaDAO.update(persona));
//            System.out.println("DELETE");
//            App.RolDAO.delete(1);
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
