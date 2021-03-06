demo2
==============

Vaadin + Spring 4 (nem boot) demo.

Ami kell
========
- Oracle Java 8
- Tomcat 8.5.24
- Postgres 10.1

Postgres
========

Docker
------
- install: ```docker pull postgres:10.1```
- start: ```docker run --name demo2 -e POSTGRES_PASSWORD=XXX -p 5432:5432 -d postgres:10.1```
- update:
```
docker exec -ti demo2 sed -i 's/# \(en_US\.UTF-8.*\)/\1/g' /etc/locale.gen
docker exec -ti demo2 sed -i 's/# \(hu_HU\.UTF-8.*\)/\1/g' /etc/locale.gen
docker exec -ti demo2 locale-gen
docker stop demo2
docker start demo2
```

Adatbázis létrehozása
---------------------
- ProjectFiles/SQL/01_create_database.sql (postgres nevében kell futtatni!)
- ProjectFiles/SQL/02_create_tables.sql (demo2user-el)
- ProjectFiles/SQL/03_data.sql (demo2user-el)

Tomcat
======

Install
-------

Letöltés innen: https://tomcat.apache.org/download-80.cgi

Setup
-------

- /conf/tomcat-user.xml (XXX <- jelszó!):
```
<role rolename="tomcat-admin"/>
<role rolename="manager-gui"/>
<user password="XXX" role="tomcat-admin,manager-gui,manager-script,admin" username="tomcat"/>
```
- /conf/server.xml (a GlobalNamingResources részbe. XXX <- jelszó!): 
```
<!-- DEMO2 -->
<Resource name="DEMO2" id="DEMO2" type="javax.sql.DataSource"
    JdbcDriver="org.postgresql.Driver"
    JdbcUrl="jdbc:postgresql://127.0.0.1:5432/"
    validationQuery = "SELECT 1"
    initialSize = "10"
    testWhileIdle="true"
    timeBetweenEvictionRunsMillis="30000"
    testOnBorrow="true"
    removeAbandoned = "true"
    removeAbandonedTimeout = "120"
    UserName="postgres"
    Password="XXX"
    jtaManaged="true"
/>
```
- Postgres JDBC driver letöltés innen: https://jdbc.postgresql.org/download.html
  <br/>Majd a driver másolása ide: ```/lib```
