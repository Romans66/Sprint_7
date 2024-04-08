package ClientTest.OrderCreate;

import com.github.javafaker.Faker;

import java.util.concurrent.TimeUnit;

public class FakerForOrderHelper {
    
    // Поля для создания заказа
    private String[] coloursOfScooter = {"BLACK", "GREY"};
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] colour;
    
    public void generateUserData() {
        Faker faker = new Faker();
        // Генерация тестовых данных
        Integer randomCounterUpTo100 = faker.number().numberBetween(0, 100);
        Integer randomCounterUpTo2 = faker.number().numberBetween(0, 2);
        
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        address = faker.address().fullAddress();
        metroStation = randomCounterUpTo100.toString();
        phone = faker.phoneNumber().phoneNumber();
        rentTime = randomCounterUpTo100;
        deliveryDate = faker.date().future(7, TimeUnit.DAYS).toString();
        comment = faker.lorem().sentence();
        
        colour = new String[ randomCounterUpTo2 ];
        for (int i = 0; i < randomCounterUpTo2; i++) {
            colour[ i ] = coloursOfScooter[ randomCounterUpTo2 ];
        }
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getMetroStation() {
        return metroStation;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public int getRentTime() {
        return rentTime;
    }
    
    public String getDeliveryDate() {
        return deliveryDate;
    }
    
    public String getComment() {
        return comment;
    }
    
    public String[] getColour() {
        return colour;
    }
    
    public String[] getColoursOfScooter() {
        return coloursOfScooter;
    }
}
