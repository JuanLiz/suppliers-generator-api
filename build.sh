#!/bin/bash
# mvn clean package -DskipTests
java -DDATABASE_URL=jdbc:h2:file:~/persistence/dbprod -jar target/suppliers-generator-api-1.0.0.jar 
