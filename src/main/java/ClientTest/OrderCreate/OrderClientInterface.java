package ClientTest.OrderCreate;

import ClientTest.OrderCreate.Obj.OrderObj;
import io.restassured.response.ValidatableResponse;

public interface OrderClientInterface {
    
    ValidatableResponse orderCreate(OrderObj orderStub);
    
    ValidatableResponse orderList();
    
    ValidatableResponse orderCancel(String getParam, int trackNumber);
}
