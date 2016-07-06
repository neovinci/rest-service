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
public class Phone {

    @XmlAttribute(name = "Default", required = true)
    private boolean def;

    @XmlAttribute(name = "PhoneNumber", required = true)
    private String phoneNumber;

    @XmlAttribute(name = "PhoneType", required = true)
    private String phoneType;

    @XmlAttribute(name = "Sequence", required = true)
    private String sequence;

    @XmlAttribute(name = "SyncStatus", required = true)
    private String syncStatus;

    public Phone() {
    }

    public Phone(boolean def, String phoneNumber, String phoneType, String sequence, String syncStatus) {
        this.def = def;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.sequence = sequence;
        this.syncStatus = syncStatus;
    }

    public void setDef(boolean def) {
        this.def = def;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public String getSequence() {
        return sequence;
    }

    public String getSyncStatus() {
        return syncStatus;
    }
}
