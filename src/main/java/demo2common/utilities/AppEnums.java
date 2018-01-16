/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.utilities;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Rendszer vagy <code>fix_code</code>-os kódok, típusok, státuszok.
 *
 * @author Varsányi Péter
 * @since 2017.07.21 - varp
 * @since 2017.07.28 - Richárd (új enum)
 * @since 2017.07.28 - varp - gombokon a jogok végigvezetése
 * @since 2017.09.04 - Richard - MKOSZTAO-252
 * @since 2017.09.12 - bt mkosztao-148 kiegészítve regisztráció típusa enum-al, permission kódok kiegészítve
 * @since 2017.10.30 - vz add permission code
 */
public class AppEnums {

    /**
     * Az engedély kódok módosítást jelző kód string-jének a vége.
     */
    public static final String MODIFY_POSTFIX = "_MODIFY";

    /**
     * Alapértemlezett permission code-ok (<code>Function.code</code>). Ezek az
     * alapjogok, alapértelmezetten "view". Ez egészülhet ki "_MODIFY" és akár
     * milyen finomított "alesettel".
     */
    public enum PERMISSION_CODE {
        ADDRESSES,
        ADDRESSES_MODIFY,
        ADDRESSESTYPES,
        ADDRESSESTYPES_MODIFY,
        AGEGROUPS,
        AGEGROUPS_MODIFY,
        ANONYMOUS, // bárki, de loginolva kell legyen
        AUDITLOGS,
        BACKUPDATA,
        BACKUPDATA_MODIFY,
        CALENDAREVENTS,
        CALENDAREVENTS_MODIFY,
        CALENDAREVENTSCOACHES,
        CALENDAREVENTSCOACHES_MODIFY,
        CALENDAREVENTSRACES,
        CALENDAREVENTSRACES_MODIFY,
        CALENDAREVENTSTRAININGS,
        CALENDAREVENTSTRAININGS_MODIFY,
        CALENDAREVENTSTYPES,
        CALENDAREVENTSTYPES_MODIFY,
        CATEGORIESGROUPS,
        CATEGORIESGROUPS_MODIFY,
        CHANGELOGS,
        CITIES,
        CITIES_MODIFY,
        COACHES,
        COACHES_MODIFY,
        CONTACTS,
        CONTACTS_MODIFY,
        CONTACTSTYPES,
        CONTACTSTYPES_MODIFY,
        COUNTRIES,
        COUNTRIES_MODIFY,
        CHAMPIONSHIPS,
        DOCUMENTSTYPES,
        DOCUMENTSTYPES_MODIFY,
        EMPLOYEES,
        EMPLOYEES_MODIFY,
        ENTRYSTATUS,
        EVENTSTATUSES,
        EVENTSTATUSES_MODIFY,
        FIXEDHOLIDAYS,
        FIXEDHOLIDAYS_MODIFY,
        INSTITUTIONS,
        INSTITUTIONS_MODIFY,
        LICENCETYPES,
        LICENCETYPES_MODIFY,
        MEDICALS,
        MEDICALS_MODIFY,
        MENTORDELEGATES,
        MENTORDELEGATES_MODIFY,
        MENTORREPORTS,
        MENTORREPORTS_MODIFY,
        MENTORS,
        MENTORS_MODIFY,
        ORGANIZATIONS,
        ORGANIZATIONS_MODIFY,
        ORGANIZATIONSTYPES,
        ORGANIZATIONSTYPES_MODIFY,
        PERSONS,
        CARS,
        CARS_MODIFY,
        PERSONS_MODIFY,
        PERSONSORGSCATEGORIES,
        PERSONSORGSCATEGORIES_MODIFY,
        PHYSICALMEASURES,
        PHYSICALMEASURES_MODIFY,
        PLAYERPOSITIONS,
        PLAYERPOSITIONS_MODIFY,
        PLAYERS,
        PLAYERS_MODIFY,
        PRESENCETYPES,
        PRESENCETYPES_MODIFY,
        PUBLIC, // publikus, nincs ellenőrzés; login sem kell hozzá
        PUBLICPLACETYPES,
        PUBLICPLACETYPES_MODIFY,
        ROLES,
        ROLES_MODIFY,
        STAFFS,
        STAFFS_MODIFY,
        SUBSTITUTIONS,
        SUBSTITUTIONS_MODIFY,
        SYSTEMPARAMS,
        SYSTEMPARAMS_MODIFY,
        TEAMS,
        TEAMS_MODIFY,
        TEMPLATES,
        TEMPLATES_MODIFY,
        TRAININGBOOKS,
        TRAININGBOOKS_MODIFY,
        TRAININGPLANS,
        TRAININGPLANS_MODIFY,
        UNITS,
        UNITS_MODIFY,
        USERS,
        USERS_MODIFY,
        WORKDAYS,
        WORKDAYS_MODIFY,
        PERSONS_RELATIONS,
        PERSONS_RELATIONS_MODIFY,
        SERVICES,
        SERVICES_MODIFY,
        RESOURCES,
        RESERVATION,
        RESERVATION_MODIFY;

