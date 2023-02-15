package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import modelo.Productos;
import modelo.Usuario;

public class ProductoDAO implements DAO<Productos> {
    private static final String SQL_INSERT ="INSERT INTO PRODUCTOS VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_READ ="SELECT * FROM PRODUCTOS WHERE CODPROD = ?";
    private static final String SQL_UPDATE="UPDATE PRODUCTOS SET SECCION=?,NOMBREPROD=?,PRECIO=?,FECHA=?,IMPORTADO=?,PAISORIGEN=? WHERE CODPROD=?";
    private static final String SQL_READALL="SELECT * FROM PRODUCTOS";
    private static final String SQL_DELETE="DELETE FROM PRODUCTOS WHERE CODPROD=?"; 
    private DataSource origenDatos;
    
    
    public ProductoDAO(DataSource origenDatos) {
        this.origenDatos = origenDatos;
    }
    @Override
    public boolean create(Productos c) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con=null;
        try {
            con=origenDatos.getConnection();
            ps=con.prepareStatement(SQL_INSERT);
            
            ps.setString(1, c.getCodProd());
            ps.setString(2, c.getSeccion());
            ps.setString(3, c.getNombreProd());
            ps.setDouble(4, c.getPrecio());
            ps.setDate(5, Date.valueOf(c.getFecha()));
            ps.setBoolean(6, c.getImportado());
            ps.setString(7, c.getPais());
            
            if(ps.executeUpdate()>0) 
                return true;
            
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
    public Productos read(Object key) {
        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con=null;
        try {
            con=origenDatos.getConnection();
            ps=con.prepareStatement(SQL_READ);
            
           ps.setNString(1, (String) key);
           rs=ps.executeQuery();
           while(rs.next()) {
               Productos pro = new Productos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getBoolean(6),rs.getString(7));
               return pro;
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
    public boolean update(Object key) {
        Statement s= null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con=null;
        Productos c = (Productos) key;
        try {
            con=origenDatos.getConnection();
            ps=con.prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getSeccion());
            ps.setString(2, c.getNombreProd());
            ps.setDouble(3, c.getPrecio());
            ps.setDate(4, Date.valueOf(c.getFecha()));
            ps.setBoolean(5, c.getImportado());
            ps.setString(6, c.getPais());
            ps.setString(7, c.getCodProd());
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
    public ArrayList<Productos> readAll() {
        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con=null;
        ArrayList<Productos> produ = new ArrayList<>();
        try {
            con=origenDatos.getConnection();
            ps=con.prepareStatement(SQL_READALL);
            
           rs=ps.executeQuery();
           while(rs.next()) {
               Productos pro = new Productos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getBoolean(6),rs.getString(7));
               produ.add(pro);
              
           }
           return produ;
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
