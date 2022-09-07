import java.util.ArrayList;
import java.util.List;

public class Buzon {

    private int capacidad;
    //private int thread;
    private int ocupacion;
    private ArrayList<String> mensajes;
    
    public ArrayList<String> darm(){
    	return mensajes;
    }
    public int darc(){
    	return capacidad;
    }
  
    


    public Buzon (int pcapacidad)
    {
        this.capacidad = pcapacidad;
        //this.thread = pthread;
        mensajes=new ArrayList<String>();
        ocupacion=0;


    }

    public synchronized String retirar(String txt){
    	txt= mensajes.get(0);
    	mensajes.remove(0);
    	return txt;
    }
    public synchronized String quitar() {
    	while (this.mensajes.size()<=0){
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
   		String txt="";
    	txt = retirar(txt);
    	notify();
    	return txt;
    }
    public synchronized String quitarf() {
    	String txt="";	
    	txt = retirar(txt);
    	notifyAll();
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
    	//System.out.println(mensajes);
    	notifyAll();

    }
    public synchronized void poneri(String t) {
    	
    	mensajes.add(t);
    	notifyAll();
       	

    }
    




}
