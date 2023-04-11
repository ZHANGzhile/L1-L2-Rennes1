package tp9;

import java.util.concurrent.ThreadLocalRandom;
import outils.*;

public class TP9 {

	// Méthode fourni par le squelette
	public static int entierAleatoire(int a, int b){
		//Retourne un entier aléatoire entre a (inclus) et b (inclus)
		return ThreadLocalRandom.current().nextInt(a, b + 1);
	}
	
	//Exercice 1
	public static void verifierPixel(Pixel p) {
		
		if(p.r<0) p.r=0;
		else if(p.r>255) p.r=255;

		if(p.v<0) p.v=0;
		else if(p.v>255) p.v=255;

		if(p.b<0) p.b=0;
		else if(p.b>255) p.b=255;
		
		
		
	}
	
	//Exercice 2.a
	public static BitMap simpleRectangle(int n, int m) {
		 BitMap img = new BitMap(n,m);
		 

		 Pixel p_blanche=new Pixel(255,255,255);
		 
		 Pixel p_noir=new Pixel(0,0,0); 
		 
		 for(int i=0;i<n;i++) {   //rendre touts les pixels blanche
			 
			 for(int j=0;j<m;j++) {
				 
				 img.set(i, j, p_blanche);
				 
			 }
			 
		 }
		
		 for(int h=10;h<m-10;h++) { //hauteur
			 
			 
			 for(int l=10;l<20;l++) { //du pixel 10 au pixel 20
			 
				 img.set(h,l, p_noir);
			 
			 }
			 
			 for(int l=n-20;l<n-10;l++) { //du pixel n(longeur-20) au pixel n(longuer-10)
			
				 img.set(h,l, p_noir);
			 
			 }
			 
		 }
			
		 for(int l=10;l<n-10;l++) { //longeur
			 
			 
			 for(int h=10;h<20;h++) {  //du pixel 10 au pixel 20
			 
				 img.set(h, l, p_noir); 
			  
			 }
			 
			 for(int h=m-20;h<m-10;h++) { //du pixel hauteur-20 al pixel hauteur-10
			
				 img.set(h,l, p_noir); 
			 
			 }
			 
		 }
		 

	
	    
		 
		 return img;
	}
	
	//Exercice 2.b
	public static BitMap simpleCroix(int n, int m) {
	
		BitMap img = new BitMap(n,m);
		 
		int moitie_longeur=n/2;
		
		int moitie_hauteur=m/2;

		 Pixel p_blanche=new Pixel(255,255,255);
		 
		 Pixel p_noir=new Pixel(0,0,0); 
		 
		 for(int i=0;i<n;i++) {   //rendre touts les pixels blanche
			 
			 for(int j=0;j<m;j++) {
				 
				 img.set(i, j, p_blanche);
				 
			 }
			 
		 }
		 
		 for(int l=10;l<n-10;l++) { //longeur
			
			 for(int m_h=moitie_hauteur-5;m_h<moitie_hauteur+5;m_h++) { //pour avoir 10 pixel noir
				 

				 img.set(l,m_h, p_noir); 
				 
			 }
			 
		 }
		 
		 
		 for(int h=10;h<m-10;h++) { //hauteur
				
			 for(int m_l=moitie_longeur-5;m_l<moitie_longeur+5;m_l++) { //pour avoir 10 pixel noir
				 

				 img.set(m_l,h, p_noir); 
				 
			 }
			 
		 }
		 
		 
		return img;
	}
	
	//Exercice 3.a
	public static BitMap composanteRouge(BitMap img) {
		
		BitMap res=new BitMap(img.largeur(),img.hauteur());
		
		 for(int i=0;i<img.largeur();i++) {   //rendre touts les pixels blanche
			 
			 for(int j=0;j<img.hauteur();j++) {
				 
				 Pixel p = img.get(i,j); 
				 
				 p.r=255;
				 
				 res.set(i,j, p);
				 
			 }
			 
		 }
		return res;
		
	}
	
	//Exercice 3.b
	public static BitMap composanteVerte(BitMap img) {
			 	
		BitMap res=new BitMap(img.largeur(),img.hauteur());
		
		 for(int i=0;i<img.largeur();i++) {   //rendre touts les pixels blanche
			 
			 for(int j=0;j<img.hauteur();j++) {
				 
				 Pixel p = img.get(i,j); 
				 
				 p.v=255;
				 
				 res.set(i,j, p);
				 
			 }
			 
		 }
		return res;
			
		}
	
	//Exercice 3.c
	public static BitMap composanteBleue(BitMap img) {
		
		
		BitMap res=new BitMap(img.largeur(),img.hauteur());
		
		 for(int i=0;i<img.largeur();i++) {   //rendre touts les pixels blanche
			 
			 for(int j=0;j<img.hauteur();j++) {
				 
				 Pixel p = img.get(i,j); 
				 
				 p.b=255;
				 
				 res.set(i,j, p);
				 
			 }
			 
		 }
		return res;
			
			
		}
	
	
	//Exercice 4
	
