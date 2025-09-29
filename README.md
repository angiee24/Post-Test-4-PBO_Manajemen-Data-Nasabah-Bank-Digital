# Post-Test-4-PBO_Manajemen-Data-Nasabah-Bank-Digital

# Post Test 4 PBO 
# Manajemen Data Nasabah Bank Digital

Angela Caroline Budiman (2409116008)

Sistem Informasi A'2024

# Deskripsi
Program ini merupakan sebuah program sederhana CRUD dengan tema Manajemen Data Nasabah Bank Digital. Melalui menu konsol yang interaktif, pengguna dapat melakukan operasi data nasabah secara lengkap, mulai dari menambah (Create), melihat (Read), mengubah (Update), hingga menghapus (Delete) data. Selain itu, program ini juga dilengkapi dengan fitur transaksi dasar seperti setor tunai, tarik tunai, dan transfer dana antar rekening, sehingga dapat menjadi simulasi sederhana dalam pengelolaan dan manajemen data nasabah bank secara digital.

# Alur Program
Program ini berjalan dengan menampilkan sembilan menu utama kepada pengguna. Opsi 1 sampai 4 digunakan untuk mengelola data dasar nasabah (tambah, lihat, ubah, hapus). Menu 5 membuka sub-menu transaksi finansial, menu 6 dan 7 digunakan untuk melihat riwayat rekening dan mencari nasabah, menu 8 dipakai untuk memberikan bonus nasabah prioritas, dan menu 9 dipakai untuk keluar.

Setiap input yang bukan merupakan angka 1–9 akan dianggap tidak valid, lalu program secara otomatis mengarahkan kembali pengguna ke menu utama.

### Penjelasan Alur per Fitur
1. Tambah Nasabah (Create)
Pengguna mendaftarkan nasabah baru dengan nama dan setoran awal. Sistem akan membuatkan nomor rekening unik secara otomatis.
2. Tampilkan Nasabah (Read)
Menampilkan daftar lengkap seluruh data nasabah yang tersimpan.
3. Ubah Nama Nasabah (Update)
Pengguna dapat mengubah nama nasabah yang sudah ada dengan mencarinya berdasarkan nomor rekening.
4. Hapus Nasabah (Delete)
Menghapus data nasabah dari sistem berdasarkan nomor rekening. Program akan memberi notifikasi jika rekening tidak ditemukan.
5. Lakukan Transaksi
Membuka sub-menu untuk melakukan transaksi finansial, yang meliputi:
- Setor Tunai: Menambahkan dana ke rekening.
- Tarik Tunai: Menarik dana dari rekening, dengan validasi saldo minimum.
- Transfer Dana: Memindahkan dana antar rekening, dengan validasi saldo dan biaya administrasi.
- Kembali Ke Menu Utama: Opsi untuk keluar dari sub-menu dan kembali ke menu utama.
6. Lihat Mutasi Rekening
Menampilkan seluruh riwayat transaksi (mutasi) dari sebuah rekening berdasarkan nomornya.
7. Cari Nasabah (Search)
Mencari data nasabah secara fleksibel menggunakan input nama atau nomor rekening.
8. Bonus Untuk Nasabah Prioritas
Menambahkan bonus 2% dari saldo hanya untuk nasabah prioritas, lalu menampilkan besarnya bonus dan saldo terbaru sekaligus mencatatnya di mutasi rekening.
9. Keluar (Exit)
Menghentikan dan keluar dari program.

## Struktur Project

<img width="411" height="224" alt="image" src="https://github.com/user-attachments/assets/01459cc6-ca82-4594-8004-51885696b819" />

1. model
- Berisi class Nasabah (superclass), serta subclass NasabahBiasa dan NasabahPrioritas.
- Menunjukkan atribut (nomorRekening, nama, saldo, mutasiRekening) dengan access modifier private.
- Menerapkan constructor untuk inisialisasi data nasabah serta getter & setter untuk akses data (penerapan encapsulation).
- Subclass menerapkan inheritance dari Nasabah dan melakukan overriding pada method tampilkanInfo().
- Fungsinya: merepresentasikan objek nasabah dalam sistem sesuai tipe (Biasa/Prioritas).

