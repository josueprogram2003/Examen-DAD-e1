package Ejercicio1;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Puerta {
	
        boolean ocupada;

        public Puerta(){
                this.ocupada=false;

        }
        public boolean estaOcupada(){
                return this.ocupada;
        }
        public synchronized void liberarPuerta(){
                this.ocupada=false;
        }
        public synchronized boolean intentarEntrar(){
                if (this.ocupada) return false;
                this.ocupada=true;
                
                return true;
        }
}