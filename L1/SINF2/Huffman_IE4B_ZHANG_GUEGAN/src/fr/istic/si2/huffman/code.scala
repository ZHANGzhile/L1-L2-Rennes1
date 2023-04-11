package fr.istic.si2.huffman

object ConstructionCode {

  /**
   * @param l une liste de couples caractère/fréquence
   * @return la liste des arbres de Huffman réduits à des feuilles,
   *         un pour chaque élément de l
   */
  def initHuffman(l: List[(Char, Double)]): List[Huffman] = {
     l match {
      
      case Nil => Nil
      case (c,d)::m => Feuille(d,c) :: initHuffman(m)
      
    }
  }

  /**
   * @param l une liste d'arbres de Huffman
   * @return la liste des éléments de l, classée par ordre croissant des fréquences aux racines
   */
  def triSelonFreq(l: List[Huffman]): List[Huffman] = {
    
    l match {
      
      case Nil => Nil
      case e1::e2 => insertion(e1,triSelonFreq(e2))
      
    }
  }
  
  /**
   * @param h un arbre de Huffman 
   * @param l une liste d'arbres de Huffman trie dans l'ordre croissant des fréquences aux racines
   * @return une nouvelle liste trie engendree par l et n dans l'ordre croissant des fréquences aux racines
   * la fonction auxiliaire de la fonction triSelonFreq
   */
  def insertion(h:Huffman, l:List[Huffman]): List[Huffman]= {
    l match {
      
      case Nil => h::Nil
      case Feuille(d,c)::e1 => h match{
                                 case Feuille(d1,c1) => if(d1 > d) Feuille(d,c)::insertion(h,e1)
                                                        else h::l 
                                 case Noeud(d2,z,o) =>  if(d2 > d) Feuille(d,c)::insertion(h,e1)
                                                        else h::l
                               }
      case Noeud(d,z,o)::e1 => h match{
                                 case Feuille(d1,c1) => if(d1 > d) Noeud(d,z,o)::insertion(h,e1)
                                                        else h::l 
                                 case Noeud(d2,_,_)  => if(d2 > d) Noeud(d,z,o)::insertion(h,e1)
                                                        else h::l
                               }
    }
  }

  /**
   * @param l une liste d'arbres de Huffman, de longueur au moins 2
   * @return la liste obtenue après avoir fusionné les 2 arbres de l de fréquences minimales
   */
  def uneFusion(l: List[Huffman]): List[Huffman] = {
    triSelonFreq(l) match{
      
      case Nil => sys.error("non definition")
      case e::Nil => sys.error("non definition")
      case Feuille(d,c)::Feuille(d1,c1)::m  => if(d > d1) Noeud(d + d1, Feuille(d1,c1), Feuille(d,c))::m
                                               else Noeud(d + d1, Feuille(d,c), Feuille(d1,c1))::m
                                               
      case Feuille(d,c)::Noeud(d1,z,o)::m   => if(d > d1) Noeud(d + d1, Noeud(d1,z,o), Feuille(d,c))::m
                                               else Noeud(d + d1, Feuille(d,c), Noeud(d1,z,o))::m
                                               
      case Noeud(d,z,o)::Feuille(d1,c)::m   => if(d > d1) Noeud(d + d1, Feuille(d1,c), Noeud(d,z,o))::m
                                               else Noeud(d + d1, Noeud(d,z,o), Feuille(d1,c))::m
                                               
      case Noeud(d,z,o)::Noeud(d1,z1,o1)::m => if(d > d1) Noeud(d + d1, Noeud(d1,z1,o1),Noeud(d,z,o))::m
                                               else Noeud(d + d1, Noeud(d,z,o),Noeud(d1,z1,o1))::m
                                               
    }
  }

  /**
   * @param l une liste NON VIDE d'arbres de Huffman.
   * @return l'arbre de Huffman obtenu en fusionnant successivement,
   *         et 2 par 2, les arbres de l de fréquences minimales
   */
  def fusion(l: List[Huffman]): Huffman = {
    l match{
      
      case Nil => sys.error("non definition")
      case e::Nil => e
      case e::e1::m => fusion(uneFusion(l))
      
    }
  }

  /**
   * @param freqs une liste de couples caractère/fréquence
   * @return l'arbre de code de Huffman correspondant à freqs
   */
  def codeHuffman(freqs: List[(Char, Double)]): Huffman = {
    fusion(initHuffman(freqs))
  }

  /**
   * @param s une chaîne de caractères
   * @return la liste des couples (caractère, fréquence d'apparition),
   *         calculée à partir de s. Chaque élément couple (c, f) est tel que
   *         c est un caractère apparaissant dans s, et f est sa fréquence
   *         d'apparition dans s.
   */
  def analyseFrequences(s: String): List[(Char, Double)] = {
    occurance(s,s.length())
  }
  
  /**
   * @param s une chaîne de caractères
   * @param n un entier
   * @return la liste des couples (caractère, fréquence d'apparition),
   *         calculée à partir de s. Chaque élément couple (c, f) est tel que
   *         c est un caractère apparaissant dans s, et f est sa fréquence
   *         d'apparition dans s.
   * la fonction auxiliaire de la fonction analyseFrequences
   */
  def occurance(s: String,n :Double): List[(Char,Double)] = {
    frequences(s.toList) match{
      
      case (c,m,s1) => if(m == 0) Nil
                       else (c,m/n) :: occurance(s1,n)
      
    }
  }
  
  /**
   * @param l une list de caractères
   * @return un tuple de taille 3 comprenant:
   *         -le premier caractére dans la liste l
   *         -l'occurence du premier caractère apparaissant dans la liste l
   *         -la chaîne de caractéres qui contient les éléments rests dans la liste l (sauf tout les occurences du premier caractère)
   * la fonction auxiliaire de la fonction analyseFrequences 
   */
  def frequences(l: List[Char]): (Char,Double,String) = {
     l match{
       
       case Nil => ('N',0,"")
       case e::Nil => (e,1,"")
       case e::e1::m => if(e == e1) (e, 1 + frequences(e::m)._2,frequences(e::m)._3) 
                        else (e, frequences(e::m)._2, e1 + frequences(e::m)._3)
     }
  }


}