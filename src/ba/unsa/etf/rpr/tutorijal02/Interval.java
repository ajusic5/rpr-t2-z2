package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval {

    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean daLiPocetnaTackaPripada;
    private boolean daLiKrajnjaTackaPripada;
    public Interval(double pocetna, double krajnja, boolean daLiPocetnaPripada, boolean daLiKrajnjaPripada) {

        if(krajnja>pocetna) throw new IllegalArgumentException("Neispravna vrijednost tacaka");
        pocetnaTacka=pocetna;
        krajnjaTacka=krajnja;
        daLiPocetnaTackaPripada=daLiPocetnaPripada;
        daLiKrajnjaTackaPripada=daLiKrajnjaPripada;
    }
    public Interval(){
        pocetnaTacka=0;
        krajnjaTacka=0;
        daLiPocetnaTackaPripada=false;
        daLiKrajnjaTackaPripada=false;
    }
    public boolean isNull(){
        if (Objects.equals(pocetnaTacka, krajnjaTacka)) {
            return true;
        }
        return false;
    }




}
