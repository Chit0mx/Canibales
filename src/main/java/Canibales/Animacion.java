package Canibales;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.io.IOException;


public class Animacion extends JFrame implements Runnable{
    private Thread hilo;
    int h,w,origenCocineroX,origenCocineroY, nCan;
    Graphics g=this.getGraphics();
    private Comida comida;
    public boolean [] alertaCanibales, platoCanibales;
    public boolean cocineroZzz=false;
    private Image dbImage;
    private Graphics gAux;

    public Animacion(int cant, Comida c){
        this.comida=c;
        h=500;
        w=(int)(h*2);
        nCan=cant;
        setTitle("Canibales AAMR 19310170");
        setSize(w,h);
        setLayout(null);
        
        alertaCanibales=new boolean[cant];
        platoCanibales=new boolean[cant];
        
        for(int i=0;i<cant;i++){
            alertaCanibales[i]=false;
            platoCanibales[i]=false;
        }
        
        g=this.getGraphics();

        hilo=new Thread(this);
        hilo.start();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
            dbImage = createImage(getWidth(),getHeight());
            gAux = dbImage.getGraphics();
            paintComponent(gAux);
            g.drawImage(dbImage,0,0,this);
    }

    public void paintComponent(Graphics g){
        int x=w/2-(nCan/2*60),y=150;
        super.paint(g);
        Cocinero(g,w/2,450,Color.blue);
        if(cocineroZzz){
            Dormir(g,w/2,450);
        }
        Olla(g,w/2,250,Color.blue);
        for(int i=0;i<nCan;i++){
            Canibal(g,x,y,Color.blue);
            if(alertaCanibales[i]){
                Exclamacion(g,x,y);
            }
            if(platoCanibales[i]){
                Plato(g,x,y);
            }
            x+=60;
        }
    }
    
    public void Cocinero(Graphics g, int x, int y, Color co) {

        Image imgCocinero = null;

        try {
            imgCocinero = ImageIO.read(new File("/Users/chit0mx/IdeaProjects/Canibales/src/main/java/images/taquero.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(imgCocinero,450,300,80,120,this);

/*
        g.setColor(Color.BLACK);
        g.fillOval(x+5, y-100, 40, 40);
        g.fillRect(x+10, y-140, 30, 40);
        g.fillOval(x, y-150, 50, 20);
        int [] vx1 = {x, x+50, x+50, x+40,x+10,x};
        int [] vy1 = {y, y, y-50, y-60, y-60, y-50};
        g.fillPolygon (vx1, vy1, 6);
    */

    }
    
    public void Canibal(Graphics g, int x, int y, Color co){

        Image imgCocinero = null;

        try {
            imgCocinero = ImageIO.read(new File("/Users/chit0mx/IdeaProjects/Canibales/src/main/java/images/kirby.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(imgCocinero,x,y-50,60,60,this);
        /*
        g.setColor(Color.BLACK);
        g.fillOval(x+5, y-100, 40, 40);
        int [] vx1 = {x, x+50, x+50, x+40,x+10,x};
        int [] vy1 = {y, y, y-50, y-60, y-60, y-50};
        g.fillPolygon (vx1, vy1, 6);

        */
    }
    
    public void Olla(Graphics g, int x, int y, Color co){
        /*
        g.setColor(Color.darkGray);
        g.fillOval(x, y+20, 60, 30);
        g.fillRect(x, y+15, 60, 20);
        g.drawString(Integer.toString(comida.mostrarRaciones()), x+70, y+30);
        g.setColor(Color.green);
        g.fillOval(x, y, 60, 30);
         */

        Image imgCocinero = null;

        try {
            imgCocinero = ImageIO.read(new File("/Users/chit0mx/IdeaProjects/Canibales/src/main/java/images/trompo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(imgCocinero,x,y,70,120,this);
        g.drawString(Integer.toString(comida.mostrarComida()), x+70, y+30);
    }
    
    public void Plato(Graphics g,int x, int y){
        /*
        g.setColor(Color.green);
        g.fillOval(x, y+10, 50, 25);
        */
        Image imgCocinero = null;

        try {
            imgCocinero = ImageIO.read(new File("/Users/chit0mx/IdeaProjects/Canibales/src/main/java/images/tacos.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(imgCocinero,x,y+10,50,50,this);

    }
    
    public void Dormir(Graphics g,int x, int y){
        g.setColor(Color.BLACK);
        g.drawString("A mimir!", x+45, y-100);
    }
    
    public void Exclamacion(Graphics g,int x, int y){
        g.setColor(Color.BLACK);
        g.drawString("¡Cocina, Taquero!", x+45, y-100);
    }

    @Override
    public void run(){
        while(true){
            try{
                repaint();
                hilo.sleep(100);
            }catch(InterruptedException ex){
            }
        }
    }
     
}
