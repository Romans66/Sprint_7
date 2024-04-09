package clienttest.ordercreate;

import clienttest.ordercreate.obj.OrderObj;
import io.restassured.response.ValidatableResponse;

public interface OrderClientInterface {
    
    ValidatableResponse orderCreate(OrderObj orderStub);
    
    ValidatableResponse orderList();
    
    ValidatableResponse orderCancel(String getParam, int trackNumber);
}