2. service
- Berisi class BankService.
- Menyimpan seluruh logika CRUD (Create, Read, Update, Delete) serta fitur transaksi (Setor, Tarik, Transfer), mutasi rekening, dan pencarian data.
- Mengatur alur program, termasuk validasi input nominal dan saldo minimum.
- Fungsinya: sebagai controller yang menghubungkan data (model) dengan tampilan (view).

3. view
- Berisi class Main.
- Menyediakan menu interaktif berupa pilihan angka 1–8 yang dapat diakses oleh pengguna.
- Menangani input user (validasi angka atau non-angka) dan memanggil method dari BankService.
- Fungsinya: menjadi antarmuka pengguna (UI) berbasis console untuk menjalankan program.

## Penerapan OOP
- **Encapsulation**  
  Semua atribut Nasabah bersifat private dengan akses melalui **getter & setter**.
- **Inheritance**  
  NasabahBiasa dan NasabahPrioritas merupakan subclass dari Nasabah.
- **Overriding**  
  Method tampilkanInfo() dioverride di setiap subclass untuk menampilkan label berbeda sesuai tipe nasabah.

# Output Program/Dokumentasi Program
## Menu Program

<img width="345" height="228" alt="image" src="https://github.com/user-attachments/assets/d07e6d64-e02d-4c0a-abf2-5c8f99967316" />

Program ini berjalan dengan menampilkan delapan menu utama kepada pengguna. Opsi 1 sampai 4 digunakan untuk mengelola data dasar nasabah (tambah, lihat, ubah, hapus). Menu 5 membuka sub-menu untuk transaksi finansial, sementara menu 6 dan 7 berfungsi untuk melihat riwayat rekening dan mencari data nasabah. Program akan selalu kembali ke tampilan menu ini setelah setiap tugas selesai, hingga pengguna memilih menu 8 untuk keluar.


<img width="372" height="322" alt="image" src="https://github.com/user-attachments/assets/d1b7dc74-b162-48cc-855a-b6aea122cf79" />

Setiap input yang salah akan dianggap tidak valid untuk mencegah error ketika pengguna salah memasukkan data. Jika pengguna mengetik angka di luar rentang menu (misalnya 9), sistem akan menampilkan pesan "Pilihan harus antara 1 dan 8", sedangkan jika memasukkan karakter non-angka (misalnya a), sistem akan menampilkan pesan "Input tidak valid, masukkan angka!". Dengan validasi ini, program menjadi lebih aman, stabil, dan tetap berjalan meskipun terjadi kesalahan input dari pengguna.

## Menu Create (Tambah Nasabah)

<img width="478" height="194" alt="image" src="https://github.com/user-attachments/assets/c8b25519-8f9b-4a1f-b7a1-9fde91c32af6" />

Output tersebut menunjukkan interaksi saat mencoba menambahkan nasabah baru. Program meminta nama dan setoran awal. Ketika pengguna memasukkan 10000, program menolaknya karena di bawah setoran minimum Rp50.000, lalu meminta input ulang. Saat pengguna salah memasukkan sepuluh, program mendeteksi input non-angka dan menampilkan pesan kesalahan. Akhirnya, ketika pengguna memasukkan 50000, program menerima nilai tersebut, berhasil membuat nasabah bernama Angie, dan memberikan nomor rekening baru 2025003 sebagai konfirmasi.

## Menu Read (Tampilkan Nasabah)

<img width="718" height="142" alt="image" src="https://github.com/user-attachments/assets/718e1f77-1b43-4ee6-a69a-d2251e7e78cb" />

Pada menu **Tampilkan Nasabah**, program akan menampilkan seluruh data nasabah yang tersimpan dalam daftar, meliputi nomor rekening, nama, dan saldo masing-masing nasabah secara berurutan (contoh: REK2025001 atas nama Budi Santoso, REK2025002 atas nama Citra Lestari, dan REK2025003 atas nama Angie). Setelah data ditampilkan, pengguna diminta menekan Enter untuk kembali ke menu utama.


