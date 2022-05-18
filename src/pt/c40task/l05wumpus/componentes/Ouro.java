package pt.c40task.l05wumpus.componentes;

import pt.c40task.l05wumpus.Caverna;

public class Ouro extends Componente{

	public Ouro(int linha, int coluna, Caverna caverna) {
		super('O', 4, linha, coluna, caverna);
	}
	
	@Override
	public void interagir() {
		System.out.println("Voce encontrou Ouro!");
	}
	
	public void coletouOuro() {
		System.out.println("Voce coletou o Ouro!");

	}

}
