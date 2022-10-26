# ASI TP (pour se faire un peu la main en Python)

# p3_cor.py

# Manipuler des tables de corresponsances (dictionnaires)

# comprendre l'existant et compléter


# efforcez vous de comprendre tout l'existant,
# et de compléter lez zones indiquées à compléter

# Fonction lire_int()
# lit une entrée (des  caractères chiffres) et rend un entier
def lire_int():
    return int(input())


# fin Fonction lire_int


# Fonction lire_int_m()
# lit une entrée (des  caractères chiffres) et rend un entier
# il y a aun message d'invitation
def lire_int_m():
    return int(input("Donner un entier :"))


# fin Fonction lire_int_m


# Fonction lire_int_m2(mess)
# lit une entrée (des  caractères chiffres) et rend un entier
# il y a aun message d'invitation passé en paramètre
def lire_int_m2(mess):
    return int(input(mess))


# fin Fonction lire_int_m2

# déclaration et inirialisation d'un dictionnaire char x int
d1 = {'a': 10, 'w': 1, 'c': 9, 'z': 10, 'b': 15, 'u': 4}

print(d1)
print("les cles", d1.keys())  # --> dict_keys(['a', 'w', 'c', 'z', 'b', 'u'])
l1cles = list(d1.keys())
print("une liste des cles", list(d1.keys()))  # --> ['a', 'w', 'c', 'z', 'b', 'u']
print(sorted(d1))  # --> ['a', 'b', 'c', 'u', 'w', 'z']
print("une liste(triee) des cles ", sorted(list(d1.keys())))  # --> ['a', 'b', 'c', 'u', 'w', 'z']


# procedure IncrementeSeuil(d dict, s int)
# incremente les valeurs >= s
def incrementeSeuil(d: dict, s: int):
    print("zheshi",d.keys())
    for c in d.keys():  # un parcours des clés
        if d[c] >= s:  # d[c] donne la valeur de la clé c (erreur si c n'est pas présente)
            # pour tester la présence d'une clé : if c in d.keys() :
            d[c] = d[c] + 1


# fin IncrementeSeuil

# test IncrementeSeuil

print("incrementeSeuil sur ", d1) # --> {'a': 10, 'w': 1, 'c': 9, 'z': 10, 'b': 15, 'u': 4}
print(d1) # --> {'a': 10, 'w': 1, 'c': 9, 'z': 10, 'b': 15, 'u': 4}
incrementeSeuil(d1, 10)
print(" --> ", d1) # --> {'a': 11, 'w': 1, 'c': 9, 'z': 11, 'b': 16, 'u': 4}


# A PROGRAMMER ET TESTER
# Fonction cumulValTrie(d : dict) -> dict
# pre : d est un dictionnaire char x int
# post : rend un dictionnaire tel que :
# les clés sont les mêmes, les valeurs ont été cumulées (selon un ordre de clés triées)


# exemple
def cumulValTrie(d: dict):
    # A COMPLETER
    d2 = {}
    a = len(sorted(d))
    print(a)
    x = 0
    while x < a:
        if x == 0:
            d2[sorted(d)[0]] = d[sorted(d)[0]]
            x = x + 1
            print(x)
        else:
            d2[sorted(d)[x]] = d[sorted(d)[x]] + d2[sorted(d)[x - 1]]
            print(d[sorted(d)[x]], d[sorted(d)[x - 1]])
            x = x + 1
            print(x)
        # fin de if
    # fin de for
    return d2


# fin cumulValTrie

# exemple2
"""
def cumulValTrie2(d: dict):
    d3 = {}
    for x in sorted(d):
        if x == 'a':
            d3[x] = d[x]
        else:
            d3[x] = d[x] + d3[sorted(d)[x] - 1]
    return d3
"""
# test cumulValTrie
print("cumulValTrie sur ")
print(d1)  # normalement {'a':11,'w':1,'c':9,'z':11,'b':16,'u':4}
d1r = cumulValTrie(d1)
print(" --> ", d1r)  # normalement {'a':11,'b':27,'c':36,'u':40,'w':41,'z':52}
# d3r = cumulValTrie2(d1)
# print(d3r)