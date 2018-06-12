import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    private Connection conectar = null;

    public  Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/compas", "root", "");
        } catch (ClassNotFoundException | SQLException error) {
            JOptionPane.showMessageDialog(null, "Connection error"+"\n"+error,"Mensaje Error",JOptionPane.ERROR_MESSAGE);
        }
        return conectar;

    }   
}
