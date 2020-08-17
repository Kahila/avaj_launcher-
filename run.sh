#!/bin/sh

javac -d bin src/*.java src/simulator/*.java src/weather/*.java src/simulator/vehicles/*.java
cd bin
java Main ../data.txt
