public class Punto {
 
private double x;
private double y;
 
public Punto(double x, double y) {
this.x=x;
this.y=y;
}
 
public double getX() {
return x;
}
public double getY() {
return y;
}
 
public void setX(double x1) {
this.x=x;
}
public void setY(double y) {
this.y=y;
}
 
public double calcularDistanciaDesde(Punto parametros) {
double cateto1 = x - parametros.getX();
double cateto2 = y - parametros.getY();
double hipotenusa = Math.sqrt(cateto1*cateto1 + cateto2*cateto2);
return hipotenusa;
 
}
public String toString(){
return "(x= " + getX() + ", y= " + getY() + " )";
}
}