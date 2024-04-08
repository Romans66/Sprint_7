package ClientCourierTest.Courier.Obj;

public class CourierCreateObj extends CourierObj {
    private String login;
    private String password;
    private String firstName;
    
    public CourierCreateObj() {
    }
    
    public CourierCreateObj(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }
    
    public CourierCreateObj(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public CourierCreateObj(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getFirstName() {
        return firstName;
    }
}
