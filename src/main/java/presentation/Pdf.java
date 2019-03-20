/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Pdf", urlPatterns = {"/Pdf"})
public class Pdf extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String path = "C:/Users/" + System.getProperty("user.name") + "/Documents/"; //PRUEBAS
//	private static final String path = "/home/pasantes/Documentos/"; //SERVIDOR

    public Pdf() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file = request.getParameter("path");
        //File documento = new File(App.pathPC+"/Documents/"+file);
        File documento = new File(path + file);
        FileInputStream archivo = new FileInputStream(documento.getPath());
        int tamanoInput = archivo.available();
        byte[] datosPDF = new byte[tamanoInput];
        archivo.read(datosPDF, 0, tamanoInput);
        String[] tmp = file.split("/");
        String fileName = tmp[tmp.length - 1];
        if (fileName.substring(fileName.length() - 3, fileName.length()).equals("PNG") || fileName.substring(fileName.length() - 3, fileName.length()).equals("png")) {
            response.setHeader("Content-disposition", "inline; filename=" + fileName);
            response.setContentType("image/png");
            response.setContentLength(tamanoInput);
            response.getOutputStream().write(datosPDF);

        } else {
            if (fileName.substring(fileName.length() - 3, fileName.length()).equals("PDF") || fileName.substring(fileName.length() - 3, fileName.length()).equals("pdf")) {
                response.setHeader("Content-disposition", "inline; filename=" + fileName);
                response.setContentType("application/pdf");
                response.setContentLength(tamanoInput);
                response.getOutputStream().write(datosPDF);
            } else {
                if (fileName.substring(fileName.length() - 3, fileName.length()).equals("DOC") || fileName.substring(fileName.length() - 3, fileName.length()).equals("doc")) {
                    response.setHeader("Content-disposition", "inline; filename=" + fileName);
                    response.setContentType("application/msword");
                    response.setContentLength(tamanoInput);
                    response.getOutputStream().write(datosPDF);
                }

            }

        }

        //String[] extension = fileName.split("\\.");
//		System.out.println("toda la dir: "+fileName.substring(fileName.length()-3,fileName.length()));
//		String cadena="algo.png";
//		
//		System.out.println("asd"+cadena.length()+"cadena++"+cadena.substring(cadena.length()-3, cadena.length()));
        //System.out.println("extver"+extension[0]);
        archivo.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
