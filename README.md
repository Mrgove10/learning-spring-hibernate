# Spring_Hibernate_TP

The documentation (TP, slides, templates) are located in the [resourcesEtudiant/](resourcesEtudiant/) folder

To start the application : `gradlew appRun`

## Rendu

- partie 1 : voir tag `parti1`
- partie 2 : HEAD de master

Certaines methode n'on pas été implmenté, merci de regarder les commentaires dans celle-ci.

### Liste les entité persisté

J'ai fait le choix de persisté les entité UserAccount ansi que Products.
Se sont les deux celles classe de l'apllication qui pourrais avoir des donnés sauvegardé dans une BDD.

### LifeCycle Hibernate

Les session hibernate son cree pour chaque transaction.
Le fait de cree une session par requete a la base de donnée permet de ne pas cree des problemes d'acces au donnée entre lesdifferentesrequetes de plusieures utilisateurs.
Une fois la requete terminer la session est detruite

### Classes principales

Les classe principale sont : 
- HibernateUtil : c'est la classe qui permet de cree les session grace a un session factory
- MainWebAppInitializer : classe de lancement de l'apllication qui met en place toute les configuration
- DBUtils : classe qui gere les transactions avec la base de donnée

Separer tout cela en plusieur classe ameliore l'architechture car elle permet d'avoir duc ode plus simple et de segmenter son application , bien mieu pour la maintenance

### diagrame

void [diagrame.txt](diagrame.txt)