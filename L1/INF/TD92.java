package TD9v1;

//
// TD9, semaine 45
//

// Question 1)
// Une structure qui représente une matière au lycée
class Matiere {
	// On peut s'en servir comme cela :
	// Matiere informatique = new Matiere();
	// informatique.nom = "Informatique";
	// informatique.notes = new double[] {10.0, 15.0, 14.5};
	// TODO définir ici les champs appropriés
	public String nom;
	public double[] notes;
	// avec un nom de matière, ex "Informatique"
	// et les notes d'un-e élève suivant cette matière,
	// par exemple double[] {10.0, 16.0, 19.0, 8.0}

}

// Question 4)
// Une structure qui représente un-e élève
class Eleve {
	// TODO définir ici les champs appropriés
	
	// avec un nom, ex "Dupont"
	public String nom;
    // avec un prénom, ex "Marie"
	public String prenom;
	// un tableau de matières (contenant le nom et ses notes), par exemple
	public Matiere[] matieres;
	// Matiere[] matieres = new Matiere[2];
	// matieres[0] = new Matiere();
	// matieres[0].nom = "Informatique";
	// matieres[0].notes = new double[] {10.0, 15.0, 14.5};
	// matieres[1] = new Matiere();
	// matieres[1].nom = "Anglais";
	// matieres[1].notes = new double[] {10.0, 14.5};

    // et enfin, un champ pour son âge en année
	public int age;
	public int annee;
}

// Question 6)
// Une structure qui représente les statistiques d'une matière
class MatiereStat {
	// TODO définir ici les champs appropriés

	// avec un nom de la matière, ex "Informatique"
	public String nom;
	// la moyenne la plus basse, ex 5.5
	public double mini;
	// la moyenne la plus haute, ex 18.3
	public double maxi;
	// la moyenne générale de la classe, ex 12.5
	public double moyenne;
}

// Question 9)
// Une structure qui représente une classe
class Classe {
	// TODO définir ici les champs appropriés

	// avec un nom de la classe, ex "Terminale A"
	public String nom;
	// un tableau d'étudiants
	public Eleve[] eleves;
	// et un tableau d'informatique statistiques pour chaque matière
	public MatiereStat[] stats;
}

// Question 14) challenge
// Une structure qui représente une date
class Date {
	// avec un jour (entier)
	public int jour; // entre 1 et 31
	// avec un mois (entier)
	public int mois; // entre 1 et 12
	// avec une année (entier)
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
	// Écrire une fonction qui affiche une structure Matiere.
	// Par exemple
	// afficheMatiere(informatique);
	//
	public static void afficheMatiere(Matiere m){
        // signature à changer
		System.out.println(m.nom+" ");
		for(int i=0;i<m.notes.length;i++) {
			System.out.print(" "+m.notes[i]);
		}
		System.out.println();
	}

	// Question 3)
	// Écrire une fonction qui calcule la moyenne des notes d'une matière.
	public static double moyenneNotes(Matiere m){
        // signature à changer
		double res=0;
		for(int i=0;i<m.notes.length;i++) {
			res+=m.notes[i];
		}
		return res/m.notes.length;
	}

	// Question 5)
	// Écrire une fonction qui prend en entrée un objet instance de la structure Eleve et qui l'affiche
	public static void afficheEleve(Eleve e){
        // signature à changer
		System.out.println(e.prenom+" "+e.nom+" (âge ="+e.age+")");  
		if(e.matieres!=null) {
			for(int i=0;i<e.matieres.length;i++) {
				afficheMatiere(e.matieres[i]);
			}
		}
	}

	// Question 7)
	// Écrire une fonction qui prend en entrée un objet instance de la structure MatiereStat et qui l'affiche
	public static void afficheMatiereStat(MatiereStat m){
		// signature à changer
		System.out.println("nom"+m.nom+"minimum: "+m.mini+" maximum: "+m.maxi+" moyenne: "+m.moyenne);
	}

	// Question 8)
	// Écrire une fonction qui prend en entrée une structure MatiereStat
	// et qui retourne une copie de cette structure.
	public static MatiereStat copieMatiereStat(MatiereStat m){
        // signature à changer
		MatiereStat res=new MatiereStat();
		res.maxi=m.maxi;
		res.mini=m.mini;
		res.moyenne=m.moyenne;
		res.nom=m.nom;
		return res;
		
		
	}

	// Question 9)
	// Écrire une fonction qui prend en entrée un nom et un prénom
	// (sous la forme de String) et qui crée et retourne un objet de
	// type Eleve avec ce nom et prénom.
	public static Eleve construireEleve(String nom,String prenom){
        // signature à changer
		Eleve res=new Eleve();
		res.nom=nom;
		res.prenom=prenom;
		return res;
	}


