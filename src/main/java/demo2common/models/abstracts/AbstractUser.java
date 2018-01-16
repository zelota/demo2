/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.abstracts;


import demo2common.utilities.TextUtility;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 10. 02.
 */
public abstract class AbstractUser extends AbstractBaseEntity {

    public abstract String getLogin();

    /**
     * Get encripted password.
     * Add user login after parameter pwd string, then encript that string.
     *
     * @param plainPasswordStr Plain password string.
     * @return Encripted password string. If login or parameter is null, it returns null.
     */
    public String getEncriptedPassword( String plainPasswordStr ) {
        if ( plainPasswordStr == null || plainPasswordStr.isEmpty() || getLogin() == null || getLogin().isEmpty() ) {
            return null;
        }
        return TextUtility.encryptString(plainPasswordStr += getLogin());
    }

}
