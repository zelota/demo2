DO $$
DECLARE r RECORD;
BEGIN
  FOR r IN SELECT
             table_name,
             constraint_name
           FROM information_schema.constraint_table_usage
  LOOP
    EXECUTE 'ALTER TABLE IF EXISTS ' || quote_ident(r.table_name) || ' DROP CONSTRAINT IF EXISTS ' ||
            quote_ident(r.constraint_name) || ' CASCADE;';
  END LOOP;
END;
$$ LANGUAGE plpgsql;

DROP TABLE IF EXISTS AUDITLOGS;
DROP INDEX IF EXISTS IXPK_FUNCTIONS;
DROP INDEX IF EXISTS IXFK_HIERARCHY_OF_FUNCTIONS;
DROP TABLE IF EXISTS FUNCTIONS;
DROP INDEX IF EXISTS IXPK_MENUS;
DROP INDEX IF EXISTS IXFK_FUNCTIONS_TO_MENUS;
DROP INDEX IF EXISTS IXFK_HIERARCHY_OF_MENUS;
DROP TABLE IF EXISTS MENUS;
DROP INDEX IF EXISTS IXPK_ORGANIZATIONS;
DROP INDEX IF EXISTS IXFK_HIERARCHY_OF_ORGS;
DROP INDEX IF EXISTS IXFK_ORGANIZATION_TYPES_TO_ORGANIZATIONS;
DROP TABLE IF EXISTS ORGANIZATIONS;
DROP INDEX IF EXISTS IXPK_ORGANIZATION_TYPES;
DROP TABLE IF EXISTS ORGANIZATION_TYPES;
DROP INDEX IF EXISTS IXPK_PERSONS;
DROP TABLE IF EXISTS PERSONS;
DROP INDEX IF EXISTS IXPK_PERSONS_ORGANIZATIONS;
DROP INDEX IF EXISTS IXFK_ORGS_2_PERSONS_ORGS;
DROP INDEX IF EXISTS IXFK_PERSONS_2_PERSONS_ORGS;
DROP INDEX IF EXISTS IXFK_PERSONSORGSCATEGORIES_TO_PERSONSORGS2;
DROP TABLE IF EXISTS PERSONS_ORGANIZATIONS;
DROP INDEX IF EXISTS IXPK_ROLES;
DROP TABLE IF EXISTS ROLES;
DROP INDEX IF EXISTS IXPK_ROLES_FUNCTIONS;
DROP INDEX IF EXISTS IXFK_ROLES_TO_FUNCTIONS;
DROP INDEX IF EXISTS IXFK_FUNCTIONS_TO_ROLES;
DROP TABLE IF EXISTS ROLES_FUNCTIONS;
DROP INDEX IF EXISTS IXPK_SYSTEM_PARAMS;
DROP INDEX IF EXISTS IXFK_ORGS_TO_SYSTEM_PARAMS;
DROP TABLE IF EXISTS SYSTEM_PARAMS;
DROP INDEX IF EXISTS IXPK_USERS;
DROP INDEX IF EXISTS IXFK_PERSON_TO_USER;
DROP TABLE IF EXISTS USERS;
DROP INDEX IF EXISTS IXPK_USERS_ROLES;
DROP INDEX IF EXISTS IXFK_ROLES_TO_USERS;
DROP INDEX IF EXISTS IXFK_USERS_TO_ROLES;
DROP TABLE IF EXISTS USERS_ROLES;

/*==============================================================*/
/* Table: AUDITLOGS                                             */
/*==============================================================*/
CREATE TABLE AUDITLOGS (
  ID               SERIAL        NOT NULL,
  FUNCTIONS_ID     NUMERIC(10)   NULL,
  ORGANIZATIONS_ID NUMERIC(10)   NULL,
  USERS_ID         NUMERIC(10)   NULL,
  EVENT            VARCHAR(255)  NULL,
  SOURCE           VARCHAR(100)  NULL,
  FUNCTION_NAME    VARCHAR(255)  NULL,
  CLIENT_INFO      VARCHAR(4000) NULL,
  RESULT           VARCHAR(255)  NULL,
  CREATED          TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID       NUMERIC(10)   NULL,
  MODIFIED         TIMESTAMP     NULL,
  MODIFIER_ID      NUMERIC(10)   NULL,
  VALID_TO         TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION          NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_AUDITLOGS PRIMARY KEY (ID)
);


