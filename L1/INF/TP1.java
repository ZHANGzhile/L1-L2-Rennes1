 public class TP1{
 	public static void main(String[] args) {

        System.out.println("Hello World!");
        java.util.Scanner sc= new java.util.Scanner(System.in);

System.out.println("2**************************************");

	System.out.println("the number a");
		int a =sc.nextInt();
		System.out.println("the number b");
		int b = sc.nextInt();
		
		int c;
		c=a;
		a=b;
		b=c;
		System.out.println("new a ="+a);
		System.out.println("new b ="+b);
		
		a=2*a;
		System.out.println("le double de a ="+a);
		b=b/2;
		System.out.println("la moitié de b ="+b);
        
		 int d = a/b;
		 int e = a%b;
		 System.out.println("le quotient de a par b ="+d);
		 System.out.println("le reste de la division de a par b ="+e);
		 
		 if (a>b) {
		     System.out.println("a est plus grande");}
		 else {
			 System.out.println("b est plus grande");}

 System.out.println("3**************************************");

    System.out.println("L'année a =");
		int f = sc.nextInt();
		
        if((f%4 ==0 & f%100 !=0)||f%400 == 0) {
        System.out.println("L'année "+f+" est bissextile");}
        else 
        { System.out.println("L'année "+f+" n'est pas bissextile");}

    System.out.println("4**************************************");
    
    System.out.println("k =");
    int k = sc.nextInt();
		int l = k/60;
		int j = k%60;
		int m = l/60;
		int i = l%60;
		int s = m/24;
		int g =m%24;
		System.out.println("cela donne "+s+" jours "+g+" heures "+i+" minutes "+j+" seconds."); 
		
 System.out.println("5**************************************");

    System.out.println("the number a,b,c est");
		int o = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int r = o+p+q;
		 
		if (r%2 == 0) {
			System.out.println("La somme des trois entiers est paire");}
		else {
			System.out.println("La somme des trois entiers est impaire.");}

    }


}