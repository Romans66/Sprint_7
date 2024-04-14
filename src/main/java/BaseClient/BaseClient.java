package BaseClient;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class BaseClient {
    protected static RequestSpecification requestSpec;
    
    protected BaseClient() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://qa-scooter.praktikum-services.ru/")
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
