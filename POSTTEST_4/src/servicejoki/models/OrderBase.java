package servicejoki.models;

public abstract class OrderBase {
    protected int id;
    protected int idcustomer;
    protected String status;

    // Konstruktor
    public OrderBase(int id, int idcustomer, String status) {
        this.id = id;
        this.idcustomer = idcustomer;
        this.status = status;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idcustomer;
    }

    public void setIdCustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method abstrak untuk menampilkan data, harus diimplementasikan di kelas turunan
    public abstract void showData();

    // Method untuk memperbarui status order
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Method untuk menghapus order
    public void deleteOrder() {
        this.status = null;
        this.id = -1;
        this.idcustomer = -1;
    }
}
