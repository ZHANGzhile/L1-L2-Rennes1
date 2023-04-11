package TP;

public class testZoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animaux a1 = new Lion("saba",10);
		Animaux a2 = new Tigre("sdfsd",3);
		//System.out.println(a1.getClass());
		Animaux[] t = new Animaux[2];
		t[0] = a1;
		t[1] = a2;
		Zoo z = new Zoo("zoo1",t);
		Animaux a3 = new Panthere("Babi",15);
		z.ajouterAnimal(a3);;
		//z.affichage(z.tableInfo());
		//System.out.println(a2.toString());
		System.out.println(z.doyen().getNom());
		System.out.println(z.ageMoyen());
		//System.out.println(z.enfants());
		//afficheTab(z.enfants());
		System.out.println(a1.getLongvite());
		System.out.println(z.enfants()[1].getNom() + " " + z.enfants()[1].getAge());
		if(a1 instanceof Lion) System.out.println("true");
		
	}
	
	public static void afficheTab(Animaux[] t) {
		for(int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}

}
