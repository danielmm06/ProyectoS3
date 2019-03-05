/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import entity.Usuarios;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import persistence.*;

/**
 *
 * @author Daniel
 */
public class App {

    // ConexiÃ³n base de datos
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
    
    // Clave secreta para el password
    public static final String SECRET_PASS = "3SP3C14L1Z4C10N"; // Password 
    
    // Mensajes de Error
    public static String errorLogin; // Error Login Message
    public static String errorSesion; // Error Old Session Message

    // --------- INSTANCIAS ---------//
    public static PersonaDAO PersonaDAO;
    public static UsuariosDAO UsuariosDAO;
    public static RolDAO RolDAO;
    public static PaisDAO PaisDAO;
    public static DepartamentoDAO DepartamentoDAO;
    public static CiudadDAO CiudadDAO;
    public static EstadoCivilDAO EstadoDAO;
    public static InfoPreguntasDAO PreguntasDAO;
    public static TipoDocumentoDAO DocumentoDAO;
    public static CategoriaDAO CategoriaDAO;
    public static CabeceraDAO CabeceraDAO;
    public static TipoSoporteDAO TSoporteDAO;
    public static SoporteDAO SoporteDAO;
    public static InfoAcademicaDAO AcademicaDAO;
    public static InfoIdiomasDAO IdiomasDAO;
    public static InfoLaboralDAO LaboralDAO;
    

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
        EstadoDAO = new EstadoCivilDAO();
        PreguntasDAO = new InfoPreguntasDAO();
        DocumentoDAO = new TipoDocumentoDAO();
        CategoriaDAO = new CategoriaDAO();
        CabeceraDAO = new CabeceraDAO();
        TSoporteDAO = new TipoSoporteDAO();
        SoporteDAO = new SoporteDAO();
        AcademicaDAO = new InfoAcademicaDAO();
        IdiomasDAO = new InfoIdiomasDAO();
        LaboralDAO = new InfoLaboralDAO();
    }
    
    // Validar Usuario
	public static boolean AuthUser(Usuarios usuario, String password) {

		
		boolean valido = false;
		if (usuario.getIdUsuario()!= null) {
			String passwordMD5 = App.MD5(password+App.SECRET_PASS);
			if (passwordMD5.equals(usuario.getContrasena())) {
			
			} else {
				errorLogin = "Usuario o contraseña equivocados";
			}
		} else {
			errorLogin = "Usuario no existe";
		}
		return valido;
	}
        
        
        // Cifrador MD5
	public static String MD5(String cadena) {
		String MD5 = "";
		try {
			MD5 = hash(cadena);
		} catch (Exception e) {
			throw new Error("Error al cifrar cadena");
		}
		return MD5;
	}

	private static String hash(String clear) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			byte[] b = md.digest(clear.getBytes());
			int size = b.length;
			StringBuffer h = new StringBuffer(size);
			for (int i = 0; i < size; i++) {
				int u = b[i] & 255;
				if (u < 16) {
					h.append("0" + Integer.toHexString(u));
				} else {
					h.append(Integer.toHexString(u));
				}
			}
			return h.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
