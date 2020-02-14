#!/usr/bin/bash

echo ======================
echo DEBUT - Arret du programme carrousel
echo ======================

echo Recuperation du PID du programme
PID=`ps aux | grep carrousel.jar | grep -v grep | awk '{ print $2 }'`
echo le PID vaut $PID
echo ----------------------

echo Kill du processus
kill -9 $PID
echo ----------------------

echo ======================
echo FIN - Arret du programme carrousel
echo ======================
