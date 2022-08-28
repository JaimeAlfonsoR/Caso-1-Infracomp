
import java.util.Scanner;
public class Consola {
    private int n;
    private int buzIntermedios;
    private int buzExtremo;



    public void menu()
    {
        System.out.println("Escriba el numero de subconjuntos a generar: ");
        Scanner input = new Scanner (System.in);
        this.n= input.nextInt();
        System.out.println("Escriba el tamaño de los buzones intermedios a generar: ");
        this.buzIntermedios= input.nextInt();
        System.out.println("Escriba el tamaño de los buzones extremos a generar: ");
        this.buzExtremo= input.nextInt();




    }






    public static void main(String[] args) {

        Consola main = new Consola();
        main.menu();

    }


}
