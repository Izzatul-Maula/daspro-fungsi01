import java.util.Scanner;

public class TeoriTugas206 {
     static Scanner sc = new Scanner(System.in);

    static String[] bacaNama(int n) {
        String[] nama = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nama mahasiswa ke-" + (i + 1) + " : ");
            nama[i] = sc.nextLine();
        }
        return nama;
    }

    static double[][] bacaNilai(int n, int k) {
        String[] komponen = {"Tugas", "Kuis", "Ujian Praktikum"};
        double[][] nilai = new double[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print("Nilai " + komponen[j] + " mahasiswa ke-" + (i + 1) + " : ");
                nilai[i][j] = sc.nextDouble();
            }
        }
        return nilai;
    }

    static double[] hitungNilaiAkhir(double[][] nilai) {
        double[] akhir = new double[nilai.length];
        for (int i = 0; i < nilai.length; i++) {
            akhir[i] = nilai[i][0] * 0.3
                     + nilai[i][1] * 0.3
                     + nilai[i][2] * 0.4;
        }
        return akhir;
    }

    static String tentukanStatus(double nilaiAkhir) {
        if (nilaiAkhir >= 70) {
            return "LULUS";
        } else {
            return "TIDAK LULUS";
        }
    }

    static int cariTertinggi(double[] akhir) {
        int nilaiMax = 0;
        for (int i = 1; i < akhir.length; i++) {
            if (akhir[i] > akhir[nilaiMax]) {
                nilaiMax = i;
            }
        }
        return nilaiMax;
    }

    static void tampilHasil(String[] nama, double[] akhir) {
        System.out.println("\n===== HASIL PENILAIAN =====");
        System.out.printf("%-20s%12s  %s%n", "Nama", "Nilai Akhir", "Status");
        for (int i = 0; i < akhir.length; i++) {
            String status = tentukanStatus(akhir[i]);
            System.out.printf("%-20s%12.2f  %s%n", nama[i], akhir[i], status);
        }
    }

    public static void main(String[] args) {
        String[] nama;
        double[][] nilai;
        double[] akhir;
        int n = 5, k = 3, nilaiMax;

        nama = bacaNama(n);
        nilai = bacaNilai(n, k);
        akhir = hitungNilaiAkhir(nilai);
        nilaiMax = cariTertinggi(akhir);
        tampilHasil(nama, akhir);

        System.out.println("\nNilai akhir tertinggi: " + nama[nilaiMax] + " (" + String.format("%.2f", akhir[nilaiMax]) + ")");
    }
}
