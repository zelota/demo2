package demo2common.models.abstracts;

/**
 * @author Áy Dániel
 */
public abstract class AbstractPersonOrganization extends AbstractBaseEntity {

    private String uniqueIDForUI;

    public String getUniqueIDForUI() {
        return uniqueIDForUI;
    }

    public void setUniqueIDForUI( String uniqueIDForUI ) {
        this.uniqueIDForUI = uniqueIDForUI;
    }
}
