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
public class Function extends AbstractBaseEntity implements Serializable {
    private Long id;

    private String code;
    private String name;
    private String description;

    private demo2common.models.generated.Function functionByParentId;
    private List<demo2common.models.generated.Function> functionById;
    private List<Menu> menuById;
    private List<RoleFunction> roleFunctionById;

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

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;

        demo2common.models.generated.Function function = (demo2common.models.generated.Function) o;

        if ( id != null ? !id.equals(function.id) : function.id != null )
            return false;

        if ( code != null ? !code.equals(function.code) : function.code != null )
            return false;
        if ( name != null ? !name.equals(function.name) : function.name != null )
            return false;
        if ( description != null ? !description.equals(function.description) : function.description != null )
            return false;
        if ( created != null ? !created.equals(function.created) : function.created != null )
            return false;
        if ( creatorId != null ? !creatorId.equals(function.creatorId) : function.creatorId != null )
            return false;
        if ( modified != null ? !modified.equals(function.modified) : function.modified != null )
            return false;
        if ( modifierId != null ? !modifierId.equals(function.modifierId) : function.modifierId != null )
            return false;
        if ( validTo != null ? !validTo.equals(function.validTo) : function.validTo != null )
            return false;
        if ( version != null ? !version.equals(function.version) : function.version != null )
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
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
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public demo2common.models.generated.Function getFunctionByParentId() {
        return functionByParentId;
    }

    public void setFunctionByParentId( demo2common.models.generated.Function functionByParentId ) {
        this.functionByParentId = functionByParentId;
    }

    @OneToMany(mappedBy = "functionByParentId")
    public List<demo2common.models.generated.Function> getFunctionById() {
        return functionById;
    }

    public void setFunctionById( List<demo2common.models.generated.Function> functionById ) {
        this.functionById = functionById;
    }

    @OneToMany(mappedBy = "functionsByFunctionsId")
    public List<Menu> getMenuById() {
        return menuById;
    }

    public void setMenuById( List<Menu> menuById ) {
        this.menuById = menuById;
    }

    @OneToMany(mappedBy = "functionsByFunctionsId")
    public List<RoleFunction> getRoleFunctionById() {
        return roleFunctionById;
    }

    public void setRoleFunctionById( List<RoleFunction> roleFunctionById ) {
        this.roleFunctionById = roleFunctionById;
    }

}
