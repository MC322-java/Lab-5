package pt.c40task.l05wumpus.componentes;

import pt.c40task.l05wumpus.Caverna;

public class Fedor extends Componente{
	
	public Fedor(int linha, int coluna, Caverna caverna) {
		super('f', 2, linha, coluna, caverna);
	}

	@Override
	public void interagir() {
		System.out.println("Voce sente um fedor muito forte!");
	}
}
