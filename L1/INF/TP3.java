public class TP3{
	public static void main(String[] args) {
		/*for (int i = 90 ; i >= 65 ; i--){
			char a = (char)i;
			System.out.println(a+" "+i);
		}
	    
	    for (int i = 65 ; i <= 90 ; i++){
			char a = (char)i;
			System.out.println(a+" "+i);
		}*/
	    alphbeEnMinuscule(97);
	    double jieguo = impotMontant(32000);
		String baifenbi = pourcentageImposition(32000);
		double fuqi = gainMariage(10000,15000);
		System.out.println("impot est : "+jieguo);
		System.out.println("pourcentageImposition est : "+ baifenbi);
		System.out.println("gainMariage est : "+ fuqi);

       
        

        java.util.Scanner sc= new java.util.Scanner(System.in);
        System.out.print("输入h");
	    int h = sc.nextInt();
	    figure(h);


	 }   
	
	public static double impotMontant(double z){
	    double a = 0 ;
	    if (z <= 10064) {
	    	a = 0 ;
	    }else if (z <= 25659) {
	    	a = (z-10065)*0.11;
	    }else if (z <= 73369) {
	    	a = (25659 - 10065)*0.11+(z-25660)*0.3;    	
	    }else if (z <= 157805) {
	    	a = (25659 - 10065)*0.11+(73369-25660)*0.3+(z-73370)*0.41;  	
	    }else if (z >=157806 ) {
	    	a = (25659 - 10065)*0.11+(73369-25660)*0.3+(157805-73370)*0.41+(z - 157806)*0.45;	
	    }
	    return a;	    
	    }
    public static String pourcentageImposition(double z){
	    double x = impotMontant(z);
	    String y = (x/z)*100+"%";
	    return y;
    }
    
    public static double gainMariage(double salaire1,double salaire2){
    	double gain = 0 ;
    	double s = (salaire1+salaire2)/2;
    	/*if (z <= 10064) {
	    	gain = 0 ;
	    }else if (z <= 25659) {
	    	gain = 2*((z-10065)*0.11);
	    }else if (z <= 73369) {
	    	gain = 2*((25659 - 10065)*0.11+(z-25660)*0.3);    	
	    }else if (z <= 157805) {
	    	gain = 2*((25659 - 10065)*0.11+(73369-25660)*0.3+(z-73370)*0.41);  	
	    }else if (z >=157806 ) {
	    	gain = 2*((25659 - 10065)*0.11+(73369-25660)*0.3+(157805-73370)*0.41+(z - 157806)*0.45);	
	    }*/
	    double y = impotMontant(s);
	    gain = 2*y;
	    return gain;	
    }
    public static void alphbeEnMinuscule(int i){
    	for(;i <= 122;i++){
    		char a = (char)i;
    		System.out.println(a+" "+i);
    	}
    }


    public static void figure(int j){
    	double n = j ;
    	for (int a= 0;a<j ;a++ ) {
    		for (int b = 1;b<=j-a ;b++ ) {
           		System.out.print(" ");
    	    }
    	    for (int c = 1;c<=n ;c++ ) {
    	    	System.out.print("*");
    	    }
            System.out.println();
            n=n+2;
        }
        for (int d = 1;d<=j ;d++ ) {
        	for (int e = 1;e<=3*j ;e++ ) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        n = j ;
        for (int a = j;a>0 ;a-- ) {
        	for (int b = 0;b<=j-a ;b++ ) {
        		System.out.print(" ");
        	}
        	for (int c = 1;c<=3*n-2 ;c++ ) {
        		System.out.print("*");
        	}
        	System.out.println();
            n=(3*n-2)/3;
        }

    }
	
	
}