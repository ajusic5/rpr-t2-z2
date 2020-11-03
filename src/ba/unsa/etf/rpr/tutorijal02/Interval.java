package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval {

    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean daLiPocetnaTackaPripada;
    private boolean daLiKrajnjaTackaPripada;
    public Interval(double pocetna, double krajnja, boolean daLiPocetnaPripada, boolean daLiKrajnjaPripada) {

        if(krajnja<pocetna) throw new IllegalArgumentException("Neispravna vrijednost tacaka");
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
    public boolean isIn(double tacka){

        if(tacka>pocetnaTacka && krajnjaTacka>tacka ) return true;
        if(tacka==pocetnaTacka) return daLiPocetnaTackaPripada;
        if(tacka==krajnjaTacka) return daLiKrajnjaTackaPripada;
        return false;

    }
    public Interval intersect(Interval i){

        if(this.krajnjaTacka<i.pocetnaTacka || this.pocetnaTacka>i.krajnjaTacka) return new Interval(); // intervali se ne presijecaju

        if(this.pocetnaTacka==i.pocetnaTacka && this.krajnjaTacka==i.krajnjaTacka){

            if(this.daLiPocetnaTackaPripada==true && i.daLiPocetnaTackaPripada==true && this.daLiKrajnjaTackaPripada==true && i.daLiKrajnjaTackaPripada==true)
                return new Interval(i.pocetnaTacka,i.krajnjaTacka,true,true);

            if(this.daLiPocetnaTackaPripada==true && i.daLiPocetnaTackaPripada==false && this.daLiKrajnjaTackaPripada==true && i.daLiKrajnjaTackaPripada==false)
                return new Interval(i.pocetnaTacka,i.krajnjaTacka,true,false);

            if(this.daLiPocetnaTackaPripada==false && i.daLiPocetnaTackaPripada==true && this.daLiKrajnjaTackaPripada==false && i.daLiKrajnjaTackaPripada==true)
                return new Interval(i.pocetnaTacka,i.krajnjaTacka,false,true);

        }

        if(this.pocetnaTacka<i.pocetnaTacka && this.krajnjaTacka>i.krajnjaTacka) return new Interval(i.pocetnaTacka,i.krajnjaTacka,i.daLiPocetnaTackaPripada,i.daLiKrajnjaTackaPripada);

        if(i.pocetnaTacka<this.pocetnaTacka && i.krajnjaTacka>this.krajnjaTacka) return new Interval(this.pocetnaTacka,this.krajnjaTacka, this.daLiPocetnaTackaPripada, this.daLiKrajnjaTackaPripada);

        //dva slučaja da je jedan interval podinterval drugog, na osnovu boolean vrijednosti određuje se da li je interval,poluinterval ili segment

        if(this.pocetnaTacka<i.pocetnaTacka) return new Interval(i.pocetnaTacka, this.krajnjaTacka, i.daLiPocetnaTackaPripada, this.daLiKrajnjaTackaPripada);

        return new Interval(this.pocetnaTacka,i.krajnjaTacka,this.daLiPocetnaTackaPripada,i.daLiKrajnjaTackaPripada);

    }

    @Override
    public boolean equals(Object o){

        Interval i=new Interval();
        i.pocetnaTacka=((Interval)o).pocetnaTacka;
        i.krajnjaTacka=((Interval)o).krajnjaTacka;
        i.daLiPocetnaTackaPripada=((Interval)o).daLiPocetnaTackaPripada;
        i.daLiKrajnjaTackaPripada=((Interval)o).daLiKrajnjaTackaPripada;

        if(i.pocetnaTacka==this.pocetnaTacka && i.krajnjaTacka==this.krajnjaTacka && i.daLiPocetnaTackaPripada==this.daLiPocetnaTackaPripada && i.daLiKrajnjaTackaPripada==this.daLiKrajnjaTackaPripada)
            return true;
        return false;

    }






}
