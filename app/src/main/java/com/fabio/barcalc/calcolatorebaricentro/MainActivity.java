package com.fabio.barcalc.calcolatorebaricentro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button calcola, aggiungi;
    EditText xbar, ybar, potenza, xcord, ycord;
    //TextView dom2, ultimo;
    ArrayList<Float> x,y,p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcola = findViewById(R.id.calcola);
        aggiungi = findViewById(R.id.aggiungi);
        xbar =  findViewById(R.id.xbar);
        ybar =  findViewById(R.id.ybar);
        potenza =  findViewById(R.id.potenza);
        xcord =  findViewById(R.id.xcord);
        ycord =  findViewById(R.id.ycord);


        x = new ArrayList<>();
        y = new ArrayList<>();
        p = new ArrayList<>();


        calcola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int l = p.size();
                if ( l>0 ) {

                    float somPot = 0;
                    float risx = 0;
                    float risy = 0;

                    for (int i = 0; i < l; i++) {
                        somPot += p.get(i);
                        risx += x.get(i) * p.get(i);
                        risy += y.get(i) * p.get(i);

                    }

                    risx /= somPot;
                    risy /= somPot;

                    xcord.setText(String.valueOf(risx));
                    ycord.setText(String.valueOf(risy));

                    x = new ArrayList<>();
                    y = new ArrayList<>();
                    p = new ArrayList<>();
                }
                else {
                    xcord.setText("Err");
                    ycord.setText("Err");
                }

            }
        });

        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x.add(Float.parseFloat(xbar.getText().toString()));
                y.add(Float.parseFloat(ybar.getText().toString()));
                p.add(Float.parseFloat(potenza.getText().toString()));

                xbar.setText("");
                ybar.setText("");
                potenza.setText("");
                xcord.setText("");
                ycord.setText("");


            }
        });


    }
}
