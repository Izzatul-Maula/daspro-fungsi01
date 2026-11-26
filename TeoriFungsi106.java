import java.util.Scanner;

public class TeoriFungsi106 {
    static Scanner sc = new Scanner(System.in);
    static int[][] inputPenjualan(int menu, int hari) {
        int[][] data = new int[menu][hari];
        for (int i = 0; i < menu; i++) {
            for (int j = 0; j < hari; j++) {
                System.out.print("Menu ke-" + (i + 1) + ", hari ke-" + (j + 1) + " : ");
                data[i][j] = sc.nextInt();
            }
        }
        return data;
    }

    static void tampilPenjualan(String[] namaMenu, int[][] data) {
        System.out.println("\n===== DATA PENJUALAN =====");
        System.out.printf("%-16s", "Menu");
        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%8s", "Hari " + (j + 1));
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-16s", namaMenu[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%8d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int[] hitungTotal(int[][] data) {
        int[] total = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            total[i] = 0;
            for (int j = 0; j < data[i].length; j++) {
                total[i] = total[i] + data[i][j];
            }
        }
        return total;
    }

    static int cariTerlaris(int[] total) {
        int menuTerlaris = 0;
        for (int i = 1; i < total.length; i++) {
            if (total[i] > total[menuTerlaris]) {
                menuTerlaris = i;
            }
        }
        return menuTerlaris;
    }

    static double[] hitungRataRata(int[] total, int hari) {
        double[] rata = new double[total.length];
        for (int i = 0; i < total.length; i++) {
            rata[i] = (double) total[i] / hari;
        }
        return rata;
    }

    public static void main(String[] args) {
        String[] namaMenu = {"Kopi", "Teh", "Es Kelapa Muda", "Roti Bakar", "Gorengan"};
        int[][] data;
        int[] total;
        double[] rata;
        int menuTerlaris;
        int menu = 5, hari = 7;

        data = inputPenjualan(menu, hari);
        tampilPenjualan(namaMenu, data);
        total = hitungTotal(data);
        menuTerlaris = cariTerlaris(total);
        rata = hitungRataRata(total, hari);

        System.out.println("\n===== TOTAL DAN RATA-RATA =====");
        System.out.printf("%-16s%8s%12s%n", "Menu", "Total", "Rata-rata");
        for (int i = 0; i < menu; i++) {
            System.out.printf("%-16s%8d%12.2f%n", namaMenu[i], total[i], rata[i]);
        }
        System.out.println("\nMenu terlaris: " + namaMenu[menuTerlaris]
                + " (total " + total[menuTerlaris] + ")");
    }
}
