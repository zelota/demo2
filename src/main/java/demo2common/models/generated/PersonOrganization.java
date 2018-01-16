/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.generated;

import demo2common.models.abstracts.AbstractPersonOrganization;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 11. 03.
 */
@Entity
@Table(name = "persons_organizations")
public class PersonOrganization extends AbstractPersonOrganization implements Serializable {
    private Long id;

    private String mainOrganization;
    private String headOfOrg;
    private String description;

    private Organization organizationByOrganizationId;
    private Person personByPersonId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Basic
    @Column(name = "main_organization", nullable = true, length = -1)
    public String getMainOrganization() {
        return mainOrganization;
    }

    public void setMainOrganization( String mainOrganization ) {
        this.mainOrganization = mainOrganization;
    }

    @Basic
    @Column(name = "head_of_org", nullable = true, length = -1)
    public String getHeadOfOrg() {
        return headOfOrg;
    }

    public void setHeadOfOrg( String headOfOrg ) {
        this.headOfOrg = headOfOrg;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 4000)
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;

        demo2common.models.generated.PersonOrganization that = (demo2common.models.generated.PersonOrganization) o;

        if ( id != null ? !id.equals(that.id) : that.id != null )
            return false;

        if ( mainOrganization != null ? !mainOrganization.equals(that.mainOrganization) : that.mainOrganization != null )
            return false;
        if ( headOfOrg != null ? !headOfOrg.equals(that.headOfOrg) : that.headOfOrg != null )
            return false;
        if ( description != null ? !description.equals(that.description) : that.description != null )
            return false;
        if ( created != null ? !created.equals(that.created) : that.created != null )
            return false;
        if ( creatorId != null ? !creatorId.equals(that.creatorId) : that.creatorId != null )
            return false;
        if ( modified != null ? !modified.equals(that.modified) : that.modified != null )
            return false;
        if ( modifierId != null ? !modifierId.equals(that.modifierId) : that.modifierId != null )
            return false;
        if ( validTo != null ? !validTo.equals(that.validTo) : that.validTo != null )
            return false;
        if ( version != null ? !version.equals(that.version) : that.version != null )
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

        result = 31 * result + (mainOrganization != null ? mainOrganization.hashCode() : 0);
        result = 31 * result + (headOfOrg != null ? headOfOrg.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (modifierId != null ? modifierId.hashCode() : 0);
        result = 31 * result + (validTo != null ? validTo.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "organizations_id", referencedColumnName = "id")
    public Organization getOrganizationByOrganizationId() {
        return organizationByOrganizationId;
    }

    public void setOrganizationByOrganizationId( Organization organizationByOrganizationId ) {
        this.organizationByOrganizationId = organizationByOrganizationId;
    }

    @ManyToOne
    @JoinColumn(name = "persons_id", referencedColumnName = "id")
    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId( Person personByPersonId ) {
        this.personByPersonId = personByPersonId;
    }

}
