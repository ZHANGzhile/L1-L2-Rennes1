package TP;

public class Panthere extends Felins{

	public Panthere(String nom, int age) {
		super(nom, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " C'est un Panthere .";
	}

	@Override
	public int getLongvite() {
		// TODO Auto-generated method stub
		return 15;
	}

	
}
