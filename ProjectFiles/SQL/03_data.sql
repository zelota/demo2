-- organization types:
INSERT INTO organization_types (id, code, name, description, created, creator_id, version, valid_to)
VALUES (1, 'ORGANIZATION', 'Szervezet', 'Szervezet', now(), 1, 1, '2100.01.01');
ALTER SEQUENCE organization_types_id_seq RESTART WITH 2;

--Organization (példa adatok)
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (1, 1, 'Root', 'Root szervezet', '1', now(), 1, 1, null);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (2, 1, 'Szervezet 1', '', '1', now(), 1, 1, 1);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (3, 1, 'Szervezet 2', '', '2', now(), 1, 1, 1);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (4, 1, 'Szervezet 3', '', '3', now(), 1, 1, 1);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (5, 1, 'Szervezet 1.1', '', '1.1', now(), 1, 1, 2);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (6, 1, 'Szervezet 1.2', '', '1.2', now(), 1, 1, 2);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (7, 1, 'Szervezet 1.3', '', '1.3', now(), 1, 1, 2);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (8, 1, 'Szervezet 2.1', '', '2.1', now(), 1, 1, 3);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (9, 1, 'Szervezet 2.2', '', '2.2', now(), 1, 1, 3);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (10, 1, 'Szervezet 3.1', '', '3.1', now(), 1, 1, 4);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (11, 1, 'Szervezet 3.2', '', '3.2', now(), 1, 1, 4);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (12, 1, 'Szervezet 3.3', '', '3.3', now(), 1, 1, 4);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (13, 1, 'Szervezet 3.4', '', '3.4', now(), 1, 1, 4);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (14, 1, 'Szervezet 1.1.1', '', '1.1.1', now(), 1, 1, 5);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (15, 1, 'Szervezet 1.1.2', '', '1.1.2', now(), 1, 1, 5);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (16, 1, 'Szervezet 1.3.1', '', '1.3.1', now(), 1, 1, 7);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (17, 1, 'Szervezet 2.2.1', '', '2.2.1', now(), 1, 1, 9);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (18, 1, 'Szervezet 2.2.2', '', '2.2.2', now(), 1, 1, 9);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (19, 1, 'Szervezet 2.2.3', '', '2.2.3', now(), 1, 1, 9);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (20, 1, 'Szervezet 3.3.1', '', '3.3.1', now(), 1, 1, 12);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (21, 1, 'Szervezet 3.3.2', '', '3.3.2', now(), 1, 1, 12);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (22, 1, 'Szervezet 3.3.3', '', '3.3.3', now(), 1, 1, 12);

INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (23, 1, 'Szervezet 3.3.1.1', '', '3.3.1.1', now(), 1, 1, 20);
INSERT INTO ORGANIZATIONS (ID, ORGANIZATION_TYPES_ID, NAME, DESCRIPTION, MATER_PATH, CREATED, CREATOR_ID, VERSION, parent_id)
VALUES (24, 1, 'Szervezet 3.3.1.2', '', '3.3.1.2', now(), 1, 1, 20);

ALTER SEQUENCE organizations_id_seq RESTART WITH 25;

--Person
INSERT INTO PERSONS (ID, NAME, FULL_NAME, DESCRIPTION, CREATOR_ID, CREATED, VERSION, SEND_NOTIFY_EMAIL)
VALUES (1, 'Admin', 'Admin', 'App Admin', 1, now(), 1, '1');
ALTER SEQUENCE PERSONS_id_seq RESTART WITH 2;

--Persons Orgs
INSERT INTO PERSONS_ORGANIZATIONS (ID, PERSONS_ID, ORGANIZATIONS_ID, MAIN_ORGANIZATION, CREATED, CREATOR_ID, VERSION)
VALUES (1, 1, 1, 1, now(), 1, 1);
ALTER SEQUENCE PERSONS_ORGANIZATIONS_id_seq RESTART WITH 2;

--Roles
INSERT INTO ROLES (ID, CODE, NAME, DESCRIPTION, CREATED, CREATOR_ID, VERSION, FIXED_CODE)
VALUES (1, 'ADMIN', 'Admin', 'General application administration', now(), 1, 1, 'I');
ALTER SEQUENCE ROLES_id_seq RESTART WITH 2;

--Users
INSERT INTO USERS (ID, PERSONS_ID, LOGIN, PASSWORD, IS_ACTIVE, CREATED, CREATOR_ID, VERSION)
VALUES (1, 1, 'admin', 'YkWITYMKbhcBEWLTlcpcEw==', '1', now(), 1, 1); -- admin
ALTER SEQUENCE USERS_id_seq RESTART WITH 2;

--UsersRoles
INSERT INTO USERS_ROLES (ID, ROLES_ID, USERS_ID, CREATED, CREATOR_ID, VERSION) VALUES (1, 1, 1, now(), 1, 1);
ALTER SEQUENCE USERS_ROLES_id_seq RESTART WITH 2;

