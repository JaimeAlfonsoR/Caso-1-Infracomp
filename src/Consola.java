
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Consola {
    private static int n;
    private static int buzIntermedios;
    private static int buzExtremo;
    public int nivel;



    public void menu()
    {
    	Scanner input = new Scanner (System.in);
        System.out.println("Escriba el numero de subconjuntos a generar: ");
        Consola.n= input.nextInt();
        System.out.println("Escriba el tamaño de los buzones intermedios a generar: ");
        Consola.buzIntermedios= input.nextInt();
        System.out.println("Escriba el tamaño de los buzones extremos a generar: ");
        Consola.buzExtremo= input.nextInt();




    }
    public static Buzon crearBuzon(int cap) {
    	Buzon b=new Buzon(cap);
    	return b;
    }






    public static void main(String[] args) {

Consola main = new Consola();
        main.menu();
        ArrayList <Buzon> b1 = new ArrayList();
 
        Buzon b;
        Buzon ultimo;
        ultimo=null;
        for (int i=0; i<11; i++) {
        	if (i==0) {
        		b = new Buzon(buzExtremo);
                b1.add(b);
                new procesoi(b1.get(b1.size()-1),0,0,n).start() ;
                ultimo=b1.get(b1.size()-1);
                
        	}
        	if (0<i && i<10) {
        		if (i<4) {
        			b = new Buzon(buzIntermedios);
        			b1.add(b);
        			new Procesot(ultimo,b1.get(b1.size()-1),1,i,n).start();
        			
        			
        		}        		
        		
        		else if (i<7) {
        			b = new Buzon(buzIntermedios);
            		b1.add(b);
        			new Procesot(b1.get(i-3),b1.get(b1.size()-1),2,(i-3),n).start();
        		}
        			
        		else if (i<10){
        			if (i==7) {
        				b = new Buzon(buzExtremo);
                        b1.add(b);
        			}
        			new Procesot(b1.get(i-3),b1.get(b1.size()-1),3,(i-6),n).start();
        			
        		}
        		//ultimo=b1.get(b1.size()-1);
        	}
        	else {
                new procesof(b1.get(b1.size()-1),4,1,n).start() ;
        	}
        }
        //System.out.println((b1.get(0)).darm());
        
    }


}
