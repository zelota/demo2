/*
 * Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.utilities;

import org.hibernate.exception.ConstraintViolationException;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains global helper methods.
 *
 * @author Varsányi Péter
 * @since 2017.07.28 - varp - a jogok végigvezetése
 * @since 2017.10.12 - default locale hu-HU
 */
public class Utility {

    public static final String PERSISTENCE_UNIT_NAME = "BW_PU";
    public static final int COMBOBOX_DEFAULT_MAX_RESULTS = 200;

    /**
     * A megadott karakter érték igaz (<code>Boolean</code>) érték-e? Igaz, ha
     * az értéke nem null és "i" vagy "y" vagy "1". Nem számít, hogy kis- vagy
     * nagybetű!
     *
     * @param chrValue Charater érték.
     * @return Boolean érték.
     */
    public static Boolean isCharaterYes( Character chrValue ) {
        for ( Character yesOrNoCharacter : AppEnums.YESORNO.YES.getValues() ) {
            if ( yesOrNoCharacter.equals(chrValue) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * A megadott karakter érték igaz (<code>Boolean</code>) érték-e? Igaz, ha
     * az értéke nem null és "i" vagy "y" vagy "1". Nem számít, hogy kis- vagy
     * nagybetű!
     *
     * @param chrValue Charater érték.
     * @return Boolean érték.
     */
    public static Boolean isCharaterYes( String chrValue ) {
        return chrValue != null && isCharaterYes(chrValue.charAt(0));
    }

    /**
     * Egy Boolean értékből Charater értéket "készít", amit adatbázisban
     * tárolunk. Ha a paraméter null, a visszatérés is null!
     *
     * @param bValue Boolean érték.
     * @return A Boolean értéknek megfelelő ('Y' vagy 'N') érték. Ha a paraméter
     * null, a visszatérés is null!
     */
    public static Character getBooleanCharacter( Boolean bValue ) {
        if ( bValue == null ) {
            return null;
        }
        return (bValue) ? 'Y' : 'N';
    }

    public static String getBooleanString( Boolean bValue ) {
        return getBooleanCharacter(bValue).toString();
    }

    /**
     * ConstraintViolationException loggolása és informatív kibontása a logba.
     *
     * @param cve ConstraintViolationException instance.
     */
    public static void logCVException( ConstraintViolationException cve ) {
        Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, "ConstraintViolationException ---");
        Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, cve.getMessage());
        // hibrenate-nél nem tudom még hogyan kell kiszedni ezeket az infokat, ezért ezek a sorok kommentbe:
        //        Set<ConstraintViolation<?>> s = cve.getConstraintViolations();
        //        for ( ConstraintViolation<?> cv : s ) {
        //            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, "CV Message: === +++ ===: " + cv.getMessage());
        //            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, "PropertyPath: " + cv.getPropertyPath().toString());
        //            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, "AnnotationType: " + cv.getConstraintDescriptor().getAnnotation().annotationType());
        //        }
        Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, cve);
    }

