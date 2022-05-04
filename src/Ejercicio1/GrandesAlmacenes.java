package Ejercicio1;

import Ejercicio1.Almacen;
import Ejercicio1.Cliente;
import Ejercicio1.Puerta;

public class GrandesAlmacenes {
    public static void main(String[] args) throws InterruptedException {
            final int NUM_CLIENTES  = 7;
            
            final int NUM_PRODUCTOS = 4;
         
         
            Cliente[]   cliente =   new Cliente[NUM_CLIENTES];
            Almacen     almacen =   new Almacen(NUM_PRODUCTOS);
            Puerta      puerta  =   new Puerta();

            Thread[]    hilosAsociados=new Thread[NUM_CLIENTES];

           
            for (int i=0; i<NUM_CLIENTES; i++){           	    
                    String nombreHilo   = "Cliente "+i;
                    cliente[i]          = new Cliente(puerta, almacen, nombreHilo);                                                                                          
                    hilosAsociados[i]   = new Thread(cliente[i]);                  
                    hilosAsociados[i].start();
            } 
            for (int i=0; i<NUM_CLIENTES; i++){
                    hilosAsociados[i].join();
            } 
           
    
}

}