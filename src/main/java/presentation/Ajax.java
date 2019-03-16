/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.Ciudad;
import entity.Departamento;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Ajax", urlPatterns = {"/Ajax"})
public class Ajax extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Ajax() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/vnd.wap.xhtml+xml");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        processAjax(request, response.getWriter(), request.getParameter("value"), response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/vnd.wap.xhtml+xml");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        processAjax(request, response.getWriter(), request.getParameter("value"), response);
    }

    protected void processAjax(HttpServletRequest request, PrintWriter out, String value, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //BLOQUE DE CODIGO: formulario para traer los departamentos segun la ciudad
        if (value.equalsIgnoreCase("FormularioDept")) {
            try {
                App.OpenConnection();
//                System.out.println(request.getParameter("content")+" estooo");          
                int pais = Integer.parseInt(request.getParameter("content"));
                ArrayList<Departamento> listaDepartamentos = App.DepartamentoDAO.getByPais(pais);

                //HTML
                out.println("<option selected value=''>Seleccione el Departamento</option> ");
                if (listaDepartamentos != null) {
                    for (Departamento dep : listaDepartamentos) {
                        out.println("<option value='" + dep.getIdDpto() + "' >" + dep.getNombreDpto() + "</option> ");
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException("Se ha generado un error inesperado", e);
            } finally {
                App.CloseConnection();
            }
        }
        //FIN BLOQUE DE CODIGO: formulario

        //BLOQUE DE CODIGO: formulario para traer las ciudades segun el departamento
        if (value.equalsIgnoreCase("FormularioCiudad")) {
            try {
                App.OpenConnection();
//                System.out.println(request.getParameter("content") + " <------");
                int depart = Integer.parseInt(request.getParameter("content"));
                ArrayList<Ciudad> listaCiudad = App.CiudadDAO.getByDepart(depart);

                //HTML
                    out.println("<option selected value='' >Seleccione la Ciudad</option>");
                if (listaCiudad != null) {
                    for (Ciudad cuidad : listaCiudad) {
                        out.println("<option value='" + cuidad.getIdCiudad() + "' >" + cuidad.getNombreCiudad() + "</option> ");
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException("Se ha generado un error inesperado", e);
            } finally {
                App.CloseConnection();
            }
        }
        //FIN BLOQUE DE CODIGO: formulario

    }
}
