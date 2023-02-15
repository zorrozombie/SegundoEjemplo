package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import modelo.Usuario;

public class UsuarioDAO implements DAO<Usuario> {
    
   private static final String SQL_INSERT ="INSERT INTO USUARIOS (nombre,apellidos,usuario,contrasena,pais,tecnologia)" + "VALUES (?,?,?,?,?,?)";
   private static final String SQL_READ ="SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";
   private static final String SQL_LOGIN="SELECT * FROM USUARIOS WHERE USUARIO=? AND CONTRASENA=?";
   private static final String SQL_UPDATE="UPDATE USUARIOS SET NOMBRE=?,APELLIDOS=?,USUARIO=?,CONTRASENA=?,PAIS=?,TECNOLOGIA=? WHERE ID_USUARIO=?";
   private static final String SQL_READALL="SELECT * FROM USUARIOS";
   private static final String SQL_DELETE="DELETE FROM USUARIOS WHERE ID_USUARIO=?"; 
   private DataSource origenDatos;
   
   
public UsuarioDAO(DataSource origenDatos) {
    this.origenDatos = origenDatos;
}


@Override
public boolean create(Usuario c) throws SQLException {
    // TODO Auto-generated method stub
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con=null;
    try {
        con=origenDatos.getConnection();
        ps=con.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellido());
        ps.setString(3, c.getUsuario());
        ps.setString(4, c.getContrasena());
        ps.setString(5, c.getPais());
        ps.setString(6, c.getTecnologia());
        
        if(ps.executeUpdate()>0) {
            rs=ps.getGeneratedKeys();
            if(rs.next()) {
                c.setId_usuario(rs.getLong(1));
            }
            return true;
        }
    }finally {
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
}


@Override
public Usuario read(Object key) {
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con=null;
    try {
        con=origenDatos.getConnection();
        ps=con.prepareStatement(SQL_READ);
        
       ps.setNString(1, (String) key);
       rs=ps.executeQuery();
       while(rs.next()) {
           Usuario usu = new Usuario(Long.parseLong((String) key),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
           return usu;
       }
        
    }catch(SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}

public Usuario login(Object usu,Object contra) {
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con=null;
    try {
        con=origenDatos.getConnection();
        ps=con.prepareStatement(SQL_LOGIN);
        
       ps.setNString(1, (String) usu);
       ps.setNString(2, (String) contra);
       rs=ps.executeQuery();
       while(rs.next()) {
           Usuario usua = new Usuario(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
           return usua;
       }
        
    }catch(SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}



public boolean update(Object key) {
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con=null;
    Usuario usu = (Usuario) key;
    try {
        con=origenDatos.getConnection();
        ps=con.prepareStatement(SQL_UPDATE);
       ps.setString(1,usu.getNombre());
       ps.setString(2,usu.getApellido());
       ps.setString(3,usu.getUsuario());
       ps.setString(4,usu.getContrasena());
       ps.setString(5,usu.getPais());
       ps.setString(6,usu.getTecnologia());
       ps.setLong(7,usu.getId_usuario());
       if(ps.executeUpdate()>0)
           return  true;
           
       
       
       
      }catch(SQLException e) {
          e.printStackTrace();
      }finally {
          try {
              con.close();
          }catch(SQLException e) {
              e.printStackTrace();
          }
      }
    return false;
}


@Override
public boolean delete(Object key) {
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con=null;
    try {
        con=origenDatos.getConnection();
        ps=con.prepareStatement(SQL_DELETE);
        
       ps.setNString(1, (String) key);
       if(ps.executeUpdate()>0)
           return true;
      
          
      
    }catch(SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
   
}


@Override
public ArrayList<Usuario> readAll() {
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con=null;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    try {
        con=origenDatos.getConnection();
        ps=con.prepareStatement(SQL_READALL);
        
       rs=ps.executeQuery();
       while(rs.next()) {
           Usuario usu = new Usuario(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
           usuarios.add(usu);
          
       }
       return usuarios;
    }catch(SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}



}