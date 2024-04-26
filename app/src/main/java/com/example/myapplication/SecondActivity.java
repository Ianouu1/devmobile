package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    double C;
    double t;
    int n;
    TextView resultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        setContentView(R.layout.layout_tp16);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        resultat = findViewById(R.id.tp16_resultatDisplay);

    }
    public void onClickCloseActivity(View view) {
        finish();
    }
    public void onClickCalculMensualite(View view) {

        // Récupérer le service d'entrée & Cacher le clavier
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        // Calcul
        C = Double.parseDouble(((TextView) findViewById(R.id.tp16_C)).getText().toString());
        t = Double.parseDouble(((TextView) findViewById(R.id.tp16_t)).getText().toString());
        n = Integer.parseInt(((TextView) findViewById(R.id.tp16_n)).getText().toString())*12;

        double calcul =  (C * (t / 12)) / (1 - (1 + (t / 12) - n));

        String resultatTexte = String.format("%.2f", calcul);
        resultat.setText(resultatTexte);
    }
}