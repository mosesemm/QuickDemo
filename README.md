# Car racing demo

### Required
* Maven 
* Mysql 

### Step by step setups
##### Download code to local:
Can use any of the options that are applicable
1. Download zip from https://github.com/mosesemm/QuickDemo
2. Unzip and go into the directory QuickDemo (From then on that will be the project root directory) 
3. Open terminal from there

##### Setup DB
1. Log into mysql as root (Enter root password on prompt):
```mysql -u root -h localhost -p```

2. Create required database
```mysql> create database carRacingDB;```

3. Create required application user;
```mysql> CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password1';```

4. Give user required privileges
```mysql> GRANT ALL PRIVILEGES ON carRacingDB. * TO 'appuser'@'localhost';```

5. Exit mysql
```mysql> quit```


6. Within project root directory, run mysql import of data (Enter root password on prompt):
 ```mysql -uroot -p carRacingDB < ./data/db.sql```
##### To run
Build application
```mvn clean install```
Run the application
```java -jar target/carracing-0.0.1-SNAPSHOT.jar```
<br/><br/>If there are any problems (hopefully not) they will be logged in app logs in the current dir (project root):
app.log
