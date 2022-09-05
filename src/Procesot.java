
public class Procesot extends Thread {
	private String datos;
	private Buzon entrada;
	private Buzon salida;
	private int nivel;
	private int M;
	private String txt;
	public Procesot (Buzon e, Buzon s, int n, int m) {
		entrada=e;
		salida=s;
		nivel=n;
		M=m;
		
	}
	public void run(){
		txt=entrada.quitar();
		transformar();
		salida.poner(txt);
		
	}
	public void transformar() {
	   txt+=("T"+ String.valueOf(nivel)+String.valueOf(M));
	}
	

}
