# ASI TP (pour seafaire un peu la main en Python)

# p2.py

# méthodes avec parametres facultatifs
# manipulation de listes


# comprendre l'existant et compléter



import random


#=====================================================
# EXEMPLE : méthode avec un paramètre facultatif

#  
#  Procédure compare(int a : int, seuil:int)
#  indique la position de a par rapport à seuil
#  à défaut, seuil vaut 0


def compare(a , seuil=None) :
	if seuil==None :
		seuil=0
		
	if a<seuil :
		print(a, " est inferieur à ",seuil)
	elif a==seuil :
		print(a, " est égal à ",seuil)
	else :
		print(a, " est supérieur à ",seuil)
	# fin du if
# fin de la procédure compare




		
	
#TESTS de la procédure compare

compare(5) # pas de deuxième argument
compare(5,6)
compare(5,5)
compare(5,4)

#=====================================================
#

# Fonction int list donne_liste_alea(int taille : int , bmax : int)
# rend une liste de longueur taille comportant des entiers < bmax

def donne_liste_alea(taille : int ,bmax : int):
	l = []
	for i in range(taille) :
		l.append(random.randint(0,bmax))
		print(l)
	# fin for
	return l;
#fin Fonction donne_liste_alea
		
#=====================================================
# EXEMPLES : parcours de listes

#  Fonction filtre(int list l, int seuil)
#  rend une liste composée des élements de l >= à seuil
#  à défaut, seuil vaut 0
#pré : l néant

def filtre(l ,seuil=None) :
	lr = []   # liste résultat à construire
	if seuil==None :
		seuil=0
	
	for e in l :
		if e >= seuil :
			lr.append(e)
		#fin de if
	#fin de for
	
	return lr;
#fin de Fonction filtre



#TESTS de la procédure filtre

maliste = donne_liste_alea(20,10)
print("Liste maliste  pour le test de la fonction filtre",maliste)
print("   -> résultat pour filtre(maliste,5) : ",filtre(maliste,5))
print("   -> résultat pour filtre(maliste,3) : ",filtre(maliste,3))
print("   -> résultat pour filtre(maliste,8) : ",filtre(maliste,8))

		

# ecrire et tester une fonction de recherche d'un élément dans une liste
# A vous !!!


#Fonction boolean recherche_seq(list : int ,  e : int)
# recheche si un element e figure dans une liste
# pré : néant
def recherche_seq(l,e) :
        for x in l :
                if x==e :
                        return True
                #fin de if
        #fin de for
        return False
#fin recherche_seq

l1 = []
for i in range(0,4) :
    l1.append(2*i)
#fin for

print(" liste l1 ",l1)

print(" 1 ",recherche_seq(l1,1))
print(" 2 ",recherche_seq(l1,2))
print(" 6 ",recherche_seq(l1,4))


#Fonction boolean recherche_seq_trie(int list l, int e)
# pré : l est triée (et contient des entiers)
# post : rend le  premier élément de l supérieur ou égal à e (ou -1)

# à compléter
def recherche_seq_trie(l,e) :
	l2 = sorted(l)
	print(l2)
	fin = len(l2)-1
	debut = 0
	while (fin-debut) >= 0:
		milieu = (debut + fin) // 2
		if e > l2[milieu] :
			debut = milieu + 1 
		elif e < l2[milieu] :
			fin = milieu - 1
		else :
		    return l2[milieu]
	       #fin de if
	#fin de while
	return -1
#fin de la fonction
# à tester
try1 = [1,6,2,8,9]
print(recherche_seq_trie(try1,4))


