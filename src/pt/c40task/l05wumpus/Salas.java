package pt.c40task.l05wumpus;

import pt.c40task.l05wumpus.componentes.*;

import java.util.*;

public class Salas {
	private boolean visitado;
	
	private ArrayList<Componente> componentes;
	
	public Salas() {
		this.componentes = new ArrayList<Componente>();
		this.visitado = false;
	}
	
	public Salas(ArrayList<Componente> a) {
		this.componentes = a;
	}
	
	public char printaSala() {
		if (!this.visitado)
			return '-';
		Componente melhor = new Componente();
		int max = -1;
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i).getPeso() > max) {
				max = componentes.get(i).getPeso();
				melhor = componentes.get(i);
			}
		}
		return melhor.getID();
	}
	
	public void interagir() {
		if (this.componentes.size() == 1 && this.componentes.get(0).getID() == 'P') {
			Componente c = new Componente();
			c.interagir();
			return;
		}
		for (Componente c : this.componentes) {
			if (c.getID() != 'P') 
				c.interagir();
		}
	}
	
	public void printaComponentes() {
		for (Componente c : this.componentes) {
			System.out.print(c.getID() + " ");
		}
	}
	
	public boolean tem(char ch) {
		for (Componente c : this.componentes) {
			if (c.getID() == ch)
				return true;
		}
		return false;
	}
	
	public void remove(char ch) {
		int idx = -1;
		for (Componente c : this.componentes) {
			if (c.getID() == ch) {
				idx = this.componentes.indexOf(c);
				break;
			}
		}
		if (idx != -1)
			this.componentes.remove(idx);
	}
	
	public void pop_back() {
		if (!this.componentes.isEmpty())
			componentes.remove(this.componentes.size() - 1);
	}
	
	public void push_back(Componente c) {
		this.componentes.add(c);
	}
	
	public void setVisitado(boolean v) {
		visitado = v;
	}
}
