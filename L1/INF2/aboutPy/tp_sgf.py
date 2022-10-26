from fs import *

# TRAVAUX PRATIQUES INF2 : LE SYSTEME DE FICHIER
#
# Ce TP contient des fonctions qu'il vous appartient de comprendre,
# implémenter, tester.Par défaut, pour l'instant les fonctions
# affichent seulement leur nom.
#
# Pensez à regarder l'évolution du cache ...

############################################################
# INIT 
############################################################
def INIT(diskname, disksize, cachesize):
    fs_make_disk(diskname, disksize)
    fs_init_cache(cachesize)
    fs_format_disk(diskname, disksize)
    fs_init_dcache()

print("**************************************************")
print("\nTEST de init, création du votre premier disque:\n")
INIT("MY1stDISK",10,3)
fs_log_on()

############################################################
# DUMP 
############################################################
def DUMP(diskname):
    fs_dump_disk(diskname)
    fs_dump_cache()
    fs_dump_dcache()

print("**************************************************")
print("\nTEST de DUMP:\n")

DUMP("MY1stDISK")

############################################################
# LS
############################################################
def LS(param=None):
    if (param):
        if fs_lookup_in_dcache(param):
            res = param
        else: 
            res = False
    else:
        ls_node = fs_list_in_dcache()
        res = []
        for node in ls_node:
            res.append(name_of_node(node))
    return res

print("**************************************************")
print("\nTEST de LS:\n")
print("ls")
print(LS())
print("**************************************************")
print(LS("jenesuispasla"))
print("**************************************************")
print(LS("."))
print("**************************************************")
print(LS(".."))

############################################################
# SYNC
############################################################      
def SYNC():
    fs_sync_cache()

print("**************************************************")
print("\nTEST de SYNC:\n")
SYNC()
DUMP("MY1stDISK")

############################################################
# MKDIR
############################################################
def MKDIR(name) :
    sector = fs_getfreeblock()
    node = fs_lookup_in_dcache(name)
    if sector and not node:
        fs_mkdir_in_dcache(name, sector)
        res = True
    elif not sector:
        res = False
        print("MKDIR ERROR: Disk full")
    elif node:
        res = False
        print("MKDIR ERROR: Name %s already used" % (name))
    return res

print("**************************************************")
print("\nTEST de MKDIR:\n")
MKDIR("my1stdir")
print("**************************************************")
print(LS())
print("**************************************************")
DUMP("MY1stDISK")
SYNC()
DUMP("MY1stDISK")

############################################################
# CD
############################################################
def CD(name):
    # à compléter pour vérifier que name est bien le nom
    # d'un sous-répertoire du répertoire courant
    if(is_DNODE(fs_lookup_in_dcache(name))):
        fs_cd_in_dcache(name)
        res = True
    else:
        print("Il n'y a aucun répertoire portant le nom %s" % (name))
        res = False
    return res

print("**************************************************")
print("\nTEST de CD, MKDIR et SYNC:\n")

print(CD("my1stdir"))
print("**************************************************")
print(LS())
print("**************************************************")
MKDIR("bach")
print("**************************************************")
print(LS())
MKDIR("mozart")
print(LS())
MKDIR("berlioz")
print(LS())
DUMP("MY1stDISK")
SYNC()
DUMP("MY1stDISK")
print(CD("mozart"))
print(LS("."))
print("**************************************************")
print(CD("debussy"))
print("**************************************************")

############################################################
# TOUCH
############################################################
def TOUCH(name):
    sector = fs_get_freeblock()
    res = False
    if sector:
        if not(is_FNODE(fs_lookup_in_dcache(name))):
            fs_touch_in_dcache(name,sector)
            res = True
        else:
            print("Il déja exsit un ficher portant nom %s" % (name))
    else:
        print("Le disque est plein")
    return res

print("**************************************************")
print("\nTEST de TOUCH:\n")
TOUCH("son1")
TOUCH("toto")
TOUCH("mon fichier") 
print(LS())
DUMP("MY1stDISK")
SYNC()
DUMP("MY1stDISK")

############################################################
# WRITE
############################################################
def WRITE(name, contents):
    res = False
    if is_FNODE(fs_lookup_in_dcache(name)):
        fs_write_in_dcache(name,contents)
        res = True
    else:
        print("Il n'y a aucun fichier portant le nom %s" % (name))
    return res
        
    
print("**************************************************")
print("\nTEST de WRITE:\n")
print(WRITE("son1","sisidoréré"))
DUMP("MY1stDISK")
SYNC()
DUMP("MY1stDISK")

############################################################
# READ
############################################################
def READ(name):
    if is_FNODE(fs_lookup_in_dcache(name)):
        res = fs_read_in_dcache(name)
    else:
        print("Il n'y a pas un ficher portant le nom %s" % (name))
        res = False
    return res

print("**************************************************")
print("\nTEST de READ:\n")

print(READ("read"))    
print(READ("son1"))
print(READ("fichierquinexistepas"))

############################################################
# RM
############################################################
def RM(name):
    res = False
    if fs_lookup_in_dcache(name):
        if is_DNODE(fs_lookup_in_dcache(name)):
            fs_cd_in_dcache(name)
            lis = fs_list_in_dcache()
            fs_cd_in_dcache("..")
            if len(lis) == 2:
                fs_rm_in_dcache(name)
                fs_sync_cache()
                res = True
            else:
                print("Le répertoire n'est pas vide !")
        else:
            fs_rm_in_dcache(name)
            fs_sync_cache()
            res = True
    else:
        print("Il n'y a aucun répertoire ou fichier portant le nom %s" % (name))
    return res
print("**************************************************")
print("\nTEST de RM:\n")

print(LS())
RM("son1")
print(LS())
CD("..")
DUMP("MY1stDISK")
SYNC()
DUMP("MY1stDISK")

fs_stats()

