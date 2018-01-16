/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.generated;

import demo2common.models.abstracts.AbstractBaseEntity;
import sun.security.pkcs11.wrapper.Functions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 11. 03.
 */
@Entity
public class Menu extends AbstractBaseEntity implements Serializable {
    private Long id;

    private String name;
    private String code;
    private String viewName;
    private String iconName;
    private Long orderNum;
    private String isActive;
    private String descriptionCode;

    private demo2common.models.generated.Menu menuByParentId;
    private List<demo2common.models.generated.Menu> menuById;
    private Functions functionsByFunctionsId;

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
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
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
    @Column(name = "view_name", nullable = true, length = 100)
    public String getViewName() {
        return viewName;
    }

    public void setViewName( String viewName ) {
        this.viewName = viewName;
    }

    @Basic
    @Column(name = "icon_name", nullable = true, length = 100)
    public String getIconName() {
        return iconName;
    }

    public void setIconName( String iconName ) {
        this.iconName = iconName;
    }

    @Basic
    @Column(name = "order_num", nullable = true, precision = 0)
    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum( Long orderNum ) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "is_active", nullable = true, length = -1)
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive( String isActive ) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "description_code", nullable = true, length = 100)
    public String getDescriptionCode() {
        return descriptionCode;
    }

    public void setDescriptionCode( String descriptionCode ) {
        this.descriptionCode = descriptionCode;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;

        demo2common.models.generated.Menu menu = (demo2common.models.generated.Menu) o;

        if ( id != null ? !id.equals(menu.id) : menu.id != null )
            return false;

        if ( name != null ? !name.equals(menu.name) : menu.name != null )
            return false;
        if ( code != null ? !code.equals(menu.code) : menu.code != null )
            return false;
        if ( viewName != null ? !viewName.equals(menu.viewName) : menu.viewName != null )
            return false;
        if ( iconName != null ? !iconName.equals(menu.iconName) : menu.iconName != null )
            return false;
        if ( orderNum != null ? !orderNum.equals(menu.orderNum) : menu.orderNum != null )
            return false;
        if ( isActive != null ? !isActive.equals(menu.isActive) : menu.isActive != null )
            return false;
        if ( descriptionCode != null ? !descriptionCode.equals(menu.descriptionCode) : menu.descriptionCode != null )
            return false;
        if ( created != null ? !created.equals(menu.created) : menu.created != null )
            return false;
        if ( creatorId != null ? !creatorId.equals(menu.creatorId) : menu.creatorId != null )
            return false;
        if ( modified != null ? !modified.equals(menu.modified) : menu.modified != null )
            return false;
        if ( modifierId != null ? !modifierId.equals(menu.modifierId) : menu.modifierId != null )
            return false;
        if ( validTo != null ? !validTo.equals(menu.validTo) : menu.validTo != null )
            return false;
        if ( version != null ? !version.equals(menu.version) : menu.version != null )
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (viewName != null ? viewName.hashCode() : 0);
        result = 31 * result + (iconName != null ? iconName.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (descriptionCode != null ? descriptionCode.hashCode() : 0);
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
    public demo2common.models.generated.Menu getMenuByParentId() {
        return menuByParentId;
    }

    public void setMenuByParentId( demo2common.models.generated.Menu menuByParentId ) {
        this.menuByParentId = menuByParentId;
    }

    @OneToMany(mappedBy = "menuByParentId")
    public List<demo2common.models.generated.Menu> getMenuById() {
        return menuById;
    }

    public void setMenuById( List<demo2common.models.generated.Menu> menuById ) {
        this.menuById = menuById;
    }

    @ManyToOne
    @JoinColumn(name = "functions_id", referencedColumnName = "id")
    public Functions getFunctionsByFunctionsId() {
        return functionsByFunctionsId;
    }

    public void setFunctionsByFunctionsId( Functions functionsByFunctionsId ) {
        this.functionsByFunctionsId = functionsByFunctionsId;
    }
}
