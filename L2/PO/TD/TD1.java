public class TD1{
	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		int c = a;
		a = b;
		b = c;
		System.out.println("a等于" + a + " b等于"+ b);
		dateMoisJours(8,5);
	}

	public static void dateMoisJours(int m, int j){
		if (m <= 12 && m >= 9) {
			if (m == 9) {
				if (j >= 22) {
					System.out.print("Oui");
			} 	
				else {System.out.print("Non");}
			}
			if (m == 12) {
				if (j <= 20) {
					System.out.print("Oui");
				}
				else {System.out.print("Non");}
			}
			if (m == 10 || m == 11 ) {
				System.out.print("Oui");
			}
		}
		else {System.out.print("Non");}		
	}
}