package org.acme;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ChildEntity extends MasterEntity {
    private String childField;

    @OneToMany(mappedBy = "childEntity")
    public Set<RelatedEntity> relatedEntitySet;

    public String getChildField() {
        return childField;
    }

    public void setChildField(final String childField) {
        this.childField = childField;
    }

    public Set<RelatedEntity> getRelatedEntitySet() {
        return relatedEntitySet;
    }

    public void setRelatedEntitySet(final Set<RelatedEntity> relatedEntitySet) {
        this.relatedEntitySet = relatedEntitySet;
    }

    @Override
    public String toString() {
        return "ChildEntity{" +
                "childField='" + childField + '\'' +
                ", relatedEntitySet=" + relatedEntitySet +
                ", id=" + id +
                ", masterField='" + masterField + '\'' +
                '}';
    }
}
