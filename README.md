# API Tests for TMDB Service

This repository contains source code that implements framework to test REST APIs for TMDB service. It uses Rest-Assured framework along with JAVA 1.8, TestNG and Maven.

#### Pre-requisite to run the tests
  * Install the latest Apache MAVEN in local system
  * Install Java 1.8 SDK

#### To download the respository do
  * git clone https://github.com/achung2018/tmdb_service_apitests.git 
  
#### To run the test
```shell
cd tmdb_service_apitests
mvn clean install -P local -Denvironment=qa -Dapikey=<your api key>

Note: Replace the above <your api key> with your actual api key

After the tests have completed running, the test result can be found at tmdb_service_apitests/target/surefire-reports/emailable-report.html
