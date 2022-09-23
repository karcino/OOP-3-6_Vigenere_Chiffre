/**
 * Verschlüsseler Klasse, Unterklasse von VigenereMaschine.
 *
 * Ruft mit dem Parameter false im Konstruktor, ein Objekt VigenereMaschine, dass verschlüsselt auf.
 *
 * @author Wahrenburg, David
 */
public class Verschluesseler extends VigenereMaschine{
    /**
     * Konstruktor der Klasse Verschlüssler
     *
     * @author Wahrenburg, David
     * @param inputFileName Name der Eingabe Datei
     * @param schluesselwort Schlüsselwort für ent- bzw. Verschlüsslung
     */
    public Verschluesseler(String inputFileName, String schluesselwort) {
        super(inputFileName, schluesselwort, false);
    }

    /**
     * Gibt den verschlüsselten text in der Konsole aus.
     *
     * @author Wahrenburg, David
     */
    @Override
    public void printOutput(){
        System.out.println("----------");
        System.out.println("Der Verschlüsselte Text lautet:");
        System.out.println();
        System.out.println(super.getOutputText());
    }
}
