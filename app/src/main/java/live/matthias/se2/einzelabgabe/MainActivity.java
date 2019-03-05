package live.matthias.se2.einzelabgabe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }
}