package ClientTest.OrderCreate.Obj;

import java.util.List;

public class OrderObj {
    private List<OrderListObj> orders;
    private OrderPageInfoObj pageInfo;
    private List<OrderAvailableStationsObj> availableStations;
    
    public List<OrderListObj> getOrders() {
        return orders;
    }
    
    public OrderPageInfoObj getPageInfo() {
        return pageInfo;
    }
    
    public List<OrderAvailableStationsObj> getAvailableStations() {
        return availableStations;
    }
}
