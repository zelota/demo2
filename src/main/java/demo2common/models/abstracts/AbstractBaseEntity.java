package demo2common.models.abstracts;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@XmlRootElement
public abstract class AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 20170115211934534L;

    protected LocalDateTime created;
    protected Long creatorId;
    protected LocalDateTime modified;
    protected Long modifierId;
    protected LocalDateTime validTo;
    protected Long version;

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(Long id, LocalDateTime created, Long creatorId, LocalDateTime validto) {
        this.setCreated(created);
        this.setCreatorId(creatorId);
        this.setValidTo(validto);
    }

    @Basic
    @Column(name = "created", nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Basic
    @Column(name = "creator_id", nullable = true, precision = 0)
    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    @Basic
    @Column(name = "modified", nullable = true)
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Basic
    @Column(name = "modifier_id", nullable = true, precision = 0)
    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    @Basic
    @Column(name = "valid_to", nullable = false)
    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }

    @Basic
    @Column(name = "version", nullable = true, precision = 0)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    /**
     * Beállítja a kötelező mezőket. Új létrehozásakor használatos, insert
     * előtt.
     * <p>
     * Beállítja:<ul>
     * <li>A <code>created</code> értékét a mostra.</li>
     * <li>A <code>creatorId</code> értékét 1-re. <b>Ezt át kell írni!</b></li>
     * <li>A <code>validTo</code> értékét a validTo-ként megadott dátumra.</li>
     * <li>A <code>version</code> értékét 0-ra.</li>
     * </ul>
     */
    public void setMandatoryFieldsDefault() {
        this.setCreated(LocalDateTime.now());
        this.setCreatorId(1L);
        //this.setValidTo(DateUtility.getValidToDate());   //CSAK FORDÍTÁS MIATT kommentben, vissza kell rakni!!!!!!!!!!!!!
        this.setVersion(1L);
    }

    /**
     * Beállítja a kötelező mezőket új esetén. Új létrehozásakor használatos,
     * insert előtt. Hívja a <code>setMandatoryFieldsDefault</code> metódust.
     * <p>
     * Beállítja:<ul>
     * <li>A <code>created</code> értékét a mostra.</li>
     * <li>A <code>creatorId</code> a paraméterként megadott értékre.</li>
     * <li>A <code>validTo</code> értékét a validTo-ként megadott dátumra.</li>
     * <li>A <code>version</code> értékét 0-ra.</li>
     * </ul>
     *
     * @param creatorId A creator user id-je. Nem lehet null!
     */
    public void setMandatoryFieldsForNew(Long creatorId) {
        if (creatorId == null) {
            throw new IllegalArgumentException("The parameter is null!");
        }
        this.setMandatoryFieldsDefault();
        this.setCreatorId(creatorId);
    }

    /**
     * Beállítja a kötelező mezőket módosítás esetén.
     * <p>
     * Beállítja:<ul>
     * <li>A <code>modified</code> értékét a mostra.</li>
     * <li>A <code>modifierId</code> a paraméterként megadott értékre.</li>
     * </ul>
     *
     * @param modifierId A módosító felhasználó id-je. Nem lehet null!
     */
    public void setMandatoryFieldsForModify(Long modifierId) {
        if (modifierId == null) {
            throw new IllegalArgumentException("The parameter is null!");
        }
        this.setModifierId(modifierId);
        this.setModified(LocalDateTime.now());
    }

    /**
     * Beállítja a kötelező mezőket törlés esetén. Hívja a
     * <code>setMandatoryFieldsForModify</code> metódust.
     * <p>
     * Beállítja:<ul>
     * <li>A <code>modified</code> értékét a mostra.</li>
     * <li>A <code>validTo</code> értékét a mostra.</li>
     * <li>A <code>modifierId</code> a paraméterként megadott értékre.</li>
     * </ul>
     *
     * @param modifierId A módosító felhasználó id-je. Nem lehet null!
     */
    public void setMandatoryFieldsForDelete(Long modifierId) {
        setMandatoryFieldsForModify(modifierId);
        this.setValidTo(LocalDateTime.now());
    }

    /**
     * Az össza audit mező törlése.
     */
    public void clearAllAuditFields() {
        setCreated(null);
        setCreatorId(null);
        setModified(null);
        setModifierId(null);
        setValidTo(null);
        setVersion(null);
    }

}
