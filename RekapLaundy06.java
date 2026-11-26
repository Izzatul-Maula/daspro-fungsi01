import java.util.Scanner;
public class RekapLaundy06 {
    public static void inputInfoLayanan(Scanner sc, String[] layanan, int[] hargaPerKg) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("\nLayanan ke-" + (i + 1));
            System.out.print("  Nama layanan : ");
            layanan[i] = sc.nextLine();
            System.out.print("  Harga per kg : ");
            hargaPerKg[i] = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void inputDataBerat(Scanner sc, int[][] data, String[] layanan, int jumlahHari) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("\nInput berat cucian untuk layanan: " + layanan[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("  Hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static void tampilkanTabel(String[] layanan, int[] hargaPerKg, int[][] data, int jumlahHari) {
        System.out.println("\n=== TABEL REKAP BERAT CUCIAN (KG) ===");
        System.out.printf("%-18s %-12s", "Layanan", "Harga/kg");
        for (int j = 0; j < jumlahHari; j++) {
            System.out.printf(" %-10s", "Hari ke-" + (j + 1));
        }
        System.out.println();

        int panjangGaris = 32 + (jumlahHari * 11);
        for (int k = 0; k < panjangGaris; k++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-18s Rp%-10d", layanan[i], hargaPerKg[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.printf(" %-10d", data[i][j]);
            }
            System.out.println();
        }
    }

    public static int totalPerLayanan(int[][] data, int barisanLayanan) {
        int total = 0;
        for (int j = 0; j < data[barisanLayanan].length; j++) {
            total += data[barisanLayanan][j];
        }
        return total;
    }

    public static void tampilkanLayananTerbanyak(String[] layanan, int[][] data) {
        int layananMax = 0;
        int maxBerat = totalPerLayanan(data, 0);

        for (int i = 1; i < layanan.length; i++) {
            int totalSaatIni = totalPerLayanan(data, i);
            if (totalSaatIni > maxBerat) {
                maxBerat = totalSaatIni;
                layananMax = i;
            }
        }
        System.out.println("\n=== LAYANAN DENGAN BERAT CUCIAN TERTINGGI ===");
        System.out.println("Layanan : " + layanan[layananMax]);
        System.out.println("Total   : " + maxBerat + " kg");
    }

    public static int hariTersibuk(int[][] data) {
        int jumlahHari = data[0].length;
        int hariMax = 0;
        int maxBeratHari = 0;

        for (int j = 0; j < jumlahHari; j++) {
            int totalHariIni = 0;
            for (int i = 0; i < data.length; i++) {
                totalHariIni += data[i][j];
            }

            if (j == 0 || totalHariIni > maxBeratHari) {
                maxBeratHari = totalHariIni;
                hariMax = j;
            }
        }
        return hariMax;
    }

    public static void hitungPendapatan(String[] layanan, int[] hargaPerKg, int[][] data, int jumlahHari) {
        int totalPendapatan = 0;
        System.out.println("\n=== RINCIAN PENDAPATAN (" + jumlahHari + " HARI) ===");
        for (int i = 0; i < layanan.length; i++) {
            int berat = totalPerLayanan(data, i);
            int pendapatanLayanan = berat * hargaPerKg[i];
            totalPendapatan += pendapatanLayanan;
            System.out.printf("%-18s : %3d kg x Rp%-7d = Rp%,d%n",
                    layanan[i], berat, hargaPerKg[i], pendapatanLayanan);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Total Pendapatan %d Hari : Rp%,d%n", jumlahHari, totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah layanan : ");
        int jumlahLayanan = sc.nextInt();

        System.out.print("Masukkan jumlah hari    : ");
        int jumlahHari = sc.nextInt();
        sc.nextLine();

        String[] layanan = new String[jumlahLayanan];
        int[] hargaPerKg = new int[jumlahLayanan];
        int[][] dataBerat = new int[jumlahLayanan][jumlahHari];

        inputInfoLayanan(sc, layanan, hargaPerKg);
        inputDataBerat(sc, dataBerat, layanan, jumlahHari);

        tampilkanTabel(layanan, hargaPerKg, dataBerat, jumlahHari);

        System.out.println("\n=== TOTAL BERAT PER LAYANAN (" + jumlahHari + " HARI) ===");
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println(layanan[i] + " : " + totalPerLayanan(dataBerat, i) + " kg");
        }

        tampilkanLayananTerbanyak(layanan, dataBerat);

        int idxSibuk = hariTersibuk(dataBerat);
        int totalHariSibuk = 0;
        for (int i = 0; i < jumlahLayanan; i++) {
            totalHariSibuk += dataBerat[i][idxSibuk];
        }
        System.out.println("\n=== HARI TERSIBUK ===");
        System.out.println("Hari    : Hari ke-" + (idxSibuk + 1) + " (indeks " + idxSibuk + ")");
        System.out.println("Total   : " + totalHariSibuk + " kg");

        hitungPendapatan(layanan, hargaPerKg, dataBerat, jumlahHari);
    }
}
