package ClientCourierTest.Courier.DeleteTest;

import ClientCourierTest.Courier.Obj.CourierCreateObj;
import ClientCourierTest.Courier.Obj.CourierLoginObj;
import ClientCourierTest.Courier.Obj.CourierObj;
import ClientTest.ClientTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

public class CourierDeleteTest extends ClientTest {
    
    // Поля для ожидаемых значений json
    private String idKey = "id";
    private String messageKey = "message";
    private String okKey = "ok";
    private boolean expectedOkValue = true;
    private String emptyID = "";
    
    private String errorMessageForDeleteWithIncorrectID = "Курьера с таким id нет.";
    private String errorMessageForDeleteWithoutID = "Недостаточно данных для удаления курьера";
    private String courierId;
    private Random random;
    private CourierObj courierCreate;
    private CourierObj courierLogin;
    
    @Before
    @Step("Подготовка тестовых данных")
    @DisplayName("Подготовка тестовых данных")
    public void setUp() {
        
        random = new Random();
        // Создаем нового курьера для теста
        courierCreate = new CourierCreateObj(fakeLogin, fakePassword, fakeFirstName);
        
        courierClient.courierCreate(courierCreate);
        
        courierLogin = new CourierLoginObj(fakeLogin, fakePassword);
        
        // Извлекаем ID курьера
        courierId =
                courierClient.courierLogin(courierLogin).extract().path(idKey).toString();
    }
    
    // Проверка успешного удаления курьера
    @Test
    @Step("Проверка успешного удаления курьера")
    @DisplayName("Удаление курьера")
    @Description("Удаление курьера по id")
    public void testCourierDelete() {
        ValidatableResponse validatableResponse = courierClient.courierDelete(pathField, courierId);
        validatableResponse.statusCode(200).and().body(okKey, equalTo(expectedOkValue));
    }
    
    // Проверка запроса с неверным id
    @Test
    @Step("Проверка ошибки при попытке удаления курьера с неверным id")
    @DisplayName("Удаление курьера с несуществующим id")
    @Description("Удаление курьера с несуществующим id")
    public void testCourierWithIncorrectId() {
        ValidatableResponse validatableResponse = courierClient.courierDelete(pathField, courierId + random.nextInt(100));
        validatableResponse.statusCode(404).and().body(messageKey, equalTo(errorMessageForDeleteWithIncorrectID));
    }
    
    // Проверка запроса без ID
    @Test
    @Step("Проверка ошибки при попытке удаления курьера без id")
    @DisplayName("Удаление курьера без id")
    @Description("Удаление курьера с пустым id")
    public void testCourierWithoutID() {
        ValidatableResponse validatableResponse = courierClient.courierDelete(pathField, emptyID);
        validatableResponse.statusCode(400).and().body(messageKey, equalTo(errorMessageForDeleteWithoutID));
    }
    
    @After
    @Step("Проверка успешного удаления курьера")
    @DisplayName("Проверка успешного удаления курьера")
    public void tearDown() {
        courierDelete(courierCreate);
    }
}
