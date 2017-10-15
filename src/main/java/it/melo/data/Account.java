package it.melo.data;

/**
 * Created by melo on 14/10/17.
 */
public class Account {
    String id;
    String currency;
    String balance;
    String available;
    String hold;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", balance='" + balance + '\'' +
                ", available='" + available + '\'' +
                ", hold='" + hold + '\'' +
                ", profile_id='" + profile_id + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    String profile_id;

}
