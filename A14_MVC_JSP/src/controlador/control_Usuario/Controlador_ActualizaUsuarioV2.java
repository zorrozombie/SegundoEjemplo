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

@WebServlet("/Controlador_ActualizaUsuarioV2")
public class Controlador_ActualizaUsuarioV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Resource(name="jdbc/MVC_JSP")
    private DataSource miPool;
    
    private UsuarioDAO usuarioDAO;
        
    
    public Controlador_ActualizaUsuarioV2() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    try {
            usuarioDAO = new UsuarioDAO(miPool);
            
        }catch(Exception e) {
            throw new ServletException();
        }
	    if("Login Usuario".equals(request.getParameter("botonLogin"))) {
	        loginUsuario(request,response);
	    }else if("Actualiza Usuario".equals(request.getParameter("botonActualiza"))) {
	        actualizaUsuario(request,response);
	    }else
	        request.getRequestDispatcher("vistaUsuario/error.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String usuario=request.getParameter("usuario1");
        String contrasena=request.getParameter("contrasena1");
	
	    if(usuario!="" && contrasena!="") {
            Usuario usua=usuarioDAO.login(usuario, contrasena);
            if(usua!=null) {
                request.setAttribute("usuarios", usua);
               
                request.getRequestDispatcher("vistaUsuario/AtualizaUsuario.jsp").forward(request, response);
            }else {
                System.out.println("Usuario no encontrado");
                request.getRequestDispatcher("vistaUsuario/error.jsp").forward(request, response);
        }
	}

}
	private void actualizaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    String id =request.getParameter("id");
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String usuario=request.getParameter("usuario");
        String contrasena=request.getParameter("contrasena");
        String pais=request.getParameter("pais");
        String tecno=request.getParameter("tecnologia");
        if(id!="") {
            Usuario usua = new Usuario(Long.parseLong(id),nombre,apellido,usuario,contrasena,pais,tecno);
            if(usuarioDAO.update(usua))
                request.getRequestDispatcher("vistaUsuario/exito.jsp").forward(request, response);
            else
                request.getRequestDispatcher("vistaUsuario/error.jsp").forward(request, response);
        }
	}
}
