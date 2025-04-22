package servicejoki.models;

public abstract class OrderBase {
    protected int id;
    protected int idcustomer;
    protected final String jenisLayanan = "Joki Game";  // FINAL ATRIBUT

    public OrderBase(int id, int idcustomer, String status) {
        this.id = id;
        this.idcustomer = idcustomer;
        this.status = status;
    }

    protected String status;

    // FINAL METHOS
    public final String getJenisLayanan() {
        return jenisLayanan;
    }

    // ABSTRACT METHOD
    public abstract void showData();

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void deleteOrder() {
        this.status = null;
        this.id = -1;
        this.idcustomer = -1;
    }
}
