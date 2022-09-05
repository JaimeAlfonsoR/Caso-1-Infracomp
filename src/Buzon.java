import java.util.ArrayList;

public class Buzon extends Thread{

    private int capacidad;
    private int thread;
    private int ocupacion;
    private int lec=0;
    private int esc=0;
    private ArrayList<String> mensajes;
    


    public void Buzon (int pcapacidad, int pthread)
    {
        this.capacidad = pcapacidad;
        this.thread = pthread;
        mensajes=new ArrayList();


    }
    public boolean estaVacio(){
    	while (esc!=0) {
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
    	lec+=1;
    	return ocupacion==0;
    	
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
    	return txt;
    }
    public synchronized void poner(String t) {
    	while ((ocupacion==capacidad)||(esc>0)||(lec>0)){
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
   		
    	ocupacion-=1;
    	esc+=1;
    	mensajes.add(t);

    }
    


    public void run()
    {

    }

}
