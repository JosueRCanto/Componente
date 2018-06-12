import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compas extends JPanel implements MouseListener{
    ArrayList<Circulo> listaCirculos;
    private int cordx,cordy,radio;
    private int newx,newy;
    Punto p1,p2;
    private String fecha;

    public void paintComponent(Graphics g) {
    
        for(Circulo objCirculo : getListaCirculos()){
        objCirculo.pintar(g);
    }
    
    }

    public Compas(){
        super();
        setListaCirculos(new ArrayList<>());
        addMouseListener(this);
        
        


    }

   
    public void Clicked(MouseEvent e) {
    	
    		
    	 
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    
        if(e.getButton()==1){        	
        	
        	cordx=e.getX();
        	cordy=e.getY();
        	 p1 = new Punto(cordx,cordy);
        	 getListaCirculos().add(new Circulo(cordx,cordy,2));
             repaint();
        
        }
        if(e.getButton()==3){
        	
        	Date date = new Date();
        	DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
        	fecha=hourdateFormat.format(date);
        	
        	newx=e.getX();
        	newy=e.getY();
        	p2 = new Punto(newx,newy);
        	radio =((int) p1.calcularDistanciaDesde(p2))*2;      	
        	getListaCirculos().add(new Circulo(cordx,cordy,radio));
        	
            repaint(); 
            meti();
       
            ConexionBD cnx = new ConexionBD();
            Connection registro = cnx.conexion();
            String sql = "INSERT INTO datos (Fecha,CoordXPunto,CoordYPunto,Radio) VALUES (?,?,?,?)";

            try {
            
                PreparedStatement pst = (PreparedStatement) registro.prepareStatement(sql);
             
                pst.setString(1, fecha);
                pst.setInt(2, cordx);
                pst.setInt(3, cordy);
                pst.setInt(4, radio);
               /* int numero_datos = */pst.executeUpdate();
               /* if (numero_datos > 0) {
                	 
                	ClasePrincipal.cargarTabla();
                              	  
                } else {
                    JOptionPane.showMessageDialog(null, "Campos vacios\n Ingrese sus datos", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
                }*/


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

            }
         
          }
        }        

    
   
    @Override
    public void mousePressed(MouseEvent e) {
    	
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public ArrayList<Circulo> getListaCirculos() {
        return listaCirculos;
    }

    public void setListaCirculos(ArrayList<Circulo> listaCirculos) {
        this.listaCirculos = listaCirculos;
    }
    
    public void meti(){
    
    	
    	   Circulos circ=new Circulos();
           DatosCompas data=new DatosCompas();
    
           data.addCompasListener(circ);
           data.setDatos(cordx,cordy,radio);          
           
    }
    
   
}
