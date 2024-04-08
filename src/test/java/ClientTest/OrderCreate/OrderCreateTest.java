package ClientTest.OrderCreate;

import ClientTest.ClientTest;
import ClientTest.OrderCreate.Obj.OrderCreateObj;
import ClientTest.OrderCreate.Obj.OrderObj;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;

public class OrderCreateTest extends ClientTest {
    
    // Поля для ожидаемых значений json
    private String trackKey = "track";
    private String[] blackColour = {"BLACK"};
    private String[] greyColour = {"GREY"};
    private String[] blackAndGreyColour = {"GREY", "BLACK"};
    private OrderObj orderCreate;
    private int trackNumber;
    
    @Before
    @Step("Подготовка тестовых данных")
    @DisplayName("Подготовка тестовых данных")
    public void setUp() {
        orderClient = new OrderClient();
        orderCreate = new OrderCreateObj(fakeFirstName,
                fakeLastName,
                fakeAddress,
                fakeMetroStation,
                fakePhone,
                fakeRentTime,
                fakeDeliveryDate,
                fakeComment,
                fakeColor);
    }
    
    // Проверяем успешное создание заказа
    @Test
    @Step("Проверяем успешное создание заказа")
    @DisplayName("Успешное создание заказа")
    @Description("Создаем заказ с рандомными данными")
    public void orderCreate() {
        ValidatableResponse validatableResponse = orderClient.orderCreate(orderCreate);
        validatableResponse.statusCode(201).and().body(trackKey, notNullValue());
        trackNumber = validatableResponse.extract().path(trackKey);
    }
    
    // Проверка успешного создания заказа с самокатом черного цвета
    @Test
    @Step("Проверка успешного создания заказа с самокатом черного цвета")
    @DisplayName("Успешное создание заказа с самокатом черного цвета")
    @Description("Успешное создание заказа с самокатом черного цвета")
    public void orderCreateWithBlackColour() {
        OrderObj orderCreateWithBlackColour = new OrderCreateObj(fakeFirstName,
                fakeLastName,
                fakeAddress,
                fakeMetroStation,
                fakePhone,
                fakeRentTime,
                fakeDeliveryDate,
                fakeComment,
                blackColour);
        ValidatableResponse validatableResponse = orderClient.orderCreate(orderCreateWithBlackColour);
        validatableResponse.statusCode(201).and().body(trackKey, notNullValue());
        trackNumber = validatableResponse.extract().path(trackKey);
    }
    
    // Проверка успешного создания заказа с самокатом серого цвета
    @Test
    @Step("Проверка успешного создания заказа с самокатом серого цвета")
    @DisplayName("Успешное создание заказа с самокатом серого цвета")
    @Description("Успешное создание заказа с самокатом серого цвета")
    public void orderCreateWithGreyColour() {
        OrderObj orderCreateWithGreyColour = new OrderCreateObj(fakeFirstName,
                fakeLastName,
                fakeAddress,
                fakeMetroStation,
                fakePhone,
                fakeRentTime,
                fakeDeliveryDate,
                fakeComment,
                greyColour);
        ValidatableResponse validatableResponse = orderClient.orderCreate(orderCreateWithGreyColour);
        validatableResponse.statusCode(201).and().body(trackKey, notNullValue());
        trackNumber = validatableResponse.extract().path(trackKey);
    }
    
    // Проверка успешного создания заказа самоката с двумя цветами
    @Test
    @Step("Проверка успешного создания заказа самоката с двумя цветами")
    @DisplayName("Успешное создание заказа с двумя цветами")
    @Description("Успешное создание заказа с двумя цветами")
    public void orderCreateWithBlackAndGreyColour() {
        OrderObj orderCreateWithBlackAndGreyColour = new OrderCreateObj(fakeFirstName,
                fakeLastName,
                fakeAddress,
                fakeMetroStation,
                fakePhone,
                fakeRentTime,
                fakeDeliveryDate,
                fakeComment,
                blackAndGreyColour);
        ValidatableResponse validatableResponse = orderClient.orderCreate(orderCreateWithBlackAndGreyColour);
        validatableResponse.statusCode(201).and().body(trackKey, notNullValue());
        trackNumber = validatableResponse.extract().path(trackKey);
    }
    
    @After
    @Step("Отмена созданного заказа")
    @DisplayName("Отмена созданного заказа")
    public void tearDown() {
        orderCancel(trackNumber);
    }
}