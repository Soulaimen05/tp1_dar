images/version.png

images/client.png

images/serveur.png

images/ip.png

---

#Activité 1-2 : Service de calculatrice

### Multiplication simple
images/exemple1-ac2.png
images/exemple2-ac2.png
images/exemple3-ac2.png

**Interprétation :** x = 4 → 20 ; x = -3 → -15 ; x = 0 → 0.

### Saisies successives

images/exemple4-ac2.png
**Interprétation :** le client saisit plusieurs entiers, reçoit x * 5 pour chacun. La saisie de 0 arrête la boucle, et les sockets sont fermés des deux côtés.

---

#Activité 1-3 : Amélioration du service de calculatrice

##Connexion entre deux machines
images/ipconfig.png



##Calculatrice améliorée
images/menu.png
images/exemple.png
images/division_par0.png

**Interprétation :** Le client envoie le choix de l'opération et les deux opérandes. Le serveur calcule selon l'opération et renvoie le résultat. La division par zéro est détectée côté serveur et un message d'erreur est renvoyé.