package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.RegisterDAO;
import pojo.User;

public class RegisterAction extends ActionSupport {

    private String username;
    private String password;
    private String email;

    public String execute() {

        if (getUsername() == null || getPassword() == null || getEmail() == null) {
            addActionError("All fields are required.");
            return "input";
        }

        // Create a User object with the provided data
        User user = new User(getUsername(), getPassword(), getEmail());

        // Call the DAO to register the user
        boolean registrationSuccess = RegisterDAO.registerUser(user);

        if (registrationSuccess) {
            return "success";
        } else {
            addActionError("Registration failed. Please try again.");
            return "error";
        }
    }

    // Getter and Setter methods

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
