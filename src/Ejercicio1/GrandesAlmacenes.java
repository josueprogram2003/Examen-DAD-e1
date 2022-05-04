package Ejercicio1;

import Ejercicio1.Almacen;
import Ejercicio1.Cliente;
import Ejercicio1.Puerta;

public class GrandesAlmacenes {
    public static void main(String[] args) throws InterruptedException {
            final int NUM_CLIENTES  = 10;
            //Primero definimos como variables finales el numero de cliente y el numero total de productos que va haber en un almacen
            final int NUM_PRODUCTOS = 5;
         
            //Se crean un array de la clase clientes que seran los distitnos clientes que habran, una unica clase de almacen para el
            //numero total de productos y la puerta que sera la que permitira entrar a los cliente, por ultimo se crea un array de thread para poder
            //lanzar los distintos clientes que se crearan
            Cliente[]   cliente =   new Cliente[NUM_CLIENTES];
            Almacen     almacen =   new Almacen(NUM_PRODUCTOS);
            Puerta      puerta  =   new Puerta();

            Thread[]    hilosAsociados=new Thread[NUM_CLIENTES];

            //Se recorre un for donde se crara un cliente nueve hasta la cantidad de clientes que pusimos que pusimos al principio
            for (int i=0; i<NUM_CLIENTES; i++){
            	    //Con cada cliente que se cree se le asignara un nombre y se lo enviara a un constructor Cliente con las clases de puerta y almacen
                    String nombreHilo   = "Cliente "+i;
                    cliente[i]          = new Cliente(puerta, almacen, nombreHilo);
                                                                                           
                    hilosAsociados[i]   = new Thread(cliente[i]);
                    //Intentamos arrancar el hilo
                    hilosAsociados[i].start();
            } 
            //Fin del for
            //Una vez que se arraquen los clientes entonces se le dara un join para que estos se ejcuten primero.
            for (int i=0; i<NUM_CLIENTES; i++){
                    hilosAsociados[i].join();
            } //Fin del for
           
    
}

}