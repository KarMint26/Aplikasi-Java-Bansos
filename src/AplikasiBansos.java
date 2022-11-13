import java.util.Random;
import java.util.Scanner;

public class AplikasiBansos {

    public static int penerimaBantuan = 100; // kuota penerima bantuan
    public static String[] minyakGoreng = new String[20]; // bahan pokok kuota yang akan dibagikan
    public static String[] gulaPasir = new String[30]; // bahan pokok kuota yang akan dibagikan
    public static String[] mieGoreng = new String[35]; // bahan pokok kuota yang akan dibagikan
    public static String[] tehHijau = new String[15]; // bahan pokok kuota yang akan dibagikna
    public static Scanner inputUser = new Scanner(System.in);

    public static String output(String index){
        System.out.print(index + " : ");
        return inputUser.nextLine();
    }

    public static void testInput(){
        String input = output("Masukkan Nama");
        System.out.println("Nama Anda Adalah " + input);
    }

    public static void pendaftarBansos(){
        while(true){
            System.out.println("     APLIKASI PENERIMA BANSOS");
            System.out.println("==================================");
            System.out.println("Isi Identitas Anda");
            String namaPendaftar = output("Masukkan Nama Anda");
            String umurPendaftar = output("Masukkan Umur Anda");
            String alamatPendaftar = output("Masukkan Alamat Anda");

            if (namaPendaftar.isBlank() || umurPendaftar.isBlank() || alamatPendaftar.isBlank()){
                System.out.println("Lengkapi Identitas Anda!!!");
                System.out.println();
                pendaftarBansos();
            } else {
                System.out.println("Nama anda adalah " + namaPendaftar + " | umur anda " + umurPendaftar + " Tahun | " + "Alamat anda di " + alamatPendaftar);
                Random randomNumber = new Random();
                int switchStatement = randomNumber.nextInt(4) + 1;
                tampilanDataBansos(switchStatement, namaPendaftar);
            }

            System.out.println();
        }
    }

    public static void tampilanDataBansos(int number, String namaPendaftar){
        switch (number){
            case 1 -> {
                inputDataKeArray(minyakGoreng, namaPendaftar);
                System.out.println("Anda Mendapatkan Sembako Berupa Minyak Goreng");
                tampilanSemuaDataBansos();
            }
            case 2 -> {
                inputDataKeArray(gulaPasir, namaPendaftar);
                System.out.println("Anda Mendapatkan Sembako Berupa Gula Pasir");
                tampilanSemuaDataBansos();
            }
            case 3 -> {
                inputDataKeArray(mieGoreng, namaPendaftar);
                System.out.println("Anda Mendapatkan Sembako Berupa Mie Goreng");
                tampilanSemuaDataBansos();
            }
            case 4 -> {
                inputDataKeArray(tehHijau, namaPendaftar);
                System.out.println("Anda Mendapatkan Sembako Berupa Teh Hijau");
                tampilanSemuaDataBansos();
            }
        }
    }

    public static void inputDataKeArray(String[] namaArray, String indexNama){
        for (int i = 0; i < namaArray.length; i++) {
            if (namaArray[i] == null){
                namaArray[i] = indexNama;
                break;
            }
        }
    }

    public static void tampilanSemuaDataBansos(){
        int sisaKuotaBansos = 0;
        int minyakGorengData = 0;
        for (int i = 0; i < minyakGoreng.length; i++) {
            if (minyakGoreng[i] != null){
                minyakGorengData++;
            }
        }
        int gulaPasirData = 0;
        for (int i = 0; i < gulaPasir.length; i++) {
            if (gulaPasir[i] != null){
                gulaPasirData++;
            }
        }
        int mieGorengData = 0;
        for (int i = 0; i < mieGoreng.length; i++) {
            if (mieGoreng[i] != null){
                mieGorengData++;
            }
        }
        int tehHijauData = 0;
        for (int i = 0; i < tehHijau.length; i++) {
            if (tehHijau[i] != null){
                tehHijauData++;
            }
        }
        sisaKuotaBansos = penerimaBantuan - minyakGorengData - gulaPasirData - mieGorengData - tehHijauData;
        System.out.println("\nSisa Kuota Sembako Minyak Goreng adalah " + minyakGorengData);
        System.out.println("Sisa Kuota Sembako Gula Pasir adalah " + gulaPasirData);
        System.out.println("Sisa Kuota Sembako Mie Goreng adalah " + mieGorengData);
        System.out.println("Sisa Kuota Sembako Teh Hijau adalah " + tehHijauData);
        System.out.println("Total Penerima Bansos adalah " + penerimaBantuan + " | dan Sisa Kuota Penerima Bansos adalah " + sisaKuotaBansos);
    }

    public static void main(String[] args) {
        pendaftarBansos();
    }

}

