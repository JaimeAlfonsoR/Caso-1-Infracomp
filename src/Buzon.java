import java.util.ArrayList;

public class Buzon extends Thread{

    private int capacidad;
    private int thread;
    private int ocupacion;
    private ArrayList<String> mensajes;
    


    public void Buzon (int pcapacidad, int pthread)
    {
        this.capacidad = pcapacidad;
        this.thread = pthread;
        mensajes=new ArrayList();


    }

    public synchronized String quitar() {
    	while (ocupacion==0){
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
   		
    	ocupacion-=1;
    	String txt= mensajes.get(-1);
    	mensajes.remove(-1);
    	notify();
    	return txt;
    }
    public synchronized String quitarf() {
    	if (ocupacion==0){
				Thread.yield();
    	}	
   		
    	ocupacion-=1;
    	String txt= mensajes.get(-1);
    	mensajes.remove(-1);
    	return txt;
    }
    public synchronized void poner(String t) {
    	while (ocupacion==capacidad){
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
   		
    	ocupacion+=1;
    	mensajes.add(t);
    	notify();

    }
    public synchronized void poneri(String t) {
    	if(ocupacion==capacidad){
    		Thread.yield();
    	}
    	
   		
    	ocupacion+=1;
    	mensajes.add(t);

    }
    




}
