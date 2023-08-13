#! /usr/bin/bash
mvn clean test -Dcucumber=" --tags @mercedesAutomation" allure:serve

