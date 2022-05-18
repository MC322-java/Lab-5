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
			if (heroi.move(comando))
				this.pontuacao -= 15;
		} else if (comando == 'k') {
			heroi.engatilha();
		} else if (comando == 'c') {
			heroi.coletaOuro();
		} else {
			System.out.println("Comando invalido");
		}
		if (caverna.getSalas()[heroi.getLinha()][heroi.getColuna()].tem('B')) {
			this.status = 'n';
			this.pontuacao -= 1000;
		}
		if (caverna.getSalas()[heroi.getLinha()][heroi.getColuna()].tem('W')) {
			if (heroi.isEngatilhada() && heroi.atacar() == 1) {
				System.out.println("Voce matou o Wumpus");
				caverna.getSalas()[heroi.getLinha()][heroi.getColuna()].remove('W'); // remove o wumpus
				this.pontuacao += 400; // ganha pontuacao
			} else {
				this.status = 'n';
				this.pontuacao -= (1000 + 100 * (heroi.isEngatilhada() ? 1 : 0));
			}
		} else if (heroi.isEngatilhada()) {
			heroi.perdeFlecha();
			this.pontuacao -= 100;
		}
		if (!caverna.getSalas()[heroi.getLinha()][heroi.getColuna()].isVisitado())
			caverna.getSalas()[heroi.getLinha()][heroi.getColuna()].interagir();
		caverna.getSalas()[heroi.getLinha()][heroi.getColuna()].setVisitado(true);
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