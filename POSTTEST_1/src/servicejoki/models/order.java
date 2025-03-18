package servicejoki.models;

import java.util.ArrayList;
import java.util.Scanner;

public class order {
    public int id;
    public int idcustomer;
    public String status;

    public order(int id, int idcustomer, String status) {
        this.id = id;
        this.idcustomer = idcustomer;
        this.status = status;
    }

    public static void tambahorder(ArrayList<order> orders, Scanner scanner) {
        System.out.print("ID order: ");
        int id = scanner.nextInt();
        System.out.print("ID customer: ");
        int idcustomer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();
        orders.add(new order(id, idcustomer, status));
        System.out.println("order berhasil ditambahkan.");
    }

    public static void updateorder(ArrayList<order> orders, Scanner scanner) {
        System.out.print("Masukkan ID order yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (order o : orders) {
            if (o.id == id) {
                System.out.print("Masukkan status baru: ");
                o.status = scanner.nextLine();
                System.out.println("order berhasil diperbarui.");
                return;
            }
        }
        System.out.println("order tidak ditemukan.");
    }

    public static void hapusorder(ArrayList<order> orders, Scanner scanner) {
        System.out.print("Masukkan ID order yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).id == id) {
                orders.remove(i);
                System.out.println("order berhasil dihapus.");
                return;
            }
        }
        System.out.println("order tidak ditemukan.");
    }
}
