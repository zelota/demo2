package demo2backend.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Felhasználó - session adatok.
 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Scope.html
 * <p>
 * Az <b>adatkör</b> meghatározásához az alábbi property-k használatosak:
 * <ul>
 * <li><code>dataSetOrganization</code> - az adat lekérdezésekben (selectekben) és az újak létrehozásában (insertekben) használt szervezet.
 * <ul>
 * <li>Insertekben használataos - új létrehozásakor.</li>
 * <li>Az egyes lekérdezésekben (selectekben).</li>
 * <li>Lehet null.</li>
 * <li>Szabadon beállítható.</li>
 * </ul>
 * Megjegyzés: jelenleg a felületről is szabadon állítható, illetve a lekérdező metódusok kialakítása miatt - nagyon sok helyen
 * általánosat használunk - a felületről kell beállítani. Igazándiból viszont ezt a service methodon belül kellene
 * beállítani.
 * </li>
 * <li><code>selectedOrganization</code> - a felületen kiválsztott szervezet.
 * <ul>
 * <li>A felületi lenyílóból jön - ez az amit a belépett felhasználó választ.</li>
 * <li>Lehet null. (Ilyen <code>admin</code> vagy olyan felhasználónál fordulhat elő, ahol csak egy szervezet van megadva.)</li>
 * </ul>
 * </li>
 * <li><code>mainOrganization</code> - fő szervezet. A bejelentkezett felhasználó
 * alapértelmezett szervezete.
 * <ul>
 * <li>Csak egy lehet ilyen a DB-ben!</li>
 * <li>A DB-ből jön.</li>
 * <li>NEM lehet null!</li>
 * </ul>
 * </li>
 * </ul>
 * <b>Működési elv</b>: Ha <code>dataSetOrganization</code> null, akkor a selected orgot adja vissza, ha az is null, akkor main org-ot.
 * A <code>dataSetOrganization</code>-et beállításával vezérelhető az egyes funkciókon, dialógusokon
 * használt lekérdezések adatköre. Ha null-ra állítjuk, akkor az kiválasztott lesz az érvényes,
 * ha pedig az is null volt, nem baj, mert akkor a main org jut érvényre. A main org viszont kötelező,
 * mert egy, az adatkört meghatározó szervezetnek minden belépett (tehát nem technikai) felhasználónak kell lennie!
 * <b>Ezt az elvet a <code>dataSetOrganization</code> gettere valósítja meg, ezért minden adatkörre vonatkozó helyen (insert, select, stb.)
 * ezt a (<code>getDataSetOrganization()</code>) metódust kell használni!</b>
 * <p>
 * A technikai felhasználók esetén is be kell állítani a <code>dataSetOrganization</code>-t!
 */
@Component
@Scope(value = "session")
public class UserData implements Serializable {

