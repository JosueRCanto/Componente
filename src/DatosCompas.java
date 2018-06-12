
import java.util.*;

public class DatosCompas{
  private Vector CompasListeners=new Vector();
  private int coordx,coordy,radio;

  public DatosCompas() {
  
  }

  public void setDatos(int coordx,int coordy,int radio){
	  int viejoradio=this.radio;
	  this.coordx=coordx;
	  this.coordy=coordy;
	  this.radio=radio;

    if(viejoradio!=this.radio){
        CompasEvent event=new CompasEvent(this,coordx ,coordy,radio );
        notificarCambio(event);
    }
  }
  
  public int getcoordx(){
    return coordx;
  }
  
  public int getcoordy(){
	    return coordy;
	  }
  
  public int getradio(){
	    return radio;
	  }

  public synchronized void addCompasListener(CompasListener listener){
	  CompasListeners.addElement(listener);
  }
  public synchronized void removeCompasListener(CompasListener listener){
	  CompasListeners.removeElement(listener);
  }

  private void notificarCambio(CompasEvent event){
    Vector lista;
    synchronized(this){
        lista=(Vector)CompasListeners.clone();
    }
    for(int i=0; i<lista.size(); i++){
        CompasListener listener=(CompasListener)lista.elementAt(i);
        listener.enterado(event);
    }
  }
  
  
}
