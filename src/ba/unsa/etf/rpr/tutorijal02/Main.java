package ba.unsa.etf.rpr.tutorijal02;

public class Main {

    public static void main(String[] args) {
    /*    System.out.println("Nema ništa u mainu, pokrenite testove!");
        Interval i=new Interval();
        System.out.println(i.toString());*/

        Interval i = new Interval(-1.1, 2.5, true, false);
        Interval i2 = new Interval(2.2, 3.6, false, true);
        Interval i3 = Interval.intersect(i, i2);

    }
}
