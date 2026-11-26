import java.util.Scanner;
public class BankSampah06 {
    public static double[] inputSetoran(Scanner sc, int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }
    public static void tampilSetoran(double[] setoran) {
        System.out.println("\n=== DAFTAR BERAT SETORAN NASABAH ===");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + "setoran" + setoran[i] + " kg");
        }
    }

    public static double totalSetoran(double[] setoran){
        double total = 0;
        for (double berat : setoran){
            total += berat;
        }
        return total;
    }

    public static double hitungSaldo(double beratSetoran, double hargaPerKg) {
        return beratSetoran * hargaPerKg;
    }

    public static int nasabahTerbanyak(double[] setoran){
        int setoranTerbanyak = 0;
        for (int i = 1; i < setoran.length; i++){
            if (setoran[i]> setoran[setoranTerbanyak]){
                setoranTerbanyak = i;
            }
        }
        return setoranTerbanyak;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hargaPerKg=3000;
        System.out.print("Masukkan jumlah nasab: ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran (sc, n);
        tampilSetoran(dataSetoran);

        double totalBerat = totalSetoran(dataSetoran);
        System.out.println("Total berat setoran semua nasabah: " + totalBerat + " Kg");

        System.out.print("\n===== SALDO NASABAH (Rp. 3000/Kg) =====");
        for (int i = 0; i < dataSetoran.length; i++){
            double saldo = hitungSaldo(dataSetoran[i], hargaPerKg);
            System.out.println("\nNasabah ke-" + (i + 1)+ ": Rp" +saldo);
        }

        int setoranTerbesar = nasabahTerbanyak(dataSetoran);
        System.out.println("\n==== NASABAH DENGAN SETORAN TERBANYAK =====");
        System.out.println("Nasabah ke-" + (setoranTerbesar) + " dengan setoran " + dataSetoran[setoranTerbesar] + " kg");
    }

}
