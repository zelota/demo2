-- demo2 adatbázis és (demo2user) felhasználó létrehozása

-- júzer
create user demo2user LOGIN PASSWORD 'Password123.';

-- adatbázis
create database demo2 owner=demo2user ENCODING='UTF8'; -- LC_CTYPE='hu_HU.utf8';
