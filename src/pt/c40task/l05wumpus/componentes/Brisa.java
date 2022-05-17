package pt.c40task.l05wumpus.componentes;

public class Brisa extends Componente {
	
	public Brisa() {
		super('b', 1);
	}
	
	@Override
	public void interagir() {
		System.out.println("Voce sente uma leve Brisa!");
	}

}
