## TP Mediathèque
Créer un projet SpringBoot avec JPA et Spring Web \
On a besoin de 3 tables : adherents, documents, emprunts \
On a besoin d’une classe Service qui va manipuler la base de données \
On a besoin d’une classe qui va contenir les règles métier liées au fonctionnement de la médiathèque (et qu’on pourra tester avec des Tests Unitaires si nécessaire) 

#### Créer une API :
- GET /adherents 
- POST /adherents 
- GET /documents 
- POST /documents 
- GET /emprunts 
- POST /emprunts 

#### Règles métier :
- Un adhérent ne peut pas emprunter plus de 3 documents 
- Un adhérent ne peut pas emprunter si son adhesion est périmée 
- Un document ne peut être emprunté en même temps par plusieurs adhérents 

Aide pour les associations JPA:
1 Emprunt doit contenir 1 Adherent et 1 Document (ManyToOne)

#### Bonus 
- Pouvoir rendre un Document 
- Lister les documents en retards et les emails des adherents concernés 

### Solution :
#### GET ALL Adherent
![getA.PNG](screenshots/getA.PNG)

#### POST Adherent
![postA.PNG](screenshots/postA.PNG)

#### GET ALL Document
![getD.PNG](screenshots/getD.PNG)

#### POST Document
![postD.PNG](screenshots/postD.PNG)

#### GET ALL Emprunt
![getAllEmprunts.PNG](screenshots/getAllEmprunts.PNG)

#### POST Emprunt
![postE.PNG](screenshots/postE.PNG)

#### Bonus:
#### RENDRE DOCUMENT
![rendreDocument.PNG](screenshots/rendreDocument.PNG)

#### DISPLAY LATE DOCUMENTS
![getLateDocuments.PNG](screenshots/getLateDocuments.PNG)