/*
Author: Tiffany Kiwiets
Entity class for CV
 */

package za.ac.cput.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Cv implements Serializable {

    @Id
    @NotNull private int cvId;
    @NotNull private String documentLocation;
    @NotNull private boolean isAcknowledged;
    @NotNull private LocalDate dateAdded;

    protected Cv() {

    }

    //private constructor
    public Cv(Builder builder) {
        this.cvId = builder.cvId;
        this.documentLocation = builder.documentLocation;
        this.isAcknowledged = builder.isAcknowledged;
        this.dateAdded = builder.dateAdded;
    }

    //getter
    public int getCvId() {
        return cvId;
    }

    public String getDocumentLocation() {
        return documentLocation;
    }

    public boolean isAcknowledged() {
        return isAcknowledged;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cv that)) return false;
        return getCvId() == that.getCvId() && Objects.equals(getDocumentLocation(), that.getDocumentLocation()) && Objects.equals(isAcknowledged(), that.isAcknowledged())
                && Objects.equals(getDateAdded(), that.getDateAdded());
    }

    @Override
    public  int hashCode() {
        return Objects.hash(getCvId(), getDocumentLocation(), isAcknowledged(), getDateAdded());
    }

    //toString
    @Override
    public String toString() {
        return "Cv{" +
                "cvId=" + cvId +
                ", documentLocation='" + documentLocation + '\'' +
                ", isAcknowledged=" + isAcknowledged +
                ", dateAdded=" + dateAdded +
                '}';
    }

    //builder
    public static class Builder {
        @NotNull private int cvId;
        @NotNull private String documentLocation;
        @NotNull private boolean isAcknowledged;
        @NotNull private LocalDate dateAdded;

        public Builder setCvId(int cvId) {
            this.cvId = cvId;
            return this;
        }

        public Builder setDocumentLocation(String documentLocation) {
            this.documentLocation = documentLocation;
            return this;
        }

        public Builder setAcknowledged(boolean acknowledged) {
            isAcknowledged = acknowledged;
            return this;
        }

        public Builder setDateAdded(LocalDate dateAdded) {
            this.dateAdded = dateAdded;
            return this;
        }

        public Builder copy(Cv cv) {
            this.cvId = cv.cvId;
            this.documentLocation = cv.documentLocation;
            this.isAcknowledged = cv.isAcknowledged;
            this.dateAdded = cv.dateAdded;
            return this;
        }

        public Cv build() {
            return new Cv(this);
        }
    }
}
