package clienttest.ordercreate.obj;

public class OrderCancelObj extends OrderObj {
    
    private int track;
    
    public OrderCancelObj(int track) {
        this.track = track;
        
    }
    
    public int getTrack() {
        return track;
    }
}
