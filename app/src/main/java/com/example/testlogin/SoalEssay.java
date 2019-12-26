package com.example.testlogin;

public class SoalEssay {
    public String pertanyaan[] = {
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",
            "Tebaklah gambar diatas....",

    };

    //membuat array untuk set gambar (dari String diubah jadi ImageView)
    //pastikan yang tertulis disini sama dengan nama di drawable
    //lihat gambar penjelasan1
    private String image[] = {
            "helikopter",
            "aku_sayang_ayah",
            "batu_akik",
            "daun_bayam",
            "dian_sastro",
            "mati_rasa",
            "obat_nyamuk",
            "pancing_ikan",
            "panjang_umur",
            "sakit_perut",
    };

    //membuat array jawaban benar
    private String jawabanBenar[] = {
            "helikopter",
            "aku sayang ayah",
            "batu akik",
            "daun bayam",
            "dian sastro",
            "mati rasa",
            "obat nyamuk",
            "pancing ikan",
            "panjang umur",
            "sakit perut",
    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getStringGambar(int x){
        String gambar = image[x];
        return gambar;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
