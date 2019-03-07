package live.matthias.se2.einzelabgabe;

import java.util.Arrays;

/**
 * Matrikelnummer sortieren wobei zuerst
 * alle geraden dann alle ungeraden Ziffern
 * gereiht sind
 */

public class StringHandler {
    public String handleString(String s) {

        //Splitte zunächst den Eingabestring in zwei Strings für ungerade und gerade Ziffern
        String ungerade = "";
        String gerade = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 == 0) {
                gerade = gerade + s.charAt(i);
            } else {
                ungerade = ungerade + s.charAt(i);
            }
        }

        //Konvertiere die Strings zu char-Arrays um sie anschließend zu sortieren
        char[] ungeradearr = ungerade.toCharArray();
        char[] geradearr = gerade.toCharArray();
        Arrays.sort(ungeradearr);
        Arrays.sort(geradearr);

        //Führe die beiden sortieren char-Arrays nacheinander zusammen zu einem Output-String
        String output = "";
        for (int i = 0; i < geradearr.length; i++) {
            output = output + geradearr[i];
        }
        for (int i = 0; i < ungeradearr.length; i++) {
            output = output + ungeradearr[i];
        }
        return output;
    }
}
