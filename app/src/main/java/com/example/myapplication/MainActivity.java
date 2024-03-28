package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button bouton;
    TextView textView;

    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // permet de mettre le bandeau en transparent
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        bouton = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> textView.setText(R.string.cat));

        Log.i("OnCreate()","onCreate");
        textView.setText("OnCreate()  \n");
        bouton.setOnClickListener(v -> textView.setText(R.string.toto));
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