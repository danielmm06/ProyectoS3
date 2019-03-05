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
                        request.setAttribute("title", App.nameProyect+" - Login"); 
                        
                        
//                        ArrayList<Persona> listaPersonas = App.PersonaDAO.getAll();
//                        //----------------------------------------------------------
//                        request.setAttribute("listaPersonas", listaPersonas);
                        
                        getServletConfig().getServletContext().getRequestDispatcher("/views/login.jsp").forward(request,response);
//                          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Personas.jsp");
//                        request.getRequestDispatcher("/views/Personas.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Error?e=NotAuthorized");
                }
            } 
            else {
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
                App.OpenConnection();
                request.setCharacterEncoding("UTF-8");

                //Recolección de parametros
                String nickname = request.getParameter("Usuario");
                int id = Integer.parseInt(nickname);
                String password = request.getParameter("Contrasena");

                //Ejecución de consultas
                UsuariosDAO usuarioDAO = new UsuariosDAO();
                Usuarios usuario = usuarioDAO.get(id);

                //Procesamiento de la información
                boolean valido = false;
                if (request.getSession().getAttribute("SendForm").equals("true")) {
                        valido = App.AuthUser(usuario, password);
                        request.getSession().setAttribute("sendForm", "false");
                } 

//                //Acciones, Envío de parametros y Redirección
//                if (valido) {
//                        ArrayList<Rol> rolesUser = new ArrayList<Rol>();
//                        ArrayList<Participacion> listaParticipaciones = new ParticipacionDAO().getAllByPersona(usuario.getPersona().getCodPersona());
//                        for (Participacion participacion : listaParticipaciones) {
//                                rolesUser.add(participacion.getRol());
//                        }
//                        request.getSession().setAttribute("rolesUser", rolesUser);
//                        request.getSession().setAttribute("rolUser", null);
//
//                        boolean init = App.InitSession(usuario, request.getSession());
//                        if (init) {
//                                response.sendRedirect("Home");	
//                        } else {
//                                request.setAttribute("error", App.errorLogin); 
//                                request.setAttribute("nickname", nickname); 
//                                getServletConfig().getServletContext().getRequestDispatcher("/Login/login.jsp").forward(request,response);
//                        }
//                } else {
//                        request.setAttribute("error", App.errorLogin); 
//                        request.setAttribute("nickname", nickname); 
//                        getServletConfig().getServletContext().getRequestDispatcher("/Login/login.jsp").forward(request,response);
//                }
        } catch (Exception e) {
                throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
                //Cierra conexión 
                App.CloseConnection();
        }
    }  
    
}
