package evoliris.com.evoliris_fragmentcommunication.model;

import java.util.Date;

/**
 * Created by temp on 26/08/2016.
 */
public class User {

    private String username;
    private String password;
    private Date dateOfBirth;

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
