package com.example.myapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button bouton;
    TextView textView;

    ImageButton imageButton;
    Button boutonswaplayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Permet de desactiver le night mode de l'application, car sinon y'avais du texte en blanc sur du jaune qui ne pouvais pas être modifié :
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        //EdgeToEdge.enable(this); // permet de mettre le bandeau en transparent
        setContentView(R.layout.activity_main);
        /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        bouton = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        imageButton = findViewById(R.id.imageButton);
        boutonswaplayout = findViewById(R.id.swaplayoutbutton);
        imageButton.setOnClickListener(v -> textView.setText(imageButton.getContentDescription()));

        //log create
        Log.i("OnCreate()","onCreate");
        textView.setText("OnCreate()  \n");

        // Le petit toast
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, R.string.hello_cat, duration);
        bouton.setOnClickListener(v -> toast.show());
    }

    public void ActionButton(View view) {
        if (view.getId() == R.id.swaplayoutbutton || view.getId() == R.id.bouton_deux) {
            setContentView(R.layout.layout_un);
            loadDataLayout1();
        } else if (view.getId() == R.id.bouton_un) {
            setContentView(R.layout.layout_deux);
        }
    }
    public void loadDataLayout1() {
        String[] data = new String[]{"Réseaux", "Mathématiques", "Probabilités Statistiques", "Gestion de Projet", "Programmation objet", "Anglais", "Droit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        ListView listView = findViewById(android.R.id.list);
        if (listView != null) {
            listView.setAdapter(adapter);
        } else {
            Log.e("MainActivity", "ListView is null");
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart()","onstart()");
        textView.append("onStart() \n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume()","onresume()");
        textView.append("onResume() \n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause()", "onPause()");
        textView.append("onPause() \n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart()", "onRestart()");
        textView.append("onRestart() \n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop()", "onStop()");
        textView.append("onStop() \n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy()", "onDestroy()");
        textView.append("onDestroy() \n");
    }
}