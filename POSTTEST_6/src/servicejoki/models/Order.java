package servicejoki.models;

import servicejoki.interfaces.OrderService;
import java.util.ArrayList;
import java.util.Scanner;

public final class Order extends OrderBase implements OrderService {
    public static int jumlahOrder = 0;

    public Order(int id, int idcustomer, String status) {
        super(id, idcustomer, status);
        jumlahOrder++;
    }

    @Override
    public void showData() {
        System.out.println("ID order: " + id + ", ID customer: " + idcustomer + ", Status: " + status + ", Jenis Layanan: " + getJenisLayanan());
    }

    @Override
    public void prosesOrder() {
        System.out.println("Memproses order ID: " + id + "...");
    }

    @Override
    public void cetakNota() {
        System.out.println("Nota: Order #" + id + " untuk Customer #" + idcustomer + " dengan status: " + status);
    }

    public static void tambahOrder(ArrayList<Order> orders, Scanner scanner) {
        try {
            System.out.print("ID order: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("ID customer: ");
            int idcustomer = Integer.parseInt(scanner.nextLine());
            System.out.print("Status: ");
            String status = scanner.nextLine();

            Order newOrder = new Order(id, idcustomer, status);
            orders.add(newOrder);
            System.out.println("Order berhasil ditambahkan.");
            newOrder.prosesOrder();
        } catch (NumberFormatException e) {
            System.out.println("Input ID harus berupa angka.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public static void updateOrder(ArrayList<Order> orders, Scanner scanner) {
        try {
            System.out.print("Masukkan ID order yang ingin diupdate: ");
            int id = Integer.parseInt(scanner.nextLine());

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
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat update: " + e.getMessage());
        }
    }

    public static void hapusOrder(ArrayList<Order> orders, Scanner scanner) {
        try {
            System.out.print("Masukkan ID order yang ingin dihapus: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).id == id) {
                    orders.get(i).deleteOrder();
                    orders.remove(i);
                    System.out.println("Order berhasil dihapus.");
                    return;
                }
            }
            System.out.println("Order tidak ditemukan.");
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus: " + e.getMessage());
        }
    }
}
