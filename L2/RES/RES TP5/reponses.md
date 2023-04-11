ZHANG Zhile
MOULHERAT Hadrien

Q1: Car les 1024 premiers ports ([0; 1023]) sont des **ports systemes**. Ils sont utiliser par le systeme d'exploitation soit pour des *processus reseaux* (exemple: les protocoles UDP ou TCP), ou bien pour des applications du systeme comme le serveur X (window manager).

Q2: Etant donnee qu'il n'y a pas d'etablissement de connexion, pour que le client communique avec le serveur, il faut qu'il lui envoie toutes les information neccesaire dans le **datagramme** pour que le serveur lui reponde. Le serveur recupere donc les informations, nottamment l'ip a travers le datagramme que le client a envoyer precedemment.

Q3: En selectionnant la bonne *interfaces reseaux* et en ajoutant un filtre **(port=xxxx)** sur *WireShark*, on retrouve bien le bon protocole utilise pour la couche transport, a savoir le protocole UDP.

Q4: Concernant le port destination (du point de vue du serveur) il correspond bien aux port choisie dans l'application. Enfin concernant le port source (toujours du point de vue du serveur) il est different car il est generer lors de la premierre communication entre le serveur et le client.

Q5: L'addresse MAC utiliser pour les deux paquets echanges entre le serveur et le client est **00:00:00:00:00:00**. Elle ne correspond pas a l'addresse MAC de notre machine (**14:b3:1f:02:50:23**), car il s'agit d'une communication en local (localhost). Donc il n'est pas neccassaire d'utiliser l'adresse MAC. En effet l'addresse MAC est utiliser pour identifier une machine specifique dans un reseaux. Dans notre contexte il ne peut s'agir que de notre machine, l'adresse MAC est donc inutile.

Q6: Le client et le serveur ne se terminent pas, car tout d'abord le client envoie un message dans le vide, et se bloque en attendant le reponse du serveur. Enfin le serveur se bloque aussi en attendant la reception d'un datagramme. Donc le serveur attend un message du client et le client attent la reponse du serveur. (**SOFT LOCK**)

Q7: Toujours en selectionnant la bonne *interfaces reseaux* et en ajoutant un **filtre (port=xxxx)** sur *WireShark*, on retrouve bien le bon protocole utilise pour la couche transport, a savoir le protocole TCP.

Q8: Sur WireShark on peut voir:
-Tout d'abord le client fait une demande de connexion aupres du serveur, c'est l'etape de Synchronisation (**SYNC**).
-Le serveur accepte la connexion (**ETABLISHED**), et repond au client en donnant ses parametres a lui (**SYNC**) et en envoyant aussi un message d'acquitement pour confirmer la bonne reception de la premierre transmission (**ACK**).
(Le fait de donner plusieurs "utilite" (**SYNC+ACK**) dans un seul message s'appelle du piggy-backing).
-Enfin le client repond lui aussi avec un message d'acquitement (**ACK**), pour confirmer qu'il a bien recu la transmission precedante.

Q9: Il ne se passe rien, parce que les processus utilisent un protocole de communication different. Aucune fonctionalite du systeme d'exploitation ne permet a ces deux processus de communiquer ensemble. Le serveur **TCP** attend donc la reponse d'un client utilisant le protocole **TCP** et le client a tres probablement envoyer un message dans le vide, attendant desesperement la reponse du serveur **UDP**. (Une bonne manierre de confirmer la reponse est de lancer ensuite le client **TCP** (et verifier la communication entre serveur et client), enfin lancer le serveur UDP (et verifier qu'il ne se passe rien, comme expliquer dans le reponse a la **question 6**)).