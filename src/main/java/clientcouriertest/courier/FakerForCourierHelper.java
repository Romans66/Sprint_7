package clientcouriertest.courier;

import com.github.javafaker.Faker;

public class FakerForCourierHelper {
    
    private String login;
    private String password;
    private String firstName;
    
    public void generateUserData() {
        Faker faker = new Faker();
        login = faker.name().username();
        password = faker.internet().password();
        firstName = faker.name().firstName();
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
