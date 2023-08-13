#! /usr/bin/bash
mvn clean test -Denv="edge" -Dcucumber=" --tags @mercedesAutomation" allure:serve

