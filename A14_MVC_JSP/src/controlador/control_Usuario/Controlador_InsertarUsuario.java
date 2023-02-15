package controlador.control_Usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.UsuarioDAO;
import modelo.Usuario;

/**
 * Servlet implementation class Controlador_InsertarUsuario
 */
@WebServlet("/Controlador_InsertarUsuario")
public class Controlador_InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MVC_JSP")
    private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
  
    public Controlador_InsertarUsuario() {
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    usuarioDAO = new UsuarioDAO(miPool);
		    
		}catch(Exception e) {
		    throw new ServletException();
		}
		
		request.setCharacterEncoding("UTF-8");
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String usuario=request.getParameter("usuario");
		String contrasena=request.getParameter("contrasena");
		String pais=request.getParameter("pais");
		String tecno=request.getParameter("tecnologia");
		
		if(nombre!="" && apellido!="" &&  usuario!="" && contrasena!="") {
		    Usuario u = new Usuario(nombre,apellido,usuario,contrasena,pais,tecno);
		    
		try {
		    if(usuarioDAO.create(u))
		        
		        request.getRequestDispatcher("vistaUsuario/exito.jsp").forward(request, response);
		    
		}catch(SQLException e) {
		    request.getRequestDispatcher("vistaUsuario/error.jsp").forward(request, response);
		}
	}
	else {
	    System.out.println("cadenas vacia");
	        request.getRequestDispatcher("vistaUsuario/error.jsp").forward(request, response);
	}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		doGet(request, response);
	}

}
