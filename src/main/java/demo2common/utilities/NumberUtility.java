/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.utilities;


import demo2common.helpers.ActionResult;

/**
 * @author Varsányi Péter
 */
public class NumberUtility {

    /**
     * String átalakítása Long típusra.
     * A stringet parse-olja Longgá.
     * Ha üres vagy null a string, akkor 0-t ad vissza.
     *
     * @param stringValue Szám érték stringként.
     * @return ActionResult. Az itemben a Long instance. Ha hiba volt, akkor az exceptionben.
     */
    public static ActionResult<Long> getLong( String stringValue ) {
        ActionResult<Long> result = new ActionResult<>();

        try {
            Long longValue = 0L;
            if ( stringValue != null && !stringValue.trim().isEmpty() ) {
                longValue = Long.parseLong(stringValue);
            }
            result.addItem(longValue);
            result.setOk(true);
        } catch (Exception ex) {
            result.setException(ex);
        }

        return result;
    }

    /**
     * A Long érték, ha null, 0-t ad vissza.
     * Null pointer exception ellenszer.
     *
     * @param value A Long érték.
     * @return A Long értek.
     */
    public static Long getValue( Long value ) {
        return value == null ? new Long(0) : value;
    }

    public static Boolean isNumeric( String str ) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
}
