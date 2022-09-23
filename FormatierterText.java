/**
 *  Speichert einen String im Standartisiertem Format zur Weiternutzung im Verschlüsselungsprogramm.
 */
public class FormatierterText {
    private String text;

    /**
     * Im Konstruktor nimmt der Text die Formatierung an
     *
     * @author Wahrenburg, David
     * @param text Input String
     */
    FormatierterText(String text){
        text = text.toLowerCase();
        // text = leerzeichenHinzufuegen(text);
        this.text = text;
        umlauteEntfernen();

    }

    /**
     * entfernt Umlaute (ä,ö,ü,ß) aus String
     *
     * @author Wahrenburg, David
     */
    public void umlauteEntfernen(){
        text = text.replace("ä","ae");
        text = text.replace("ö","oe");
        text = text.replace("ü","ue");
        text = text.replace("ß","ss");
    }

    /**
     * Fügt alle 5 Zeichen ein Leerzeichen ein
     *
     * @author Wahrenburg, David
     * @param str Input String
     * @return gibt einen String mit Leerzeichen zurück
     */
    public String leerzeichenHinzufuegen(String str){
        StringBuilder strB = new StringBuilder();
        for(int i=0; i< str.length();i++){
            strB.append(str.charAt(i));
            if(i % 5 == 4){
                strB.append(" ");
            }
        }
        return strB.toString();
    }

    /**
     * Gibt den text im Standartformat auf der Konsole aus
     *
     * @author Wahrenburg, David
     */
    public void printFormatiertertext(){
        System.out.println(this.text);
    }

    /**
     * Getter für das text Attribut
     *
     * @author Wahrenburg, David
     * @return Formatierten Text als String
     */
    public String getText(){
        return this.text;
    }
}
