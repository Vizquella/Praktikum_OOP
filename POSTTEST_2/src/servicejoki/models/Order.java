package servicejoki.models;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Order {
    private static int nextId = 1;
    private int id;
    private int idCustomer;
    private String status;

    public Order(int idCustomer, String status) {
        this.id = nextId++;
        this.idCustomer = idCustomer;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void tambahorder(ArrayList<Order> orders, ArrayList<Customer> customers, Scanner scanner) {
        System.out.print("ID customer: ");
        int idcustomer = scanner.nextInt();
        scanner.nextLine();
        
        boolean customerExists = false;
        for (Customer c : customers) {
            if (c.getId() == idcustomer) {
                customerExists = true;
                break;
            }
        }

        if (!customerExists) {
            System.out.println("ID customer tidak ditemukan.");
            return;
        }

        System.out.print("Status: ");
        String status = scanner.nextLine();
        orders.add(new Order(idcustomer, status));
        System.out.println("Order berhasil ditambahkan.");
    }

    public static void updateOrder(ArrayList<Order> orders, Scanner scanner) {
        try {
            System.out.print("Masukkan ID order yang ingin diupdate: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Order o : orders) {
                if (o.getId() == id) {
                    System.out.print("Masukkan status baru: ");
                    o.setStatus(scanner.nextLine());
                    System.out.println("Order berhasil diperbarui.");
                    return;
                }
            }
            System.out.println("Order tidak ditemukan.");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Harap masukkan angka.");
            scanner.nextLine();
        }
    }

    public static void hapusOrder(ArrayList<Order> orders, Scanner scanner) {
        try {
            System.out.print("Masukkan ID order yang ingin dihapus: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getId() == id) {
                    orders.remove(i);
                    System.out.println("Order berhasil dihapus.");
                    return;
                }
            }
            System.out.println("Order tidak ditemukan.");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Harap masukkan angka.");
            scanner.nextLine();
        }
    }
}
