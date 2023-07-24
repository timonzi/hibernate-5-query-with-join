package org.acme;

public class ChildPojo {
    private String masterField;
    private String childField;
    private String relatedField;

    public ChildPojo(
            final String masterField,
            final String childField,
            final String relatedField
    ) {
        this.masterField = masterField;
        this.childField = childField;
        this.relatedField = relatedField;
    }

    public ChildPojo(
            final String masterField,
            final String childField
    ) {
        this.masterField = masterField;
        this.childField = childField;
    }

    public String getMasterField() {
        return masterField;
    }

    public void setMasterField(final String masterField) {
        this.masterField = masterField;
    }

    public String getChildField() {
        return childField;
    }

    public void setChildField(final String childField) {
        this.childField = childField;
    }

    public String getRelatedField() {
        return relatedField;
    }

    public void setRelatedField(final String relatedField) {
        this.relatedField = relatedField;
    }

    @Override
    public String toString() {
        return "ChildPojo{" +
                "masterField='" + masterField + '\'' +
                ", childField='" + childField + '\'' +
                ", relatedField='" + relatedField + '\'' +
                '}';
    }
}
