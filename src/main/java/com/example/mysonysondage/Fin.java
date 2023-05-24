package com.example.mysonysondage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Fin extends AppCompatActivity implements View.OnClickListener  {
    private Button btRefaire, btAllResult, btAccueil;
    private TextView txtResult;

    private String idE, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        this.btRefaire = (Button) findViewById(R.id.idBtRefaire);
        this.btAllResult = (Button) findViewById(R.id.idBtResult);
        this.btAccueil = (Button) findViewById(R.id.idBtFin);
        this.txtResult = (TextView) findViewById(R.id.idResultats);
        if (this.getIntent().getStringExtra("idE") != null){
            this.idE = this.getIntent().getStringExtra("idE");
            this.email = this.getIntent().getStringExtra("email");
        }
        this.btAccueil.setOnClickListener(this);
        this.btRefaire.setOnClickListener(this);
        this.btAllResult.setOnClickListener(this);

        float moyenne = Sony.getEnquete(this.idE).moyenne(this.email);
        this.txtResult.setText(moyenne+"/20");

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.idBtFin) {
            Intent unIntent = new Intent(this, MainActivity.class);
            this.startActivity(unIntent);
        } else if (view.getId() == R.id.idBtRefaire){
            Intent unIntent = new Intent(this, Page1.class);
            unIntent.putExtra("email", this.email);
            unIntent.putExtra("idE", this.idE);
            this.startActivity(unIntent);
            Sony.getEnquete(this.idE).supprimerReponse(this.email);
        } else if (view.getId() == R.id.idBtResult){
            Intent unIntent = new Intent(this, Resultatall.class);
            unIntent.putExtra("email", this.email);
            unIntent.putExtra("idE", this.idE);
            this.startActivity(unIntent);
        }
    }
}