package com.example.dolgozodemo.models;

public class Dolgozo {
    private int id;
    private String nev;
    private String nem;
    private int kor;
    private int fizetes;

    public Dolgozo(int id, String nev, String nem, int kor, int fizetes) {
        this.id = id;
        this.nev = nev;
        this.nem = nem;
        this.kor = kor;
        this.fizetes = fizetes;
    }

    public Dolgozo(String nev, String nem,  int kor, int fizetes) {
        this.nev = nev;
        this.nem = nem;
        this.kor = kor;
        this.fizetes = fizetes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getFizetes() {
        return fizetes;
    }

    public void setFizetes(int fizetes) {
        this.fizetes = fizetes;
    }

    @Override
    public String toString() {
        return String.format("%-20s %5s %4d év %8d Ft", nev, nem, kor, fizetes);
    }
}

