package interceptor;

import action.LoginAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

public class LoginInterceptor implements Interceptor {
    @Override
    public void destroy() {
        System.out.println("destroy called");
    }

    @Override
    public void init() {
        System.out.println("init called");

    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Object user = ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");

        if (user == null){
            if (ai.getAction().getClass().equals(LoginAction.class)){
                return ai.invoke();
            }
            return "input";
        }
        return ai.invoke();
    }
}
