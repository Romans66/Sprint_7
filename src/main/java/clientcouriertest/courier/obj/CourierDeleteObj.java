package clientcouriertest.courier.obj;

public class CourierDeleteObj extends CourierObj {
    private String id;
    
    public CourierDeleteObj() {
    }
    
    public CourierDeleteObj(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
}
