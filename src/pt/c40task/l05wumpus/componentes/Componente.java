package pt.c40task.l05wumpus.componentes;

public class Componente {
	private char ID;
	private int peso;

	public Componente() {
		this.setID('#');
		this.setPeso(0);
	}
	
	public Componente(char ID, int peso) {
		this.setID(ID);
		this.setPeso(peso);
	}

	public void interagir() {
		System.out.println("Voce entrou numa sala vazia");
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
}
