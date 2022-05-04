package Ejercicio1;

import java.util.Random;

public class Cliente implements Runnable{
//Se crean las variables de la clase puerta, almacen, nombre.Estas seran recibidas atrabas del constructor. Una varia final de los intentos que puede
	//hacer los clientes y una variable random que genera un numero aleatorio
        Puerta      puerta;
        Almacen     almacen;
        String      nombre;
        Random      generador;
        final int MAX_INTENTOS  =   10;
/*Se reciben los objetos de puerta, almacen y el nombre 
 * que se mandaron en el lanzador, por ultimo se creara 
 * un nuevo generador
        */
        public Cliente(Puerta p, Almacen a, String nombre){
                this.puerta     =   p;
                this.almacen    =   a;
                this.nombre     =   nombre;
                generador       =   new Random();
        }

        //e crea un metodo void para poder generar el tiempo de espera que se requiera
        public void esperar(){
                try {
                        int ms_azar = generador.nextInt(100);
                        Thread.sleep(ms_azar);
                } catch (InterruptedException ex) {
                        System.out.println("Falló la espera");
                }
        }
        @Override
        public void run() {
        	//Iniciando el hilo se creara un for que se recorrera 10 veces, el numero maximo de intentos
                for (int i=0; i<MAX_INTENTOS; i++){
             
                	//Tenemos un if que validara que el metodo de puerta creada y si este es false, lo cual pasa 
                	//la primera vez que se recorre
                        if (!puerta.estaOcupada()){
                    //Se habre otro if que llamara al metodo intentar entrar que retorna un valor de 
                    //true o falso
                                if (puerta.intentarEntrar()){
                                	//Cuando se pase el if, es porque el valor ha regrasado como true
                                	//en este if se esperar un tiempo ya establecido y por ultimo se cerrara la puerta
                                        esperar();
                                        puerta.liberarPuerta();
                                        //Al entrar a la puerta se llamara al al metodo de almacen que devuelve un booleano true o false
                                        if (almacen.cogerProducto()){
                                        	//Si se consigue un true entonces se retornara el exito en caso de cuzar
                                        	//se devolvera que no se pudo adquirir un producto
                                                System.out.println(
                                                                this.nombre + ": cogí un producto!");
                                                return ;
                                        }
                                        else {
                                                System.out.println(
                                                           this.nombre+
                                                           ": ops, crucé pero no cogí nada");
                                                return ;
                                        } //Fin del else
                                } //Fin del if
                        } else{
                           esperar();
                        }

                } 
                //19.Al recorrese y no haber entrado se imprimira un mensaje de que no se tuvo exito
                //Fin del for
                //Se superó el máximo de reintentos y abandonamos
                System.out.println(this.nombre+
                                ": lo intenté muchas veces y no pude");
        }

}