## Menu Update (Ubah Nama Nasabah)

<img width="558" height="163" alt="image" src="https://github.com/user-attachments/assets/bda2bc18-5475-4f47-ad26-1a94f978a8b5" />

Pada menu **Ubah Nama Nasabah**, pengguna diminta memasukkan nomor rekening nasabah yang datanya akan diperbarui. Program kemudian menampilkan nama saat ini dari nasabah tersebut, lalu meminta input nama baru. Setelah pengguna memasukkan nama baru (contoh: dari *Angie* menjadi *Angela*), sistem akan langsung memperbarui data dan menampilkan pesan berhasil, kemudian pengguna diarahkan untuk menekan Enter agar kembali ke menu utama.

<img width="465" height="122" alt="image" src="https://github.com/user-attachments/assets/28dab0c6-0f13-4217-9e51-ac2acec2c8d2" />

Pada menu **Ubah Nama Nasabah**, jika pengguna memasukkan nomor rekening yang tidak terdaftar dalam sistem (contoh: `12`), maka program akan menampilkan pesan **"GAGAL: Rekening tidak ditemukan."**. Setelah itu, pengguna diarahkan untuk menekan Enter agar kembali ke menu utama tanpa ada perubahan data nasabah.


## Menu Delete (Hapus Nasabah)

<img width="556" height="115" alt="image" src="https://github.com/user-attachments/assets/b1df4380-413b-4bef-8e9f-dca97dedfe8a" />

Pada menu **Hapus Nasabah**, pengguna diminta memasukkan nomor rekening yang ingin dihapus. Jika nomor rekening tersebut ditemukan dalam daftar (contoh: `REK2025003`), maka program akan menghapus data nasabah yang bersangkutan dari sistem dan menampilkan pesan **"BERHASIL: Nasabah telah dihapus."**. Setelah itu, pengguna diarahkan untuk menekan Enter agar kembali ke menu utama.


<img width="483" height="88" alt="image" src="https://github.com/user-attachments/assets/2b014186-3d09-4ff4-867c-61a940c8a414" />

Pada menu Hapus Nasabah, jika pengguna memasukkan nomor rekening yang tidak terdaftar dalam sistem (contoh: 123), maka program akan menampilkan pesan "GAGAL: Rekening tidak ditemukan.". Setelah itu, pengguna diarahkan untuk menekan Enter agar kembali ke menu utama tanpa ada data yang terhapus

## Menu Transaksi (Lakukan Transaksi)

<img width="323" height="136" alt="image" src="https://github.com/user-attachments/assets/b09d8b3d-678d-426c-8b99-d216fccd87fe" />

Ketika pengguna memilih menu "Lakukan Transaksi" dari menu utama, program akan menampilkan sub-menu khusus transaksi seperti yang terlihat pada gambar. Di sini, pengguna diberikan pilihan untuk melakukan Setor Tunai (1), Tarik Tunai (2), atau Transfer Dana (3). Opsi nomor 4 disediakan agar pengguna dapat kembali ke menu utama jika tidak ingin melanjutkan transaksi.

### Setor Tunai
<img width="392" height="106" alt="image" src="https://github.com/user-attachments/assets/242fdc7b-e5f1-4c5d-aea8-a893fb199e7c" />

Pada menu Setor Tunai, pengguna diminta memasukkan nomor rekening tujuan (contoh: REK2025001) diikuti dengan jumlah nominal yang akan disetor. Jika rekening ditemukan dan nominal valid, program akan menambahkan jumlah tersebut ke saldo nasabah dan mencatatnya di mutasi. Sebagai konfirmasi, sistem akan menampilkan pesan "BERHASIL" beserta saldo terbaru dari rekening tersebut.

<img width="442" height="112" alt="image" src="https://github.com/user-attachments/assets/f5437961-0fbc-4c06-ac17-afc054edc357" />

Alur ini menunjukkan penanganan kesalahan pada menu Setor Tunai. Ketika pengguna memasukkan nomor rekening yang tidak ada dalam sistem (contoh: 20), program akan melakukan pencarian dan gagal menemukan data yang cocok. Akibatnya, sistem akan membatalkan transaksi dan menampilkan pesan "GAGAL: Rekening tidak ditemukan"

