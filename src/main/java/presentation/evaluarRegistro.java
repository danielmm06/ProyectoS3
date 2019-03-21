/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.Cabecera;
import entity.InfoIdiomas;
import entity.InfoPreguntas;
import entity.Pais;
import entity.Persona;
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

/**
 *
 * @author niari
 */
@WebServlet(name = "evaluarRegistro", urlPatterns = {"/evaluarRegistro"})
public class evaluarRegistro extends HttpServlet {

    public evaluarRegistro() {
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

                    ArrayList<Pais> listaPais = App.PaisDAO.getAll();
//                        //----------------------------------------------------------
                    request.setAttribute("listaPais", listaPais);

                    int user = Integer.parseInt(request.getParameter("doc")); //---------------------------------------
                    Persona persona = App.PersonaDAO.get(user);
                    if (persona.getDocumento() != null) {
                        InfoPreguntas preguntas = App.PreguntasDAO.get(persona.getDocumento());
                        Cabecera cabecera = App.CabeceraDAO.getByPreguntas(preguntas);

                        request.setAttribute("persona", persona);
                        request.setAttribute("preguntas", preguntas);
                        request.setAttribute("cabecera", cabecera);
                        request.setAttribute("academica", App.AcademicaDAO.getAllByPreguntas(preguntas));
                        request.setAttribute("laboral", App.LaboralDAO.getAllByPreguntas(preguntas));

                        ArrayList<String> formulario = new ArrayList<String>();
                        formulario.add(cabecera.getCategoria().getIdCategoria() + "");
                        formulario.add(persona.getTipodocumento().getIdDocumento() + "");
                        formulario.add(persona.getExpCiudad().getIdDpto().getIdPais().getIdPais() + "");
                        formulario.add(persona.getExpCiudad().getIdDpto().getIdDpto() + "");
                        formulario.add(persona.getExpCiudad().getIdCiudad() + "");
                        formulario.add(persona.getResCiudad().getIdDpto().getIdPais().getIdPais() + "");
                        formulario.add(persona.getResCiudad().getIdDpto().getIdDpto() + "");
                        formulario.add(persona.getResCiudad().getIdCiudad() + "");
                        formulario.add(persona.getOficCiudad().getIdDpto().getIdPais().getIdPais() + "");
                        formulario.add(persona.getOficCiudad().getIdDpto().getIdDpto() + "");
                        formulario.add(persona.getOficCiudad().getIdCiudad() + "");
                        formulario.add(persona.getFechaNacimiento().toString().split("-")[0]);
                        formulario.add(persona.getFechaNacimiento().toString().split("-")[1]);
                        formulario.add(persona.getFechaNacimiento().toString().split("-")[2]);
                        formulario.add(persona.getCiudadNacimiento().getIdDpto().getIdPais().getIdPais() + "");
                        formulario.add(persona.getCiudadNacimiento().getIdDpto().getIdDpto() + "");
                        formulario.add(persona.getCiudadNacimiento().getIdCiudad() + "");
                        formulario.add(persona.getSexo());
                        formulario.add(persona.getEstadoCivil().getId() + "");
                        formulario.add(persona.getEstrato());
                        formulario.add(preguntas.getTipoEmpresa());
                        formulario.add(preguntas.getEmpCiudad().getIdDpto().getIdPais().getIdPais() + "");
                        formulario.add(preguntas.getEmpCiudad().getIdDpto().getIdDpto() + "");
                        formulario.add(preguntas.getEmpCiudad().getIdCiudad() + "");
                        formulario.add(preguntas.getExistenciaPrograma());

                        ArrayList<InfoIdiomas> listIdiomas = App.IdiomasDAO.getAllByPreguntas(preguntas);
                        if (!listIdiomas.isEmpty()) {
                            for (Iterator<InfoIdiomas> ite = listIdiomas.iterator(); ite.hasNext();) {
                                InfoIdiomas idioma = ite.next();
                                formulario.add(idioma.getIdioma());
                                formulario.add(idioma.getComprende());
                                formulario.add(idioma.getHabla());
                                formulario.add(idioma.getEscribe());
                            }
                        }

                        formulario.add("finIdiomas");

                        formulario.add(preguntas.getEgresadoUnillanos());
                        formulario.add(preguntas.getComentarios());

//                        response.getWriter().print(formulario);
                        request.setAttribute("formulario", formulario);

                        getServletConfig().getServletContext().getRequestDispatcher("/views/evaluacionRegistro.jsp").forward(request, response);
//                          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Personas.jsp");
//                        request.getRequestDispatcher("/views/Personas.jsp").forward(request, response);
                    }
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
            App.OpenConnection();
            InfoPreguntas info = App.PreguntasDAO.get(Integer.parseInt(request.getParameter("Documento")));
            info.setComentarios(request.getParameter("notas"));
            HttpSession session = request.getSession();
            if (request.getParameter("notas").equalsIgnoreCase("")) {
                session.setAttribute("registro", true);
            } else {
                session.setAttribute("registro", false);
            }
            App.PreguntasDAO.update(info);

            response.sendRedirect("evaluarSoporte");//"+info.getIdPreguntas());
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            //Cierra conexión 
            App.CloseConnection();
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
