package controlador.control_Usuario;

import java.io.IOException;

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
 * Servlet implementation class Controlador_BorrarUsuario
 */
@WebServlet("/Controlador_BorrarUsuario")
public class Controlador_BorrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    @Resource(name="jdbc/MVC_JSP")
    private DataSource miPool;
    
    private UsuarioDAO usuarioDAO;
   
    public Controlador_BorrarUsuario() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
            usuarioDAO = new UsuarioDAO(miPool);
            
        }catch(Exception e) {
            throw new ServletException();
        }
        
        request.setCharacterEncoding("UTF-8");
        String id=request.getParameter("id_usu");
      
        
        if(id!="") {
            if(usuarioDAO.delete(id))
                request.getRequestDispatcher("vistaUsuario/exito.jsp").forward(request, response);
    }else {
        System.out.println("Usuario no encontrado");
            request.getRequestDispatcher("vistaUsuario/error.jsp").forward(request, response);
    }
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
