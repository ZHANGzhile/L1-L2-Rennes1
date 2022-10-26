public class TD10{
	public static void renverseSommet(int[] t,int k){
        int temp =0;
        for (int j=0;j<=k/2;j++ ) {
        	temp = t[j];
        	t[j]=t[k-j];
        	t[k-j] = temp;
        }
	}

	public static void triPile(int[] t){
		for (int j =t.length-1;j>0 ;j--) {
			int max=0;
		    for (int i=0;i<=j;i++ ) {
			    if (t[i]>t[max]) {
				    max=i;
			    }
		    }
		    renverseSommet(t,max); 
		    renverseSommet(t,j);  
        }
        for (int i=0;i<t.length ;i++ ) {
        	System.out.print(t[i]+" ");
        }System.out.println();
	}

	public static int[] buildtind(double[] t){
        int a=0;
		for (int i=0;i<t.length;i++ ) {
			if(t[i] != 0.0) a++;
		}
		int[] tind =new int[a];
		int b =0;
		for (int j=0;j<t.length && b<tind.length;j++ ) {
			if (t[j] != 0.0) {
				tind[b]=j;
				b++;
			}
		}
		return tind;
	}

	public static double[] buildtval (double[]t){
        int[] tind = buildtind(t);
        double[] tval = new double[tind.length];
        int b=0;
        for (int i=0;i<t.length && b<tval.length;i++ ) {
        	if (t[i] != 0.0) {
        		tval[b] = t[i];
        		b++;
        	}
        }
        return tval;
	}

	public static double valeur(int[]tind,double[]tval,int i){
        int indice =0;
        boolean trouve =false;
        for (int j=0;j<tind.length ;j++ ) {
        	if (tind[j] == i) {
        		indice = j;
        		trouve =true;
        	}
        }
        if (trouve) return tval[indice];
        else return 0;
	}
	public static void main(String[] args) {
		int[] t={3,1,4,5,6,2};
		triPile(t);
		double[] t1= {0, 0, 1.1, 0, 2.0, 0, 0, 4.5, 0};
		System.out.println(buildtind(t1));
		System.out.println(buildtval(t1));
		System.out.println(valeur(buildtind(t1),buildtval(t1),3));
	}
}