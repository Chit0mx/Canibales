package Canibales;

public class Cocinero extends Thread {
    private Comida comida;

    public Cocinero(Comida r) {
       this.comida = r;
    }

    public synchronized void run() {
        while(true) {
            if(comida.mostrarLlenadoComida() == false){
                if(comida.mostrarComida() == 0){
                    try {
                        sleep(2000);
                     } catch (InterruptedException e) { }
                }
                else{
                    try {
                        sleep(1000);
                     } catch (InterruptedException e) { }
                }
                
                comida.prepararComida();
                if(comida.mostrarComida() == 1)
                    System.out.println("El taquero preparó 1 taco");
                else
                    System.out.println("El taquero preparó " + comida.mostrarComida() + " tacos");
            }
            
       }
    }
}
