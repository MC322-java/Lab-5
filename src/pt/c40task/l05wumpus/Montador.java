package pt.c40task.l05wumpus;

public abstract class Montador {
	
	public static Caverna montaCaverna(String descricao[][]) {
		Caverna caverna = new Caverna();
		caverna.criarCave();
		for (int i = 0; i < descricao.length; i++) {
			int linha = Integer.parseInt(descricao[i][0]) - 1;
			int coluna = Integer.parseInt(descricao[i][1]) - 1;
			char tipo = descricao[i][2].charAt(0);
			caverna.setSala(linha, coluna, tipo);
			if (tipo == 'B' || tipo == 'W') {
				int dx[] = {1, -1, 0, 0};
				int dy[] = {0, 0, -1, 1};
				for (int k = 0; k < 4; k++) {
					int novaLinha = linha + dx[k];
					int novaColuna = coluna + dy[k];
					if (0 <= novaLinha && novaLinha < 4 && 0 <= novaColuna && novaColuna < 4) {
//						caverna.cave[novaLinha][novaColuna].remove('#');
						caverna.setSala(novaLinha, novaColuna, tipo == 'B' ? 'b' : 'f');
					}
				}
			}
		}
		return caverna;
	}
		
	
}
