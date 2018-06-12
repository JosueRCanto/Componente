
import java.util.*;

import javax.swing.JOptionPane;

public class Circulos implements CompasListener{

  public Circulos() {
  }
  public void enterado(EventObject ev){
    if(ev instanceof CompasEvent){
        CompasEvent event=(CompasEvent)ev;
        JOptionPane.showMessageDialog(null, "coordx="+event.getcoordx()+"\n"+"coordy="+event.getcoordy()+"\n"+"radio="+event.getradio(), "Datos", JOptionPane.INFORMATION_MESSAGE);
        
    }
  }
}