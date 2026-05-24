package Laprak_Modul_Bab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Pemain {
    private String nama;
    private int tinggiBadan;
    private int beratBadan;

    public Pemain(String nama, int tinggiBadan, int beratBadan) {
        this.nama = nama;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    public int getTinggiBadan() { return tinggiBadan; }
    public int getBeratBadan() { return beratBadan; }
}

public class PencarianTim {
    public static int binarySearchIndeks(List<Pemain> list, int target, boolean berdasarkanTinggi) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int nilaiMid = berdasarkanTinggi ? list.get(mid).getTinggiBadan() : list.get(mid).getBeratBadan();

            if (nilaiMid == target) {
                return mid;
            } else if (nilaiMid < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int hitungFrekuensiBinarySearch(List<Pemain> list, int target, boolean berdasarkanTinggi) {
        int count = 0;
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int nilaiMid = berdasarkanTinggi ? list.get(mid).getTinggiBadan() : list.get(mid).getBeratBadan();

            if (nilaiMid == target) {
                count++;
                int kiri = mid - 1;
                while (kiri >= 0 && (berdasarkanTinggi ? list.get(kiri).getTinggiBadan() : list.get(kiri).getBeratBadan()) == target) {
                    count++;
                    kiri--;
                }
                int kanan = mid + 1;
                while (kanan < list.size() && (berdasarkanTinggi ? list.get(kanan).getTinggiBadan() : list.get(kanan).getBeratBadan()) == target) {
                    count++;
                    kanan++;
                }
                return count;
            } else if (nilaiMid < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Pemain> timA = new ArrayList<>();
        timA.add(new Pemain("A1", 165, 50));
        timA.add(new Pemain("A2", 165, 55));
        timA.add(new Pemain("A3", 166, 56));
        timA.add(new Pemain("A4", 168, 56));
        timA.add(new Pemain("A5", 168, 56));
        timA.add(new Pemain("A6", 169, 60));
        timA.add(new Pemain("A7", 170, 60));
        timA.add(new Pemain("A8", 170, 66));
        timA.add(new Pemain("A9", 171, 70));
        timA.add(new Pemain("A10", 172, 72));

        List<Pemain> timB = new ArrayList<>();
        timB.add(new Pemain("B1", 165, 58));
        timB.add(new Pemain("B2", 166, 58));
        timB.add(new Pemain("B3", 167, 59));
        timB.add(new Pemain("B4", 168, 60));
        timB.add(new Pemain("B5", 168, 60));
        timB.add(new Pemain("B6", 169, 65));
        timB.add(new Pemain("B7", 170, 66));
        timB.add(new Pemain("B8", 171, 68));
        timB.add(new Pemain("B9", 172, 68));
        timB.add(new Pemain("B10", 175, 71));

        System.out.println("===== 2a. Data ArrayList Tim A dan B =====");
        
        timA.sort(Comparator.comparingInt(Pemain::getTinggiBadan));
        System.out.print("Tinggi Badan Tim A (Sorted): [");
        for(int i=0; i<timA.size(); i++) System.out.print(timA.get(i).getTinggiBadan() + (i == timA.size()-1 ? "" : ", "));
        System.out.println("]");

        timA.sort(Comparator.comparingInt(Pemain::getBeratBadan));
        System.out.print("Berat Badan Tim A (Sorted): [");
        for(int i=0; i<timA.size(); i++) System.out.print(timA.get(i).getBeratBadan() + (i == timA.size()-1 ? "" : ", "));
        System.out.println("]");

        timB.sort(Comparator.comparingInt(Pemain::getTinggiBadan));
        System.out.print("Tinggi Tim B (Sorted): [");
        for(int i=0; i<timB.size(); i++) System.out.print(timB.get(i).getTinggiBadan() + (i == timB.size()-1 ? "" : ", "));
        System.out.println("]");

        timB.sort(Comparator.comparingInt(Pemain::getBeratBadan));
        System.out.print("Berat Tim B (Sorted): [");
        for(int i=0; i<timB.size(); i++) System.out.print(timB.get(i).getBeratBadan() + (i == timB.size()-1 ? "" : ", "));
        System.out.println("]\n");

        System.out.println("===== 2b. Frekuensi Tinggi Badan Tim B =====");
        timB.sort(Comparator.comparingInt(Pemain::getTinggiBadan));
        
        int jmlT168 = hitungFrekuensiBinarySearch(timB, 168, true);
        int jmlT160 = hitungFrekuensiBinarySearch(timB, 160, true);
        int idxT168 = binarySearchIndeks(timB, 168, true);
        int idxT160 = binarySearchIndeks(timB, 160, true);

        System.out.println("Jumlah Pemain Tim B dengan Tinggi Badan 168 cm: " + jmlT168);
        System.out.println("Jumlah Pemain Tim B dengan Tinggi Badan 160 cm: " + jmlT160);
        System.out.println("Binary Search Tinggi Badan 168 cm di Tim b: " + (idxT168 != -1 ? "Ditemukan di index " + idxT168 : "Tidak Ditemukan"));
        System.out.println("Binary Search Tinggi 160 cm di Tim b: " + (idxT160 != -1 ? "Ditemukan di index " + idxT160 : "Tidak Ditemukan") + "\n");

        System.out.println("===== 2c. Frekuensi Berat Badan Tim A =====");
        timA.sort(Comparator.comparingInt(Pemain::getBeratBadan));

        int jmlB56 = hitungFrekuensiBinarySearch(timA, 56, false);
        int jmlB53 = hitungFrekuensiBinarySearch(timA, 53, false);
        int idxB56 = binarySearchIndeks(timA, 56, false);
        int idxB53 = binarySearchIndeks(timA, 53, false);

        System.out.println("Jumlah Pemain Tim A dengan Berat Badan 56 kg: " + jmlB56);
        System.out.println("Jumlah Pemain Tim A dengan Berat Badan 53 kg: " + jmlB53);
        System.out.println("Binary Search Berat 56 di Tim A: " + (idxB56 != -1 ? "Ditemukan di Index " + idxB56 : "Tidak Ditemukan"));
        System.out.println("Binary Search Berat 53 di Tim A: " + (idxB53 != -1 ? "Ditemukan di Index " + idxB53 : "Tidak Ditemukan") + "\n");

        System.out.println("===== 2d. Kesamaan Tinggi atau Berat Badan diantara Tim A dan Tim B =====");
        
        timB.sort(Comparator.comparingInt(Pemain::getTinggiBadan));
        boolean adaTinggiSama = false;
        for (Pemain pA : timA) {
            if (binarySearchIndeks(timB, pA.getTinggiBadan(), true) != -1) {
                adaTinggiSama = true;
                break;
            }
        }
        System.out.println("Tinggi badan: Tim A dan Tim B " + (adaTinggiSama ? "ADA yang sama" : "TIDAK ADA yang sama"));

        timB.sort(Comparator.comparingInt(Pemain::getBeratBadan));
        boolean adaBeratSama = false;
        for (Pemain pA : timA) {
            if (binarySearchIndeks(timB, pA.getBeratBadan(), false) != -1) {
                adaBeratSama = true;
                break;
            }
        }
        System.out.println("Berat badan : Tim A dan Tim B " + (adaBeratSama ? "ADA yang sama" : "TIDAK ADA yang sama"));
    }
}