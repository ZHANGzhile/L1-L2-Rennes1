public class TP8{
	public static int occurence(String s ,char c){
		int nom = 0;
		for (int i = 0;i<s.length() ;i++ ) {
			if (s.charAt(i) == c) {
				nom++;
			}
		}return nom;
	}

	public static boolean estPaindrome(String s){
        for (int i =0;i<=s.length()/2 ;i++ ) {
        	if (s.charAt(i) != s.charAt(s.length()-1-i)) {
        		return false;
        	}
        }return true;
	}

	public static String extraireSousChaine(String s,int d,int f){
		String a = "";
		for (int i=d;i<=f ;i++ ) {
			a = a + s.charAt(i);
		}
		return a;
	}

	public static String remplacer(String s,char a, char b){
        String s1 = "";
		for (int i =0;i<s.length() ;i++ ) {
			if (s.charAt(i)==a) {
				s1=s1+b;
			}
			else s1=s1+s.charAt(i);
		}
		return s1;
	}

	public static void enumererSousChaines(String s){
		for (int i =0;i<s.length() ;i++ ) {
			
		}
	}

	public static boolean estMajuscule(char c){
	    if (c>'Z' || c<'A') return false;
		else return true;
	}

	public static boolean estMinuscule(char c){
		if (c<'a' || c>'z') return false;
		else return true;
	}

	public static boolean estLettre(char c){
		if (((int) c > 122) || ((int) c < 65) ||
                (((int) c > 90) && ((int) c < 97))) {
				return false;
			}
		else return true;
	}

	public static char minusculeChar(char c){
        if (estMajuscule(c)) {
        	return ((char)((int)c - (int)'Z' + (int)'z'));
        }
        else return c;
	}

	public static char majusculeChar(char c){
		if(estMinuscule(c)){
			return ((char) ((int)c + (int)'Z' - (int)'z'));
		}
		else return c;
	}

	public static String minusculeChaine(String s){
		String s1 ="";
		for (int i=0;i<s.length() ;i++ ) {
			s1=s1+minusculeChar(s.charAt(i));
		}
		return s1;
	}

	public static String majusculeDebut(String s){
		String s1="";
		s1=s1+majusculeChar(s.charAt(0));
		for (int i=1;i<s.length();i++ ) {
			if(!estLettre(s.charAt(i))){
				s1=s1+s.charAt(i)+majusculeChar(s.charAt(i+1));
				i++;
			}
			else s1=s1+minusculeChar(s.charAt(i));
		}
		return s1;
	}

	public static int comptageMot(String s){
        int count = 0;
        int nb = 0;
        for (int i = 0;i<s.length() ;i++ ) {
        	if (!estLettre(s.charAt(i))) {
        		if (count == 2) {
        			nb++;
        			count = 0;
        		}else count = 0;
        	}else count++;
        }return nb;
	}

    public static int conversionEntier(String s){
    	int entier = 0;
    	for (int i=0;i<s.length() ;i++ ) {
    		entier= entier*10+((int)(s.charAt(i))-(int)('0'));
    	}return entier;
    }

	public static void main(String[] args) {
		String s ="Bonjour";
		String s1 = "gramme";
		String s2 ="l’eXamen ne sera pas TROP dur";
		String s3 ="Le si et le la en cle de fa";
		String s4 = "123";
		String s5 = "l’eXamen ne sera pas TROP dur";
		//System.out.println(extraireSousChaine(s,2,5));
		//System.out.println(remplacer(s1,'m','p'));
		//System.out.println(estMajuscule('A'));
		//System.out.println(minusculeChaine(s2));
		//System.out.println(comptageMot(s3));
		//System.out.println(conversionEntier(s4));
		//System.out.println(majusculeChar('a'));
		System.out.println(minusculeChar('A'));
		System.out.println(majusculeDebut(s5));
	}
}