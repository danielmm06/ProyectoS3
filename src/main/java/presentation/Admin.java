/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.InfoPreguntas;
import entity.Persona;
import entity.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistence.UsuariosDAO;

/**
 *
 * @author niari
 */
@WebServlet(name = "Admin", urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {
    
    public Admin() {
        super();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {// I
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
            // Acciones, Envío de parametros y Redirección
            if (sesionValida) {
                if (permisoValido) {
                    request.setCharacterEncoding("UTF-8");
                    request.setAttribute("title", App.nameProyect + " - Admin");

                    ArrayList<Persona> lista = App.PersonaDAO.getAll();
                    ArrayList<InfoPreguntas> preguntas = App.PreguntasDAO.getAll();
                    ArrayList<String> formulario = new ArrayList<String>();
                    int cont = 0;
                    for (Iterator<Persona> iterator = lista.iterator(); iterator.hasNext();) {
                        Persona next = iterator.next();
                        formulario.add(next.getDocumento() + "");
                        formulario.add(next.getNombre1() + " " + next.getNombre2() + " " + next.getApellido1() + " " + next.getApellido2());
                        formulario.add(preguntas.get(cont).getValidacionPreguntas());
                        formulario.add(preguntas.get(cont).getEstado());
                        cont++;
                    }
                    request.setAttribute("formulario", formulario);

//                        ArrayList<Persona> listaPersonas = App.PersonaDAO.getAll();
//                        //----------------------------------------------------------
//                        request.setAttribute("listaPersonas", listaPersonas);
                    getServletConfig().getServletContext().getRequestDispatcher("/views/listado.jsp").forward(request, response);
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            //Cierra conexión 
//            App.CloseConnection();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
