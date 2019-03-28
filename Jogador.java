public class Jogador {

   private int creditos = 200;
   private int apostados;
    	
 
   public int getCreditos() {
	   return creditos;
   }
   
   public void setCreditos(int creditos) {
	   this.creditos = creditos;
   }
   
   public int getApostado() {
	   return apostados;
   }
   
   public void setApostado(int aposta) {
	   apostados = apostados + aposta;
   }
   
}