package servicejoki.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Order extends OrderBase {

    // Konstruktor yang memanggil konstruktor parent
    public Order(int id, int idcustomer, String status) {
        super(id, idcustomer, status);
    }

    // Implementasi metode abstrak showData
    @Override
    public void showData() {
        System.out.println("ID order: " + id + ", ID customer: " + idcustomer + ", Status: " + status);
    }

    // Method untuk menambah order
    public static void tambahOrder(ArrayList<Order> orders, Scanner scanner) {
        System.out.print("ID order: ");
        int id = scanner.nextInt();
        System.out.print("ID customer: ");
        int idcustomer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();

        orders.add(new Order(id, idcustomer, status));
        System.out.println("Order berhasil ditambahkan.");
    }

    // Method untuk update order berdasarkan ID
    public static void updateOrder(ArrayList<Order> orders, Scanner scanner) {
        System.out.print("Masukkan ID order yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Order o : orders) {
            if (o.getId() == id) {
                System.out.print("Masukkan status baru: ");
                String newStatus = scanner.nextLine();
                o.updateStatus(newStatus);
                System.out.println("Order berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Order dengan ID " + id + " tidak ditemukan.");
    }

    // Method untuk hapus order berdasarkan ID
    public static void hapusOrder(ArrayList<Order> orders, Scanner scanner) {
        System.out.print("Masukkan ID order yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.get(i).deleteOrder();
                orders.remove(i);
                System.out.println("Order berhasil dihapus.");
                return;
            }
        }
        System.out.println("Order dengan ID " + id + " tidak ditemukan.");
    }
}
