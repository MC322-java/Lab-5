package pt.c40task.l05wumpus.componentes;

public class Wumpus extends Componente{
	
	public Wumpus() {
		super('W', 4);
	}
	
	@Override
	public void interagir() {
		System.out.println("Voce encotrou o Wumpus!!");
	}

}
