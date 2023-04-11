package TP;

public abstract class Oiseaux extends Animaux{
	private int nbSpec;
	

	public Oiseaux(String nom, int age, int nbSpect) {
		super(nom, age);
		this.nbSpec = nbSpect;
		// TODO Auto-generated constructor stub
	}
	
	

	public int getNbSpec() {
		return nbSpec;
	}



	public void setNbSpec(int nbSpec) {
		this.nbSpec = nbSpec;
	}



	@Override
	public String toString() {
		return super.toString() + " C'est un Oiseau. ";
	}

	@Override
	public abstract int getLongvite();
	
	public void creerSpectacle() {
		System.out.println(getNom() + " participa a un spectacle.");
		nbSpec++;
	}



}
