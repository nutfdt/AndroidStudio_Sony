package com.example.mysonysondage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Page1 extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rgEcologie;
    private Button btSuivant;
    private String email, idE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        this.rgEcologie = (RadioGroup) findViewById(R.id.rgEcologie);
        this.btSuivant = (Button) findViewById(R.id.idBtSuivant);
        this.btSuivant.setOnClickListener(this);
        this.email = this.getIntent().getStringExtra("email");
        this.idE = this.getIntent().getStringExtra("idE");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idBtSuivant) {
            int score = 0;
            switch (this.rgEcologie.getCheckedRadioButtonId()) {
                case R.id.idEcologie1:
                    score = 20;
                    break;
                case R.id.idEcologie2:
                    score = 16;
                    break;
                case R.id.idEcologie3:
                    score = 12;
                    break;
                case R.id.idEcologie4:
                    score = 8;
                    break;
                case R.id.idEcologie5:
                    score = 4;
                    break;
            }
            //ajouter la réponse du candidat dans l'enquete
            System.out.println("Canary3 + " + Sony.getEnquete(this.idE).getCandidat(this.email).hashCode());
            System.out.println("Canary2 + " + Sony.getEnquete(this.idE).hashCode());
            Sony.getEnquete(this.idE).ajouterReponse("Ecologie", score, this.email);
            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("email", this.email);
            unIntent.putExtra("idE", this.idE);
            this.startActivity(unIntent);
        }
    }
}