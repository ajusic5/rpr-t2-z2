package ba.unsa.etf.rpr.tutorijal02;

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



}
