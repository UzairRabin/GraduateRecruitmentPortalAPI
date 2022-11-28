package za.ac.cput.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Qualification implements Serializable {
    @Id
    private String qualificationId;
    private String qualificationName, qualificationDescription,;

    public Qualification() {

    }

    private Qualification(Builder builder) {
        this.qualificationId = builder.qualificationId;
        this.qualificationName = builder.qualificationName;
        this.qualificationDescription = builder.qualificationDescription;
    }

    public String getQualificationId() {
        return qualificationId;
    }


    public String getQualificationName() {
        return qualificationName;
    }

    public String getQualificationDescription() {
        return qualificationDescription;
    }


    @Override
    public String toString() {
        return "Qualification{" +
                "qualificationId='" + qualificationId + '\'' +
                ", qualificationName='" + qualificationName + '\'' +
                ", qualificationDescription='" + qualificationDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Qualification qualification = (Qualification) o;
        return qualificationId.equals(qualification.qualificationId) && qualificationName.equals(qualification.qualificationName) && qualificationDescription.equals(qualification.qualificationDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualificationId, qualificationName, qualificationDescription);
    }

    public static class Builder {
        private String qualificationId, qualificationName, qualificationDescription;


        public Builder qualificationId(String qualificationId) {
            this.qualificationId = qualificationId;
            return this;

        }

        public Builder qualificationName(String qualificationName) {
            this.qualificationName = qualificationName;
            return this;

        }

        public Builder qualificationDescription(String qualificationDescription) {
            this.qualificationDescription = qualificationDescription;
            return this;


        }


        public Qualification build() {
            return new Qualification(this);
        }
    }
}
