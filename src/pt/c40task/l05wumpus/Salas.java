package pt.c40task.l05wumpus;

import pt.c40task.l05wumpus.componentes.*;

import java.util.*;

public class Salas {
	private boolean visitado;
	
	private ArrayList<Componente> componentes;
	
	public Salas() {
		this.setComponentes(new ArrayList<Componente>());
		this.visitado = false;
	}
	
	public Salas(ArrayList<Componente> a) {
		this.setComponentes(a);
	}
	
	public char printaSala() {
		if (!this.visitado)
			return '-';
		Componente melhor = new Componente();
		int max = -1;
		for (int i = 0; i < getComponentes().size(); i++) {
			if (getComponentes().get(i).getPeso() > max) {
				max = getComponentes().get(i).getPeso();
				melhor = getComponentes().get(i);
			}
		}
		return melhor.getID();
	}
	
	public void interagir() {
		if (this.getComponentes().size() == 1 && this.getComponentes().get(0).getID() == 'P') {
			Componente c = new Componente();
			c.interagir();
			return;
		}
		for (Componente c : this.getComponentes()) {
			if (c.getID() != 'P') 
				c.interagir();
		}
	}
	
	public void printaComponentes() {
		for (Componente c : this.getComponentes()) {
			System.out.print(c.getID() + " ");
		}
	}
	
	public boolean tem(char ch) {
		for (Componente c : this.getComponentes()) {
			if (c.getID() == ch)
				return true;
		}
		return false;
	}
	
	public void remove(char ch) {
		int idx = -1;
		for (Componente c : this.getComponentes()) {
			if (c.getID() == ch) {
				idx = this.getComponentes().indexOf(c);
				break;
			}
		}
		if (idx != -1)
			this.getComponentes().remove(idx);
	}
	
	public void pop_back() {
		if (!this.getComponentes().isEmpty())
			getComponentes().remove(this.getComponentes().size() - 1);
	}
	
	public void push_back(Componente c) {
		this.getComponentes().add(c);
	}
	
	public void setVisitado(boolean v) {
		visitado = v;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
}
