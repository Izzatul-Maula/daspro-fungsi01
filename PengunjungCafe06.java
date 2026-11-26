public class PengunjungCafe06 {
    public static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung: ");
        for (int i = 0; i < namaPengunjung.length; i++) {
            System.out.println("- " + namaPengunjung[i]);
        }
    }

    public static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        daftarPengunjung("Ali", "Budi", "Citra");
        daftarPengunjung("Andi");
        daftarPengunjung("Doni", "Eti", "Fahmi", "Galih");

        System.out.println();

        int total1 = hitungTotalBelanja(15000);
        int total3 = hitungTotalBelanja(15000, 20000, 12000);
        int total5 = hitungTotalBelanja(15000, 20000, 22000, 12000, 10000);

        System.out.println("Total belanja (1 item): Rp " + total1);
        System.out.println("Total belanja (3 item): Rp " + total3);
        System.out.println("Total belanja (5 item): Rp " + total5);
    }
}
