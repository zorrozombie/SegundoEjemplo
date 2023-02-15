package controlador.control_productos;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import modelo.Productos;
import modelo.Usuario;


@WebServlet("/Controlador_Productos")
public class Controlador_Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/MVC_JSP")
	
    private DataSource miPool;
    private ProductoDAO productoDAO;   
    public Controlador_Productos() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // if("Inserta".equals(request.getParameter("guarda"))) 
	   //    InsertaProducto(request,response);
	    
	    productoDAO = new ProductoDAO(miPool);
	    request.setCharacterEncoding("UTF-8");
	    
	   
	    String comando = request.getParameter("guarda");
	    if(comando==null) comando="listar";
	    System.out.println(comando);
	    switch(comando) {
	        case "listar":
	            mostrarProducto(request,response);
	            break;
	        case"Insertar":
	            InsertaProducto(request,response);
	            mostrarProducto(request,response);
	            break;
	        case"cargaParaActualizar":
	            actualizarProducto(request,response);
	            break;
	        case"cargaParaEliminar":
	            eliminarProducto(request,response);
	            break;
	            
	    }

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}
	private void mostrarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    try {
            productoDAO = new ProductoDAO(miPool);
            
        }catch(Exception e) {
            throw new ServletException();
        }
        ArrayList<Productos> productos = new ArrayList<>();
        productos=productoDAO.readAll();
        if(productos!=null) {
            request.setAttribute("produ", productos);
             System.out.println("Has conseguido mostrarlo todo");
             request.getRequestDispatcher("vistasProductos/mostrarTodo.jsp").forward(request, response);
        }else {
            System.out.println("No has conseguido mostrar todo");
        }
	}
	
	private void InsertaProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    System.out.println("Has entrado al insertaproducto");
	    try {
            productoDAO = new ProductoDAO(miPool);
            
        }catch(Exception e) {
            throw new ServletException();
        }
	    
	    request.setCharacterEncoding("UTF-8");
        String codProd=request.getParameter("CodProd");
        String seccione=request.getParameter("secciones");
        String arti=request.getParameter("articulo");
        String pre=request.getParameter("precio");
        String impor=request.getParameter("importado");
        String pais=request.getParameter("pais");
        String fecha =request.getParameter("fecha");
        Boolean importa;
        if(codProd!="" && seccione!="" &&  arti!="" && pre!="" && impor!="" && pais!="") {
            if(impor=="si")
                importa=true;
            else
                importa=false;
            Productos u = new Productos(codProd,seccione,arti,Double.parseDouble(pre),Date.valueOf(fecha).toLocalDate(),importa,pais);
            try {
                if(productoDAO.create(u))
                    System.out.println("Hola");
                else
                    System.out.println("No");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }     
	
	}
	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codProd=request.getParameter("codProd");
        String seccion=request.getParameter("seccion");
        String nombreProd=request.getParameter("nombreProd");
	    Double precio=Double.parseDouble(request.getParameter("precio"));
        
        String sFecha=request.getParameter("Fecha");
        System.out.print(sFecha);
       
        LocalDate fechalocalDate=null;
        
        try {
            fechalocalDate=LocalDate.parse(sFecha, DateTimeFormatter.ofPattern("yyyy/mm/dd"));
        }catch(DateTimeParseException e) {
            System.out.print("error en el formato de fecha");
        }
        
        boolean importado=Boolean.valueOf(request.getParameter("importado"));
        System.out.print(importado);
        
        String pais=request.getParameter("pais");
        
        Productos productoActualizado = new Productos( codProd, seccion, nombreProd, precio,  fechalocalDate,  importado, pais);
        System.out.print(productoActualizado);
        
        if(productoDAO.update(productoActualizado)) {
            mostrarProducto(request,response);
        }
    }
	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Has entrado en eliminar Producto");
	    
	    try {
            productoDAO = new ProductoDAO(miPool);
            
        }catch(Exception e) {
            throw new ServletException();
        }
        
        request.setCharacterEncoding("UTF-8");
        String id=request.getParameter("codProducto");
        System.out.println(id);
      
        if(id!="") {
            if(productoDAO.delete(id))
                mostrarProducto(request,response);
    }else {
        System.out.println("Usuario no encontrado");
        mostrarProducto(request,response);
    }
	}
}
