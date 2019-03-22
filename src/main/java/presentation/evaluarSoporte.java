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
                            listaPathsNames[3] = xn;
                            listaPathsNamestmp[3] = soporte.getNombreTmp();
                            System.out.println("soporte PREGRADO--> " + soporte.getNombreTmp());
                        }

                        if (soporte.getNombreSoporte().equals("RESOLUCION")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[4] = xn;
                            listaPathsNamestmp[4] = soporte.getNombreTmp();
                            System.out.println("soporte RESOLUCION--> " + soporte.getNombreTmp());
                        }

                        if (soporte.getNombreSoporte().equals("CEDULA")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[5] = xn;
                            listaPathsNamestmp[5] = soporte.getNombreTmp();
                            System.out.println("soporte CEDULA--> " + soporte.getNombreTmp());
                        }

                        if (soporte.getNombreSoporte().equals("EPS")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[6] = xn;
                            listaPathsNamestmp[6] = soporte.getNombreTmp();
                            System.out.println("soporte EPS--> " + soporte.getNombreTmp());
                        }

                        if (soporte.getNombreSoporte().equals("EGRESADO")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[7] = xn;
                            listaPathsNamestmp[7] = soporte.getNombreTmp();
                            System.out.println("soporte CARNETEGRESADO--> " + soporte.getNombreTmp());
                        }
                        
                        if (soporte.getNombreSoporte().equals("VOTACION")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[8] = xn;
                            listaPathsNamestmp[8] = soporte.getNombreTmp();
                            System.out.println("soporte CERTIFICADOVOTACION--> "+soporte.getNombreTmp());
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
            HttpSession sesion = request.getSession();
            int user = Integer.parseInt(String.valueOf(sesion.getAttribute("actual")));
            InfoPreguntas info = App.PreguntasDAO.get(user);
            info.setComentarioSoporte(request.getParameter("notas2"));
            System.out.println(info.getComentarioSoporte() + " - " + info.getComentarios());
            if (info.getComentarioSoporte() == "") {
                if (info.getComentarios() == null) {
                    info.setEstado("Aprobado");
                } else {
                    info.setEstado("No aprobado");
                }
            } else {
                info.setEstado("No aprobado");
            }
            info.setValidacionPreguntas("Evaluado");
            info.setFechaLectura(Date.valueOf(LocalDate.now()));
            
            App.PreguntasDAO.update(info);

            response.sendRedirect("Admin");//"+info.getIdPreguntas());
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            //Cierra conexiÃƒÂ³n 
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
