package Canibales;

public class Canibal extends Thread {
    private Comida comida;
    private int numC;
    Animacion anim;

    public Canibal(Comida r, int n, Animacion a) {
       this.comida = r;
       this.numC = n;
       this.anim = a;
    }
    
    public synchronized void run() {
        while(true) {
            if(comida.mostrarLlenadoComida() == false){
                if(comida.mostrarAlerta() == false){
                    comida.canibalAlerta();
                    anim.cocineroZzz=false;
                    System.out.println("El cliente (" + this.numC+ ") no alcanzó taco, le chifla al taquero");
                    anim.alertaCanibales[this.numC-1]=true;
                    while (comida.mostrarLlenadoComida() == false) {
                        try {
                            sleep(500);
                         } catch (InterruptedException e) { }
                    }
                    anim.alertaCanibales[this.numC-1]=false;
                    System.out.println("El taquero lleno la parrilla, a mimir!");
                    System.out.println("El cliente (" + this.numC+ ") tomó un taco. [Quedan " + comida.tomarRacion() + " tacos en la parrilla]");
                    anim.cocineroZzz=true;
                    comida.sinAlerta();
                    anim.platoCanibales[this.numC-1]=true;
                    try {
                        sleep(2000);
                     } catch (InterruptedException e) { }
                }
                else{
                    while (comida.mostrarAlerta() == true) {
                        try {
                            sleep(500);
                         } catch (InterruptedException e) { }
                    }
                    System.out.println("El cliente (" + this.numC+ ") tomó un taco. [Quedan " + comida.tomarRacion() + " tacos en la parrilla]");
                    anim.platoCanibales[this.numC-1]=true;
                    try {
                       sleep(2000);
                    } catch (InterruptedException e) { }
                }
            }else{
                System.out.println("El cliente (" + this.numC+ ") tomó un taco. [Quedan " + comida.tomarRacion() + " tacos en la parrilla]");
                anim.platoCanibales[this.numC-1]=true;
                try {
                   sleep(2000);
                } catch (InterruptedException e) { }
            }
            anim.platoCanibales[this.numC-1]=false;
        }
    }
}
