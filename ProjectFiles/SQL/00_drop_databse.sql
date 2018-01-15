-- demo2 adatbázis és (demo2user) felhasználó eldobása

-- db törlése
--DO
--$do$
--BEGIN
--  IF EXISTS (select 1 from pg_database where datname='demo2') THEN
    drop DATABASE demo2;
--  end IF;
--END
--$do$;

-- juser törlése
--DO
--$do$
--BEGIN
--  IF EXISTS (select 1 from pg_roles where rolname='demo2user') THEN
    drop USER demo2user;
--  end IF;
--END
--$do$;

