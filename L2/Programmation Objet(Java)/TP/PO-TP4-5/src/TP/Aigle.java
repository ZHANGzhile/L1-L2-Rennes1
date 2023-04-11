package TP;

public class Aigle extends Oiseaux{


	public Aigle(String nom, int age, int nbSpect) {
		super(nom, age, nbSpect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " C'est un Aigle . ";
	}

	@Override
	public int getLongvite() {
		// TODO Auto-generated method stub
		return 14;
	}
	
	

}
