
public class procesoi extends Thread {
	private int nMensajes; 
	private String datos;
	private Buzon salida;
	private int nivel;
	private int M;
	private String txt;
	public procesoi ( Buzon s, int n, int m, int z) {
		salida=s;
		nivel=n;
		M=m;
		nMensajes=z;
		
	}
	public void run(){
		Thread.yield();
		while (nMensajes>0) {
			while(salida.darm().size()>=salida.darc()){
		   		Thread.yield();
			}	
			M+=1;
			txt="";
			transformar();
			salida.poneri(txt);
			nMensajes-=1;
		}
		int e = 0;
		while (e<3) {
			while(salida.darm().size()>=salida.darc()){
		   		Thread.yield();
			}
		
			salida.poneri("FIN");
			e+=1;
		}
		
		
		
	}
	public void transformar() {
		txt+=("M"+String.valueOf(M));
	}
	

}

