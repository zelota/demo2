/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.generated;

import com.ash.commonlibrary.fw.models.abstracts.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 11. 03.
 */
@Entity
@Table(name = "users_roles")
public class UserRole extends AbstractBaseEntity implements Serializable {
    private Long id;

    private String description;

    private Roles rolesByRolesId;
    private Users usersByUsersId;

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
    @Column(name = "description", nullable = true, length = 4000)
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        com.ash.commonlibrary.fw.models.generated.UserRole that = (com.ash.commonlibrary.fw.models.generated.UserRole) o;

        if ( id != null ? !id.equals(that.id) : that.id != null ) return false;

        if ( description != null ? !description.equals(that.description) : that.description != null ) return false;
        if ( created != null ? !created.equals(that.created) : that.created != null ) return false;
        if ( creatorId != null ? !creatorId.equals(that.creatorId) : that.creatorId != null ) return false;
        if ( modified != null ? !modified.equals(that.modified) : that.modified != null ) return false;
        if ( modifierId != null ? !modifierId.equals(that.modifierId) : that.modifierId != null ) return false;
        if ( validTo != null ? !validTo.equals(that.validTo) : that.validTo != null ) return false;
        if ( version != null ? !version.equals(that.version) : that.version != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

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
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    public Roles getRolesByRolesId() {
        return rolesByRolesId;
    }

    public void setRolesByRolesId( Roles rolesByRolesId ) {
        this.rolesByRolesId = rolesByRolesId;
    }

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    public Users getUsersByUsersId() {
        return usersByUsersId;
    }

    public void setUsersByUsersId( Users usersByUsersId ) {
        this.usersByUsersId = usersByUsersId;
    }
}
