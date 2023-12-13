import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Inserisci il testo in chiaro da cifrare: ");
    String testoInChiaro = scanner.nextLine();

    
    
    Matrice m = new Matrice("TPSIT");
    Vigenere v = new Vigenere(0, 12, 0, 12, m);
    Thread t = new Thread(v);
    
  }
}
