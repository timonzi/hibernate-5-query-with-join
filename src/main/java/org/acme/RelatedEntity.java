package org.acme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RelatedEntity {
    @Id
    @GeneratedValue
    public Long id;

    public String relatedField;

    @ManyToOne
    public ChildEntity childEntity;


    public Long getId() {
        return id;
    }


    public String getRelatedField() {
        return relatedField;
    }

    public void setRelatedField(final String relatedField) {
        this.relatedField = relatedField;
    }

    public ChildEntity getChildEntity() {
        return childEntity;
    }

    public void setChildEntity(final ChildEntity childEntity) {
        this.childEntity = childEntity;
    }
}
