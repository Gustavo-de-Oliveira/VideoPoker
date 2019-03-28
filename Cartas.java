public class Cartas extends java.lang.Object{
	private int naipe, valor;
	/*Naipe:
	 * 0 = Paus; 1 = Ouros; 2 = Copas; 3 = Espadas; 
	 * 
	 * Cartas:
	 * J = 11; Q = 12; K = 13; A = 14;
	 * */
	
	public int getNaipe(){
		return naipe;
	}

	public void setNaipe(int naipe){
		this.naipe = naipe;
	}

	public int getValor(){
		return valor;
	}

	public void setValor(int valor){
		this.valor = valor;
	}
	
	public Cartas(int naipe, int valor) {
		this.naipe = naipe;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		String naipe = "", valor = "", str = "";

		//Naipes
		switch (this.naipe) {
		case 0:
			naipe = "Paus";
			break;

		case 1:
			naipe = "Ouros";			
			break;
		
		case 2:
			naipe = "Copas";			
			break;
		
		case 3:
			naipe = "Espadas";			
			break;
		}

		//Valor
		switch (this.valor) {
		case 2:
			valor = "Dois";
			break;
		
		case 3:
			valor = "Três";
			break;
		
		case 4:
			valor = "Quatro";
			break;
			
		case 5:
			valor = "Cinco";
			break;

		case 6:
			valor = "Seis";
			break;
		
		case 7:
			valor = "Sete";
			break;
		
		case 8:
			valor = "Oito";
			break;

		case 9:
			valor = "Nove";
			break;	
			
		case 10:
			valor = "Dez";
			break;

		case 11:
			valor = "Valete(J)";
			break;
		
		case 12:
			valor = "Dama(Q)";
			break;
		
		case 13:
			valor = "Rei(K)";
			break;

		case 14:
			valor = "Às(A)";
			break;
		}
		
		str = valor+" de "+naipe+"\n";
		return str;
	}
	
}
