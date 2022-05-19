package pt.c40task.l05wumpus;

import pt.c40task.l05wumpus.componentes.*;

public abstract class Montador {
	
	public static Caverna montaCaverna(Caverna caverna, String descricao[][]) {
		caverna.criarCave();
		for (int i = 0; i < descricao.length; i++) {
			int linha = Integer.parseInt(descricao[i][0]) - 1;
			int coluna = Integer.parseInt(descricao[i][1]) - 1;
			char tipo = descricao[i][2].charAt(0);
			Componente novo = null;
			switch (tipo) {
				case 'B':
					novo = new Buraco(linha, coluna, caverna);
					for (Brisa b : ((Buraco) novo).getBrisas()) {
						if (posicaoValida(b.getLinha(), b.getColuna()))
							b.adiciona();
					}
					break;
				case 'P':
					novo = new Heroi(linha, coluna, caverna);
					break;
				case 'O':
					novo = new Ouro(linha, coluna, caverna);
					break;
				case 'W':
					novo = new Wumpus(linha, coluna, caverna);
					for (Fedor f : ((Wumpus) novo).getFedores()) {
						if (posicaoValida(f.getLinha(), f.getColuna()))
							f.adiciona();
					}
					break;
				default: // _
					break;
			}
			if (novo != null) {
				novo.adiciona();
			}
		}
		caverna.atualizaCaverna();
		return caverna;
	}
	
	public static boolean posicaoValida(int linha, int coluna) {
		return 0 <= linha && linha < 4 && 0 <= coluna && coluna < 4;
	}
}