	// Question 11)
	// Une fonction qui affiche la moyenne de chaque élève d'une classe, pour chaque matière
	public static void afficheMoyennes(Classe c){
        // signature à changer
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
	// en fonction des notes des élèves présents dans c.eleves
	// c.stats[i].nom, c.stats[i].mini, c.stats[i].maxi, c.stats[i].moyenne
	public static void calculeStatistiques(){
        // signature à changer
		System.out.println("A faire !");
	}

	// Question 13)
	// Renvoie l'Eleve ayant la meilleure moyenne dans la matière nommée "nom"
	public static void meilleurMoyenne(){
		System.out.println("A faire !");
	}

	// Question 14)
	// calculer l'age (en année) d'un-e élève en fonction de sa Date() de naissance
	public static void calculeAge(){
        // signature à changer
		System.out.println("A faire !");
	}

	// Question 14)
	// créer un nouvel élève en calculant correctement son age en fonction de sa date de naissance
	public static void nouvelEleve(){
        // signature à changer
		System.out.println("A faire !");
	}

	//
	// Méthode main contenant des exemples
	//
	public static void main(String[] arg) {

		// Sur la structure Matiere

		
		// Question 1)
		System.out.println("\nQuestion 1)");
		// on crée un nouvel objet instance de la structure Matiere
		Matiere info_Marie_Dupont = new Matiere();
		// on remplit ces deux champs
		info_Marie_Dupont.nom = "Informatique"; // String
		info_Marie_Dupont.notes = new double[] {10.0, 15.0, 14.5}; // double[]
		System.out.println(info_Marie_Dupont);  // juste son adresse !
		

		
		// Question 2)
		System.out.println("\nQuestion 3)");
		// on affiche la matière de cette élève
		afficheMatiere(info_Marie_Dupont);
		// affiche
		// Informatique : 10.0, 15.0, 14.5
		

		
		// Question 3)
		System.out.println("\nQuestion 2)");
		// on affiche la moyenne des notes de cette élève dans la matière informatique
		double moyenne_info_Marie_Dupont = moyenneNotes(info_Marie_Dupont);
		System.out.println("Moyenne de cette élève en " + info_Marie_Dupont.nom + " = " + moyenne_info_Marie_Dupont);
		// affiche
		// Moyenne de cette élève en Informatique = 13.166666666666666
		

		
		// Question 4)
		System.out.println("\nQuestion 4)");
		Eleve marie_dupont = new Eleve();
		marie_dupont.nom = "Dupont";
		marie_dupont.prenom = "Marie";
		// pour l'exemple, juste une seule matière
		marie_dupont.matieres = new Matiere[] {info_Marie_Dupont};
		marie_dupont.age = 18;
		System.out.println(marie_dupont);  // juste son adresse !
		

		
		// Question 5)
		// on affiche cette élève
		System.out.println("\nQuestion 5)");
		afficheEleve(marie_dupont);
		// affiche
		// Marie Dupont (âge = 18)
		// Informatique : 10.0, 15.0, 14.5
		

		
		// Question 4)
		// un autre exemple
		Eleve jules_ferry = new Eleve();
		jules_ferry.nom = "Ferry";
		jules_ferry.prenom = "Jules";
		// pour l'exemple, juste deux matière
		Matiere[] matieres = new Matiere[1];
		matieres[0] = new Matiere();
		matieres[0].nom = "Informatique";
		matieres[0].notes = new double[] {10.0, 5.0, 14.5};
		jules_ferry.matieres = matieres;
		jules_ferry.age = 18;
		System.out.println(jules_ferry);  // juste son adresse !
		

		
		// Question 5)
		// on affiche cet élève
		afficheEleve(jules_ferry);
		// affiche
		// Jules Ferry (âge = 18)
		// Informatique : 10.0, 5.0, 14.5
		

		
		// Question 6)
		System.out.println("\nQuestion 6)");
		MatiereStat info_terminale_A = new MatiereStat();
		info_terminale_A.nom = "Informatique";
		// trois moyennes, la plus basse, la plus haut, et la moyenne générale de la classe
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
		System.out.println(info_terminale_B);  // juste l'adresse, mais différente car une copie

		

		
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

		// pour Marie Dupont, on récupère ses notes d'informatique
		Matiere[] matieres_MD = new Matiere[2];
		matieres_MD[0] = new Matiere();
		matieres_MD[0].nom = "Informatique";
		matieres_MD[0].notes = marie_dupont.matieres[0].notes;

		// et on rajoute des notes d'anglais
		matieres_MD[1] = new Matiere();
		matieres_MD[1].nom = "Anglais";
		matieres_MD[1].notes = new double[] {6, 11, 9.5, 12};
		marie_dupont.matieres = matieres_MD;

		// pour Jules Ferry, on récupère ses notes d'informatique
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
		// Pour chaque matière, afficher le ou la meilleur-e étudiant-e
		for (int i = 0; i < nomsMatieres.length; i++) {
			Eleve e = meilleurMoyenne(terminale_A, nomsMatieres[i]);
			System.out.println("Le ou la meilleur-e étudiant-e en " + nomsMatieres[i] + " est \"" + e.prenom + " " + e.nom + "\"");
		}
		*/
	}

}


