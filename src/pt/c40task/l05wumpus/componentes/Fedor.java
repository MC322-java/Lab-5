package pt.c40task.l05wumpus.componentes;

public class Fedor extends Componente{
	
	public Fedor() {
		super('f', 2);
	}

	@Override
	public void interagir() {
		System.out.println("Voce sente um fedor muito forte!");
	}
}