<img width="389" height="266" alt="image" src="https://github.com/user-attachments/assets/a2d92312-78fc-4281-bc8f-41382681fd83" />

Setiap input nominal yang bukan berupa angka akan dianggap tidak valid untuk mencegah error saat transaksi. Misalnya pada menu Setor Tunai, jika pengguna memasukkan teks seperti "seratus", sistem akan menampilkan pesan "Input tidak valid, masukkan angka!" dan meminta pengguna mengulang dengan angka yang benar. Setelah pengguna mengetik jumlah yang valid (contoh: 100000), transaksi akan diproses dan saldo terbaru akan ditampilkan.

### Tarik Tunai
<img width="680" height="150" alt="image" src="https://github.com/user-attachments/assets/6f879db1-a207-4212-be14-4be0992fc92b" />

Pada menu Tarik Tunai, alur ini menunjukkan validasi saldo minimum. Pengguna memasukkan nomor rekening yang valid (REK2025001) dan mencoba menarik nominal yang sangat besar (200000000). Program kemudian memeriksa apakah sisa saldo setelah penarikan akan lebih besar atau sama dengan batas saldo minimum yang telah ditentukan. Karena kondisi tersebut tidak terpenuhi, transaksi dibatalkan dan sistem menampilkan pesan "GAGAL: Saldo tidak mencukupi atau akan kurang dari saldo minimum"

<img width="434" height="138" alt="image" src="https://github.com/user-attachments/assets/8f2f7475-2bbb-4462-9bae-42409dbffade" />

Alur ini menunjukkan proses transaksi Tarik Tunai yang berhasil. Setelah memilih menu Tarik Tunai, pengguna memasukkan nomor rekening yang valid (REK2025001) dan jumlah penarikan (100000). Program memvalidasi bahwa saldo nasabah mencukupi untuk penarikan tersebut dan sisa saldonya tidak akan kurang dari batas minimum. Karena semua syarat terpenuhi, saldo nasabah dikurangi dan sistem menampilkan pesan "BERHASIL" beserta informasi sisa saldo yang terbaru.

<img width="437" height="115" alt="image" src="https://github.com/user-attachments/assets/40b63c50-e20b-4594-b05e-e2b360f93114" />

Alur ini menunjukkan penanganan kesalahan ketika pengguna mencoba melakukan penarikan tunai dari rekening yang tidak ada. Pengguna memasukkan nomor rekening yang tidak terdaftar di sistem (contoh: 1000). Program kemudian mencari data tersebut namun tidak berhasil menemukannya, sehingga transaksi dibatalkan dan sistem menampilkan pesan "GAGAL: Rekening tidak ditemukan"

<img width="394" height="263" alt="image" src="https://github.com/user-attachments/assets/78259cdf-9f3a-469b-92d2-9a37286fd92e" />

Setiap input nominal yang tidak sesuai format angka akan dianggap tidak valid untuk mencegah error pada proses transaksi. Misalnya pada menu Tarik Tunai, jika pengguna memasukkan teks seperti "seratus", sistem akan menampilkan pesan "Input tidak valid, masukkan angka!" dan meminta pengguna mengulang input. Setelah pengguna mengetik jumlah yang benar (contoh: 100000), transaksi akan berhasil diproses dan sistem menampilkan saldo terbaru dari rekening tersebut.

### Transfer Dana 
<img width="460" height="172" alt="image" src="https://github.com/user-attachments/assets/a50a426f-9274-4851-a733-c609c735ccd8" />

Alur ini menunjukkan proses Transfer Dana yang berhasil antar dua rekening berbeda. Pengguna memasukkan nomor rekening pengirim (REK2025001), nomor rekening penerima (REK2025002), dan jumlah yang akan ditransfer (100000). Program memvalidasi bahwa semua rekening valid dan saldo pengirim mencukupi untuk jumlah transfer ditambah biaya administrasi. Setelah semua syarat terpenuhi, saldo pengirim dikurangi dan saldo penerima ditambahkan. Terakhir, sistem menampilkan pesan konfirmasi "BERHASIL: Transfer berhasil"

