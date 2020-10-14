#!/bin/bash
cd src
java Compiler $1;
java -jar ../jasmin/jasmin.jar file.j;