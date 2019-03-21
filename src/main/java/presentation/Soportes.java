/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.Persona;
import entity.Soporte;
import entity.TipoSoporte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Soportes", urlPatterns = {"/Soportes"})
public class Soportes extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "C:/Users/" + System.getProperty("user.name") + "/Documents/soportes"; // PRUEBAS
    //private final String UPLOAD_DIRECTORY = "/home/pasantes/Documentos/soportes"; //SERVIDOR
    private final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private String[] listaPathsNames;
    private String[] listaPathsNamestmp;

    public Soportes() {
        super();
    }

    /**
     * Metodo para enviar informacion a la vista (Registro.jsp)
     *
     * @param request. Este parametro permite el envio de informacion al jsp
     * @param response. Este parametro recibe los parámetros dados por el
     * usuario
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    int documento = Integer.parseInt(String.valueOf(session.getAttribute("user")));
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
                            System.out.println("soporte DIPLOMA--> "+soporte.getNombreTmp());

                        }

                        if (soporte.getNombreSoporte().equals("PAGO")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[0] = xn;
                            listaPathsNamestmp[0] = soporte.getNombreTmp();
                            System.out.println("soporte PAGO--> "+soporte.getNombreTmp());
                        }

                        if (soporte.getNombreSoporte().equals("FOTO")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[1] = xn;
                            listaPathsNamestmp[1] = soporte.getNombreTmp();
                            System.out.println("soporte foto--> "+soporte.getNombreTmp());

                        }
                        if (soporte.getNombreSoporte().equals("PREGRADO")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            listaPathsNames[1] = xn;
                            listaPathsNamestmp[1] = soporte.getNombreTmp();
                            System.out.println("soporte PREGRADO--> "+soporte.getNombreTmp());
                        }

                    }
                    Soporte soporte = App.SoporteDAO.getByPersona(documento);

                    request.setAttribute("pathDelete", UPLOAD_DIRECTORY);
                    request.setAttribute("listaPathsNamestmp", listaPathsNamestmp);
                    request.setAttribute("listaPathsNames", listaPathsNames);
                    request.setAttribute("listasoporte", listasoporte);
                    request.setAttribute("soporte", soporte);
                    request.setAttribute("persona", persona);

                    getServletConfig().getServletContext().getRequestDispatcher("/views/Soporte.jsp").forward(request, response);
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
     * Metodo para obtener informacion de la vista (Registro.jsp)
     *
     * @param request. Este parametro permite el envio de informacion al jsp
     * @param response. Este parametro recibe los parámetros dados por el
     * usuario
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /**
             * Inicializa conexión con base de datos
             */
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
//            boolean sesionValida = App.CheckSession(request.getSession());
//            boolean permisoValido = App.CheckPermits(request.getSession(), "INSCRIPCION_PREGRADO");
            // Acciones, Envío de parametros y Redirección

            if (sesionValida) {
                if (permisoValido) {
                    request.setCharacterEncoding("UTF-8");
                    request.setAttribute("title", App.nameProyect + " - Soporte");

//                    int codPersona = Integer.parseInt(request.getParameter("user"));
                    
                    HttpSession session = request.getSession();//-----------------------------------------------------------------------------
                    int codPersona = Integer.parseInt(String.valueOf(session.getAttribute("user")));//-----------------------------------------------------------------------------

                    Persona persona = App.PersonaDAO.get(codPersona);

                    ArrayList<Input> inputs = getInputsForm(request);
                    int posicionArrayName = 0;

                    int cont = 0;
                    for (Input input : inputs) {
                        if (input.type.equals("input")) {
                            if (input.value.equals("1")) {
                                request.setAttribute("goToStep", 1);
                            }
//                            if (input.value.equals("2")) {
//                                request.setAttribute("goToStep", 2);
//                            }
//                            if (input.value.equals("3")) {
//                                request.setAttribute("goToStep", 3);
//                            }
                            processInputs();
                        } else {

                            String filePath = processFiles(input.fileItem, codPersona + "", input.name, input.value);
                            String saveDB = savePathBD(codPersona + "", input.name, input.value);
                        }
                    }

                    ArrayList<Soporte> listasoporte = App.SoporteDAO.getAllByAllPerson(codPersona);
                    for (Soporte soporte : listasoporte) {
                    System.out.println("lista de soportes "+soporte.getNombreSoporte());

                        if (soporte.getNombreSoporte().equals("DIPLOMA")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            System.out.println(xn + "xn");
                            listaPathsNames[2] = xn;
                            listaPathsNamestmp[2] = soporte.getNombreTmp();
                            cont++;
                        }

                        if (soporte.getNombreSoporte().equals("PAGO")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
//                            System.out.println(xn + " xn");
                            listaPathsNames[0] = xn;
                            listaPathsNamestmp[0] = soporte.getNombreTmp();
                            System.out.println("soporte D "+soporte.getNombreTmp());
                            cont++;
                        }

                        if (soporte.getNombreSoporte().equals("FOTO")) {
                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            System.out.println(xn + "xn");
                            listaPathsNames[1] = xn;
                            listaPathsNamestmp[1] = soporte.getNombreTmp();
                            System.out.println("soporte foto "+soporte.getNombreTmp());
                            cont++;
                        }

                        if (soporte.getNombreSoporte().equals("PREGRADO")) {

                            String[] x = soporte.getUrlArchivo().split("soportes");
                            String xn = x[x.length - 1];
                            System.out.println("xn " +xn);
                            listaPathsNames[3] = xn;
                            listaPathsNamestmp[3] = soporte.getNombreTmp();
                            cont++;
                        }

                    }

                    Soporte soporte = App.SoporteDAO.getByPersona(codPersona);

                    request.setAttribute("pathDelete", UPLOAD_DIRECTORY);
                    request.setAttribute("listaPathsNamestmp", listaPathsNamestmp);
                    request.setAttribute("listaPathsNames", listaPathsNames);
                    request.setAttribute("listasoporte", listasoporte);
                    request.setAttribute("soporte", soporte);
                    request.setAttribute("persona", persona);

                    getServletConfig().getServletContext().getRequestDispatcher("/views/Soporte.jsp").forward(request, response);
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

    protected void processInputs() {
    }

    protected String savePathBD(String nameDir, String nombre, String nombtmp) {
        String filePath = "";
        try {
            ArrayList<Soporte> listasoporte = App.SoporteDAO.getAllByAllPerson((int) Long.parseLong(nameDir));
            String nameControl = nombre;
            String intControl = "";

            System.out.println("nombre "+nombre );

            if (nombre.equals("DIPLOMA")) {
                System.out.println("soporte nombre  ---> " + nombre);
                Soporte soporteAct = new Soporte();
                for (Soporte soporte : listasoporte) {
                    if (soporte.getNombreSoporte().equals(nombre)) {
                        String fileName = nameDir + nombre + ".pdf";
                        filePath = "soportes/" + nameDir + "/Inscripcion/" + fileName;
                        soporte.setUrlArchivo(filePath);
                        soporte.setNombreSoporte(nombre);
                        Persona persona = App.PersonaDAO.get((int) Long.parseLong(nameDir));
                        soporte.setIdPersona(persona);
                        TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(3);
                        soporte.setIdTiposoporte(tipoSoporte);
                        soporte.setNombreTmp(nombtmp);
                        soporteAct = soporte;
                        break;
                    }
                }
                if (soporteAct.getNombreSoporte() == null) {
                    System.out.println("soporte Act reg ---> " + soporteAct.getNombreSoporte());
                    String fileName = nameDir + nombre + ".pdf";
                    filePath = "soportes/" + nameDir + "/Inscripcion/" + fileName;
                    soporteAct.setUrlArchivo(filePath);
                    soporteAct.setNombreSoporte(nombre);
                    Persona persona = App.PersonaDAO.get((int) Long.parseLong(nameDir));
                    soporteAct.setIdPersona(persona);
                    TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(3);
                    soporteAct.setIdTiposoporte(tipoSoporte);
                    soporteAct.setNombreTmp(nombtmp);
                    App.SoporteDAO.insert(soporteAct);
                } else {
                    if (soporteAct.getNombreSoporte().equals(nombre)) {
                        App.SoporteDAO.update(soporteAct);
                    }
                }
            }

            if (nombre.equals("PAGO")) {
                Soporte soporteAct = new Soporte();
                for (Soporte soporte : listasoporte) {
                    if (soporte.getNombreSoporte().equals(nombre)) {
                        String fileName = nameDir + nombre + ".pdf";
                        filePath = "soportes/" + nameDir + "/Inscripcion/" + fileName;
                        soporte.setUrlArchivo(filePath);
                        soporte.setNombreSoporte(nombre);
                        Persona persona = App.PersonaDAO.get((int) Long.parseLong(nameDir));
                        soporte.setIdPersona(persona);
                        TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(2);
                        soporte.setIdTiposoporte(tipoSoporte);
                        soporte.setNombreTmp(nombtmp);
                        soporteAct = soporte;
                        break;
                    }
                }
                if (soporteAct.getNombreSoporte() == null) {
                    System.out.println("soporte Act foto ---> "+soporteAct.getNombreSoporte());
                    String fileName = nameDir + nombre + ".pdf";
                    filePath = "soportes/" + nameDir + "/Inscripcion/" + fileName;
                    soporteAct.setUrlArchivo(filePath);
                    soporteAct.setNombreSoporte(nombre);
                    Persona persona = App.PersonaDAO.get((int) Long.parseLong(nameDir));
                    soporteAct.setIdPersona(persona);
                    TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(2);
                    soporteAct.setIdTiposoporte(tipoSoporte);
                    soporteAct.setNombreTmp(nombtmp);
                    App.SoporteDAO.insert(soporteAct);
                } else {
                    if (soporteAct.getNombreSoporte().equals(nombre)) {
                        App.SoporteDAO.update(soporteAct);
                    }
                }
            }

            if (nombre.equals("FOTO")) {
                Soporte soporteAct = new Soporte();
                for (Soporte soporte : listasoporte) {
                    if (soporte.getNombreSoporte().equals(nombre)) {
                        String fileName = nameDir + nombre + ".pdf";
                        filePath = "soportes/" + nameDir + "/Inscripcion/" + fileName;
                        soporte.setUrlArchivo(filePath);
                        soporte.setNombreSoporte(nombre);
                        Persona persona = App.PersonaDAO.get((int) Long.parseLong(nameDir));
                        soporte.setIdPersona(persona);
                        TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(187);
                        soporte.setIdTiposoporte(tipoSoporte);
                        soporte.setNombreTmp(nombtmp);
                        soporteAct = soporte;
                        break;
                    }
                }
                if (soporteAct.getNombreSoporte() == null) {
//					System.out.println("soporte Act fosy ---> "+soporteAct.getNombreSoporte());
                    String fileName = nameDir + nombre + ".pdf";
                    filePath = "soportes/" + nameDir + "/Inscripcion/" + fileName;
                    soporteAct.setUrlArchivo(filePath);
                    soporteAct.setNombreSoporte(nombre);
                    Persona persona = App.PersonaDAO.get((int) Long.parseLong(nameDir));
                    soporteAct.setIdPersona(persona);
                    TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(187);
                    soporteAct.setIdTiposoporte(tipoSoporte);
                    soporteAct.setNombreTmp(nombtmp);
                    App.SoporteDAO.insert(soporteAct);
                } else {
                    if (soporteAct.getNombreSoporte().equals(nombre)) {
                        App.SoporteDAO.update(soporteAct);
                    }
                }
            }

            if (nombre.equals("PREGRADO")) {
                Soporte soporteAct = new Soporte();
                for (Soporte soporte : listasoporte) {
                    if (soporte.getNombreSoporte().equals(nombre)) {
                        String fileName = nameDir + nombre + ".pdf";
                        filePath = "soportes/" + nameDir + "/Inscripcion/" + fileName;
                        soporte.setUrlArchivo(filePath);
                        soporte.setNombreSoporte(nombre);
                        Persona persona = App.PersonaDAO.get((int) Long.parseLong(nameDir));
                        soporte.setIdPersona(persona);
                        TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(4);
                        soporte.setIdTiposoporte(tipoSoporte);
                        soporte.setNombreTmp(nombtmp);
                        soporteAct = soporte;
                        break;
                    }
                }
                if (soporteAct.getNombreSoporte() == null) {
//					System.out.println("soporte Act fosy ---> "+soporteAct.getNombreSoporte());
                    String fileName = nameDir + nombre + ".pdf";
                    filePath = "soportes/" + nameDir + "/Inscripcion/" + fileName;
                    soporteAct.setUrlArchivo(filePath);
                    soporteAct.setNombreSoporte(nombre);
                    Persona persona = App.PersonaDAO.get((int) Long.parseLong(nameDir));
                    soporteAct.setIdPersona(persona);
                    TipoSoporte tipoSoporte = App.TipoSoporteDAO.get(4);
                    soporteAct.setIdTiposoporte(tipoSoporte);
                    soporteAct.setNombreTmp(nombtmp);
                    App.SoporteDAO.insert(soporteAct);
                } else {
                    if (soporteAct.getNombreSoporte().equals(nombre)) {
                        App.SoporteDAO.update(soporteAct);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    protected String processFiles(FileItem fileItem, String nameDir, String nombre, String value) {
        String filePath = "";
        try {
            File uploadDir2 = new File(UPLOAD_DIRECTORY);
            if (!uploadDir2.exists()) {
                uploadDir2.mkdir();
            }
            File uploadDir3 = new File(UPLOAD_DIRECTORY + "/" + nameDir);
            if (!uploadDir3.exists()) {
                uploadDir3.mkdir();
            }
            File uploadDir = new File(UPLOAD_DIRECTORY + "/" + nameDir + "/Inscripcion");
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String[] extension = fileItem.getName().split("\\.");
            String ext = extension[extension.length - 1];
            String fileName = nameDir + nombre + "." + ext;
            filePath = UPLOAD_DIRECTORY + "/" + nameDir + "/Inscripcion/" + fileName;
            File file = new File(filePath);
            fileItem.write(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    protected class Input {

        private String name;
        private String value;
        private String type;

        private FileItem fileItem;

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setFileItem(FileItem fileItem) {
            this.fileItem = fileItem;
        }
    }

    protected ArrayList<Input> getInputsForm(HttpServletRequest request) throws ServletException, IOException {
        ArrayList<Input> inputs = new ArrayList<Input>();
        if (ServletFileUpload.isMultipartContent(request)) {
            ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
            upload.setSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);

            try {
                List<FileItem> formItems = upload.parseRequest(request);
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        String typeInput = item.getContentType();
                        String nameInput = item.getFieldName();
                        String valueInput = "";
                        if (item.isFormField()) {
                            valueInput = item.getString();
                            typeInput = "input";
                        } else {
                            valueInput = item.getName();
                        }
                        Input input = new Input();
                        input.setType(typeInput);
                        input.setName(nameInput);
                        input.setValue(valueInput);
                        input.setFileItem(item);
                        inputs.add(input);
                    }
                }
            } catch (Exception ex) {
            }
        }
        return inputs;
    }
}
