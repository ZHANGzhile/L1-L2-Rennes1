public class TP2{
	public static void main(String[] args) {
		//Précision et variables de type double
		java.util.Scanner sc= new java.util.Scanner(System.in);
		System.out.println("Enter double n : ");
		double x =sc.nextDouble();
	    int i = 1;
	    while( i<=11){
	    	System.out.println(x);
	    	x=x+0.1;
	    	i++;} 
	    


	    //Conversion
	    System.out.println("Enter le temperature : ");
        double f = sc.nextDouble();
		int a = 1;
		while (a<=28 & f<=250 & -20<=f) {
            double c=((5.0/9.0)*f - 160.0/9.0);		
            System.out.println("Degrés F "+f+" ---> "+c+" degrés C");
		    f=f+10;
		    a++;
		   
		}


		// Somme de 1 à n
		int sum = 0;
		int b = 0;
		System.out.println("Enter n :");
		int n = sc.nextInt();
		do {
		    b++;
		    System.out.print(b+" +");
		    sum += b ;
	        }while( b<n);
		    System.out.println(b+ " =  "+sum);
		sc.close();



		// affichage figures
		for(int e=1;e<=5;e++) {
		    int j = 1;
		    while (j<=6-i) {
				System.out.print("*");
				j++;
			}
		    System.out.println();
		}
    

	}
}