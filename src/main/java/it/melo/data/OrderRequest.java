package it.melo.data;

/**
 * Created by melo on 15/10/17.
 */
public abstract class OrderRequest {
    private String client_oid;
    private String side;
    private String product_id;
    private String stp;

    public String getClient_oid() {
        return client_oid;
    }

    public void setClient_oid(String client_oid) {
        this.client_oid = client_oid;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getStp() {
        return stp;
    }

    public void setStp(String stp) {
        this.stp = stp;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "client_oid='" + client_oid + '\'' +
                ", side='" + side + '\'' +
                ", product_id='" + product_id + '\'' +
                ", stp='" + stp + '\'' +
                '}';
    }
}
