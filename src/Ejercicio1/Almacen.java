package Ejercicio1;

public class Almacen {
    private int numProductos;
    public Almacen(int nProductos){
            this.numProductos=nProductos;
    }
    //17.Al crear el objeto almacen se le pone el nuemro de productos que hay
    //al llamrse el metodo coger productos una vez entrado se restara al total uno menos
    //y se devolvera un true pero si ya no hay productos entonces se devolvera un false
    public boolean cogerProducto(){
            if (this.numProductos>0){
                    this.numProductos--;
                    return true;
            }
            return false;
    }
}
