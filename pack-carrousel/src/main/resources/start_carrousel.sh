#!/usr/bin/bash

echo ======================
echo DEBUT - Demarrage du programme carrousel
echo ======================

echo chmod sur le JAR programme
chmod +x "carrousel.jar"
echo ----------------------

echo chmod sur le script d\'arret du programme
chmod +x "stop_carrousel.sh"
echo ----------------------

echo chmod sur le script de statut du programme
chmod +x "status_carrousel.sh"
echo ----------------------

echo Creation du repertoire logs
if [ ! -d "logs" ];then
	mkdir logs
	chmod 755 logs
fi

echo Creation du repertoire images
if [ ! -d "images" ];then
	mkdir images
	chmod 755 images
fi

echo lancement du programme
java -jar -Dspring.config.location=./properties/ carrousel.jar >> logs/carrousel.log & disown
echo ----------------------

echo Pour suivre les logs de l\'application : tail -f logs/carrousel.log
echo ----------------------

echo ======================
echo FIN - Demarrage du programme carrousel
echo ======================