        /**
         * A paraméterben megadott alap kódhoz hozzácsapja a módosítást leíró
         * részt.
         *
         * @param pc A megadott engedély kód.
         * @return A módosításra vonatkozó engedély kód. Ha a paraméter
         * <code>null</code> volt, az eredmény is <code>null</code>.
         */
        public static String getModify(PERMISSION_CODE pc) {
            String retVal = null;
            if (pc != null) {
                retVal = !pc.name().contains(MODIFY_POSTFIX) ? pc.name() + MODIFY_POSTFIX : pc.name();
            }
            return retVal;
        }

        /**
         * A paraméterben megadott alap kódhoz hozzácsapja a módosítást leíró
         * részt. Ha már hozzá van csapva, akkor nem teszi.
         *
         * @param pcName A megadott engedély kód neve.
         * @return A módosításra vonatkozó engedély kód. Ha a paraméter
         * <code>null</code> volt, az eredmény is <code>null</code>.
         */
        public static String getModify(String pcName) {
            String retVal = pcName;
            if (retVal != null && !retVal.contains(MODIFY_POSTFIX)) {
                retVal += MODIFY_POSTFIX;
            }
            return retVal;
        }
    }

    /**
     * Kalendárium események (<code>Calendarevents</code>) státuszok.
     */
    public enum CALENDAREVENTS_STATUS {
        /**
         * Nincs megadva.
         */
        NOTSETTED,
        /**
         * A felvett esemény alapértemezett állapota.
         */
        PREPARED,
        /**
         * Meghírdetett esemény
         */
        PUBLICATED,
        /**
         * Felfüggesztett esemény
         */
        SUSPENDED,
        /**
         * Jelenleg zajló esemény
         */
        CURRENTLY,
        /**
         * Törölt esemény
         */
        CANCELLED,
        /**
         * Lezárt. A hozzá kapcsolódó találkozó adatok nem módosíthatók.
         */
        COMPLETED
    }

    /**
     * Találkozó esemény típus (<code>CalendareventTypes</code>) kódok.
     */
    public enum CALENDAREVENTS_TYPES_CODE {
        /**
         * Nincs megadva.
         */
        NOTSETTED
    }

    /**
     * Beépített kapcsolat típus kódok.
     */
    public enum CONTACT_TYPES_CODE {
        COMPANYEMAIL,
        PERSONALEMAIL,
        OTHEREMAIL,
        TECHNICALEMAIL,
        COMPANYMOBILE,
        PERSONALMOBILE,
        COMPANYPHONE,
        PERSONALPHONE,
        COMPANYFAX,
        OTHERPHONENUMBER
    }

    /**
     * A taskhoz cuccok.
     */
    public enum TASK_STATUSES {
        NEW, OPEN, PROGRESS, DONE, FAIL
    }

    public enum TASK_ACTIONS {
        PERSONS
    }

    public enum PERSONS_TASK_SUBACTIONS {
        REG_APPROVAL, MISSING_PERSONAL_EMAIL
    }

    /**
     * Státuszok
     */
    public enum STATUS {
        WAITING,
        ACCEPTED
    }

    /**
     * Férfi-Nő
     */
    public enum GENDER {
        MALE("caption.man"),
        FEMALE("caption.woman");

        private String captionCode;

        GENDER(final String caption) {
            this.captionCode = caption;
        }

        public String getCaptionCode() {
            return captionCode;
        }

    }

    /**
     * Dokumentum típus
     */

    public enum DOCUMENT_TYPES {
        HIGHLIGHT
    }

    /**
     * Dokumentum típus csoport.
     */
    public enum DOCUMENT_TYPES_GROUPS {
        CALENDAREVENTS("caption.doctypegrp.calendarevents"),
        EDUCATIONSDOCUMENTS("caption.doctypegrp.educationsdocuments"),
        PLAYERSDOCUMENTS("caption.doctypegrp.playersdocuments"),
        TEAMS("caption.doctypegrp.teams"),
        ORGANIZATIONS("caption.doctypegrp.organizations"),
        TEMPALTES("caption.doctypegrp.tempaltes"),
        SPORTCLUB("caption.doctypegrp.sportclub");

        private String captionCode;

        DOCUMENT_TYPES_GROUPS(final String caption) {
            this.captionCode = caption;
        }

