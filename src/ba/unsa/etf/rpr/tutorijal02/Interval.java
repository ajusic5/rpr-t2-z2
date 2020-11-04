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

        if(krajnjaTacka<i.pocetnaTacka || i.krajnjaTacka<pocetnaTacka) return new Interval(); // intervali se ne presijecaju

        if(pocetnaTacka==i.pocetnaTacka && krajnjaTacka==i.krajnjaTacka){ //intervali se poklapaju

            if(daLiPocetnaTackaPripada && i.daLiPocetnaTackaPripada && daLiKrajnjaTackaPripada && i.daLiKrajnjaTackaPripada)
                return new Interval(pocetnaTacka,krajnjaTacka,true,true);

            if((!daLiPocetnaTackaPripada || i.daLiPocetnaTackaPripada) && daLiKrajnjaTackaPripada && i.daLiKrajnjaTackaPripada)
                return  new Interval(pocetnaTacka,krajnjaTacka,false, true);

            if(daLiPocetnaTackaPripada && i.daLiPocetnaTackaPripada && (!daLiKrajnjaTackaPripada || !i.daLiKrajnjaTackaPripada))
                return new Interval(pocetnaTacka,krajnjaTacka,true, false);

            return new Interval(pocetnaTacka,krajnjaTacka,false,false);
        }

        if(krajnjaTacka==i.pocetnaTacka){

            if(daLiKrajnjaTackaPripada && i.daLiPocetnaTackaPripada)
                return new Interval(i.pocetnaTacka,krajnjaTacka, true, true);

            return new Interval(i.pocetnaTacka,krajnjaTacka, false,false);
        }
        if(i.krajnjaTacka==pocetnaTacka){

            if(i.daLiKrajnjaTackaPripada && daLiPocetnaTackaPripada)
                return new Interval(pocetnaTacka,i.krajnjaTacka, true, true);

            return new Interval(pocetnaTacka,i.krajnjaTacka, false,false);
        }

        if(pocetnaTacka>i.pocetnaTacka && krajnjaTacka<i.krajnjaTacka){

            if(daLiPocetnaTackaPripada  && daLiKrajnjaTackaPripada )
                return new Interval(pocetnaTacka,krajnjaTacka,true,true);

            if( !daLiPocetnaTackaPripada &&  daLiKrajnjaTackaPripada)
                return new Interval(pocetnaTacka,krajnjaTacka,false,true);

            if( daLiPocetnaTackaPripada && !daLiKrajnjaTackaPripada)
                return new Interval(pocetnaTacka,krajnjaTacka,true,false);

            return new Interval(pocetnaTacka,krajnjaTacka,false,false);

        }

        if(pocetnaTacka<i.pocetnaTacka && krajnjaTacka>i.krajnjaTacka){

            if(i.daLiPocetnaTackaPripada &&  i.daLiKrajnjaTackaPripada)
                return new Interval(i.pocetnaTacka,i.krajnjaTacka,true,true);

            if(!i.daLiPocetnaTackaPripada  && i.daLiKrajnjaTackaPripada )
                return new Interval(i.pocetnaTacka,i.krajnjaTacka,false,true);

            if(i.daLiPocetnaTackaPripada && !i.daLiKrajnjaTackaPripada )
                return new Interval(i.pocetnaTacka,i.krajnjaTacka,true,false);

            return new Interval(i.pocetnaTacka,i.krajnjaTacka,false,false);

        } // dva slučaja kada je jedan interval podinterval drugog

        if(pocetnaTacka<i.pocetnaTacka){
            if(i.daLiPocetnaTackaPripada && daLiKrajnjaTackaPripada)
                return new Interval(i.pocetnaTacka,krajnjaTacka,true,true);

            if(!i.daLiPocetnaTackaPripada && daLiKrajnjaTackaPripada)
                return new Interval(i.pocetnaTacka,krajnjaTacka,false,true);

            if(i.daLiPocetnaTackaPripada && !daLiKrajnjaTackaPripada)
                return new Interval(i.pocetnaTacka,krajnjaTacka,true, false);

            return new Interval(i.pocetnaTacka,krajnjaTacka,false,false);
        }

        if(daLiPocetnaTackaPripada && i.daLiKrajnjaTackaPripada)
            return new Interval(pocetnaTacka,i.krajnjaTacka,true,true);

        if(!daLiPocetnaTackaPripada && i.daLiKrajnjaTackaPripada)
            return new Interval(pocetnaTacka,i.krajnjaTacka,false,true);

        if(daLiPocetnaTackaPripada && !i.daLiKrajnjaTackaPripada)
            return new Interval(pocetnaTacka,i.krajnjaTacka,true, false);
        return new Interval(pocetnaTacka,i.krajnjaTacka,false,false);

    }

    public static Interval intersect(Interval i1, Interval i2){

        if(i2.krajnjaTacka<i1.pocetnaTacka || i1.krajnjaTacka<i2.pocetnaTacka) return new Interval(); // intervali se ne presijecaju

        if(i2.pocetnaTacka==i1.pocetnaTacka && i2.krajnjaTacka==i1.krajnjaTacka){ //intervali se poklapaju

            if(i2.daLiPocetnaTackaPripada && i1.daLiPocetnaTackaPripada && i2.daLiKrajnjaTackaPripada && i1.daLiKrajnjaTackaPripada)
                return new Interval(i2.pocetnaTacka,i2.krajnjaTacka,true,true);

            if((!i2.daLiPocetnaTackaPripada || i1.daLiPocetnaTackaPripada) && i2.daLiKrajnjaTackaPripada && i1.daLiKrajnjaTackaPripada)
                return  new Interval(i2.pocetnaTacka,i2.krajnjaTacka,false, true);

            if(i2.daLiPocetnaTackaPripada && i1.daLiPocetnaTackaPripada && (!i2.daLiKrajnjaTackaPripada || !i1.daLiKrajnjaTackaPripada))
                return new Interval(i2.pocetnaTacka,i2.krajnjaTacka,true, false);

            return new Interval(i2.pocetnaTacka,i2.krajnjaTacka,false,false);
        }

        if(i2.krajnjaTacka==i1.pocetnaTacka){

            if(i2.daLiKrajnjaTackaPripada && i1.daLiPocetnaTackaPripada)
                return new Interval(i1.pocetnaTacka,i2.krajnjaTacka, true, true);

            return new Interval(i1.pocetnaTacka,i2.krajnjaTacka, false,false);
        }

        if(i1.krajnjaTacka==i2.pocetnaTacka){

            if(i1.daLiKrajnjaTackaPripada && i2.daLiPocetnaTackaPripada)
                return new Interval(i2.pocetnaTacka,i1.krajnjaTacka, true, true);

            return new Interval(i2.pocetnaTacka,i1.krajnjaTacka, false,false);
        }

        if(i2.pocetnaTacka>i1.pocetnaTacka && i2.krajnjaTacka<i1.krajnjaTacka){

            if(i2.daLiPocetnaTackaPripada  && i2.daLiKrajnjaTackaPripada )
                return new Interval(i2.pocetnaTacka,i2.krajnjaTacka,true,true);

            if( !i2.daLiPocetnaTackaPripada &&  i2.daLiKrajnjaTackaPripada)
                return new Interval(i2.pocetnaTacka,i2.krajnjaTacka,false,true);

            if( i2.daLiPocetnaTackaPripada && !i2.daLiKrajnjaTackaPripada)
                return new Interval(i2.pocetnaTacka,i2.krajnjaTacka,true,false);

            return new Interval(i2.pocetnaTacka,i2.krajnjaTacka,false,false);

        }

        if(i2.pocetnaTacka<i1.pocetnaTacka && i2.krajnjaTacka>i1.krajnjaTacka){

            if(i1.daLiPocetnaTackaPripada &&  i1.daLiKrajnjaTackaPripada)
                return new Interval(i1.pocetnaTacka,i1.krajnjaTacka,true,true);

            if(!i1.daLiPocetnaTackaPripada  && i1.daLiKrajnjaTackaPripada )
                return new Interval(i1.pocetnaTacka,i1.krajnjaTacka,false,true);

            if(i1.daLiPocetnaTackaPripada && !i1.daLiKrajnjaTackaPripada )
                return new Interval(i1.pocetnaTacka,i1.krajnjaTacka,true,false);

            return new Interval(i1.pocetnaTacka,i1.krajnjaTacka,false,false);

        } // dva slučaja kada je jedan interval podinterval drugog

        if(i2.pocetnaTacka<i1.pocetnaTacka){
            if(i1.daLiPocetnaTackaPripada && i2.daLiKrajnjaTackaPripada)
                return new Interval(i1.pocetnaTacka,i2.krajnjaTacka,true,true);

            if(!i1.daLiPocetnaTackaPripada && i2.daLiKrajnjaTackaPripada)
                return new Interval(i1.pocetnaTacka,i2.krajnjaTacka,false,true);

            if(i1.daLiPocetnaTackaPripada && !i2.daLiKrajnjaTackaPripada)
                return new Interval(i1.pocetnaTacka,i2.krajnjaTacka,true, false);

            return new Interval(i1.pocetnaTacka,i2.krajnjaTacka,false,false);
        }

        if(i2.daLiPocetnaTackaPripada && i1.daLiKrajnjaTackaPripada)
            return new Interval(i2.pocetnaTacka,i1.krajnjaTacka,true,true);

        if(!i2.daLiPocetnaTackaPripada && i1.daLiKrajnjaTackaPripada)
            return new Interval(i2.pocetnaTacka,i1.krajnjaTacka,false,true);

        if(i2.daLiPocetnaTackaPripada && !i1.daLiKrajnjaTackaPripada)
            return new Interval(i2.pocetnaTacka,i1.krajnjaTacka,true, false);

        return new Interval(i2.pocetnaTacka,i1.krajnjaTacka,false,false);

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

    @Override
    public String toString() {

        if(pocetnaTacka==krajnjaTacka && daLiKrajnjaTackaPripada && daLiKrajnjaTackaPripada)
           return "[]";
        if(pocetnaTacka==krajnjaTacka && daLiKrajnjaTackaPripada && !daLiKrajnjaTackaPripada)
            return "[)";
        if(pocetnaTacka==krajnjaTacka && !daLiKrajnjaTackaPripada && daLiKrajnjaTackaPripada)
            return "(]";
        if(pocetnaTacka==krajnjaTacka && !daLiKrajnjaTackaPripada && !daLiKrajnjaTackaPripada)
            return "()";


        if(daLiPocetnaTackaPripada && daLiKrajnjaTackaPripada) {
            String s="[";
            s+= this.pocetnaTacka;
            s+= ",";
            s+=this.krajnjaTacka;
            s+= "]";
            return s;
        }
        if(!daLiPocetnaTackaPripada && daLiKrajnjaTackaPripada) {
            String s="(";
            s+= this.pocetnaTacka;
            s+= ",";
            s+=this.krajnjaTacka;
            s+= "]";
            return s;
        }
        if(daLiPocetnaTackaPripada && !daLiKrajnjaTackaPripada) {
            String s="[";
            s+= this.pocetnaTacka;
            s+= ",";
            s+=this.krajnjaTacka;
            s+= ")";
            return s;
        }

        if(!daLiPocetnaTackaPripada && !daLiKrajnjaTackaPripada) {
            String s="(";
            s+= this.pocetnaTacka;
            s+= ",";
            s+=this.krajnjaTacka;
            s+= ")";
            return s;
        }


        return "";
    }
}
