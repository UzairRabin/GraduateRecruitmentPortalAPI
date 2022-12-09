package za.ac.cput.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

/**
 * @author Chuma Nxazonke

 * Date: 24 November 2022
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Graduate implements Serializable {

    //Declaring all the private fields for the program
    @Id
    @Column(name = "graduateId")
    private String graduateId;

    @JoinColumn(name = "experienceId")
    @OneToOne
    private Experience experiences;

    @JoinColumn(name = "cvId")
    @OneToOne
    private Cv cv;

    @JoinColumn(name = "qualificationId")
    @OneToOne
    private Qualification qualification;

    @NotNull
    private String firstName;
    @NotNull
    private String preferredName;
    @NotNull
    private String surname;
    @NotNull
    private String primaryEmail;
    @NotNull
    private String secondaryEmail;
    @NotNull
    private String password;
    @NotNull
    private String cellphone;

    public Graduate(Builder builder) {
        this.graduateId = builder.graduateId;
        this.experiences = builder.experience;
        this.qualification = builder.qualification;
        this.cv = builder.cv;
        this.firstName = builder.firstName;
        this.preferredName = builder.preferredName;
        this.surname = builder.surname;
        this.primaryEmail = builder.primaryEmail;
        this.secondaryEmail = builder.secondaryEmail;
        this.password = builder.password;
        this.cellphone = builder.cellphone;
    }

    public String getGraduateId() {
        return graduateId;
    }

    public Experience getExperiences() {
        return experiences;
    }

    public Cv getCv() {
        return cv;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getCellphone() {
        return cellphone;
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "graduateId='" + graduateId + '\'' +
                ", experiences=" + experiences +
                ", cv=" + cv +
                ", qualification=" + qualification +
                ", firstName='" + firstName + '\'' +
                ", preferredName='" + preferredName + '\'' +
                ", surname='" + surname + '\'' +
                ", primaryEmail='" + primaryEmail + '\'' +
                ", secondaryEmail='" + secondaryEmail + '\'' +
                ", password='" + password + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graduate graduate = (Graduate) o;
        return graduateId.equals(graduate.graduateId) && experiences.equals(graduate.experiences) && cv.equals(graduate.cv) && qualification.equals(graduate.qualification) && firstName.equals(graduate.firstName) && preferredName.equals(graduate.preferredName) && surname.equals(graduate.surname) && primaryEmail.equals(graduate.primaryEmail) && secondaryEmail.equals(graduate.secondaryEmail) && password.equals(graduate.password) && cellphone.equals(graduate.cellphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graduateId);
    }

    public static class Builder {
        private String graduateId;
        private Experience experience;
        private Cv cv;
        private Qualification qualification;
        private String firstName;
        private String preferredName;
        private String surname;
        private String primaryEmail;
        private String secondaryEmail;
        private String password;
        private String cellphone;


        public Builder setGraduateId(String graduateId) {
            this.graduateId = graduateId;
            return this;
        }

        public Builder setExperience(Experience experience) {
            this.experience = experience;
            return this;
        }

        public Builder setQualification(Qualification qualification) {
            this.qualification = qualification;
            return this;
        }

        public Builder setCV(Cv cv) {
            this.cv = cv;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setPreferredName(String preferredName) {
            this.preferredName = preferredName;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setPrimaryEmail(String primaryEmail) {
            this.primaryEmail = primaryEmail;
            return this;
        }

        public Builder setSecondaryEmail(String secondaryEmail) {
            this.secondaryEmail = secondaryEmail;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setCellphone(String cellphone) {
            this.cellphone = cellphone;
            return this;
        }

        public Builder copy(Graduate graduate) {
            this.graduateId = graduateId;
            this.experience = experience;
            this.qualification = qualification;
            this.cv = cv;
            this.firstName = graduate.firstName;
            this.preferredName = graduate.preferredName;
            this.surname = graduate.surname;
            this.primaryEmail = graduate.primaryEmail;
            this.secondaryEmail = graduate.secondaryEmail;
            this.password = graduate.password;
            this.cellphone = graduate.cellphone;

            return this;
        }

        public Graduate build() {
            return new Graduate(this);
        }
    }


}
