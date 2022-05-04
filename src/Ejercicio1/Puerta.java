package Ejercicio1;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Puerta {
	
  //11.Se crea una variable booleana y se le asiganara por primera vez un estado de false
        boolean ocupada;

        public Puerta(){
                this.ocupada=false;

        }
        //12.Al ser llamda retorna el valor que la variable booleana
        public boolean estaOcupada(){
                return this.ocupada;
        }
        public synchronized void liberarPuerta(){
                this.ocupada=false;
        }
        //14.Cuando se llame a este metodo se devolvera un valor de true o false aleatorio
        public synchronized boolean intentarEntrar(){
                if (this.ocupada) return false;
                /* Si llegamos aquí, la puerta estaba libre
                pero la pondremos a ocupada un tiempo
                y luego la volveremos a poner a "libre"*/
                this.ocupada=true;
                
                return true;
        }
}