    /**
     * Egyedi azonosító generalasa
     *
     * @return String
     */
    public static String getUniqueID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Get localized message/text by code and locale.
     *
     * @param strCode      String code (in the properties file).
     * @param locale       Locale code.
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @param msgFileName  Messages file name. Default: messages.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nText( String strCode, Locale locale, String defaultValue, String msgFileName ) {
        String retVal = strCode;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("localizations/" + locale.toString() + "/" + msgFileName);
            retVal = bundle.getString(strCode);
        } catch (java.util.MissingResourceException mre) {
            if ( defaultValue == null || defaultValue.isEmpty() ) {
                //retVal = "Exception:[" + strCode + "]";
                Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, "Exception - getI18nText method: code is null/empty or missing! Code: " + strCode);
            } else {
                retVal = defaultValue;
            }
        }
        return retVal;
    }

    /**
     * Get localized patterned message/text by code and locale. Patterned
     * message string consists a replaceable text part.
     *
     * @param strCode      String code (in the properties file).
     * @param locale       Locale code.
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @param msgFileName  Messages file name. Default: messages.
     * @param patternText  Pattern (replacable string) text.
     * @param patternValue Pattern value.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nText( String strCode, Locale locale, String defaultValue, String msgFileName, String patternText, String patternValue ) {
        String retVal = getI18nText(strCode, locale, defaultValue, msgFileName);
        return retVal.replaceAll(patternText, patternValue);
    }

    //
    //<editor-fold defaultstate="collapsed" desc="i18n">

    /**
     * Get localized patterned message/text by code and locale. Patterned
     * message string consists a "#FIELD_NAME#" text part which will be replace.
     *
     * @param strCode      String code (in the properties file).
     * @param locale       Locale code.
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @param msgFileName  Messages file name. Default: messages.
     * @param patternValue Pattern value.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nText( String strCode, Locale locale, String defaultValue, String msgFileName, String patternValue ) {
        return getI18nText(strCode, locale, defaultValue, msgFileName, "#FIELD_NAME#", patternValue);
    }

    /**
     * Get localized message/text from default messages file by code and locale.
     *
     * @param strCode      String code (in the properties file).
     * @param locale       Locale code.
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nMessages( String strCode, Locale locale, String defaultValue ) {
        return getI18nText(strCode, locale, defaultValue, "messages");
    }

    public static String getI18nMessagesRequired( String strCode ) {
        return getI18nMessagesRequired(strCode, getDefaultLocale());
    }

    //<editor-fold defaultstate="collapsed" desc="i18n - messages">

    public static String getI18nMessagesWrong( String strCode ) {
        return getI18nMessagesWrong(strCode, getDefaultLocale());
    }

    public static String getI18nMessagesExists( String strCode ) {
        return getI18nMessagesExists(strCode, getDefaultLocale());
    }

    public static String getI18nMessagesNotExists( String strCode ) {
        return getI18nMessagesNotExists(strCode, getDefaultLocale());
    }

    public static String getI18nMessagesRequired( String strCode, Locale locale ) {
        String message = getI18nText("msg.pattern.error.required", locale, null, "messages");
        String value = getI18nText(strCode, getDefaultLocale(), null, "others").toLowerCase();
        return message.replaceAll("#FIELD_NAME#", value);
    }

    public static String getI18nMessagesWrong( String strCode, Locale locale ) {
        String message = getI18nText("msg.pattern.error.wrong", locale, null, "messages");
        String value = getI18nText(strCode, getDefaultLocale(), null, "others").toLowerCase();
        return message.replaceAll("#FIELD_NAME#", value);
    }

    public static String getI18nMessagesExists( String strCode, Locale locale ) {
        String message = getI18nText("msg.pattern.error.exists", locale, null, "messages");
        String value = getI18nText(strCode, getDefaultLocale(), null, "others").toLowerCase();
        return message.replaceAll("#FIELD_NAME#", value);
    }

    public static String getI18nMessagesNotExists( String strCode, Locale locale ) {
        String message = getI18nText("msg.pattern.error.notexists", locale, null, "messages");
        String value = getI18nText(strCode, getDefaultLocale(), null, "others").toLowerCase();
        return message.replaceAll("#FIELD_NAME#", value);
    }

    /**
     * Get localized message/text from default messages file by code and locale.
     *
     * @param strCode String code (in the properties file).
     * @param locale  Locale code.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nMessages( String strCode, Locale locale ) {
        return getI18nMessages(strCode, locale, null);
    }

    /**
     * Get localized message/text from default messages file by code and locale.
     * Use <code>Locale.getDefault</code> value.
     *
     * @param strCode String code (in the properties file).
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nMessages( String strCode ) {
        return getI18nMessages(strCode, getDefaultLocale(), null);
    }

    /**
     * Get localized message/text from default messages file by code and locale.
     * Use <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param patternText  Text pattern. Replacable string part.
     * @param patternValue Pattern value.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nMessages( String strCode, String patternText, String patternValue ) {
        return getI18nText(strCode, getDefaultLocale(), null, "messages", patternText, patternValue);
    }

    /**
     * Get localized message/text from default messages file by code and locale.
     * Use <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nMessages( String strCode, String defaultValue ) {
        return getI18nMessages(strCode, getDefaultLocale(), defaultValue);
    }

    /**
     * Get localized menu text from default messages file by code and locale.
     *
     * @param strCode      String code (in the properties file).
     * @param locale       Locale code.
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nMenus( String strCode, Locale locale, String defaultValue ) {
        return getI18nText(strCode, locale, defaultValue, "menus");
    }

    /**
     * Get localized menu text from default messages file by code and locale.
     *
     * @param strCode String code (in the properties file).
     * @param locale  Locale code.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nMenus( String strCode, Locale locale ) {
        return getI18nMenus(strCode, locale, null);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="i18n - menus">

    /**
     * Get localized menu text from default messages file by code and locale.
     * Use <code>Locale.getDefault</code> value.
     *
     * @param strCode String code (in the properties file).
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nMenus( String strCode ) {
        return getI18nMenus(strCode, getDefaultLocale(), null);
    }

    /**
     * Get localized menu text from default messages file by code and locale.
     * Use <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nMenus( String strCode, String defaultValue ) {
        return getI18nMenus(strCode, getDefaultLocale(), defaultValue);
    }

    /**
     * Get localized menu text from default messages file by code and locale.
     * Use <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param patternText  Text pattern. Replacable string part.
     * @param patternValue Pattern value.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nMenus( String strCode, String patternText, String patternValue ) {
        return getI18nText(strCode, getDefaultLocale(), null, "menus", patternText, patternValue);
    }

    /**
     * Get localized text from default messages file by code and locale.
     *
     * @param strCode      String code (in the properties file).
     * @param locale       Locale code.
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nButtons( String strCode, Locale locale, String defaultValue ) {
        return getI18nText(strCode, locale, defaultValue, "buttons");
    }

    /**
     * Get localized text from default messages file by code and locale.
     *
     * @param strCode String code (in the properties file).
     * @param locale  Locale code.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nButtons( String strCode, Locale locale ) {
        return getI18nButtons(strCode, locale, null);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="i18n - buttons ">

    /**
     * Get localized text from default messages file by code and locale. Use
     * <code>Locale.getDefault</code> value.
     *
     * @param strCode String code (in the properties file).
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nButtons( String strCode ) {
        return getI18nButtons(strCode, getDefaultLocale(), null);
    }

    /**
     * Get localized text from default messages file by code and locale. Use
     * <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nButtons( String strCode, String defaultValue ) {
        return getI18nButtons(strCode, getDefaultLocale(), defaultValue);
    }

    /**
     * Get localized menu text from default messages file by code and locale.
     * Use <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param patternText  Text pattern. Replacable string part.
     * @param patternValue Pattern value.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nButtons( String strCode, String patternText, String patternValue ) {
        return getI18nText(strCode, getDefaultLocale(), null, "buttons", patternText, patternValue);
    }

    /**
     * Get localized text from default messages file by code and locale.
     *
     * @param strCode      String code (in the properties file).
     * @param locale       Locale code.
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nFormats( String strCode, Locale locale, String defaultValue ) {
        return getI18nText(strCode, locale, defaultValue, "formats");
    }

    /**
     * Get localized text from default messages file by code and locale.
     *
     * @param strCode String code (in the properties file).
     * @param locale  Locale code.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nFormats( String strCode, Locale locale ) {
        return getI18nFormats(strCode, locale, null);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="i18n - formats ">

    /**
     * Get localized text from default messages file by code and locale. Use
     * <code>Locale.getDefault</code> value.
     *
     * @param strCode String code (in the properties file).
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nFormats( String strCode ) {
        return getI18nFormats(strCode, getDefaultLocale(), null);
    }

    /**
     * Get localized text from default messages file by code and locale. Use
     * <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nFormats( String strCode, String defaultValue ) {
        return getI18nFormats(strCode, getDefaultLocale(), defaultValue);
    }

    /**
     * Get localized text from default messages file by code and locale.
     *
     * @param strCode      String code (in the properties file).
     * @param locale       Locale code.
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nOthers( String strCode, Locale locale, String defaultValue ) {
        return getI18nText(strCode, locale, defaultValue, "others");
    }

    /**
     * Get localized text from default messages file by code and locale.
     *
     * @param strCode String code (in the properties file).
     * @param locale  Locale code.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nOthers( String strCode, Locale locale ) {
        return getI18nOthers(strCode, locale, null);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="i18n - others ">

    /**
     * Get localized text from default messages file by code and locale. Use
     * <code>Locale.getDefault</code> value.
     *
     * @param strCode String code (in the properties file).
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nOthers( String strCode ) {
        return getI18nOthers(strCode, getDefaultLocale(), null);
    }

    /**
     * Get localized text from default messages file by code and locale. Use
     * <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param defaultValue If <code>strCode</code> is missing in localization
     *                     file, the method gives back this value. It can be null or empty.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]' or defaultValue (if it's not
     * null).
     */
    public static String getI18nOthers( String strCode, String defaultValue ) {
        return getI18nOthers(strCode, getDefaultLocale(), defaultValue);
    }

    /**
     * Get localized menu text from default messages file by code and locale.
     * Use <code>Locale.getDefault</code> value.
     *
     * @param strCode      String code (in the properties file).
     * @param patternText  Text pattern. Replacable string part.
     * @param patternValue Pattern value.
     * @return The localized string/text value. If an exception raises, the
     * result is: 'Exception:[" + strCode + "]'.
     */
    public static String getI18nOthers( String strCode, String patternText, String patternValue ) {
        return getI18nText(strCode, getDefaultLocale(), null, "others", patternText, patternValue);
    }

    // ideiglenesen kommentbe!
