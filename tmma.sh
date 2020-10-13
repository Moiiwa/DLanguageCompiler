#!/bin/bash
cd src
java Compiler $1;
cd ..
java -jar jasmin/jasmin.jar file.j;