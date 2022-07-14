
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private final String URL="jdbc:mysql://localhost:3306/Base_Nueva";
    private final String USER="root";
    protected Connection conexion;
    
    public void iniciar() throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        this.conexion=DriverManager.getConnection(URL,USER,"");
    
    }
    
    
    
}
