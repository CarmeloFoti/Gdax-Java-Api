package it.melo.data;


/**
 * Created by melo on 15/10/17.
 */
public class AccountChange {

    private String id;
    private String created_at;
    private String  amount;
    private String balance;
    private String  type;
    private AccountChangeDetail details;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AccountChangeDetail getDetails() {
        return details;
    }

    public void setDetails(AccountChangeDetail details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "AccountChange{" +
                "id='" + id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", amount='" + amount + '\'' +
                ", balance='" + balance + '\'' +
                ", type='" + type + '\'' +
                ", details=" + details +
                '}';
    }


/*
            "details": {
        "order_id": "d50ec984-77a8-460a-b958-66f114b0de9b",
                "trade_id": "74",
                "product_id": "BTC-USD"
    }
    */
}