    private static final long serialVersionUID = 2017011521135436456L;
//
//    /**
//     * A személy main szervezete. Login után kell beállítani.
//     * Ez a személy alapértelmezett szervezete.
//     * Egy ilyennek KELL lennie a DB-ben.
//     * NEM lehet null!
//     */
//    private Organization mainOrganization;
//
//    /**
//     * Login status.
//     */
//    private LOGINSTATES loginStatus;
//    /**
//     * Logged in user.
//     */
//    private User loggedInUser;
//    /**
//     * Substituted user. Null if it's not a substitution situation.
//     */
//    private User substitutedUser;
//    /**
//     * Function (permissions) collection. Logged in user's or (if exists) the
//     * substituted user's functions.
//     */
//    private List<Function> functions;
//    /**
//     * A kiválasztott vállalat.
//     * A felületen (a lenyílóban) kiválasztott szervezet.
//     * Értéke lehet null!
//     * Ha null, akkor a main orgot adja vissza.
//     */
//    private Organization selectedOrganization;
//    /**
//     * A selectekben az adatkörre szűkítésére vonatkozó szervezet.
//     * Ezt - és csak ezt! - szabad/kell használni a lekérdezésekben, ahol adatörre kell szűkíteni!
//     * Az értéke függ a main és a selectedtől, de be is lehet állítani direktbe.
//     * A funkciók előtt kell beállítani vagy törölni.
//     * Értéke lehet null!
//     * Ha null, akkor a selected orgot adja vissza, ha az is null, akkor main org-ot.
//     */
//    private Organization dataSetOrganization;
//    /**
//     * List of organizations.
//     * Az összes szervezet, amelyhez a felhasználónak joga van.
//     */
//    private List<Organization> organizations;
//
//    /**
//     * A bejelentkezett felhasználó fő (vagy kiválasztott) szervezetének a
//     * szülőjének materpath-át adja vissza. Ha nincs bejelentkeze, akkor null.
//     *
//     * @return Mather path vagy null.
//     */
//    public String getMaterPathForParentByUser() {
//        String retVal = null;
//        if (getLoggedinUser() != null && getDataSetOrganization() != null) {
//            retVal = getDataSetOrganization().getMaterPathForParent();
//        }
//        return retVal;
//    }
//
//    /**
//     * Client (source - web browser data) information string. Uses in audit log
//     * source field.
//     */
//    private String clientSource;
//    /**
//     * User locale value.
//     */
//    private Locale locale;
//
//    public UserDataBean() {
//    }
//
//    /**
//     * Logout. All values set to default.
//     */
//    @PostConstruct
//    public void logout() {
//        this.functions = new ArrayList<Function>();
//        this.loginStatus = LOGINSTATES.LOGGEDOUT;
//        this.loggedInUser = null;
//        this.substitutedUser = null;
//        this.clientSource = "";
//        this.organizations = new ArrayList<Organization>();
//    }
//
//    /**
//     * Is user authenticated and logged in?
//     *
//     * @return true, if loggen in.
//     */
//    public Boolean isLoggedIn() {
//        return (this.loginStatus != null && LOGINSTATES.LOGGEDIN.equals(this.loginStatus));
//    }
//
//    /**
//     * Login status value.
//     *
//     * @return a LOGINSTATES enum value.
//     */
//    public LOGINSTATES getLoginStatus() {
//        return this.loginStatus;
//    }
//
//    /**
//     * Get user's permissions (Function).
//     *
//     * @return Function collection.
//     */
//    public List<Function> getFunctions() {
//        return functions;
//    }
//
//    /**
//     * Login status setter.
//     *
//     * @param state LOGINSTATES
//     */
//    public void setLoginStatus(LOGINSTATES state) {
//        this.loginStatus = state;
//    }
//
//    /**
//     * Get logged in user.
//     *
//     * @return Logged in User instance.
//     */
//    public User getLoggedinUser() {
//        return this.loggedInUser;
//    }
//
//    /**
//     * Get current user.
//     *
//     * @return If substituted user is null, return logged in user. Otherwise
//     * substituted user.
//     */
//    public User getUser() {
//        return (this.substitutedUser == null) ? this.loggedInUser : this.substitutedUser;
//    }
//
//    /**
//     * Set user's permissions (Function).
//     *
//     * @param functions Function collections.
//     */
//    public void setFunctions(List<Function> functions) {
//        this.functions = functions;
//    }
//
//    /**
//     * Client (source - web browser data) information string. Uses in audit log
//     * source field.
//     *
//     * @return Client information string.
//     */
//    public String getClientSource() {
//        return clientSource;
//    }
//
//    /**
//     * Set autehticated users. If logged in user equals the substituted user,
//     * the substituted user fields sets to null.
//     *
//     * @param loggedInUser    Logged in user.
//     * @param substitutedUser Substituted user or null.
//     */
//    public void setUser(User loggedInUser, User substitutedUser) {
//        this.loggedInUser = loggedInUser;
//        this.substitutedUser = substitutedUser;
//        if (substitutedUser != null && loggedInUser.getId().equals(substitutedUser.getId())) {
//            this.substitutedUser = null;
//        }
//        //getOrganizations(); //Tomee
//        //setMainOrganization(); //Tomee
//    }
//
//    /**
//     * Client (source - web browser data) information string. Uses in audit log
//     * source field.
//     *
//     * @param clientSource Client information string.
//     */
//    public void setClientSource(String clientSource) {
//        this.clientSource = clientSource;
//    }
//
//    /**
//     * Get user locale value. The default value is hu/Hu.
//     *
//     * @return Locale.
//     */
//    public Locale getLocale() {
//        if (locale == null) {
//            this.locale = new Locale("hu", "HU");
//        }
//        return locale;
//    }
//
//    /**
//     * Set user locale.
//     * <b>It sets global JVM default locale value too!</b>
//     *
//     * @param locale Locale instace.
//     */
//    public void setLocale(Locale locale) {
//        this.locale = locale;
//    }
//
//    /**
//     * User's orgranizations.
//     * <p>
//     * amennyiben van olyan kapcsolata a personnak, amiben PARENT-ként szerepel (tehát personsorganisations
//     * entity-ben relatedPerson) akkor a kapcsolat másik szereplőjének az org-jait (unique módon)
//     * hozzáadjuk a listához
//     *
//     * @return Organization list.
//     */
//    public List<Organization> getOrganizations() {
//        if (this.organizations == null) {
//            this.organizations = new ArrayList<Organization>();
//        }
//        if (isLoggedIn() && this.organizations.isEmpty() && getUser().getPersonsId() != null) {
//            List<PersonOrganization> pos = getUser().getPersonsId().getPersonsOrganizationsList().stream()
//                    .filter(e -> DateUtility.isValidDate(e.getValidTo()))
//                    .collect(Collectors.toList());
//            pos.stream().forEach((po) -> {
//                this.organizations.add(po.getOrganizationsId());
//            });
//        }
//
//        return organizations;
//    }
//
//    /**
//     * Mely organizations-ökhöz van kapcsolata.
//     *
//     * @param organizations
//     */
//    public void setOrganizations(List<Organization> organizations) {
//        this.organizations = organizations;
//    }
//
//    /**
//     * A felhasználó az ADMIN-e.
//     *
//     * @return
//     */
//    public Boolean isUserAdmin() {
//        return (getUser() != null && getUser().getId().equals(new Long(1)));
//    }
//
//    /**
//     * A felhasználónak több orgja van-e? Ha igen, ez a megjelenítésekben
//     * játszhat szerepet. Megjelenik az ORG oszlop.
//     *
//     * @return
//     * @since 2017.09.14 - bt lehetséges nullpointerexception javítása
//     */
//    public Boolean isUserMultiorgUser() {
//        return isUserGod() || getOrganizations().size() > 1;
//    }
//
//    /**
//     * A felhasználó technikai felhasználó-e?
//     * <p>
//     * - Nem tartozik hozzá Person
//     *
//     * @return
//     */
//    public Boolean isUserTechnical() {
//        return getUser() == null || getUser().getPersonsId() == null;
//    }
//
//    /**
//     * User's orgranization ids.
//     *
//     * @return Organization ids list.
//     * @since 2017.09.14 - bt refaktor
//     */
//    public List<Long> getOrganizationIds() {
//        List<Long> organizationIds = new ArrayList<Long>();
//        if (this.organizations == null || this.organizations.isEmpty()) {
//            getOrganizations();
//        }
//
//        return organizations.stream().map(Organization::getId).collect(Collectors.toList());
//    }
//
//    /**
//     * Felhasználó alapértelmezett vállalata. Ha helyettesít, akkor a
//     * helyettesített felhasználó alapértelmezett vállalata.
//     *
//     * @return Organization.
//     */
//    public Organization getOrganization() {
//        return getUser() == null ? null : mainOrganization;
//    }
//
//    /**
//     * Get user's localized message/text by code. It uses the user's
//     * <code>locale</code> value.
//     *
//     * @param strCode String code (in the properties file).
//     * @return The localized string/text value.
//     */
//    public String getText(String strCode) {
//        return Utility.getI18nMessages(strCode, getLocale());
//    }
//
//    /**
//     * Van-e joga.
//     *
//     * @param functionCode Funkció kód, ami nem lehet üres.
//     * @return Ha van joga, akkor true, egyéb esetben false.
//     */
//    public Boolean hasPermission(String functionCode) {
//        if (functionCode == null || functionCode.trim().isEmpty()) {
//            return false;
//        }
//        for (int i = 0; i < getFunctions().size(); i++) {
//            if (functionCode.trim().toLowerCase().equals(getFunctions().get(i).getCode().trim().toLowerCase())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Organization getMainOrganization() {
//        return this.mainOrganization;
//    }
//
//    public void setMainOrganization(Organization mainOrganization) {
//        this.mainOrganization = mainOrganization;
//    }
//
//    /**
//     * A bejelentkezett felhasználó fő (vagy kiválasztott) szervezetének a
//     * materpath-át adja vissza. Ha nincs bejelentkeze, akkor null.
//     *
//     * @return Mather path vagy null.
//     */
//    public String getMaterPathByUser() {
//        String retVal = null;
//        if (getLoggedinUser() != null && getDataSetOrganization() != null) {
//            retVal = getDataSetOrganization().getMaterPath();
//        }
//        return retVal;
//    }
//
//    /**
//     * A selectekben az adatkörre szűkítésére vonatkozó szervezet.
//     * Ezt - és csak ezt! - szabad/kell használni a lekérdezésekben, ahol adatörre kell szűkíteni!
//     * Az értéke függ a main és a selectedtől, de be is lehet állítani direktbe.
//     * A funkciók előtt kell beállítani vagy törölni.
//     * Értéke lehet null!
//     * Ha null, akkor a selected orgot adja vissza, ha az is null, akkor a main org-ot.
//     *
//     * @return A query-kben használandó <code>Organization</code> objektum.
//     */
//    public Organization getDataSetOrganization() {
//        if (dataSetOrganization != null) {
//            return dataSetOrganization;
//        }
//        if (selectedOrganization != null) {
//            return selectedOrganization;
//        }
//        return mainOrganization;
//    }
//
//    /**
//     * A selectekben az adatkörre szűkítésére vonatkozó szervezet beállítása.
//     *
//     * @param organization A query-kben használandó <code>Organization</code> objektum. Lehet null.
//     */
//    public void setDataSetOrganization(Organization organization) {
//        this.dataSetOrganization = organization;
//    }
//
//    public Organization getSelectedOrganization() {
//        if (selectedOrganization == null) {
//            return mainOrganization;
//        }
//        return selectedOrganization;
//    }
//
//    public void setSelectedOrganization(Organization selectedOrganization) {
//        this.selectedOrganization = selectedOrganization;
//    }

    /**
     * Login statuses.
     */
    public enum LOGINSTATES {
        LOGGEDOUT, AUTHENTICATED, PRIVACY_NOT_ACCEPTED, LOGGEDIN, SELECTSUBSTITUTION, NOMAINORGANIZATION
    }
}
