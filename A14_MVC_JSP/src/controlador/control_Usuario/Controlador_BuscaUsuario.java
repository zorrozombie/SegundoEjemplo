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
 * Servlet implementation class Controlador_BuscaUsuario
 */
@WebServlet("/Controlador_BuscaUsuario")
public class Controlador_BuscaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/MVC_JSP")
    private DataSource miPool;
    
    private UsuarioDAO usuarioDAO;
     
  
    public Controlador_BuscaUsuario() {
     
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
            if(usuarioDAO.read(id)!=null)
                request.setAttribute("usuario", usuarioDAO.read(id));
                request.getRequestDispatcher("vistaUsuario/mostrarUsuario.jsp").forward(request, response);
    }
    else {
        System.out.println("Usuario no encontrado");
            request.getRequestDispatcher("vistaUsuario/error.jsp").forward(request, response);
    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
