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
public class Auditlog extends AbstractBaseEntity implements Serializable {
    private Long id;
    private Long functionsId;
    private Long organizationsId;
    private Long usersId;
    private String event;
    private String source;
    private String functionName;
    private String clientInfo;
    private String result;

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
    @Column(name = "functions_id", nullable = true, precision = 0)
    public Long getFunctionsId() {
        return functionsId;
    }

    public void setFunctionsId( Long functionsId ) {
        this.functionsId = functionsId;
    }

    @Basic
    @Column(name = "organizations_id", nullable = true, precision = 0)
    public Long getOrganizationsId() {
        return organizationsId;
    }

    public void setOrganizationsId( Long organizationsId ) {
        this.organizationsId = organizationsId;
    }

    @Basic
    @Column(name = "users_id", nullable = true, precision = 0)
    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId( Long usersId ) {
        this.usersId = usersId;
    }

    @Basic
    @Column(name = "event", nullable = true, length = 255)
    public String getEvent() {
        return event;
    }

    public void setEvent( String event ) {
        this.event = event;
    }

    @Basic
    @Column(name = "source", nullable = true, length = 100)
    public String getSource() {
        return source;
    }

    public void setSource( String source ) {
        this.source = source;
    }

    @Basic
    @Column(name = "function_name", nullable = true, length = 255)
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName( String functionName ) {
        this.functionName = functionName;
    }

    @Basic
    @Column(name = "client_info", nullable = true, length = 4000)
    public String getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo( String clientInfo ) {
        this.clientInfo = clientInfo;
    }

    @Basic
    @Column(name = "result", nullable = true, length = 255)
    public String getResult() {
        return result;
    }

    public void setResult( String result ) {
        this.result = result;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;

        demo2common.models.generated.Auditlog auditlog = (demo2common.models.generated.Auditlog) o;

        if ( id != null ? !id.equals(auditlog.id) : auditlog.id != null )
            return false;
        if ( functionsId != null ? !functionsId.equals(auditlog.functionsId) : auditlog.functionsId != null )
            return false;
        if ( organizationsId != null ? !organizationsId.equals(auditlog.organizationsId) : auditlog.organizationsId != null )
            return false;
        if ( usersId != null ? !usersId.equals(auditlog.usersId) : auditlog.usersId != null )
            return false;
        if ( event != null ? !event.equals(auditlog.event) : auditlog.event != null )
            return false;
        if ( source != null ? !source.equals(auditlog.source) : auditlog.source != null )
            return false;
        if ( functionName != null ? !functionName.equals(auditlog.functionName) : auditlog.functionName != null )
            return false;
        if ( clientInfo != null ? !clientInfo.equals(auditlog.clientInfo) : auditlog.clientInfo != null )
            return false;
        if ( result != null ? !result.equals(auditlog.result) : auditlog.result != null )
            return false;
        if ( created != null ? !created.equals(auditlog.created) : auditlog.created != null )
            return false;
        if ( creatorId != null ? !creatorId.equals(auditlog.creatorId) : auditlog.creatorId != null )
            return false;
        if ( modified != null ? !modified.equals(auditlog.modified) : auditlog.modified != null )
            return false;
        if ( modifierId != null ? !modifierId.equals(auditlog.modifierId) : auditlog.modifierId != null )
            return false;
        if ( validTo != null ? !validTo.equals(auditlog.validTo) : auditlog.validTo != null )
            return false;
        if ( version != null ? !version.equals(auditlog.version) : auditlog.version != null )
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (functionsId != null ? functionsId.hashCode() : 0);
        result1 = 31 * result1 + (organizationsId != null ? organizationsId.hashCode() : 0);
        result1 = 31 * result1 + (usersId != null ? usersId.hashCode() : 0);
        result1 = 31 * result1 + (event != null ? event.hashCode() : 0);
        result1 = 31 * result1 + (source != null ? source.hashCode() : 0);
        result1 = 31 * result1 + (functionName != null ? functionName.hashCode() : 0);
        result1 = 31 * result1 + (clientInfo != null ? clientInfo.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (created != null ? created.hashCode() : 0);
        result1 = 31 * result1 + (creatorId != null ? creatorId.hashCode() : 0);
        result1 = 31 * result1 + (modified != null ? modified.hashCode() : 0);
        result1 = 31 * result1 + (modifierId != null ? modifierId.hashCode() : 0);
        result1 = 31 * result1 + (validTo != null ? validTo.hashCode() : 0);
        result1 = 31 * result1 + (version != null ? version.hashCode() : 0);
        return result1;
    }
}
