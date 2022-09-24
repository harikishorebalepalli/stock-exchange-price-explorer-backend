# stock-exchange-price-explorer-backend

## Versions
java version "17.0.2"  
Spring-boot version "2.7.4"


## To set up Database
1. Install mySql community server
2. Use the following script to create database and table:

    create database stockexchange;
    
    use stockexchange;
    
    create table prices(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    symbol varchar(255),
    close double,
    timestamp varchar(255)
    );
    
3. Load data into the prices table
4. start the mysql server at port 3306.

## To install and run
1. Install Maven and add it to java class path
2. Build the maven project in the application loaction path : mvn clean install
3. Run the springboot app : "mvn spring-boot:run"

