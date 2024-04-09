package clienttest.ordercreate.obj;

public class OrderListObj extends OrderObj {
    
    private Integer id;
    private Integer courierId;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;
    private String createdAt;
    private String updatedAt;
    private Integer status;
    private String firstName;
    private String lastName;
    private Integer track;
    
    public Integer getId() {
        return id;
    }
    
    public Integer getCourierId() {
        return courierId;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getMetroStation() {
        return metroStation;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public int getRentTime() {
        return rentTime;
    }
    
    public String getDeliveryDate() {
        return deliveryDate;
    }
    
    public String getComment() {
        return comment;
    }
    
    public String[] getColor() {
        return color;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }
    
    public String getUpdatedAt() {
        return updatedAt;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Integer getTrack() {
        return track;
    }
}
