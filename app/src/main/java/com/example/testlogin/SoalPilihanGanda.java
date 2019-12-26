package com.example.testlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SoalPilihanGanda extends AppCompatActivity {

    //membuat array untuk pertanyaan
    public String pertanyaan[] = {
            "Apa yang menarik dari hubungan sepasang angsa?",
            "Manakah pernyataan berikut yang SALAH?",
            "Apa yang harus dilakukan ketika pacar pms?",
            "Apa nama spesies orang utan langka di muka bumi?",
            "Dalam tangga lagu, nada apa yang paling menyakitkan?",
            "Disebut apakah spesies yang akan di MUSNAHKAN ?",
            "Manakah diantara banguan berikut ini yang merupakan bangunan BERSEJARAH?",
            "Siapa Jodoh ku?",
            "Sebutkan satu ciri-ciri penduduk diseluruh benua!",
    };

    //membuat array untuk pilihan jawaban
    private String pilihanJawaban[][] = {
            {"Angsa jantan memiliki 3-4 pasangan","Selalu bersama selamanya","cinta"},
            {"Laki-laki","Perempuan","Wanita"},
            {"Pura-pura mati","Ajak jalan-jalan","Ajak Shopping"},
            {"Mantan","Gebetan","Semua Benar"},
            {"Nada dering","Nada Perpisahan","Nada DO RE MI"},
            {"MANTAN","GEBETAN","JOMBLO"},
            {"Semua Benar","Taj Mahal","Rumah Mantan"},
            {"Skip","Pervita Pearce","Selena Gomes"},
            {"Buat PR","Remedi","Soal lainnya"},
    };

    //membuat array untuk jawaban benar
    private String jawabanBenar[] = {
            "Selalu bersama selamanya",
            "Laki-laki",
            "Pura-pura mati",
            "Semua Benar",
            "Nada Perpisahan",
            "JOMBLO",
            "Monas",
            "Skip",
            "Soal lainnya",
    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    //membuat getter untuk mengambil pilihan jawaban 3
    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}