	public static BitMap inverser(BitMap img) {
		
		BitMap res=new BitMap(img.largeur(),img.hauteur());
		
		for(int i=0;i<img.largeur();i++) {   //
			 
			 for(int j=0;j<img.hauteur();j++) {
				 
				 Pixel p = img.get(i,j); 
				 
				 p.r=255-p.r;
				 p.b=255-p.b;
				 p.v=255-p.v;
				 
				 verifierPixel(p);
				 
				 res.set(i,j, p);
				 
			 }
			 
		 }
		
		return res;
		
		
	}
	
	
	//Exercice 5
	public static BitMap bruit(BitMap img,int m) {
		
		BitMap res=new BitMap(img.largeur(),img.hauteur());
		
		for(int i=0;i<img.largeur();i++) {   
			 
			 for(int j=0;j<img.hauteur();j++) {
				 
				 Pixel p = img.get(i,j); 
				 
				 p.r=p.r-entierAleatoire(-m,m);
				 p.b=p.b-entierAleatoire(-m,m);
				 p.v=p.v-p.v-entierAleatoire(-m,m);
				 
				 verifierPixel(p);
				 
				 res.set(i,j, p);
				 
			 }
			 
		 }
		
		return res;
		
 
	}
	
	//Exercice 6.a
	public static BitMap filtreMonochrome(BitMap img) {
		
		BitMap res=new BitMap(img.largeur(),img.hauteur());
		
		Pixel p_blanche=new Pixel(255,255,255);
		 
		Pixel p_noir=new Pixel(0,0,0); 
		
		int moyenne;
		 
		
		for(int i=0;i<img.largeur();i++) {   
			 
			 for(int j=0;j<img.hauteur();j++) {
				 
				 Pixel p = img.get(i,j); 
				 
				 moyenne=(p.r+p.v+p.b)/3;
				 if(moyenne<128) res.set(i, j, p_noir);
				 else res.set(i, j, p_blanche);
				 
			 }
			 
		 }
		
		return res;
	}
	
	
	//Exercice 6.b
	public static BitMap filtreGris(BitMap img,boolean r) {
	
		BitMap res=new BitMap(img.largeur(),img.hauteur());

		double moyenne;
		 
		
		for(int i=0;i<img.largeur();i++) {   
			 
			 for(int j=0;j<img.hauteur();j++) {
				 
				 Pixel p = img.get(i,j); 
				 
				 if(r=false) moyenne=(p.r+p.v+p.b)/3;
				 else moyenne=0.2125*p.r+0.7154*p.v+0.0721*p.v;
					 
				 p.r=(int)moyenne;
				 p.v=(int)moyenne;
				 p.b=(int)moyenne;
				 
				 verifierPixel(p);
				 res.set(i, j, p);
				 
			 }
			 
		 }
		
		return res;
		
	}
	
	
	//Exercice 7
	public static BitMap filtreSepia(BitMap img) {
	
		BitMap res=new BitMap(img.largeur(),img.hauteur());

		
		for(int i=0;i<img.largeur();i++) {   
			 
			 for(int j=0;j<img.hauteur();j++) {
				 
				 Pixel p = img.get(i,j); 
				
					 
				 p.r=(int)(0.393*p.r+0.769*p.v+0.189*p.b);
				 p.v=(int)(0.349*p.r+0.686*p.v+0.168*p.b);
				 p.b=(int)(0.272*p.r+0.534*p.v+0.131*p.b);
				 
				 verifierPixel(p);
				 res.set(i, j, p);
				 
			 }
			 
		 }
		
		return res;
		
		
		
	}

	// TODO écrivez ici vos fonctions

	public static void main(String[] args) {

		System.out.println("Début du TP 9");

		// Exercice 1
		
		BitMap rectangle = simpleRectangle(100, 100);
		BitMap.enregistreBitMap(rectangle, "simpleRectangle");
		

		// Exercice 2
		
		BitMap croix = simpleCroix(100, 100);
		BitMap.enregistreBitMap(croix, "simpleCroix");
		

		// Lit l'image tiger.bmp dans le dossier principal du projet (au dessus du dossier src/ qui contient TP9.java)
		BitMap img = BitMap.aPartirDe("tiger.bmp");

		// Exercice 3
		
		BitMap.enregistreBitMap(composanteRouge(img),"tiger_rouge");
		BitMap.enregistreBitMap(composanteVerte(img),"tiger_vert");
		BitMap.enregistreBitMap(composanteBleue(img),"tiger_bleu");
		

		// Exercice 4
		
		BitMap.enregistreBitMap(inverser(img),"tiger_inverse");
		

		// Exercice 5
		
		BitMap.enregistreBitMap(bruit(img, 128),"tiger_bruit128");
		BitMap.enregistreBitMap(bruit(img, 64),"tiger_bruit64");
		

		// Exercice 6
		
		BitMap.enregistreBitMap(filtreMonochrome(img),"tiger_mono");
		

		
		BitMap.enregistreBitMap(filtreGris(img, false),"tiger_gris_pasrealiste");
		BitMap.enregistreBitMap(filtreGris(img, true),"tiger_gris_realiste");
	

		
		BitMap.enregistreBitMap(filtreSepia(img),"tiger_sepia");
		

		// Exercice 7
		/*
		BitMap.enregistreBitMap(posteriser(img, 32),"tiger_post32");
		BitMap.enregistreBitMap(posteriser(img, 64),"tiger_post64");
		BitMap.enregistreBitMap(posteriser(img, 128),"tiger_post128");
		*/

		// Exercice 8
		/*
		BitMap.enregistreBitMap(flou(img), "tiger_flou");
		BitMap.enregistreBitMap(flou(flou(img)), "tiger_flou_flou");
		*/

		System.out.println("Fin du TP 9");
	}

}








