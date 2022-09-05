
public class Procesot extends Thread {
	private static int nMensajes; 
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
		Procesot.nMensajes=z;
		
	}
	public void run(){
		if (nivel==0) {
			while (nMensajes>0) {
				M+=1;
				txt="";
				transformari();
				salida.poneri(txt);
				nMensajes-=1;
			}
			
			salida.poneri("FIN");
			salida.poneri("FIN");
			salida.poneri("FIN");
		}
		if (nivel==4) {
			while (txt!="FIN") {
				txt=entrada.quitarf();
			}
			txt=entrada.quitarf();
			txt=entrada.quitarf();
			txt=entrada.quitarf();
		}
		else {
			
		
			while (txt!="FIN") {
				txt=entrada.quitar();
				transformar();
				salida.poner(txt);
				nMensajes-=1;
			}
			salida.poner(txt);
		}	
		
	}
	public void transformar() {
	   txt+=("T"+ String.valueOf(nivel)+String.valueOf(M));
	}
	public void transformari() {
		txt+=("M"+String.valueOf(M));
	}
	

}
