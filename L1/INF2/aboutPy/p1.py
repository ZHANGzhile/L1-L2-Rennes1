# ASI TP (pour se faire un peu la main en Python)

# p1.py

# Différencier fonctions et procédures

# comprendre l'existant et compléter


# efforcez vous de comprendre tout l'existant,
# et de compléter lez zones indiqués à compléter

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


# print(lire_int_m())

# affiche un menu
def menu():
    print("Somme de deux entiers   : 1")
    print("Produit de deux entiers : 2")
    print("Max de deux entiers     : 3")
    print("Max de quatres entiers  : 4")
    print("Quitter :               : 0")


# fin Procédure menu


# lancer l'échange avec l'utilisateur
def tests_menu():
    menu()
    choix = lire_int_m2("Donner un entier entre 0 et 4")
    if choix == 1:
        Psomme()
    elif choix == 2:
        # à compléter !!
        Pproduit()
    elif choix == 3:
        # à compléter !!
        Pmax2()
    elif choix == 4:
        Pmax4()
        # à compléter !!
    else:
        print("Au revoir !")


# fin if
# fin procédure tests_menu


# Fonction Fsomme : rend la somme de deux entiers passés en paramètres
# Fsomme(a : int, b :int) => int
def Fsomme(a, b):
    return a + b


# fin Fonction Fsomme

def Fproduit(a, b):
    return a * b


# Procédure PSomme : fais l'aquisition de deux entiers et rend leur somme
def Psomme():
    print("SOMME DE DEUX ENTIERS")
    print(" Donnez deux entiers (valider chacun par retour chariot)")
    nlu1 = lire_int()
    nlu2 = lire_int()
    res = Fsomme(nlu1, nlu2)
    print("La somme de ", nlu1, " et de ", nlu2, " est ", res)


# fin de la procédure Psomme

# Procédure Pproduit : fais l'aquisition de deux entiers et rend leur produit
def Pproduit():
    print("PRODUIT DE DEUX ENTIERS")
    print(" Donnez deux entiers")
    nlu1 = lire_int_m()
    nlu2 = lire_int_m()
    res = Fproduit(nlu1, nlu2)  # à remplacer par un appel à UNE fonction Fproduit
    print("La somme de ", nlu1, " et de ", nlu2, " est ", res)


# fin de la procédure Pproduit

# Fonction max2 : rend le max de deux entiers passés en paramètres
# max(a : int, b : int) => bool
def Fmax2(a, b):
    if a <= b:
        r = b
    else:
        r = a
    return r


# fin Fonction max2

# Procedure Pmax2 : fais l'aquisition de deux entiers et rend le max
def Pmax2():
    print("LE MAX DE DEUX ENTIERS")
    print("Donner deux entiers")
    nlu1 = lire_int()
    nlu2 = lire_int()
    res = Fmax2(nlu1, nlu2)
    print("Le max de ", nlu1, " et de ", nlu2, " est ", res)


# fin de la procedure Pmax2

# Procedure Pmax4 : fais l
def Pmax4():
    print("LE MAX DE QUATRE ENTIERS")
    print("Donner quatre entiers")
    nlu1 = lire_int()
    nlu2 = lire_int()
    nlu3 = lire_int()
    nlu4 = lire_int()
    res = Fmax2(Fmax2(nlu1, nlu2), Fmax2(nlu3, nlu4))
    print("Le max de ", nlu1, " et de ", nlu2, " et de ", nlu3, " et de ", nlu4, " est ", res)


# fin de la procedure Pmax4
tests_menu()
