/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.generated;

import demo2common.models.abstracts.AbstractUser;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 11. 03.
 */
@Entity
public class User extends AbstractUser implements Serializable {
    private Long id;

    private String login;
    private String password;
    private LocalDateTime lastLogon;
    private String isActive;
    private String description;

    private Person personByPersonId;
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
    @Column(name = "login", nullable = true, length = 255)
    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    @Basic
    @Column(name = "last_logon", nullable = true)
    public LocalDateTime getLastLogon() {
        return lastLogon;
    }

    public void setLastLogon( LocalDateTime lastLogon ) {
        this.lastLogon = lastLogon;
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

        demo2common.models.generated.User user = (demo2common.models.generated.User) o;

        if ( id != null ? !id.equals(user.id) : user.id != null )
            return false;

        if ( login != null ? !login.equals(user.login) : user.login != null )
            return false;
        if ( password != null ? !password.equals(user.password) : user.password != null )
            return false;
        if ( lastLogon != null ? !lastLogon.equals(user.lastLogon) : user.lastLogon != null )
            return false;
        if ( isActive != null ? !isActive.equals(user.isActive) : user.isActive != null )
            return false;
        if ( description != null ? !description.equals(user.description) : user.description != null )
            return false;
        if ( created != null ? !created.equals(user.created) : user.created != null )
            return false;
        if ( creatorId != null ? !creatorId.equals(user.creatorId) : user.creatorId != null )
            return false;
        if ( modified != null ? !modified.equals(user.modified) : user.modified != null )
            return false;
        if ( modifierId != null ? !modifierId.equals(user.modifierId) : user.modifierId != null )
            return false;
        if ( validTo != null ? !validTo.equals(user.validTo) : user.validTo != null )
            return false;
        if ( version != null ? !version.equals(user.version) : user.version != null )
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastLogon != null ? lastLogon.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
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
    @JoinColumn(name = "persons_id", referencedColumnName = "id")
    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId( Person personByPersonId ) {
        this.personByPersonId = personByPersonId;
    }

    @OneToMany(mappedBy = "usersByUsersId")
    public List<UserRole> getUserRoleById() {
        return userRoleById;
    }

    public void setUserRoleById( List<UserRole> userRoleById ) {
        this.userRoleById = userRoleById;
    }
}
