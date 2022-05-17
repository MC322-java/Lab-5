package pt.c40task.l05wumpus.componentes;

public class Ouro extends Componente{

	public Ouro() {
		super('O', 4);
	}
	
	@Override
	public void interagir() {
		System.out.println("Voce encontrou Ouro!");
	}
	
	public void coletouOuro() {
		System.out.println("Voce coletou o Ouro!");

	}

}
