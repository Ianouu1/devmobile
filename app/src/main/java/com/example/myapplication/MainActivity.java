package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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
        EdgeToEdge.enable(this); // permet de mettre le bandeau en transparent
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
        boutonswaplayout.setOnClickListener(v -> R.layout.layout_un)

        //log create
        Log.i("OnCreate()","onCreate");
        textView.setText("OnCreate()  \n");

        // Le petit toast
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, R.string.hello_cat, duration);
        bouton.setOnClickListener(v -> toast.show());


    }

    public void ActionButton(View view) {
        if (view.getId() == R.id.swaplayoutbutton) {
            // Échanger entre layout 1 et layout 2
            if (boutonswaplayout.getText().equals("Layout 1")) {
                setContentView(R.layout.layout_un);
                boutonswaplayout.findViewById(R.id.bouton_un);
            } else {
                setContentView(R.layout.layout_deux);
                boutonswaplayout.findViewById(R.id.bouton_deux);
            }
        } else if (view.getId() == R.id.bouton_un) {
            // Échanger vers layout 2
            setContentView(R.layout.layout_deux);
            boutonswaplayout.setText("Layout 1");
        } else if (view.getId() == R.id.bouton_deux) {
            // Échanger vers layout 1
            setContentView(R.layout.layout_un);
            boutonswaplayout.setText("Layout 2");
        }



        setContentView(R.layout.layout_un);

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