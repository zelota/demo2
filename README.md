demo2
==============

Vaadin + Spring 5 (nem boot) demo.

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
- start: ```docker run --name demo2 -e POSTGRES_PASSWORD=XXX -p 5432:5432 -d postgres```
- update:
```
docker exec -ti demo2 sed -i 's/# \(en_US\.UTF-8.*\)/\1/g' /etc/locale.gen
docker exec -ti demo2 sed -i 's/# \(hu_HU\.UTF-8.*\)/\1/g' /etc/locale.gen
docker exec -ti demo2 locale-gen
docker stop demo2
docker start demo2
```

Tomcat
======

Install
-------

Letöltés innen: https://tomcat.apache.org/download-80.cgi

Setup
-------

- /conf/tomcat-users.xml (XXX <- jelszó!):
```
<role rolename="tomcat-admin"/>
<role rolename="manager-gui"/>
<user password="XXX" roles="tomcat-admin,manager-gui,manager-script,admin" username="tomcat"/>
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
    jtaManaged="false"
/>
```
- Postgres JDBC driver letöltés innen: https://jdbc.postgresql.org/download.html
  <br/>Majd a driver másolása ide: ```/lib```
