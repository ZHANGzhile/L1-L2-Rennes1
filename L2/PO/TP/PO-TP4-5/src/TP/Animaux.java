package TP;

abstract class Animaux {

	private String nom;
	private int age;
	
	
	public Animaux(String nom, int age) {
		this.nom = nom;
		if(age < 0) { this.age = 0;}
		else{ this.age = age;}
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return nom + " a " + age + " ans. ";
	}
	
	public abstract int getLongvite();
	
}
