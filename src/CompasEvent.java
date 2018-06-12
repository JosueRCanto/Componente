import java.util.EventObject;


public class CompasEvent extends EventObject{
private int coordx,coordy,radio;
	public CompasEvent(Object fuente,int coordX,int coordY,int Radio) {
		super(fuente);
		coordx=coordX;
		coordy=coordY;
		radio=Radio;
		
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
}