<img width="569" height="151" alt="image" src="https://github.com/user-attachments/assets/96819513-c758-4af3-a533-44e9494fa7b5" />

Alur ini menunjukkan validasi penting pada fitur Transfer Dana, yaitu mencegah pengguna mentransfer uang ke rekeningnya sendiri. Pengguna memasukkan nomor rekening yang sama untuk pengirim dan penerima (REK2025001). Program mendeteksi kesamaan ini, membatalkan transaksi sebelum meminta nominal, dan menampilkan pesan "GAGAL: Anda tidak bisa mentransfer ke rekening sendiri"

<img width="469" height="164" alt="image" src="https://github.com/user-attachments/assets/65111d0c-94a5-460d-80da-f3d170282faa" />

Alur ini menunjukkan validasi saldo pada fitur Transfer Dana. Pengguna telah memasukkan nomor rekening pengirim dan penerima yang valid, namun kemudian memasukkan jumlah transfer yang sangat besar (2000000000). Program memeriksa apakah saldo pengirim mencukupi untuk membayar jumlah transfer ditambah biaya administrasi. Karena tidak cukup, transaksi dibatalkan dan sistem menampilkan pesan "GAGAL: Saldo tidak mencukupi"

<img width="380" height="279" alt="image" src="https://github.com/user-attachments/assets/5a8b528f-ccea-4ebd-a524-5836cabd4ce5" />

Setiap input nominal pada fitur transfer yang tidak berbentuk angka akan dianggap tidak valid agar transaksi tidak gagal. Misalnya pada menu Transfer Dana, jika pengguna mengetik teks seperti "seratus", sistem langsung menampilkan pesan "Input tidak valid, masukkan angka!" dan meminta ulang input. Setelah pengguna memasukkan jumlah yang benar (contoh: 100000), sistem memproses transaksi dengan sukses dan menampilkan pesan "Transfer berhasil."

### Kembali Ke Menu Utama
<img width="377" height="275" alt="image" src="https://github.com/user-attachments/assets/8e7f34c9-cd43-40f1-8b3c-d92e8bf70aa3" />

Alur pada gambar ini menunjukkan cara pengguna kembali ke menu utama dari sub-menu transaksi. Setelah berada di dalam "Menu Transaksi", pengguna memilih opsi nomor 4 ("Kembali ke Menu Utama"). Program kemudian mengeksekusi perintah return untuk keluar dari fungsi menuTransaksi(), dan alur program langsung kembali menampilkan menu utama, siap menerima perintah selanjutnya.


<img width="461" height="231" alt="image" src="https://github.com/user-attachments/assets/215ddc3a-6479-48bf-a95b-7cb1ddc78741" />

Alur ini menunjukkan penanganan input yang tidak valid di dalam sub-menu transaksi. Pengguna memasukkan angka 5, yang tidak termasuk dalam pilihan yang tersedia (1-4). Program kemudian menjalankan blok default pada switch-case di dalam fungsi menuTransaksi(), yang menampilkan pesan "Pilihan tidak valid.". Setelah itu, pengguna diminta menekan Enter untuk melanjutkan sesi transaksi di sub-menu tersebut.


## Menu Mutasi (Lihat Mutasi Rekening)

<img width="809" height="157" alt="image" src="https://github.com/user-attachments/assets/357158c4-f0e2-4f7f-a53f-14f2c83cf894" />

Output ini memperlihatkan bahwa pengguna memilih menu 6 untuk melihat mutasi rekening dengan nomor 2025001. Program mengenali bahwa nasabah ini adalah nasabah biasa dan secara otomatis memotong biaya administrasi bulanan sebesar Rp5.000,00, karena ini adalah kali pertama mutasi dilihat di bulan September 2025. Setelah pemotongan, saldo awal Rp500.000,00 berkurang menjadi Rp495.000,00, dan mutasi tersebut dicatat dalam riwayat rekening nasabah.

