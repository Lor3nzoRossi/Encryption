import java.util.Scanner;

// import javax.sql.rowset.Joinable;

class Main {
  public static void main(String[] args) {
    // istanziare un oggetto scanner per prendere successivamente l'input
    // dall'utente
    Scanner scanner = new Scanner(System.in);
    String chiave = "KEY";
    // istanziare la matrice
    Matrice m = new Matrice(chiave);
    // istanziare 4 Vigenere per poi creare dei thread che popoleranno la matrice
    Vigenere v1 = new Vigenere(0, 12, 0, 12, m);
    Vigenere v2 = new Vigenere(0, 12, 13, 25, m);
    Vigenere v3 = new Vigenere(13, 25, 0, 12, m);
    Vigenere v4 = new Vigenere(13, 25, 13, 25, m);
    // istanziare thread per popolare la matrice
    Thread t1 = new Thread(v1);
    Thread t2 = new Thread(v2);
    Thread t3 = new Thread(v3);
    Thread t4 = new Thread(v4);

   // avvio dei thread
    t1.start();
    t2.start();
    t3.start();
    t4.start();

    // attendere il termine dell'esecuzione di ciascun thread
    try {
      t1.join();
      t2.join();
      t3.join();
      t4.join();
    } catch (InterruptedException ex) { // non ho capito a che serve "Joinable"
      System.out.println("Errore nel join: " + ex);
    }

    System.out.println("Inserisci il testo in chiaro da cifrare: ");
    String testoInChiaro = scanner.nextLine();
    scanner.close();

    String testoCifrato = m.cifra(testoInChiaro);

    System.out.println("Il testo cifrato è: " + testoCifrato);
    
  }
}
