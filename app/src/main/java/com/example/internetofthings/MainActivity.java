package com.example.internetofthings;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    private TextView textViewWashingNumber;
    private TextView textViewVacuumState;
    private EditText editText;
    private Button btnSubmit;
    private Button btnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewWashingNumber = findViewById(R.id.textViewWashingNumber);
        textViewVacuumState = findViewById(R.id.textViewVacuumState);
        editText = findViewById(R.id.editTextWashingNumber);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSwitch = findViewById(R.id.btnSwitch);

        btnSubmit.setOnClickListener(this::submit);
        btnSwitch.setOnClickListener(this::switch_);
        btnSwitch.setText("WŁĄCZ");
    }

    private void submit(View view) {
        String input = editText.getText().toString();

        if (input == null) {
            Toast.makeText(this, "Musisz wpisać numer od 1 do 12", Toast.LENGTH_SHORT).show();
        } else {
            try {
                int n = Integer.parseInt(input);

                if (n >= 1 && n <= 12) {
                    textViewWashingNumber.setText("Numer prania: " + input);
                    Toast.makeText(this, "Numer prania został zapisany", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Musisz wpisać numer od 1 do 12", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Musisz wpisać numer od 1 do 12. Tylko liczba całkowita!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void switch_(View view) {
        if (btnSwitch.getText().toString() == "WŁĄCZ") {
            btnSwitch.setText("WYŁĄCZ");
            textViewVacuumState.setText("Odkurzacz włączony");
        } else {
            btnSwitch.setText("WŁĄCZ");
            textViewVacuumState.setText("Odkurzacz wyłączony");
        }
    }
}