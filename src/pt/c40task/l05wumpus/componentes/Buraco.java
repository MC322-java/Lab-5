package pt.c40task.l05wumpus.componentes;

import java.util.*;

import pt.c40task.l05wumpus.Caverna;

public class Buraco extends Componente{
	
	public Buraco(int linha, int coluna, Caverna caverna) {
		super('B', 4, linha, coluna, caverna);
	}
	
	@Override
	public void interagir() {
		System.out.println("Voce caiu no Buraco!");
	}
	
	public ArrayList<Brisa> getBrisas() {
		ArrayList<Brisa> brisas = new ArrayList<Brisa>();
		brisas.add(new Brisa(linha - 1, coluna, caverna));
		brisas.add(new Brisa(linha + 1, coluna, caverna));
		brisas.add(new Brisa(linha, coluna - 1, caverna));
		brisas.add(new Brisa(linha, coluna + 1, caverna));
		return brisas;
	}

}
