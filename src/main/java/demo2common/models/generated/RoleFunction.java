/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.generated;

import demo2common.models.abstracts.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 11. 03.
 */
@Entity
@Table(name = "roles_functions")
public class RoleFunction extends AbstractBaseEntity implements Serializable {
    private Long id;

    private Function functionByFunctionId;
    private Role roleByRoleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;

        demo2common.models.generated.RoleFunction that = (demo2common.models.generated.RoleFunction) o;

        if ( id != null ? !id.equals(that.id) : that.id != null )
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

        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (modifierId != null ? modifierId.hashCode() : 0);
        result = 31 * result + (validTo != null ? validTo.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "functions_id", referencedColumnName = "id")
    public Function getFunctionByFunctionId() {
        return functionByFunctionId;
    }

    public void setFunctionByFunctionId( Function functionByFunctionId ) {
        this.functionByFunctionId = functionByFunctionId;
    }

    @ManyToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId( Role roleByRoleId ) {
        this.roleByRoleId = roleByRoleId;
    }
}
