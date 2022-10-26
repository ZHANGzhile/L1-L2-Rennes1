package TD9v1;

//
// TD9, semaine 45
//

// Question 1)
// Une structure qui repr�sente une mati�re au lyc�e
class Matiere {
	// On peut s'en servir comme cela :
	// Matiere informatique = new Matiere();
	// informatique.nom = "Informatique";
	// informatique.notes = new double[] {10.0, 15.0, 14.5};
	// TODO d�finir ici les champs appropri�s
	public String nom;
	public double[] notes;
	// avec un nom de mati�re, ex "Informatique"
	// et les notes d'un-e �l�ve suivant cette mati�re,
	// par exemple double[] {10.0, 16.0, 19.0, 8.0}

}

// Question 4)
// Une structure qui repr�sente un-e �l�ve
class Eleve {
	// TODO d�finir ici les champs appropri�s
	
	// avec un nom, ex "Dupont"
	public String nom;
    // avec un pr�nom, ex "Marie"
	public String prenom;
	// un tableau de mati�res (contenant le nom et ses notes), par exemple
	public Matiere[] matieres;
	// Matiere[] matieres = new Matiere[2];
	// matieres[0] = new Matiere();
	// matieres[0].nom = "Informatique";
	// matieres[0].notes = new double[] {10.0, 15.0, 14.5};
	// matieres[1] = new Matiere();
	// matieres[1].nom = "Anglais";
	// matieres[1].notes = new double[] {10.0, 14.5};

    // et enfin, un champ pour son �ge en ann�e
	public int age;
	public int annee;
}

// Question 6)
// Une structure qui repr�sente les statistiques d'une mati�re
class MatiereStat {
	// TODO d�finir ici les champs appropri�s

	// avec un nom de la mati�re, ex "Informatique"
	public String nom;
	// la moyenne la plus basse, ex 5.5
	public double mini;
	// la moyenne la plus haute, ex 18.3
	public double maxi;
	// la moyenne g�n�rale de la classe, ex 12.5
	public double moyenne;
}

// Question 9)
// Une structure qui repr�sente une classe
class Classe {
	// TODO d�finir ici les champs appropri�s

	// avec un nom de la classe, ex "Terminale A"
	public String nom;
	// un tableau d'�tudiants
	public Eleve[] eleves;
	// et un tableau d'informatique statistiques pour chaque mati�re
	public MatiereStat[] stats;
}

// Question 14) challenge
// Une structure qui repr�sente une date
class Date {
	// avec un jour (entier)
	public int jour; // entre 1 et 31
	// avec un mois (entier)
	public int mois; // entre 1 et 12
	// avec une ann�e (entier)
	public int annee;

	// calcule la date d'aujourd'hui, fourni par l'enseignant
	public Date() {
		java.time.LocalDate today = java.time.LocalDate.now();
		this.jour  = today.getDayOfMonth();
		this.mois  = today.getMonthValue();
		this.annee = today.getYear();
	}
}


//
// Classe principale du fichier TD9.java
//
public class TD9 {

	// Question 2)
	// �crire une fonction qui affiche une structure Matiere.
	// Par exemple
	// afficheMatiere(informatique);
	//
	public static void afficheMatiere(Matiere m){
        // signature � changer
		System.out.println(m.nom+" ");
		for(int i=0;i<m.notes.length;i++) {
			System.out.print(" "+m.notes[i]);
		}
		System.out.println();
	}

	// Question 3)
	// �crire une fonction qui calcule la moyenne des notes d'une mati�re.
	public static double moyenneNotes(Matiere m){
        // signature � changer
		double res=0;
		for(int i=0;i<m.notes.length;i++) {
			res+=m.notes[i];
		}
		return res/m.notes.length;
	}

	// Question 5)
	// �crire une fonction qui prend en entr�e un objet instance de la structure Eleve et qui l'affiche
	public static void afficheEleve(Eleve e){
        // signature � changer
		System.out.println(e.prenom+" "+e.nom+" (�ge ="+e.age+")");  
		if(e.matieres!=null) {
			for(int i=0;i<e.matieres.length;i++) {
				afficheMatiere(e.matieres[i]);
			}
		}
	}

	// Question 7)
	// �crire une fonction qui prend en entr�e un objet instance de la structure MatiereStat et qui l'affiche
	public static void afficheMatiereStat(MatiereStat m){
		// signature � changer
		System.out.println("nom"+m.nom+"minimum: "+m.mini+" maximum: "+m.maxi+" moyenne: "+m.moyenne);
	}

