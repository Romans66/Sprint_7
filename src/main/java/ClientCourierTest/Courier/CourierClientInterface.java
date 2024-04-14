package ClientCourierTest.Courier;

import ClientCourierTest.Courier.Obj.CourierObj;
import io.restassured.response.ValidatableResponse;

public interface CourierClientInterface {
    
    ValidatableResponse courierCreate(CourierObj courier);
    
    ValidatableResponse courierLogin(CourierObj courier);
    
    ValidatableResponse courierDelete(String pathParameter, String id);
    
}