-- functions
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to) VALUES
  (1, NULL, 'ANONYMOUS', 'Anonymous elérés. Mindenkinek kell, olyan amihez nem kell extra jog, csak login.', now(), 1,
   1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (2, NULL, 'AUDITLOGS', 'Audilog (megtekintés)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (3, NULL, 'SYSTEMPARAMS', 'Rendszerparaméterek  (megtekintés)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (4, 3, 'SYSTEMPARAMS_MODIFY', 'Rendszerparaméterek (módosítás)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (5, NULL, 'ROLES', 'Szerepkörök (megtekintés)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (6, 5, 'ROLES_MODIFY', 'Szerepkörök (módosítás)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (7, NULL, 'USERS', 'Felhasználók (megtekintés)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (8, 7, 'USERS_MODIFY', 'Felhasználók (módosítás)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (9, NULL, 'PERSONS', 'Személyek (megtekintés)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (10, 9, 'PERSONS_MODIFY', 'Személyek (módosítás)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (11, NULL, 'ORGANIZATIONS', 'Szervezeti hierarchia karbantarás (megtekintés)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (12, 11, 'ORGANIZATIONS_MODIFY', 'Szervezeti hierarchia karbantarás (módosítás)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (13, NULL, 'ORGANIZATIONSTYPES', 'Szervezeti elem típusok (megtekintés)', now(), 1, 1, '2100.01.01');
INSERT INTO functions (id, parent_id, code, name, created, creator_id, version, valid_to)
VALUES (14, 13, 'ORGANIZATIONSTYPES_MODIFY', 'Szervezeti elem típusok (módosítás)', now(), 1, 1, '2100.01.01');
ALTER SEQUENCE functions_id_seq RESTART WITH 101;

-- roles_functions for ADMIN role
ALTER SEQUENCE roles_functions_id_seq RESTART WITH 1;
INSERT INTO roles_functions (roles_id, functions_id, creator_id) VALUES
  (1, 1, 1),
  (1, 2, 1),
  (1, 3, 1),
  (1, 4, 1),
  (1, 5, 1),
  (1, 6, 1),
  (1, 7, 1),
  (1, 8, 1),
  (1, 9, 1),
  (1, 10, 1),
  (1, 11, 1),
  (1, 12, 1),
  (1, 13, 1),
  (1, 14, 1);

-- menu items
INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (1, NULL, 1, 'Kódszótárak', 'menu.dictionaries', '', now(), 1, 1, '2100.01.01', 10);
INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (2, NULL, 1, 'Adminisztráció', 'menu.administration', '', now(), 1, 1, '2100.01.01', 30);

INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (3, 1, 13, 'Szervezeti egység típus', 'menu.organizationstypes', 'ORGANIZATIONSTYPES', now(), 1, 1, '2100.01.01', 10);
INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (4, 2, 11, 'Szervezeti egységek', 'menu.organizations', 'ORGANIZATIONS', now(), 1, 1, '2100.01.01', 10);
INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (5, 2, 7, 'Felhasználók', 'menu.users', 'USERS', now(), 1, 1, '2100.01.01', 20);
INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (6, 2, 9, 'Személyek', 'menu.persons', 'PERSONS', now(), 1, 1, '2100.01.01', 30);
INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (7, 2, 5, 'Szerepkörök', 'menu.roles', 'ROLES', now(), 1, 1, '2100.01.01', 40);
INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (8, 2, 3, 'Rendszer paraméterek', 'menu.systemparams', 'SYSTEMPARAMS', now(), 1, 1, '2100.01.01', 70);
INSERT INTO menus (id, parent_id, functions_id, name, code, view_name, created, creator_id, version, valid_to, order_num)
VALUES (9, 2, 2, 'Eseménynapló', 'menu.auditlogs', 'AUDITLOGS', now(), 1, 1, '2100.01.01', 80);
ALTER SEQUENCE menus_id_seq RESTART WITH 10;

-- systemparams
INSERT INTO SYSTEM_PARAMS (ID, ORGANIZATIONS_ID, CODE, NAME, PARAM_VALUE, DESCRIPTION, CREATOR_ID, SYSTEM_GLOBAL) VALUES
  (1, 1, 'SMTP_HOSTNAME', 'SMTP hostname', 'smtp.gmail.com', 'SMTP server host name.', 1, 'I'),
  (2, 1, 'SMTP_PORT', 'SMTP port number', '25', 'SMTP server port number.', 1, 'I'),
  (3, 1, 'SMTP_SSL_ON_CONNECT', 'SMTP SSL on connect', 'false', 'SMTP SSL on connect.', 1, 'I'),
  (4, 1, 'SMTP_FROM_EMAIL', 'SMTP from email address', 'no-replay@somewhere.org', 'From email address.', 1, 'I'),
  (5, 1, 'SMTP_USER_AUTH', 'Authentication', 'true', 'Does SMTP server use authentication?.', 1, 'I'),
  (6, 1, 'SMTP_USERNAME', 'Username', 'Administrator', 'Username for SMTP server connection.', 1, 'I'),
  (7, 1, 'SMTP_PASSWORD', 'Password', 'Pw123456', 'Password for SMTP server connection.', 1, 'I'),
  (8, 1, 'PASSWORD_REGEXP_RULE', 'Jelszó szabálya (reguláris kifejezés)', '^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{8,}$', 'Jelszó szabálya (reguláris kifejezés)', 1, 'I'), -- NAGYBETŰ, kistbető, szám, 8 karakter
  (9, 1, 'PASSWORD_RULE_VIOLATION_MESSAGE', 'Jelszó szabályt megsértésére felhasználói üzenet (captionCode kód)', 'captionCode.password.rule.violation', 'Jelszó szabályt megsértésére felhasználói üzenet.', 1, 'I'),
  (10, 1, 'BASE_URL', 'Alkalmazás alap URL-je', 'http://localhost:8080', 'Alkalmazás alap URL-je', 1, 'I'),
  (11, 1, 'TEMPORARY_APPOINTMENT_TIMEOUT', 'Az ideiglenes foglalások lejárati ideje percben', '10', 'Az ideiglenes foglalások lejárati ideje percben', 1, 'I');
ALTER SEQUENCE SYSTEM_PARAMS_ID_SEQ RESTART WITH 12;


