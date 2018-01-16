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
public class Role extends AbstractBaseEntity implements Serializable {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String fixedCode;

    private List<RoleFunction> roleFunctionById;
    private List<UserRole> userRoleById;

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
    @Column(name = "name", nullable = true, length = 100)
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

        demo2common.models.generated.Role role = (demo2common.models.generated.Role) o;

        if ( id != null ? !id.equals(role.id) : role.id != null )
            return false;
        if ( code != null ? !code.equals(role.code) : role.code != null )
            return false;
        if ( name != null ? !name.equals(role.name) : role.name != null )
            return false;
        if ( description != null ? !description.equals(role.description) : role.description != null )
            return false;
        if ( fixedCode != null ? !fixedCode.equals(role.fixedCode) : role.fixedCode != null )
            return false;
        if ( created != null ? !created.equals(role.created) : role.created != null )
            return false;
        if ( creatorId != null ? !creatorId.equals(role.creatorId) : role.creatorId != null )
            return false;
        if ( modified != null ? !modified.equals(role.modified) : role.modified != null )
            return false;
        if ( modifierId != null ? !modifierId.equals(role.modifierId) : role.modifierId != null )
            return false;
        if ( validTo != null ? !validTo.equals(role.validTo) : role.validTo != null )
            return false;
        if ( version != null ? !version.equals(role.version) : role.version != null )
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

    @OneToMany(mappedBy = "roleByRoleId")
    public List<RoleFunction> getRoleFunctionById() {
        return roleFunctionById;
    }

    public void setRoleFunctionById( List<RoleFunction> roleFunctionById ) {
        this.roleFunctionById = roleFunctionById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public List<UserRole> getUserRoleById() {
        return userRoleById;
    }

    public void setUserRoleById( List<UserRole> userRoleById ) {
        this.userRoleById = userRoleById;
    }
}
