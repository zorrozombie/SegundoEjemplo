package controlador.control_Usuario;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Controlador_MostrarTodoUsuario
 */
@WebServlet("/Controlador_MostrarTodoUsuario")
public class Controlador_MostrarTodoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/MVC_JSP")
	private DataSource miPool;
	private UsuarioDAO usuarioDAO;   
    
    public Controlador_MostrarTodoUsuario() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
            usuarioDAO = new UsuarioDAO(miPool);
            
        }catch(Exception e) {
            throw new ServletException();
        }
	    ArrayList<Usuario> usuarios = new ArrayList<>();
	    usuarios=usuarioDAO.readAll();
        if(usuarios!=null) {
            request.setAttribute("usuario", usuarios);
            request.getRequestDispatcher("vistaUsuario/mostrarTodo.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("vistaUsuario/error.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
