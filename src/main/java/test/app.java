
package test;

import DAO.UsuarioDAOImp;
import clases.Usuarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class app {
    public static void main(String[] args) {
        
        List<Usuarios> usuarioEnvio=new ArrayList<>();
        usuarioEnvio.add(new Usuarios("Zoe","Mancini","zoe@gmail.com","35125251"));
        usuarioEnvio.add(new Usuarios("Martin","Maldonado","martin@gmail.com","3516125451"));
        usuarioEnvio.add(new Usuarios("Marcos","Maldonado","marcos@gmail.com","3516156451"));
        usuarioEnvio.add(new Usuarios("Mateo","Maldonadivia","mateo@gmail.com","3514925451"));
        usuarioEnvio.add(new Usuarios("Matias","Marro","matias@gmail.com","351651351"));
        usuarioEnvio.add(new Usuarios("Manuel","Mujica","manuel@gmail.com","3516125888"));
        usuarioEnvio.add(new Usuarios("Azul","Maldonado","azul@gmail.com","351612451"));
        
        
        
        List<Usuarios> usuariosRecepcion=new ArrayList<>();
        
        UsuarioDAOImp usuarioDAO=new UsuarioDAOImp();
        
        try {
            
            //usuarioDAO.registrar(usuarioEnvio);
            //usuariosRecepcion=usuarioDAO.recuperar();
            //usuarioDAO.modificar(new Usuarios("Jeremias","a","a","3516112163"));
            usuarioDAO.eliminar(new Usuarios("Matias","","",""));
            
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("Error de la aplicacion");
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la conexion");
            ex.printStackTrace(System.out);
        }
        
        
    }
}