//    /**
//     * A kapott input <code>string</code>-ben kicserél az ékezetes karaktereket a nem ékezetes megfelelőikkel, lowercase,
//     * trim-eli a maradék szóközöket egyetlen <code>glue</code>-ra cseréli
//     *
//     * @param input
//     * @param glue
//     * @return
//     */
//    public static String noramlizeString( String input, String glue ) {
//        return StringUtils.stripAccents(input)
//                .trim()
//                .toLowerCase()
//                .replaceAll(" +", " ")
//                .replaceAll("[^A-Za-z0-9 ]", "")
//                .replaceAll(" ", glue);
//
//    }

    public static Locale getDefaultLocale() {
        return Locale.forLanguageTag("hu-HU");
    }

    public enum AuditorFieldsInfo {
        VALIDTO("validTo"), VERSION("version"), CREATED("created"), CREATORID("creatorId"), MODIFIED("modifier"), MODIFIERID("modifierId");

        private final String fieldName;

        AuditorFieldsInfo( String fieldName ) {
            this.fieldName = fieldName;
        }

        public String getFieldName() {
            return this.fieldName;
        }
    }

    //</editor-fold>
    //</editor-fold>

    public enum DIALOG_MODE {
        NOTSETTED, NEW, MODIFY, VIEW, DELETE, COPY, PASSWORD, MESSAGE, SELECT
    }
}
