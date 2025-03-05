import java.util.Scanner;

// Enum untuk kategori buku
enum Kategori {
    NOVEL, BIOGRAFI, TEKNOLOGI, ANAK;
}

// Class generics Buku dengan dua parameter generics
class Buku<T, U> {
    private T judul;
    private U pengarang;
    private double harga;
    private Kategori kategori;

    // Konstruktor
    public Buku(T judul, U pengarang, double harga, Kategori kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.harga = harga;
        this.kategori = kategori;
    }

    // Method get untuk mengambil data
    public T getJudul() {
        return judul;
    }

    public U getPengarang() {
        return pengarang;
    }

    public double getHarga() {
        return harga;
    }

    public Kategori getKategori() {
        return kategori;
    }

    // Method untuk menampilkan informasi buku
    public void displayInfo() {
        System.out.println("\nInformasi Buku:");
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Harga: " + harga);
        System.out.println("Kategori: " + kategori);
    }

    // Method get untuk mengambil data berdasarkan nama atribut
    public Object get(String attributeName) {
        switch (attributeName.toLowerCase()) {
            case "judul":
                return getJudul();
            case "pengarang":
                return getPengarang();
            case "harga":
                return getHarga();
            case "kategori":
                return getKategori();
            default:
                return null;
        }
    }
}

// Main class untuk menjalankan program
public class GenericBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input data buku
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();
        
        System.out.print("Masukkan Nama Pengarang: ");
        String pengarang = scanner.nextLine();
        
        System.out.print("Masukkan Harga: ");
        double harga = scanner.nextDouble();
        
        // Menampilkan kategori buku
        System.out.println("Pilih Kategori Buku:");
        for (int i = 0; i < Kategori.values().length; i++) {
            System.out.println(i + ". " + Kategori.values()[i]);
        }
        
        System.out.print("Masukkan pilihan: ");
        int kategoriIndex = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        
        Kategori kategori = Kategori.values()[kategoriIndex];
        
        // Membuat objek Buku
        Buku<String, String> buku = new Buku<>(judul, pengarang, harga, kategori);
        
        // Menampilkan informasi buku
        buku.displayInfo();
        
        scanner.close();
    }
}
