/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Prueba", urlPatterns = {"/Prueba"})
public class Prueba extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    public Prueba() {
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
                        request.setAttribute("title", App.nameProyect+" - Descuento Individual"); 
                        
                        
                        ArrayList<Persona> listaPersonas = App.PersonaDAO.getAll();
                        //----------------------------------------------------------
                        request.setAttribute("listaPersonas", listaPersonas);
                        
                        getServletConfig().getServletContext().getRequestDispatcher("/views/prueba.jsp").forward(request,response);
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
            try {// Inicializa conexión con base de datos
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
//          boolean sesionValida = App.CheckSession(request.getSession());
//			boolean permisoValido = App.CheckPermits(request.getSession(), "INSCRIPCION_PREGRADO");
            // Acciones, Envío de parametros y Redirección
              
              
            if (sesionValida) {
                if (permisoValido) {
                	request.setCharacterEncoding("UTF-8");
			request.setAttribute("title", App.nameProyect+" - Descuento Individual"); 
            
            //linea de codigo para redireccionar
//                response.sendRedirect("SoportesIndividual");
		
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
    
}
