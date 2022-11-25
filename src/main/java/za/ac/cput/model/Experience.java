package za.ac.cput.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Experience {
    //Experience attributes
    @Id @NotNull
    private String experienceId;
    @NotNull
    private String  jobTitle;
    @NotNull
    private String assumedRole;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;

    //private constructor
    private Experience (Builder builder){
        this.experienceId = builder.experienceId;
        this.jobTitle = builder.jobTitle;
        this.assumedRole = builder.assumedRole;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;

    }

    protected Experience () {}

    //Getters

    public String getExperienceId() {
        return experienceId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getAssumedRole() {
        return assumedRole;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "experienceId='" + experienceId + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", assumedRole='" + assumedRole + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    //Builder

    public static class Builder {
        private String experienceId;
        private String jobTitle;
        private String assumedRole;
        private String startDate;
        private String endDate;

        public Builder setExperienceId(String experienceId) {
            this.experienceId = experienceId;
            return this;
        }

        public Builder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public Builder setAssumedRole(String assumedRole) {
            this.assumedRole = assumedRole;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder copy(Experience experience) {
            this.experienceId = experience.experienceId;
            this.jobTitle = experience.jobTitle;
            this.assumedRole = experience.assumedRole;
            this.startDate = experience.startDate;
            this.endDate = experience.endDate;

            return this;
        }


        public Experience build() {
            return new Experience(this); // anonymous object
        }

    }
}