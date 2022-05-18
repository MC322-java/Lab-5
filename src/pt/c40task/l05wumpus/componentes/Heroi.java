package pt.c40task.l05wumpus.componentes;

import java.util.Random;

import pt.c40task.l05wumpus.Caverna;
import pt.c40task.l05wumpus.Montador;

public class Heroi extends Componente{

	private boolean flecha;
	private boolean engatilhada; 
	private boolean ouro;
	
	public Heroi(int linha, int coluna, Caverna caverna) {
		super('P', 3, linha, coluna, caverna);
		this.flecha = true;
		this.engatilhada = false;
		this.ouro = false;
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
	
	public boolean move(char movimento) {
		int novaLinha = this.getLinha();
		int novaColuna = this.getColuna();
		switch (movimento) {
			case 'w':
				novaLinha--;
				break;
			case 's':
				novaLinha++;
				break;
			case 'a':
				novaColuna--;
				break;
			case 'd':
				novaColuna++;
				break;
			default:
				break;
		}
		if (!Montador.posicaoValida(novaLinha, novaColuna)) {
			System.out.println("Movimento invalido");
			return false;
		}
		this.remove();
		this.setLinha(novaLinha);
		this.setColuna(novaColuna);
		this.adiciona();
		return true;
	}
	
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
}
	

