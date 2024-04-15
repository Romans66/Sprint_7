package clientcouriertest.courier;

import baseclient.BaseClient;
import clientcouriertest.courier.obj.CourierObj;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierClient extends BaseClient implements CourierClientInterface {
    
    @Override
    public ValidatableResponse courierCreate(CourierObj courier) {
        ValidatableResponse validatableResponse = given().spec(requestSpec).body(courier).post(CourierClientConst.COURIER_CREATE_ENDPOINT).then();
        return validatableResponse;
    }
    
    @Override
    public ValidatableResponse courierLogin(CourierObj courier) {
        ValidatableResponse validatableResponse = given().spec(requestSpec).body(courier).post(CourierClientConst.COURIER_LOGIN_ENDPOINT).then();
        return validatableResponse;
    }
    
    @Override
    public ValidatableResponse courierDelete(String pathParameter, String id) {
        ValidatableResponse validatableResponse = given().spec(requestSpec).pathParam(pathParameter, id).delete(CourierClientConst.COURIER_DELETE_ENDPOINT).then();
        return validatableResponse;
    }
}