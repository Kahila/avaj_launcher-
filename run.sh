#!/bin/sh

javac -d bin src/simulator/*.java src/weather/*.java src/simulator/vehicles/*.java
cd bin
java simulator.Main ../data.txt
rm -fr *
