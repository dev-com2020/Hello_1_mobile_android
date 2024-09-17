package com.example.hello_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TrzeciaAktywnosc extends AppCompatActivity {

    private int polubienia = 0;
    private TextView textView3;
    private Button buttonLike;
    private Button buttonUnlike;
    private Button buttonSave;

    private static final String LIKES_COUNT_KEY = "polubień";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trzecia_aktywnosc);

//        inicjalizacja widoków
        textView3 = findViewById(R.id.textView3);
        buttonLike = findViewById(R.id.button6);
        buttonUnlike = findViewById(R.id.button5);
        buttonSave = findViewById(R.id.button4);

        buttonLike.setOnClickListener(v -> {
            polubienia++;
            textView3.setText(polubienia + " polubień");
        });

        buttonUnlike.setOnClickListener(v -> {
            if (polubienia > 0) {
                polubienia--;
                textView3.setText(polubienia + " polubień");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}