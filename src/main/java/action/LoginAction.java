package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.LoginDAO;
import org.apache.struts2.ServletActionContext;
import pojo.LoginInfo;

public class LoginAction extends ActionSupport {

    String username;
    String password;

    public String execute(){
       String statusCode = "";
       boolean isUserValid = LoginDAO.isUserValid(new LoginInfo(username,password));
        ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", username);

       if (isUserValid){
           statusCode = "success";
       } else {
           statusCode = "input";
       }
       return statusCode;
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
}
