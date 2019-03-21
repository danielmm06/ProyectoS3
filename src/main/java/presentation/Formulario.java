/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.Cabecera;
import entity.Categoria;
import entity.Ciudad;
import entity.EstadoCivil;
import entity.InfoAcademica;
import entity.InfoIdiomas;
import entity.InfoLaboral;
import entity.InfoPreguntas;
import entity.Pais;
import entity.Persona;
import entity.TipoDocumento;
import entity.Usuarios;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
 * @author Daniel
 */
@WebServlet(name = "Formulario", urlPatterns = {"/Formulario"})
public class Formulario extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Formulario() {
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
                    request.setAttribute("title", App.nameProyect + " - Formulario");

                    ArrayList<Pais> listaPais = App.PaisDAO.getAll();
//                        //----------------------------------------------------------
                    request.setAttribute("listaPais", listaPais);

                    //int user = Integer.parseInt(request.getParameter("user"));
                    HttpSession session = request.getSession();//-----------------------------------------------------------------------------
                    int user = Integer.parseInt(String.valueOf(session.getAttribute("user")));//-----------------------------------------------------------------------------
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

//                        response.getWriter().print(formulario);
                        request.setAttribute("formulario", formulario);

//                        System.out.println(formulario);
                    }
                    getServletConfig().getServletContext().getRequestDispatcher("/views/Registro.jsp").forward(request, response);
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {// Inicializa conexión con base de datos
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
//            boolean sesionValida = App.CheckSession(request.getSession());
//            boolean permisoValido = App.CheckPermits(request.getSession(), "INSCRIPCION_PREGRADO");
            // Acciones, Envío de parametros y Redirección

            if (sesionValida) {
                if (permisoValido) {
                    request.setCharacterEncoding("UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    
                    int operation = 0;

                    Persona persona = new Persona();
                    persona.setNombre1(request.getParameter("Nombre1"));
                    persona.setNombre2(request.getParameter("Nombre2"));
                    persona.setApellido1(request.getParameter("Apellido1"));
                    persona.setApellido2(request.getParameter("Apellido2"));
                    persona.setDocumento(Integer.parseInt(request.getParameter("Documento")));
                    persona.setTipodocumento(new TipoDocumento(Integer.parseInt(request.getParameter("TipoDocumento"))));
                    persona.setExpCiudad(new Ciudad(Integer.parseInt(request.getParameter("ExpCiudad"))));
                    persona.setDireccion(request.getParameter("Direccion"));
                    persona.setBarrio(request.getParameter("Barrio"));
                    persona.setTelefono(request.getParameter("Celular"));
                    persona.setEmail(request.getParameter("Correo"));
                    persona.setResCiudad(new Ciudad(Integer.parseInt(request.getParameter("ResCiudad"))));
                    persona.setDireccionOfic(request.getParameter("OfiDireccion"));
                    persona.setTelefonoOfic(request.getParameter("OfiTelefono"));
                    persona.setFaxOfic(request.getParameter("Fax"));
                    persona.setCelularOfic(request.getParameter("OfiCelular"));
                    persona.setOficCiudad(new Ciudad(Integer.parseInt(request.getParameter("OfiCiudad"))));
                    persona.setFechaNacimiento(Date.valueOf(request.getParameter("ano") + "-" + request.getParameter("mes") + "-" + request.getParameter("dia")));
                    persona.setCiudadNacimiento(new Ciudad(Integer.parseInt(request.getParameter("NacCiudad"))));
                    persona.setSexo(request.getParameter("Sexo"));
                    persona.setEstadoCivil(new EstadoCivil(Integer.parseInt(request.getParameter("Estado"))));
                    persona.setEstrato(request.getParameter("Estrato"));

                    if (App.PersonaDAO.get(persona.getDocumento()).getDocumento() == null) {
                        App.PersonaDAO.insert(persona);
                        operation = 1;
                    } else {
                        App.PersonaDAO.update(persona);
                        operation = 2;
                    }

                    InfoPreguntas preguntas = new InfoPreguntas();
                    preguntas.setIdPreguntas(persona.getDocumento());
                    preguntas.setEmpresa(request.getParameter("Empresa"));
                    preguntas.setTipoEmpresa(request.getParameter("TipoEmpresa"));
                    preguntas.setCargo(request.getParameter("Cargo"));
                    preguntas.setEmpDireccion(request.getParameter("EmpDireccion"));
                    preguntas.setEmpTelefono(request.getParameter("EmpTelefono"));
                    preguntas.setEmpCiudad(new Ciudad(Integer.parseInt(request.getParameter("EmpCiudad"))));
                    if (!request.getParameter("Conocimiento").equals("Otros")) {
                        preguntas.setExistenciaPrograma(request.getParameter("Conocimiento"));
                    } else {
                        preguntas.setExistenciaPrograma(request.getParameter("Otrosok"));
                    }
                    preguntas.setExpeLaborFunciones(request.getParameter("funciones"));
                    preguntas.setRazones(request.getParameter("razones"));
                    preguntas.setFinPrestamo(request.getParameter("Prestamo"));
                    preguntas.setFinAuxEmpresarial(request.getParameter("AuxEmp"));
                    preguntas.setFinRecPropios(request.getParameter("Recursos"));
                    preguntas.setFinBeca(request.getParameter("Beca"));
                    preguntas.setEgresadoUnillanos(request.getParameter("Egresado"));
                    preguntas.setFechaFormulario(Date.valueOf(LocalDate.now()));

                    if (App.PreguntasDAO.get(preguntas.getIdPreguntas()).getIdPreguntas() == null) {
                        App.PreguntasDAO.insert(preguntas);
                    } else {
                        App.PreguntasDAO.update(preguntas);
                    }

                    Cabecera cabecera = new Cabecera();
                    cabecera.setCategoria(new Categoria(Integer.parseInt(request.getParameter("Categoria"))));
                    cabecera.setPrograma(request.getParameter("Programa"));
                    cabecera.setFacultad(request.getParameter("Facultad"));
                    cabecera.setIdPreguntas(preguntas);
                    cabecera.setIdCabecera(App.CabeceraDAO.getByPreguntas(preguntas).getIdCabecera());

                    if (cabecera.getIdCabecera() == null) {
                        App.CabeceraDAO.insert(cabecera);
                    } else {
                        App.CabeceraDAO.update(cabecera);
                    }
                    
                    App.IdiomasDAO.deleteByPreguntas(preguntas);

                    InfoIdiomas idiomas = new InfoIdiomas();
                    idiomas.setIdioma("Espanol");
                    idiomas.setComprende(request.getParameter("EspComprende"));
                    idiomas.setHabla(request.getParameter("EspHabla"));
                    idiomas.setEscribe(request.getParameter("EspEscribe"));
                    idiomas.setIdPreguntas(preguntas);

                    App.IdiomasDAO.insert(idiomas);

                    idiomas.setIdioma("Ingles");
                    idiomas.setComprende(request.getParameter("IngComprende"));
                    idiomas.setHabla(request.getParameter("IngHabla"));
                    idiomas.setEscribe(request.getParameter("IngEscribe"));
                    
                    App.IdiomasDAO.insert(idiomas);

                    idiomas.setIdioma("Frances");
                    idiomas.setComprende(request.getParameter("FranComprende"));
                    idiomas.setHabla(request.getParameter("FranHabla"));
                    idiomas.setEscribe(request.getParameter("FranEscribe"));
                    
                    App.IdiomasDAO.insert(idiomas);

                    if (request.getParameter("otroIdioma") != "") {
                        idiomas.setIdioma(request.getParameter("otroIdioma"));
                        idiomas.setComprende(request.getParameter("otroComprende"));
                        idiomas.setHabla(request.getParameter("otroHabla"));
                        idiomas.setEscribe(request.getParameter("otroEscribe"));
                        
                        App.IdiomasDAO.insert(idiomas);
                    }
                    
                    App.AcademicaDAO.deleteByPreguntas(preguntas);

                    InfoAcademica academica = new InfoAcademica();
                    academica.setIdPreguntas(preguntas);
                    for (int i = 1; i <= 4; i++) {
                        if (request.getParameter("a" + i + "1") != "") {
                            academica.setUniversidad(request.getParameter("a" + i + "1"));
                            academica.setPrograma(request.getParameter("a" + i + "2"));
                            academica.setTituloObtenido(request.getParameter("a" + i + "3"));
                            academica.setAno(request.getParameter("a" + i + "4"));

                            App.AcademicaDAO.insert(academica);
                        }
                    }
                    
                    App.LaboralDAO.deleteByPreguntas(preguntas);
                    
                    InfoLaboral laboral = new InfoLaboral();
                    laboral.setIdPreguntas(preguntas);
                    for (int i = 1; i <= 4; i++) {
                        if (request.getParameter("l" + i + "1") != "") {
                            laboral.setEmpresa(request.getParameter("l" + i + "1"));
                            laboral.setCargo(request.getParameter("l" + i + "2"));
                            laboral.setFechaInicio(Date.valueOf(request.getParameter("l" + i + "3")));
                            laboral.setFechaFin(Date.valueOf(request.getParameter("l" + i + "4")));

                            App.LaboralDAO.insert(laboral);
                        }
                    }

                    response.sendRedirect("Soportes?user="+persona.getDocumento());
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