/*==============================================================*/
/* Table: FUNCTIONS                                             */
/*==============================================================*/
CREATE TABLE FUNCTIONS (
  ID          SERIAL        NOT NULL,
  PARENT_ID   INT4          NULL,
  CODE        VARCHAR(100)  NULL,
  NAME        VARCHAR(100)  NOT NULL,
  DESCRIPTION VARCHAR(4000) NULL,
  CREATED     TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID  NUMERIC(10)   NULL,
  MODIFIED    TIMESTAMP     NULL,
  MODIFIER_ID NUMERIC(10)   NULL,
  VALID_TO    TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION     NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_FUNCTIONS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_FUNCTIONS                                        */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_FUNCTIONS
  ON FUNCTIONS (
    ID
  );

/*==============================================================*/
/* Index: IXFK_HIERARCHY_OF_FUNCTIONS                           */
/*==============================================================*/
CREATE INDEX IXFK_HIERARCHY_OF_FUNCTIONS
  ON FUNCTIONS (
    PARENT_ID
  );

/*==============================================================*/
/* Table: MENUS                                                 */
/*==============================================================*/
CREATE TABLE MENUS (
  ID               SERIAL       NOT NULL,
  PARENT_ID        INT4         NULL,
  FUNCTIONS_ID     INT4         NULL,
  NAME             VARCHAR(100) NULL,
  CODE             VARCHAR(100) NULL,
  VIEW_NAME        VARCHAR(100) NULL,
  ICON_NAME        VARCHAR(100) NULL,
  ORDER_NUM        NUMERIC(10)  NULL,
  IS_ACTIVE        CHAR(1)      NULL,
  DESCRIPTION_CODE VARCHAR(100) NULL,
  CREATED          TIMESTAMP    NOT NULL DEFAULT now(),
  CREATOR_ID       NUMERIC(10)  NULL,
  MODIFIED         TIMESTAMP    NULL,
  MODIFIER_ID      NUMERIC(10)  NULL,
  VALID_TO         TIMESTAMP    NOT NULL DEFAULT '2100-01-01',
  VERSION          NUMERIC(10)  NULL     DEFAULT 1,
  CONSTRAINT PK_MENUS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_MENUS                                            */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_MENUS
  ON MENUS (
    ID
  );

/*==============================================================*/
/* Index: IXFK_FUNCTIONS_TO_MENUS                               */
/*==============================================================*/
CREATE INDEX IXFK_FUNCTIONS_TO_MENUS
  ON MENUS (
    FUNCTIONS_ID
  );

/*==============================================================*/
/* Index: IXFK_HIERARCHY_OF_MENUS                               */
/*==============================================================*/
CREATE INDEX IXFK_HIERARCHY_OF_MENUS
  ON MENUS (
    PARENT_ID
  );

/*==============================================================*/
/* Table: ORGANIZATIONS                                         */
/*==============================================================*/
CREATE TABLE ORGANIZATIONS (
  ID                    SERIAL        NOT NULL,
  PARENT_ID             INT4          NULL,
  ORGANIZATION_TYPES_ID INT4          NULL,
  CODE                  VARCHAR(100)  NULL,
  FIXED_CODE            CHAR(1)       NULL,
  NAME                  VARCHAR(100)  NOT NULL,
  TAX_NUMBER            VARCHAR(100)  NULL,
  COMPANY_REG_NUMBER    VARCHAR(100)  NULL,
  REGISTRATIONS_PLACE   VARCHAR(100)  NULL,
  ACCOUNT_NUMBER        VARCHAR(100)  NULL,
  MATER_PATH            VARCHAR(100)  NULL,
  IS_EXTERNAL           CHAR(1)       NULL,
  IS_MEMBER             VARCHAR(100)  NULL,
  ORG_PHOTO             BYTEA         NULL,
  CONTENT_TYPE          VARCHAR(255)  NULL,
  FILE_NAME             VARCHAR(255)  NULL,
  DESCRIPTION           VARCHAR(4000) NULL,
  CREATED               TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID            NUMERIC(10)   NULL,
  MODIFIED              TIMESTAMP     NULL,
  MODIFIER_ID           NUMERIC(10)   NULL,
  VALID_TO              TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION               NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_ORGANIZATIONS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_ORGANIZATIONS                                    */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_ORGANIZATIONS
  ON ORGANIZATIONS (
    ID
  );

/*==============================================================*/
/* Index: IXFK_HIERARCHY_OF_ORGS                                */
/*==============================================================*/
CREATE INDEX IXFK_HIERARCHY_OF_ORGS
  ON ORGANIZATIONS (
    PARENT_ID
  );

/*==============================================================*/
/* Index: IXFK_ORGANIZATION_TYPES_TO_ORGANIZATIONS              */
/*==============================================================*/
CREATE INDEX IXFK_ORGANIZATION_TYPES_TO_ORGANIZATIONS
  ON ORGANIZATIONS (
    ORGANIZATION_TYPES_ID
  );

/*==============================================================*/
/* Table: ORGANIZATION_TYPES                                    */
/*==============================================================*/
CREATE TABLE ORGANIZATION_TYPES (
  ID          SERIAL        NOT NULL,
  CODE        VARCHAR(100)  NULL,
  NAME        VARCHAR(100)  NOT NULL,
  DESCRIPTION VARCHAR(4000) NULL,
  FIXED_CODE  CHAR(1)       NULL,
  CREATED     TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID  NUMERIC(10)   NULL,
  MODIFIED    TIMESTAMP     NULL,
  MODIFIER_ID NUMERIC(10)   NULL,
  VALID_TO    TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION     NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_ORGANIZATION_TYPES PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_ORGANIZATION_TYPES                               */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_ORGANIZATION_TYPES
  ON ORGANIZATION_TYPES (
    ID
  );

/*==============================================================*/
/* Table: PERSONS                                               */
/*==============================================================*/
CREATE TABLE PERSONS (
  ID                SERIAL        NOT NULL,
  NAME              VARCHAR(100)  NULL,
  FIRST_NAME        VARCHAR(100)  NULL,
  MIDDLE_NAME       VARCHAR(100)  NULL,
  LAST_NAME         VARCHAR(100)  NULL,
  FULL_NAME         VARCHAR(4000) NULL,
  MOTHERS_NAME      VARCHAR(100)  NULL,
  BIRTH_DATE        TIMESTAMP     NULL,
  BIRTH_PLACE       VARCHAR(100)  NULL,
  GENDER            VARCHAR(50)   NULL,
  PHOTO             BYTEA         NULL,
  CONTENT_TYPE      VARCHAR(255)  NULL,
  FILE_NAME         VARCHAR(255)  NULL,
  IS_DECEASED       CHAR(1)       NULL,
  IS_EXTERNAL       CHAR(1)       NULL,
  SEND_NOTIFY_EMAIL CHAR(1)       NULL,
  UNIQUE_CODE       VARCHAR(100)  NULL,
  DESCRIPTION       VARCHAR(4000) NULL,
  CREATED           TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID        NUMERIC(10)   NULL,
  MODIFIED          TIMESTAMP     NULL,
  MODIFIER_ID       NUMERIC(10)   NULL,
  VALID_TO          TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION           NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_PERSONS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_PERSONS                                          */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_PERSONS
  ON PERSONS (
    ID
  );

/*==============================================================*/
/* Table: PERSONS_ORGANIZATIONS                                 */
/*==============================================================*/
CREATE TABLE PERSONS_ORGANIZATIONS (
  ID                        SERIAL        NOT NULL,
  ORGANIZATIONS_ID          INT4          NULL,
  PERSONS_ID                INT4          NULL,
  PERSONSORGS_CATEGORIES_ID INT4          NULL,
  MAIN_ORGANIZATION         CHAR(1)       NULL,
  HEAD_OF_ORG               CHAR(1)       NULL,
  DESCRIPTION               VARCHAR(4000) NULL,
  CREATED                   TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID                NUMERIC(10)   NULL,
  MODIFIED                  TIMESTAMP     NULL,
  MODIFIER_ID               NUMERIC(10)   NULL,
  VALID_TO                  TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION                   NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_PERSONS_ORGANIZATIONS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_PERSONS_ORGANIZATIONS                            */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_PERSONS_ORGANIZATIONS
  ON PERSONS_ORGANIZATIONS (
    ID
  );

/*==============================================================*/
/* Index: IXFK_ORGS_2_PERSONS_ORGS                              */
/*==============================================================*/
CREATE INDEX IXFK_ORGS_2_PERSONS_ORGS
  ON PERSONS_ORGANIZATIONS (
    ORGANIZATIONS_ID
  );

/*==============================================================*/
/* Index: IXFK_PERSONS_2_PERSONS_ORGS                           */
/*==============================================================*/
CREATE INDEX IXFK_PERSONS_2_PERSONS_ORGS
  ON PERSONS_ORGANIZATIONS (
    PERSONS_ID
  );

/*==============================================================*/
/* Index: IXFK_PERSONSORGSCATEGORIES_TO_PERSONSORGS2            */
/*==============================================================*/
CREATE INDEX IXFK_PERSONSORGSCATEGORIES_TO_PERSONSORGS2
  ON PERSONS_ORGANIZATIONS (
    PERSONSORGS_CATEGORIES_ID
  );

/*==============================================================*/
/* Table: ROLES                                                 */
/*==============================================================*/
CREATE TABLE ROLES (
  ID          SERIAL        NOT NULL,
  CODE        VARCHAR(100)  NULL,
  NAME        VARCHAR(100)  NULL,
  DESCRIPTION VARCHAR(4000) NULL,
  FIXED_CODE  CHAR(1)       NULL,
  CREATED     TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID  NUMERIC(10)   NULL,
  MODIFIED    TIMESTAMP     NULL,
  MODIFIER_ID NUMERIC(10)   NULL,
  VALID_TO    TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION     NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_ROLES PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_ROLES                                            */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_ROLES
  ON ROLES (
    ID
  );

/*==============================================================*/
/* Table: ROLES_FUNCTIONS                                       */
/*==============================================================*/
CREATE TABLE ROLES_FUNCTIONS (
  ID           SERIAL      NOT NULL,
  FUNCTIONS_ID INT4        NULL,
  ROLES_ID     INT4        NULL,
  CREATED      TIMESTAMP   NOT NULL DEFAULT now(),
  CREATOR_ID   NUMERIC(10) NULL,
  MODIFIED     TIMESTAMP   NULL,
  MODIFIER_ID  NUMERIC(10) NULL,
  VALID_TO     TIMESTAMP   NOT NULL DEFAULT '2100-01-01',
  VERSION      NUMERIC(10) NULL     DEFAULT 1,
  CONSTRAINT PK_ROLES_FUNCTIONS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_ROLES_FUNCTIONS                                  */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_ROLES_FUNCTIONS
  ON ROLES_FUNCTIONS (
    ID
  );

/*==============================================================*/
/* Index: IXFK_ROLES_TO_FUNCTIONS                               */
/*==============================================================*/
CREATE INDEX IXFK_ROLES_TO_FUNCTIONS
  ON ROLES_FUNCTIONS (
    ROLES_ID
  );

/*==============================================================*/
/* Index: IXFK_FUNCTIONS_TO_ROLES                               */
/*==============================================================*/
CREATE INDEX IXFK_FUNCTIONS_TO_ROLES
  ON ROLES_FUNCTIONS (
    FUNCTIONS_ID
  );

/*==============================================================*/
/* Table: SYSTEM_PARAMS                                         */
/*==============================================================*/
CREATE TABLE SYSTEM_PARAMS (
  ID               SERIAL        NOT NULL,
  ORGANIZATIONS_ID INT4          NULL,
  CODE             VARCHAR(100)  NULL,
  NAME             VARCHAR(100)  NULL,
  PARAM_VALUE      VARCHAR(4000) NULL,
  HIDDEN           CHAR(1)       NULL,
  SYSTEM_GLOBAL    CHAR(1)       NULL,
  DESCRIPTION      VARCHAR(4000) NULL,
  CREATED          TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID       NUMERIC(10)   NULL,
  MODIFIED         TIMESTAMP     NULL,
  MODIFIER_ID      NUMERIC(10)   NULL,
  VALID_TO         TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION          NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_SYSTEM_PARAMS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_SYSTEM_PARAMS                                    */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_SYSTEM_PARAMS
  ON SYSTEM_PARAMS (
    ID
  );

/*==============================================================*/
/* Index: IXFK_ORGS_TO_SYSTEM_PARAMS                            */
/*==============================================================*/
CREATE INDEX IXFK_ORGS_TO_SYSTEM_PARAMS
  ON SYSTEM_PARAMS (
    ORGANIZATIONS_ID
  );

/*==============================================================*/
/* Table: USERS                                                 */
/*==============================================================*/
CREATE TABLE USERS (
  ID          SERIAL        NOT NULL,
  PERSONS_ID  INT4          NULL,
  LOGIN       VARCHAR(255)  NULL,
  PASSWORD    VARCHAR(255)  NULL,
  LAST_LOGON  TIMESTAMP     NULL,
  IS_ACTIVE   CHAR(1)       NULL,
  DESCRIPTION VARCHAR(4000) NULL,
  CREATED     TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID  NUMERIC(10)   NULL,
  MODIFIED    TIMESTAMP     NULL,
  MODIFIER_ID NUMERIC(10)   NULL,
  VALID_TO    TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION     NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_USERS PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_USERS                                            */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_USERS
  ON USERS (
    ID
  );

/*==============================================================*/
/* Index: IXFK_PERSON_TO_USER                                   */
/*==============================================================*/
CREATE INDEX IXFK_PERSON_TO_USER
  ON USERS (
    PERSONS_ID
  );

/*==============================================================*/
/* Table: USERS_ROLES                                           */
/*==============================================================*/
CREATE TABLE USERS_ROLES (
  ID          SERIAL        NOT NULL,
  ROLES_ID    INT4          NULL,
  USERS_ID    INT4          NULL,
  DESCRIPTION VARCHAR(4000) NULL,
  CREATED     TIMESTAMP     NOT NULL DEFAULT now(),
  CREATOR_ID  NUMERIC(10)   NULL,
  MODIFIED    TIMESTAMP     NULL,
  MODIFIER_ID NUMERIC(10)   NULL,
  VALID_TO    TIMESTAMP     NOT NULL DEFAULT '2100-01-01',
  VERSION     NUMERIC(10)   NULL     DEFAULT 1,
  CONSTRAINT PK_USERS_ROLES PRIMARY KEY (ID)
);

/*==============================================================*/
/* Index: IXPK_USERS_ROLES                                      */
/*==============================================================*/
CREATE UNIQUE INDEX IXPK_USERS_ROLES
  ON USERS_ROLES (
    ID
  );

/*==============================================================*/
/* Index: IXFK_ROLES_TO_USERS                                   */
/*==============================================================*/
CREATE INDEX IXFK_ROLES_TO_USERS
  ON USERS_ROLES (
    ROLES_ID
  );

/*==============================================================*/
/* Index: IXFK_USERS_TO_ROLES                                   */
/*==============================================================*/
CREATE INDEX IXFK_USERS_TO_ROLES
  ON USERS_ROLES (
    USERS_ID
  );