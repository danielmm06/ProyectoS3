package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.App;

public class Other extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Other() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("p");
		request.setAttribute("title", App.nameProyect+" - "+pagina); 
		getServletConfig().getServletContext().getRequestDispatcher("/Other/"+pagina+".jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
