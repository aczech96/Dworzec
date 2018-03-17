import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Anna on 05.07.2017.
 */
public class Autobus {
    String nazwaFirmy;
    int liczbaMiejsc;
    String miastoWyjazdu;
    String miastoDocelowe;
    double cenaBiletu;

    int liczePrzystanki = 0;

    BufferedReader plik1 = new BufferedReader(new FileReader("Polec.txt"));
    BufferedReader plik2 = new BufferedReader(new FileReader("Nowex.txt"));
    BufferedReader plik3 = new BufferedReader(new FileReader("Voyager.txt"));

    String strumien = null;

    public Autobus(String nazwaFirmy, int liczbaMiejsc, String miastoWyjazdu, String miastoDocelowe, double cenaBiletu) throws FileNotFoundException {
        this.nazwaFirmy = nazwaFirmy;
        this.liczbaMiejsc = liczbaMiejsc;
        this.miastoWyjazdu = miastoWyjazdu;
        this.miastoDocelowe = miastoDocelowe;
        this.cenaBiletu = cenaBiletu;
    }

    public String toString() {
        return ("Autobus: " + nazwaFirmy + " wyrusza z " + miastoWyjazdu + " i jedzie do " + miastoDocelowe + " cena biletu wynosi " + cenaBiletu + " w ofercje znajduja sie również bilety ulgowe z ulgą 50%");
    }

    int x = 0; //liczba kupionych juz biletow

    double kupBilet(Autobus bus, Dworzec dworzec, int typ) throws IllegalAccessException, IOException {
        //typ: 1- bilet normalny, 2-bilet ulgowy
        double cena;
        if (x <= bus.liczbaMiejsc) {
            if (typ == 2) {
                cena = 0.5 * trasa(bus, dworzec);
                return (cena);
            } else if (typ == 1) {
                cena = trasa(bus, dworzec);
                return (cena);
            } else System.out.println("Nie ma takiego typu biletu");
            x++;
        } else System.out.println("Nie ma juz miejsc w wybranym autobisie");
        return 0;
    }

    double y;//pomocniczny do wpisywania wartosci przez uzytkownika
    Scanner wczytaj = new Scanner(System.in);

    double trasa(Autobus bus, Dworzec dworzec) throws IllegalAccessException, IOException {//cena biletu w zalezniosci do jakiego miasta sie jedzie
        List<String> polecStops = new ArrayList<String>();
        List<String> nowexStops = new ArrayList<String>();
        List<String> voyagerStops = new ArrayList<String>();
        int ilosc = 0;

        System.out.println("Prosze wybrac miasto docelowe: ");
        if (bus.nazwaFirmy == "Połeć") {
            ilosc = przystanki(plik1, dworzec, polecStops);
        } else if (bus.nazwaFirmy == "Nowex") {
            ilosc = przystanki(plik2, dworzec, nowexStops);
        } else if (bus.nazwaFirmy == "Voyager") {
            ilosc = przystanki(plik3, dworzec, voyagerStops);
        }
        try {
            y = wczytaj.nextInt();
            if (y > ilosc-1)
                throw new IllegalAccessException();
            return (bus.cenaBiletu - (y - 1) * 0.1);
        } catch (IllegalAccessException wyj) {
            System.out.println("Przystanek o podanym numerze nie istnieje");
        }
        return 0;
    }

    public int przystanki(BufferedReader plik, Dworzec dworzec, List<String> stops) throws IOException {
        plik.mark(100);
        try {
            String czytaj = null;
            czytaj = plik.readLine();
            while (czytaj != null) {
                stops.add(czytaj);
                czytaj = plik.readLine();
            }

            for (int i = 0; i < stops.size() - 1; i++) {
                System.out.println(stops.get(i));
            }
        } catch (IOException wyjatek) {
            System.out.println("Nie mozna odczytac pliku");
        } finally {
            if (plik != null)
                plik.reset();
        }
        return stops.size();
    }
}