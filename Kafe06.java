import java.util.Scanner;
public class Kafe06 {
    public static void menu(int jamKunjung) {

        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        } else {
            System.out.println("Jam kunjung tidak valid. Harap masukkan jam antara 14 hingga 16.");
            return;
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 12,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 15,000");
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String statusMember;
        boolean isMember;
        int jamKunjung;
        String namaPelanggan;

        System.out.print("Masukkan nama pelanggan: ");
        namaPelanggan = sc.nextLine();
        ubahNamaPelanggan(namaPelanggan);
        System.out.println("Di dalam main: " + namaPelanggan);

        System.out.print("Apakah Anda member? ");
        statusMember = sc.nextLine();
        isMember = statusMember.equalsIgnoreCase("true");

        System.out.print("Masukkan jam kunjung (14-16): ");
        jamKunjung = sc.nextInt();

        menu(jamKunjung);
    }

    public static void ubahNamaPelanggan(String namaPelanggan) {
    namaPelanggan = "Tamu";
    System.out.println("Di dalam fungsi: " + namaPelanggan);
    }

    
}