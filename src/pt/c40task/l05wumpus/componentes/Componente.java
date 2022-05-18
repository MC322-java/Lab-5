package pt.c40task.l05wumpus.componentes;

import pt.c40task.l05wumpus.*;

public class Componente {
	private char ID;
	private int peso;
	protected int linha;
	protected int coluna;
	protected Caverna caverna;
	
	public Componente() {}

	public Componente(int linha, int coluna, Caverna caverna) {
		this.setID('#');
		this.setPeso(0);
		this.setLinha(linha);
		this.setColuna(coluna);
		this.setCaverna(caverna);
	}
	
	public Componente(char ID, int peso, int linha, int coluna, Caverna caverna) {
		this.setID(ID);
		this.setPeso(peso);
		this.setLinha(linha);
		this.setColuna(coluna);
		this.setCaverna(caverna);
	}

	public void interagir() {
		System.out.println("Voce entrou numa sala vazia");
	}
	
	public void remove() {
		caverna.getSalas()[linha][coluna].remove(ID);
	}
	
	public void adiciona() {
		caverna.getSalas()[linha][coluna].push_back(this);
	}
	
	// Getters e Setters
	
	public char getID() {
		return ID;
	}

	public void setID(char iD) {
		ID = iD;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Caverna getCaverna() {
		return caverna;
	}

	public void setCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
}
