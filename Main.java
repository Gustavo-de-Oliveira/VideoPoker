import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Baralho baralho = new Baralho();

		String jogarNov = "", trocaMao = "";

		int aposta, premio;


		Jogador pessoa = new Jogador();		

		do {
			
			baralho = new Baralho();
			System.out.println("Olá!!\n\nBem vindo ao Videopoker!\n\nCréditos disponíveis: " +pessoa.getCreditos() + "\n\nQuantos créditos deseja apostar?");


			try {

				aposta = EntradaTeclado.leInt();

			} catch (Exception e) {

				System.out.println("Voce digitou um valor não compativel, comece novamente.");
				return;
			}
			
			pessoa.setApostado(aposta);
			
			pessoa.setCreditos(pessoa.getCreditos() - aposta);			

			baralho.DarMao();
			baralho.OrganizarMao();
			System.out.println(baralho.getMao()+"\n");



			System.out.println("Quais cartas deseja fazer a troca? Digite seus índices separados por espaços se sim e 'N' se não quer trocas.");
			try {
				trocaMao = EntradaTeclado.leString();
			} catch (Exception e1) {
				System.out.println("Valor nao identificado, vamos considerar que não quer trocar nenhuma carta.");
				trocaMao = "N";
			}
			
			
			if (trocaMao.compareTo("N") != 0 && trocaMao.compareTo("n") != 0) {
				
				baralho.TrocarMao(trocaMao);
				
				baralho.OrganizarMao();
				System.out.println(baralho.getMao()+"\n");
				
				System.out.println("Quais cartas deseja fazer a 2a troca? Digite seus índices separados por espaços se sim e 'N' se não quer mais trocas.");
				try {
					trocaMao = EntradaTeclado.leString();
				} catch (Exception e) {
					System.out.println("Valor nao identificado, vamos considerar que não quer trocar nenhuma carta.");
					trocaMao = "N";
				}

				if (trocaMao.compareTo("N") != 0 && trocaMao.compareTo("n") != 0) {
					baralho.TrocarMao(trocaMao);				
				}  

			}
					
			premio = baralho.Pontos();

			baralho.OrganizarMao();
			System.out.println(baralho.getMao()+"\n");
			
			System.out.println("Voce recebeu:\n"+premio*pessoa.getApostado());
			pessoa.setCreditos(premio*pessoa.getApostado() + pessoa.getCreditos());

			
			System.out.println("Deseja jogar novamente (S) ou deixar o jogo (N)?");
			try {
				jogarNov = EntradaTeclado.leString();
			} catch (Exception e) {
				System.out.println("Valor nao identificado, vamos considerar que não quer jogar novamente.");
				trocaMao = "N";
			}

			if (trocaMao.compareTo("N") == 0 && trocaMao.compareTo("n") == 0){				
				return;
			}
			
			if(pessoa.getCreditos() == 0) {
				System.out.println("O jogo será finalizado, você não possui créditos para continuar!\n\n");
				return;
			}

		}while(true); 

	}

}
