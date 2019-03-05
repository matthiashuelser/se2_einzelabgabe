package live.matthias.se2.einzelabgabe;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sortBtn = findViewById(R.id.sortBtn);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.inputtext);
                TextView output = findViewById(R.id.output);
                String s = input.getText().toString();
                StringHandler stringHandler = new StringHandler();
                output.setText("Ausgabe: " + stringHandler.handleString(s));
            }
        });
        Button networkBtn = findViewById(R.id.networkBtn);
        networkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.inputtext);
                TextView output = findViewById(R.id.output);
                String s = input.getText().toString();
                NetworkHandler networkHandler = new NetworkHandler();
                try {
                    output.setText("Ausgabe: " + networkHandler.handleNetwork(s));
                } catch (IOException e) {
                    output.setText("Fehler!");
                    e.printStackTrace();
                }
            }
        });
    }



}