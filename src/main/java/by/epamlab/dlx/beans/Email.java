package by.epamlab.dlx.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Sergei Astapenko on 05.07.2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Email {

    @XmlAttribute(name = "Default", required = true)
    private boolean def;

    @XmlAttribute(name = "EmailAddress", required = true)
    private String emailAddress;

    @XmlAttribute(name = "EmailType", required = true)
    private String emailType;

    @XmlAttribute(name = "Sequence", required = true)
    private String sequence;

    @XmlAttribute(name = "SyncStatus", required = true)
    private String syncStatus;

    public Email() {
    }

    public Email(boolean def, String emailAddress, String emailType, String sequence, String syncStatus) {
        this.def = def;
        this.emailAddress = emailAddress;
        this.emailType = emailType;
        this.sequence = sequence;
        this.syncStatus = syncStatus;
    }

    public void setDef(boolean def) {
        this.def = def;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public boolean isDef() {
        return def;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmailType() {
        return emailType;
    }

    public String getSequence() {
        return sequence;
    }

    public String getSyncStatus() {
        return syncStatus;
    }
}
