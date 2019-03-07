package live.matthias.se2.einzelabgabe;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class CatFacts extends Thread {
    String catFact;
    public void run() {
        try {
            JSONObject json = readJsonFromUrl("https://catfact.ninja/fact?max_length=140");
            catFact = "Random Fact about cats:\n" + json.get("fact").toString();
        } catch (Exception e) {
            catFact = "Error getting random Fact about cats. Sorry.";
        }
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public String getCatFact() {
        return catFact;
    }
}
