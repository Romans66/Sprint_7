package clienttest;

import clientcouriertest.courier.CourierClient;
import clientcouriertest.courier.FakerForCourierHelper;
import clientcouriertest.courier.obj.CourierObj;
import clienttest.ordercreate.FakerForOrderHelper;
import clienttest.ordercreate.OrderClient;

import static clienttest.ClientTestConst.*;

public abstract class ClientTest {
    
    // Общие поля для тестов
    protected static CourierClient courierClient;
    
    // Общие настройки и генерация тестовых данных для тестов ClientCourier
    protected FakerForCourierHelper fakerForCourierHelper;
    
    private static OrderClient OrderClient;
    
    // Общие настройки и генерация тестовых данных для тестов OrderCourier
    
    protected OrderClient orderClient;
    protected FakerForOrderHelper fakerForOrderHelper;
    
    // Поля для сгенерированных данных
    protected String fakeFirstName;
    protected String fakeLastName;
    protected String fakeAddress;
    protected String fakeMetroStation;
    protected String fakePhone;
    protected int fakeRentTime;
    protected String fakeDeliveryDate;
    protected String fakeComment;
    protected String[] fakeColor;
    protected String fakeLogin;
    protected String fakePassword;
    
    public ClientTest() {
        courierClient = new CourierClient();
        orderClient = new OrderClient();
        fakerForOrderHelper = new FakerForOrderHelper();
        fakerForCourierHelper = new FakerForCourierHelper();
        
        // Генерация тестовых данных
        fakerForOrderHelper.generateUserData();
        fakerForCourierHelper.generateUserData();
        
        fakeFirstName = fakerForOrderHelper.getFirstName();
        fakeLastName = fakerForOrderHelper.getLastName();
        fakeAddress = fakerForOrderHelper.getAddress();
        fakeMetroStation = fakerForOrderHelper.getMetroStation();
        fakePhone = fakerForOrderHelper.getPhone();
        fakeRentTime = fakerForOrderHelper.getRentTime();
        fakeDeliveryDate = fakerForOrderHelper.getDeliveryDate();
        fakeComment = fakerForOrderHelper.getComment();
        fakeColor = fakerForOrderHelper.getColour();
        fakeLogin = fakerForCourierHelper.getLogin();
        fakePassword = fakerForCourierHelper.getPassword();
    }
    
    public static void orderCancel(int trackNumber) {
        OrderClient = new OrderClient();
        OrderClient.orderCancel(GET_PARAM_TRACK, trackNumber);
    }
    
    public static void courierDelete(CourierObj courierStub) {
        courierClient = new CourierClient();
        String courierId;
        // Получаем ID и удаляем созданного курьера
        if (courierStub != null) {
            try {
                courierId =
                        courierClient.courierLogin(courierStub).extract().path(ID_KEY).toString();
                courierClient.courierDelete(ID_KEY, courierId);
            } catch (NullPointerException | IllegalStateException e) {
                System.err.println(INFO_MESSAGE_IF_ID_IS_NOT_GET);
            }
        }
    }
}
