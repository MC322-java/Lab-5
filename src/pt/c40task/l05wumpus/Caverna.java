package pt.c40task.l05wumpus;

import pt.c40task.l05wumpus.componentes.*;

public class Caverna {

	public Salas cave[][];
	
	public char board[][] = {
			{'-','-','-','-'},
			{'-','-','-','-'},
			{'-','-','-','-'},
			{'-','-','-','-'}
		};
		
	public void criarCave() {
		cave =  new Salas[4][4];
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
					cave[i][j] = new Salas();
	}
	
	public void atualizaCaverna() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				this.board[i][j] = cave[i][j].printaSala();
			}
		}
	}
	
	public void setSala(int linha, int coluna, char tipo) {
		Componente novo = null;
		switch (tipo) {
			case 'b':
				novo = new Brisa();
				break;
			case 'B':
				novo = new Buraco();
				break;
			case 'f':
				novo = new Fedor();
				break;
			case 'P':
				novo = new Heroi(linha, coluna);
				break;
			case 'O':
				novo = new Ouro();
				break;
			case 'W':
				novo = new Wumpus();
				break;
			default: // _
				break;
		}
		// fazer a brisa e o fedor separado
		if (novo != null)
			this.cave[linha][coluna].push_back(novo);
	}
}
