package baseclient;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static baseclient.BaseConst.*;

public abstract class BaseClient {
    protected static RequestSpecification requestSpec;
    
    protected BaseClient() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader(CONTENT_TYPE_HEADER, CONTENT_JSON_TYPE)
                .build();
    }
}