        public String getCaptionCode() {
            return captionCode;
        }

        @Override
        public String toString() {
            return name();
        }
    }

    /**
     * Egyedi azonosító típusa.
     */
    public enum UNIQUE_IDENTIFIER_TYPE {
        IDENTITY_CARD("caption.identitycard"),
        PASSPORT("caption.passport"),
        DRIVER_LICENSE("caption.driverlicense"),
        TAX_ID("caption.taxid"),
        SOCIAL_SECURITY_NUMBER("caption.socialsecuritynumber");

        private final String captionCode;

        UNIQUE_IDENTIFIER_TYPE(final String caption) {
            this.captionCode = caption;
        }

        public String getCaptionCode() {
            return captionCode;
        }

    }

    /**
     * Organization fix kódok. Ezek a gyűjtő/meta szervezetek kódjai.
     */
    public enum ORGANIZATIONS_CODE {
        COACH,
        PLAYER,
        MENTOR,
        MEDICAL,
        STAFF,
        EMPLOYEE;

        public static List<String> getMetaList() {
            List<String> metaNameList = new ArrayList<>();
            for (ORGANIZATIONS_CODE meta : ORGANIZATIONS_CODE.values()) {
                metaNameList.add(meta.name());
            }
            return metaNameList;
        }
    }

    /**
     * Beépített szervezet típus kódok.
     */
    public enum ORGANIZATIONS_TYPES_CODE {
        LICENCHOLDER,
        ORGANIZATION,
        MANAGEMENT,
        OFFICE,
        FINANCING,
        COMMISSION,
        SELECTION,
        SECTION,
        SPEC,
        TEAM,
        METAORGANIZATION,
        ROOT,
        SITE,
        PARTNER
    }

    public enum ADRESS_TYPES_CODE {
        COMPANYMAINADDRESS,
        COMPANYSITESADDRESS,
        BILLINGADDRESS,
        MAILINGADDRESS,
        PERSONALHOMEADDRESS,
        OTHERADDRESS;
    }


    /**
     * Kategória csoport fix kódok.
     */
    public enum CATEGORIES_GROUPS_CODE {
        COACH,
        PLAYER,
        MENTOR,
        MEDICAL,
        STAFF,
        EMPLOYEE
    }

    /**
     * Személy szervezet kategória csoport fix kódok.
     */
    public enum PERSONSORG_CATEGORIES {
        ATHLETE
    }

    /**
     * Személy szervezet kategória csoport fix kódok.
     */
    public enum REGEXPS {
        EMAIL("^" + "([a-zA-Z0-9_\\.\\-+])+" // local
                + "@" + "[a-zA-Z0-9-.]+" // domain
                + "\\." + "[a-zA-Z0-9-]{2,}" // tld
                + "$"),
        PHONENUMBER("^\\+[0-9]{1,3}[\\s\\.\\-]{0,1}[0-9]{1,3}[\\s\\.\\-]{0,1}[0-9]{7,12}$"),
        TAXNUMBER("^[0-9]{8}[\\-]{1}[0-9]{1}[\\-]{1}[0-9]{2}$");

        private String caption;

        REGEXPS(final String caption) {
            this.caption = caption;
        }

        public String getCaption() {
            return caption;
        }
    }

    /**
     * Naptár eseményeknél ismétlődési tartomány kiválasztásához használjuk
     */
    public enum CALENDAREVENTS_REPETABLE_CHOOSER {
        WITH_END_DATE("caption.withenddate", 0),
        WITH_COUNTER("caption.withcounter", 1);

        private final String captionCode;
        private final Integer selected;

        CALENDAREVENTS_REPETABLE_CHOOSER(String captionCode, Integer selected) {
            this.captionCode = captionCode;
            this.selected = selected;
        }

        public String getCaptionCode() {
            return captionCode;
        }

        public Integer getSelected() {
            return selected;
        }

    }

    /**
     * Naptár események kalkulálásához
     */
    public enum CALENDAREVENTS_UNITS {
        HOUR, WEEK, MONTH, YEAR, DAY
    }

    /**
     * Naptár események szűrésénél az első combobox elemei
     */
    public enum FILTER_FOR_CALENDAR {
        COACH("caption.coaches"),
        PLAYER("caption.players"),
        MENTOR("caption.mentors"),
        MEDICAL("caption.medicals"),
        STAFF("caption.staffs"),
        TEAM("caption.teams");

        private final String captionCode;

        FILTER_FOR_CALENDAR(String captionCode) {
            this.captionCode = captionCode;
        }

        public String getCaptionCode() {
            return captionCode;
        }
    }

