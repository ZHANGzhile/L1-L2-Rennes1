package TP;

public class Cervides extends Animaux{

	

	public Cervides(String nom, int age) {
		super(nom, age);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + " C'est un Cervide . ";
	}

	@Override
	public int getLongvite() {
		// TODO Auto-generated method stub
		return 20;
	}

	
}
