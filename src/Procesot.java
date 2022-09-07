
public class Procesot extends Thread {
	private int nMensajes; 
	private String datos;
	private Buzon entrada;
	private Buzon salida;
	private int nivel;
	private int M;
	private String txt;
	public Procesot (Buzon e, Buzon s, int n, int m, int z) {
		entrada=e;
		salida=s;
		nivel=n;
		M=m;
		nMensajes=z;
		
	}
	public void run(){
			
		while ( txt!="FIN" ) {
			
			txt=entrada.quitar();
			if (txt=="FIN") {
				salida.poner(txt);
			}
			else {
				txt=transformar(txt);
				//System.out.println(txt);
				salida.poner(txt);
				nMensajes-=1;
			}	
		}
	
		
	}
	public String transformar(String txt) {
	   txt+=("T"+ String.valueOf(nivel)+String.valueOf(M));
	   return txt;
	}
	

}
