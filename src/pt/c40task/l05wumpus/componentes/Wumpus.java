package pt.c40task.l05wumpus.componentes;

import java.util.ArrayList;

import pt.c40task.l05wumpus.Caverna;

public class Wumpus extends Componente{
	
	public Wumpus(int linha, int coluna, Caverna caverna) {
		super('W', 4, linha, coluna, caverna);
	}
	
	@Override
	public void interagir() {
		System.out.println("Voce encotrou o Wumpus!!");
	}

	public ArrayList<Fedor> getFedores() {
		ArrayList<Fedor> fedores = new ArrayList<Fedor>();
		fedores.add(new Fedor(linha - 1, coluna, caverna));
		fedores.add(new Fedor(linha + 1, coluna, caverna));
		fedores.add(new Fedor(linha, coluna - 1, caverna));
		fedores.add(new Fedor(linha, coluna + 1, caverna));
		return fedores;
	}
}
