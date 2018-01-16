/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.generated;

import demo2common.models.abstracts.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 11. 03.
 */
@Entity
public class Person extends AbstractBaseEntity implements Serializable {
    private Long id;
    private String name;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String mothersName;
    private LocalDateTime birthDate;
    private String birthPlace;
    private String gender;
    private byte[] photo;
    private String contentType;
    private String fileName;
    private String isDeceased;
    private String isExternal;
    private String sendNotifyEmail;
    private String uniqueCode;
    private String description;

    private List<PersonOrganization> personOrganizationById;
    private List<User> userById;

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
    @Column(name = "first_name", nullable = true, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "middle_name", nullable = true, length = 100)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName( String middleName ) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "full_name", nullable = true, length = 4000)
    public String getFullName() {
        return fullName;
    }

    public void setFullName( String fullName ) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "mothers_name", nullable = true, length = 100)
    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName( String mothersName ) {
        this.mothersName = mothersName;
    }

    @Basic
    @Column(name = "birth_date", nullable = true)
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate( LocalDateTime birthDate ) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "birth_place", nullable = true, length = 100)
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace( String birthPlace ) {
        this.birthPlace = birthPlace;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 50)
    public String getGender() {
        return gender;
    }

    public void setGender( String gender ) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto( byte[] photo ) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "content_type", nullable = true, length = 255)
    public String getContentType() {
        return contentType;
    }

    public void setContentType( String contentType ) {
        this.contentType = contentType;
    }

    @Basic
    @Column(name = "file_name", nullable = true, length = 255)
    public String getFileName() {
        return fileName;
    }

    public void setFileName( String fileName ) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "is_deceased", nullable = true, length = -1)
    public String getIsDeceased() {
        return isDeceased;
    }

    public void setIsDeceased( String isDeceased ) {
        this.isDeceased = isDeceased;
    }

    @Basic
    @Column(name = "is_external", nullable = true, length = -1)
    public String getIsExternal() {
        return isExternal;
    }

    public void setIsExternal( String isExternal ) {
        this.isExternal = isExternal;
    }

    @Basic
    @Column(name = "send_notify_email", nullable = true, length = -1)
    public String getSendNotifyEmail() {
        return sendNotifyEmail;
    }

    public void setSendNotifyEmail( String sendNotifyEmail ) {
        this.sendNotifyEmail = sendNotifyEmail;
    }

    @Basic
    @Column(name = "unique_code", nullable = true, length = 100)
    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode( String uniqueCode ) {
        this.uniqueCode = uniqueCode;
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

        demo2common.models.generated.Person person = (demo2common.models.generated.Person) o;

        if ( id != null ? !id.equals(person.id) : person.id != null )
            return false;
        if ( name != null ? !name.equals(person.name) : person.name != null )
            return false;
        if ( firstName != null ? !firstName.equals(person.firstName) : person.firstName != null )
            return false;
        if ( middleName != null ? !middleName.equals(person.middleName) : person.middleName != null )
            return false;
        if ( lastName != null ? !lastName.equals(person.lastName) : person.lastName != null )
            return false;
        if ( fullName != null ? !fullName.equals(person.fullName) : person.fullName != null )
            return false;
        if ( mothersName != null ? !mothersName.equals(person.mothersName) : person.mothersName != null )
            return false;
        if ( birthDate != null ? !birthDate.equals(person.birthDate) : person.birthDate != null )
            return false;
        if ( birthPlace != null ? !birthPlace.equals(person.birthPlace) : person.birthPlace != null )
            return false;
        if ( gender != null ? !gender.equals(person.gender) : person.gender != null )
            return false;
        if ( !Arrays.equals(photo, person.photo) )
            return false;
        if ( contentType != null ? !contentType.equals(person.contentType) : person.contentType != null )
            return false;
        if ( fileName != null ? !fileName.equals(person.fileName) : person.fileName != null )
            return false;
        if ( isDeceased != null ? !isDeceased.equals(person.isDeceased) : person.isDeceased != null )
            return false;
        if ( isExternal != null ? !isExternal.equals(person.isExternal) : person.isExternal != null )
            return false;
        if ( sendNotifyEmail != null ? !sendNotifyEmail.equals(person.sendNotifyEmail) : person.sendNotifyEmail != null )
            return false;
        if ( uniqueCode != null ? !uniqueCode.equals(person.uniqueCode) : person.uniqueCode != null )
            return false;
        if ( description != null ? !description.equals(person.description) : person.description != null )
            return false;
        if ( created != null ? !created.equals(person.created) : person.created != null )
            return false;
        if ( creatorId != null ? !creatorId.equals(person.creatorId) : person.creatorId != null )
            return false;
        if ( modified != null ? !modified.equals(person.modified) : person.modified != null )
            return false;
        if ( modifierId != null ? !modifierId.equals(person.modifierId) : person.modifierId != null )
            return false;
        if ( validTo != null ? !validTo.equals(person.validTo) : person.validTo != null )
            return false;
        if ( version != null ? !version.equals(person.version) : person.version != null )
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (mothersName != null ? mothersName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (birthPlace != null ? birthPlace.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (isDeceased != null ? isDeceased.hashCode() : 0);
        result = 31 * result + (isExternal != null ? isExternal.hashCode() : 0);
        result = 31 * result + (sendNotifyEmail != null ? sendNotifyEmail.hashCode() : 0);
        result = 31 * result + (uniqueCode != null ? uniqueCode.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (modifierId != null ? modifierId.hashCode() : 0);
        result = 31 * result + (validTo != null ? validTo.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public List<PersonOrganization> getPersonOrganizationById() {
        return personOrganizationById;
    }

    public void setPersonOrganizationById( List<PersonOrganization> personOrganizationById ) {
        this.personOrganizationById = personOrganizationById;
    }

    @OneToMany(mappedBy = "userById")
    public List<User> getUserById() {
        return userById;
    }

    public void setUserById( List<User> userById ) {
        this.userById = userById;
    }
}
