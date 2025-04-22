package servicejoki.models;

import java.util.ArrayList;
import java.util.Scanner;

// FINAL CLAS
public final class Order extends OrderBase {

    public Order(int id, int idcustomer, String status) {
        super(id, idcustomer, status);
    }

    @Override
    public void showData() {
        System.out.println("ID order: " + id + ", ID customer: " + idcustomer + ", Status: " + status);
    }

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

    public static void updateOrder(ArrayList<Order> orders, Scanner scanner) {
        System.out.print("Masukkan ID order yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Order o : orders) {
            if (o.id == id) {
                System.out.print("Masukkan status baru: ");
                String newStatus = scanner.nextLine();
                o.updateStatus(newStatus);
                System.out.println("Order berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Order tidak ditemukan.");
    }

    public static void hapusOrder(ArrayList<Order> orders, Scanner scanner) {
        System.out.print("Masukkan ID order yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).id == id) {
                orders.get(i).deleteOrder();
                orders.remove(i);
                System.out.println("Order berhasil dihapus.");
                return;
            }
        }
        System.out.println("Order tidak ditemukan.");
    }
}
