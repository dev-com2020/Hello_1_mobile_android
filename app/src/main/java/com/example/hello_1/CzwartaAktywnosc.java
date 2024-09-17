package com.example.hello_1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CzwartaAktywnosc extends AppCompatActivity {

    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private TextView textView6;
    private TextView textView7;
    private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_czwarta_aktywnosc);

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        button8 = findViewById(R.id.button8);

        loadLogoFragment();
        
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInputs();
            }

            private void validateInputs() {
                String email = editTextTextEmailAddress.getText().toString();
                String password = editTextTextPassword.getText().toString();
                boolean isValid = true;

                textView6.setVisibility(View.GONE);
                textView7.setVisibility(View.GONE);

                if (TextUtils.isEmpty(email) || !email.contains("@")){
                    textView6.setText("Podaj poprawny email");
                    textView6.setVisibility(View.VISIBLE);
                    isValid = false;

                }

                if (TextUtils.isEmpty(password) || password.length() < 4) {
                    textView7.setText("Hasło musi być dłuższe niż 4 znaki");
                    textView7.setVisibility(View.VISIBLE);
                    isValid = false;

                }

                if (isValid) {
                    Toast.makeText(CzwartaAktywnosc.this, "Zalogowano poprawnie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CzwartaAktywnosc.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadLogoFragment() {
        LogoFragment logoFragment = new LogoFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, logoFragment)
                .commit();
    }
}