package Ejercicio3;

import java.util.Random;


public class Productor implements Runnable{

	 Cola colaCompartida;
	 Random numAzar;
	 
     public Productor(Cola cola){
             this.colaCompartida=cola;
             this.numAzar =  new Random();
     }
     @Override
     public void run() {
        while (true){
                int num=numAzar.nextInt(10);
                while (colaCompartida.encolar(num)==false){
                	try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                }

                System.out.println("Productor encoló el numero:"+num);
        }
     } 
}
