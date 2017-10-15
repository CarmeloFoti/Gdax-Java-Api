package it.melo.data;

/**
 * Created by melo on 15/10/17.
 */
public class LimitOrderRequest extends OrderRequest {
    private String price;
    private String size;
    private String time_in_force;
    private String cancel_after;
    private String post_only;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTime_in_force() {
        return time_in_force;
    }

    public void setTime_in_force(String time_in_force) {
        this.time_in_force = time_in_force;
    }

    public String getCancel_after() {
        return cancel_after;
    }

    public void setCancel_after(String cancel_after) {
        this.cancel_after = cancel_after;
    }

    public String getPost_only() {
        return post_only;
    }

    public void setPost_only(String post_only) {
        this.post_only = post_only;
    }

    @Override
    public String toString() {
        return "LimitOrderRequest{" +
                "price='" + price + '\'' +
                ", size='" + size + '\'' +
                ", time_in_force='" + time_in_force + '\'' +
                ", cancel_after='" + cancel_after + '\'' +
                ", post_only='" + post_only + '\'' +
                ", post_only='" + post_only + '\'' +
                super.toString() +
                '}';
    }
}
