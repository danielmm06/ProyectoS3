package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.App;

public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Error() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = request.getParameter("e");
		if (error == null) {
			error = "UrlNotFound";
			response.sendRedirect(App.pathURL+"/Error?e="+error);	
//		} else {
//			if (App.CheckSessionInit(request.getSession())) {
//				request.setAttribute("title", App.nameProyect+" - "+error); 
//				getServletConfig().getServletContext().getRequestDispatcher("/Errors/"+error+".jsp").forward(request,response);
			} else {
				response.sendRedirect(App.pathURL+"/Login");
			}
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
