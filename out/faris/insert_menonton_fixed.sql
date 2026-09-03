-- Database: basdatmovie
USE basdatmovie;

SET FOREIGN_KEY_CHECKS = 0;

-- INSERT INTO MENONTON (3 rows. Dihapus 0 duplikasi PK)
INSERT INTO Menonton (ID_konten, email, nama_profil, waktu_terakhir_menonton, posisi_terakhir) VALUES
('FI-080', 'dewi.saputra838@gmail.com', 'Kakak', '2016-08-04 19:42:01', 37),
('SE-003', 'dian.herlambang23@gmail.com', 'Raka', '2011-09-08 19:42:01', 37),
('FI-117', 'fajar.tambunan522@gmail.com', 'Dimas', '2019-01-13 14:27:00', 36);

SET FOREIGN_KEY_CHECKS = 1;