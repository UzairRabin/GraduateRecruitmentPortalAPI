package za.ac.cput.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Objects;
import java.io.Serializable;

/**
 * @author Chuma Nxazonke

 * Date: 24 November 2022
 */

@Table
@Entity
public class Graduate implements Serializable {

    //Declaring all the private fields for the program
    @Id
    @Column(name = "graduateId")
    private String graduateId;



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

    @JoinColumn(name = "cvId")
    @OneToOne
    private Cv cv;

    @JoinColumn(name = "qualification")
    @OneToOne
    private Qualification qualification;


    @JoinColumn(name = "experienceId")
    @OneToOne
    private Experience experience;





    protected Graduate(){

    }

    private Graduate(Builder builder) {

        this.graduateId = builder.graduateId;
        this.firstName = builder.firstName;
        this.preferredName = builder.preferredName;
        this.surname = builder.surname;
        this.primaryEmail = builder.primaryEmail;
        this.secondaryEmail = builder.secondaryEmail;
        this.password = builder.password;
        this.cellphone = builder.cellphone;
        this.cv = Cv.builder().build();
        this.qualification = builder.qualification;
        this.experience = builder.experience;


    }

    public String getGraduateId() {
        return graduateId;
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

    public Cv getCv() {
        return cv;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public Experience getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "graduateId='" + graduateId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", preferredName='" + preferredName + '\'' +
                ", surname='" + surname + '\'' +
                ", primaryEmail='" + primaryEmail + '\'' +
                ", secondaryEmail='" + secondaryEmail + '\'' +
                ", password='" + password + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", cv=" + cv +
                ", qualification=" + qualification +
                ", experience=" + experience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graduate graduate = (Graduate) o;
        return Objects.equals(graduateId, graduate.graduateId) && Objects.equals(firstName, graduate.firstName) && Objects.equals(preferredName, graduate.preferredName) && Objects.equals(surname, graduate.surname) && Objects.equals(primaryEmail, graduate.primaryEmail) && Objects.equals(secondaryEmail, graduate.secondaryEmail) && Objects.equals(password, graduate.password) && Objects.equals(cellphone, graduate.cellphone) && Objects.equals(cv, graduate.cv) && Objects.equals(qualification, graduate.qualification) && Objects.equals(experience, graduate.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graduateId);
    }

    public static class Builder {
        private String graduateId;
        private String firstName;
        private String preferredName;
        private String surname;
        private String primaryEmail;
        private String secondaryEmail;
        private String password;
        private String cellphone;
        private Cv cv;
        private Qualification qualification;
        private Experience experience;


        public Builder setGraduateId(String graduateId) {
            this.graduateId = graduateId;
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


        public Builder setCV(Cv cv) {
            this.cv = cv;
            return this;
        }

        public Builder setQualification(Qualification qualification) {
            this.qualification = qualification;
            return this;
        }


        public Builder setExperience(Experience experience) {
            this.experience = experience;
            return this;
        }


        public Builder copy(Graduate graduate) {
            this.graduateId = graduate.graduateId;
            this.firstName = graduate.firstName;
            this.preferredName = graduate.preferredName;
            this.surname = graduate.surname;
            this.primaryEmail = graduate.primaryEmail;
            this.secondaryEmail = graduate.secondaryEmail;
            this.password = graduate.password;
            this.cellphone = graduate.cellphone;
            this.cv = graduate.cv;
            this.experience = graduate.experience;
            this.qualification = graduate.qualification;

            return this;
        }

        public Graduate build() {
            return new Graduate(this);
        }
    }


}
