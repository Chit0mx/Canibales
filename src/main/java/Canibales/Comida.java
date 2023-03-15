package Canibales;

public class Comida {
    private boolean olla = true;
    private boolean cocineroAlertado = false;
    private int raciones;
    private int racionesTotales;
    
    public Comida(int raciones){
        this.raciones = raciones;
        this.racionesTotales = raciones;
    }
    
    public synchronized int tomarRacion() {
        while (olla == false) {
            try {
               wait();
            }
            catch (InterruptedException e) {
            }
        }
        raciones--;
        if(raciones > 0){
            
            olla = true;
        }
        else {
            olla = false;
        }
        notifyAll();
        return raciones;
   }
    
    public synchronized void prepararComida() {
        while (olla == true) {
            try {
               wait();
            }
            catch (InterruptedException e) { 
            } 
        }
        raciones++;
        if(raciones >= racionesTotales){
            olla = true;
        }
        notifyAll();
    }
    
    public synchronized int mostrarComida() {
        notifyAll();
        return raciones;
   }
    
    public synchronized boolean mostrarLlenadoComida() {
        notifyAll();
        return olla;
   }
    
    public synchronized boolean mostrarAlerta() {
        notifyAll();
        return cocineroAlertado;
   }
    
    public synchronized void canibalAlerta() {
        cocineroAlertado = true;
        notifyAll();
   }
    
    public synchronized void sinAlerta() {
        cocineroAlertado = false;
        notifyAll();
   }
}
