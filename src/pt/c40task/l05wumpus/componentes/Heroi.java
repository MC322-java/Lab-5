package pt.c40task.l05wumpus.componentes;

import java.util.Random;

public class Heroi extends Componente{

	private boolean flecha;
	private boolean engatilhada; 
	private boolean ouro;
	private int linha;
	private int coluna;
	
	public Heroi(int linha, int coluna) {
		super('P', 3);
		this.flecha = true;
		this.engatilhada = false;
		this.ouro = false;
		this.linha = linha;
		this.coluna = coluna;
	}

	public int atacar() {
		int num;
		Random rand = new Random();
		num = (2 + rand.nextInt() % 2) % 2;
		this.setFlecha(false);
		this.setEngatilhada(false);
		return num;
	}
//	
//	@Override
//	public void interagir() {
//		System.out.println("O heroi esta na casa (" + (this.linha + 1) + ", " + (this.coluna + 1) + ")");
//	}
	
	// Getters e Setters
	public boolean isEngatilhada() {
		return engatilhada;
	}

	public void setEngatilhada(boolean engatilhada) {
		this.engatilhada = engatilhada;
	}

	public boolean isFlecha() {
		return flecha;
	}

	public void setFlecha(boolean flecha) {
		this.flecha = flecha;
	}

	public boolean isOuro() {
		return ouro;
	}

	public void setOuro(boolean ouro) {
		this.ouro = ouro;
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
}
	

