package TP;

public class Zoo {
	private String nom;
	private Animaux[] animal;

	public Animaux[] getAnimal() {
		return animal;
	}

	public void setAnimal(Animaux[] animal) {
		this.animal = animal;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Zoo(String nom, Animaux[] animal) {
		super();
		this.nom = nom;
		this.animal = animal;
	}

	public void ajouterAnimal(Animaux a) {
		Animaux[] newAni = new Animaux[animal.length + 1];
		for (int i = 0; i < newAni.length - 1; i++) {
			newAni[i] = animal[i];
		}
		newAni[newAni.length - 1] = a;
		this.animal = newAni;
	}

	public void SupprimerAnimal(Animaux a) {
		for (int i = 0; i < animal.length; i++) {
			if (animal[i] == a) {
				animal[i] = null;
			}
		}
	}

	public Object[][] tableInfo() {
		Object[][] t = new Object[3][];
		String[] t0 = new String[animal.length];
		Class[] t1 = new Class[animal.length];
		Object[] t2 = new Object[animal.length];
		for (int i = 0; i < t0.length; i++) {
			t0[i] = animal[i].getNom();
			t1[i] = animal[i].getClass();
			t2[i] = animal[i].getAge();
		}
		t[0] = t0;
		t[1] = t1;
		t[2] = t2;

		return t;
	}

	public void affichage(Object[][] t) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}

	public Animaux doyen() {
		Animaux a = animal[0];
		for (int i = 0; i < animal.length; i++) {
			if (a.getAge() <= animal[i].getAge()) {
				a = animal[i];
			}
		}
		return a;
	}

	public double ageMoyen() {
		double somme = 0;
		if(animal.length != 0) {
			for (int i = 0; i < animal.length; i++) {
				somme += animal[i].getAge();
			}
			return somme / animal.length;
		}else {
			return 0;
		}		
	}
	/*
	public Animaux[] enfants() {
		Animaux[] t = new Animaux[animal.length];
		for (int i = 0; i < animal.length; i++) {
			if (animal[i].getAge() <= 2) {
				t[i] = animal[i];
			}
		}
		return t;

	}*/
	
	public Animaux[] enfants() {
		Animaux[] t = new Animaux[animal.length];
		for(int i = 0; i < animal.length; i++) {
			if(animal[i].getAge() <= animal[i].getLongvite()*0.25) {
				t[i] = animal[i];
			}
		}
		return t;
	}
	
	public Animaux trouverOiseauLeMoinsFatigue() {
		for(int i = 0; i < animal.length; i++) {
			if(animal[i] instanceof Oiseaux) {
				return animal[i];
			}
		}
		return null; 
	}
	

}
