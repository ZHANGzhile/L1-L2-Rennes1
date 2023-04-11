package TP;

public class Faucon extends Oiseaux{


	public Faucon(String nom, int age, int nbSpect) {
		super(nom, age, nbSpect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " C'est un Faucon . ";
	}

	@Override
	public int getLongvite() {
		// TODO Auto-generated method stub
		return 13;
	}
	
	

}
