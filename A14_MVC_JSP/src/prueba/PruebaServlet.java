package prueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PruebaServlet
 */
@WebServlet("/PruebaServlet")
public class PruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	
    public PruebaServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida=response.getWriter();
		response.setContentType("text/plain");
		
		Connection miConexion=null;
		ResultSet mir = null;
		
		try {
		    miConexion=miPool.getConnection();
		    mir=miConexion.createStatement().executeQuery("SELECT * FROM PRODUCTOS;");
		    while(mir.next()) {
		        salida.println(mir.getString(3));
		    }
		}catch(Exception e) {
		    e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
