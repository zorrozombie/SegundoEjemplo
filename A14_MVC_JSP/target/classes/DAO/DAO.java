package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public interface DAO <T>{
    
    public boolean create(T c) throws SQLException;
    
    public T read(Object key);
    
    public boolean delete(Object key);
    
    public boolean update(Object key);
    
    public ArrayList<T> readAll();
    

}
