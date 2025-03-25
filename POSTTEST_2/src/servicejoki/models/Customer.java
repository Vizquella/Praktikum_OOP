package servicejoki.models;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

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
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("No Telepon: ");
            String noTelp = scanner.nextLine();

            customers.add(new Customer(id, nama, noTelp));
            System.out.println("Customer berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! ID harus berupa angka.");
            scanner.nextLine();
        }
    }
}
