package model;

public class Deal {
    public int id, customerId;
    public String status;

    public Deal(int id, int customerId, String status) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
    }
}
