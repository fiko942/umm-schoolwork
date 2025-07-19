
# PROJECT IMPLEMENTASI AI MENGENALI JENIS KELAMIN BERDASARKAN WAJAH

📍 Tugas Akhir - Mata Kuliah Kecerdasan Buatan  
Universitas Muhammadiyah Malang  
Dibimbing oleh: Muhammad Ilham Perdana, S.Tr.T., M.T.

## 👨‍💻 Disusun Oleh
| Nama                   | NIM               |
|------------------------|------------------|
| Akhmad Zamri Ardani    | 202310370311406  |
| Wiji Fiko Teren        | 202310370311437  |
| Alfito Afdhan Nugraha  | 202310370311415  |

---

## 📌 Deskripsi Proyek

Proyek ini merupakan implementasi model Artificial Intelligence (AI) menggunakan metode Computer Vision dan Deep Learning untuk mengenali jenis kelamin seseorang berdasarkan gambar wajah.

Model ini dikembangkan dan dilatih menggunakan dataset UTKFace, yaitu kumpulan gambar wajah manusia yang dilabeli usia, jenis kelamin, dan ras. Dataset ini bersumber dari Kaggle:  
🔗 https://www.kaggle.com/datasets/jangedoo/utkface-new

Selain itu, pendekatan preprocessing, pemrosesan gambar, hingga pembuatan dan pelatihan model CNN pada proyek ini sebagian besar mengacu langsung dan mereplikasi hasil serta struktur kode dari repositori resmi:  
🔗 https://www.kaggle.com/datasets/jangedoo/utkface-new/code

Dengan pendekatan yang identik, hasil model dalam proyek ini juga menunjukkan performa akurasi dan loss yang sangat mirip dengan yang diperoleh di referensi aslinya.

---

## 🧠 Tujuan

Membangun sistem AI berbasis deep learning untuk mengklasifikasikan jenis kelamin dari citra wajah secara otomatis.

---

## 🧰 Teknologi & Library yang Digunakan

- Python 3.x
- NumPy, Pandas
- OpenCV (Computer Vision)
- Matplotlib, Seaborn (Visualisasi)
- TensorFlow / Keras (Pelatihan CNN)
- Scikit-learn (Evaluasi)
- KaggleHub (Pengambilan Dataset)

---

## 🗃️ Dataset

- Nama: UTKFace
- Format file: `[age]_[gender]_[race]_[date&time].jpg`
- Label penting:
  - `age`: usia (0–116)
  - `gender`: jenis kelamin (0 = Male, 1 = Female)

Contoh nama file: `24_1_2_20170116174525125.jpg.chip.jpg`

---

## 🔄 Alur Program

1. Unduh dataset dari Kaggle.
2. Proses dataset:
   - Ekstrak label dari nama file
   - Konversi gambar ke grayscale
   - Resize ke 128x128
   - Normalisasi pixel
3. Analisis eksploratif (EDA)
4. Arsitektur CNN sederhana (mirip referensi UTKFace Code)
5. Pelatihan dan validasi model
6. Visualisasi hasil evaluasi model

---

## 🎯 Hasil

Model CNN yang dibangun mampu mengklasifikasikan jenis kelamin berdasarkan wajah dengan akurasi tinggi.  
Hasil pelatihan dan evaluasi sangat presisi dan mendekati performa model pada referensi aslinya dari UTKFace Kaggle Code.

---

## 📁 Struktur Folder

```
project-root/
├── dataset/                 # berisi file gambar UTKFace
│   └── *.jpg
├── model/                   # menyimpan model terlatih
│   └── best_model.h5
├── src/                     # kode sumber program
│   ├── preprocessing.py
│   ├── train_model.py
│   └── evaluate.py
├── laporan_tugas_akhir.pdf  # dokumen laporan akhir
└── README.md
```

---

## 📚 Referensi

- Dataset UTKFace — https://www.kaggle.com/datasets/jangedoo/utkface-new  
- Kode referensi resmi — https://www.kaggle.com/datasets/jangedoo/utkface-new/code  
- Dokumentasi Keras dan TensorFlow  
- Paper referensi CNN: LeNet-5, VGGNet

---
