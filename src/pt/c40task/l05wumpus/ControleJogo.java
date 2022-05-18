package pt.c40task.l05wumpus;

import pt.c40task.l05wumpus.componentes.*;

public class ControleJogo {
	private int pontuacao;
	private char status;
	private Heroi heroi;
	
	public ControleJogo(Heroi heroi) {
		this.pontuacao = 0;
		this.status = 'x';
		this.setHeroi(heroi);
	}
	
	public boolean valido(int i, int j) {
		if (0 <= i && i < 4 && 0 <= j && j < 4) {
			return true;
		}
		System.out.println("Movimento invalido");
		return false;
	}
	
	public boolean cavernaValida(Caverna caverna) {
		int cntB = 0, cntP = 0, cntW = 0, cntO = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (Componente c : caverna.getSalas()[i][j].getComponentes()) {
					if (c.getID() == 'B')
						cntB++;
					if (c.getID() == 'P')
						cntP++;
					if (c.getID() == 'W')
						cntW++;
					if (c.getID() == 'O')
						cntO++;
				}
			}
		}
		return 2 <= cntB && cntB <= 3 && cntP == 1 && cntW == 1 && cntO == 1;
	}
	
	public void printa(Caverna caverna) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(caverna.getBoard()[i][j]);
//				caverna.getSalas()[i][j].printaComponentes();
//				System.out.println();
			}
			System.out.println();
		}
	}
	
	public void executar(Caverna caverna, char comando) {
		if (comando == 'w' || comando == 's' || comando == 'a' || comando == 'd') {
			if (getHeroi().move(comando))
				this.pontuacao -= 15;
		} else if (comando == 'k') {
			// equipa flecha
			if (getHeroi().isFlecha()) getHeroi().setEngatilhada(true);
			else System.out.println("Voce nao tem flecha\n");
			return;
		} else if (comando == 'c') {
			// coleta o ouro
			if (caverna.getSalas()[getHeroi().getLinha()][getHeroi().getColuna()].tem('O')) {
				caverna.getSalas()[getHeroi().getLinha()][getHeroi().getColuna()].remove('O');
				getHeroi().setOuro(true);
			} else {
				System.out.println("Nao tem ouro nesta sala\n");
			}
		} else {
			System.out.println("Comando invalido");
		}
		if (caverna.getSalas()[getHeroi().getLinha()][getHeroi().getColuna()].tem('B')) {
			this.status = 'n';
			this.pontuacao -= 1000;
		}
		if (caverna.getSalas()[getHeroi().getLinha()][getHeroi().getColuna()].tem('W')) {
			if (getHeroi().isEngatilhada() && getHeroi().atacar() == 1) {
				System.out.println("Voce matou o Wumpus");
				caverna.getSalas()[getHeroi().getLinha()][getHeroi().getColuna()].remove('W'); // remove o wumpus
				this.pontuacao += 400; // ganha pontuacao
			} else {
				this.status = 'n';
				this.pontuacao -= (1000 + 100 * (getHeroi().isEngatilhada() ? 1 : 0));
			}
		} else if (getHeroi().isEngatilhada()) {
			this.pontuacao -= 100;
			getHeroi().setEngatilhada(false);
			getHeroi().setFlecha(false);
		}
		if (!caverna.getSalas()[getHeroi().getLinha()][getHeroi().getColuna()].isVisitado())
			caverna.getSalas()[getHeroi().getLinha()][getHeroi().getColuna()].interagir();
		caverna.getSalas()[getHeroi().getLinha()][getHeroi().getColuna()].setVisitado(true);
	}
	
	// Getters e Setters

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}
}