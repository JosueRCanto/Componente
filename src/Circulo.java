import java.awt.*;

public class Circulo{

    private int x = 0, y = 0, radio;

    public Circulo(int x, int y,int radio) {

        setX(x);
        setY(y);
        setradio(radio);
    }

    public void pintar(Graphics g){

     g.drawOval(getX()-(radio/2),getY()-(radio/2),radio,radio);
        g.setColor(Color.BLACK);
    }

    public int getradio() {
        return radio;
    }

    public void setradio(int radio) {
        this.radio = radio;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }



    public void setY(int y) {
        this.y = y;
    }

   


}
