/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.generated;

import demo2common.models.abstracts.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 11. 03.
 */
@Entity
@Table(name = "organization_types")
public class OrganizationType extends AbstractBaseEntity implements Serializable {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String fixedCode;

    private List<Organization> organizationById;

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
    @Column(name = "code", nullable = true, length = 100)
    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 4000)
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @Basic
    @Column(name = "fixed_code", nullable = true, length = -1)
    public String getFixedCode() {
        return fixedCode;
    }

    public void setFixedCode( String fixedCode ) {
        this.fixedCode = fixedCode;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;

        demo2common.models.generated.OrganizationType that = (demo2common.models.generated.OrganizationType) o;

        if ( id != null ? !id.equals(that.id) : that.id != null )
            return false;
        if ( code != null ? !code.equals(that.code) : that.code != null )
            return false;
        if ( name != null ? !name.equals(that.name) : that.name != null )
            return false;
        if ( description != null ? !description.equals(that.description) : that.description != null )
            return false;
        if ( fixedCode != null ? !fixedCode.equals(that.fixedCode) : that.fixedCode != null )
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
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (fixedCode != null ? fixedCode.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (modifierId != null ? modifierId.hashCode() : 0);
        result = 31 * result + (validTo != null ? validTo.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "organizationTypeByOrganizationTypeId")
    public List<Organization> getOrganizationById() {
        return organizationById;
    }

    public void setOrganizationsById( List<Organization> organizationById ) {
        this.organizationById = organizationById;
    }
}
