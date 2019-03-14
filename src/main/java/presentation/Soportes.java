/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Soportes", urlPatterns = {"/Soportes"})
public class Soportes extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "C:/Users/" + System.getProperty("user.name") + "/Documents/soportes"; // PRUEBAS
    //private final String UPLOAD_DIRECTORY = "/home/pasantes/Documentos/soportes"; //SERVIDOR
    private final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private String[] listaPathsNames;
    private String[] listaPathsNamestmp;

    public Soportes() {
        super();
    }

    /**
     * Metodo para enviar informacion a la vista (Registro.jsp)
     *
     * @param request. Este parametro permite el envio de informacion al jsp
     * @param response. Este parametro recibe los parámetros dados por el
     * usuario
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /**
             * Inicializa conexión con base de datos
             */
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
            /**
             * Acciones, Envío de parametros y Redirección
             */
            if (sesionValida) {
                if (permisoValido) {
                    request.setCharacterEncoding("UTF-8");
                    request.setAttribute("title", App.nameProyect + " - Soportes");

                    getServletConfig().getServletContext().getRequestDispatcher("/views/Soporte.jsp").forward(request, response);
//                          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Personas.jsp");
//                        request.getRequestDispatcher("/views/Personas.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Error?e=NotAuthorized");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            // Cierra conexión
            App.CloseConnection();
        }
    }

    /**
     * Metodo para obtener informacion de la vista (Registro.jsp)
     *
     * @param request. Este parametro permite el envio de informacion al jsp
     * @param response. Este parametro recibe los parámetros dados por el
     * usuario
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /**
             * Inicializa conexión con base de datos
             */
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
//            boolean sesionValida = App.CheckSession(request.getSession());
//            boolean permisoValido = App.CheckPermits(request.getSession(), "INSCRIPCION_PREGRADO");
            // Acciones, Envío de parametros y Redirección

            if (sesionValida) {
                if (permisoValido) {
                    request.setCharacterEncoding("UTF-8");
                    request.setAttribute("title", App.nameProyect + " - Soporte");
//            
//            //linea de codigo para redireccionar
//                response.sendRedirect("SoportesIndividual");

                } else {
                    response.sendRedirect("Error?e=NotAuthorized");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            // Cierra conexión
            App.CloseConnection();
        }
    }

}
