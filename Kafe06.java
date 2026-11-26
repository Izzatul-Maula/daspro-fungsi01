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
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String statusMember;
        boolean isPromoValid;
        boolean isMember;
        int jamKunjung;
        String namaPelanggan;

        System.out.print("Masukkan nama pelanggan: ");
        namaPelanggan = sc.nextLine();
        ubahNamaPelanggan(namaPelanggan);
        System.out.println("Di dalam main: " + namaPelanggan);

        System.out.print("Apakah Anda member(true/false): ");
        statusMember = sc.nextLine();
        isMember = statusMember.equalsIgnoreCase("true");

        System.out.print("Masukkan jam kunjung (14-16): ");
        jamKunjung = sc.nextInt();



        menu(jamKunjung);
        int totalKeseluruhan = 0;
        String lanjut;

        do {
            System.out.print("\nMasukkan Nomor Menu yang ingin dipesan: ");
            int pilihanMenu = sc.nextInt();
            if (pilihanMenu >= 1 && pilihanMenu <= 6) {
                System.out.print("Masukkan jumlah item yang ingin dipesan: ");
                int banyakItem = sc.nextInt();

                int hargaTotal = HitungTotalHarga06(pilihanMenu, banyakItem);
                totalKeseluruhan += hargaTotal;
                System.out.println("Total harga untuk pesanan anda: Rp " + hargaTotal);
            } else {
                System.out.println("Pilihan menu tidak tersedia. Silakan pilih nomor menu antara 1 hingga 6.");
                
            }
            System.out.print("Apakah Anda ingin memesan lagi? (yes/no): ");
            lanjut = sc.next();

        } while (lanjut.equalsIgnoreCase("yes"));

        System.out.print("Masukkan kode promo:");
        String kodePromo = sc.next();

        double besarDiskon = hitungDiskon(totalKeseluruhan, kodePromo, isMember);
        double totalBayar = totalKeseluruhan - besarDiskon;

        System.out.println("\n===== RINCIAN PEMBAYARAN =====");
        System.out.println("Total harga pesanan : Rp " + totalKeseluruhan);
        System.out.println("Diskon              : " + besarDiskon);
        System.out.println("===============================");
        System.out.println("Total yang dibayar  : Rp " + totalBayar);
        

    }

    public static void ubahNamaPelanggan(String namaPelanggan) {
        namaPelanggan = "Tamu";
        System.out.println("Di dalam fungsi: " + namaPelanggan);
    }
    
    public static int HitungTotalHarga06(int pilihanMenu, int banyakItem) {
        int[] hargaItem = {15000, 20000, 22000, 12000, 10000, 18000}; 

        int hargaTotal =hargaItem[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static double hitungDiskon(int totalKeseluruhan, String kodePromo, boolean isMember) {
        double diskon = 0.0, diskonMember = 0.0;
        if (kodePromo.equals("DISKON50")) {
           diskon = (totalKeseluruhan * 50) / 100;
        } else if (kodePromo.equals("DISKON30")) {
            diskon = (totalKeseluruhan * 30) / 100;        
        } else {
            System.out.print("Kode promo tidak valid");
        }

        if (isMember) {
            System.out.println("Anda mendapat tambahan diskon");
            diskonMember = 0.10;
            diskon += diskonMember;
        }
        return diskon;
    }
}