package pt.c40task.l05wumpus;

import pt.c40task.l05wumpus.componentes.*;

public class ControleJogo {
	private int pontuacao;
	private char status;
	
	public ControleJogo() {
		this.pontuacao = 0;
		this.status = 'x';
	}
	
	public static boolean valido(int i, int j) {
		if (0 <= i && i < 4 && 0 <= j && j < 4) {
			return true;
		}
		System.out.println("Movimento invalido");
		return false;
	}
	
	public void printa(Caverna caverna) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(caverna.board[i][j]);
//				caverna.cave[i][j].printaComponentes();
//				System.out.println();
			}
			System.out.println();
		}
	}
	
	public void executar(Caverna caverna, Heroi heroi, char comando) {
		if (comando == 'w') {
			// cima
			if (!valido(heroi.getLinha() - 1, heroi.getColuna())) return;
			caverna.cave[heroi.getLinha()][heroi.getColuna()].pop_back();
			heroi.setLinha(heroi.getLinha() - 1);
			caverna.cave[heroi.getLinha()][heroi.getColuna()].push_back(heroi);
			this.pontuacao -= 15;
		} else if (comando == 's') {
			// baixo
			if (!valido(heroi.getLinha() + 1, heroi.getColuna())) return;
			caverna.cave[heroi.getLinha()][heroi.getColuna()].pop_back();
			heroi.setLinha(heroi.getLinha() + 1);
			caverna.cave[heroi.getLinha()][heroi.getColuna()].push_back(heroi);
			this.pontuacao -= 15;
		} else if (comando == 'a') {
			// esquerda
			if (!valido(heroi.getLinha(), heroi.getColuna() - 1)) return;
			caverna.cave[heroi.getLinha()][heroi.getColuna()].pop_back();
			heroi.setColuna(heroi.getColuna() - 1);
			caverna.cave[heroi.getLinha()][heroi.getColuna()].push_back(heroi);
			this.pontuacao -= 15;
		} else if (comando == 'd') {
			// direita
			if (!valido(heroi.getLinha(), heroi.getColuna() + 1)) return;
			caverna.cave[heroi.getLinha()][heroi.getColuna()].pop_back();
			heroi.setColuna(heroi.getColuna() + 1);
			caverna.cave[heroi.getLinha()][heroi.getColuna()].push_back(heroi);
			this.pontuacao -= 15;
		} else if (comando == 'k') {
			// equipa flecha
			if (heroi.isFlecha()) heroi.setEngatilhada(true);
			else System.out.println("Voce nao tem flecha\n");
			return;
		} else if (comando == 'c') {
			// coleta o ouro
			if (caverna.cave[heroi.getLinha()][heroi.getColuna()].tem('O')) {
				caverna.cave[heroi.getLinha()][heroi.getColuna()].remove('O');
				heroi.setOuro(true);
			} else {
				System.out.println("Nao tem ouro nesta sala\n");
			}
		}
		if (caverna.cave[heroi.getLinha()][heroi.getColuna()].tem('B')) {
			this.status = 'n';
			this.pontuacao -= 1000;
		}
		if (caverna.cave[heroi.getLinha()][heroi.getColuna()].tem('W')) {
			if (heroi.isEngatilhada() && heroi.atacar() == 1) {
				System.out.println("Voce matou o Wumpus");
				caverna.cave[heroi.getLinha()][heroi.getColuna()].remove('W'); // remove o wumpus
				this.pontuacao += 500; // ganha pontuacao
				System.out.println("PONTUACAO: " + this.pontuacao);
			} else {
				this.status = 'n';
				this.pontuacao -= 1000;
			}
		} else if (heroi.isEngatilhada()) {
			heroi.setEngatilhada(false);
			heroi.setFlecha(false);
		}
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
}