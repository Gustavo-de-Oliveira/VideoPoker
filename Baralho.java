import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baralho {
	private ArrayList<Cartas> baralho;
	private ArrayList<Cartas> mao;
	
	Cartas cartas;
	
	public String getBaralho() {
 		return baralho.toString();
 	}
 	
 	public String getMao() {
 		return mao.toString();
 	}
	
	public Baralho() {
		baralho = new ArrayList<Cartas>(); 
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				cartas = new Cartas(i, j);
				baralho.add(cartas);
			}
		}
	}
	
	public void DarMao() {
		Random rand = new Random();
		int r = -1;
		mao = new ArrayList<Cartas>();
		for (int i = 0; i < 5; i++) {
			r = rand.nextInt(baralho.size()-1);
			mao.add(baralho.get(r));
			baralho.remove(r);
		}
	}
	
	public void TrocarMao(String str) {
		int[] pos;
		int n = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ') {
				n++;
			}
		}
		
		pos = new int[n]; n = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ') {
				pos[n] = Integer.parseInt(Character.toString(str.charAt(i))) - 1;
			}
		}
		
		if(pos.length > 0 && pos.length < 6) {
			Random rand = new Random();
			int r = -1;
			for (int i = 0; i < pos.length; i++) {				
				r = rand.nextInt(baralho.size()-1);
				mao.set(pos[i], baralho.get(r));
				baralho.remove(r);
			}
		}
	}
	
	public void OrganizarMao() {		 
		ArrayList<Cartas> aux;
		aux = new ArrayList<Cartas>();
		int menor = 20;
		int id = 20;
		
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < mao.size(); j++) {
				if(mao.get(j).getValor() < menor) {
					id = j;
					menor = mao.get(j).getValor();
					}
		 		}
			aux.add(mao.get(id));
			mao.remove(id);
			id = 20;
			menor = 20;
		}		
		mao = aux;
	}
	
	public int Pontos() {
		int p = 0;
		
		OrganizarMao();
		
		//Royal Straight Flush 
		if(mao.get(0).getNaipe() == mao.get(1).getNaipe() && mao.get(0).getNaipe() == mao.get(2).getNaipe() && mao.get(0).getNaipe() ==  mao.get(3).getNaipe() && mao.get(0).getNaipe() == mao.get(4).getNaipe()) {
		  if(mao.get(0).getValor() == 10 && mao.get(1).getValor() == 11 && mao.get(2).getValor() == 12 && mao.get(3).getValor() == 13 && mao.get(4).getValor() == 14) { 
			  return 200; 
			  } 
		  }
		  
		//Straight Flush 
		if(mao.get(0).getNaipe() == mao.get(1).getNaipe() && mao.get(0).getNaipe() == mao.get(2).getNaipe() && mao.get(0).getNaipe() == mao.get(3).getNaipe() && mao.get(0).getNaipe() == mao.get(4).getNaipe()) {
		  if(mao.get(0).getValor() == mao.get(1).getValor()-1 && mao.get(1).getValor() == mao.get(2).getValor()-1 && mao.get(2).getValor() == mao.get(3).getValor()-1 && mao.get(3).getValor() == mao.get(4).getValor()-1) { 
			  return 100; 
			  } 
		  }
		  
		//Quadra 
		if(mao.get(0).getValor() == mao.get(1).getValor() && mao.get(0).getValor() == mao.get(2).getValor() && mao.get(0).getValor() == mao.get(3).getValor()) return 50;
		if(mao.get(1).getValor() == mao.get(2).getValor() && mao.get(1).getValor() == mao.get(3).getValor() && mao.get(1).getValor() == mao.get(4).getValor()) return 50;
		
		//FullHouse
		if(mao.get(0).getValor() == mao.get(1).getValor() || mao.get(1).getValor() == mao.get(2).getValor() || mao.get(2).getValor() == mao.get(3).getValor() || mao.get(3).getValor() == mao.get(4).getValor()) {
			if((mao.get(0).getValor() == mao.get(1).getValor() && mao.get(0).getValor() == mao.get(2).getValor()) || (mao.get(1).getValor() == mao.get(2).getValor() && mao.get(1).getValor() == mao.get(3).getValor()) || (mao.get(2).getValor() == mao.get(3).getValor() && mao.get(2).getValor() == mao.get(4).getValor())) {
				return 20;
			}
		}
		
		//Flush
		if(mao.get(0).getNaipe() == mao.get(1).getNaipe() && mao.get(0).getNaipe() == mao.get(2).getNaipe() && mao.get(0).getNaipe() ==  mao.get(3).getNaipe() && mao.get(0).getNaipe() == mao.get(4).getNaipe()) {
			return 10;
		}
		
		//Straigh
		if(mao.get(0).getValor() == mao.get(1).getValor()-1 && mao.get(1).getValor() == mao.get(2).getValor()-1 && mao.get(2).getValor() == mao.get(3).getValor()-1 && mao.get(3).getValor() == mao.get(4).getValor()-1) { 
			return 5; 
		}
		
		//Trinca
		if((mao.get(0).getValor() == mao.get(1).getValor() && mao.get(0).getValor() == mao.get(2).getValor()) || (mao.get(1).getValor() == mao.get(2).getValor() && mao.get(1).getValor() == mao.get(3).getValor()) || (mao.get(2).getValor() == mao.get(3).getValor() && mao.get(2).getValor() == mao.get(4).getValor())) {
			return 2;
		}
		
		//Dois Pares
		if(mao.get(0).getValor() == mao.get(1).getValor()) {
			if(mao.get(1).getValor() == mao.get(2).getValor()) return 1;
			if(mao.get(2).getValor() == mao.get(3).getValor()) return 1;
			if(mao.get(3).getValor() == mao.get(4).getValor()) return 1;
		}
		if(mao.get(1).getValor() == mao.get(2).getValor()) {
			if(mao.get(2).getValor() == mao.get(3).getValor()) return 1;
			if(mao.get(3).getValor() == mao.get(4).getValor()) return 1;
		}
		if(mao.get(2).getValor() == mao.get(3).getValor()) {
			if(mao.get(0).getValor() == mao.get(1).getValor()) return 1;
		}
		if(mao.get(3).getValor() == mao.get(4).getValor()) {
			if(mao.get(0).getValor() == mao.get(1).getValor()) return 1;
			if(mao.get(1).getValor() == mao.get(2).getValor()) return 1;			
		}
		
		return p;
	}
	
}
