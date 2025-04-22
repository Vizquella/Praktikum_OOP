package servicejoki.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private int id;
    private String nama;
    private String noTelp;

    public Customer(int id, String nama, String noTelp) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public static void tambahCustomer(ArrayList<Customer> customers, Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("No Telepon: ");
        String noTelp = scanner.nextLine();

        customers.add(new Customer(id, nama, noTelp));
        System.out.println("Customer berhasil ditambahkan.");
    }

    public static void tambahCustomer(ArrayList<Customer> customers, Scanner scanner, String defaultTelp) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        customers.add(new Customer(id, nama, defaultTelp));
        System.out.println("Customer berhasil ditambahkan dengan default noTelp.");
    }

    public void showData() {
        System.out.println("ID: " + id + ", Nama: " + nama + ", No Telepon: " + noTelp);
    }
}
