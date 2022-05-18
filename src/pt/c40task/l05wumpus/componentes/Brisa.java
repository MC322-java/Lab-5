package pt.c40task.l05wumpus.componentes;

import pt.c40task.l05wumpus.Caverna;

public class Brisa extends Componente {
	
	public Brisa(int linha, int coluna, Caverna caverna) {
		super('b', 1, linha, coluna, caverna);
	}
	
	@Override
	public void interagir() {
		System.out.println("Voce sente uma leve Brisa!");
	}

}
