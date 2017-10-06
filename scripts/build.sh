#!/bin/sh
cd $1
mkdir -m 777 -p build/source/../class/../docs
cd source
cp *.java ../build/source/
cd ../build
javac -d class source/*.java
javadoc -encoding UTF-8 -charset UTF-8 -d docs -private source/*.java