	// Question 8)
	// �crire une fonction qui prend en entr�e une structure MatiereStat
	// et qui retourne une copie de cette structure.
	public static MatiereStat copieMatiereStat(MatiereStat m){
        // signature � changer
		MatiereStat res=new MatiereStat();
		res.maxi=m.maxi;
		res.mini=m.mini;
		res.moyenne=m.moyenne;
		res.nom=m.nom;
		return res;
		
		
	}

	// Question 9)
	// �crire une fonction qui prend en entr�e un nom et un pr�nom
	// (sous la forme de String) et qui cr�e et retourne un objet de
	// type Eleve avec ce nom et pr�nom.
	public static Eleve construireEleve(String nom,String prenom){
        // signature � changer
		Eleve res=new Eleve();
		res.nom=nom;
		res.prenom=prenom;
		return res;
	}


	// Question 11)
	// Une fonction qui affiche la moyenne de chaque �l�ve d'une classe, pour chaque mati�re
	public static void afficheMoyennes(Classe c){
        // signature � changer
		for(int i=0;i<c.eleves.length;i++) {
			System.out.println("Eleve: "+c.eleves[i].nom+" "+c.eleves[i].prenom);
			for(int j=0;j<c.eleves[i].matieres.length;j++) {
				System.out.println(c.eleves[i].matieres[j].nom);
				System.out.println(moyenneNotes(c.eleves[i].matieres[j]));
			}
			
		}
	}

	// Question 12)
	// Une fonction qui calcule les champs c.stats[i] pour une classe,
	// en fonction des notes des �l�ves pr�sents dans c.eleves
	// c.stats[i].nom, c.stats[i].mini, c.stats[i].maxi, c.stats[i].moyenne
	public static void calculeStatistiques(){
        // signature � changer
		System.out.println("A faire !");
	}

	// Question 13)
	// Renvoie l'Eleve ayant la meilleure moyenne dans la mati�re nomm�e "nom"
	public static void meilleurMoyenne(){
		System.out.println("A faire !");
	}

	// Question 14)
	// calculer l'age (en ann�e) d'un-e �l�ve en fonction de sa Date() de naissance
	public static void calculeAge(){
        // signature � changer
		System.out.println("A faire !");
	}

	// Question 14)
	// cr�er un nouvel �l�ve en calculant correctement son age en fonction de sa date de naissance
	public static void nouvelEleve(){
        // signature � changer
		System.out.println("A faire !");
	}

