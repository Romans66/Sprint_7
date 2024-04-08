package ClientTest;

import ClientCourierTest.Courier.CourierClient;
import ClientCourierTest.Courier.FakerForCourierHelper;
import ClientCourierTest.Courier.Obj.CourierObj;
import ClientTest.OrderCreate.FakerForOrderHelper;
import ClientTest.OrderCreate.OrderClient;

public abstract class ClientTest {
    // Данные для tearDown
    private static String infoMessageIfIdIsNotGet = "Id курьера не найден по запросу, удаление не требуется";
    private static String idKeyForDelete = "id";
    
    // Общие поля для тестов
    protected static String pathField = "id";
    protected static CourierClient courierClient;
    
    // Общие настройки и генерация тестовых данных для тестов ClientCourier
    
    protected FakerForCourierHelper fakerForCourierHelper;
    
    // Поля для метода с отменой заказа
    private static String getParam = "track";
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
        OrderClient.orderCancel(getParam, trackNumber);
    }
    
    public static void courierDelete(CourierObj courierStub) {
        courierClient = new CourierClient();
        String courierId;
        // Получаем ID и удаляем созданного курьера
        if (courierStub != null) {
            try {
                courierId =
                        courierClient.courierLogin(courierStub).extract().path(idKeyForDelete).toString();
                courierClient.courierDelete(pathField, courierId);
            } catch (NullPointerException | IllegalStateException e) {
                System.err.println(infoMessageIfIdIsNotGet);
            }
        }
    }
}
