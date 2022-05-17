package pt.c40task.l05wumpus.componentes;

public class Buraco extends Componente{
	
	public Buraco() {
		super('B', 4);
	}
	
	@Override
	public void interagir() {
		System.out.println("Voce caiu no Buraco!");
	}

}
