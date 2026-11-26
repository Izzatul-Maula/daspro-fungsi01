import java.util.Scanner;
public class RekapLaundy06 {
static String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
    public static void inputDataBerat(Scanner sc, int[][] data, String[] layanan) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Input berat cucian untuk layanan: " + layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Hari " + namaHari[j] + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static void tampilkanTabel(String[] layanan, int[] hargaPerKg, int[][] data) {
        System.out.println("\n=== TABEL REKAP BERAT CUCIAN (KG) ===");
        System.out.printf("%-15s %-12s", "Layanan", "Harga/kg");
        for (String hari : namaHari) {
            System.out.printf(" %-8s", hari);
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s Rp%-10d", layanan[i], hargaPerKg[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf(" %-8d", data[i][j]);
            }
            System.out.println();
        }
    }

    public static int totalPerLayanan(int[][] data, int barisLayanan) {
        int total = 0;
        for (int j = 0; j < data[barisLayanan].length; j++) {
            total += data[barisLayanan][j];
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
        int HariMax = 0;
        int maxBeratHari = 0;

        for (int j = 0; j < jumlahHari; j++) {
            int totalHariIni = 0;
            for (int i = 0; i < data.length; i++) {
                totalHariIni += data[i][j];
            }

            if (j == 0 || totalHariIni > maxBeratHari) {
                maxBeratHari = totalHariIni;
                HariMax = j;
            }
        }
        return HariMax;
    }

    public static void hitungPendapatan(String[] layanan, int[] hargaPerKg, int[][] data) {
        int totalPendapatan = 0;
        System.out.println("\n=== RINCIAN PENDAPATAN (6 HARI) ===");
        for (int i = 0; i < layanan.length; i++) {
            int berat = totalPerLayanan(data, i);
            int pendapatanLayanan = berat * hargaPerKg[i];
            totalPendapatan += pendapatanLayanan;
            System.out.printf("%-15s : %3d kg x Rp%-6d = Rp%,d%n",
            layanan[i], berat, hargaPerKg[i], pendapatanLayanan);
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total Pendapatan 6 Hari : Rp%,d%n", totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] hargaPerKg = {6000, 8000, 5000, 12000};
        int[][] dataBerat = {
            {12, 15, 10, 18, 20, 25},
            {20, 18, 22, 15, 30, 35},
            {8,  5,  10, 7,  6,  12},
            {3,  6,  2,  5,  8,  10}
        };

        tampilkanTabel(layanan, hargaPerKg, dataBerat);

        System.out.println("\n=== TOTAL BERAT PER LAYANAN (6 HARI) ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + " : " + totalPerLayanan(dataBerat, i) + " kg");
        }

        tampilkanLayananTerbanyak(layanan, dataBerat);

        int idxSibuk = hariTersibuk(dataBerat);
        int totalHariSibuk = 0;
        for (int i = 0; i < dataBerat.length; i++) {
            totalHariSibuk += dataBerat[i][idxSibuk];
        }
        System.out.println("\n=== HARI TERSIBUK ===");
        System.out.println("Hari    : " + namaHari[idxSibuk] + " (indeks " + idxSibuk + ")");
        System.out.println("Total   : " + totalHariSibuk + " kg");

        hitungPendapatan(layanan, hargaPerKg, dataBerat);

        sc.close();
    }
}
