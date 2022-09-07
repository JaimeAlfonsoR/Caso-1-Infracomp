
public class procesof extends Thread {
	private int nMensajes; 
	private String datos;
	private Buzon entrada;
	private int nivel;
	private int M;
	private String txt;
	public procesof (Buzon e, int n, int m, int z) {
		entrada=e;
		nivel=n;
		M=m;
		nMensajes=z;
		
	}
	public void run(){
			int e=0;
			while (nMensajes>0 && txt!="FIN") {
				while (entrada.darm().size()<=0){
					//System.out.println(entrada.darm());
					Thread.yield();
		    	}
				txt=entrada.quitarf();
				System.out.println(txt);
				nMensajes-=1;
				
			}
			
			while (e<3) {
				while(entrada.darm().size()<=0){
					//System.out.println(entrada.darm());
					Thread.yield();
		    	}
				txt=entrada.quitarf();
                
				System.out.println(txt);
				e+=1;
			}
		}	
		
	
	


}
