import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClasePrincipal extends JFrame implements Serializable{
	private JPanel panelBD=new JPanel();
	
	
	 static DefaultTableModel model;
	 static JTable tablaBD;
	 JScrollPane scrollBD;
	 private JPanel panelLienzos=new JPanel();
	 
    public ClasePrincipal () {
        super("Compas");
     
        
        panelBD.setBackground(Color.BLACK);

        //agregar el layoutManager BoxLayout
        Container contenedorPrincipal = getContentPane();
        contenedorPrincipal.setLayout(new GridLayout());
        
        tablaBD = new JTable ();
        scrollBD = new JScrollPane(tablaBD);
        panelBD.add(scrollBD);

        //Crear un JPanel y agregarlo
      
        Compas lienzo = new Compas();
        Compas lienzo2=new Compas();
        panelLienzos.setLayout(new GridLayout());
        panelLienzos.add(lienzo);
        panelLienzos.add(lienzo2);
        
        contenedorPrincipal.add(panelLienzos);
        contenedorPrincipal.add(panelBD);
      
        cargarTabla();
      

    }
    
public static void cargarTabla()  {
        
        try {
        String [] columnas = {"Fecha","CoordXPunto","CoordYPunto","Radio"};
        String [] registros = new String[4];
        String sql ="SELECT * FROM datos";
        model = new DefaultTableModel(null,columnas);
        ConexionBD cc = new ConexionBD();
        Connection cn=cc.conexion();
        
        
        Statement st = (Statement)cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            registros[0]=rs.getString("Fecha");
            registros[1]=rs.getString("CoordXPunto");
            registros[2]=rs.getString("CoordYPunto");
            registros[3]=rs.getString("Radio");
            model.addRow(registros);
        }
        tablaBD.setModel(model);
        }
        catch (SQLException ex) {
            Logger.getLogger(ClasePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }                                   
    }

    public static void main(String []args){
        ClasePrincipal ventana = new ClasePrincipal();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(new Dimension(1000,600));
        ventana.setVisible(true);
    }
}