<img width="909" height="157" alt="image" src="https://github.com/user-attachments/assets/f703dbc2-6d65-4f3c-9ead-45f206b84f0c" />

Output ini memperlihatkan pengguna memilih menu 6 untuk melihat mutasi rekening, lalu memasukkan nomor rekening 2025002. Program mengenali bahwa ini adalah rekening nasabah prioritas dan, sesuai dengan perubahan yang telah Anda buat, secara otomatis memotong biaya administrasi bulanan sebesar Rp3.000,00. Potongan ini terjadi karena ini adalah kali pertama mutasi rekening dilihat pada bulan September 2025. Setelah pemotongan, saldo awal yang tadinya Rp12.000.000,00 berkurang menjadi Rp11.997.000,00, dan mutasi tersebut dicatat dalam riwayat rekening nasabah.

<img width="440" height="119" alt="image" src="https://github.com/user-attachments/assets/a81a8e3d-a015-4441-839e-d22da9b5091a" />

Alur ini menunjukkan penanganan kesalahan saat pengguna mencoba melihat mutasi rekening dengan nomor yang tidak terdaftar. Ketika pengguna memasukkan nomor rekening yang tidak ada di dalam sistem (contoh: 2409116008), program akan gagal menemukan data yang cocok dan akan menampilkan pesan "GAGAL: Rekening tidak ditemukan." untuk menginformasikan pengguna.

## Menu Search (Cari Nasabah)

<img width="652" height="135" alt="image" src="https://github.com/user-attachments/assets/790020ff-a68e-49ea-8107-5c3c4d311f4d" />

Pada menu Cari Nasabah, pengguna dapat memasukkan kata kunci berupa Nama ataupun Nomor Rekening (contoh: REK2025001). Program kemudian akan melakukan iterasi pada seluruh data nasabah. Jika ditemukan data yang cocok dengan kata kunci, baik pada nama maupun nomor rekening, maka detail lengkap dari nasabah tersebut akan ditampilkan di bawah "Hasil Pencarian".

<img width="425" height="143" alt="image" src="https://github.com/user-attachments/assets/6e9e6b32-617e-4914-8221-f80777d8232d" />

Alur ini menunjukkan hasil pencarian jika data tidak ditemukan. Ketika pengguna memasukkan kata kunci yang tidak cocok dengan nama atau nomor rekening manapun yang ada di dalam sistem (contoh: Angie), program akan menyelesaikan proses pencarian tanpa menemukan hasil. Sebagai umpan balik, sistem akan menampilkan pesan informatif "Nasabah tidak ditemukan".

## Menu Bonus Untuk Nasabah Prioritas

<img width="822" height="58" alt="image" src="https://github.com/user-attachments/assets/46350740-71ba-406e-8bbc-ba01256cc84b" />

Ketika pengguna memilih menu 8, program akan mencari semua nasabah dengan kategori Prioritas. Pada contoh di atas, ditemukan nasabah Citra Lestari yang memiliki saldo Rp1.200.000. Sistem kemudian menghitung bonus berupa 2% dari saldo saat ini, yaitu Rp24.000. Bonus tersebut otomatis ditambahkan ke saldo, sehingga saldo baru menjadi Rp1.224.000. Mutasi rekening juga mencatat transaksi ini sebagai “Bunga tabungan: +Rp24000”.

Dengan cara ini, fitur bonus menegaskan perbedaan layanan antara Nasabah Biasa dan Nasabah Prioritas, karena hanya prioritas yang mendapat tambahan saldo otomatis. Ini sesuai konsep bank digital yang memberikan benefit khusus bagi nasabah premium.

## Menu Exit (Keluar)

<img width="758" height="48" alt="image" src="https://github.com/user-attachments/assets/9e41f980-1f0c-4890-9b91-25eacbdad716" />

Terakhir, jika pengguna memilih menu Keluar (contoh: opsi nomor 8), program akan menampilkan pesan perpisahan "Terima kasih!". Setelah itu, perintah return dieksekusi, yang akan menghentikan perulangan utama (main loop) dan mengakhiri sesi program secara permanen.
