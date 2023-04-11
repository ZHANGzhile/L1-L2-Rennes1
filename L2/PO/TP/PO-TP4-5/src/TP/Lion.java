package TP;

public class Lion extends Felins{

	@Override
	public int getLongvite() {
		// TODO Auto-generated method stub
		return 12;
	}

	public Lion(String nom, int age) {
		super(nom, age);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + " C'est un Lion .";
	}


}
