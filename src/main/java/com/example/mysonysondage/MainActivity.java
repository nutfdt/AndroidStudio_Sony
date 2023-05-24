package com.example.mysonysondage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button  btInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btInscription = (Button) findViewById(R.id.idInscription);

        this.btInscription.setOnClickListener(this);
        Sony.initialiser();
    }

    @Override
    public void onClick(View v) {
        String idE = "Enquete12";
        Intent unIntent = new Intent(this, Inscription.class);
        unIntent.putExtra("idE", idE);
        this.startActivity(unIntent);
    }
}
