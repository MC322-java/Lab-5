package pt.c40task.l05wumpus;

//import java.util.Scanner;

import pt.c40task.l05wumpus.componentes.*;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
//	   AppWumpus.executaJogo();
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
//   public static void executaJogo() {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      String cave[][] = tk.retrieveCave();
//	  String cave[][] = {
//			  {"1", "1", "_"},
//			  {"1", "2", "_"},
//			  {"1", "3", "B"},
//			  {"1", "4", "_"},
//			  {"2", "1", "_"},
//			  {"2", "2", "B"},
//			  {"2", "3", "_"},
//			  {"2", "4", "_"},
//			  {"3", "1", "_"},
//			  {"3", "2", "B"},
//			  {"3", "3", "W"},
//			  {"3", "4", "B"},
//			  {"4", "1", "_"},
//			  {"4", "2", "_"},
//			  {"4", "3", "_"},
//			  {"4", "4", "O"}
//	  };
      Caverna caverna = Montador.montaCaverna(cave);
      Heroi heroi = new Heroi(0, 0);
      caverna.cave[0][0].push_back(heroi);
	  caverna.cave[0][0].setVisitado(true);
	  caverna.cave[0][0].interagir();
	  caverna.atualizaCaverna();
      ControleJogo jogo = new ControleJogo();
//      jogo.printa(caverna);
      tk.writeBoard(caverna.board, jogo.getPontuacao(), jogo.getStatus());
      String movements = tk.retrieveMovements();
//      Scanner sc = new Scanner(System.in);
      for (int i = 0; i < movements.length(); i++) {
//      for (int i = 0; ; i++) {
//    	  String comando = sc.next();
    	  jogo.executar(caverna, heroi, movements.charAt(i));
//    	  jogo.executar(caverna, heroi, comando.charAt(0));
    	  caverna.cave[heroi.getLinha()][heroi.getColuna()].setVisitado(true);
    	  caverna.cave[heroi.getLinha()][heroi.getColuna()].interagir();
    	  caverna.atualizaCaverna();
//    	  jogo.printa(caverna);
    	  tk.writeBoard(caverna.board, jogo.getPontuacao(), jogo.getStatus());
    	  if (heroi.getLinha() == 0 && heroi.getColuna() == 0 && heroi.isOuro()) {
    		  jogo.setStatus('w');
    		  jogo.setPontuacao(jogo.getPontuacao() + 1000);
    	  }
    	  System.out.println("Pontuacao: " + jogo.getPontuacao());
    	  System.out.println("Status: " + jogo.getStatus());
//    	  if (comando.charAt(0) == 'q' || jogo.getStatus() != 'x')
//    		  break;
    	  if (movements.charAt(0) == 'q' || jogo.getStatus() != 'x')
    		  break;
      }
//      sc.close();
      tk.writeBoard(caverna.board, jogo.getPontuacao(), jogo.getStatus());
      if (jogo.getStatus() == 'w')
    	  System.out.println("Voce ganhou =D !!!");
      else if (jogo.getStatus() == 'n')
    	  System.out.println("Voce perdeu =( ...");
      else if (jogo.getStatus() == 'x')
    	  System.out.println("Volte sempre !!!");
      tk.stop();
   }

}
