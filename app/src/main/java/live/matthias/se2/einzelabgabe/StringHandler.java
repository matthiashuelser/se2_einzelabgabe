package live.matthias.se2.einzelabgabe;

import java.util.Arrays;

public class StringHandler {
    public String handleString(String s) {
        String ungerade = "";
        String gerade = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 == 0) {
                gerade = gerade + s.charAt(i);
            } else {
                ungerade = ungerade + s.charAt(i);
            }
        }
        char[] ungeradearr = ungerade.toCharArray();
        char[] geradearr = gerade.toCharArray();
        Arrays.sort(ungeradearr);
        Arrays.sort(geradearr);
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
