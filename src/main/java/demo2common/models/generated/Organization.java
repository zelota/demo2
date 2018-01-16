/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.models.generated;

import demo2common.models.abstracts.AbstractOrganization;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author Baranyi Tamás <tamas.baranyi@ashszoftverhaz.hu>
 * @since 2017. 11. 03.
 */
@Entity
public class Organization extends AbstractOrganization implements Serializable {
    private Long id;

    private String code;
    private String fixedCode;
    private String name;
    private String taxNumber;
    private String companyRegNumber;
    private String registrationsPlace;
    private String accountNumber;
    private String materPath;
    private String isExternal;
    private String isMember;
    private byte[] orgPhoto;
    private String contentType;
    private String fileName;
    private String description;

    private demo2common.models.generated.Organization organizationByParentId;
    private List<demo2common.models.generated.Organization> organizationById;
    private OrganizationType organizationTypeByOrganizationTypeId;

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
    @Column(name = "fixed_code", nullable = true, length = -1)
    public String getFixedCode() {
        return fixedCode;
    }

    public void setFixedCode( String fixedCode ) {
        this.fixedCode = fixedCode;
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
    @Column(name = "tax_number", nullable = true, length = 100)
    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber( String taxNumber ) {
        this.taxNumber = taxNumber;
    }

    @Basic
    @Column(name = "company_reg_number", nullable = true, length = 100)
    public String getCompanyRegNumber() {
        return companyRegNumber;
    }

    public void setCompanyRegNumber( String companyRegNumber ) {
        this.companyRegNumber = companyRegNumber;
    }

    @Basic
    @Column(name = "registrations_place", nullable = true, length = 100)
    public String getRegistrationsPlace() {
        return registrationsPlace;
    }

    public void setRegistrationsPlace( String registrationsPlace ) {
        this.registrationsPlace = registrationsPlace;
    }

    @Basic
    @Column(name = "account_number", nullable = true, length = 100)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber( String accountNumber ) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "mater_path", nullable = true, length = 100)
    public String getMaterPath() {
        return materPath;
    }

    public void setMaterPath( String materPath ) {
        this.materPath = materPath;
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
    @Column(name = "is_member", nullable = true, length = 100)
    public String getIsMember() {
        return isMember;
    }

    public void setIsMember( String isMember ) {
        this.isMember = isMember;
    }

    @Basic
    @Column(name = "org_photo", nullable = true)
    public byte[] getOrgPhoto() {
        return orgPhoto;
    }

    public void setOrgPhoto( byte[] orgPhoto ) {
        this.orgPhoto = orgPhoto;
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

        demo2common.models.generated.Organization that = (demo2common.models.generated.Organization) o;

        if ( id != null ? !id.equals(that.id) : that.id != null )
            return false;

        if ( code != null ? !code.equals(that.code) : that.code != null )
            return false;
        if ( fixedCode != null ? !fixedCode.equals(that.fixedCode) : that.fixedCode != null )
            return false;
        if ( name != null ? !name.equals(that.name) : that.name != null )
            return false;
        if ( taxNumber != null ? !taxNumber.equals(that.taxNumber) : that.taxNumber != null )
            return false;
        if ( companyRegNumber != null ? !companyRegNumber.equals(that.companyRegNumber) : that.companyRegNumber != null )
            return false;
        if ( registrationsPlace != null ? !registrationsPlace.equals(that.registrationsPlace) : that.registrationsPlace != null )
            return false;
        if ( accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null )
            return false;
        if ( materPath != null ? !materPath.equals(that.materPath) : that.materPath != null )
            return false;
        if ( isExternal != null ? !isExternal.equals(that.isExternal) : that.isExternal != null )
            return false;
        if ( isMember != null ? !isMember.equals(that.isMember) : that.isMember != null )
            return false;
        if ( !Arrays.equals(orgPhoto, that.orgPhoto) )
            return false;
        if ( contentType != null ? !contentType.equals(that.contentType) : that.contentType != null )
            return false;
        if ( fileName != null ? !fileName.equals(that.fileName) : that.fileName != null )
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

        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (fixedCode != null ? fixedCode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (taxNumber != null ? taxNumber.hashCode() : 0);
        result = 31 * result + (companyRegNumber != null ? companyRegNumber.hashCode() : 0);
        result = 31 * result + (registrationsPlace != null ? registrationsPlace.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (materPath != null ? materPath.hashCode() : 0);
        result = 31 * result + (isExternal != null ? isExternal.hashCode() : 0);
        result = 31 * result + (isMember != null ? isMember.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(orgPhoto);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
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
    public demo2common.models.generated.Organization getOrganizationByParentId() {
        return organizationByParentId;
    }

    public void setOrganizationByParentId( demo2common.models.generated.Organization organizationByParentId ) {
        this.organizationByParentId = organizationByParentId;
    }

    @OneToMany(mappedBy = "organizationByParentId")
    public List<demo2common.models.generated.Organization> getOrganizationById() {
        return organizationById;
    }

    public void setOrganizationById( List<demo2common.models.generated.Organization> organizationById ) {
        this.organizationById = organizationById;
    }

    @ManyToOne
    @JoinColumn(name = "organization_types_id", referencedColumnName = "id")
    public OrganizationType getOrganizationTypeByOrganizationTypeId() {
        return organizationTypeByOrganizationTypeId;
    }

    public void setOrganizationByParentId( OrganizationType organizationTypeByOrganizationTypeId ) {
        this.organizationTypeByOrganizationTypeId = organizationTypeByOrganizationTypeId;
    }
}
