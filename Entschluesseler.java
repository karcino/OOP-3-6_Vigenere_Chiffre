/**
 * Entschluesseler Klasse, Unterklasse von Vigenere Maschine
 *
 * Ruft VigenerMaschine auf und übergibt Boolean für Entschlüsselung.
 *
 * @author Wahrenburg, David
 */
public class Entschluesseler extends VigenereMaschine {
    /**
     * Konstruktor der Klasse Entschlüssler
     *
     * @author Wahrenburg, David
     * @param inputFileName
     * @param schluesselwort
     */
    public Entschluesseler(String inputFileName, String schluesselwort) {
        super(inputFileName, schluesselwort, true);
    }

    /**
     * Gibt den Entschlüsselten Text in der Konsole aus.
     *
     * @author Wahrenburg, David
     */
   @Override
    public void printOutput(){
       System.out.println("----------");
        System.out.println("Der Entschlüsselte Text lautet:");
       System.out.println();
        System.out.println(super.getOutputText());  // verwendet die Methode getOutputText() aus der Oberklasse
    }

}
