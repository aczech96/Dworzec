import java.util.Scanner;

/**
 * Created by Anna on 14.10.2017.
 */
public class Platnosc {

    public void plac(double kwotaDoZaplaty) {
        double pieniadze; //tyle ile klient wrzucil zeby zaplacic
        java.text.DecimalFormat zaokraglenie=new java.text.DecimalFormat();
        zaokraglenie.setMaximumFractionDigits(2);
        zaokraglenie.setMinimumFractionDigits(2);
        System.out.println("Wprowadż odpowiednia ilosc pieniedzy");
        Scanner wczytaj = new Scanner(System.in);
        pieniadze = wczytaj.nextDouble();
        if (kwotaDoZaplaty == 0)
            System.out.println("Nie wybrano żadnych biletów lub wubrane są niepoprawne - kwota do zaplaty wynosi zero");
        else while (kwotaDoZaplaty > pieniadze) {
            kwotaDoZaplaty -= pieniadze;
            System.out.println("Do zaplaty pozostalo " + zaokraglenie.format(kwotaDoZaplaty));
            pieniadze=wczytaj.nextDouble();
        }
        if (kwotaDoZaplaty < pieniadze) {
            pieniadze -= kwotaDoZaplaty;
            System.out.println("Prosze odebrac wydrukowane bilety\nReszta wynosi " + zaokraglenie.format(pieniadze));
        } else if (kwotaDoZaplaty == pieniadze)
            System.out.println("Dziekujemy za transakcje, proszę zabrać wydrukowane bilety");
    }
}
