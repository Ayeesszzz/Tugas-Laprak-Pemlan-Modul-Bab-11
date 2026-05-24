package Laprak_Modul_Bab11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Pemain {
    private String asalTim; 
    private int tinggiBadan;
    private int beratBadan;

    public Pemain(String asalTim, int tinggiBadan, int beratBadan) {
        this.asalTim = asalTim;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    public String getAsalTim() { return asalTim; }
    public void setAsalTim(String asalTim) { this.asalTim = asalTim; } // Digunakan saat copy ke Tim C
    public int getTinggiBadan() { return tinggiBadan; }
    public int getBeratBadan() { return beratBadan; }

    @Override
    public String toString() {
        return String.format("%s | Tinggi Badan: %3d cm | Berat Badan: %2d kg", asalTim, tinggiBadan, beratBadan);
    }
}

public class ManajemenTim {
    public static void cetakDaftar(List<Pemain> daftar) {
        for (Pemain p : daftar) {
            System.out.println(p);
        }
    }
    public static void cetakMaxMin(String namaTim, List<Pemain> tim) {
        if (tim.isEmpty()) return;

        Pemain maxTinggi = tim.get(0);
        Pemain minTinggi = tim.get(0);
        Pemain maxBerat = tim.get(0);
        Pemain minBerat = tim.get(0);

        for (Pemain p : tim) {
            if (p.getTinggiBadan() > maxTinggi.getTinggiBadan()) maxTinggi = p;
            if (p.getTinggiBadan() < minTinggi.getTinggiBadan()) minTinggi = p;
            if (p.getBeratBadan() > maxBerat.getBeratBadan()) maxBerat = p;
            if (p.getBeratBadan() < minBerat.getBeratBadan()) minBerat = p;
        }

        System.out.println("===== 1c. Max & Min " + namaTim + " =====");
        System.out.println("Max Tinggi: " + maxTinggi);
        System.out.println("Min Tinggi: " + minTinggi);
        System.out.println("Max Berat : " + maxBerat);
        System.out.println("Min Berat : " + minBerat);
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pemain> timA = new ArrayList<>();
        timA.add(new Pemain("Tim A", 168, 50));
        timA.add(new Pemain("Tim A", 168, 55));
        timA.add(new Pemain("Tim A", 165, 56));
        timA.add(new Pemain("Tim A", 165, 56));
        timA.add(new Pemain("Tim A", 166, 56));
        timA.add(new Pemain("Tim A", 170, 60));
        timA.add(new Pemain("Tim A", 172, 60));
        timA.add(new Pemain("Tim A", 169, 66));
        timA.add(new Pemain("Tim A", 170, 70));
        timA.add(new Pemain("Tim A", 171, 72));

        List<Pemain> timB = new ArrayList<>();
        timB.add(new Pemain("Tim B", 169, 60));
        timB.add(new Pemain("Tim B", 168, 65));
        timB.add(new Pemain("Tim B", 171, 68));
        timB.add(new Pemain("Tim B", 172, 68));
        timB.add(new Pemain("Tim B", 175, 71));
        timB.add(new Pemain("Tim B", 165, 59));
        timB.add(new Pemain("Tim B", 167, 60));
        timB.add(new Pemain("Tim B", 166, 58));
        timB.add(new Pemain("Tim B", 168, 58));
        timB.add(new Pemain("Tim B", 170, 66));

        List<Pemain> semuaPemain = new ArrayList<>();
        semuaPemain.addAll(timA);
        semuaPemain.addAll(timB);

        System.out.println("===== 1a. Semua Pemain - Tinggi Badan Ascending =====");
        semuaPemain.sort(Comparator.comparingInt(Pemain::getTinggiBadan));
        cetakDaftar(semuaPemain);
        System.out.println();

        System.out.println("===== 1a. Semua Pemain - Tinggi Badan Descending =====");
        semuaPemain.sort(Comparator.comparingInt(Pemain::getTinggiBadan).reversed());
        cetakDaftar(semuaPemain);
        System.out.println();

        System.out.println("===== 1b. Semua Pemain - Berat Badan Ascending =====");
        semuaPemain.sort(Comparator.comparingInt(Pemain::getBeratBadan));
        cetakDaftar(semuaPemain);
        System.out.println();

        System.out.println("===== 1b. Semua Pemain - Berat Badan Descending =====");
        semuaPemain.sort(Comparator.comparingInt(Pemain::getBeratBadan).reversed());
        cetakDaftar(semuaPemain);
        System.out.println();

        cetakMaxMin("Tim A", timA);
        cetakMaxMin("Tim B", timB);

        System.out.println("===== 1d. Tim C (Salinan dari Tim B) =====");
        List<Pemain> timC = new ArrayList<>();

        for (Pemain p : timB) {
            timC.add(new Pemain("Tim C", p.getTinggiBadan(), p.getBeratBadan()));
        }
        
        cetakDaftar(timC);
    }
}