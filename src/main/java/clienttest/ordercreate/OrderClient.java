package clienttest.ordercreate;

import baseclient.BaseClient;
import clienttest.ordercreate.obj.OrderObj;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static clienttest.ordercreate.OrderClientConst.*;
import static io.restassured.RestAssured.given;

public class OrderClient extends BaseClient implements OrderClientInterface {
    private OrderObj orderObj;
    
    @Override
    public ValidatableResponse orderCreate(OrderObj orderStub) {
        ValidatableResponse validatableResponse = given().spec(requestSpec).body(orderStub).post(COURIER_CREATE_ORDERS_ENDPOINT).then();
        return validatableResponse;
    }
    
    @Override
    public ValidatableResponse orderList() {
        Response response = given().spec(requestSpec).get(COURIER_LIST_ORDERS_ENDPOINT);
        
        // Попытка десериализации
        try {
            orderObj = response.body().as(OrderObj.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ValidatableResponse validatableResponse = response.then();
        return validatableResponse;
    }
    
    @Override
    public ValidatableResponse orderCancel(String getParam, int trackNumber) {
        ValidatableResponse validatableResponse = given().spec(requestSpec).queryParam(getParam, trackNumber).put(COURIER_CANCEL_ORDERS_ENDPOINT).then();
        return validatableResponse;
    }
    
    public OrderObj getOrderListObj() {
        return orderObj;
    }
}