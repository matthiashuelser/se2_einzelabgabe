package live.matthias.se2.einzelabgabe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;

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
                String outputText;
                NetworkThread t = new NetworkThread();
                ProgressBar progressBar = findViewById(R.id.progressBar);

                t.setInput(s);
                t.start();
                progressBar.setVisibility(View.VISIBLE);
                try {
                    t.join(10000);
                    outputText = "Ausgabe: " + t.getOutput();
                } catch (InterruptedException e) {
                    outputText = "Fehler!";
                }
                progressBar.setVisibility(View.INVISIBLE);
                output.setText(outputText);
            }
        });
    }



}