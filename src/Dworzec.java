import java.util.List;

/**
 * Created by Anna on 05.07.2017.
 */
public class Dworzec {
  int liczbaStanowisk;
  String miasto;


  public Dworzec(int liczbaStanowisk, String miasto){
      this.liczbaStanowisk=liczbaStanowisk;
      this.miasto=miasto;
  }

  public String toString(){
      return("Witamy na dworcu w miescie: "+miasto);
  }
  void informacja(List<Autobus> lista){
      System.out.println("Autobusy odjeżdżające z dworca: ");
      for(int i=0; i<lista.size();i++){
          System.out.println(lista.get(i).toString());
      }
      System.out.println("");

  }

}
