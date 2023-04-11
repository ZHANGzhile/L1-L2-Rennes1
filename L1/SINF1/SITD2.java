public class SITD2{
    public static void afficheTab(int[] t){
    	for (int i =0;i<t.length ;i++ ) {
    		System.out.print(t[i]+" ");
    	}System.out.println();
    }

	public static int[] bulle(int[] t){
        for (int i =0;i<t.length-1;i++ ) {
      	    for (int j = 0 ;j<t.length-i-1;j++ ) {
      	    	if (t[j]>t[j+1]) {
      	    		int temp = t[j+1];
      	    		t[j+1]=t[j];
      	    		t[j]=temp;
      	    	}
      	    }
        }
        return t;
	}

	public static int[] selection(int[] t){
		for (int i = 1;i<t.length ;i++ ) {
		 	int index = 0;
		 	for (int j =1;j<=t.length-i ;j++ ) {
		 		if (t[j]>t[index]) {
		 		    index=j;
		 		}
		 	}
		 	int temp = t[t.length-i];
		 	t[t.length-i] = t[index];
		 	t[index] = temp;
		}
		return t;
	}

    public static void mergeSort(int[] data, int left, int right) { 
      if (left >= right) 
  return; 
 //两路归并 
 // 找出中间索引 
 int center = (left + right) / 2; 
 // 对左边数组进行递归 
 mergeSort(data, left, center); 
 // 对右边数组进行递归 
 mergeSort(data, center + 1, right); 
 // 合并 
 merge(data, left, center, right); 
 System.out.print("排序中:\t"); 
 print(data); 
 } 

 public static void merge(int[] data, int leftStart, int leftEnd,  int rightEnd) { 
 int i = leftStart; 
 int j = leftEnd+1; 
 int k = 0; 
 // 临时数组 
 int[] temp = new int[rightEnd - leftStart + 1]; //创建一个临时的数组来存放临时排序的数组 
 // 确认分割后的两段数组是否都取到了最后一个元素 
 while (i <= leftEnd && j <= rightEnd) { 
  // 从两个数组中取出最小的放入临时数组 
  if (data[i] > data[j]) { 
  temp[k] = data[j]; 
  k++;
  j++;
  }else { 
  temp[k] = data[i];
  k++;
  i++;
  } 
 } 
 // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个） 
 while (i <= leftEnd) { 
  temp[k++] = data[i++]; 
 } 
 while (j <= rightEnd) { 
  temp[k++] = data[j++]; 
 } 
 k = leftStart; 
 // 将临时数组中的内容拷贝回原数组中 // （原left-right范围的内容被复制回原数组） 
 for (int element=0;element<temp.length;element++) { 
  data[k++] = temp[element]; 
 } 
 } 
  
 public static void print(int[] data) { 
 for (int i = 0; i < data.length; i++) { 
  System.out.print(data[i] + "\t"); 
 } 
 System.out.println(); 
 } 
	public static void main(String[] args) {
		int[] t ={-1,5,4,8,6};
		//afficheTab(bulle(t));
		//System.out.println("************************************");
		//afficheTab(selection(t));
		mergeSort(t, 0, t.length - 1); 
        System.out.print("\n排序后: \t"); 
        afficheTab(t);
	}

	/*
c)	f(N) = T*(N+1){ //la fonction recherche, un élément parcourt N fois, plus 1 pour la condition false termine la boucle , et il y a T éléments} + (T+1){ //la boucle dans la fonction corriger} + 1{//créer un tableau boolean}= T*N+2T+2.
La complexité en pire cas est O(f(N))=O(T*N+2T+2)=O(T*N)= O(N).
*/
	public static void triFusion(String[] t, int gauche, int droite){
	    if(gauche < droite){
	    	int milieu = (gauche+droite)/2;
	        triFusion(t, gauche,milieu); /*triFusion(t1) Recurse(récursif) sous-tableau a gauche */
	        triFusion(t, milieu+1,droite); /*triFusion(t1) Recurse(récursif) sous-tableau a droite*/
	        fusion(t,gauche,milieu,droite); /*fusion(t1_, t2_)*/
	    }
	}
	public static void fusion(String[] dico, int gauche, int milieu, int droite) { 
		 int i = gauche; 
		 int j = milieu+1; 
		 int k = 0; 
		 String[] temp = new String[droite - gauche + 1]; //Créer un tableau temporaire pour stocker le tableau temporairement trié 
		 while (i <= milieu && j <= droite) { //c.a.d devoir moins que la longueur des deux sous-tableaux
		     // Prenez le plus petit des deux sous-tableaux dans le tableau temporaire
		     if (dico[i].compareTo(dico[j])>=0) { //si l'element dans le sous-tableau a gauche est plus petit ou egale que l'element dans le droite sous-tableau
		         temp[k] = dico[j]; 
		         k++;
		         j++;
		     }else { 
		         temp[k] = dico[i];
		         k++;
		         i++;
		     } 
		 } 
		 //Les parties restantes sont placées dans le tableau temporaire par leur ordre(deja tri dans le sous-tableau)
		 //En fait, ces deux boucles while n'exécuteront qu'une seule d'entre elles 
		 //Parce que nous avons comparé tous les éléments de l'un des sous-tableaux avec certains éléments de l'autre sous-tableau et deja les remplis dans le tableau temporaire
		 while (i <= milieu) { //les restes(c.a.d plus grandes) elements sont dans le sous-tableau a gauche
		     temp[k++] = dico[i++]; 
		 } 
		 while (j <= droite) { //les restes(c.a.d plus grandes) elements sont dans le sous-tableau a droite
		     temp[k++] = dico[j++]; 
		 } 
		 // Copiez les elements du tableau temporaire dans le tableau d'origine
		 for(int x=0;x<temp.length;x++){
	         dico[gauche++] = temp[x];
		 } 
	} 
}