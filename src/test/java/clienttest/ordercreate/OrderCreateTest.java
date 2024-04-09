package clienttest.ordercreate;

import clienttest.ClientTest;
import clienttest.ordercreate.obj.OrderCreateObj;
import clienttest.ordercreate.obj.OrderObj;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static clienttest.ClientTestConst.GET_PARAM_TRACK;
import static org.hamcrest.Matchers.notNullValue;
@RunWith(Parameterized.class)
public class OrderCreateTest extends ClientTest {
    
    // Поля для ожидаемых значений json
    private String[] scooterColour;
    private OrderObj orderCreate;
    private int trackNumber;
    
    public OrderCreateTest(String[] scooterColour) {
        this.scooterColour = scooterColour;
    }
    
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"GREY", "BLACK"}},
                {new String[]{}}
        };
    }
    
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
                scooterColour);
    }
    
    // Проверяем успешное создание заказа
    @Test
    @Step("Проверяем успешное создание заказа")
    @DisplayName("Успешное создание заказа")
    @Description("Создаем заказ с цветами BLACK, GREY и без цвета")
    public void orderCreate() {
        ValidatableResponse validatableResponse = orderClient.orderCreate(orderCreate);
        validatableResponse.statusCode(201).and().body(GET_PARAM_TRACK, notNullValue());
        trackNumber = validatableResponse.extract().path(GET_PARAM_TRACK);
    }
    
    @After
    @Step("Отмена созданного заказа")
    @DisplayName("Отмена созданного заказа")
    public void tearDown() {
        orderCancel(trackNumber);
    }
}