# Le carrousel de FELIX

## Présentation

Application permettant la diffusion d'images sur des TV, écran.

Le but étant de partager des documents sous forme d'image (rapports de PIC, DR, PERF, invitations aux communautés, photo journées respi, ..... tout ce que vous voulez ;)

L'application est actuellement déployée ici : http://192.168.14.190:8082/

## Technologies

- Java 8
- Tymeleaf
- Bootstrap

## Source

https://si-devops-gitlab.edf.fr/flx-felix/carrousel

## Lancement sur eclipse :

VM arguments :
-Dspring.config.location=file:D:\carrousel\configurations-carrousel\src\main\resources\application-dev.yml

## Build

A la racine : 

```
mvn clean install
```

Cela génère un zip dans pack-carrousel/target

## Déploiement

Prendre tout le contenu du zip et le transferer sur la machine linux 192.168.14.190 dans /root/carrousel

lancer la commande

```
[root@LILVMAPACHE carrousel]# chmod +x start_carrousel.sh
```

Ouvrir depuis winscp avec notepad++ les fichiers start, status et stop enlever une ligne vide et sauvegarder.

C'est louche mais je pense qu'il y à un problème de conversion CRLR entre windows et linux.

La commande dos2unix aurait résolue le pb mais pas dispo sur cette machine linux.

A creuser si vous voulez ;)

Pour démarrer l'application lancer :

```
[root@LILVMAPACHE carrousel]# ./start_carrousel.sh
```

Pour arrêter l'application lancer :

```
[root@LILVMAPACHE carrousel]# ./stop_carrousel.sh

```

## Ajouter des images

Il suffit d'ajouter des images dans le répertoire /root/carrousel/images (répertoire créé par le start)

![images_carrousel.PNG](images_readme/images_carrousel.PNG)



## Paramétrage du carrousel 

J'ai externalisé toutes les ressources Javascript, CSS, Bootstrap

Vous pouvez donc librement modifier le carrousel dans les fichiers /root/carrousel/ihm/static/custom/js/main.js et /root/carrousel/ihm/static/custom/css/main.css

![js_carrousel.PNG](images_readme/js_carrousel.PNG)



## Configuration des répertoires

Les configuration de l'application SpringBoot sont également externalisées dans /root/carrousel/properties/application.yml

Vous pouvez modifier le port de l'application ou le chemin des images, ressources...

![images_readme/carrousel_properties.PNG](images_readme/carrousel_properties.PNG)



## Pour aller plus loin

Externaliser le répertoire templates qui contient le fichier home.html afin de pouvoir le modifier à chaud sans devoir builder et redeployer l'application.

J'ai essayer mais ca ne fonctionne pas.

Vous pouvez creuser le sujets si cela vous interesse



## Références

https://getbootstrap.com/docs/4.0/components/carousel/



