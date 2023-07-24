package org.acme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MasterEntity {
    @Id
    @GeneratedValue
    public Long id;

    public String masterField;


    public Long getId() {
        return id;
    }


    public String getMasterField() {
        return masterField;
    }

    public void setMasterField(final String masterField) {
        this.masterField = masterField;
    }
}
