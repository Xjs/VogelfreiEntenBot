#!/bin/bash
BASEDIR=$(dirname "$0")
echo "$BASEDIR"
cd $BASEDIR
java -cp bin:lib/telegrambots-2.4.4.5-jar-with-dependencies.jar Main
