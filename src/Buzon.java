import java.util.ArrayList;

public class Buzon {

    private int capacidad;
    //private int thread;
    private int ocupacion;
    private ArrayList<String> mensajes;
    
    public ArrayList<String> darm(){
    	return mensajes;
    }
    


    public Buzon (int pcapacidad)
    {
        this.capacidad = pcapacidad;
        //this.thread = pthread;
        mensajes=new ArrayList<String>();
        ocupacion=0;


    }

    public synchronized String quitar() {
    	while (this.mensajes.size()<=0){
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
   		
    	String txt= mensajes.get(mensajes.size()-1);
    	mensajes.remove(mensajes.size()-1);
    	notify();
    	return txt;
    }
    public synchronized String quitarf() {
    	String txt="";
    	if (this.mensajes.size()<=0){
				Thread.yield();
				txt= mensajes.get(mensajes.size()-1);
		    	mensajes.remove(mensajes.size()-1);
    	}	
   		
    	return txt;
    }
    public synchronized void poner(String t) {
    	while (this.mensajes.size()>=this.capacidad){
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
   		
    	mensajes.add(t);
    	System.out.println(mensajes);
    	notify();

    }
    public synchronized void poneri(String t) {
    	if(this.mensajes.size()>=this.capacidad){
    		Thread.yield();
    		mensajes.add(t);
        	System.out.println(mensajes);
    	}
    	
    	//ocupacion+=1;

    }
    




}
