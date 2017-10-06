#!/bin/sh
mkdir $1
cd $1
mkdir source
cd source
atom $1.java
