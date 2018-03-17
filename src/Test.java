import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javafx.application.Platform.exit;

/**
 * Created by Anna on 05.07.2017.
 */
public class Test {
    List<Autobus> autobusy = new ArrayList<Autobus>();

    public static void main(String[] args) throws IllegalAccessException, IOException {
        Test t = new Test();
        Scanner wczytaj = new Scanner(System.in);
        Dworzec gorlice = new Dworzec(20, "Gorlice");
        Autobus polec = new Autobus("Połeć", 52, "Gorlice", "Kraków", 20);
        Autobus nowex = new Autobus("Nowex", 40, "Gorlice", "Lipinki", 4);
        Autobus voyager = new Autobus("Voyager", 45, "Gorlice", "Nowy Sącz", 10);
        t.autobusy.add(voyager);
        t.autobusy.add(polec);
        t.autobusy.add(nowex);
        Platnosc p= new Platnosc();
        System.out.println(gorlice.toString());

        int temp, pom, wybor = 1;
        double cena = 0;

        // dodac kolejny autobus, zrobic drugi dworzec!
        while (wybor == 1) {
            System.out.println("Co chcesz zrobic ?\n1. Kupic bilet \n2.Zaplacic\n3.Wyjsc");
            wybor = wczytaj.nextInt();
            switch (wybor) {
                case 1: {
                    System.out.println("Na ktory z autobusow chcesz kupic bilet?\n1.Połeć\n2.Nowex\n3.Voyager");
                    temp = wczytaj.nextInt();
                    if(temp>3){
                        System.out.println("Blad");
                        break;}
                    System.out.println("Jaki bilet chcesz kupic?\n1.Normalny\n2.Ulgowy");
                    pom = wczytaj.nextInt();
                    if(pom>2){
                        System.out.println("Blad");
                        break;}
                    switch (temp) {
                        case 1: {
                            cena += polec.kupBilet(polec, gorlice, pom);
                            break;
                        }
                        case 2: {
                            cena += nowex.kupBilet(nowex, gorlice, pom);
                            break;
                        }
                        case 3: {
                            cena += voyager.kupBilet(voyager, gorlice, pom);
                            break;
                        }
                        default: {
                            System.out.println("Nie ma takiej mozliwosci do wybrania");
                        }
                    }
                    if (cena == 0) {
                        break;
                    } else {
                        System.out.println("Do zaplaty: " + cena);
                        break;
                    }
                }
                case 2:{
                    p.plac(cena);
                    break;
                }
                default: {
                    exit();
                }
            }
        }
    }
}