	//
	// M�thode main contenant des exemples
	//
	public static void main(String[] arg) {

		// Sur la structure Matiere

		
		// Question 1)
		System.out.println("\nQuestion 1)");
		// on cr�e un nouvel objet instance de la structure Matiere
		Matiere info_Marie_Dupont = new Matiere();
		// on remplit ces deux champs
		info_Marie_Dupont.nom = "Informatique"; // String
		info_Marie_Dupont.notes = new double[] {10.0, 15.0, 14.5}; // double[]
		System.out.println(info_Marie_Dupont);  // juste son adresse !
		

		
		// Question 2)
		System.out.println("\nQuestion 3)");
		// on affiche la mati�re de cette �l�ve
		afficheMatiere(info_Marie_Dupont);
		// affiche
		// Informatique : 10.0, 15.0, 14.5
		

		
		// Question 3)
		System.out.println("\nQuestion 2)");
		// on affiche la moyenne des notes de cette �l�ve dans la mati�re informatique
		double moyenne_info_Marie_Dupont = moyenneNotes(info_Marie_Dupont);
		System.out.println("Moyenne de cette �l�ve en " + info_Marie_Dupont.nom + " = " + moyenne_info_Marie_Dupont);
		// affiche
		// Moyenne de cette �l�ve en Informatique = 13.166666666666666
		

		
		// Question 4)
		System.out.println("\nQuestion 4)");
		Eleve marie_dupont = new Eleve();
		marie_dupont.nom = "Dupont";
		marie_dupont.prenom = "Marie";
		// pour l'exemple, juste une seule mati�re
		marie_dupont.matieres = new Matiere[] {info_Marie_Dupont};
		marie_dupont.age = 18;
		System.out.println(marie_dupont);  // juste son adresse !
		

		
		// Question 5)
		// on affiche cette �l�ve
		System.out.println("\nQuestion 5)");
		afficheEleve(marie_dupont);
		// affiche
		// Marie Dupont (�ge = 18)
		// Informatique : 10.0, 15.0, 14.5
		

		
		// Question 4)
		// un autre exemple
		Eleve jules_ferry = new Eleve();
		jules_ferry.nom = "Ferry";
		jules_ferry.prenom = "Jules";
		// pour l'exemple, juste deux mati�re
		Matiere[] matieres = new Matiere[1];
		matieres[0] = new Matiere();
		matieres[0].nom = "Informatique";
		matieres[0].notes = new double[] {10.0, 5.0, 14.5};
		jules_ferry.matieres = matieres;
		jules_ferry.age = 18;
		System.out.println(jules_ferry);  // juste son adresse !
		

		
		// Question 5)
		// on affiche cet �l�ve
		afficheEleve(jules_ferry);
		// affiche
		// Jules Ferry (�ge = 18)
		// Informatique : 10.0, 5.0, 14.5
		

		
		// Question 6)
		System.out.println("\nQuestion 6)");
		MatiereStat info_terminale_A = new MatiereStat();
		info_terminale_A.nom = "Informatique";
		// trois moyennes, la plus basse, la plus haut, et la moyenne g�n�rale de la classe
		info_terminale_A.mini = 5.5;
		info_terminale_A.maxi = 18.3;
		info_terminale_A.moyenne = 12.5;
		System.out.println(info_terminale_A);  // juste son adresse !
		

		
		// Question 7)
		System.out.println("\nQuestion 7)");
		afficheMatiereStat(info_terminale_A);
		

		
		// Question 8)
		System.out.println("\nQuestion 8)");
		MatiereStat info_terminale_B = copieMatiereStat(info_terminale_A);
		System.out.println(info_terminale_B);  // juste l'adresse, mais diff�rente car une copie

		

		
		// Question 9)
		System.out.println("\nQuestion 9)");
		Classe terminale_A = new Classe();
		terminale_A.nom = "Terminale A";
		terminale_A.eleves = new Eleve[] { marie_dupont, jules_ferry };
		terminale_A.stats = new MatiereStat[] { info_terminale_A };
		System.out.println(terminale_A); // ceci affichera juste l'adresse !
		

		
		// Question 10)
		System.out.println("\nQuestion 10)");
		Eleve mohamed_ali = construireEleve("Ali", "Mohamed");
		System.out.println(mohamed_ali); // ceci affichera juste l'adresse !
		afficheEleve(mohamed_ali);
		

		
		// Question 11)
		System.out.println("\nQuestion 11)");
		afficheMoyennes(terminale_A);

		// pour Marie Dupont, on r�cup�re ses notes d'informatique
		Matiere[] matieres_MD = new Matiere[2];
		matieres_MD[0] = new Matiere();
		matieres_MD[0].nom = "Informatique";
		matieres_MD[0].notes = marie_dupont.matieres[0].notes;

		// et on rajoute des notes d'anglais
		matieres_MD[1] = new Matiere();
		matieres_MD[1].nom = "Anglais";
		matieres_MD[1].notes = new double[] {6, 11, 9.5, 12};
		marie_dupont.matieres = matieres_MD;

		// pour Jules Ferry, on r�cup�re ses notes d'informatique
		Matiere[] matieres_JF = new Matiere[2];
		matieres_JF[0] = new Matiere();
		matieres_JF[0].nom = "Informatique";
		matieres_JF[0].notes = jules_ferry.matieres[0].notes;

		// et on rajoute des notes d'anglais
		matieres_JF[1] = new Matiere();
		matieres_JF[1].nom = "Anglais";
		matieres_JF[1].notes = new double[] {20, 17, 14, 13.5};
		jules_ferry.matieres = matieres_JF;

		//calculeStatistiques(terminale_A);
		afficheMoyennes(terminale_A);
		

		/*
		// Question 13)
        System.out.println("\nQuestion 13)");
        String[] nomsMatieres = new String[] { "Informatique","Anglais" };
		// Pour chaque mati�re, afficher le ou la meilleur-e �tudiant-e
		for (int i = 0; i < nomsMatieres.length; i++) {
			Eleve e = meilleurMoyenne(terminale_A, nomsMatieres[i]);
			System.out.println("Le ou la meilleur-e �tudiant-e en " + nomsMatieres[i] + " est \"" + e.prenom + " " + e.nom + "\"");
		}
		*/
	}

}


