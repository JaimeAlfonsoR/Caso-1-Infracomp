
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
		if (nivel==0) {
			while (nMensajes>0) {
				M+=1;
				txt="";
				transformari();
				salida.poneri(txt);
				nMensajes-=1;
			}
			int e = 0;
			while (e<M) {
			
			salida.poneri("FIN");
			}
		}
		if (nivel==4) {
			while (txt!="FIN") {
				txt=entrada.quitarf();
				System.out.println(txt);
			}
			txt=entrada.quitarf();
			System.out.println(txt);
			txt=entrada.quitarf();
			System.out.println(txt);
			txt=entrada.quitarf();
			System.out.println(txt);
		}
		else {
			
		
			while (txt!="FIN") {
				txt=entrada.quitar();
				transformar();
				salida.poner(txt);
				//nMensajes-=1;
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
