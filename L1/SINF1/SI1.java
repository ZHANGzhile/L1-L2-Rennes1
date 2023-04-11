public class SI1{
	public static int rechercheDicho(int cherche, int[] t) {
		int debut=0;
		int fin=t.length-1;
		int milieu= (debut+fin)/2;
		while(fin - debut >= 0 ) {
			milieu = (debut + fin)/2;
			if(t[debut] == cherche) return debut;
			if(t[fin] == cherche) return fin;
			if(t[milieu] == cherche) return milieu;
			else if(t[milieu] > cherche) fin = milieu-1;
			else  debut = milieu+1;
		}return -1;
	}

    public static void main(String[] args) {
		int[] t = {};
		int[] t1 ={1};
		int[] t2 ={1,3};
		int[] t3 ={2,4,8,10};
		int[] t4 = {1,2,3,5,9,10,20,25};

		System.out.print(rechercheDicho(20,t4));
	}
}
