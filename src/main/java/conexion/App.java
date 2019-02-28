/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.IOException;

import persistence.*;

/**
 *
 * @author Daniel
 */
public class App {

    // Conexión base de datos
    public static final String HOST_DB = "localhost:3306"; // Host:Port DB
    public static final String NAME_DB = "preinscripcion"; // Name DB
    public static final String USER_DB = "root"; // User DB
    public static final String PASS_DB = ""; // Password DB

    // Parametros del sistema
    public static final String nameProyect = "Inscripción Especialización"; // Name Proyect

    // Manejador de Base de datos
    public static DataBase DB; // DB Handler
    public static boolean printSQL = false; // Printer SQL in DAO

    // Ubicaciones path
    public static String pathURL; // Url Web of Proyect
    public static String pathPC; // Local path of folder "Downloads"

    // --------- INSTANCIAS ---------//
    public static PersonaDAO PersonaDAO;
    public static UsuariosDAO UsuariosDAO;
    public static RolDAO RolDAO;
    public static PaisDAO PaisDAO;
    public static DepartamentoDAO DepartamentoDAO;
    public static CiudadDAO CiudadDAO;

    // Conectar con Base de Datos
    public static void OpenConnection() {
        DB = DataBase.CreateInstance();
        CreateInstancesDAO();
        DB.OpenConnection();
    }

    public static void CloseConnection() throws IOException {
        DB.CloseConnection();
    }

    public static void AutoCommit() {
        DB.AutoCommit();
    }

    public static void NoAutoCommit() {
        DB.NoAutoCommit();
    }

    public static void CreateInstancesDAO() {
        PersonaDAO = new PersonaDAO();
        UsuariosDAO = new UsuariosDAO();
        RolDAO = new RolDAO();
        PaisDAO = new PaisDAO();
        DepartamentoDAO = new DepartamentoDAO();
        CiudadDAO = new CiudadDAO();
    }

}
