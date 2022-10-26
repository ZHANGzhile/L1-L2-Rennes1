public class TD7{
    public static double minLigne(double[][]t , int i){
	    double min = t[i][0];
	    for (int j = 1;j < t[i].length ;j++ ) {
		    if (min > t[i][j]) {
			    min = t[i][j];
		    }
	    }return min;
    }

    public static double maxColonne(double[][]t,int j){
    	double max = t[0][j];
    	for (int i = 1;i < t.length ;i++ ) {
    		if (max < t[i][j]) {
    			max = t[i][j];
    		}
    	}return max;
    }

    public static boolean pointCol(double[][]t,int i,int j){
    	double min = minLigne(t,i);
    	double max = maxColonne(t,j);
    	if (t[i][j] == min && t[i][j] == max) {
    		return true;
    	}else return false;
    }

    public static void affichePointCol(double[][]t){
    	for (int i = 0;i < t.length ;i++ ) {
    		for (int j = 0 ;j < t[i].length ;j++ ) {
    			if(pointCol(t,i,j)) 
    				System.out.print(t[i][j]);
    		}
    			
        }
    }
    public static void main(String[] args) {
    	double[][] t = {{4,0,1},{5,6,3},{1,4,0}};
    	affichePointCol(t);
    }

}