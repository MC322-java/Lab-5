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
//      arquivoMovimentos = "alksdjf";
      Caverna caverna = new Caverna();
      Montador.montaCaverna(caverna, cave);
	  caverna.atualizaCaverna();
      ControleJogo jogo = new ControleJogo(new Heroi(0, 0, caverna));
      caverna.getSalas()[0][0].setVisitado(true);
      caverna.getSalas()[0][0].interagir();
      caverna.atualizaCaverna();
      String nome = "Alcebiades";
      if (!jogo.cavernaValida(caverna)) {
    	  System.out.println("Caverna invalida");
    	  return;
      }
      boolean interativo = (arquivoMovimentos != null);
      if (interativo) {
    	  System.out.println("=== Caverna");
    	  System.out.print("Digite seu nome: ");
    	  nome = jogo.scanner();
      }
      jogo.printa(caverna);
      tk.writeBoard(caverna.getBoard(), jogo.getPontuacao(), jogo.getStatus());
      String movements = tk.retrieveMovements();
      if (interativo) {
    	  while (true) {
    		  String comando = jogo.scanner();
    		  jogo.executar(caverna, comando.charAt(0));
    		  caverna.atualizaCaverna();
    		  jogo.printa(caverna);
	    	  tk.writeBoard(caverna.getBoard(), jogo.getPontuacao(), jogo.getStatus());
	    	  System.out.println("Jogador: " + nome);
	    	  System.out.println("Pontuacao: " + jogo.getPontuacao());
	    	  System.out.println("Status: " + jogo.getStatus());
	    	  if (movements.charAt(0) == 'q' || jogo.getStatus() != 'x')	
	    		  break;
    	  }
      } else {
	      for (int i = 0; i < movements.length(); i++) {
	    	  jogo.executar(caverna, movements.charAt(i));
	    	  caverna.atualizaCaverna();
	    	  jogo.printa(caverna);
	    	  tk.writeBoard(caverna.getBoard(), jogo.getPontuacao(), jogo.getStatus());
	    	  System.out.println("Jogador: " + nome);
	    	  System.out.println("Pontuacao: " + jogo.getPontuacao());
	    	  System.out.println("Status: " + jogo.getStatus());
	    	  if (movements.charAt(0) == 'q' || jogo.getStatus() != 'x')
	    		  break;
	      }
      }
      tk.writeBoard(caverna.getBoard(), jogo.getPontuacao(), jogo.getStatus());
      if (jogo.getStatus() == 'w')
    	  System.out.println("Voce ganhou =D !!!");
      else if (jogo.getStatus() == 'n')
    	  System.out.println("Voce perdeu =( ...");
      else if (jogo.getStatus() == 'x')
    	  System.out.println("Volte sempre !!!");
      tk.stop();
   }

}
