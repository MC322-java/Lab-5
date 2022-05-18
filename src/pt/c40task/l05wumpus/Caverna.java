package pt.c40task.l05wumpus;

public class Caverna {

	private Salas salas[][];
	
	private char board[][] = {
			{'-','-','-','-'},
			{'-','-','-','-'},
			{'-','-','-','-'},
			{'-','-','-','-'}
		};
		
	public void criarCave() {
		setSalas(new Salas[4][4]);
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
					getSalas()[i][j] = new Salas(i, j, this);
	}
	
	public void atualizaCaverna() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				this.getBoard()[i][j] = getSalas()[i][j].printaSala();
			}
		}
	}

	public Salas[][] getSalas() {
		return salas;
	}

	public void setSalas(Salas salas[][]) {
		this.salas = salas;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char board[][]) {
		this.board = board;
	}
}
