public class TD8{
	public static void afficheTable(char[] t){
		for (int i = 0;i < t.length;i++) {
			System.out.print(t[i]+" ");
		}
	}

	public static void afficheChaine(String s){
		System.out.print(s);
	}

	public static int nombreDee(String s){
		int resultat = 0;
		char e ='e';
		int i = 0;
		while(i<s.length()){
			if(s.charAt(i) == e) resultat += 1;
			i++;
		}return resultat;
	}

	public static int occurrence(String s , char a, int n){
		int b = 0;
		for (int i =0;i<s.length() ;i++ ) {
			if (s.charAt(i) == a) b += 1;
			if (b == n) return i;
        }return -1;
	}

	/*public static int nombreMots(String s){
		char[] t ={' ',',','.','!','?',';',':'};
		int a = 0;
		for (int i =0;i<s.length() ;i=i+3 ) {
			for (int j = 0;j<t.length ;j++ ) {
				if(((s.charAt(i)>='a'&&s.charAt(i)<='z') || 
					(s.charAt(i)>='A'&&s.charAt(i)<='Z')) && s.charAt(i+2) ==t[j] ) a+=1 ;
			}
		}return a;
	}*/

	/*public static int nOccurance2Lettres(String s) {
        int res=0;
        int count=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=','||s.charAt(i)!=';'||s.charAt(i)!=' '||s.charAt(i)!='.'||s.charAt(i)!=':'||s.charAt(i)!='!'||s.charAt(i)!=':') {
                if(count==2) {
                    res+=1;
                }else if(count>2) {
                    count=0;
                }

            count++;
            }
        }
        return res;
    }*/

    public static int nbOccurrenceMots2Lettres(String s){
    	int nb = 0;
    	int count = 0;
    	for (int i =0;i<s.length() ;i++ ) {
    		if(s.charAt(i)==','||s.charAt(i)==';'||s.charAt(i)==' '||s.charAt(i)=='.'||s.charAt(i)==':'||s.charAt(i)=='!'||s.charAt(i)==':') {
    			if (count == 2) {
    				nb++;
    				count = 0;
    			}else count = 0;
    		}else count++;
    	}return nb;
    }

    public static boolean prefixe(String s,String s1){
    	for (int i = 0; i<s1.length() ;i++ ) {
    		if (s1.charAt(i)!=s.charAt(i)) {
    			return false;
    		}
    	}return true;
    }

    public static boolean estSousMotAIndiceK(String s,String s1,int k){
    	if (s.charAt(k)==s1.charAt(0)) {
    		for (int i =1;i<s1.length() ;i++ ) {
    			if(s1.charAt(i)!=s.charAt(i+k)) return false;    			
    		}return true;
    	}else return false;
    }

	public static void main(String[] args) {
		char[] t = {'a','b','c'};
		String s = "abcdefghgi";
		String b = "il est un garc on.";
		char a = 'g';
		String c ="bonjour bonsoir";
		String c1 = "bon";
		afficheTable(t);
		afficheChaine(s);
		System.out.println();
		System.out.println(nombreDee(s));
		System.out.println(occurrence(s,a,2));
		System.out.println(nbOccurrenceMots2Lettres(b));
        System.out.println(prefixe(c,c1));
        System.out.println(estSousMotAIndiceK(c,c1,5));
	}
}