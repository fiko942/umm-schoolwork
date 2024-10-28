# Validator Library with Regex

Aplikasi ini adalah sebuah modul validasi sederhana yang dapat memverifikasi berbagai jenis input, seperti email, URL, teks alfanumerik, angka, port, IP, dan slug. Aplikasi ini terdiri dari dua kelas utama: `Main` dan `Validator`.

## Struktur Proyek

- **Main.java**: Kelas utama yang menjalankan berbagai tes validasi pada berbagai jenis input menggunakan kelas `Validator`.
- **Validator.java**: Kelas yang berisi metode untuk memvalidasi berbagai tipe input dengan menggunakan ekspresi reguler (regex).

## Validasi yang Didukung

Kelas `Validator` menyediakan metode berikut untuk memvalidasi input:
- **isEmail**: Memeriksa apakah input adalah email yang valid.
- **isUrl**: Memeriksa apakah input adalah URL yang valid.
- **isAlpha**: Memeriksa apakah input hanya berisi karakter alfabet (a-z, A-Z).
- **isNumeric**: Memeriksa apakah input hanya berisi angka (0-9).
- **isAlphanumeric**: Memeriksa apakah input hanya berisi karakter alfanumerik (a-z, A-Z, 0-9).
- **isPort**: Memeriksa apakah input adalah nomor port yang valid (0-65535).
- **isIP**: Memeriksa apakah input adalah alamat IP yang valid.
- **isSlug**: Memeriksa apakah input adalah slug yang valid (karakter huruf kecil dan angka, dipisahkan oleh tanda hubung `-`).

## Cara Kerja

Aplikasi ini menggunakan refleksi (`reflection`) untuk memanggil metode validasi secara dinamis. `Main.java` menjalankan berbagai metode validasi pada contoh input dan membandingkan hasilnya dengan hasil yang diharapkan (`expectedResult`).

Jika hasil validasi sesuai dengan yang diharapkan, maka tes dianggap **PASS**; jika tidak sesuai, maka **FAIL**.

## Struktur File

Proyek ini memiliki dua file utama:
  - Main.java
  - Validator.java


## Cara Menjalankan

1. **Clone atau Unduh Repository** ke komputer Anda.
2. Buka terminal atau command prompt, navigasikan ke direktori `com/fiko942/moduatasksatu`.
3. **Compile** kedua file Java dengan perintah:
   `bash
   javac Main.java Validator.java`

4. Jalankan aplikasi dengan perintah `java com.fiko942.moduatasksatu.Main
`

## Contoh Output
- isEmail: PASS - (test@example.com)
- isEmail: FAIL - (notanemail)
- isUrl: PASS - (https://example.com)
- isUrl: FAIL - (invalid-url)

Kontak: fiko@streampeg.com