package servicejoki;

import servicejoki.models.Customer;
import servicejoki.models.Order;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Customer");
                System.out.println("2. Tambah Order");
                System.out.println("3. Lihat Data");
                System.out.println("4. Update Order");
                System.out.println("5. Hapus Order");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        Customer.tambahCustomer(customers, scanner);
                        break;
                    case 2:
                        Order.tambahorder(orders, customers, scanner);
                        break;
                    case 3:
                        lihatData();
                        break;
                    case 4:
                        Order.updateOrder(orders, scanner);
                        break;
                    case 5:
                        Order.hapusOrder(orders, scanner);
                        break;
                    case 6:
                        System.out.println("Keluar dari program.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine();
            }
        }
    }

    static void lihatData() {
        System.out.println("\nData Customer:");
        for (Customer c : customers) {
            System.out.println("ID: " + c.getId() + ", Nama: " + c.getNama() + ", No Telepon: " + c.getNoTelp());
        }

        System.out.println("\nData Order:");
        for (Order o : orders) {
            System.out.println("ID Order: " + o.getId() + ", ID Customer: " + o.getIdCustomer() + ", Status: " + o.getStatus());
        }
    }
}
