package clienttest.listoforders;

import clientcouriertest.courier.obj.CourierObj;
import clienttest.ClientTest;
import clienttest.ordercreate.obj.OrderListObj;
import clienttest.ordercreate.OrderClient;
import clienttest.ordercreate.obj.OrderObj;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class OrderGetListTest extends ClientTest {
    private OrderObj orderObj;
    private OrderObj orderCreate;
    private CourierObj courierCreate;
    private CourierObj courierLogin;
    private String courierId;
    
    @Before
    @Step("Подготовка тестовых данных")
    @DisplayName("Подготовка тестовых данных")
    public void setUp() {
        orderClient = new OrderClient();
        orderObj = new OrderListObj();
    }
    
    // Проверка успешного получения списка заказов
    @Test
    @Step("Проверка успешного получения списка заказов")
    @DisplayName("Получение списка существующих заказов")
    @Description("Получаем все заказы и доп. данные")
    public void orderCreate() {
        ValidatableResponse validatableResponse = orderClient.orderList();
        validatableResponse.statusCode(200);
        OrderObj orderListAllObj = orderClient.getOrderListObj();
        assertThat(orderListAllObj.getAvailableStations().size(), notNullValue());
        assertThat(orderListAllObj.getOrders().size(), notNullValue());
        assertThat(orderListAllObj.getPageInfo().getPage(), notNullValue());
        assertThat(orderListAllObj.getPageInfo().getTotal(), notNullValue());
        assertThat(orderListAllObj.getPageInfo().getLimit(), notNullValue());
    }
    
}