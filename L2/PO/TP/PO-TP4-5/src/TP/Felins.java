package TP;

public abstract class Felins extends Animaux{
	
	
	public Felins(String nom, int age) {
		super(nom, age);

	}

	@Override
	public String toString() {
		return super.toString() + " C'est un Filin .";
	}

	@Override
	public abstract int getLongvite();
	

}