    /**
     * Az alap model tranziens típus. Nem mindenhol van töltve! pl: Sportolók
     * meta szervezeteinek lekérdezésénél fontos ahol ezen múlik hogy az adott
     * entitást valaki szerkesztheti vagy nem.
     */
    public enum OWNED_OR_OTHER {
        OWNED, OTHER
    }

    /**
     * Naptár eseménynél használjuk ahol azt vizsgáljuk hogy a szervezeteket
     * másolni kell-e vagy sem.
     */
    public enum INHERITANCE_CODES {
        TRAINING
    }

    /**
     * Jelszó szabályok.
     */
    public enum PASSWORD_RULES { // ^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\s]).{8,16}$
        NUMBER("caption.number", "[0-9]"),
        CAPITAL_LETTER("caption.captital.letter", "[A-Z]"),
        MINUSCULE("caption.minuscule", "[a-z]"),
        SPECIAL_CHARACTER("caption.special.character", "[\\p{Punct}]"),
        PASSWORD_LENGTH("caption.maximum.length", ".");

        private final String caption;
        private final String regexp;

        PASSWORD_RULES(final String caption, final String regexp) {
            this.caption = caption;
            this.regexp = regexp;
        }

        public static PASSWORD_RULES getByRegexp(StringBuilder ruleBuilder) {
            PASSWORD_RULES retValue = null;
            String regexpStr = ruleBuilder.toString();
            for (PASSWORD_RULES rule : values()) {
                if (rule.getRegexp().equals(regexpStr)) {
                    retValue = rule;
                    break;
                }
            }
            return retValue;
        }

        public static PASSWORD_RULES getByRegexp(String regexp) {
            return getByRegexp(new StringBuilder(regexp));
        }

        public String getCaption() {
            return caption;
        }

        public String getRegexp() {
            return regexp;
        }

    }

    /**
     * Naptár eseményeknél ismétlődési tartomány kiválasztásához használjuk
     */
    public enum YESORNO {
        YES("yes", "CHECK_CIRCLE_O", Arrays.asList('i', 'y', 'I', 'Y', '1')),
        NO("no", "CIRCLE_THIN", Arrays.asList('h', 'n', 'H', 'N', '0', null));

        private final String captionCode;
        private final String iconCode;
        private final List<Character> values;

        YESORNO(String captionCode, String icon, List<Character> values) {
            this.captionCode = captionCode;
            this.iconCode = icon;
            this.values = values;
        }

        public String getCaptionCode() {
            return captionCode;
        }

        public String getIconCode() {
            return iconCode;
        }

        public List<Character> getValues() {
            return values;
        }

    }

    /**
     * A contactPage típusok kategóriája
     */
    public enum ContactsTypesCategory {

        EMAIL("E", "email"),
        PHONE("N", "phone"),
        WEB("W", "web"),
        OTHER("O","other");

        private final String code;
        private final String captionCode;

        ContactsTypesCategory(String code, String captionCode) {
            this.code = code;
            this.captionCode = captionCode;
        }

        public String getCode() {
            return code;
        }

        public String getCaptionCode() {
            return captionCode;
        }
    }

    public enum RegistrationType {
        USER("caption.registrationtype.user"),
        PARENT("caption.registrationtype.parent");

        private final String captionCode;

        RegistrationType(String captionCode) {
            this.captionCode = captionCode;
        }

        public String getCaptionCode() {
            return captionCode;
        }

    }

    public enum Countries{
        DEFAULT("HU");


        String code;

        Countries(String code) {
            this.code = code;

        }

        public String getCode() {
            return code;
        }
    }

    public enum ActionType {
        NEW, VIEW, EDIT, DELETE
    }

    public static final class SYSTEM_PARAM_CODES {
        public static final String SMTP_HOSTNAME = "SMTP_HOSTNAME";
        public static final String SMTP_PORT = "SMTP_PORT";
        public static final String SMTP_SSL_ON_CONNECT = "SMTP_SSL_ON_CONNECT";
        public static final String SMTP_FROM_EMAIL = "SMTP_FROM_EMAIL";
        public static final String SMTP_USER_AUTH = "SMTP_USER_AUTH";
        public static final String SMTP_USERNAME = "SMTP_USERNAME";
        public static final String SMTP_PASSWORD = "SMTP_PASSWORD";
        public static final String PASSWORD_REGEXP_RULE = "PASSWORD_REGEXP_RULE";
        public static final String PASSWORD_RULE_VIOLATION_MESSAGE = "PASSWORD_RULE_VIOLATION_MESSAGE";
        public static final String BASE_URL = "BASE_URL";
        public static final String TEMPORARY_APPOINTMENT_TIMEOUT = "TEMPORARY_APPOINTMENT_TIMEOUT";

    }
}
