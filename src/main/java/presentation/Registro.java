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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Registro() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {// Inicializa conexión con base de datos
            App.OpenConnection();

            request.setCharacterEncoding("UTF-8");
            request.setAttribute("title", App.nameProyect + " - Registro");

//                        ArrayList<Persona> listaPersonas = App.PersonaDAO.getAll();
//                        //----------------------------------------------------------
//                        request.setAttribute("listaPersonas", listaPersonas);
            getServletConfig().getServletContext().getRequestDispatcher("/views/preregistro.jsp").forward(request, response);
//                          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Personas.jsp");
//                        request.getRequestDispatcher("/views/Personas.jsp").forward(request, response);

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
            String usuario = request.getParameter("Usuario");
            String clave = request.getParameter("Contrasena");
            if (clave.equals(request.getParameter("ConfirmContrasena"))) {
                Usuarios user = new Usuarios();
                user.setIdUsuario(Integer.parseInt(usuario));
                user.setContrasena(clave);
                user.setIdRol(new Rol(2));
                App.UsuariosDAO.insert(user);
                response.getWriter().print(true);
            } else {
                response.getWriter().print(false);
            }
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            // Cierra conexión
            App.CloseConnection();
        }
    }

}
