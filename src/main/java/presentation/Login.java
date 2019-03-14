/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.Rol;
import entity.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.UsuariosDAO;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {// Inicializa conexión con base de datos
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
            // Acciones, Envío de parametros y Redirección
            if (sesionValida) {
                if (permisoValido) {
                    request.setCharacterEncoding("UTF-8");
                    request.setAttribute("title", App.nameProyect + " - Login");

//                        ArrayList<Persona> listaPersonas = App.PersonaDAO.getAll();
//                        //----------------------------------------------------------
//                        request.setAttribute("listaPersonas", listaPersonas);
                    getServletConfig().getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
//                          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Personas.jsp");
//                        request.getRequestDispatcher("/views/Personas.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Error?e=NotAuthorized");
                }
            } else {
                response.sendRedirect("Logout");
            }
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            // Cierra conexión
            App.CloseConnection();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Inicializa conexión con base de datos
            if (request.getParameter("name") == "") {
                App.OpenConnection();
                request.setCharacterEncoding("UTF-8");

                //Recolección de parametros
                String nickname = request.getParameter("Usuario");
                int id_nickname = Integer.parseInt(nickname);
                String password = request.getParameter("Contrasena");

                //Ejecución de consultas
                UsuariosDAO usuarioDAO = new UsuariosDAO();
                Usuarios usuario = usuarioDAO.get(id_nickname);

                //Procesamiento de la información
                boolean valido = App.AuthUser(usuario, password);
                System.out.println("valido--->" + valido);

                if (valido == true) {
                    response.sendRedirect("Formulario");
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }

        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            //Cierra conexión 
            App.CloseConnection();
        }
    }

}
