
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
        System.out.println("Escriba el numero de subconjuntos a generar: ");
        Scanner input = new Scanner (System.in);
        this.n= input.nextInt();
        System.out.println("Escriba el tamaño de los buzones intermedios a generar: ");
        this.buzIntermedios= input.nextInt();
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
        List <Buzon> b1 = new ArrayList();
        Buzon b;
        Buzon ultimo;
        ultimo=null;
        for (int i=0; i<11; i++) {
        	if (i==0) {
        		b = new Buzon(buzExtremo);
                b1.add(b);
                new Procesot(ultimo,b,0,0,n).start() ;
                ultimo=b;
        	}
        	if (0<i && i<10) {
        		b = new Buzon(buzIntermedios);
        		b1.add(b);
        		if (i<4) {
        			new Procesot(ultimo,b,1,i,n).start() ;
        		}
        		else if (i<7) {
        			new Procesot(ultimo,b,2,(i-3),n).start() ;
        		}
        		else{
        			new Procesot(ultimo,b,3,(i-6),n).start() ;
        		}
        		ultimo=b;
        	}
        	else {
                new Procesot(ultimo,null,4,1,n).start() ;
        	}
        }
        System.out.println((b1.get(0)).darm());
        
    }


}
