#!/usr/bin/bash

echo ======================
echo DEBUT - Obtention du statut de l\'application
echo ======================

echo Récupération du PID du programme
PID=`ps aux | grep carrousel.jar | grep -v grep | awk '{ print $2 }'`

if [ $PID -ne "" ];then
	echo l\'application carrousel est lancee [PID=$PID]
else
	echo l\'application carrousel n\est pas lancee [PID=$PID]
fi
echo ----------------------

echo ======================
echo FIN - Obtention du statut de l\'application
echo ======================
