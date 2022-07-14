
package DAO;

import Interfaces.DAOUsuarios;
import clases.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAOImp extends Conexion implements DAOUsuarios{
    
    private final String REGISTRO="INSERT INTO usuarios(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private final String MODIFICAR="UPDATE usuarios SET telefono=? WHERE nombre=?";
    private final String ELIMINAR="DELETE FROM usuarios WHERE nombre=?";
    private final String RECUPERAR ="SELECT * FROM usuarios";

    @Override
    public void registrar(List<Usuarios> usuarios) throws SQLException, ClassNotFoundException {
        this.iniciar();
        PreparedStatement accion=this.conexion.prepareStatement(REGISTRO);
        
        for (Usuarios usuario : usuarios) {
            
            accion.setString(1, usuario.getNombre());
            accion.setString(2, usuario.getApellido());
            accion.setString(3, usuario.getEmail());
            accion.setString(4, usuario.getTelefono());
            accion.executeUpdate();
            
            
        }
        
        System.out.println("Se realizo la actualizacion de la tabla");
        accion.close();
        this.conexion.close();
        
        
        
    }

    @Override
    public List<Usuarios> recuperar() throws SQLException, ClassNotFoundException {
        List<Usuarios> usuarios=new ArrayList<>();
        this.iniciar();
        Statement accion=this.conexion.createStatement();
        ResultSet resultado=accion.executeQuery(RECUPERAR);
        
        while(resultado.next()){
            usuarios.add(new Usuarios(
                    resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5)
            ));
            
        
        }
        resultado.close();
        accion.close();
        this.conexion.close();
        usuarios.forEach(System.out::println);
        
        return usuarios;
    }

    @Override
    public void modificar(Usuarios user) throws SQLException, ClassNotFoundException {
        this.iniciar();
        PreparedStatement accion=this.conexion.prepareStatement(MODIFICAR);
        accion.setString(1, user.getTelefono());
        accion.setString(2, user.getNombre());
        
        
        
        accion.close();
        this.conexion.close();
        System.out.println("Se realizo la actualizacion");
    }

    @Override
    public void eliminar(Usuarios user) throws SQLException, ClassNotFoundException {
       this.iniciar();
       
        PreparedStatement accion=this.conexion.prepareStatement(ELIMINAR);
        accion.setString(1, user.getNombre());
        
        
        
        accion.close();
        this.conexion.close();
        System.out.println("Se realizo el borrado");
    }

   
    
}
