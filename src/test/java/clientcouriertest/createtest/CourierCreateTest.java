package clientcouriertest.createtest;

import clientcouriertest.courier.obj.CourierCreateObj;
import clientcouriertest.courier.obj.CourierObj;
import clienttest.ClientTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;

import static clienttest.ClientTestConst.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class CourierCreateTest extends ClientTest {
    
    // Поля для ожидаемых значений json
    private final boolean expectedOkValue = true;
    private CourierObj courierCreate;
    private CourierObj courierWithoutFirstName;
    private CourierCreateObj courierWithoutRequirementData;
    
    @Before
    @Step("Подготовка тестовых данных")
    @DisplayName("Подготовка тестовых данных")
    public void setUp() {
        courierCreate = new CourierCreateObj(fakeLogin, fakePassword, fakeFirstName);
        courierWithoutFirstName = new CourierCreateObj(fakeLogin, fakePassword);
        courierWithoutRequirementData = new CourierCreateObj(fakeFirstName);
    }
    
    // Проверка успешного создания курьера
    @Test
    @Step("Проверка успешного создания курьера")
    @DisplayName("Создание курьера")
    @Description("Создание курьера со всеми заполненными полями")
    public void testCourierCreate() {
        ValidatableResponse validatableResponse = courierClient.courierCreate(courierCreate);
        
        validatableResponse.statusCode(201).and().body(OK_KEY, equalTo(expectedOkValue));
    }
    
    // Проверка невозможности создания дубликата курьера
    @Test
    @Step("Проверка невозможности создания дубликата курьера")
    @DisplayName("Дуликат курьера")
    @Description("Создание курьера с ранее созданными данными")
    public void testCourierCreateDuplicateData() {
        ValidatableResponse validatableResponseFirst = courierClient.courierCreate(courierCreate);
        
        validatableResponseFirst.statusCode(201).and().body(OK_KEY, equalTo(expectedOkValue));
        
        ValidatableResponse validatableResponseSecond = courierClient.courierCreate(courierCreate);
        
        validatableResponseSecond.statusCode(409).and().body(MESSAGE_KEY, equalTo(ERROR_MESSAGE_FOR_DUPLICATE_COURIER));
    }
    
    // Проверка создания курьера без firstName
    @Test
    @Step("Проверка создания курьера без поля firstName")
    @DisplayName("Создание курьера без firstName")
    @Description("Создание курьера без необязательного поля firstName")
    public void testCourierCreateWithoutFirstName() {
        ValidatableResponse validatableResponse = courierClient.courierCreate(courierWithoutFirstName);
        
        validatableResponse.statusCode(201).and().body(OK_KEY, equalTo(expectedOkValue));
    }
    
    // Проверка создания курьера без login и Password
    @Test
    @Step("Проверка создания курьера без полей login и Password")
    @DisplayName("Создание курьера без login и Password")
    @Description("Создание курьера без обязательных полей login и Password")
    public void testCourierCreateWithoutRequirementData() {
        CourierCreateObj courierWithoutRequirementData = new CourierCreateObj(fakeFirstName);
        
        ValidatableResponse validatableResponse = courierClient.courierCreate(courierWithoutRequirementData);
        
        validatableResponse.statusCode(400).and().body(MESSAGE_KEY, equalTo(ERROR_MESSAGE_WITHOUT_REQUIRED_DATA));
    }
    
    @After
    @Step("Проверка успешного удаления курьера")
    @DisplayName("Проверка успешного удаления курьера")
    public void tearDown() {
        courierDelete(courierCreate);
    }
}
