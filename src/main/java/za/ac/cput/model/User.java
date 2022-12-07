package za.ac.cput.model;

/*
   User.java
   Damone Hartnick
 */
//
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @NotNull
    private String  userId ;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String userRole;



    protected User(){

    }


    public User (Builder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.password = builder.password;
        this.userRole = builder.userRole;
    }


    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    public static class Builder {
        private String userId;
        private String email;
        private String password;
        private String userRole;


        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setUserRole(String userRole) {
            this.userRole = userRole;
            return this;
        }
        public Builder copy(User user) {
            this.userId = user.userId;
            this.email = user.email;
            this.password = user.password;
            this.userRole = user.userRole;

            return this;
        }

        public User build(){
            return new User(this);
        }

    }


}
