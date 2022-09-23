/**
 * Die Klasse VigenereMaschine implementiert die Gemeinsamkeiten der Klassen Entschluessler
 * und Verschluessler, die von dieser abgeleitet werden.
 *
 * @author Fiedler, Paul, 3726896
 */
public class VigenereMaschine {
    private String inputFileName;
    private String schluesselwort;
    private FormatierterText inputText;
    private String outputText;
    private char[][] chiffrierMatrix;
    private boolean isEntschluesseler;

    /**
     * Constructs and initializes a VigenereMaschine with an input- and output as well a s a schluesselwort
     * Konstruktor der Klasse.
     *
     * @author Fiedler, Paul, 3726896
     * @param inputFileName Name der zu ent- oder verschlüsselten Datei.
     * @param schluesselwort Das für Ent-/Verschlüsslung notwendige Schlüsselwort.
     * @param isEntschluesseler Bestimmt, ob die VigenereMaschine Ent- oder Verschlüssler ist.
     */
    public VigenereMaschine(String inputFileName, String schluesselwort, boolean isEntschluesseler){
        this.inputFileName = inputFileName;
        this.schluesselwort = schluesselwort;
        this.isEntschluesseler = isEntschluesseler;
        this.inputText = new FormatierterText(FileHandler.readFromFile(inputFileName));
        this.chiffrierMatrix = new char[26][26]; // initialisiert ein zweidimensionales char-Array in der Größe des genutzten Alphabets
        // generiert Matrix
        int k = 0;
        for (int i = 0; i < chiffrierMatrix.length; i++) {
            for (int j = 0; j < chiffrierMatrix[i].length; j++) {
                chiffrierMatrix[i][j] = (char)(k++ % 26 + 97);
            }
            k++;
        }
    }

    /**
     * Getter für das Attribut inputText
     *
     * @author Fiedler, Paul, 3726896
     * @return inputText, in die Vigenere-Maschine eingegebener Text als Typ FormatierterText.
     */
    public FormatierterText getInputText() {
        return inputText;
    }

    /**
     * Getter für das Attribut outputText
     *
     * @author Fiedler, Paul, 3726896
     * @return outputText, in die Vigenere-Maschine eingegebener Text vom Typ String.
     */
    public String getOutputText() {
        return outputText;
    }

    /**
     * Gibt die eine Matrix und Erklärung zur Fuktionsweise der VigenereChiffre auf der Konsole aus.
     *
     * @author Fiedler, Paul, 3726896
     */
    public void printMatrix(){
        // prints instructions
        System.out.println("\n");
        System.out.println("### VIGENERE-CHIFFRE ###");
        System.out.println("\n");
        System.out.println("Das Chiffre findet sich, wo Zeile des Schlüsselbuchstaben und ");
        System.out.println("Spalte des zu verschlüsselnden Buchstabens in der Matrix zusammentreffen.");
        System.out.println("\n");
        System.out.println("Zum Dechiffrieren Suchen sie in der ersten Spalte den Schlüsselbuchstaben");
        System.out.println("suchen sie in dessen Spalte den entsprechenden Buchstaben im verschlüsselten Text");
        System.out.println("in der ersten Zeile über diesem finden sie den entsprechenden entschlüsselten Buchstaben.");
        System.out.println("\n");

        // prints Matrix
        for (int i = 0; i < chiffrierMatrix.length; i++) {
            for (int j = 0; j < chiffrierMatrix[i].length; j++) {

                if (chiffrierMatrix[i][j] - 10 < 0) {System.out.print(chiffrierMatrix[i][j] + " |");}
                else {System.out.print(chiffrierMatrix[i][j] + "|");}
            }
            System.out.println();
        }
    }

    /**
     * Gibt den Ausgangstext auf der Konsole aus.
     *
     * @author Fiedler, Paul, 3726896
     */
    public void printInput(){
        System.out.println();
        System.out.println("----------");
        System.out.println("Ausgangstext:");
        System.out.println();
        System.out.println(this.inputText.getText());
    }

    /**
     * Gibt das Attribut outputText in der Konsole aus.
     *
     * @author Fiedler, Paul, 3726896
     */
    public void printOutput(){
         System.out.println(this.outputText);
    }

    /**
     * Speichert das Ergebnis als Datei.
     *
     * @param outputFilename
     * @author Fiedler, Paul, 3726896
     */
    public void outputToFile(String outputFilename){
        FileHandler.writeFile(outputFilename, this.outputText.toString());
    }

    /**
     * Ver-/Enschluesselt den formatierten Text.
     *
     * @author Fiedler, Paul, 3726896
     */
    public void chiffrieren() {

        char[] inputText = this.inputText.getText().toCharArray();

        StringBuilder sb = new StringBuilder();

        int k = 0;
        for (int i = 0; i < inputText.length; i++) {
            if (inputText[i] < 97 || inputText[i] > 122) {
                sb = sb.append(inputText[i]);
            } else {
                if (k == schluesselwort.length()) {k = 0;}
                int x = (int)(schluesselwort.charAt(k)) - 97;
                if (isEntschluesseler){
                    char c =(char)(chiffrierMatrix[26 - x][inputText[i] - 97]); // Chiffre char ermitteln
                    sb.append(c);
                }else{
                    char c =(char)(chiffrierMatrix[x][inputText[i] - 97]); // Chiffre char ermitteln
                    sb.append(c);
                }
                k++;
            }
        }
        outputText = sb.toString();
    }
}
