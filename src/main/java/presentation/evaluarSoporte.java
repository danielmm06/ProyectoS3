/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.InfoPreguntas;
import entity.Persona;
import entity.Soporte;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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
@WebServlet(name = "evaluarSoporte", urlPatterns = {"/evaluarSoporte"})
public class evaluarSoporte extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "C:/Users/" + System.getProperty("user.name") + "/Documents/soportes"; // PRUEBAS
    //private final String UPLOAD_DIRECTORY = "/home/pasantes/Documentos/soportes"; //SERVIDOR
    private final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private String[] listaPathsNames;
    private String[] listaPathsNamestmp;

    public evaluarSoporte() {
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
        try {
            /**
             * Inicializa conexiÃ³n con base de datos
             */
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
            /**
             * Acciones, EnvÃ­o de parametros y RedirecciÃ³n
             */
            if (sesionValida) {
                if (permisoValido) {
                    request.setCharacterEncoding("UTF-8");
//                    int documento = 123;
                    request.setAttribute("title", App.nameProyect + " - Soportes");

                    HttpSession session = request.getSession();
                    int documento = Integer.parseInt(String.valueOf(session.getAttribute("actual")));
                    Persona persona = App.PersonaDAO.get(documento);
                    listaPathsNames = new String[10]; // INICIALIZACION DE LISTA CON NUMERO DE SOPORTES A SUBIR
                    listaPathsNamestmp = new String[10]; // INICIALIZACION DE LISTA CON NUMERO DE SOPORTES A SUBIR

                    ArrayList<Soporte> listasoporte = App.SoporteDAO.getAllByAllPerson(documento);

                    for (Soporte soporte : listasoporte) {

                        if (soporte.getNombreSoporte().equals("DIPLOMA")) {

                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[2] = xn;
                            listaPathsNamestmp[2] = soporte.getNombreTmp();
                            System.out.println("soporte DIPLOMA--> " + soporte.getNombreTmp());

                        }

                        if (soporte.getNombreSoporte().equals("PAGO")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[0] = xn;
                            listaPathsNamestmp[0] = soporte.getNombreTmp();
                            System.out.println("soporte PAGO--> " + soporte.getNombreTmp());
                        }

                        if (soporte.getNombreSoporte().equals("FOTO")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[1] = xn;
                            listaPathsNamestmp[1] = soporte.getNombreTmp();
                            System.out.println("soporte foto--> " + soporte.getNombreTmp());

                        }
                        if (soporte.getNombreSoporte().equals("PREGRADO")) {

                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[1] = xn;
                            listaPathsNamestmp[1] = soporte.getNombreTmp();
                            System.out.println("soporte PREGRADO--> " + soporte.getNombreTmp());
                        }

                    }
                    Soporte soporte = App.SoporteDAO.getByPersona(documento);

                    InfoPreguntas preguntas = App.PreguntasDAO.get(documento);

                    request.setAttribute("pathDelete", UPLOAD_DIRECTORY);
                    request.setAttribute("listaPathsNamestmp", listaPathsNamestmp);
                    request.setAttribute("listaPathsNames", listaPathsNames);
                    request.setAttribute("listasoporte", listasoporte);
                    request.setAttribute("soporte", soporte);
                    request.setAttribute("persona", persona);
                    request.setAttribute("notas", preguntas.getComentarioSoporte());

                    getServletConfig().getServletContext().getRequestDispatcher("/views/evaluacionSoporte.jsp").forward(request, response);
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
            // Cierra conexiÃ³n
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
            HttpSession sesion = request.getSession();
            int user = Integer.parseInt(String.valueOf(sesion.getAttribute("actual")));
            InfoPreguntas info = App.PreguntasDAO.get(user);
            info.setComentarioSoporte(request.getParameter("notas2"));
            System.out.println(info.getComentarioSoporte() + " - " + info.getComentarios());
            if (info.getComentarioSoporte() == "") {
                if (info.getComentarios() == null) {
                    info.setValidacionPreguntas("Aprobado");
                } else {
                    info.setValidacionPreguntas("No aprobado");
                }
            } else {
                info.setValidacionPreguntas("No aprobado");
            }
            info.setEstado("Evaluado");
            info.setFechaLectura(Date.valueOf(LocalDate.now()));
            
            App.PreguntasDAO.update(info);

            response.sendRedirect("Admin");//"+info.getIdPreguntas());
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            //Cierra conexiÃ³n 
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
