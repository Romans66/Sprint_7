package clientcouriertest.courier.obj;

public class CourierLoginObj extends CourierObj {
    private String login;
    private String password;
    
    public CourierLoginObj() {
    }
    
    public CourierLoginObj(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public CourierLoginObj(String login) {
        this.login = login;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }
    
}
