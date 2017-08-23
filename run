#!/bin/bash
BASEDIR=$(dirname "$0");
cd $BASEDIR;
java -cp bin:lib/telegrambots-2.4.4.5-jar-with-dependencies.jar Main 2> run.error.log >/dev/null &
PID=$!;
echo "$PID";
