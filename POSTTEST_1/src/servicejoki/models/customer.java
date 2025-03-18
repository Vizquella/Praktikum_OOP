package servicejoki.models;

import java.util.ArrayList;
import java.util.Scanner;

public class customer {
    public int id;
    public String nama;
    public String noTelp;

    public customer(int id, String nama, String noTelp) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public static void tambahcustomer(ArrayList<customer> customers, Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("No Telepon: ");
        String noTelp = scanner.nextLine();
        customers.add(new customer(id, nama, noTelp));
        System.out.println("customer berhasil ditambahkan.");
    }
}