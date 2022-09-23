/**
 * Main Klasse
 *
 * Die Klasse Main beinhaltet die main()=Methode, die der Startpunkt des Programms ist.
 * Durch Instanziierung von Objekten der anderen Klassen und Aufruf deren Methoden stellt
 * implementiert sie die Logik des "Vignere-Chiffre" Programms.
 *
 * @aurthor Fiedler, Paul, 3726896
 */

public class Main{
    public static void main(String[] args) {

        String inputFilename = "gedicht.txt"; // der Name des Inputtexts wird als String der Variable inputFilename zugewiesen.
        String outputFilename = "out.txt";    // der Name des Outputtexts wird als string der Variable outputFilename zugewiesen.
        String schluesselwort = "scheune";    // der String des scheune wird der Variable schluesselwort zugewiesen.

        VigenereMaschine verschl = new Verschluesseler(inputFilename, schluesselwort);
        verschl.printMatrix();

        verschl.printInput();
        verschl.chiffrieren();
        verschl.printOutput();

        verschl.outputToFile(outputFilename);


        VigenereMaschine entschl = new Entschluesseler(outputFilename, schluesselwort);

        entschl.printInput();
        entschl.chiffrieren();
        entschl.printOutput();

        entschl.outputToFile("out2.txt");
    }

}
















        // EINGABE - Eingabeauswahl Chiffrierung oder Dechiffrierung
        //         - Schlüsselwort
        //         - Dateinamen für Klartext und Geheimtext
        //          Programmaufruf mit: java main --decrypt "input.txt" "output.txt" "Schlüsselwort"
        //                        oder: java main --encrypt "input.txt" "output.txt" "Schlüsselwort"
