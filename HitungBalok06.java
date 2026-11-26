import java.util.Scanner;

public class HitungBalok06 {

    public static int hitungLuas(int pjg, int lb){
        int Luas = pjg * lb;
        return Luas;
    }

    public static int hitunVolume (int tinggi, int a, int b){
        int volume = hitungLuas(a, b)*tinggi;
        return volume;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p,l,t,L,vol;

        System.out.print("Masukkan panjang: ");
        p = sc.nextInt();
        System.out.print("Masukkan Lebar: ");
        l = sc.nextInt();
        System.out.print("Masukkan tinggi: ");
        t = sc.nextInt();
        

        L = p * l;
        System.out.println("Luas persegi panjang adalah: " + L);
        vol = p * l * t;
        System.out.println("Volume balok adalah "+ vol);

        sc.close();
    }
    
}
