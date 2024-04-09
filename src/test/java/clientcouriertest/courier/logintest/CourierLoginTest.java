package clientcouriertest.courier.logintest;

import clientcouriertest.courier.obj.CourierCreateObj;
import clientcouriertest.courier.obj.CourierLoginObj;
import clientcouriertest.courier.obj.CourierObj;
import clienttest.ClientTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static clienttest.ClientTestConst.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CourierLoginTest extends ClientTest {
    private CourierObj courierLogin;
    private CourierObj courierCreate;
    private CourierObj courierLoginWithIncorrectPassword;
    private CourierObj courierLoginWithoutPassword;
    private CourierObj courierLoginWithIncorrectData;
    
    @Before
    @Step("Подготовка тестовых данных")
    @DisplayName("Подготовка тестовых данных")
    public void setUp() {
        // Создаем курьера и тестовые данные для тестов
        courierCreate = new CourierCreateObj(fakeLogin, fakePassword, fakeFirstName);
        
        courierClient.courierCreate(courierCreate);
        
        courierLogin = new CourierLoginObj(fakeLogin, fakePassword);
        
        courierLoginWithIncorrectPassword = new CourierLoginObj(fakeLogin, fakePassword + fakeLogin);
        
        courierLoginWithoutPassword = new CourierLoginObj(fakeLogin);
        
        courierLoginWithIncorrectData = new CourierLoginObj(fakeLogin + fakePassword, fakePassword);
    }
    
    // Проверка успешного логина курьера
    @Test
    @Step("Проверка успешного логина курьера")
    @DisplayName("Успешный логин курьера")
    @Description("Проверка успешного логина курьера")
    public void testCourierLogin() {
        ValidatableResponse validatableResponse = courierClient.courierLogin(courierLogin);
        validatableResponse.statusCode(200).body(ID_KEY, notNullValue());
    }
    
    // Проверка ошибки при неверном пароле
    @Test
    @Step("Проверка ошибки при попытке логина с некорректным паролем")
    @DisplayName("Ошибка при логине с некорректным паролем")
    @Description("Проверка логина при отправке некорректного пароля")
    public void testCourierLoginWithIncorrectPassword() {
        ValidatableResponse validatableResponse = courierClient.courierLogin(courierLoginWithIncorrectPassword);
        validatableResponse.statusCode(404).body(MESSAGE_KEY, equalTo(ERROR_MESSAGE_FOR_LOGIN_WITH_INCORRECT_DATA));
    }
    
    // Проверка ошибки при логине без поля password
    @Test
    @Step("Проверка ошибки при попытке логина без пароля")
    @DisplayName("Ошибка при логине без пароля")
    @Description("Проверка логина при отправке данных без пароля")
    public void testCourierLoginWithoutPasswordData() {
        ValidatableResponse validatableResponse = courierClient.courierLogin(courierLoginWithoutPassword);
        validatableResponse.statusCode(400).body(MESSAGE_KEY, equalTo(ERROR_MESSAGE_FOR_LOGIN_WITHOUT_PARAMETERS));
    }
    
    // Проверка ошибки при отправке некорректного логина
    @Test
    @Step("Проверка ошибки при попытке логина с некорректным логином")
    @DisplayName("Ошибка при логине с неверным логином")
    @Description("Проверка логина при отправке данных с некорректным логином")
    public void testCourierLoginWithIncorrectLogin() {
        ValidatableResponse validatableResponse = courierClient.courierLogin(courierLoginWithIncorrectData);
        validatableResponse.statusCode(404).body(MESSAGE_KEY, equalTo(ERROR_MESSAGE_FOR_LOGIN_WITH_INCORRECT_DATA));
    }
    
    @After
    @Step("Проверка успешного удаления курьера")
    @DisplayName("Проверка успешного удаления курьерам")
    public void tearDown() {
        courierDelete(courierCreate);
    }
}