package it.melo.data;

/**
 * Created by melo on 15/10/17.
 */
public class AccountChangeDetail {
    public String order_id;
    public String trade_id;
    public String product_id;
    public String transfer_id;
    public String transfer_type;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(String trade_id) {
        this.trade_id = trade_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(String transfer_id) {
        this.transfer_id = transfer_id;
    }

    public String getTransfer_type() {
        return transfer_type;
    }

    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }

    @Override
    public String toString() {
        return "AccountChangeDetail{" +
                "order_id='" + order_id + '\'' +
                ", trade_id='" + trade_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", transfer_id='" + transfer_id + '\'' +
                ", transfer_type='" + transfer_type + '\'' +
                '}';
    }
}
